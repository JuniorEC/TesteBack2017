package br.com.jdjava.Controller;

import java.sql.SQLException;

import br.com.jdjava.ModelCliente.ClienteBot;

public class BuscaCliente {
	
	public static void main(String[] args) throws SQLException {
		ClienteBot clienteBot = new ClienteBot();
		int qtdBot = 3000;
		
		clienteBot.GerarClienteBot(qtdBot);
		
		//double valor = 560;
		
		
		//clienteBot.BuscaClienteBot(valor);
		
	}

}
