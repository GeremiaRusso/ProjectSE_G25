/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projectse;

import java.util.ArrayList;

/**
 *
 * @author gerem
 */
public class Contatto implements Comparable<Contatto>{
    private String nome;
    private String cognome;
    private String tag;
    private ArrayList<String> email;
    private ArrayList<String> numero;
    
    public Contatto(String nome, String cognome, String tag){
        this.nome = nome;
        this.cognome = cognome;
        this.tag = tag;
        this.email = new ArrayList<>(3);
        this.numero = new ArrayList<>(3);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void addEmail(String e){
        if(email.size() < 3)
            email.add(e);
        else
            System.out.println("Sono presenti già 3 email");
    }
    
    public void addNumber(String n){
        if(numero.size() < 3)
            numero.add(n);
        else
            System.out.println("Sono presenti già 3 numeri");
    }
    

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getTag() {
        return tag;
    }
    
    public ArrayList<String> getEmail(){
        return email;
    }
    
    public ArrayList<String> getNumero(){
        return numero;
    }

    @Override
    public int compareTo(Contatto o) {
        return this.cognome.compareTo(o.nome);
    }

    
}
