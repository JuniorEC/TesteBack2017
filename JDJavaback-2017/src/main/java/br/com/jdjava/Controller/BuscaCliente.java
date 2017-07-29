package br.com.jdjava.Controller;

import java.util.List;

import br.com.jdjava.ModelCliente.ClienteDados;

public class BuscaCliente {

	public ClienteDados BuscarCliente(List<ClienteDados> clienteDado) {
		
		ClienteDados cliente = null;
		
		cliente = clienteDado.get(1);
		
		return cliente;
	}

}
