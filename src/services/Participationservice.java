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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Event;
import models.Participation;
import util.Myconnection;

/**
 *
 * @author Mekni
 */
public class Participationservice {
    
    Myconnection Mycnx = Myconnection.getInstance();
    Connection cnx = Mycnx.getCnx();
    
    
    public boolean evenementExiste(int idEvent) {
    String req = "SELECT COUNT(*) FROM event WHERE idEvent = ?";
    
    try {
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1, idEvent);
        
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            int count = rs.getInt(1);
            return count > 0; // Si count est supérieur à 0, l'événement existe, sinon il n'existe pas
        }
    } catch (SQLException ex) {
        Logger.getLogger(Eventservice.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return false; // En cas d'erreur ou si l'événement n'a pas été trouvé
}
    
    
    
    public void ajouterParticipation(Participation participation) {
    int idEvent = participation.getIdEvent();

    if (evenementExiste(idEvent)) {
        // L'événement existe, vous pouvez maintenant ajouter la participation
        String req ="INSERT INTO `participation` (`idEvent`, `idUser`, `codeQR`) VALUES (?, ?, ?)";

        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            
             ps.setInt(1, participation.getIdEvent());
            ps.setInt(2, participation.getIdUser());
            ps.setString(3, participation.getCodeQR());
            ps.executeUpdate();
            System.out.println("Participation ajoutée avec succès !");
        } catch (SQLException ex) {
            Logger.getLogger(Participationservice.class.getName()).log(Level.SEVERE, null, ex);
        }
    } else {
        System.err.println("Erreur : L'événement avec idEvent " + idEvent + " n'existe pas.");
    }
}
    
public void updateParticipation(Participation participation) {
    int idParticipation = participation.getIdParticipation();
    int idEvent = participation.getIdEvent();

    // Vérifiez d'abord si la participation existe
    if (participationExiste(idParticipation)) {
        // Vérifiez ensuite si l'événement associé existe
        if (evenementExiste(idEvent)) {
            // Les deux existent, vous pouvez maintenant effectuer la mise à jour
            String req = "UPDATE participation SET  idUser = ?, codeQR = ? WHERE idParticipation = ?";

            try {
                PreparedStatement ps = cnx.prepareStatement(req);
              
                ps.setInt(1, participation.getIdUser());
                ps.setString(2, participation.getCodeQR());
                ps.setInt(3, idParticipation); 
               

                int res = ps.executeUpdate();

                if (res > 0) {
                    System.out.println("Participation mise à jour avec succès !");
                } else {
                    System.err.println("Erreur lors de la mise à jour de la participation.");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Participationservice.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.err.println("Erreur : L'événement avec idEvent " + idEvent + " n'existe pas.");
        }
    } else {
        System.err.println("Erreur : La participation avec idParticipation " + idParticipation + " n'existe pas.");
    }
}
public boolean participationExiste(int idParticipation) {
    String req = "SELECT COUNT(*) FROM participation WHERE idParticipation = ?";

    try {
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1, idParticipation);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            int count = rs.getInt(1);
            return count > 0; // Si count est supérieur à 0, la participation existe, sinon elle n'existe pas
        }
    } catch (SQLException ex) {
        Logger.getLogger(Participationservice.class.getName()).log(Level.SEVERE, null, ex);
    }

    return false; // En cas d'erreur ou si la participation n'a pas été trouvée
}


   public void deleteParticipation(int idParticipation){
       String req = "Delete FROM participation where idParticipation=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1,idParticipation);          
            
             int result = ps.executeUpdate();

        if (result == 0) {
            System.out.println("Event with ID " + idParticipation + " does not exist.");
        } else {
            System.out.println("Event with ID " + idParticipation + " has been deleted successfully!");
        }
            
        } catch (SQLException ex) {
            Logger.getLogger(Eventservice.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
   
    public List<Participation> afficherParticipation() {
    List<Participation> participations = new ArrayList<>();
    String req = "SELECT * FROM participation";
    
    try {
        Statement st = cnx.createStatement();
        ResultSet rs = st.executeQuery(req);
        
        while (rs.next()) {

             Participation participation = new Participation(
                rs.getInt("idParticipation"),
               
                rs.getInt("idEvent"),
                 rs.getInt("iduser"),
              
                rs.getString("codeqr")
                
            );
            
            participations.add(participation);
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(Eventservice.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return participations;
}
   
   

}
    
    
    
    
    
    
    
    
    
    
    
    

