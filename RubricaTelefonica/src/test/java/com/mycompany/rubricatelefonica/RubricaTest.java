/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.rubricatelefonica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author gerem
 */
public class RubricaTest {
    
    public RubricaTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of addContatto method, of class Rubrica.
     */
   @Test
public void testAddContatto() {
    // Crea un oggetto Contatto con valori validi
    Contatto contatto = new Contatto("Mario", "Rossi", "1234567890","","","","","",""); 
    Rubrica instance = new Rubrica();

    // Aggiungi il contatto alla rubrica
    instance.addContatto(contatto);

    // Verifica che il contatto sia stato aggiunto correttamente
    assertTrue(instance.getContatti().contains(contatto)); 
}


    /**
     * Test of removeContatto method, of class Rubrica.
     */
    @Test
    public void testRemoveContatto() {
        System.out.println("removeContatto");
        Contatto contatto = new Contatto("Mario", "Rossi", "1234567890","","","","","","");
        Rubrica instance = new Rubrica();
        instance.removeContatto(contatto);
        assertFalse(instance.getContatti().contains(contatto));
    }

    /**
     * Test of searchContatti method, of class Rubrica.
     */
@Test
public void testSearchContatti() {
    System.out.println("searchContatti");

    // Parola chiave per la ricerca
    String keyword = "Giuffri";

    // Crea una nuova rubrica e aggiunge dei contatti
    Rubrica instance = new Rubrica();
    Contatto contatto1 = new Contatto("Mario", "Rossi", "1234567890", "", "", "offgre@gmail.it", "", "", "sport");
    Contatto contatto2 = new Contatto("Luca", "Giuffri", "1234567890", "", "", "offgre@gmail.it", "", "", "studente");

    instance.addContatto(contatto1);
    instance.addContatto(contatto2);

    // Il risultato atteso dovrebbe contenere solo il contatto che ha la parola chiave 'studente' nel tag
    List<Contatto> expResult = new ArrayList<>();
    expResult.add(contatto2);  // Solo contatto2 dovrebbe essere restituito, perché ha "studente" nel tag

    // Chiamata al metodo da testare
    List<Contatto> result = instance.searchContatti(keyword);

    // Verifica che il risultato contenga contatto2
    assertTrue(result.contains(contatto2));  // Assicuriamoci che contatto2 sia presente nel risultato
    assertEquals(expResult.size(), result.size());  // Verifica che la dimensione dei risultati sia corretta
}



   public void testExportRubrica() {
    // Crea una nuova rubrica
    Rubrica rubrica = new Rubrica();

    // Aggiungi alcuni contatti
    Contatto contatto1 = new Contatto("Mario", "Rossi", "1234567890", "2345678901", "3456789012", 
                                      "mario.rossi@example.com", "mario2@example.com", "mario3@example.com", "Amico");
    Contatto contatto2 = new Contatto("Giulia", "Bianchi", "0987654321", "8765432109", "7654321098", 
                                      "giulia.bianchi@example.com", "giulia2@example.com", "giulia3@example.com", "Collega");

    rubrica.addContatto(contatto1);
    rubrica.addContatto(contatto2);

    // Esporta la rubrica in un file CSV
    String fileName = "rubrica_test.csv";
    rubrica.exportRubrica(fileName);

    // Verifica che il file sia stato creato
    File file = new File(fileName);
    if (file.exists()) {
        System.out.println("Il file è stato creato con successo: " + fileName);
        
        // Leggi il contenuto del file per verificarne la correttezza
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);  // Stampa il contenuto del file per la verifica

                // Puoi aggiungere logiche per verificare che il contenuto del file
                // corrisponda esattamente ai dati dei contatti che hai inserito
            }
        } catch (IOException e) {
            System.err.println("Errore nella lettura del file: " + e.getMessage());
        }
    } else {
        System.err.println("Il file non è stato creato.");
    }

}
   
   

