/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Logan
 */
public class GestionSQL {
    private static ArrayList<Client> listeClients;
    private static Client unClient;
    
    private static Connection conn;
    private static Statement stmt;
    private static ResultSet rs;
    private static String pilote = "org.gjt.mm.mysql.Driver";
    private static String url = new String("jdbc:mysql://localhost/symfony5_formarmor");
    
    public static ArrayList<Client> ListeDesClients()
    {
        try
        {
            listeClients = new ArrayList<Client>();
            Class.forName(pilote);           			            
            conn = DriverManager.getConnection(url,"root","");
            stmt = conn.createStatement();			            
            rs = stmt.executeQuery("select * from client");
            while (rs.next())
            {
                unClient = new Client(rs.getInt("id"), rs.getString("nom"), rs.getString("tel"));
                listeClients.add(unClient);
            }
            rs.close();
            stmt.close();
            conn.close();
            return listeClients;
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
            return null;
        }
        catch (ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static ArrayList<Client> ListeDesClients(String libelle) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}