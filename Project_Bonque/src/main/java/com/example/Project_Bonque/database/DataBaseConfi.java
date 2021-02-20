package com.example.Project_Bonque.database;


import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConfi {
    public static Connection connect() {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Databases", "bonque","1311");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }

        return con;
    }
}
