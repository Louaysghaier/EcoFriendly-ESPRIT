

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laundryshopmanagementsystem;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author louay
 */
public class serviceCardController implements Initializable {

    @FXML
    private StackPane card_form;
    @FXML
    private Label card_clothType;
    @FXML
    private ImageView card_imageView;
    @FXML
    private Label card_serviceName;
    @FXML
    private Label card_price;
    @FXML
    private Label info;
    @FXML
    private Button card_addBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void oninfo(MouseEvent event) {
    }

    @FXML
    private void addBtn(ActionEvent event) {
    }
    
}
