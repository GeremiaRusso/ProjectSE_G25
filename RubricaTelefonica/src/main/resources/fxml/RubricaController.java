/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package fxml;

import com.mycompany.rubricatelefonica.Contatto;
import com.mycompany.rubricatelefonica.ErrorsPrint;
import com.mycompany.rubricatelefonica.Rubrica;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class RubricaController implements Initializable {

    private Rubrica rubrica;
    private ObservableList<Contatto> contattiObservableList; //list che gestisce l'aggiunta dei contatti visibili sulla tableview attraverso la GUI
    private static Pattern PATTERNnumber = Pattern.compile("\\d{10}"); //pattern obbligatorio per poter salvare un numero (10cifre)
    private static final Pattern PATTERNEmail = Pattern.compile("^[^@]+@[^@]+\\.[a-zA-Z]{2,}$");//pattern obbligatorio per poter salvare una mail (aaa@bbb.cc)

    //Identificativi di colonne,textfield e tableview riguardanti la parte grafica 
    @FXML
    private TableView<Contatto> tableview;
    @FXML
    private TableColumn<Contatto, String> nameClm, surnameClm, num1Clm, num2Clm, num3Clm, email1Clm, email2Clm, email3Clm, tagClm;
    @FXML
    private TextField nameField, surnameField, num1Field, num2Field, num3Field, email1Field, email2Field, email3Field, tagField;
    private TextField searchField;
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
        
        // Seleziona i campi giusti dalla sezione di inserimento dati alle colonne dei contatti
        nameClm.setCellValueFactory(new PropertyValueFactory<>("nome"));
        surnameClm.setCellValueFactory(new PropertyValueFactory<>("cognome"));
        num1Clm.setCellValueFactory(new PropertyValueFactory<>("numero1"));
        num2Clm.setCellValueFactory(new PropertyValueFactory<>("numero2"));
        num3Clm.setCellValueFactory(new PropertyValueFactory<>("numero3"));
        email1Clm.setCellValueFactory(new PropertyValueFactory<>("email1"));
        email2Clm.setCellValueFactory(new PropertyValueFactory<>("email2"));
        email3Clm.setCellValueFactory(new PropertyValueFactory<>("email3"));
        tagClm.setCellValueFactory(new PropertyValueFactory<>("tag"));

        tableview.setItems(contattiObservableList); // aggiorna la lista dei contatti visibili
    }    

    @FXML
    private void addContact(ActionEvent event) {
        
        //Salvataggio in variabili temporanee dei dati inseriti nei field per poter creare un contatto da aggiungere alla lista osservabile ed alla rubrica
        String nome = nameField.getText();
        String cognome = surnameField.getText();
        String num1 = num1Field.getText();
        String num2 = num2Field.getText();
        String num3 = num3Field.getText();
        String email1 = email1Field.getText();
        String email2 = email2Field.getText();
        String email3 = email3Field.getText();
        String tag = tagField.getText();

        //Aggiunte tutte le casistiche in cui l'aggiunta del contatto viene bloccata a seconda dell'errore di input causato, stampando anche quale sia stato
            if (nome.isEmpty() && cognome.isEmpty()) 
                ErrorsPrint.showMessage("Errore", "Inserire obbligatoriamente almeno uno tra Nome e Cognome");
                
            if(!num1.isEmpty() && !PATTERNnumber.matcher(num1).matches())
                ErrorsPrint.showMessage("Errore inserimento!" , "Formato del primo numero sbagliato! \n Inserire 10 cifre");
                
            if(!num2.isEmpty() && !PATTERNnumber.matcher(num2).matches())
                ErrorsPrint.showMessage("Errore inserimento!" , "Formato del secondo numero sbagliato! \n Inserire 10 cifre");
               
            if(!num3.isEmpty() && !PATTERNnumber.matcher(num3).matches())
                ErrorsPrint.showMessage("Errore inserimento!" , "Formato del terzo numero sbagliato! \n Inserire 10 cifre");
              
            if(!email1.isEmpty() && !PATTERNEmail.matcher(email1).matches())
                ErrorsPrint.showMessage("Errore inserimento!", "Formato della prima mail sbagliato! \n Inserire una '@' tra due stringhe di caratteri \n e l'identificativo (it,com..)");

            if(!email2.isEmpty() && !PATTERNEmail.matcher(email2).matches())
                ErrorsPrint.showMessage("Errore inserimento!", "Formato della seconda mail sbagliato! \n Inserire una '@' tra due stringhe di caratteri \n e l'identificativo (it,com..)");

            if(!email3.isEmpty() && !PATTERNEmail.matcher(email3).matches())
                ErrorsPrint.showMessage("Errore inserimento!", "Formato della terza mail sbagliato! \n Inserire una '@' tra due stringhe di caratteri \n e l'identificativo (it,com..)");
               
            
       if((!nome.isEmpty() || !cognome.isEmpty())  && (PATTERNnumber.matcher(num1).matches() ||num1.isEmpty()) && (PATTERNnumber.matcher(num2).matches() || num2.isEmpty()) && (PATTERNnumber.matcher(num3).matches() || num3.isEmpty()) && (PATTERNEmail.matcher(email1).matches() || email1.isEmpty()) && (PATTERNEmail.matcher(email2).matches() || email2.isEmpty()) && (PATTERNEmail.matcher(email3).matches() || email3.isEmpty())){
           //aggiunta del contatto in rubrica e aggiornamento della lista osservabile tramite la GUI se non ci sono stati problemi nell'inserimento
            Contatto contatto = new Contatto(nome, cognome, tag, num1, num2, num3, email1, email2, email3);
            rubrica.addContatto(contatto);
            refreshTable(); 
            clearFields();
       }
        
    }

    @FXML
    private void removeContact(ActionEvent event) {
         Contatto selectedContatto = tableview.getSelectionModel().getSelectedItem(); //sceglie il contatto cliccato
        if (selectedContatto != null) {
            rubrica.removeContatto(selectedContatto);
            refreshTable();
        } else {
            System.out.println("Seleziona un contatto da rimuovere.");
        }
    }

    @FXML
    private void modifyContact(ActionEvent event) {
        Contatto selectedContatto = tableview.getSelectionModel().getSelectedItem();

    if (selectedContatto != null) {
        // Sposta gli items del contatto selezionato dalla lista osservabile nei field di inserimento per poter modificare gli items
        nameField.setText(selectedContatto.getNome());
        surnameField.setText(selectedContatto.getCognome());
        num1Field.setText(selectedContatto.getNumero1());
        num2Field.setText(selectedContatto.getNumero2());
        num3Field.setText(selectedContatto.getNumero3());
        email1Field.setText(selectedContatto.getEmail1());
        email2Field.setText(selectedContatto.getEmail2());
        email3Field.setText(selectedContatto.getEmail3());
        tagField.setText(selectedContatto.getTag());

        // Rimuove il contatto dalla rubrica e dalla lista osservabile caricandolo nei field dell'inserimento per poter aggiungerlo senza reinserire tutto da capo ma solo modificando gli items
        rubrica.removeContatto(selectedContatto);
        contattiObservableList.remove(selectedContatto);

        // Aggiorna la tabella eliminando il contatto che si sta per modificare
        refreshTable();
    } else {
        ErrorsPrint.showMessage("Errore", "Seleziona un contatto da modificare.");
    }
    }

    @FXML
    private void searchContact(ActionEvent event) {
       try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("search.fxml"));
        Parent root = loader.load();  // Carica la scena per attivare la ricerca in tempo reale a seconda dell'inserimento

        SearchController searchController = loader.getController(); // Prende il controller dal loader, quindi la chiamata alla scena precedente
        ObservableList<Contatto> contatti = FXCollections.observableArrayList(rubrica.getContatti()); // Ottiene i contatti salvati
        searchController.setContatti(contatti);  // Passa tutti i contatti al controller della ricerca in tempo reale

        Stage stage = new Stage();
        stage.setTitle("Cerca Contatti");
        stage.setScene(new Scene(root)); // Imposta la scena
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
    }

    @FXML
    private void exportContact(ActionEvent event) throws IOException {
         Contatto selected = tableview.getSelectionModel().getSelectedItem();
        if (selected != null) {
            String nomefile = selected.getCognome() + "_" + selected.getNome() + ".csv";
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomefile))) {
                writer.write(selected.toCSV());
            }
        } else {
            ErrorsPrint.showMessage("Errore input","Seleziona un contatto da esportare.");
        }
    }

    @FXML
    private void exportRubrica(ActionEvent event) {
        rubrica.exportRubrica("rubrica.csv");
    }

    @FXML
    private void importRubrica(ActionEvent event) {
        rubrica.importRubrica("rubrica.csv");
        refreshTable();
    }
    
     private void refreshTable() {
        contattiObservableList.setAll(rubrica.getContatti());
        tableview.refresh();
    }

    private void clearFields() {
        nameField.clear();
        surnameField.clear();
        num1Field.clear();
        num2Field.clear();
        num3Field.clear();
        email1Field.clear();
        email2Field.clear();
        email3Field.clear();
        tagField.clear();
        searchField.clear();
    }
    
}
