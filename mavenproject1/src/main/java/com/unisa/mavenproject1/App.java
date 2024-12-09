package com.unisa.mavenproject1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        // Carica il file FXML dalla cartella resources
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/rubrica.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1115, 772); // Dimensioni della finestra
        stage.setScene(scene);
        stage.setTitle("Rubrica");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
