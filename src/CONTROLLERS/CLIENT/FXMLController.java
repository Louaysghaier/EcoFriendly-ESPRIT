/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLERS.CLIENT;
import MODELS.Orders;
import MODELS.Service;
import MODELS.User;
import SERVICES.ECOservice;
import SERVICES.OrderService;
import UTIL.MyConnection;
//import java.awt.Insets;
import javafx.geometry.Insets;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author louay
 */
public class FXMLController implements Initializable {
  @FXML
    private Button biblio_btn;

    @FXML
    private StackPane carouselContainer;

    @FXML
    private AnchorPane caroussel;

    @FXML
    private Button dashboard_btn;

    @FXML
    private AnchorPane dashboard_form;

    @FXML
    private Button event_btn;

    @FXML
    private Button forum_btn;

    @FXML
    private Button logout_btn;

    @FXML
    private AnchorPane main_form;

    @FXML
    private Button nextButton;


    @FXML
    private TextField order_amount;

    @FXML
    private Label order_change;

    @FXML
    private TableColumn<?, ?> order_col_orderID;

    @FXML
    private TableColumn<?, ?> order_col_service;

    @FXML
    private TableColumn<?, ?> order_col_type;


    @FXML
    private GridPane order_gridPane;

    @FXML
    private Button order_payBtn;

    @FXML
    private Button order_rating;

    @FXML
    private Button order_receiptBtn;

    @FXML
    private Button order_refreshBtn;

    @FXML
    private Button order_removeBtn;

    @FXML
    private ScrollPane order_scrollPane;

    @FXML
    private TableView<Orders> order_tableView;

    @FXML
    private Label order_total;

    @FXML
    private Button prevButton;

    @FXML
    private Button services_btn;

    @FXML
    private Button sms;

    @FXML
    private Button transport_btn;

    @FXML
    private Label username;
    @FXML
    private AnchorPane dashboardmain_form;
    @FXML
    private AnchorPane service_form;
    @FXML
    private TextField numrotel;
    @FXML
    private Button HISTO;
    @FXML
    private AnchorPane HISTO_form;
    @FXML
    private ScrollPane ordercardsscrollpane;
    @FXML
    private GridPane customers_gridPane;
    @FXML
    private TextField service_reclamation;
    @FXML
    private ComboBox<?> comments;
    @FXML
    private TextField order_reclamation;
    @FXML
    private Button order_payBtn1;
    @FXML
    private Button goback;

    
    //    DISPLAY TOTAL AMOUNT
    private float totalP;
    User user1 = new User();
    OrderService Osrv = new OrderService();
    ObservableList<Orders> ordersList = FXCollections.observableArrayList();
// TO SHOW YOUR DATA IN OUR TABLEVIEW
//       int id;
//public void selectedOrderfromTBV(Orders selectedOrder) {
//    if (selectedOrder != null) {
//        id = selectedOrder.getOrderId(); // Assuming 'id' is a class variable
//        order_col_orderID.setText(String.valueOf(selectedOrder.getOrderId())); // Assuming order_col_orderID is a Label or Text component
//        order_col_type.setText(selectedOrder.getService().getServiceName()); // Assuming order_col_type is a Label or Text component

          // display orders in tableview
    
  
    public void OrderShowData() {
        ordersList.clear(); // Clear the list before adding new data
        ordersList.addAll(Osrv.getorderbyidUser(1));
        order_col_orderID.setCellValueFactory(new PropertyValueFactory<>("num_order"));
        order_col_type.setCellValueFactory(new PropertyValueFactory<>("status"));
        order_col_service.setCellValueFactory(new PropertyValueFactory<>("priceorder"));

// Set the items of the TableView
        order_tableView.setItems(ordersList);

    }
    
    public void displayTotal() {
      totalP=  Osrv.orderTotal();
        order_total.setText("$" + totalP);
    }


    @FXML
    void SMS(ActionEvent event) {

    }

    

        private float orderAmount;
    private float orderChange;

    @FXML
    public void orderAmount() {
     totalP=   Osrv.orderTotal();

        if (order_amount.getText().isEmpty()) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Something add money");
            alert.showAndWait();
        } else if (totalP > Float.parseFloat(order_amount.getText())) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Solde Insuffisant");
            alert.showAndWait();
            order_amount.setText("");
        } else {
            orderAmount = Float.parseFloat(order_amount.getText());
            orderChange = (orderAmount - totalP);
            order_change.setText("$" + orderChange);
        }
    }
    

    @FXML
    void orderPayBtn(ActionEvent event) {

    }

    @FXML
    void orderReceiptBtn(ActionEvent event) {

    }

    @FXML
    void orderRefreshBtn(ActionEvent event) {
 OrderShowData();
// orderDisplayOrder();
        displayTotal();
    
    }
