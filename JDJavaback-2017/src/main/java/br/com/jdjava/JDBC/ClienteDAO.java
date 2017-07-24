package br.com.jdjava.JDBC;

import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.jdjava.ModelCliente.ClienteDados;

public class ClienteDAO {
	
	private Connection connection;
	@SuppressWarnings("unused")
	private int Uid;
	
	public ClienteDAO() {
		
		this.connection = new Conexaodb().getConnection();
		
	}
	
	public void InsereClienteBot(ClienteDados clienteDados) throws SQLException {
		
		try {
			
			String sql = "insert into tb_customer_account" +
	                " (id_customer,cpf_cnp,nm_customer,is_active,vl_total)" +
	                " values (?,?,?,?,?)";
	        PreparedStatement stmt = this.connection.prepareStatement(sql);

	       
	        stmt.setInt(1, clienteDados.getIdCliente());
	        stmt.setString(2, clienteDados.getCpfCliente());
	        stmt.setString(3, clienteDados.getNomeCliente());
	        stmt.setBoolean(3, clienteDados.getAtivoCliente());
	        stmt.setDouble(3, clienteDados.getVlTotalCliente());
	        stmt.execute();
	        stmt.close();
		} catch (Exception e) {
			System.out.println(e);
			throw new RuntimeException(e);
		} finally {
			this.connection.close();
		}
	}
	
	//public List<ClienteDados> getListaClientes(double valor) throws SQLException {
	public void getListaClientes(double valor) throws SQLException {	
		try {
			
			List<ClienteDados> clienteDado = new ArrayList<ClienteDados>();
			String sql = "SELECT * FROM `tb_customer_account`";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
	             
				// criando o objeto Contato
				
	             ClienteDados clienteDados = new ClienteDados();
	             clienteDados.setIdCliente(rs.getInt("id_customer"));
	             clienteDados.setCpfCliente(rs.getString("cpf_cnp"));
	             clienteDados.setNomeCliente(rs.getString("nm_customer"));
	             clienteDados.setAtivoCliente(rs.getBoolean("is_active"));
	             clienteDados.setVlTotalCliente(rs.getDouble("vl_total"));
	             
	             // adicionando o objeto à lista
	             if ((1500<=clienteDados.getIdCliente()) && (clienteDados.getIdCliente()<=2700) && clienteDados.getVlTotalCliente()>=valor) {
	             
	            	 clienteDado.add(clienteDados);
	            	 System.out.println("=======================CLIENTE REGISTRADO================================");
	             }
	         }
			Collections.sort(clienteDado);
			
			Object[] options = { "Sim", "Não" };
			int n = JOptionPane.showOptionDialog(null,
							"Deseja importar este arquivo para .txt? ",
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
	         //return clienteDado;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			this.connection.close();
		}
	}
	
	public int BuscaUltimoId() throws SQLException {
		
		try {
			
			String sql = "Select Max(id_customer) FROM `tb_customer_account`";
			PreparedStatement stmt;
			stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			
            int UId = 0;
            this.Uid = (rs.getInt("MAX(id_customer)"));
            
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
	
}
