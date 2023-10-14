/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLERS.CLIENT;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
/**
 * FXML Controller class
 *
 * @author louay
 */
public class FXMLController implements Initializable {

    @FXML
    private AnchorPane main_form;
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
    private StackPane carouselContainer;

    @FXML
    private Button nextButton;

    @FXML
    private Button prevButton;
private int currentIndex = 0;
    private String[] imagePaths = {
            "/STYLING/pic2.png",
        "/STYLING/pic1.jpg",
        "/STYLING/pic3.jpg"
    };

    @FXML
    private void initialize() {
        showImage(currentIndex);

        nextButton.setOnAction(event -> {
            currentIndex = (currentIndex + 1) % imagePaths.length;
            showImage(currentIndex);
        });

        prevButton.setOnAction(event -> {
            currentIndex = (currentIndex - 1 + imagePaths.length) % imagePaths.length;
            showImage(currentIndex);
        });
    }
    private void showImage(int index) {
        String imagePath = imagePaths[index];
        Image image = new Image(imagePath);
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(558); 
        carouselContainer.getChildren().setAll(imageView);
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {        initialize();

        // TODO
    }    

    @FXML
    private void switchForm(ActionEvent event) {
    }

    @FXML
    private void logout(ActionEvent event) {
    }
    
}
