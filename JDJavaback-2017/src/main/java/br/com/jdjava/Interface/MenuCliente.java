package br.com.jdjava.Interface;

import org.kordamp.bootstrapfx.scene.layout.Panel;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MenuCliente extends Application {

	 public static void main(String[] args) {
	  launch();
	 }

	 @Override
	 public void start(final Stage palco) throws Exception {
		 Panel panel = new Panel("Bem vindo!");
	     panel.getStyleClass().add("panel-primary");           
	     BorderPane content = new BorderPane();
	     content.setPadding(new Insets(20));
	     
		 Button btnExit = new Button();
		 btnExit.setText("Fechar");
		 btnExit.getStyleClass().setAll("btn","btn-danger");
		 btnExit.setOnAction(new EventHandler<ActionEvent>() {
	          
	          @Override
	          public void handle(ActionEvent event) {
	              palco.close();
	          }
	      });
	     
		 Button btnAddUsr = new Button();
		 btnAddUsr.setText("Adicionar um Cliente");
		 btnAddUsr.getStyleClass().setAll("btn","btn-primary");
		 btnAddUsr.setOnAction(new EventHandler<ActionEvent>() {
	          
	          @Override
	          public void handle(ActionEvent event) {
	              
	              AddCliente addCliente = new AddCliente();
	              try {
					addCliente.start(palco);
				} catch (Exception e) {
					e.printStackTrace();
				}
	          }
	      });
		  
		  Button btnSrcUsr = new Button();
		  btnSrcUsr.setText("Buscar Cliente");
		  btnSrcUsr.getStyleClass().setAll("btn","btn-primary");
		  btnSrcUsr.setOnAction(new EventHandler<ActionEvent>() {
	          
	          @Override
	          public void handle(ActionEvent event) {
	              
	              BuscaCliente buscaCliente = new BuscaCliente();
	              try {
					buscaCliente.start(palco);
				} catch (Exception e) {
					e.printStackTrace();
				}
	          }
	      });
		  
		  
		  Scene cena = new Scene(panel, 600, 400);
		  cena.getStylesheets().add("bootstrapfx.css");
		  content.setLeft(btnAddUsr);
		  content.setCenter(btnSrcUsr);
		  content.setRight(btnExit);
		  
		  panel.setBody(content);
		  palco.setTitle("SisGC - Sistema de gestão de Clientes");
		  palco.setScene(cena);
		  palco.show();

	 }
}

