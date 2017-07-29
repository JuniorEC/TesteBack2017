package br.com.jdjava.Interface;

import java.sql.SQLException;

import org.kordamp.bootstrapfx.scene.layout.Panel;

import br.com.jdjava.JDBC.ClienteDAO;
import br.com.jdjava.ModelCliente.ClienteBot;
import br.com.jdjava.ModelCliente.ClienteDados;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BuscaCliente extends Application {
	
	 public static void main(String[] args) {
		  launch();
		 }

		 @Override
		 public void start(final Stage palco) throws Exception {
			 Panel panel = new Panel("Busca de Clientes.");
		     panel.getStyleClass().add("panel-primary");           
		     AnchorPane content = new AnchorPane();
		     content.setPadding(new Insets(200));
		     
		     Label lblIdInicial = new Label();
		     lblIdInicial.setText("Id Inicial");
		     
		     Label lblIdFinal = new Label();
		     lblIdFinal.setText("Id Final");
		     
		     Label lblValorBase = new Label();
		     lblValorBase.setText("Valor base");
		     
		     Label lblOpcoes = new Label();
		     lblOpcoes.setText("Escolha uma Opção");
		     
		     final Label lblmedia = new Label();
		     
		     final Label lblmediana = new Label();
		     
		     final CheckBox cbMedia = new CheckBox();
		     cbMedia.setText("Media");
		     
		     final CheckBox cbMediana = new CheckBox();
		     cbMediana.setText("Mediana");
		     
		     final TextField tfIntervaloIn = new TextField();
		     tfIntervaloIn.setMaxWidth(Double.MAX_VALUE);
		     
		     final TextField tfIntervaloFim = new TextField();
		     tfIntervaloFim.setMaxWidth(Double.MAX_VALUE);
		     
		     final TextField tfValorBase = new TextField();
		     tfValorBase.setMaxWidth(Double.MAX_VALUE);
		     
		     final ListView<ClienteDados> clienteDado = new ListView<ClienteDados>();
		     clienteDado.setPrefWidth(300);
		     clienteDado.setPrefHeight(200);
		     
		     
			 Button btnExit = new Button();
			 btnExit.setMaxWidth(Double.MAX_VALUE);
			 btnExit.getStyleClass().setAll("btn","btn-danger");
			 btnExit.setText("Fechar");
			 btnExit.setOnAction(new EventHandler<ActionEvent>() {
		          
		          @Override
		          public void handle(ActionEvent event) {
		              palco.close();
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
			 
			 Button btnBuscar = new Button();
			 btnBuscar.setMaxWidth(Double.MAX_VALUE);
			 btnBuscar.getStyleClass().setAll("btn","btn-primary");
			 btnBuscar.setText("Buscar");
			 btnBuscar.setOnAction(new EventHandler<ActionEvent>() {
		          
		          @Override
		          public void handle(ActionEvent event) {
		              double valor = Double.parseDouble(tfValorBase.getText());
		        	  int idInicial = Integer.parseInt(tfIntervaloIn.getText());
		              int idFinal = Integer.parseInt(tfIntervaloFim.getText());
		              
		              ClienteDAO clienteDao = new ClienteDAO();
		              ObservableList<ClienteDados> items =FXCollections.observableArrayList();
		              try {
		            	  
						items.addAll(clienteDao.getListaClientes(valor, idInicial, idFinal));
						
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
		              clienteDado.setItems(items);
		              
		              if(cbMedia.isSelected()) {
		            	  
		            	  ClienteBot clienteBot = new ClienteBot();
		            	  String media = clienteBot.MediaVlTotal(valor, idInicial, idFinal);
		            	  lblmedia.setText("A média é: " + media);
		            	  
		              } if(cbMediana.isSelected()) {
		            	  
		            	  ClienteBot clienteBot = new ClienteBot();
		            	  String mediana = clienteBot.MedianaVlTotal(valor, idInicial, idFinal);
		            	  lblmediana.setText("A mediana é: " + mediana);
		              }
		          }
		      });
			 
			 VBox vCb = new VBox();
			 vCb.setPadding(new Insets(20, 40, 10, 10));
			 vCb.setSpacing(8);
			 vCb.getChildren().addAll(lblOpcoes,cbMedia,cbMediana,lblmedia,lblmediana);
			 
			 VBox vTf = new VBox();
			 vTf.setPadding(new Insets(20,40,10,10));
			 vTf.setSpacing(8);
			 vTf.getChildren().addAll(tfIntervaloIn,tfIntervaloFim,tfValorBase);
			 
			 VBox vLbl = new VBox();
			 vLbl.setPadding(new Insets(20,40,10,10));
			 vLbl.setSpacing(20);
			 vLbl.getChildren().addAll(lblIdInicial,lblIdFinal,lblValorBase);
			 
			 VBox vLw = new VBox();
			 vLw.setPadding(new Insets(20,40,10,10));
			 vLbl.getChildren().addAll(clienteDado);
			 
			 HBox hBtn = new HBox();
			 hBtn.setPadding(new Insets(20,40,10,10));
			 hBtn.setSpacing(8);
			 hBtn.getChildren().addAll(btnBuscar,btnVoltar,btnExit);
			 
			 content.getChildren().addAll(vTf,vLbl,hBtn,vCb, vLw);
			 content.setLeftAnchor(vCb, -150.0);
			 content.setRightAnchor(vTf, 280.0);
			 content.setRightAnchor(vLbl, 200.0);
			 content.setRightAnchor(vLw, 40.0);
			 content.setBottomAnchor(hBtn, 150.0);
			 
			 
			 
		     Scene cena = new Scene(panel, 600, 500);
		     cena.getStylesheets().add("bootstrapfx.css");
		     panel.setBody(content);
			 palco.setTitle("SisGC - Sistema de gestão de Clientes");
			 palco.setScene(cena);
			 palco.show();
		 }

}
