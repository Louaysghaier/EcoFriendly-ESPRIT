package util;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rayen
 */
public class Myconnection {
    
    //DB Credentials
    final String URL = "jdbc:mysql://localhost:3306/event";
    final String USR = "root";
    final String PWD = "";
    
    //var
    Connection cnx;
    static Myconnection instance;

    public Myconnection() {
        try {
            cnx = DriverManager.getConnection(URL, USR, PWD);
            System.out.println("Connexion etablie avec succes!");
        } catch (SQLException ex) {
            Logger.getLogger(Myconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public static Myconnection getInstance() {
        if(instance == null)
            instance = new Myconnection();
        return instance;
    }

    public Connection getCnx() {
        return cnx;
    }
}
