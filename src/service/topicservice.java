
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.topic;
import util.myconnection;

/**
 *
 * @author Dorra
 */

    public class topicservice implements IService<topic> {
Connection cnx ;

public topicservice(){
    this.cnx= myconnection.getInstance().getconnection();
}

    @Override
    public void ajouter(topic t) {
        try {
            String req = "INSERT INTO `topic`( `idtopic`, `name`) VALUES ('" + t.getidtopic() + "','" + t.getname() + "')";
            
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
   public void modifier(topic t) {
    try {
                String req = "UPDATE `documents` SET `name` = ?";
        PreparedStatement preparedStatement = cnx.prepareStatement(req);
        
        preparedStatement.setString(2, t.getname());
        /*preparedStatement.setInt(3, t.getId());
*/
        int rowCount = preparedStatement.executeUpdate();
        
        if (rowCount > 0) {
            System.out.println("topic modifié avec succès.");
        } else {
            System.out.println("Aucun document correspondant n'a été trouvé pour la mise à jour.");
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
}


    @Override
    public void supprimer(int idtopic) {
        String req = "DELETE FROM documents WHERE idtopic = ?";
        PreparedStatement preparedStatement = null;
    try {
        preparedStatement = cnx.prepareStatement(req);
    } catch (SQLException ex) {
        Logger.getLogger(topicservice.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        preparedStatement.setInt(1, idtopic);
    } catch (SQLException ex) {
        Logger.getLogger(documentsservice.class.getName()).log(Level.SEVERE, null, ex);
    }

    try {
        // Exécutez la requête SQL
        preparedStatement.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(documentsservice.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
  public topic getOne(topic t) {
    try {
      
        String req = "SELECT * FROM `topic` WHERE `nom` = ?";
        PreparedStatement preparedStatement = cnx.prepareStatement(req);
        preparedStatement.setString(1, t.getname());
     

        ResultSet resultSet = preparedStatement.executeQuery();
        
        if (resultSet.next()) {
          topic foundtopic = new topic();
            foundtopic.setidtopic(resultSet.getInt("idtopic"));
          foundtopic.setname(resultSet.getString("name"));
          
            
            return foundtopic; 
        } else {
            return null; 
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
        return null;
    }
}


    @Override
    public List<topic> getAll() {
      String req = "SELECT * FROM `topic`";
      ArrayList<topic> listetopic= new ArrayList();
    Statement stm;
    try {
        stm = this.cnx.createStatement();
    
    
        ResultSet rs=  stm.executeQuery(req);
    while (rs.next()){
        topic to = new topic();
        to.setidtopic(rs.getInt(1));
        to.setname(rs.getString("name"));
      
        
        listetopic.add(to);
    }
        
        
    } catch (SQLException ex) {
    
        System.out.println(ex.getMessage());
    
    }
    return listetopic;
    }

    
}


