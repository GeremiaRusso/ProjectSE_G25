/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package fxml;
import com.mycompany.rubricatelefonica.Contatto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;

import java.net.URL;
import java.util.ResourceBundle;

public class SearchController implements Initializable {

    @FXML
    private TextField searchField;

    @FXML
    private TableView<Contatto> searchResultsTable;

    @FXML
    private TableColumn<Contatto, String> nameClm;
    @FXML
    private TableColumn<Contatto, String> surnameClm;
    @FXML
    private TableColumn<Contatto, String> num1Clm;
    @FXML
    private TableColumn<Contatto, String> num2Clm;
    @FXML
    private TableColumn<Contatto, String> num3Clm;
    @FXML
    private TableColumn<Contatto, String> email1Clm;
    @FXML
    private TableColumn<Contatto, String> email2Clm;
    @FXML
    private TableColumn<Contatto, String> email3Clm;
    @FXML
    private TableColumn<Contatto, String> tagClm;

    private ObservableList<Contatto> contattiObservableList;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Inizializza la lista dei contatti
        contattiObservableList = FXCollections.observableArrayList();

        // Impostazione delle colonne
        nameClm.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNome()));
        surnameClm.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCognome()));
        num1Clm.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNumero1()));
        num2Clm.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNumero2()));
        num3Clm.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNumero3()));
        email1Clm.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmail1()));
        email2Clm.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmail2()));
        email3Clm.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmail3()));
        tagClm.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTag()));

        // Filtro in tempo reale sulla ricerca del cognome e del tag
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == null || newValue.isEmpty()) {
        searchResultsTable.setItems(contattiObservableList);
    } else {
        ObservableList<Contatto> filteredList = FXCollections.observableArrayList();
        for (Contatto contatto : contattiObservableList) {
            // Filtro per cognome e tag (entrambi i campi vengono considerati nella ricerca)
            if (contatto.getCognome().toLowerCase().contains(newValue.toLowerCase()) ||
                contatto.getTag().toLowerCase().contains(newValue.toLowerCase())) {
                filteredList.add(contatto);
            }
        }
        searchResultsTable.setItems(filteredList);
    }
});

    }
    public void setContatti(ObservableList<Contatto> contatti) {
        contattiObservableList.setAll(contatti);
    }
}