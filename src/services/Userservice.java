/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.User;
import util.Myconnection;

/**
 *
 * @author Mekni
 */
public class Userservice {
    
     Myconnection Mycnx = Myconnection.getInstance();
    Connection cnx = Mycnx.getCnx();
    
    public int getUserIdById(int idUser) {
    String req = "SELECT iduser FROM user WHERE iduser = ?";
    int userId = -1;

    try {
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1, idUser);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            userId = rs.getInt("iduser");
        }
    } catch (SQLException ex) {
        Logger.getLogger(Userservice.class.getName()).log(Level.SEVERE, null, ex);
    }

    return userId;
}

    
    public User getUserByIdd(int idUser) {
    String req = "SELECT * FROM user WHERE iduser = ?";
    User user = null;

    try {
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1, idUser);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            user = new User();
            user.setIduser(rs.getInt("iduser"));
            user.setUsername(rs.getString("username"));
             user.setWallet(rs.getDouble("wallet"));
            // Assignez d'autres propriétés de l'utilisateur en fonction de votre modèle User
        }
    } catch (SQLException ex) {
        Logger.getLogger(Userservice.class.getName()).log(Level.SEVERE, null, ex);
    }

    return user;
}
    
    
    
    
    
    
    
    
    public User getUserById(int idUser) {
    String req = "SELECT * FROM user WHERE iduser = ?";
    User user = null;

    try {
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1, idUser);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            user = new User();
            user.setIduser(rs.getInt("iduser"));
            user.setUsername(rs.getString("username"));
            
            // Assignez d'autres propriétés de l'utilisateur en fonction de votre modèle User
        }
    } catch (SQLException ex) {
        Logger.getLogger(Userservice.class.getName()).log(Level.SEVERE, null, ex);
    }

    return user;
}
    
    
    
    
    
    

   public String getUsernameById(int userId) {
    String req = "SELECT username FROM user WHERE iduser = ?";
    String username = null;

    try {
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1, userId);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            username = rs.getString("username");
        }  
    } catch (SQLException ex) {
        Logger.getLogger(Userservice.class.getName()).log(Level.SEVERE, null, ex);
    }

    return username;
}
 
    
public void updateUserWallet(int userId, double newWalletAmount) {
    String query = "UPDATE user SET wallet = ? WHERE iduser = ?";

    try (PreparedStatement statement = cnx.prepareStatement(query)) {
        statement.setDouble(1, newWalletAmount);
        statement.setInt(2, userId);

        // Exécutez la mise à jour de la base de données
        statement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
        // Gérez les exceptions SQL ici
    }
}

    public double getUserWalletById(int userId) {
    String query = "SELECT wallet FROM user WHERE iduser = ?";
    double wallet = 0.0; // Valeur par défaut si l'utilisateur n'est pas trouvé ou en cas d'erreur

    try (PreparedStatement statement = cnx.prepareStatement(query)) {
        statement.setInt(1, userId);
        ResultSet rs = statement.executeQuery();

        if (rs.next()) {
            wallet = rs.getDouble("wallet");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        // Gérez les exceptions SQL ici
    }

    return wallet;
}

    
    
}

