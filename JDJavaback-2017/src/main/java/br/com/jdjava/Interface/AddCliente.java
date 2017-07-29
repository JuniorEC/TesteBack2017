package br.com.jdjava.Interface;

import org.kordamp.bootstrapfx.scene.layout.Panel;

import br.com.jdjava.ModelCliente.ClienteBot;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class AddCliente extends Application {
	
	 public static void main(String[] args) {
		  launch();
		 }

		 @Override
		 public void start(final Stage palco) throws Exception {
			 Panel panel = new Panel("Adicione um Cliente.");
		     panel.getStyleClass().add("panel-primary");           
		     AnchorPane content = new AnchorPane();
		     content.setPadding(new Insets(200));
		     
		     Label lblNmCliente = new Label();
		     lblNmCliente.setText("Nome Completo: ");
		     
		     Label lblCpf = new Label();
		     lblCpf.setText("CPF(Sem pontuação): ");
		     
		     Label lblVl = new Label();
		     lblVl.setText("Valor inicial para conta: ");
		     
		     final Label lblStatus = new Label();
		     
		     final TextField tfNmCliente = new TextField();
		     
		     final TextField tfCpfCliente = new TextField();
		     
		     final TextField tfValorCliente = new TextField();
		     
		     
		     Button btnCadastrar = new Button();
			 btnCadastrar.setText("Cadastrar");
			 btnCadastrar.getStyleClass().setAll("btn","btn-primary");
			 btnCadastrar.setOnAction(new EventHandler<ActionEvent>() {
		          
		          @Override
		          public void handle(ActionEvent event) {
		        	  
		        	  ClienteBot clienteBot = new ClienteBot();
		        	  String nome = tfNmCliente.getText();
		        	  String cpf = tfCpfCliente.getText();
		        	  double valor = Double.parseDouble(tfValorCliente.getText());
		        	  String status = clienteBot.AdicionaCliente(nome, cpf, valor);
		        	  
		        	  lblStatus.setText(status);
		          }
		      });
		     
			 Button btnVoltar = new Button();
			 btnVoltar.setText("Voltar");
			 btnVoltar.getStyleClass().setAll("btn","btn-default");
			 btnVoltar.setOnAction(new EventHandler<ActionEvent>() {
		          
		          @Override
		          public void handle(ActionEvent event) {
		              
		        	  MenuCliente menuCliente = new MenuCliente();
		        	  try {
						menuCliente.start(palco);
					} catch (Exception e) {

						e.printStackTrace();
					}
		          }
		      });
		     
			 Button btnExit = new Button();
			 btnExit.setText("Fechar");
			 btnExit.getStyleClass().setAll("btn","btn-danger");
			 btnExit.setOnAction(new EventHandler<ActionEvent>() {
		          
		          @Override
		          public void handle(ActionEvent event) {
		              palco.close();
		          }
		      });
			 
			 VBox vLbl = new VBox();
			 vLbl.setPadding(new Insets(20,40,10,10));
			 vLbl.setSpacing(20);
			 vLbl.getChildren().addAll(lblNmCliente,lblCpf,lblVl,lblStatus);
			 
			 VBox vTf = new VBox();
			 vTf.setPadding(new Insets(20,40,10,10));
			 vTf.setSpacing(8);
			 vTf.getChildren().addAll(tfNmCliente,tfCpfCliente, tfValorCliente);
			 
			 HBox hBtn = new HBox();
			 hBtn.setPadding(new Insets(20,40,10,10));
			 hBtn.setSpacing(8);
			 hBtn.getChildren().addAll(btnCadastrar, btnVoltar,btnExit);
			 
			 content.getChildren().addAll(vLbl,vTf,hBtn);
			 content.setLeftAnchor(vLbl, -150.0);
			 content.setLeftAnchor(vTf, 50.0);
			 content.setBottomAnchor(hBtn, 200.0);
		     
			 Scene cena = new Scene(panel, 600, 400);
		     cena.getStylesheets().add("bootstrapfx.css");
		     panel.setBody(content);
			 palco.setTitle("SisGC - Sistema de gestão de Clientes");
			 palco.setScene(cena);
			 palco.show();
		 }

}
