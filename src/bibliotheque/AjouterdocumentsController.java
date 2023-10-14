/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotheque;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import models.documents;
import models.topic;
import service.documentsservice;
import service.topicservice;

/**
 * FXML Controller class
 *
 * @author Dorra
 */
public class AjouterdocumentsController implements Initializable {

     private ObservableList categoriesList = FXCollections.observableArrayList();
    //ObservableList Listt = FXCollections.observableArrayList ( "1","2","3");
    @FXML
    private TextField dtitre;
    //private File imageFile;
    @FXML
    private TextField dtype;
    @FXML
    private DatePicker ddate;
    @FXML
    private ComboBox<?> dtopic;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        List<topic> topic = null;
        topic = new topicservice().getAll();
    categoriesList.addAll(topic);
    dtopic.setItems(categoriesList);



    }    

    
           
    
    @FXML
    private void dimporter(ActionEvent event) {
        
          FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Choisir une image");
    // définir les filtres pour n'afficher que les fichiers image
    fileChooser.getExtensionFilters().addAll(
        new FileChooser.ExtensionFilter("Images", "*.png", "*.jpg", "*.gif")
    );
         // ouvrir la boîte de dialogue de sélection de fichier
         File imageFile = fileChooser.showOpenDialog(((Node) event.getSource()).getScene().getWindow());
    }
    

    @FXML
    private void denregistrer(ActionEvent event) throws IOException, SQLException {
         String titre,type ;
     Date date;
     topic topic ;
     byte[]  image = null ;
    
     
        documents d = new documents();

        titre = dtitre.getText();
        type = dtype.getText();
     
       topic = (topic) dtopic.getSelectionModel().getSelectedItem();
//categ = wcategorie.getValue();
 
      

        LocalDate localDate = ddate.getValue();
       date = Date.valueOf(localDate);
   

       
        
       // Contôle de saisie
      // Contôle de saisie
    if (dtitre.getText().isEmpty() || dtype.getText().isEmpty() || ddate.getValue() == null ) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText("Attention !");
        alert.setContentText("Veuillez remplir tous les champs.");
        alert.showAndWait();
        return;
    }
if (!dtitre.getText().matches("[a-zA-Z]+")) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Erreur");
    alert.setHeaderText("Attention !");
    alert.setContentText("Le nom ne doit contenir que des lettres.");
    alert.showAndWait();
    return;
}

if (!dtype.getText().matches("[a-zA-Z]+")) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Erreur");
    alert.setHeaderText("Attention !");
    alert.setContentText("La marque ne doit contenir que des lettres.");
    alert.showAndWait();
    return;
}
   

  

    // Si tous les champs sont valides, on ajoute le produit
   documentsservice uc = new documentsservice();
        documents docu = new documents( titre, type ,topic, image);

    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Choisir une image");
    File file = fileChooser.showOpenDialog(null);
    if (file != null) {
        // Convertir le fichier en tableau d'octets et l'affecter à l'attribut ImageActivite de l'objet a
        byte[] imageBytes = Files.readAllBytes(file.toPath());
        docu.setImage(imageBytes);
    }

    uc.ajouter(docu);

    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Succès");
    alert.setHeaderText("Bienvenue");
    alert.setContentText("Le produit a été ajouté avec succès !");
    alert.showAndWait();

//            try {
//            wprix.getScene().getWindow().hide();
//            
//            Parent root = FXMLLoader.load(getClass().getResource("Afficherproduitw.fxml"));
//            Scene scene = new Scene(root);
//            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//            stage.setScene(scene);
//            stage.show();
//        } catch (IOException ex) {
//            Logger.getLogger(AjouterproduitController.class.getName()).log(Level.SEVERE, null, ex);
//        }
            
            
            }

    private void SelectImage(ActionEvent event) {
         FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Choisir une image");
    // définir les filtres pour n'afficher que les fichiers image
    fileChooser.getExtensionFilters().addAll(
        new FileChooser.ExtensionFilter("Images", "*.png", "*.jpg", "*.gif")
    );
         // ouvrir la boîte de dialogue de sélection de fichier
         File imageFile = fileChooser.showOpenDialog(((Node) event.getSource()).getScene().getWindow());
    }

    }


    