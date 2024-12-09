package com.mycompany.progoffline;

import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXML;



/**
 *
 * @author gerem
 */
import java.util.ArrayList;

/**
 * Classe che rappresenta un contatto.
 */
public class Contatto implements Comparable<Contatto> {

    private String nome;
    private String cognome;
    private String tag;
    private ArrayList<String> numeri;
    private ArrayList<String> email;

    // Costruttore
    public Contatto(String nome, String cognome, String tag, 
                    String numero1, String numero2, String numero3,
                    String email1, String email2, String email3) {
        this.nome = nome;
        this.cognome = cognome;
        this.tag = tag;
        this.numeri = new ArrayList(3);       
        this.email = new ArrayList(3);
        
    }

    // Getter e Setter per nome
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter e Setter per cognome
    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    // Getter e Setter per tag
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    // Getter e Setter per numeri
    public ArrayList<String> getNumeri() {
        return numeri;
    }

    public void setNumeri(ArrayList<String> numeri) {
        this.numeri = numeri;
    }

    // Getter e Setter per email
    public ArrayList<String> getEmail() {
        return email;
    }

    public void setEmail(ArrayList<String> email) {
        this.email = email;
    }

    // Metodo toCSV per esportare un contatto in formato CSV
    public String toCSV() {
        return nome + "," + cognome + "," + tag + "," +
               String.join(",", numeri) + "," + String.join(",", email);
    }

    // Metodo statico per creare un contatto a partire da una riga CSV
    public static Contatto fromCSV(String csv) {
        String[] parts = csv.split(",");
        
        // Assumiamo che il CSV contenga 9 campi
        String nome = parts[0];
        String cognome = parts[1];
        String tag = parts[2];
        String numero1 = parts[3];
        String numero2 = parts[4];
        String numero3 = parts[5];
        String email1 = parts[6];
        String email2 = parts[7];
        String email3 = parts[8];

        return new Contatto(nome, cognome, tag, numero1, numero2, numero3, email1, email2, email3);
    }

    // Implementazione del metodo compareTo per ordinare i contatti
    @Override
    public int compareTo(Contatto o) {
        return this.cognome.compareTo(o.cognome); // Ordina per cognome
    }
}

