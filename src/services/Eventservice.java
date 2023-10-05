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
public class Eventservice {
    
    Myconnection Mycnx = Myconnection.getInstance();
    Connection cnx = Mycnx.getCnx();
    
    //Add 1
  
    
    //Add 2
    public void ajouterEvent(Event p){
       String req = "INSERT INTO `event`(`LieuEvent`, `dateDebutEvent`, `dateFinEvent`, `nbmaxParticipant`, `PrixTicket`, `nomEvent`, `typeEvent`, `descriptionEvent`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
           ps.setString(1, p.getLieuEvent());
        ps.setDate(2, p.getDateDebutEvent());
        ps.setDate(3, p.getDateFinEvent());
        ps.setString(4, p.getNbmaxParticipant());
        ps.setString(5, p.getPrixTicket());
        ps.setString(6, p.getNomEvent());
        ps.setString(7, p.getTypeEvent());
        ps.setString(8, p.getDescriptionEvent());
            ps.executeUpdate();
            System.out.println("event ajoutée avec succes!");
        } catch (SQLException ex) {
            Logger.getLogger(Eventservice.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //           Event event = new Event(); 
//            event.setIdEvent((rs.getInt(1)));
//            event.setLieuEvent(rs.getString("LieuEvent"));
//            event.setDateDebutEvent(rs.getDate("dateDebutEvent"));
//            event.setDateFinEvent(rs.getDate("dateFinEvent"));
//            event.setNbmaxParticipant(rs.getString("nbmaxParticipant"));
//            event.setPrixTicket(rs.getString("PrixTicket"));
//            event.setNomEvent(rs.getString("nomEvent"));
//            event.setTypeEvent(rs.getString("typeEvent"));
//            event.setDescriptionEvent(rs.getString("descriptionEvent"));
      public List<Event> afficherEvent() {
    List<Event> evenements = new ArrayList<>();
    String req = "SELECT * FROM event";
    
    try {
        Statement st = cnx.createStatement();
        ResultSet rs = st.executeQuery(req);
        
        while (rs.next()) {

             Event event = new Event(
                rs.getInt("idEvent"),
                rs.getString("LieuEvent"),
                rs.getDate("dateDebutEvent"),
                rs.getDate("dateFinEvent"),
                rs.getString("nbmaxParticipant"),
                rs.getString("PrixTicket"),
                rs.getString("nomEvent"),
                rs.getString("typeEvent"),
                rs.getString("descriptionEvent")
            );
            
            evenements.add(event);
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(Eventservice.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return evenements;
}
      
        public void deleteEvent(int idEvent){
       String req = "Delete FROM event where idEvent=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1,idEvent);          
            
             int result = ps.executeUpdate();

        if (result == 0) {
            System.out.println("Event with ID " + idEvent + " does not exist.");
        } else {
            System.out.println("Event with ID " + idEvent + " has been deleted successfully!");
        }
            
        } catch (SQLException ex) {
            Logger.getLogger(Eventservice.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
          public void updateEvent(Event updatedEvent) {
    String req = "UPDATE event SET LieuEvent=?, dateDebutEvent=?, dateFinEvent=?, nbmaxParticipant=?, PrixTicket=?, nomEvent=?, typeEvent=?, descriptionEvent=? WHERE idEvent=?";
    try {
        PreparedStatement ps = cnx.prepareStatement(req);
        
        ps.setString(1, updatedEvent.getLieuEvent());
        ps.setDate(2, updatedEvent.getDateDebutEvent());
        ps.setDate(3, updatedEvent.getDateFinEvent());
        ps.setString(4, updatedEvent.getNbmaxParticipant());
        ps.setString(5, updatedEvent.getPrixTicket());
        ps.setString(6, updatedEvent.getNomEvent());
        ps.setString(7, updatedEvent.getTypeEvent());
        ps.setString(8, updatedEvent.getDescriptionEvent());
        
        // Assurez-vous d'obtenir l'ID de l'événement que vous souhaitez mettre à jour
        ps.setInt(9, updatedEvent.getIdEvent());
        
        int res = ps.executeUpdate();

        if (res== 0) {
 System.out.println("Event with ID " + updatedEvent.getIdEvent() + " does not exist.");
           
        } else {
 System.out.println("Event with ID " + updatedEvent.getIdEvent() + " has been updated successfully!");
           
        }
    } catch (SQLException ex) {
        Logger.getLogger(Eventservice.class.getName()).log(Level.SEVERE, null, ex);
    }
}
        
      

        
}
