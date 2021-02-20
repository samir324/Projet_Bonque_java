package com.example.Project_Bonque.model;

public class Person {
    private int person_id;
    private int acount_numero;
    private String acount_type;
    private String person_nom;
    private String person_prenom;
    private double person_solde;

    // constructor


    public Person( int acount_numero, String acount_type, String person_nom, String person_prenom, double person_solde) {
        this.acount_numero = acount_numero;
        this.acount_type = acount_type;
        this.person_nom = person_nom;
        this.person_prenom = person_prenom;
        this.person_solde = person_solde;
    }

    public Person(int person_id, int acount_numero, String acount_type, String person_nom, String person_prenom) {
        this.person_id = person_id;
        this.acount_numero = acount_numero;
        this.acount_type = acount_type;
        this.person_nom = person_nom;
        this.person_prenom = person_prenom;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public int getAcount_numero() {
        return acount_numero;
    }

    public void setAcount_numero(int acount_numero) {
        this.acount_numero = acount_numero;
    }

    public String getAcount_type() {
        return acount_type;
    }

    public void setAcount_type(String acount_type) {
        this.acount_type = acount_type;
    }

    public String getPerson_nom() {
        return person_nom;
    }

    public void setPerson_nom(String person_nom) {
        this.person_nom = person_nom;
    }

    public String getPerson_prenom() {
        return person_prenom;
    }

    public void setPerson_prenom(String person_prenom) {
        this.person_prenom = person_prenom;
    }

    public double getPerson_solde() {
        return person_solde;
    }

    public void setPerson_solde(double person_solde) {
        this.person_solde = person_solde;
    }
}