/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unisa.mavenproject1;

/**
 *
 * @author gerem
 */

import java.io.*;
import java.util.TreeSet;

/**
 * Classe Rubrica che gestisce i contatti.
 */
public class Rubrica {
    
    private TreeSet<Contatto> rubrica;
    
    public Rubrica() {
        this.rubrica = new TreeSet();
    }
    
    /**
     * Aggiungi un contatto alla rubrica.
     * @param contatto Il contatto da aggiungere.
     */
    public void addContatto(Contatto contatto) {
        rubrica.add(contatto);
    }
    
    /**
     * Rimuovi un contatto dalla rubrica.
     * @param contatto Il contatto da rimuovere.
     */
    public void removeContatto(Contatto contatto) {
        rubrica.remove(contatto);
    }

    /**
     * Modifica un contatto esistente nella rubrica.
     * @param oldContatto Il contatto da modificare.
     * @param newContatto Il nuovo contatto che sostituisce il vecchio.
     */
    public void modifyContatto(Contatto oldContatto, Contatto newContatto) {
        if (rubrica.contains(oldContatto)) {
            rubrica.remove(oldContatto);
            rubrica.add(newContatto);
        }
    }

    /**
     * Cerca un contatto nella rubrica utilizzando il metodo contains.
     * @param contatto Il contatto da cercare.
     * @return true se il contatto esiste, false altrimenti.
     */
    public boolean searchContatto(Contatto contatto) {
        return rubrica.contains(contatto);
    }

    /**
     * Esporta la rubrica in un file CSV.
     * @param namefile Il nome del file di destinazione.
     */
    public void exportRubrica(String namefile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(namefile))) {
            for (Contatto contatto : rubrica) {
                writer.write(contatto.toCSV());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Errore durante l'esportazione della rubrica: " + e.getMessage());
        }
    }

    /**
     * Importa i contatti da un file CSV.
     * @param namefile Il nome del file da cui importare.
     */
    public void importRubrica(String namefile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(namefile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Contatto contatto = Contatto.fromCSV(line);
                rubrica.add(contatto);
            }
        } catch (IOException e) {
            System.out.println("Errore durante l'importazione della rubrica: " + e.getMessage());
        }
    }

    // Getter per ottenere la rubrica
    public TreeSet<Contatto> getRubrica() {
        return rubrica;
    }
}
