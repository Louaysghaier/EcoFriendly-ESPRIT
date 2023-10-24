/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package evenement;

import GUI_Events.AjoutController;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import models.Event;
import models.Participation;
import models.User;
import services.Eventservice;
import services.Participationservice;
import services.Userservice;
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
        
        
       Eventservice eventService = new Eventservice();
       
//
User user = new User(2, "med");
////user.setIduser(1); // Assurez-vous que l'ID correspond à l'utilisateur existant dans votre base de données
//
//Event event5 = new Event();
//event5.setNomEvent("Fête d'été");
//event5.setDateDebutEvent(new Date(System.currentTimeMillis()));
//event5.setDurée(4);
//event5.setLieuEvent("Parc central");
//event5.setPrixTicket(10.0);
//event5.setNbmaxParticipant(100);
//event5.setTypeEvent("Fête en plein air");
//event5.setDescriptionEvent("Une fête d'été amusante pour toute la famille !");

//event5.setUser(user);
//eventService.ajouterEvent(event5, user);

//    Event event1 = new Event();
//    event1.setNomEvent("Soirée de Gala");
//    event1.setDateDebutEvent(new Date(System.currentTimeMillis()));
//    event1.setDurée(5);
//    event1.setLieuEvent("Hôtel de Luxe");
//    event1.setPrixTicket(50.0);
//    event1.setNbmaxParticipant(200);
//    event1.setTypeEvent("Gala élégant");
//    event1.setDescriptionEvent("Une soirée de gala pour une occasion spéciale.");
//    event1.setImage(System.getProperty("user.home") + "/Desktop/gala.jpg");
//    event1.setUser(user);
//    eventService.ajouterEvent(event1, user);
//
//    // Événement 2 : Randonnée en montagne
//    Event event2 = new Event();
//    event2.setNomEvent("Randonnée en montagne");
//    event2.setDateDebutEvent(new Date(System.currentTimeMillis()));
//    event2.setDurée(6);
//    event2.setLieuEvent("Montagnes pittoresques");
//    event2.setPrixTicket(20.0);
//    event2.setNbmaxParticipant(50);
//    event2.setTypeEvent("Aventure en plein air");
//    event2.setDescriptionEvent("Une randonnée en montagne avec des paysages à couper le souffle.");
//    event2.setImage(System.getProperty("user.home") + "/Desktop/randonnee.jpg");
//    event2.setUser(user);
//    eventService.ajouterEvent(event2, user);
//
//    // Événement 3 : Atelier de cuisine
//    Event event3 = new Event();
//    event3.setNomEvent("Atelier de cuisine");
//    event3.setDateDebutEvent(new Date(System.currentTimeMillis()));
//    event3.setDurée(3);
//    event3.setLieuEvent("École de cuisine locale");
//    event3.setPrixTicket(30.0);
//    event3.setNbmaxParticipant(15);
//    event3.setTypeEvent("Cours de cuisine interactif");
//    event3.setDescriptionEvent("Apprenez à cuisiner des plats délicieux avec nos chefs expérimentés.");
//    event3.setImage(System.getProperty("user.home") + "/Desktop/cuisine.jpg");
//    event3.setUser(user);
//    eventService.ajouterEvent(event3, user);
//
//
//
//
//
//List<Event> events = eventService.afficherEvents();
//    for (Event e : events) {
//        System.out.println("ID: " + e.getIdEvent());
//        System.out.println("Nom: " + e.getNomEvent());
//        System.out.println("Date de début: " + e.getDateDebutEvent());





//int eventIdToDelete = 13;
  //  eventService.deleteEvent(eventIdToDelete);
//Event eventToUpdate = eventService.getEventById(11); // Remplacez "11" par l'ID de l'événement que vous souhaitez mettre à jour

//if (eventToUpdate != null) {
    // Mettez à jour les propriétés de eventToUpdate
  //  eventToUpdate.setLieuEvent("Nouvel emplacement");
    //eventToUpdate.setPrixTicket(15.0);
    
   // eventService.updateEvent(eventToUpdate);
//} else {
  //  System.out.println("L'événement avec l'ID spécifié n'a pas été trouvé.");
//}

//Eventservice eventService1 = new Eventservice();

//Participationservice p=new Participationservice();
// Event event5 = eventService.getEventById(5);
////        if (event5 != null) {
//            // L'événement existe, vous pouvez ajouter une participation
//            User user = new User(2, "nom_utilisateur"); // Assurez-vous que l'ID correspond à l'utilisateur que vous souhaitez associer
//
//            Participation participation = new Participation();
//            participation.setEvent(event5);
//            participation.setUser(user);
//            participation.setCodeQR("CodeQR123"); // Code QR de la participation (si nécessaire)
//
//            p.ajouterParticipation(participation);
//        } else {
//            System.err.println("Erreur : L'événement associé à la participation n'existe pas.");
//        }
//    

///////////////////////////////////////////////////////////////////////////////////////
//  int participationIdToDelete = 4;
//    p.deleteParticipation(participationIdToDelete);


/////////////////////////////////////////////////////////////////////////////////////
//Event event = eventService.getEventById(16);

    // Créez une nouvelle participation
   // Participation participation = new Participation(5, event, user, "NouveauCodeQR");

    // Mettez à jour la participation
   // p.updateParticipation(participation);

    
    
    
    
    
    
    
    Userservice U = new Userservice();
int currentUserId = U.getUserIdById(2); // Remplacez 2 par l'ID de l'utilisateur actuellement connecté
List<Event> userEvents = eventService.afficherEventsByUser(currentUserId);
























int idUserToRetrieve=2;
   List<List<String>> eventInfoList = eventService.getEventNamesByUser(idUserToRetrieve);

    System.out.println("Liste des événements pour l'utilisateur avec l'ID " + idUserToRetrieve + ":");

    for (List<String> eventInfo : eventInfoList) {
        String username = eventInfo.get(0);
        String eventName = eventInfo.get(1);
        String eventCount = eventInfo.get(2);

        System.out.println("Utilisateur : " + username);
        System.out.println("Nom de l'événement : " + eventName);
        System.out.println("Nombre total d'événements : " + eventCount);
        System.out.println("-------------------------");
    }
}









//
//
//
//














    }









    

