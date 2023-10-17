/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Models.Commentaire;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import static javafx.fxml.FXMLLoader.load;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import static sun.plugin2.util.NativeLibLoader.load;
import util.MyConnection;

/**
 * FXML Controller class
 *
 * @author Grati Eya
 */
public class CommentsDetailsController implements Initializable {

    @FXML
    private ListView<Commentaire> listViewComments;
    @FXML
    private Button buttonReturnDetails;
     MyConnection Mycnx = MyConnection.getInstance();
    Connection cnx = Mycnx.getCnx();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       ObservableList<Commentaire> commentaires = FXCollections.observableArrayList();
        listViewComments.setItems(commentaires);
        int idPost=18;
        List<Commentaire> commentairesFromDB = getCommentairesFromDatabase(idPost);
        commentaires.addAll(commentairesFromDB);

        listViewComments.setCellFactory(param -> new ListCell<Commentaire>() {
            @Override
            protected void updateItem(Commentaire item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/ItemComment.fxml"));
                    AnchorPane pane;
                    try {
                        pane = loader.load();
                    
                    ItemCommentController controller = loader.getController();
                    controller.initialize(item);
                    setGraphic(pane);
                    
                } catch (IOException ex) {
                        Logger.getLogger(CommentsDetailsController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
            }
        });
    }

    public List<Commentaire> getCommentairesFromDatabase(int idPost) {
        // Connectez-vous à la base de données et récupérez les commentaires
        // Assurez-vous de remplacer les détails de connexion et la requête SQL
        
        List<Commentaire> commentaires = new ArrayList<>();
        String req = "SELECT * FROM `commentaire` WHERE `idPost`=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            Statement stmt = cnx.createStatement();
            ps.setInt(1, idPost);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Commentaire commentaire = new Commentaire();
                commentaire.setIdComment(rs.getInt("idComment"));
                commentaire.setNomUser(rs.getString("nomUser"));
                commentaire.setPrenomUser(rs.getString("prenomUser"));
                commentaire.setDescription(rs.getString("Description"));
                commentaire.setDateCreation(rs.getDate("Datecreation"));
                commentaires.add(commentaire);
            }
            

            rs.close();
            ps.close();
            //cnx.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return commentaires;
    
    }    

    @FXML
    private void Return(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/ForumInterface.fxml"));
        Parent root = loader.load();
        ForumInterfaceController forumInterfaceController = loader.getController();
        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
    }
    private int postId;

    public void setPostId(int id) {
        this.postId = id;
    }
    
}
