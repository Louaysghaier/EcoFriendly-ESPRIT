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
import models.documents;
import util.myconnection;
/**
 *
 * @author Dorra
 */
 public class documentsservice implements IService<documents> {
Connection cnx ;

public documentsservice(){
    this.cnx= myconnection.getInstance().getconnection();
}

    @Override
    public void ajouter(documents d) {
        try {
            String req = "INSERT INTO `documents`( `type`, `titre`) VALUES ('dorra" + d.getType() + "','mezyana" + d.getTitre() + "')";
            
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
   public void modifier(documents d) {
    try {
                String req = "UPDATE `documents` SET `titre` = ?, `type` = ?  WHERE `id` = ?";
        PreparedStatement preparedStatement = cnx.prepareStatement(req);
        preparedStatement.setString(1, d.getTitre());
        preparedStatement.setString(2, d.getType());
        preparedStatement.setInt(3, d.getId());

        int rowCount = preparedStatement.executeUpdate();
        
        if (rowCount > 0) {
            System.out.println("Document modifié avec succès.");
        } else {
            System.out.println("Aucun document correspondant n'a été trouvé pour la mise à jour.");
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
}


    @Override
    public void supprimer(int id) {
        String req = "DELETE FROM documents WHERE id = ?";
        PreparedStatement preparedStatement = null;
    try {
        preparedStatement = cnx.prepareStatement(req);
    } catch (SQLException ex) {
        Logger.getLogger(documentsservice.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        preparedStatement.setInt(1, id);
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
  public documents getOne(documents d) {
    try {
      
        String req = "SELECT * FROM `documents` WHERE `titre` = ? AND `type` = ?";
        PreparedStatement preparedStatement = cnx.prepareStatement(req);
        preparedStatement.setString(1, d.getTitre());
        preparedStatement.setString(2, d.getType());

        ResultSet resultSet = preparedStatement.executeQuery();
        
        if (resultSet.next()) {
            documents foundDocument = new documents();
            foundDocument.setId(resultSet.getInt("id"));
            foundDocument.setTitre(resultSet.getString("titre"));
            foundDocument.setType(resultSet.getString("type"));
            
            return foundDocument; 
        } else {
            return null; 
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
        return null;
    }
}


    @Override
    public List<documents> getAll() {
      String req = "SELECT * FROM `documents`";
      List<documents> listedocuments= new ArrayList();
    Statement stm;
    try {
        stm = this.cnx.createStatement();
    
    
        ResultSet rs=  stm.executeQuery(req);
    while (rs.next()){
        documents de = new documents();
        de.setId(rs.getInt(1));
        de.setTitre(rs.getString("titre"));
        de.setType(rs.getString(3));
        
        
        listedocuments.add(de);
    }
     if (stm != null) {
            stm.close();
        }
    
    
    

        
        
    } catch (SQLException ex) {
    
        System.out.println(ex.getMessage());
    
    }
    return listedocuments;
    }

    
}
