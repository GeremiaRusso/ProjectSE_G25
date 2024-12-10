/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rubricatelefonica;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class ErrorsPrint {
    // Crea una nuova scena per far visualizzare un messaggio tramite la GUI in casi specifici sollevati dal controller
    public static void showMessage(String title, String message) {
        Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.setTitle(title);

        Label label = new Label(message);
        VBox layout = new VBox(30);
        layout.getChildren().add(label);
        layout.setStyle("-fx-padding: 20; -fx-alignment: center;");

        Scene scene = new Scene(layout, 500, 300);
        dialog.setScene(scene);
        dialog.showAndWait();
    }
}
