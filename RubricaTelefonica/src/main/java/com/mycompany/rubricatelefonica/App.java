package com.mycompany.rubricatelefonica;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import static javafx.application.Application.launch;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        // Carica il file FXML dalla directory corretta
        scene = new Scene(loadFXML("/rubrica"), 1115, 772); // Dimensioni basate su quelle fornite in FXML
        stage.setScene(scene);
        stage.setTitle("Rubrica");
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        // Aggiunge il percorso corretto per trovare il file FXML
        return new FXMLLoader(App.class.getResource("/fxml/" + fxml + ".fxml")).load();
    }

    public static void main(String[] args) {
        launch();
    }
}