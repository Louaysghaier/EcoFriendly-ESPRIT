/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package evenement;
import java.sql.Date;
import java.util.List;
import models.Event;
import models.Participation;
import services.Eventservice;
import services.Participationservice;
import util.Myconnection;
/**
 *
 * @author Mekni
 */
public class Evenement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Myconnection aa= Myconnection.getInstance();
        
         Event event1 = new Event(
        "Salle de conférence A",
        new Date(System.currentTimeMillis()), // Date de début
        new Date(System.currentTimeMillis() + 3600000), // Date de fin (1 heure après le début)
        "100", // Nombre maximum de participants
        "25.00", // Prix du ticket
        "Conférence sur la technologie",
        "Conférence",
        "Une conférence informative sur les dernières technologies."
    );
         
         Event event2 = new Event(
    "Salle de réunion B",
    new Date(System.currentTimeMillis() + 86400000), // Date de début (1 jour après le début du premier événement)
    new Date(System.currentTimeMillis() + 90000000), // Date de fin (1 jour et 5 heures après le début)
    "50", // Nombre maximum de participants
    "15.00", // Prix du ticket
    "Atelier de développement",
    "Atelier",
    "Un atelier pratique sur le développement de logiciels."
);

         Event event3 = new Event(
    "Salle de conférence C",
    new Date(System.currentTimeMillis() + 172800000), // Date de début (2 jours après le début du premier événement)
    new Date(System.currentTimeMillis() + 187200000), // Date de fin (2 jours et 3 heures après le début)
    "200", // Nombre maximum de participants
    "10.00", // Prix du ticket
    "Salon de l'emploi",
    "Salon",
    "Un salon de l'emploi pour les professionnels de l'informatique."
);
         Event event4 = new Event(
    "Salle de conférence C",
    new Date(System.currentTimeMillis() + 172800000), // Date de début (2 jours après le début du premier événement)
    new Date(System.currentTimeMillis() + 187200000), // Date de fin (2 jours et 3 heures après le début)
    "200", // Nombre maximum de participants
    "10.00", // Prix du ticket
    "Salon de l'emploi",
    "Salon",
    "Un salon de l'emploi pour les professionnels de l'informatique."
);
         
         Event updatedEvent = new Event(
        5,
        "Nouveau lieu de l'événement",
        new Date(System.currentTimeMillis()), // Nouvelle date de début
        new Date(System.currentTimeMillis() + 7200000), // Nouvelle date de fin (2 heures après le début)
        "150", // Nouveau nombre maximum de participants
        "30.00", // Nouveau prix du ticket
        "Nouveau nom de l'événement",
        "Nouveau type d'événement",
        "Nouvelle description de l'événement"
    );


       Eventservice eventService = new Eventservice();
       
      // eventService.ajouterEvent(event4);
        //eventService.ajouterEvent(event2);
        // eventService.ajouterEvent(event3);
       
       //System.out.println(eventService.afficherEvent());
       //eventService.updateEvent(updatedEvent);
       //System.out.println(eventService.afficherEvent());
        
        
        
       // eventService.deleteEvent(5);
         //eventService.deleteEvent(7);
         
             Participation participation3 = new Participation(8, 2, "codeQR14") ;
             Participation participation2 = new Participation(10, 2, "codeQR14") ;
            // Participation participation2 = new Participation(2 ,1, 2, "QR123"); // Exemple d'ID d'événement, d'ID d'utilisateur et de code QR
                
           //  event2.addParticipation(event2, participation1);
         //    event2.addParticipation(event2, participation2);
              
    // Vérifiez si la participation a été ajoutée à la liste de participations de l'événement
  // List<Participation> participations = event2.getParticipations();


//event2.afficherParticipations();
Participationservice participationservice=new Participationservice();
//participationservice.ajouterParticipation(participation3);

           Participation participationToUpdate = new Participation(6,6, 4, "NouveauQRCode"); // Remplacez les valeurs par les données correctes

               // participationservice.updateParticipation(participationToUpdate);
            
                     //   participationservice.deleteParticipation(5);
                     //affichage
                      List<Participation> participations = participationservice.afficherParticipation();
                    for (Participation participation : participations) {
            System.out.println(participation);
        }


}

    }






    

