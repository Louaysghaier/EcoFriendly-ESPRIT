 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Models.Post;
import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import Models.Post;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Grati Eya
 */
public class ItemController implements Initializable {
    
    @FXML
    private Label datePost;
    @FXML
    private Label labelprenom;
    @FXML
    private Label labelnom;
    @FXML
    private Label labelpost;
    @FXML
    private Label labletitrepost;
    @FXML
    private Label labelnbrecomment;
     @FXML
    private ImageView imguser;
    @FXML
    private Button buttonAddComment;
    @FXML
    private Button buttonReadComments;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    /*private Post post;
    public void setData(Post post){
        this.post = post;
        labelnom.setText(post.getNomUser());
        labelprenom.setText(post.getPrenomUser());
        labletitrepost.setText(post.getTitle());
        labelpost.setText(post.getDescriptionp());
        labelnbrecomment.setText(String.valueOf(post.getNbreComment()));
        Image image = new Image(getClass().getResourceAsStream(post.getImage()));
        imguser.setImage(image);     
    }*/
    
    
    //    public void setData(Event eventData) {
//  //  this.eventData = eventData; // Assurez-vous que vous avez un attribut 'eventdata' dans votre contrôleur
//
//    EventName.setText(eventData.getNomEvent()); // Remplissez le nom de l'événement
//    pricee.setText(String.valueOf(eventData.getPrixTicket())); // Remplissez le prix du ticket en tant que chaîne
//    String imagePath = eventData.getImage(); // Récupérez le chemin de l'image de l'événement
//    Image image = new Image("file:" + imagePath, 190, 100, false, true); // Chargez l'image depuis le chemin
//    imageevent.setImage(image); // Affichez l'image
//}
//
//    
//    
//    
 

   private Date datep;
   private Image image;
   public void setData(String nomUser, String prenomUser, String imagePath, String title, String description, int nbreComment, Date datep) {
    labelnom.setText(nomUser);
    labelprenom.setText(prenomUser);
    labletitrepost.setText(title);
    labelpost.setText(description);
    labelnbrecomment.setText(String.valueOf(nbreComment) + "Comments");
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // Format de la date
    datePost.setText( sdf.format(datep));

    // Chargez l'image depuis le chemin de l'image
    Image image = new Image("file:" + imagePath, 190, 100, false, true);
    imguser.setImage(image); // Affichez l'image
}


   
   
    private int idPost;

// Méthode pour initialiser l'ID de l'événement
public void setPostId(int postId) {
    this.idPost = postId;
}

// Méthode pour obtenir l'ID de l'événement
public Integer getIdPost() {
    return idPost;
}
   
   
   
   
    // Vous pouvez ajouter des méthodes de gestion d'événements ici

private void showDetails(ActionEvent event) {
    // Obtenez l'ID de l'événement à partir de la carte d'événement sélectionnée
    int idPost = getIdPost(); // Vous devez obtenir l'ID de l'événement à partir de la carte sélectionnée

    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddComment.fxml"));
        Parent root = loader.load();
       // AddCommentController detailsController = loader.getController();

        // Chargez les détails de l'événement en fonction de l'ID
       // detailsController.loadEventDetails(idPost);

        // Affichez la vue de détails
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}

    public void initi(int postId) {
        this.idPost = postId;
    }


    @FXML
    private void Add(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/AddComment.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    private void ReadComments(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/CommentsDetails.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
    }
    
}
