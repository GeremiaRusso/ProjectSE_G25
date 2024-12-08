package com.unisa.mavenproject1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        // Carica il file FXML dalla cartella corretta
        scene = new Scene(loadFXML("rubrica"), 1115, 772); // Assicurati che "rubrica" sia il nome corretto del file FXML
        stage.setScene(scene);
        stage.setTitle("Rubrica");
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        // Carica il file FXML dalla cartella /resources/fxml/
        return new FXMLLoader(App.class.getResource("/fxml/" + fxml + ".fxml")).load();
    }

    public static void main(String[] args) {
        launch();
    }
}