Alert alert;
    @FXML
    void orderRemoveBtn(ActionEvent event) {OrderService ordserv=new OrderService();
Orders selectedOrder = order_tableView.getSelectionModel().getSelectedItem();

    if (selectedOrder == null) {
        alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Message");
        alert.setHeaderText(null);
        alert.setContentText("Please select the item first");
        alert.showAndWait();
    } else {
        int id = selectedOrder.getOrderId();
        try {
            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to DELETE Service ID: " + id);
            Optional<ButtonType> option = alert.showAndWait();
            if (option.get().equals(ButtonType.OK)) {
                ordserv.supprimerorder(id);

                // TO CLEAR ALL FIELDS
              //  servicesClearBtn();

                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Deleted!");
                alert.showAndWait();
                OrderShowData();

            } else {
                alert = new Alert(Alert.AlertType.WARNING);
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

    

    
    @FXML
    void orderSelectOrder(MouseEvent event) {

    }

    @FXML
    void orderrating(ActionEvent event) {

    }

    @FXML
    void switchForm(ActionEvent event) {

    }
    
    void orderAmount(ActionEvent event) {

    }
    
    
    // Alert alert;
    ECOservice eco = new ECOservice();
    OrderService ordserv = new OrderService();
    private int currentIndex = 0;
    private String[] imagePaths = {
        "/STYLING/pic2.png",
        "/STYLING/pic1.jpg",
        "/STYLING/pic3.jpg"
    };
    
    
    
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
//        order_tableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
//    selectedOrderfromTBV(newValue); // Call the method when an item is selected
//});

    }
    private void showImage(int index) {
        String imagePath = imagePaths[index];
        Image image = new Image(imagePath);
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(558); 
        carouselContainer.getChildren().setAll(imageView);
    }
    

    @FXML
    private void Historic(ActionEvent event) {
        if (event.getSource() == HISTO) {
                        service_form.setVisible(false);
                          HISTO_form.setVisible(true);
                         }
    }
    
    @FXML

   public void logout() {

        try {
            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to logout?");
            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {
                // LINK YOUR LOGIN FORM
                Parent root = FXMLLoader.load(getClass().getResource("/GUI/ordercards.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);

                stage.setScene(scene);
                stage.show();

                // TO HIDE YOUR MAIN FORM
                logout_btn.getScene().getWindow().hide();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private final ObservableList<Service> listD = FXCollections.observableArrayList();

    @FXML
    private void goback(ActionEvent event) {
         if (event.getSource() == goback) {
                        service_form.setVisible(true);
                          HISTO_form.setVisible(false);
                         }
    }
    
    public void initializeCards(List<Service> Services) {
    try {
        int row = 0;
        int column = 1;
        for (int i = 0; i < Services.size(); i++) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/servicescards.fxml"));
            AnchorPane pane = loader.load();
            ServicescardsController controller = loader.getController();
            controller.setData(Services.get(i));
            order_gridPane.add(pane, column, row);
            column += 1;
            if (column > 2) {
                column = 1;
                row += 1;
            }
        }
    } catch (IOException ex) {
        Logger.getLogger(ServicescardsController.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    public void initializeOrderCards(List<Orders> orderslist) {
    try {
        int row = 0;
        int column = 1;
        for (int i = 0; i < orderslist.size(); i++) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/ordercards.fxml"));
            AnchorPane pane = loader.load();
           OrdercardsController controller = loader.getController();
            controller.setData(orderslist.get(i));
            customers_gridPane.add(pane, column, row);
            column += 1;
            if (column > 2) {
                column = 1;
                row += 1;
            }
        }
    } catch (IOException ex) {
        Logger.getLogger(ServicescardsController.class.getName()).log(Level.SEVERE, null, ex);
    }
}

   /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {       
        initialize();
        List<Service> lS=eco.getAll();
        initializeCards(lS);
        List<Orders>LSord=Osrv.getorderbyidUser(1);
        initializeOrderCards(LSord);
        
        // TODO
         order_amount.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode() == KeyCode.ENTER) {
                orderAmount();
            }
        });
    }    
}
