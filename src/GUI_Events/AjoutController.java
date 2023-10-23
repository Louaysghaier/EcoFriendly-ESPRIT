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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import models.Event;
import models.Participation;
import models.User;
import services.Eventservice;
import services.Participationservice;
import services.Userservice;
import util.Myconnection;

/**
 * FXML Controller class
 *
 * @author Mekni
 */
 
public class AjoutController implements Initializable {
 
    @FXML
    private TextField eventname;
    @FXML
    private TextField lieuevent;
    @FXML
    private TextField duree;
    @FXML
    private DatePicker datedebut;
    @FXML
    private TextField ticketprice;
    @FXML
    private TextField nbmaxparticipation;
    @FXML
    private TextField eventtype;
    @FXML
    private TextArea eventdescription;
    @FXML
    private Button importeer;
    @FXML
    private ImageView viewimage;
    @FXML
    private Button importeer1;
    @FXML
    private AnchorPane main_form;

    Myconnection Mycnx = Myconnection.getInstance();
    Connection cnx = Mycnx.getCnx();
    @FXML
    private Button consulter1;
    @FXML
    private Button clear1;
    @FXML
    private AnchorPane afficheevent;
    @FXML
    private AnchorPane ajout;
    @FXML
    private GridPane griddd;
    @FXML
    private GridPane gridmyev;
    @FXML
    private VBox vboxxx;
    @FXML
    private VBox vboxmyev;
    
    @FXML
     public void addEmployeeInsertImage() {
        FileChooser open = new FileChooser();
        File file = open.showOpenDialog(main_form.getScene().getWindow());

        if (file != null) {
            getData.path = file.getAbsolutePath();
            Image image = new Image(file.toURI().toString(), 150, 120, false, true);
            viewimage.setImage(image);
        }
    }
                        String uri = getData.path;
    
    
    
    



    



//    @FXML
//    private void AjouterEvent1(ActionEvent Event) {
//        String nomEvent = eventname.getText();
//        String lieuEvent = lieuevent.getText();
//        String dureeEvent = duree.getText();
//        LocalDate dateDebut = datedebut.getValue();
//        String prixTicket = ticketprice.getText();
//        String nbMaxParticipants = nbmaxparticipation.getText();
//        String typeEvent = eventtype.getText();
//        String descriptionEvent = eventdescription.getText();
//          String imagePath = getData.path; // Récupérez le chemin de l'image sélectionnée
//        // Créez un objet Event avec les données récupérées
//        Event event = new Event();
//        event.setNomEvent(nomEvent);
//        event.setLieuEvent(lieuEvent);
//        event.setDurée(dureeEvent);
//        event.setDateDebutEvent(java.sql.Date.valueOf(dateDebut));
//        event.setPrixTicket(Double.parseDouble(prixTicket));
//        event.setNbmaxParticipant(Integer.parseInt(nbMaxParticipants));
//        event.setTypeEvent(typeEvent);
//        event.setDescriptionEvent(descriptionEvent);
//          event.setImage(imagePath);
//             
//      Userservice userService = new Userservice();
//int currentUserId = userService.getUserIdById(2);
//User currentUser = userService.getUserById(currentUserId);
//event.setUser(currentUser);
//
//
//          
//        Eventservice eventService = new Eventservice();
//        eventService.ajouterEvent1(event);
//       
//       
//        Clear();
//    }






