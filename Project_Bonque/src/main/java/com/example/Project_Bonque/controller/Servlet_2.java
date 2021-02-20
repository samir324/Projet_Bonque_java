package com.example.Project_Bonque.controller;

import com.example.Project_Bonque.DAO.DAOAcount;
import com.example.Project_Bonque.DAOImpl.DAOImplAcount;
import com.example.Project_Bonque.model.Acount;
import com.example.Project_Bonque.model.Entreprise;
import com.example.Project_Bonque.model.Person;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static com.example.Project_Bonque.database.DataBaseConfi.connect;


// Servlet Name

@WebServlet("/")

public class Servlet_2 extends HttpServlet {
    private DAOAcount daoCompte;

    public Servlet_2() throws SQLException {
    }

    public void init() {
        daoCompte = new DAOImplAcount();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        PrintWriter out = response.getWriter();
        out.print("<br>");
        out.print("<h1>Liste des Entreprise</h1>");

        out.println("<table border='1'><tr><th>Id</th><th>Numero</th><th>Solde</th><th>Nom</th><th>Delete</th>");


        try {
            Connection con = connect();;
            Statement st= con.createStatement();
            ResultSet rs=st.executeQuery("select * from entreprise");
            while(rs.next()) {
                int id1  = rs.getInt(1);



                out.print("<tr><td>");
                out.println(rs.getInt(1));
                out.print("</td>");
                out.print("<td>");
                out.println(rs.getLong(2));
                out.print("</td>");
                out.print("<td>");
                out.println(rs.getDouble(3));
                out.print("</td>");
                out.print("<td>");
                out.println(rs.getString(6));
                out.print("</td>");
                out.print("<td>");
                out.print("<a href=delete?id=");
                out.println(id1);
                out.print(">");
                out.println("Delete");
                out.println("</a>");
                out.print("</td>");

                out.print("</tr>");
            }

        }catch(Exception e)
        {
            System.out.println(e);
        }
        out.print("</table>");

        out.print("<br>");
        out.print("<h1>Liste des Personnes</h1>");


        out.println("<table border='1'><tr><th>Id</th><th>Numero</th><th>Solde</th><th>Nom</th><th>Prenom</th><th>Delete</th>");


        try {
            Connection con = connect();;
            Statement st= con.createStatement();
            ResultSet rs=st.executeQuery("select * from personne");
            while(rs.next()) {
                int id1  = rs.getInt(1);


                out.print("<tr><td>");
                out.println(rs.getInt(1));
                out.print("</td>");
                out.print("<td>");
                out.println(rs.getLong(2));
                out.print("</td>");
                out.print("<td>");
                out.println(rs.getDouble(3));
                out.print("</td>");
                out.print("<td>");
                out.println(rs.getString(6));
                out.print("</td>");
                out.print("<td>");
                out.println(rs.getString(7
                ));
                out.print("</td>");
                out.print("<td>");
                out.print("<a href=delete?id=");
                out.println(id1);
                out.print(">");
                out.println("Delete");
                out.println("</a>");
                out.print("</td>");

                out.print("</tr>");
            }

        }catch(Exception e)
        {
            System.out.println(e);
        }
        out.print("</table>");



        String action = request.getServletPath();

        switch (action) {
            case "/":
                try {
                    compteList(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "/insertEntreprise":
                insertEntreprise(request, response);
                break;
            case "/insertPerson":
                insertPersone(request, response);
                break;
            case "/delete":
                delete(request, response);
                break;
            case "/update":
                update(request, response);
                break;
            default:
                break;
        }


    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private void updateEntreprise(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // String type = request.getParameter("type");
        double solde = Double.parseDouble(request.getParameter("solde"));
        int numero = Integer.parseInt(request.getParameter("numero"));
        String nom = request.getParameter("nom");
        int id = Integer.parseInt(request.getParameter("id"));

        Entreprise entreprise = new Entreprise(id, nom, numero, solde);

        try {
            daoCompte.updateEntreprise(entreprise);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.sendRedirect("index.jsp");
    }

    private void updatepersone(HttpServletRequest request, HttpServletResponse response) throws IOException {
        double solde = Double.parseDouble(request.getParameter("solde"));
        int numero = Integer.parseInt(request.getParameter("numero"));
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        int id = Integer.parseInt(request.getParameter("id"));
        String type = request.getParameter("type");
        Person persone = new Person(id, numero, type, nom,prenom);
        try {
            daoCompte.updatePersone(persone);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.sendRedirect("index.jsp");
    }


    private void deleteEntreprise(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int id = Integer.parseInt(request.getParameter("id"));


        try {
            daoCompte.deleteEntreprise(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.sendRedirect("index.jsp");

    }
    private void deletePersone(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int id = Integer.parseInt(request.getParameter("id"));


        try {
            daoCompte.deletePersone(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.sendRedirect("index.jsp");

    }

    private void compteList(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Acount> acountList = daoCompte.allAcount();
        request.setAttribute("acount", acountList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);

    }


    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String type = request.getParameter("type");
        double solde = Double.parseDouble(request.getParameter("solde"));
        int numero = Integer.parseInt(request.getParameter("numero"));

        int id = Integer.parseInt(request.getParameter("id"));
        Acount compte1 = new Acount(id, numero, solde, type);
        try {
            daoCompte.updateAcount(compte1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.sendRedirect("index.jsp");


    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int id = Integer.parseInt(request.getParameter("id"));


        try {
            daoCompte.deleteAcount(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.sendRedirect("index.jsp");

    }





    private void insertEntreprise(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String type = request.getParameter("type");
        double solde = Double.parseDouble(request.getParameter("solde"));
        int numero = Integer.parseInt(request.getParameter("numero"));
        String nom = request.getParameter("nom");
        Entreprise entreprise = new Entreprise( type,nom,numero, solde);
        try {
            daoCompte.insertAcountEntreprise(entreprise);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.sendRedirect("index.jsp");
    }

    private void insertPersone(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String type = request.getParameter("type");
        double solde = Double.parseDouble(request.getParameter("solde"));
        int numero = Integer.parseInt(request.getParameter("numero"));
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        Person persone = new Person(numero, type,nom,prenom,solde);
        try {
            daoCompte.insertAcountPerson(persone);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.sendRedirect("index.jsp");
    }








}


