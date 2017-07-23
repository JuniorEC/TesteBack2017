package br.com.jdjava.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.jdjava.ModelCliente.ClienteDados;

public class ClienteDAO {
	
	private Connection connection;
	
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
	
	public List<ClienteDados> getListaClientes(double valor) throws SQLException {
		
		try {
			
			String sql = "";
			List<ClienteDados> clienteDado = new ArrayList<ClienteDados>();
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
	         rs.close();
	         stmt.close();
	         return clienteDado;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			this.connection.close();
		}
	}
	
}
