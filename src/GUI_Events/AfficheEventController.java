/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_Events;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Event;
import util.Myconnection;

/**
 * FXML Controller class
 *
 * @author Mekni
 */
public class AfficheEventController implements Initializable {

    @FXML
    private VBox vboxxx;
    @FXML
    public GridPane griddd;
    
       Myconnection Mycnx = Myconnection.getInstance();
    Connection cnx = Mycnx.getCnx();

    
    
    Event eventData;
    
    
    
    
    
    private int selectedEventId = -1; // Initialisez-le à une valeur qui n'aura pas de correspondance dans la base de données

    
    ObservableList<Event> Cardlistdata = FXCollections.observableArrayList(); 
    private TextField SEARCH;
    private AnchorPane anchroshoweven;
    @FXML
    private Button addaff;
    
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

            Cardlistdata.add(event);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return Cardlistdata;
}



    
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

            if (column == 3) {
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



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    
//         paginat.setPageFactory(this::changePage);
             menuDisplayCard();
       
    }    

private void showEventCardByName(ActionEvent event) {
    // Récupérez le nom de l'événement à partir de la zone de recherche
    String eventName = SEARCH.getText().trim().toLowerCase();

    // Parcourez toutes les cartes d'événements
    for (Node card : vboxxx.getChildren()) {
        if (card instanceof AnchorPane) {
            AnchorPane eventCard = (AnchorPane) card;

            // Recherchez le label "eventName" dans la carte d'événement
            Label EventName = (Label) eventCard.lookup("#EventName");

            if (EventName != null) {
                String cardEventName = EventName.getText().trim().toLowerCase();

                if (cardEventName.equals(eventName)) {
                    // Affichez la carte d'événement correspondante
                    eventCard.setVisible(true);
                    eventCard.setManaged(true);
                } else {
                    // Masquez les autres cartes d'événements
                    eventCard.setVisible(false);
                    eventCard.setManaged(false);
                }
            }
        }
    }
}
@FXML
private void refreshEventList(ActionEvent event) {
    // Appelez la méthode pour mettre à jour la liste des événements
    menuDisplayCard();
}



@FXML
public void handleAddAffButton(ActionEvent event) {
    // Code pour naviguer vers l'interface Ajout.fxml
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Ajout.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

        // Fermez la fenêtre actuelle si nécessaire
        ((Node)(event.getSource())).getScene().getWindow().hide();
    } catch (IOException e) {
        e.printStackTrace();
    }
}











}
