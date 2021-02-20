package com.example.Project_Bonque.DAO;

import com.example.Project_Bonque.model.Acount;
import com.example.Project_Bonque.model.Entreprise;
import com.example.Project_Bonque.model.Person;
import java.sql.SQLException;
import java.util.List;

public interface DAOAcount {

    // public void insertAcount(Acount Acount) throws SQLException;
    public void updateAcount(Acount acount) throws SQLException;
    public void deleteAcount(int acount_id) throws SQLException;
    public Acount selectAcountType(String acount_type);
    public List<Acount> allAcount() throws SQLException;
    public void insertAcountPerson(Person personne ) throws SQLException;
   // public void insertAcountEntreprise(Entreprise entreprise) throws SQLException;
    public void insertAcountEntreprise(Entreprise entreprise) throws SQLException;
    public void deleteEntreprise(int id) throws SQLException;
    public void deletePersone(int id) throws SQLException;

    public void updatePersone(Person persone) throws SQLException ;
    public void updateEntreprise(Entreprise entreprise) throws SQLException;

}


