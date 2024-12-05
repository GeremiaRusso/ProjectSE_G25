/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projectse;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

/**
 *
 * @author gerem
 */
public class RubricaController implements Initializable{

    private Label label;
    
    @FXML
    private TextField name;
    @FXML
    private TextField surname;
    @FXML
    private TextField tag;
    @FXML
    private TextField number1;
    @FXML
    private TextField number2;
    @FXML
    private TextField number3;
    @FXML
    private TextField email1;
    @FXML
    private TextField email2;
    @FXML
    private TextField email3;
    @FXML
    private Button addButton;
    @FXML
    private Button removeButton;
    @FXML
    private Button modifyButton;
    @FXML
    private Button searchButton;
    @FXML
    private Button saveButton;
    @FXML
    private Button uploadButton;
    @FXML
    private TableColumn<?, ?> nameClm;
    @FXML
    private TableColumn<?, ?> cognomeClm;
    @FXML
    private TableColumn<?, ?> tagClm;
    @FXML
    private TableColumn<?, ?> email1Clm;
    @FXML
    private TableColumn<?, ?> email2Clm;
    @FXML
    private TableColumn<?, ?> email3Clm;
    @FXML
    private TableColumn<?, ?> number1Clm;
    @FXML
    private TableColumn<?, ?> number2Clm;
    @FXML
    private TableColumn<?, ?> numberClm3;

    @FXML
    private void AddContact(ActionEvent event) {
    }

    @FXML
    private void RemoveContact(ActionEvent event) {
    }

    @FXML
    private void ModifyContact(ActionEvent event) {
    }

    @FXML
    private void SearchContato(ActionEvent event) {
    }

    @FXML
    private void ExportRubrica(ActionEvent event) {
    }
    
    @FXML
    private void ImportRubrica(ActionEvent event){
        
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