    @FXML
    private void AjouterEvent1(ActionEvent Event) {
    // Récupérez les données depuis les champs de texte et les contrôles de l'interface utilisateur
    String nomEvent = eventname.getText();
    String lieuEvent = lieuevent.getText();
    String dureeEvent = duree.getText();
    LocalDate dateDebut = datedebut.getValue();
    String prixTicket = ticketprice.getText();
    String nbMaxParticipants = nbmaxparticipation.getText();
    String typeEvent = eventtype.getText();
    String descriptionEvent = eventdescription.getText();
    String imagePath = getData.path; // Récupérez le chemin de l'image sélectionnée

    // Effectuez des contrôles de saisie
    if (nomEvent.isEmpty() || lieuEvent.isEmpty() || dureeEvent.isEmpty() || dateDebut == null ||
        prixTicket.isEmpty() || nbMaxParticipants.isEmpty() || typeEvent.isEmpty() || descriptionEvent.isEmpty()) {
        showAlert(AlertType.ERROR, "Champs non remplis", "Veuillez remplir tous les champs.");
        return; // Arrêtez la création de l'événement si un champ est vide
    }

    if (nomEvent.length() < 8) {
        showAlert(AlertType.ERROR, "Erreur de saisie", "Le nom de l'événement doit comporter au moins 8 caractères.");
        return; // Arrêtez la création de l'événement si le nom est trop court
    }

    if (dateDebut.isBefore(LocalDate.now())) {
        showAlert(AlertType.ERROR, "Erreur de saisie", "La date de début de l'événement doit être une date future.");
        return; // Arrêtez la création de l'événement si la date n'est pas valide
    }

    // Créez un objet Event avec les données récupérées
    Event event = new Event();
    event.setNomEvent(nomEvent);
    event.setLieuEvent(lieuEvent);
    event.setDurée(dureeEvent);
    event.setDateDebutEvent(java.sql.Date.valueOf(dateDebut));
    event.setPrixTicket(Double.parseDouble(prixTicket));
    event.setNbmaxParticipant(Integer.parseInt(nbMaxParticipants));
    event.setTypeEvent(typeEvent);
    event.setDescriptionEvent(descriptionEvent);
    event.setImage(imagePath);
    event.setDatecreation(new java.sql.Date(System.currentTimeMillis()));

    Userservice userService = new Userservice();
    int currentUserId = userService.getUserIdById(2);
    User currentUser = userService.getUserById(currentUserId);
    event.setUser(currentUser);

    Eventservice eventService = new Eventservice();
    eventService.ajouterEvent11(event);

    showAlert(AlertType.INFORMATION, "Succès", "L'événement a été ajouté avec succès.");

    Clear();
   
}

private void showAlert(AlertType alertType, String title, String content) {
    Alert alert = new Alert(alertType);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(content);
    alert.showAndWait();
}








    @FXML
    public void switchForm(ActionEvent event) {
        if (event.getSource() == consulter1) {
            ajout.setVisible(false);
            afficheevent.setVisible(true);

        }
}





@FXML
    private void Clear() {
        eventname.clear();
        lieuevent.clear();
        duree.clear();
        datedebut.getEditor().clear();
        ticketprice.clear();
        nbmaxparticipation.clear();
        eventtype.clear();
        eventdescription.clear();
        viewimage.setImage(null);
        getData.path = "";
    }

    




    public void afficherEventSelectionne(Event eventSelectionne) {
    if (eventSelectionne != null) {
        eventname.setText(eventSelectionne.getNomEvent());
        lieuevent.setText(eventSelectionne.getLieuEvent());
        duree.setText(eventSelectionne.getDurée());
        
        // Utilisez le formatage pour afficher correctement la date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        datedebut.setValue(LocalDate.parse(dateFormat.format(eventSelectionne.getDateDebutEvent().getTime()), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        
        ticketprice.setText(String.valueOf(eventSelectionne.getPrixTicket()));
        nbmaxparticipation.setText(String.valueOf(eventSelectionne.getNbmaxParticipant()));
        eventtype.setText(eventSelectionne.getTypeEvent());
        eventdescription.setText(eventSelectionne.getDescriptionEvent());

        // Chargez l'image depuis le chemin de l'événement
        String imagePath = eventSelectionne.getImage();
        Image image = new Image("file:" + imagePath, 190, 100, false, true);
        viewimage.setImage(image);
    } else {
        // Réinitialisez les champs si l'événement sélectionné est nul
        Clear();
    }
}


Event eventData;
    
    
    
    
    
    private int selectedEventId = -1; // Initialisez-le à une valeur qui n'aura pas de correspondance dans la base de données

    
    ObservableList<Event> Cardlistdata = FXCollections.observableArrayList(); 
  
