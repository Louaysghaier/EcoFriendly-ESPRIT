/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLERS.ADMIN;

import MODELS.Service;
import SERVICES.ECOservice;
import UTIL.MyConnection;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;


/**
 * FXML Controller class
 *
 * @author louay
 */
public class AdminserviceController implements Initializable {

    @FXML
    private AnchorPane service_form;
    @FXML
    private TableView<Service> service_tableView;
    @FXML
    private TableColumn<?, ?> service_col_service;
    @FXML
    private TableColumn<?, ?> service_col_PPK;
    @FXML
    private TableColumn<?, ?> service_col_DU;
    private TextField service_id;
    private ComboBox<?> service_clothType;
    private ComboBox<?> service_service;
    @FXML
    private TextField service_PPK;
    @FXML
    private ImageView service_imageView;
    @FXML
    private Button service_importBtn;
    @FXML
    private Button service_insertBtn;
    @FXML
    private Button service_updateBtn;
    @FXML
    private Button service_clearBtn;
    @FXML
    private Button service_deleteBtn;
    @FXML
    private ComboBox<String> service_type;
     private File selectedFile;

    /**
     * Initializes the controller class.
     */
    @Override
public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> services = FXCollections.observableArrayList();
        services.add("pressing");
        services.add("maintenance");
        services.add("delivery");

        // Assuming service_type is a ComboBox in your FXML file
        service_type.setItems(services);
         servicesShowData();
          // Set up a listener for the TableView's selection model
        service_tableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            // Call servicesSelectData() with the selected Service object
            servicesSelectData(newValue);});
                }




// TO SHOW YOUR DATA IN OUR TABLEVIEW
int id;
ObservableList<Service> servicesListData = FXCollections.observableArrayList();
ECOservice eco = new ECOservice();
        Alert alert;
        Connection cnx = MyConnection.getInstance().getCnx();






public void servicesSelectData(Service selectedService) {
   // Service selectedService = service_tableView.getSelectionModel().getSelectedItem();
    
    if (selectedService != null) {
        id = selectedService.getServiceId();
        service_type.setValue(selectedService.getServiceName());
        service_PPK.setText(String.valueOf(selectedService.getPrice()));

        // Load and display the image
        String imageUrl = selectedService.getImg();
        if (imageUrl != null && !imageUrl.isEmpty()) {
            Image selectedImage = new Image( imageUrl, 103, 115, false, true);
            service_imageView.setImage(selectedImage);
        } else {
            // Handle the case where there is no image URL
            service_imageView.setImage(null);
        }
    }
}

public void servicesShowData() {
    servicesListData.clear(); // Clear the list before adding new data
    servicesListData.addAll(eco.getAll());

    service_col_service.setCellValueFactory(new PropertyValueFactory<>("serviceName"));
    service_col_PPK.setCellValueFactory(new PropertyValueFactory<>("price"));
    service_col_DU.setCellValueFactory(new PropertyValueFactory<>("img"));

    service_tableView.setItems(servicesListData);
}

    @FXML
    private void servicesSelectData(MouseEvent event) {
    }

    @FXML
    private void servicesImportBtn(ActionEvent event) throws IOException {
        
     
         FileChooser fileChooser = new FileChooser();
fileChooser.setTitle("Choisir une image");
// Définir les filtres pour n'afficher que les fichiers image
fileChooser.getExtensionFilters().addAll(
    new FileChooser.ExtensionFilter( "*.png", "*.jpg", "*.gif")
);

// Ouvrir la boîte de dialogue de sélection de fichier
File imageFile = fileChooser.showOpenDialog(((Node) event.getSource()).getScene().getWindow());

if (imageFile != null) {
    // Load the selected image and set it to the ImageView
    Image image = new Image(imageFile.toURI().toString(),103, 115, false, true);
    service_imageView.setImage(image);
}

}
         
         
        
        
    

    @FXML
   
      public void servicesInsertBtn() {
 
        if (
                 service_type.getSelectionModel().getSelectedItem() == null
                || service_PPK.getText().isEmpty() ) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("All fields are necessary to be filled");
            alert.showAndWait();
        } else {
            try{
        Service serv =new Service ();
         
            double price = Double.parseDouble(service_PPK.getText());
        serv.setServiceName((String)service_type.getSelectionModel().getSelectedItem());
             serv.setPrice(price);
             
            serv.setImg(service_imageView.getImage().impl_getUrl());
            eco.ajouter(serv);
            alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added!");
                    alert.showAndWait();
                   servicesShowData();

        }
            
            
            
         catch (Exception e) {
                e.printStackTrace();
            }}
        }

    

    @FXML
private void servicesUpdateBtn(ActionEvent event) {
   // Call servicesSelectData() to ensure a valid item is selected
    Service selectedService = service_tableView.getSelectionModel().getSelectedItem();
    if (selectedService == null) {
        alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Message");
        alert.setHeaderText(null);
        alert.setContentText("Please select the item first");
        alert.showAndWait();
    } else {
        try {
            // Populate the fields with the selected service's data
           
            // Modify the selected service
            Service modifiedService = new Service();
            double price = Double.parseDouble(service_PPK.getText());
            modifiedService.setServiceId(selectedService.getServiceId());
            modifiedService.setServiceName((String)service_type.getSelectionModel().getSelectedItem());
            modifiedService.setPrice(price);
            modifiedService.setImg(service_imageView.getImage().impl_getUrl());

            //ECOservice eco = new ECOservice();
            eco.modifier(modifiedService);

            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Message");
            alert.setHeaderText(null);
            alert.setContentText("Successfully Updated!");
            alert.showAndWait();

            // Refresh the TableView to reflect the changes
            servicesShowData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


    @FXML
    private void servicesClearBtn() {
        service_type.getSelectionModel().clearSelection();
        service_PPK.setText("");
        service_imageView.setImage(null);
    }

    @FXML
    private void servicesDeleteBtn(ActionEvent event) {
    //// Call servicesSelectData() to ensure a valid item is selected
    Service selectedService = service_tableView.getSelectionModel().getSelectedItem();

    if (selectedService == null) {
        alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error Message");
        alert.setHeaderText(null);
        alert.setContentText("Please select the item first");
        alert.showAndWait();
    } else {
        int id = selectedService.getServiceId();
        try {
            alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to DELETE Service ID: " + id);
            Optional<ButtonType> option = alert.showAndWait();
            if (option.get().equals(ButtonType.OK)) {
                eco.supprimer(id);
                System.out.println("louay hna");

                // TO CLEAR ALL FIELDS
                servicesClearBtn();

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Deleted!");
                alert.showAndWait();
                servicesShowData();

            } else {
                alert = new Alert(AlertType.WARNING);
                alert.setTitle("Warning Message");
                alert.setHeaderText(null);
                alert.setContentText("Cancelled");
                alert.showAndWait();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

}
