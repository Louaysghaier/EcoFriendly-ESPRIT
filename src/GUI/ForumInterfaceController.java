/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.ItemController;
import Models.Post;
import Models.getData;
import java.awt.Insets;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import util.MyConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.Node;

/**
 * FXML Controller class
 *
 * @author Grati Eya
 */
public class ForumInterfaceController implements Initializable {

    private AnchorPane forum_form;
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
    private Button buttoninterfaceaddpost;
    @FXML
    private GridPane gridForum;
    @FXML
    private Button close;
    @FXML
    private Button buttonMinus;
    private double x = 0;
    private double y = 0;
    MyConnection Mycnx = MyConnection.getInstance();
    Connection cnx = Mycnx.getCnx();
    @FXML
    private AnchorPane main_form;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        menuDisplayCard();
        /*posts.addAll(getData());
        int column =0;
        int row =0;
        try{
            for (int i=0;i<posts.size();i++){
                FXMLLoader fxmlLoader = new FXMLLoader();
                String name;
                //fxmlLoader.setLocation(getClass().getResource( name: "/GUI/Item.fxml"));
                Parent root = FXMLLoader.load(getClass().getResource("../GUI/Item.fxml"));

                AnchorPane anchorPane =fxmlLoader.load();


                //fxmlLoader.setLocation(getClass().getResource( name: "/GUI/Item.fxml" ));

                ItemController itemController = fxmlLoader.getController();
                itemController.setData(posts.get(i));
                if(column ==3){
                    column=0;
                    row++;
                }
                
                gridForum.add(anchorPane,column,row);
                
                //GridPane.setMargin(anchorPane, new Insets(topRightBottomLeft:10));
               gridForum.setMinWidth(Region.USE_COMPUTED_SIZE);
               gridForum.setPrefWidth(Region.USE_COMPUTED_SIZE);
               gridForum.setMaxWidth(Region.USE_PREF_SIZE);
               
               gridForum.setMinHeight(Region.USE_COMPUTED_SIZE);
               gridForum.setPrefHeight(Region.USE_COMPUTED_SIZE);
               gridForum.setMaxHeight(Region.USE_PREF_SIZE);


            }
         }catch(IOException e){
                e.printStackTrace();
            } */
    } 
    ObservableList<Post> Cardlistdata = FXCollections.observableArrayList();
    public ObservableList<Post> AffichePost() {
   

    try {
        Statement st = cnx.createStatement();
        String sql = "SELECT * FROM post"; 

        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            // Créez un modèle Event à partir des données de la base de données
            Post post = new Post();

            // Récupérez toutes les colonnes de la table event
            post.setIdPost(rs.getInt("idPost"));
            post.setNomUser(rs.getString("nomUser"));
            post.setPrenomUser(rs.getString("prenomUser"));
            post.setImage(rs.getString("image"));
            post.setDateCreationp(rs.getDate("dateCreationp"));
            post.setNbreComment(rs.getInt("nbreComment"));
            post.setTitle(rs.getString("title"));
            post.setDescriptionp(rs.getString("descriptionp"));
            

            Cardlistdata.add(post);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
     System.out.println("Size: " + Cardlistdata.size());

    return Cardlistdata;
}

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////
//public void menuDisplayCard() {
//    try {
//        ObservableList<Event> tempList = FXCollections.observableArrayList();
//        tempList.addAll(AfficheEvent());
//
//        int row = 0;
//        int column = 0;
//
//        griddd.getRowConstraints().clear();
//        griddd.getColumnConstraints().clear();
//
//        for (int q = 0; q < tempList.size(); q++) {
//            FXMLLoader load = new FXMLLoader();
//            load.setLocation(getClass().getResource("CardEvent.fxml"));
//
//            AnchorPane pane = load.load();
//            CardEventController card = load.getController();
//
//            // Passez les données nécessaires à la carte, y compris le chemin de l'image
//            card.initialize(tempList.get(q).getIdEvent());
//            card.setData(tempList.get(q).getNomEvent(), tempList.get(q).getPrixTicket(), tempList.get(q).getImage());
//
//            if (column == 3) {
//                column = 0;
//                row += 1;
//            }
//            griddd.add(pane, column++, row);
//        }
//
//        // Supprimez les données de la liste principale après avoir terminé l'itération
//        Cardlistdata.clear();
//    } catch (IOException ex) {
//        ex.printStackTrace();
//    }
//}
//

   
//    
//    public void menuDisplayCard() {
//    try {
//        ObservableList<Event> tempList = FXCollections.observableArrayList();
//        tempList.addAll(AfficheEvent());
//
//        int row = 0;
//        int column = 0;
//
//        griddd.getRowConstraints().clear();
//        griddd.getColumnConstraints().clear();
//
//        for (int q = 0; q < tempList.size(); q++) {
//            FXMLLoader load = new FXMLLoader();
//            load.setLocation(getClass().getResource("CardEvent.fxml"));
//
//            AnchorPane pane = load.load();
//            CardEventController card = load.getController();
//
//            // Définir l'ID de l'événement
//            card.setEventId(tempList.get(q).getIdEvent());
//
//            // Passez les données nécessaires à la carte, y compris le chemin de l'image
//            card.setData(tempList.get(q).getNomEvent(), tempList.get(q).getPrixTicket(), tempList.get(q).getImage());
//
//            if (column == 3) {
//                column = 0;
//                row += 1;
//            }
//            griddd.add(pane, column++, row);
//        }
//
//        // Supprimez les données de la liste principale après avoir terminé l'itération
//        Cardlistdata.clear();
//    } catch (IOException ex) {
//        ex.printStackTrace();
//    }
//}

      private int currentPage = 0;
      private int cardsPerPage = 9;
   
   
 

public void menuDisplayCard() {
    System.out.println("menuDisplayCard called");
    try {
        ObservableList<Post> tempList = FXCollections.observableArrayList();
        tempList.addAll(AffichePost());

        int row = 0;
        int column = 0;

        gridForum.getRowConstraints().clear();
        gridForum.getColumnConstraints().clear();

        for (int q = 0; q < tempList.size(); q++) {
            FXMLLoader load = new FXMLLoader();
            load.setLocation(getClass().getResource("Item.fxml"));

            AnchorPane pane = load.load();
            ItemController card = load.getController();

            
            card.setPostId(tempList.get(q).getIdPost());

            // Passez les données nécessaires à la carte, y compris le chemin de l'image
            card.setData(tempList.get(q).getNomUser(), 
                         tempList.get(q).getPrenomUser(), 
                         tempList.get(q).getImage(),
                         tempList.get(q).getTitle(), 
                         tempList.get(q).getDescriptionp(), 
                         tempList.get(q).getNbreComment(),
                         tempList.get(q).getDateCreationp());

            if (column == 3) {
                column = 0;
                row += 1;
            }
            gridForum.add(pane, column++, row);
        }

        // Supprimez les données de la liste principale après avoir terminé l'itération
        Cardlistdata.clear();
    } catch (IOException ex) {
        ex.printStackTrace();
    }

System.out.println("menuDisplayCard called");
    }    

    @FXML
    private void switchForm(ActionEvent event) {
        /*if (event.getSource() == dashboard_btn) {
            dashbord_form.setVisible(true);
            forum_form.setVisible(false);
            transport_form.setVisible(false);
            biblio_form.setVisible(false);
            event_form.setVisible(false);
            services_form.setVisible(false);

            dashboard_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #FF0000);");
            forum_btn.setStyle("-fx-background-color:transparent");
            transport_btn.setStyle("-fx-background-color:transparent");
            biblio_btn.setStyle("-fx-background-color:transparent");
            event_btn.setStyle("-fx-background-color:transparent");
            services_btn.setStyle("-fx-background-color:transparent");*/

            /*homeTotalEmployees();
            homeEmployeeTotalPresent();
            homeTotalInactive();
            homeChart();*/

       /* } else if (event.getSource() == forum_btn) {
            dashbord_form.setVisible(false);
            forum_form.setVisible(true);
            transport_form.setVisible(false);
            biblio_form.setVisible(false);
            event_form.setVisible(false);
            services_form.setVisible(false);

            dashboard_btn.setStyle("-fx-background-color:transparent");
            forum_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #FF0000);");
            transport_btn.setStyle("-fx-background-color:transparent");
            biblio_btn.setStyle("-fx-background-color:transparent");
            event_btn.setStyle("-fx-background-color:transparent");
            services_btn.setStyle("-fx-background-color:transparent");*/

            /*addEmployeeGendernList();
            addEmployeePositionList();
            addEmployeeSearch();*/

        /*} else if (event.getSource() == transport_btn) {
            dashbord_form.setVisible(false);
            forum_form.setVisible(false);
            transport_form.setVisible(true);
            biblio_form.setVisible(false);
            event_form.setVisible(false);
            services_form.setVisible(false);

            dashboard_btn.setStyle("-fx-background-color:transparent");
            forum_btn.setStyle("-fx-background-color:transparent");
            transport_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #FF0000);");
            biblio_btn.setStyle("-fx-background-color:transparent");
            event_btn.setStyle("-fx-background-color:transparent");
            services_btn.setStyle("-fx-background-color:transparent");

            //salaryShowListData();

        }else if (event.getSource() == biblio_btn) {
            dashbord_form.setVisible(false);
            forum_form.setVisible(false);
            transport_form.setVisible(false);
            biblio_form.setVisible(true);
            event_form.setVisible(false);
            services_form.setVisible(false);

            dashboard_btn.setStyle("-fx-background-color:transparent");
            forum_btn.setStyle("-fx-background-color:transparent");
            transport_btn.setStyle("-fx-background-color:transparent");
            biblio_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #FF0000);");
            event_btn.setStyle("-fx-background-color:transparent");
            services_btn.setStyle("-fx-background-color:transparent");

            //salaryShowListData();

        }else if (event.getSource() == event_btn) {
            dashbord_form.setVisible(false);
            forum_form.setVisible(false);
            transport_form.setVisible(false);
            biblio_form.setVisible(false);
            event_form.setVisible(true);
            services_form.setVisible(false);

            dashboard_btn.setStyle("-fx-background-color:transparent");
            forum_btn.setStyle("-fx-background-color:transparent");
            transport_btn.setStyle("-fx-background-color:transparent");
            biblio_btn.setStyle("-fx-background-color:transparent");
            event_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #FF0000);");
            services_btn.setStyle("-fx-background-color:transparent");

            //salaryShowListData();

        }else if (event.getSource() == services_btn) {
            dashbord_form.setVisible(false);
            forum_form.setVisible(false);
            transport_form.setVisible(false);
            biblio_form.setVisible(false);
            event_form.setVisible(false);
            services_form.setVisible(true);

            dashboard_btn.setStyle("-fx-background-color:transparent");
            forum_btn.setStyle("-fx-background-color:transparent");
            transport_btn.setStyle("-fx-background-color:transparent");
            biblio_btn.setStyle("-fx-background-color:transparent");
            event_btn.setStyle("-fx-background-color:transparent");
            services_btn.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #FF0000);");

            //salaryShowListData();

        }*/
    }

    @FXML
    private void logout() {
        /*Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Message");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to logout?");
        Optional<ButtonType> option = alert.showAndWait();
        try {
            if (option.get().equals(ButtonType.OK)) {

                logout_btn.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);

                root.setOnMousePressed((MouseEvent event) -> {
                    x = event.getSceneX();
                    y = event.getSceneY();
                });

                root.setOnMouseDragged((MouseEvent event) -> {
                    stage.setX(event.getScreenX() - x);
                    stage.setY(event.getScreenY() - y);

                    stage.setOpacity(.8);
                });

                root.setOnMouseReleased((MouseEvent event) -> {
                    stage.setOpacity(1);
                });

                stage.initStyle(StageStyle.TRANSPARENT);

                stage.setScene(scene);
                stage.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    @FXML
    public void AddbtnInterface(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/AddPost.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        
    }
    /*private List<Post> posts = new ArrayList<>();
    private List<Post> getData(){
        List<Post> posts = new ArrayList<>();
        Post post;
        Date date = new Date(System.currentTimeMillis());
        for(int i=0;i<20;i++){
            post = new Post();
            post.setNomUser("Grati");
            post.setPrenomUser("Eya");
            post.setDescriptionp("J'ai un probléme dans mon projet pi");
            post.setTitle("JavaFX");
            post.setImage("/styel/eya.jpg");
            post.setDateCreationp(date);
            post.setNbreComment(5);
            posts.add(post);
        }
        return posts;
    }*/

    @FXML
    private void close() {
        System.exit(0);
    }
    public void minimize() {
        Stage stage = (Stage) forum_form.getScene().getWindow();
    if (stage != null) {
        stage.setIconified(true);
    }
    }
  

    
}
