package br.com.jdjava.JDBC;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import br.com.jdjava.FileUtil.ExportarExcel;
import br.com.jdjava.ModelCliente.ClienteDados;

public class ClienteDAO {
	
	private Connection connection;
	
	
	public ClienteDAO() {
		
		this.connection = new Conexaodb().getConnection();
		
	}
	
	public void InsereClienteBot(ClienteDados clienteDados) throws SQLException {
		
		try {
			
			String sql = "insert into tb_customer_account" +
	                " (id_customer,cpf_cnpj,nm_customer,is_active,vl_total)" +
	                " values (?,?,?,?,?)";
	        PreparedStatement stmt = this.connection.prepareStatement(sql);

	       
	        stmt.setInt(1, clienteDados.getIdCliente());
	        stmt.setString(2, clienteDados.getCpfCliente());
	        stmt.setString(3, clienteDados.getNomeCliente());
	        stmt.setBoolean(4, clienteDados.getAtivoCliente());
	        stmt.setDouble(5, clienteDados.getVlTotalCliente());
	        stmt.execute();
	        stmt.close();
		} catch (Exception e) {
			System.out.println(e);
			throw new RuntimeException(e);
		} finally {
			this.connection.close();
		}
	}
	
	public List<ClienteDados> getListaClientes(double valor, int idInicial, int idFinal) throws SQLException {
	//public void getListaClientes(double valor, int idInicial, int idFinal) throws SQLException {	
		try {
			
			List<ClienteDados> clienteDado = new ArrayList<ClienteDados>();
			String sql = "SELECT * FROM `tb_customer_account`";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
	             
				// criando o objeto Contato
				
	             ClienteDados clienteDados = new ClienteDados();
	             clienteDados.setIdCliente(rs.getInt("id_customer"));
	             clienteDados.setCpfCliente(rs.getString("cpf_cnpj"));
	             clienteDados.setNomeCliente(rs.getString("nm_customer"));
	             clienteDados.setAtivoCliente(rs.getBoolean("is_active"));
	             clienteDados.setVlTotalCliente(rs.getDouble("vl_total"));
	             
	             // adicionando o objeto à lista
	             if ((idInicial<=clienteDados.getIdCliente()) && (clienteDados.getIdCliente()<=idFinal) && clienteDados.getVlTotalCliente()>=valor) {
	             
	            	 clienteDado.add(clienteDados);
	            	 System.out.println("=======================CLIENTE REGISTRADO================================");
	             }
	        }
			Collections.sort(clienteDado);
			
			Object[] options = { "Sim", "Não" };
			int n = JOptionPane.showOptionDialog(null,
							"Deseja importar este arquivo para .xls? ",
							"OPA!", JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			
				for(int i = 0; i < clienteDado.size(); i++) {
					
					if (n ==0) {
						FileWriter arquivo;
						arquivo = new FileWriter(new File("C:\\Users\\Junior\\TesteBack2017\\JDJavaback-2017\\Arquivo.txt"));  
						arquivo.write(clienteDado.get(i).toString()); 
					
						System.out.println(clienteDado.get(i));
						arquivo.close();
					}
					if(n ==1) {
						System.out.println(clienteDado.get(i));
					}
				
			}
	         rs.close();
	         stmt.close();
	         return clienteDado;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			this.connection.close();
		}
	}
	
	public int BuscaUltimoId(int qtdBot) throws SQLException {
		
		try {
			
			String sql = "Select Max(id_customer) FROM `tb_customer_account`";
			PreparedStatement stmt;
			stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			int UId = 0;
			
			while (rs.next()){
				
			UId = (rs.getInt("MAX(id_customer)"));
            
			}
            rs.close();
	        stmt.close();
	         
            return UId;
            
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		} finally {
			this.connection.close();
		}
		
	}
	
	public double MediaVlTotal(double valor, int idInicial, int idFinal) throws SQLException {
		
		try {
			
			double	somaValorTotal	= 0;
			double	media			= 0;
			List<ClienteDados> clienteDado = new ArrayList<ClienteDados>();
			String sql = "SELECT * FROM `tb_customer_account`";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
	             
				// criando o objeto Contato
				
	             ClienteDados clienteDados = new ClienteDados();
	             clienteDados.setIdCliente(rs.getInt("id_customer"));
	             clienteDados.setCpfCliente(rs.getString("cpf_cnpj"));
	             clienteDados.setNomeCliente(rs.getString("nm_customer"));
	             clienteDados.setAtivoCliente(rs.getBoolean("is_active"));
	             clienteDados.setVlTotalCliente(rs.getDouble("vl_total"));
	             
	             // adicionando o objeto à lista
	             
	             if ((idInicial<=clienteDados.getIdCliente()) && (clienteDados.getIdCliente()<=idFinal) && clienteDados.getVlTotalCliente()>=valor) {
	             
	            	 clienteDado.add(clienteDados);
	            	 somaValorTotal	= somaValorTotal + clienteDados.getVlTotalCliente();
	          //  	 System.out.println("=======================CLIENTE REGISTRADO================================");
	             }
			}
			
			media = somaValorTotal/clienteDado.size();
			rs.close();
	         stmt.close();
	         return media;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			this.connection.close();
		}
		
	}
	
	public void ExcelSql() throws SQLException {
		try {
			
			FileOutputStream out = new FileOutputStream("export.xls");
			Workbook wb = new HSSFWorkbook();
			Sheet s = wb.createSheet();
			Row r = null;
			Cell c = null;
			int i = 0;
			r = s.createRow(i);
			c = r.createCell(0);
			c.setCellValue("id_customer");
	   		c = r.createCell(1);
	   		c.setCellValue("cpf_cnpj");
	   		c = r.createCell(2);
	   		c.setCellValue("nm_customer");
	   		c = r.createCell(3);
	   		c.setCellValue("is_active");
	   		c = r.createCell(4);
	   		c.setCellValue("vl_total");
		
			String sql = "SELECT * FROM `tb_customer_account`";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
		
			while (rs.next()) {
             
			// criando o objeto Contato
			
	             ClienteDados clienteDados = new ClienteDados();
	             ExportarExcel exportarExcel = new ExportarExcel();
	             clienteDados.setIdCliente(rs.getInt("id_customer"));
	             clienteDados.setCpfCliente(rs.getString("cpf_cnpj"));
	             clienteDados.setNomeCliente(rs.getString("nm_customer"));
	             clienteDados.setAtivoCliente(rs.getBoolean("is_active"));
	             clienteDados.setVlTotalCliente(rs.getDouble("vl_total"));
	             i++;
	             r = s.createRow(i);
	             
	            	 
	            	 //Criando a primeira linha na LINHA zero, que seria o número 1
	            	 
	            	 for(int j = 0; j < 1 ; j++) {
	            	 
	            		 c = r.createCell(0);
	            		 c.setCellValue(clienteDados.getIdCliente());
	            		 
	            		 c = r.createCell(1);
	            		 c.setCellValue(clienteDados.getCpfCliente());
	            		 
	            		 c = r.createCell(2);
	            		 c.setCellValue(clienteDados.getNomeCliente());
	            		 
	            		 c = r.createCell(3);
	            		 c.setCellValue(clienteDados.getAtivoCliente());
	            		 
	            		 c = r.createCell(4);
	            		 c.setCellValue(clienteDados.getVlTotalCliente());

	             	}
	             
			}
		

			wb.write(out);
			out.close();
			rs.close();
			stmt.close();
		
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			this.connection.close();
		}
	}
}
	

