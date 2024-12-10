/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package fxml;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Alessio
 */
public class SearchController implements Initializable {

    @FXML
    private TextField searchField;
    @FXML
    private TableView<?> searchResultsTable;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
