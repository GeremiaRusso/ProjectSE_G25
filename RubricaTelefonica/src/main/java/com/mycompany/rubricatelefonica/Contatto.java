package com.mycompany.rubricatelefonica;

public class Contatto implements Comparable<Contatto> {

    private String nome;
    private String cognome;
    private String tag;
    private String numero1;
    private String numero2;
    private String numero3;
    private String email1;
    private String email2;
    private String email3;

    // Costruttore
    public Contatto(String nome, String cognome, String tag,String numero1, String numero2, String numero3,String email1, String email2, String email3){
        this.nome = nome;
        this.cognome = cognome;
        this.tag = tag;
        this.numero1 = numero1;
        this.numero2 = numero2;
        this.numero3 = numero3;
        this.email1 = email1;
        this.email2 = email2;
        this.email3 = email3;
    }

    // Getter e Setter
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getNumero1() {
        return numero1;
    }

    public void setNumero1(String numero1) {
        this.numero1 = numero1;
    }

    public String getNumero2() {
        return numero2;
    }

    public void setNumero2(String numero2) {
        this.numero2 = numero2;
    }

    public String getNumero3() {
        return numero3;
    }

    public void setNumero3(String numero3) {
        this.numero3 = numero3;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getEmail3() {
        return email3;
    }

    public void setEmail3(String email3) {
        this.email3 = email3;
    }

    // Metodo per esportare il contatto come CSV
    public String toCSV() {
    }

    // Metodo statico per creare un contatto da una riga CSV
    public static Contatto fromCSV(String csv) {
    }


    // Override della compareTo per ordinare i contatti
    @Override
    public int compareTo(Contatto other) {
       
        String thisCognome = this.cognome != null ? this.cognome : "";
        String otherCognome = other.cognome != null ? other.cognome : "";
        int result = thisCognome.compareTo(otherCognome);

        if (result == 0) {
            String thisNome = this.nome != null ? this.nome : "";
            String otherNome = other.nome != null ? other.nome : "";
            result = thisNome.compareTo(otherNome);
        }
        return result;
    }
}

