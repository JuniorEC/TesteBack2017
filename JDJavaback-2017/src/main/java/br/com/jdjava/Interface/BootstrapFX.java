package br.com.jdjava.Interface;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.scene.layout.Panel;

public class BootstrapFX extends Application {
	public static void main(String[] args) {
		  launch();
		 }
    @Override
    public void start(Stage primaryStage) throws Exception {  
        Panel panel = new Panel("This is the title");
        panel.getStyleClass().add("panel-primary");           
        BorderPane content = new BorderPane();
        content.setPadding(new Insets(20));
        Button button = new Button("Hello BootstrapFX");
        button.getStyleClass().setAll("btn","btn-danger");    
        content.setCenter(button);
        panel.setBody(content);

        Scene scene = new Scene(panel);
        scene.getStylesheets().add("bootstrapfx.css");        

        primaryStage.setTitle("BootstrapFX");
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();
    }
}
