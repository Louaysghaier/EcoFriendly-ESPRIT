/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MAINAPPLICATION;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import CONTROLLERS.CLIENT.FXMLController;

/**
 *
 * @author louay
 */
public class ECOFRIENDLYESPRIT extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/mainform.fxml"));
      //   Parent root = FXMLLoader.load(getClass().getResource("/ADMIN/Adminservice.fxml"));
        Scene scene = new Scene(root);
        
        stage.setMinWidth(750);
        stage.setMinHeight(416);
        
        stage.setTitle("ECOFRIENDLY ESPRIT");
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
