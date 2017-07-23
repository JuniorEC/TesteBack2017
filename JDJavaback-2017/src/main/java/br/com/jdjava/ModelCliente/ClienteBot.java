package br.com.jdjava.ModelCliente;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.jdjava.JDBC.ClienteDAO;

public class ClienteBot {
	
	public String GerarClienteBot(int qtdBot) throws SQLException {
		
		int 	index;
		String 	nomes [] ={"Miguel","Sophia","Davi","Alice","Arthur","Julia","Pedro","Isabella","Gabriel","Manuela","Bernardo","Laura",
							"Lucas","Luiza","Matheus","Valentina","Rafael","Giovanna","Heitor","Maria","Eduarda","Enzo","Helena","Guilherme","Beatriz",
							"Nicolas","Maria","Luiza","Lorenzo","Lara","Gustavo","Mariana","Felipe","Nicole","Samuel","Rafaela","João","Pedro","Heloísa",
							"Daniel","Isadora","Vitor","Lívia","Leonardo","MariaClara","Henrique","AnaClara","Theo","Lorena","Murilo","Gabriela","Eduardo",
							"Yasmin","PedroHenrique","Isabelly","Pietro","Sarah","Cauã","AnaJulia","Isaac","Letícia","Caio","AnaLuiza","Vinicius","Melissa",
							"Benjamin","Marina","João","Clara","Lucca","Cecília","JoãoMiguel","Esther","Bryan","Emanuelly","Joaquim","Rebeca","JoãoVitor",
							"AnaBeatriz","Thiago","Lavínia","Antônio","Vitória","DaviLucas","Bianca","Francisco","Catarina","EnzoGabriel","Larissa","Bruno",
							"MariaFernanda","Emanuel","Fernanda","JoãoGabriel","Amanda","Ian","Alícia","DaviLuiz","Carolina","Rodrigo","Agatha","Otávio",
							"Gabrielly"};
		String 	sobrenomes [] = {"Alves","Monteiro","Novaes","Mendes","Barros","Freitas","Barbosa","Pinto","Moura","Cavalcanti","Dias","Castro",
								"Campos","Cardoso","Silva","Souza","Costa","Santos","Oliveira","Pereira","Rodrigues","Almeida","Nascimento","Lima","Araújo",
								"Fernandes","Carvalho","Gomes","Martins","Rocha","Ribeiro","Rezende","Sales","Peixoto","Fogaça","Porto","Ribeiro","Duarte","Moraes",
								"Ramos","Pereira","Ferreira","Silveira","Moreira","Teixeira","Caldeira","Vieira","Nogueira","da Costa","da Rocha","da Cruz","da Cunha",
								"da Mata","da Rosa","da Mota","da Paz","da Luz","da Conceição","das Neves","Fernandes","Gonçalves","Rodrigues","Martins","Lopes",
								"Gomes","Mendes","Nunes","Carvalho","Melo","Cardoso,","Pires","Jesus","Aragão","Viana","Farias"};
		String 	numeros = "0123456789";
		String 	nomeCompleto = "";
		String 	cpf= "";
		Boolean ativo = true;
		Double valor = 0.0;
		Random random = new Random();
		
		for(int i = 1; i<=qtdBot; i++) {
			
			ClienteDados clienteDados = new ClienteDados();
			
			for (int j = 0; j<12; j++) {
				
				index = random.nextInt( numeros.length() );
				cpf += numeros.substring( index, index + 1 );
				
			}
			
			for(int k = 1; k < 2; k++) {
				
			nomeCompleto += nomes[random.nextInt( nomes.length )];
			nomeCompleto += sobrenomes[random.nextInt( sobrenomes.length )];
			//nomeCompleto += nomes.substring( index, index + 1 );
			
			}
			
			valor = (7.98*i)/0.5*25;
			clienteDados.setIdCliente(i);
			clienteDados.setCpfCliente(cpf);
			clienteDados.setNomeCliente(nomeCompleto);
			clienteDados.setAtivoCliente(ativo);
			clienteDados.setVlTotalCliente(valor);
			
			ClienteDAO clienteDao = new ClienteDAO();
			clienteDao.InsereClienteBot(clienteDados);
			
			System.out.println( clienteDados.toString() );
		}
		
		return ClienteDados.class.toString();
		
	}
	
	public List<ClienteDados> BuscaClienteBot(double valor) {
		List<ClienteDados> clienteDado = new ArrayList<ClienteDados>();
		ClienteDAO clienteDAO = new ClienteDAO();
		try {
			clienteDAO.getListaClientes(valor);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clienteDado;
	}
	

}