    private AnchorPane anchroshoweven;
    
public AnchorPane getAnchroshoweven() {
    return anchroshoweven;
}

    
    public ObservableList<Event> AfficheEvent() {
    

    try {
        Statement st = cnx.createStatement();
        String sql = "SELECT * FROM event"; // Assurez-vous que votre table s'appelle "event"

        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            // Créez un modèle Event à partir des données de la base de données
            Event event = new Event();

            // Récupérez toutes les colonnes de la table event
            event.setIdEvent(rs.getInt("idEvent"));
            event.setNomEvent(rs.getString("nomEvent"));
            event.setPrixTicket(rs.getDouble("PrixTicket"));
            event.setImage(rs.getString("image"));
            event.setDateDebutEvent(rs.getDate("dateDebutEvent"));
            event.setDurée(rs.getString("Durée"));
            event.setLieuEvent(rs.getString("LieuEvent"));
            event.setNbmaxParticipant(rs.getInt("nbmaxParticipant"));
            event.setTypeEvent(rs.getString("typeEvent"));
            event.setDescriptionEvent(rs.getString("descriptionEvent"));
            event.setDatecreation(rs.getDate("Datecreation"));
            Cardlistdata.add(event);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return Cardlistdata;
}


AfficheEventController aa = new AfficheEventController();
  
    
    public void menuDisplayCard() {
    try {
        ObservableList<Event> tempList = FXCollections.observableArrayList();
        tempList.addAll(AfficheEvent());

        int row = 0;
        int column = 0;

        griddd.getRowConstraints().clear();
        griddd.getColumnConstraints().clear();

        for (int q = 0; q < tempList.size(); q++) {
            FXMLLoader load = new FXMLLoader();
            load.setLocation(getClass().getResource("CardEvent.fxml"));

            AnchorPane pane = load.load();
            CardEventController card = load.getController();

            // Définir l'ID de l'événement
            card.setEventId(tempList.get(q).getIdEvent());

            // Passez les données nécessaires à la carte, y compris le chemin de l'image
            card.setData(tempList.get(q).getIdEvent(), tempList.get(q).getNomEvent(), tempList.get(q).getPrixTicket(), tempList.get(q).getImage());

            if (column == 2) {
                column = 0;
                row += 1;
            }
            griddd.add(pane, column++, row);
        }

        // Supprimez les données de la liste principale après avoir terminé l'itération
        Cardlistdata.clear();
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}

     public void removeEventFromUI(Event event) {
    // Supprimez l'événement de la liste observable
    Cardlistdata.remove(event);
    
    // Rechargez la grille des cartes
    griddd.getChildren().clear(); // Supprimez toutes les cartes actuellement affichées

    // Réaffichez les cartes restantes après suppression
    menuDisplayCard();
}






    
//private void refreshEventList() {
//    // Appelez la méthode pour mettre à jour la liste des événements
//    menuDisplayCard();
//}
//    
//
//public void refreshEventList11() {
//    // Appelez la méthode pour mettre à jour la liste des événements
//    
//  
//  
//        menuDisplayCardmy(selectedEventId);
//}
//    







ObservableList<Event> Cardlistdatamy = FXCollections.observableArrayList(); 
    private Eventservice eventService = new Eventservice();
    private void menuDisplayCard(int userId) {
        try {
            Cardlistdatamy.clear();

            // Utilisez le userId pour charger les événements de l'utilisateur connecté
            List<Event> userEvents = eventService.afficherEventsByUser(userId);

            Cardlistdatamy.addAll(userEvents);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    
    
    }
    
    
    
    public void menuDisplayCardmy(int userId) {
    try {
        // Utilisez le userId pour charger les événements de l'utilisateur connecté
        List<Event> userEvents = eventService.afficherEventsByUser(userId);
        ObservableList<Event> tempList = FXCollections.observableArrayList(userEvents);

        int row = 0;
        int column = 0;

        gridmyev.getRowConstraints().clear();
        gridmyev.getColumnConstraints().clear();

        for (int q = 0; q < tempList.size(); q++) {
            FXMLLoader load = new FXMLLoader();
            load.setLocation(getClass().getResource("Card2.fxml"));

            AnchorPane pane = load.load();
            Card2Controller card1 = load.getController();
 card1.setAjoutController(this);
            // Définir l'ID de l'événement
            card1.setEventId(tempList.get(q).getIdEvent());

            // Passez les données nécessaires à la carte, y compris le chemin de l'image
card1.setData1(tempList.get(q).getIdEvent(), tempList.get(q).getNomEvent(), tempList.get(q).getPrixTicket(), tempList.get(q).getImage(), tempList.get(q).getLieuEvent(), tempList.get(q).getNbmaxParticipant(), tempList.get(q).getTypeEvent(), tempList.get(q).getDescriptionEvent(), tempList.get(q).getDateDebutEvent());

            if (column == 1) {
                column = 0;
                row += 1;
            }
            gridmyev.add(pane, column++, row);
        }

        // Supprimez les données de la liste principale après avoir terminé l'itération
        Cardlistdatamy.clear();
     
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}




















//    private void afficherEvenementsUtilisateurActuel(int userId) {
//    // Assurez-vous que userId est défini avec l'ID de l'utilisateur connecté
//    // userId = 2; // Remplacez 2 par l'ID de l'utilisateur connecté
//
//    Eventservice eventService = new Eventservice(); // Remplacez ServiceEvent par le nom de votre classe de service
//    List<Event> userEvents = eventService.afficherEventsByUser1(userId);
//
//    ObservableList<Event> itemsEvenements = FXCollections.observableArrayList(userEvents);
//
//    listmyevents.setItems(itemsEvenements);
//}


    // ...

//private int userId; // L'ID de l'utilisateur actuellement connecté

// Créez une méthode pour afficher les événements de l'utilisateur actuel
//    @FXML
//    private void afficherEvenementsUtilisateurActuel() {
//    // Assurez-vous que userId est défini avec l'ID de l'utilisateur connecté
//    userId = 2; // Remplacez 2 par l'ID de l'utilisateur connecté
//
//    Eventservice eventService = new Eventservice(); // Remplacez ServiceEvent par le nom de votre classe de service
//    List<Event> userEvents = eventService.afficherEventsByUser(userId);
//
//    ObservableList<String> itemsEvenements = FXCollections.observableArrayList();
//
//    for (Event event : userEvents) {
//        String eventString = "Nom de l'événement : " + event.getNomEvent() + "\n";
//        eventString += "Date de début : " + event.getDateDebutEvent() + "\n";
//        eventString += "Durée : " + event.getDurée() + "\n";
//        eventString += "Lieu : " + event.getLieuEvent() + "\n";
//        eventString += "Prix du ticket : " + event.getPrixTicket() + "\n";
//        eventString += "Nombre maximal de participants : " + event.getNbmaxParticipant() + "\n";
//        eventString += "Type d'événement : " + event.getTypeEvent() + "\n";
//        eventString += "Description : " + event.getDescriptionEvent() + "\n";
//
//        itemsEvenements.add(eventString);
//    }
//
//    listEvenement.setItems(itemsEvenements);
//}
//@FXML
//private void afficherEvenementsUtilisateurActuel() {
//    // Assurez-vous que le nom d'utilisateur actuel est défini
//    int iduser= selectedEventId;
//    String username = "nom_utilisateur"; // Remplacez "nom_utilisateur" par le nom de l'utilisateur connecté
//
//    // Utilisez la méthode getEventNamesByUser pour récupérer la liste des noms d'événements
//    Eventservice event = new Eventservice();
//    List<String> eventNames = event.getEventNamesByUser1(iduser);
//
//    // Convertissez la liste des noms d'événements en une ObservableList
//    ObservableList<String> itemsEvenements = FXCollections.observableArrayList(eventNames);
//
//    // Assurez-vous que listEvenement est l'identifiant de votre ListView dans le fichier FXML
//    listEvenement.setItems(itemsEvenements);
//}
//
//

    
    
    
    
    
    
    
  @Override
    public void initialize(URL url, ResourceBundle rb) {
          
          int userId = 2; // Remplacez ceci par la valeur appropriée
          menuDisplayCard();
        menuDisplayCardmy(userId);
       // refreshEventList11();
       
 //  afficherEvenementsUtilisateurActuel(userId);
   
   
   
    
    }


   
}






        
        
        
        
        
        
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

  
    
    



    


    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

