/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

/**
 *
 * @author Dorra
 */
public class myconnection {
   
    
    //DB Credentials
    final String URL = "jdbc:mysql://localhost:3306/bibliotheque";
    final String USR = "root";
    final String PWD = "";
    
    //var
    Connection cnx;
    static myconnection instance;

    private myconnection() {
        try {
            cnx = DriverManager.getConnection(URL, USR, PWD);
            System.out.println("Connexion etablie avec succes!");
        } catch (SQLException ex) {
            Logger.getLogger(myconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public static myconnection getInstance() {
        if(instance == null)
            instance = new myconnection();
        return instance;
    }

    public Connection getCnx() {
        return cnx;
    }

    
    public Connection getconnection() {
    return cnx;
}
    
}
