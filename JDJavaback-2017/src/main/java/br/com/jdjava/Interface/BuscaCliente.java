package br.com.jdjava.Interface;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class BuscaCliente extends Application {
	
	 public static void main(String[] args) {
		  launch();
		 }

		 @Override
		 public void start(Stage palco) throws Exception {
			 TilePane tilePane = new TilePane();
		     tilePane.setPrefColumns(3);
		     tilePane.setPadding(new Insets(5, 5, 5, 5));
		     tilePane.setVgap(5);
		     tilePane.setHgap(5);
		     tilePane.setStyle("-fx-background-color: D0D0D0;");
		     tilePane.setAlignment(Pos.CENTER);
		     
		     TextField tfIntervaloIn = new TextField();
		     
			 Button btnExit = new Button();
			 btnExit.setText("Fechar");
			 btnExit.setOnAction(new EventHandler<ActionEvent>() {
		          
		          @Override
		          public void handle(ActionEvent event) {
		              palco.close();
		          }
		      });
			 
			 Button btnBuscar = new Button();
			 btnBuscar.setText("Buscar");
			 btnBuscar.setOnAction(new EventHandler<ActionEvent>() {
		          
		          @Override
		          public void handle(ActionEvent event) {
		              
		          }
		      });
			 tilePane.getChildren().addAll(btnBuscar, btnExit);
			  ObservableList<Node> children = tilePane.getChildren();
		      children.forEach(button->{
		          ((Button)button).setMinWidth(Button.USE_PREF_SIZE);
		          ((Button)button).setMaxWidth(Double.MAX_VALUE);
		          ((Button)button).setMinHeight(Button.USE_PREF_SIZE);
		          ((Button)button).setMaxHeight(Double.MAX_VALUE);

		      });
		      
		     Scene cena = new Scene(tilePane, 600, 400);
		     cena.getStylesheets().add("bootstrapfx.css");
			  palco.setTitle("Buscar Cliente");
			  palco.setScene(cena);
			  palco.show();
		 }

}
