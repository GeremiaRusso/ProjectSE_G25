package com.unisa.mavenproject1;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;

public class RubricaController implements Initializable {

    private Rubrica rubrica; // Istanza della classe Rubrica
    private ObservableList<Contatto> contattiObservableList; // Lista osservabile per la TableView

    @FXML
    private TableView<Contatto> tableView; // TableView per i contatti
    @FXML
    private TableColumn<Contatto, String> nameClm;
    @FXML
    private TableColumn<Contatto, String> surnameClm;
    @FXML
    private TableColumn<Contatto, String> tagClm;
    @FXML
    private TableColumn<Contatto, String> email1Clm;
    @FXML
    private TableColumn<Contatto, String> email2Clm;
    @FXML
    private TableColumn<Contatto, String> email3Clm;
    @FXML
    private TableColumn<Contatto, String> num1Clm;
    @FXML
    private TableColumn<Contatto, String> num2Clm;
    @FXML
    private TableColumn<Contatto, String> num3Clm;

    @FXML
    private TextField nameField;
    @FXML
    private TextField surnameField;
    @FXML
    private TextField tagField;
    @FXML
    private TextField email1Field;
    @FXML
    private TextField email2Field;
    @FXML
    private TextField email3Field;
    @FXML
    private TextField number1Field;
    @FXML
    private TextField number2Field;
    @FXML
    private TextField number3Field;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Inizializza la rubrica e la lista osservabile
        rubrica = new Rubrica();
        contattiObservableList = FXCollections.observableArrayList();

        // Collega le colonne della TableView con le proprietà della classe Contatto
        nameClm.setCellValueFactory(new PropertyValueFactory<>("nome"));
        surnameClm.setCellValueFactory(new PropertyValueFactory<>("cognome"));
        tagClm.setCellValueFactory(new PropertyValueFactory<>("tag"));
        email1Clm.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getEmail().isEmpty() ? "" : c.getValue().getEmail().get(0)));

    email2Clm.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getEmail().size() > 1 ? c.getValue().getEmail().get(1) : ""));

    email3Clm.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getEmail().size() > 2 ? c.getValue().getEmail().get(2) : ""));

    num1Clm.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getNumeri().isEmpty() ? "" : c.getValue().getNumeri().get(0)));

    num2Clm.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getNumeri().size() > 1 ? c.getValue().getNumeri().get(1) : ""));

    num3Clm.setCellValueFactory(c ->  new SimpleStringProperty(c.getValue().getNumeri().size() > 2 ? c.getValue().getNumeri().get(2) : ""));
        // Associa la lista osservabile alla TableView
        tableView.setItems(contattiObservableList);
    }

    @FXML
    private void addContact(ActionEvent event) {
        // Recupera i dati dai campi di testo
        String nome = nameField.getText();
        String cognome = surnameField.getText();
        String tag = tagField.getText();
        String email1 = email1Field.getText();
        String email2 = email2Field.getText();
        String email3 = email3Field.getText();
        String num1 = number1Field.getText();
        String num2 = number2Field.getText();
        String num3 = number3Field.getText();

        // Crea un nuovo contatto
        Contatto contatto = new Contatto(nome, cognome, tag, num1, num2, num3, email1, email2, email3);

        // Aggiungi il contatto alla rubrica e aggiorna la lista osservabile
        rubrica.addContatto(contatto);
        contattiObservableList.add(contatto);

        // Ripulisci i campi di testo
        clearFields();
    }

    @FXML
    private void removeContact(ActionEvent event) {
        // Ottieni il contatto selezionato nella TableView
        Contatto selectedContact = tableView.getSelectionModel().getSelectedItem();

        if (selectedContact != null) {
            // Rimuovi il contatto dalla rubrica e dalla lista osservabile
            rubrica.removeContatto(selectedContact);
            contattiObservableList.remove(selectedContact);
        }
    }

    @FXML
    private void modifyContact(ActionEvent event) {
        // Ottieni il contatto selezionato
        Contatto selectedContact = tableView.getSelectionModel().getSelectedItem();

        if (selectedContact != null) {
            // Recupera i nuovi valori dai campi di testo
            String nome = nameField.getText();
            String cognome = surnameField.getText();
            String tag = tagField.getText();
            String email1 = email1Field.getText();
            String email2 = email2Field.getText();
            String email3 = email3Field.getText();
            String num1 = number1Field.getText();
            String num2 = number2Field.getText();
            String num3 = number3Field.getText();

            // Crea un nuovo contatto con i valori modificati
            Contatto newContact = new Contatto(nome, cognome, tag, num1, num2, num3, email1, email2, email3);

            // Modifica il contatto nella rubrica
            rubrica.modifyContatto(selectedContact, newContact);

            // Aggiorna la lista osservabile
            contattiObservableList.remove(selectedContact);
            contattiObservableList.add(newContact);

            // Ripulisci i campi di testo
            clearFields();
        }
    }

    @FXML
    private void searchContact(ActionEvent event) {
        // Filtra i contatti in base al nome e aggiorna la lista visibile nella TableView
        String nome = nameField.getText().toLowerCase();
        ObservableList<Contatto> filteredList = FXCollections.observableArrayList();

        for (Contatto c : rubrica.getRubrica()) {
            if (c.getNome().toLowerCase().contains(nome)) {
                filteredList.add(c);
            }
        }

        tableView.setItems(filteredList);
    }

    private void clearFields() {
        nameField.clear();
        surnameField.clear();
        tagField.clear();
        email1Field.clear();
        email2Field.clear();
        email3Field.clear();
        number1Field.clear();
        number2Field.clear();
        number3Field.clear();
    }
}
