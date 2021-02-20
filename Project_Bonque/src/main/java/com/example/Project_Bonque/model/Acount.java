package com.example.Project_Bonque.model;

public class Acount {

    private int acount_id;
    private int acount_numero;
    private double acount_solde;
    private String acount_type;



    public int getAcount_id() {
        return acount_id;
    }

    public void setAcount_id(int acount_id) {
        this.acount_id = acount_id;
    }

    public int getAcount_numero() {
        return acount_numero;
    }

    public void setAcount_numero(int acount_numero) {
        this.acount_numero = acount_numero;
    }

    public double getAcount_solde() {
        return acount_solde;
    }

    public void setAcount_solde(double acount_solde) {
        this.acount_solde = acount_solde;
    }
    public String getAcount_type() {
        return acount_type;
    }

    public void setAcount_type(String acount_type) {
        this.acount_type = acount_type;
    }

    public Acount(int acount_id, int acount_numero, double acount_solde, String acount_type) {
        this.acount_id = acount_id;
        this.acount_numero = acount_numero;
        this.acount_solde = acount_solde;
        this.acount_type = acount_type;
    }

    public Acount(int acount_numero, double acount_solde, String acount_type) {
        this.acount_numero = acount_numero;
        this.acount_solde = acount_solde;
        this.acount_type = acount_type;
    }
}
