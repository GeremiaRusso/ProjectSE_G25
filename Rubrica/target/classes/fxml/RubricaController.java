/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package fxml;

import com.mycompany.progoffline.Contatto;
import com.mycompany.progoffline.Rubrica;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Alessio
 */
public class RubricaController implements Initializable {

    private Rubrica rubrica;
    private ObservableList<Contatto> contattiObservableList;
    @FXML
    private TableView<Contatto> tableview;
    
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
    @FXML
    private MenuItem addButton;
    @FXML
    private MenuItem removeButton;
    @FXML
    private MenuItem modifyButton;
    @FXML
    private MenuItem searchButton;
    @FXML
    private MenuItem exportcontactButton;
    @FXML
    private TextField nameField;
    @FXML
    private TextField surnameField;
    @FXML
    private TextField num1Field;
    @FXML
    private TextField num2Field;
    @FXML
    private TextField num3Field;
    @FXML
    private TextField email1Field;
    @FXML
    private TextField email2Field;
    @FXML
    private TextField email3Field;
    @FXML
    private TextField tagField;
    @FXML
    private MenuItem exportrubricaButton;
    @FXML
    private MenuItem importrubricaButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rubrica = new Rubrica();
        contattiObservableList = FXCollections.observableArrayList();
        
        nameClm.setCellValueFactory(new PropertyValueFactory<>("nome"));
        surnameClm.setCellValueFactory(new PropertyValueFactory<>("cognome"));
        num1Clm.setCellValueFactory(new PropertyValueFactory<>("num1"));
        num2Clm.setCellValueFactory(new PropertyValueFactory<>("num2"));
        num3Clm.setCellValueFactory(new PropertyValueFactory<>("num3"));
        email1Clm.setCellValueFactory(new PropertyValueFactory<>("email1"));
        email2Clm.setCellValueFactory(new PropertyValueFactory<>("email2"));
        email3Clm.setCellValueFactory(new PropertyValueFactory<>("email3"));
        tagClm.setCellValueFactory(new PropertyValueFactory<>("tag"));
        tableview.setItems(contattiObservableList);
        
    }    

    @FXML
    private void addContact(ActionEvent event) {
        String nome = nameField.getText();
        String cognome = surnameField.getText();
        String num1 = num1Field.getText();
        String num2 = num2Field.getText();
        String num3 = num3Field.getText();
        String email1 = email1Field.getText();
        String email2 = email2Field.getText();
        String email3 = email3Field.getText();
        String tag = tagField.getText();
        
        Contatto contatto = new Contatto(nome, cognome, tag, num1, num2, num3, email1, email2, email3);

        // Aggiungi il contatto alla rubrica e aggiorna la lista osservabile
        rubrica.addContatto(contatto);
        contattiObservableList.add(contatto);
        tableview.setItems(contattiObservableList);

        // Ripulisci i campi di testo
        
    }

    @FXML
    private void removeContact(ActionEvent event) {
    }

    @FXML
    private void modifyContact(ActionEvent event) {
    }

    @FXML
    private void searchContact(ActionEvent event) {
    }

    @FXML
    private void exportContact(ActionEvent event) {
    }

    @FXML
    private void exportRubrica(ActionEvent event) {
    }

    @FXML
    private void importRubrica(ActionEvent event) {
    }

    
    
}
