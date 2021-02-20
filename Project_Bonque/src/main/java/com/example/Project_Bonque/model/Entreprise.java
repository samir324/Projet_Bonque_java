package com.example.Project_Bonque.model;

public class Entreprise {

    private int entreprise_id;
    private String acount_type;
    private String entreprise_nom;
    private int acount_numero;
    private double entreprise_solde;

    public int getEntreprise_id() {
        return entreprise_id;
    }

    public void setEntreprise_id(int entreprise_id) {
        this.entreprise_id = entreprise_id;
    }

    public String getAcount_type() {
        return acount_type;
    }

    public void setAcount_type(String acount_type) {
        this.acount_type = acount_type;
    }

    public String getEntreprise_nom() {
        return entreprise_nom;
    }

    public void setEntreprise_nom(String entreprise_nom) {
        this.entreprise_nom = entreprise_nom;
    }

    public int getAcount_numero() {
        return acount_numero;
    }

    public void setAcount_numero(int acount_numero) {
        this.acount_numero = acount_numero;
    }

    public double getEntreprise_solde() {
        return entreprise_solde;
    }

    public void setEntreprise_solde(double entreprise_solde) {
        this.entreprise_solde = entreprise_solde;
    }

    public Entreprise(int entreprise_id, String acount_type, String entreprise_nom, int acount_numero, double entreprise_solde) {
        this.entreprise_id = entreprise_id;
        this.acount_type = acount_type;
        this.entreprise_nom = entreprise_nom;
        this.acount_numero = acount_numero;
        this.entreprise_solde = entreprise_solde;
    }

    public Entreprise(String acount_type, String entreprise_nom, int acount_numero, double entreprise_solde) {
        this.acount_type = acount_type;
        this.entreprise_nom = entreprise_nom;
        this.acount_numero = acount_numero;
        this.entreprise_solde = entreprise_solde;
    }

    public Entreprise(int entreprise_id, String entreprise_nom, int acount_numero, double entreprise_solde) {
        this.entreprise_id = entreprise_id;
        this.entreprise_nom = entreprise_nom;
        this.acount_numero = acount_numero;
        this.entreprise_solde = entreprise_solde;
    }
}
