/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rubricatelefonica;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Rubrica {

    private TreeSet<Contatto> rubrica;

    public Rubrica() {
        this.rubrica = new TreeSet<>();
    }

    public void addContatto(Contatto contatto) {
        rubrica.add(contatto);
    }

    public void removeContatto(Contatto contatto) {
        rubrica.remove(contatto);
    }

    public List<Contatto> searchContatti() {
        
    }

    public void exportRubrica(String namefile) {
    }

    public void importRubrica(String namefile) {
    }

    public List<Contatto> getContatti() {
    }
}