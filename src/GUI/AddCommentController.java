/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import util.MyConnection;

/**
 * FXML Controller class
 *
 * @author Grati Eya
 */
public class AddCommentController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private AnchorPane AddComment_form;
    @FXML
    private Button buttonAddComment;
    @FXML
    private TextField inputDescriptionComment;
    @FXML
    private Button buttonReturnComment;
    @FXML
    private Label username;
    @FXML
    private Button dashboard_btn;
    @FXML
    private Button transport_btn;
    @FXML
    private Button biblio_btn;
    @FXML
    private Button event_btn;
    @FXML
    private Button logout_btn;
    @FXML
    private Button services_btn;
    @FXML
    private Button forum_btn;
    @FXML
    private AnchorPane dashboard_form;
    @FXML
    private Button close;
    @FXML
    private Button minus;
    @FXML
    private Label labelStatus;
    MyConnection Mycnx = MyConnection.getInstance();
    Connection cnx = Mycnx.getCnx();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        buttonAddComment.setOnAction((event) -> {
           try {
               this.Add(event);
           } catch (IOException ex) {
               Logger.getLogger(AddPostController.class.getName()).log(Level.SEVERE, null, ex);
           }
       });
    }  
    private double x = 0;
    private double y = 0;
    @FXML
    private void Return(ActionEvent event) throws IOException   {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/ForumInterface.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root)); 
    }
    @FXML
    private void close() {
            System.exit(0);
    }

    @FXML
    private void switchForm(ActionEvent event) {
    }

    @FXML
    private void logout(ActionEvent event) {
    }
    
    
    @FXML
    private boolean Add(ActionEvent event) throws IOException {
        try{
            Alert alert;
            if (inputDescriptionComment.getText().isEmpty() ) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
                return false;     
            }else{
                System.out.println("Add button clicked");
        
            
                String inputDescriptionCommentValue = inputDescriptionComment.getText();
                


                String query = "INSERT INTO commentaire (`DateCreation`,`Description`) VALUES (NOW(),?)";
                PreparedStatement statement = cnx.prepareStatement(query);
                statement.setString(1, inputDescriptionCommentValue);

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Add Post");
                    alert.showAndWait();

                    System.out.println("L'insertion a été réussie !");
                }

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/ForumInterface.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
                statement.close();
                cnx.close();

            } 
        
         }catch (SQLException e) {
                e.printStackTrace();
            }
         return true;
    
    }

    @FXML
    private void minimize() {
        Stage stage = (Stage) AddComment_form.getScene().getWindow();
        stage.setIconified(true);
    }
    
}
