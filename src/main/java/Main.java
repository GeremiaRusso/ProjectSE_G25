/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gerem
 */
public class Main {
    
    private String nome;
    
    public Main(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return this.nome;
    }
    
    public String getNome(String nome){
        return "ciao";
    }
    
    public String getCgonome(String cognome){
        return "cognome";
    }
}
