package com.example.Project_Bonque.DAOImpl;

import com.example.Project_Bonque.DAO.DAOAcount;
import com.example.Project_Bonque.model.Acount;
import com.example.Project_Bonque.model.Entreprise;
import com.example.Project_Bonque.model.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.example.Project_Bonque.database.DataBaseConfi.connect;

public class DAOImplAcount implements DAOAcount {



    private static final String INSERT = "INSERT INTO banque.acount " + "  (acount_type, acount_numero, acount_solde) VALUES (?, ?, ?)";
    private static String SELECT= "select acount_type,acount_numero,acount_solde from banque.acount where acount_type =?";
    private static final String SELECT_ALL = "select * from banque.acount";
    private static final String DELETE = "delete from acount where acount_id = ?";
    private static final String UPDATE = "update acount set acount_type = ?,acount_numero= ?, acount_solde =? where acount_id = ?";

    private static final String INSERT_ENTREPRISE = "INSERT INTO entreprese" + "  (acount_numero, acount_solde, entreprise_nom) VALUES (?, ?, ?)";
    private static final String INSERT_PERSONNE = "INSERT INTO personne" + "  (acount_numero, acount_solde, personne_nom, personne_prenom) VALUES (?, ?, ?, ?, ?)";


    private static final String DELETE_PERSONNE = "delete from personne where acount_id = ?";
    private static final String DELETE_ENTREPRISE= "delete from entreprese where acount_id = ?";
    private static final String UPDATE_PERSONNE = "update personne set acount_numero = ?,acount_solde= ?, personne_nom =? , personne_prenom =? where acount_id = ?";
    private static final String UPDATE_ENTREPRISE= "update entreprese set acount_numero = ?,acount_solde= ?, entr_nom =? where acount_id = ?";


    public void insertAcountEntreprise(Entreprise entreprise) throws SQLException {
        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ENTREPRISE)) {
            preparedStatement.setString(1, entreprise.getAcount_type());
            preparedStatement.setString(4, entreprise.getEntreprise_nom());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }


    public void insertAcountPersone(Person personne) throws SQLException {
        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PERSONNE)) {
             preparedStatement.setString(1, personne.getAcount_type());
             preparedStatement.setInt(2, personne.getAcount_numero());
             preparedStatement.setDouble(3, personne.getPerson_solde());
             preparedStatement.setString(4, personne.getPerson_nom());
             preparedStatement.setString(5, personne.getPerson_prenom());
             preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }



    public void updateCompte(Acount acount) throws SQLException {
        try (Connection connection = connect();
             PreparedStatement statement = connection.prepareStatement(UPDATE);) {
            statement.setString(1, acount.getAcount_type());
            statement.setLong(2, acount.getAcount_numero());
            statement.setDouble(3, acount.getAcount_solde());
            statement.setInt(4, acount.getAcount_id());
            statement.executeUpdate();
        }

    }

    @Override
    public void updateAcount(Acount acount) throws SQLException {

    }

    public void deleteAcount(int id) throws SQLException {
        try (Connection connection = connect();
             PreparedStatement statement = connection.prepareStatement(DELETE);) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }


    public Acount selectAcountType(String type) {
        Acount acount = null;
        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT);) {
            preparedStatement.setString(1, type);
            //System.out.println(preparedStatement);
            ResultSet Result = preparedStatement.executeQuery();
            while (Result.next()) {
                String acount_type = Result.getString("acount_type");
                int acount_numero = Result.getInt("acount_numero");
                double acount_solde = Result.getDouble("acount_solde");
                acount = new Acount(acount_numero , acount_solde, acount_type);
            }
        } catch (SQLException e) {

        }
        return acount;
    }

    public void updatePersone(Person persone) throws SQLException {
        try (Connection connection = connect();
             PreparedStatement statement = connection.prepareStatement(UPDATE_PERSONNE);) {
            statement.setLong(1, persone.getAcount_numero());
            statement.setDouble(2, persone.getPerson_solde());
            statement.setString(3, persone.getPerson_nom());
            statement.setString(4, persone.getPerson_prenom());
            statement.setInt(5, persone.getPerson_id());
            statement.executeUpdate();
        }

    }
    public void updateEntreprise(Entreprise entreprise) throws SQLException {
        try (Connection connection = connect();
             PreparedStatement statement = connection.prepareStatement( UPDATE_ENTREPRISE);) {
            statement.setLong(1, entreprise.getAcount_numero());
            statement.setDouble(2, entreprise.getEntreprise_solde());
            statement.setString(3, entreprise.getEntreprise_nom());
            statement.setInt(4, entreprise.getEntreprise_id());
            statement.executeUpdate();
        }

    }

    public void deletePersone(int id) throws SQLException {
        try (Connection connection = connect();
             PreparedStatement statement = connection.prepareStatement(DELETE_PERSONNE);) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
    public void deleteEntreprise(int id) throws SQLException {
        try (Connection connection = connect();
             PreparedStatement statement = connection.prepareStatement(DELETE_ENTREPRISE);) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }


    public List<Acount> allAcount() throws SQLException {
        List<Acount> acounts = new ArrayList<>();
        Connection connection = connect();;
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
        {
            ResultSet Result = preparedStatement.executeQuery();
            while (Result.next()) {
                while (Result.next()) {
                    int acount_id = Result.getInt("acount_id");
                    String acount_type = Result.getString("acount_type");
                    int acount_numero = Result.getInt("acount_numero");
                    double acount_solde = Result.getDouble("acount_solde");
                    acounts.add(new Acount(acount_id, acount_numero, acount_solde, acount_type));

                }
            }
            return acounts;
        }
    }

    @Override
    public void insertAcountPerson(Person personne) throws SQLException {

    }


}