public static void testImportRubrica() {
    // Creazione del file CSV con dei dati di test
    String nomeFile = "rubrica_test.csv";
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeFile))) {
        // Scrittura di due contatti nel file CSV
        writer.write("Mario,Rossi,Amico,1234567890,2345678901,3456789012,mario.rossi@example.com,mario2@example.com,mario3@example.com");
        writer.newLine();
        writer.write("Giulia,Bianchi,Collega,0987654321,8765432109,7654321098,giulia.bianchi@example.com,giulia2@example.com,giulia3@example.com");
        writer.newLine();
    } catch (IOException e) {
        e.printStackTrace();
        System.out.println("Errore durante la creazione del file di test.");
    }

    // Creazione della rubrica
    Rubrica rubrica = new Rubrica();

    // Importazione della rubrica dal file CSV
    try (BufferedReader reader = new BufferedReader(new FileReader(nomeFile))) {
        String line;
        while ((line = reader.readLine()) != null) {
            Contatto contatto = Contatto.fromCSV(line);
            if (contatto != null) {
                rubrica.addContatto(contatto);
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
        System.out.println("Errore durante l'importazione dei contatti.");
    }

    // Verifica dei contatti importati
    if (rubrica.getContatti().size() > 0) {
        System.out.println("Contatti importati correttamente!");
        for (Contatto contatto : rubrica.getContatti()) {
            System.out.println(contatto.getNome() + " " + contatto.getCognome());
        }
    } else {
        System.out.println("Nessun contatto importato.");
    }
}


    @Test
    public void testOrdinaRubrica() {
        // Creazione della rubrica
        Rubrica rubrica = new Rubrica();
        
        // Aggiungi alcuni contatti alla rubrica
        rubrica.addContatto(new Contatto("Mario", "Rossi", "123456789", "987654321", "456789123", "mario.rossi@email.com", "mario2@email.com", "mario3@email.com", "Amico"));
        rubrica.addContatto(new Contatto("Luca", "Bianchi", "234567890", "876543210", "567890123", "luca.bianchi@email.com", "luca2@email.com", "luca3@email.com", "Collega"));
        rubrica.addContatto(new Contatto("Giulia", "Verdi", "345678901", "765432109", "678901234", "giulia.verdi@email.com", "giulia2@email.com", "giulia3@email.com", "Familiare"));
        rubrica.addContatto(new Contatto("Marco", "Rossi", "456789012", "654321098", "789012345", "marco.rossi@email.com", "marco2@email.com", "marco3@email.com", "Amico"));
        
        // Ordinamento per cognome e nome
        rubrica.getContatti().sort((c1, c2) -> {
            int cognomeComparison = c1.getCognome().compareTo(c2.getCognome());
            if (cognomeComparison == 0) {
                return c1.getNome().compareTo(c2.getNome());
            }
            return cognomeComparison;
        });

        // Verifica che i contatti siano ordinati correttamente
        List<Contatto> contattiOrdinati = rubrica.getContatti();

        // Verifica che il primo contatto abbia il cognome "Bianchi" e nome "Luca"
        assertEquals("Bianchi", contattiOrdinati.get(0).getCognome());
        assertEquals("Luca", contattiOrdinati.get(0).getNome());

        // Verifica che il secondo contatto abbia il cognome "Rossi" e nome "Marco"
        assertEquals("Rossi", contattiOrdinati.get(1).getCognome());
        assertEquals("Marco", contattiOrdinati.get(1).getNome());

        // Verifica che il terzo contatto abbia il cognome "Rossi" e nome "Mario"
        assertEquals("Rossi", contattiOrdinati.get(2).getCognome());
        assertEquals("Mario", contattiOrdinati.get(2).getNome());

        // Verifica che l'ultimo contatto abbia il cognome "Verdi" e nome "Giulia"
        assertEquals("Verdi", contattiOrdinati.get(3).getCognome());
        assertEquals("Giulia", contattiOrdinati.get(3).getNome());
    }




    @Test
    public void testGetContatti() {
        System.out.println("getContatti");

        // Crea una nuova rubrica vuota
        Rubrica instance = new Rubrica();

        // Chiamata al metodo getContatti
        List<Contatto> result = instance.getContatti();

        // Stampa il tipo di oggetto restituito
        System.out.println("Tipo di oggetto restituito: " + result.getClass().getName());

        // Stampa il contenuto della lista restituita
        System.out.println("Contatti ottenuti: " + result);

        // Verifica che la lista restituita sia vuota
        if (result.size() != 0) {
            System.out.println("Errore: la lista dei contatti non è vuota. Dimensione lista: " + result.size());
        } else {
            System.out.println("Test passato: la lista dei contatti è vuota.");
        }

        // Verifica che la lista sia effettivamente vuota
        if (!result.isEmpty()) {
            System.out.println("Errore: la lista dei contatti dovrebbe essere vuota.");
        } else {
            System.out.println("Test passato: la lista dei contatti è vuota.");
        }
    }
}





