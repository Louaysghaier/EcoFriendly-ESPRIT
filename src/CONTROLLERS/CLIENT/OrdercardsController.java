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

/**
 * FXML Controller class
 *
 * @author louay
 */
public class OrdercardsController implements Initializable {

    @FXML
    private AnchorPane card_form;
    @FXML
    private Label order_number;
    @FXML
    private Label card_datOrder;
    @FXML
    private Button card_moreInfo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void moreInfoBtn(ActionEvent event) {
    }
    
}
