/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Events;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Event;
import models.Participation;
import services.Eventservice;
import services.Participationservice;
import services.Userservice;
import util.Myconnection;

/**
 * FXML Controller class
 *
 * @author Mekni
 */
public class AfficheEventController implements Initializable {

    
    
   

//
//    public void setEventToUpdate(int selectedEventId) {
//        this.selectedEventId = selectedEventId;
//    }
//    public void updateEvent(ActionEvent event) {
//    int eventId = selectedEventId;
//    int userId = 2;
//
//    String newNomEvent = upeventname.getText();
//    String newLieuEvent = lieueventup.getText();
//    String newDuree = dureeup.getText();
//    LocalDate newDateDebut = datedebutup.getValue();
//    String newPrixTicket = ticketpriceup.getText();
//    String newNbMaxParticipants = nbmaxparticipationup.getText();
//    String newTypeEvent = (String) eventtypeup.getValue();
//    String newDescriptionEvent = eventdescriptionup.getText();
//    String newImagePath = getData.path;
//
//    if (newNomEvent.isEmpty() || newLieuEvent.isEmpty() || newDuree.isEmpty() || newDateDebut == null
//        || newPrixTicket.isEmpty() || newNbMaxParticipants.isEmpty() || newTypeEvent.isEmpty() || newDescriptionEvent.isEmpty()) {
//        showAlert(Alert.AlertType.ERROR, "Champs vides", "Veuillez remplir tous les champs obligatoires.");
//        return;
//    }
//
//    Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
//    confirmationAlert.setTitle("Confirmation");
//    confirmationAlert.setHeaderText("Confirmer la mise à jour");
//    confirmationAlert.setContentText("Êtes-vous sûr de vouloir mettre à jour l'événement ?");
//
//    Optional<ButtonType> result = confirmationAlert.showAndWait();
//    if (result.isPresent() && result.get() == ButtonType.OK) {
//        Event updatedEvent = new Event();
//        updatedEvent.setIdEvent(eventId);
//        updatedEvent.setNomEvent(newNomEvent);
//        updatedEvent.setLieuEvent(newLieuEvent);
//        updatedEvent.setDurée(newDuree);
//        updatedEvent.setDateDebutEvent(java.sql.Date.valueOf(newDateDebut));
//        updatedEvent.setPrixTicket(Double.parseDouble(newPrixTicket));
//        updatedEvent.setNbmaxParticipant(Integer.parseInt(newNbMaxParticipants));
//        updatedEvent.setTypeEvent(newTypeEvent);
//        updatedEvent.setDescriptionEvent(newDescriptionEvent);
//        updatedEvent.setImage(newImagePath);
//
//        Eventservice eventService = new Eventservice();
//        eventService.updateEvent(updatedEvent, userId);
//        
//      
//        
//
//
//        showAlert(Alert.AlertType.INFORMATION, "Succès", "L'événement a été mis à jour avec succès.");
//    
//        // L'utilisateur a annulé la mise à jour, vous pouvez ajouter du code ici si nécessaire
//    }
//}


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    
//         paginat.setPageFactory(this::changePage);
            // menuDisplayCard();
       
    }    

//private void showEventCardByName(ActionEvent event) {
//    // Récupérez le nom de l'événement à partir de la zone de recherche
//    String eventName = SEARCH.getText().trim().toLowerCase();
//
//    // Parcourez toutes les cartes d'événements
//    for (Node card : vboxxx.getChildren()) {
//        if (card instanceof AnchorPane) {
//            AnchorPane eventCard = (AnchorPane) card;
//
//            // Recherchez le label "eventName" dans la carte d'événement
//            Label EventName = (Label) eventCard.lookup("#EventName");
//
//            if (EventName != null) {
//                String cardEventName = EventName.getText().trim().toLowerCase();
//
//                if (cardEventName.equals(eventName)) {
//                    // Affichez la carte d'événement correspondante
//                    eventCard.setVisible(true);
//                    eventCard.setManaged(true);
//                } else {
//                    // Masquez les autres cartes d'événements
//                    eventCard.setVisible(false);
//                    eventCard.setManaged(false);
//                }
//            }
//        }
//    }

//










}
