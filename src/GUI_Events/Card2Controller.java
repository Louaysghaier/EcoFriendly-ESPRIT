/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Events;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.Event;
import services.Eventservice;

/**
 * FXML Controller class
 *
 * @author Mekni
 */
public class Card2Controller implements Initializable {

    @FXML
    private AnchorPane cardevent;
    @FXML
    private Label evname1;
    @FXML
    private Label date1;
    @FXML
    private Label prix1;
    @FXML
    private Label lieu1;
    @FXML
    private Label nb1;
    @FXML
    private Label type1;
    @FXML
    private Button delete1;
    @FXML
    private Button update1;
    @FXML
    private Label description1;
    @FXML
    private ImageView im1;

    
    
    private Image image;
    
    private int idEvent;
public void setData1(int eventId, String eventName, double ticketPrice, String imagePath ,String lieu, int nbrmax, String type, String description ,Date date) {
    this.idEvent = eventId; // Définissez l'ID de l'événement

    evname1.setText(eventName); // Remplissez le nom de l'événement
    prix1.setText(String.valueOf(ticketPrice)); // Remplissez le prix du ticket en tant que chaîne
   lieu1.setText(eventName);
     nb1.setText(String.valueOf(nbrmax));
      type1.setText(type);
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Le format de date souhaité
    date1.setText(dateFormat.format(date)); // Formatez la date en chaîne et affichez-la
     description1.setText(description); 
    // Chargez l'image depuis le chemin de l'image
    Image image = new Image("file:" + imagePath, 190, 100, false, true);
    im1.setImage(image); // Affichez l'image
}

      public void setEventId(int eventId) {
        this.idEvent = eventId;
    }

      

    
    public void setSelectedEventId(int eventId) {
        this.idEvent = eventId;
    }
    
public Integer getIdEvent() {
    return idEvent;
}
    
    
 private AjoutController ajoutController;

    public Card2Controller(AjoutController ajoutController) {
        this.ajoutController = ajoutController;
    }

    private int selectedEventId = -1;
    
    
    
     public void setAjoutController(AjoutController ajoutController) {
        this.ajoutController = ajoutController;
    }
    
    
     public Card2Controller() {
        // Vous pouvez initialiser des variables ou effectuer d'autres opérations ici si nécessaire
    }
    
    
    

  @FXML
private void deleteEvent(ActionEvent event) {
    int idEvent = getIdEvent();
    selectedEventId = idEvent;
    int eventIdToDelete = selectedEventId; // Récupérez l'ID de l'événement que vous souhaitez supprimer

    if (eventIdToDelete == -1) {
System.out.println("-11111111111");
    }

    // Appelez la méthode de service pour supprimer l'événement
    Eventservice eventService = new Eventservice();
     eventService.deleteEvent(eventIdToDelete);
        
    // Créez une boîte de dialogue pour afficher le résultat de la suppression
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Suppression d'événement");
alert.setHeaderText("Suppression de l'évenement réussie");
    
    alert.showAndWait();
//   ajoutController.refreshEventList11();

    // Réinitialisez les champs de texte et les contrôles d'interface utilisateur après la suppression
     
}
   
    
    
    
      private int eventToUpdate;

    public void setEventToUpdate(int eventtoupdate) {
        this.eventToUpdate = eventtoupdate;
    }
    
    
        @FXML
private void updateselected(ActionEvent event) {
    // Obtenez l'ID de l'événement à partir de la carte d'événement sélectionnée
    int idEvent = getIdEvent();
    selectedEventId = idEvent;
   
System.out.println("ID de l'événement : " + idEvent);// Mettez à jour selectedEventId avec l'ID de l'événement sélectionné
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Ajout.fxml"));
        Parent root = loader.load();
        AfficheDetailsController afficheDetailsController = loader.getController();

          afficheDetailsController.setEventToUpdate(selectedEventId); 
       // detailsController.loadEventDetails22(idEvent);
        // detailsController.loadEventDetails22(idEvent);
      // detailsController.getJoinanchro().setVisible(false);
        //detailsController.getJoinanchro().setManaged(false);
        
        //detailsController.getMainformaffiche().setVisible(true);
        //detailsController.getMainformaffiche().setManaged(true);

        if (eventToUpdate != -1) {
            // Your existing code for loading the event details and showing the form.
        } else {
            System.out.println("Invalid event ID: " + eventToUpdate);
        }
        // Affichez la vue de détails
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}
  
    
    
     private AfficheDetailsController afficheDetailsController;
    
    public Card2Controller(AfficheDetailsController afficheDetailsController) {
        this.afficheDetailsController = afficheDetailsController;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * Initializes the controller class.
     */
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

   

    
}
