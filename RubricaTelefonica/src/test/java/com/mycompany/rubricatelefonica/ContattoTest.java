package com.mycompany.rubricatelefonica;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe di test per Contatto.
 */
public class ContattoTest {

    public ContattoTest() {
    }

    @BeforeAll
    public static void setUpClass() {
        System.out.println("Inizio test classe Contatto...");
    }

    @AfterAll
    public static void tearDownClass() {
        System.out.println("Test classe Contatto completati.");
    }

    @BeforeEach
    public void setUp() {
        System.out.println("Preparazione di un nuovo test...");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Test completato.");
    }

    @Test
    public void testGetNome() {
        Contatto instance = new Contatto("Mario", "Rossi", "1234567899", "1234567891", "1234567890", "", "", "", "università");
        String expResult = "Mario";
        String result = instance.getNome();
        assertEquals(expResult, result, "getNome non restituisce il valore corretto.");
    }

    @Test
    public void testSetNome() {
        Contatto instance = new Contatto();
        String nome = "Mario";
        instance.setNome(nome);
        assertEquals(nome, instance.getNome(), "setNome non imposta correttamente il valore.");
    }

    @Test
    public void testGetCognome() {
        Contatto instance = new Contatto("Mario", "Rossi", "1234567899", "1234567891", "1234567890", "", "", "", "università");
        String expResult = "Rossi";
        String result = instance.getCognome();
        assertEquals(expResult, result, "getCognome non restituisce il valore corretto.");
    }

    @Test
    public void testSetCognome() {
        Contatto instance = new Contatto();
        String cognome = "Rossi";
        instance.setCognome(cognome);
        assertEquals(cognome, instance.getCognome(), "setCognome non imposta correttamente il valore.");
    }

    @Test
    public void testGetTag() {
        Contatto instance = new Contatto("Mario", "Rossi", "1234567899", "1234567891", "1234567890", "", "", "", "università");
        String expResult = "università";
        String result = instance.getTag();
        assertEquals(expResult, result, "getTag non restituisce il valore corretto.");
    }

    @Test
    public void testSetTag() {
        Contatto instance = new Contatto();
        String tag = "università";
        instance.setTag(tag);
        assertEquals(tag, instance.getTag(), "setTag non imposta correttamente il valore.");
    }

 @Test
public void testToCSV() {
    // Crea un nuovo contatto con alcuni campi vuoti
    Contatto instance = new Contatto("Mario", "Rossi", "1234567890", "", "", "", "", "", "");

    // Risultato atteso con i valori vuoti nel formato CSV
    String expResult = "Mario,Rossi,1234567890,,,,,,";

    // Ottieni il risultato del metodo toCSV
    String result = instance.toCSV();

    // Aggiungiamo un messaggio di stampa per il debugging
    System.out.println("Risultato: " + result);  // Stampa il risultato per il debug

    // Verifica che il risultato ottenuto corrisponda a quello atteso
    assertEquals(expResult, result, "Il formato CSV non è corretto.");
}







    @Test
    public void testFromCSV() {
        String csv = "Mario,Rossi,123456789,,,,,,";
        Contatto expResult = new Contatto("Mario", "Rossi", "123456789", "", "", "", "", "", "");
        Contatto result = Contatto.fromCSV(csv);
        assertEquals(expResult.toCSV(), result.toCSV(), "fromCSV non restituisce l'oggetto corretto.");
    }

    @Test
    public void testCompareTo() {
        Contatto instance1 = new Contatto("Mario", "Rossi", "123456789", "", "", "", "", "", "");
        Contatto instance2 = new Contatto("Luigi", "Bianchi", "987654321", "", "", "", "", "", "");
        assertTrue(instance1.compareTo(instance2) > 0, "Il confronto non è corretto per ordine crescente.");
        assertTrue(instance2.compareTo(instance1) < 0, "Il confronto non è corretto per ordine decrescente.");
        assertEquals(0, instance1.compareTo(instance1), "Il confronto con se stesso dovrebbe restituire 0.");
    }
}
