/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package fxml;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author gerem
 */
public class RubricaController implements Initializable {

    @FXML
    private TableView<?> tableview;
    @FXML
    private TableColumn<?, ?> nameClm;
    @FXML
    private TableColumn<?, ?> surnameClm;
    @FXML
    private TableColumn<?, ?> num1Clm;
    @FXML
    private TableColumn<?, ?> num2Clm;
    @FXML
    private TableColumn<?, ?> num3Clm;
    @FXML
    private TableColumn<?, ?> email1Clm;
    @FXML
    private TableColumn<?, ?> email2Clm;
    @FXML
    private TableColumn<?, ?> email3Clm;
    @FXML
    private TableColumn<?, ?> tagClm;
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
        // TODO
    }    

    @FXML
    private void addContact(ActionEvent event) {
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
