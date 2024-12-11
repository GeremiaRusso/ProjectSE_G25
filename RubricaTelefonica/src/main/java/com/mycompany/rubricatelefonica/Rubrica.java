/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rubricatelefonica;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Rubrica {

    private List<Contatto> rubrica;

    public Rubrica() {
        this.rubrica = new ArrayList<>();
    }

    public void addContatto(Contatto contatto) {
        rubrica.add(contatto);
        ordinaRubrica();
    }

    public void removeContatto(Contatto contatto) {
        rubrica.remove(contatto);
        ordinaRubrica();
    }

    public List<Contatto> searchContatti(String keyword) {
        return rubrica.stream().filter(contatto -> contatto.getCognome().toLowerCase().contains(keyword.toLowerCase())).collect(Collectors.toList());
    }

    public void exportRubrica(String namefile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(namefile))) {
            for (Contatto contatto : rubrica) {
                writer.write(contatto.toCSV());
                writer.newLine();
            }
        } catch (IOException e) {
            ErrorsPrint.showMessage("Errore durante l'esportazione: " , e.getMessage());
        }
    }

    public void importRubrica(String namefile) {
         try (BufferedReader reader = new BufferedReader(new FileReader(namefile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Contatto contatto = Contatto.fromCSV(line);
                if (contatto != null) {
                    rubrica.add(contatto);
                }
            }
        } catch (IOException e) {
            ErrorsPrint.showMessage("Errore durante l'importazione: ", e.getMessage());
        }
    }

    public List<Contatto> getContatti() {
        return new ArrayList<>(rubrica);
    }
    
     private void ordinaRubrica() {
        Collections.sort(rubrica);  
    }
}