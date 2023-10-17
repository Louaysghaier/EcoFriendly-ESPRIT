/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICES;

import INTERFACES.IOrders;
import MODELS.Orders;
import MODELS.Service;
import MODELS.User;
import UTIL.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author louay
 */
public class OrderService implements IOrders<Orders> {
    private ObservableList<Service> servicesList = FXCollections.observableArrayList();
    private ECOservice eco=new ECOservice();
    @Override
public void ajouterorder(Orders order) {
    String insertQuery = "INSERT INTO `orders`( `num_order`, `userId`, `pickupDateTime`, `status`, `services`, `phonenumber`, `priceOrder`) VALUES (?, ?, ?, ?, ?,?,?)";
    
    try {
        Connection connection = MyConnection.getInstance().getCnx();
        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
        int i=1;
        // Set values for the prepared statement
        preparedStatement.setInt(i++, order.getNum_order());
        preparedStatement.setInt(i++, 1); // Assuming getUserId() retrieves the user's ID
        preparedStatement.setTimestamp(i++, new Timestamp(order.getPickupDateTime().getTime()));
        preparedStatement.setString(i++, order.getStatus());
        preparedStatement.setInt(i++, order.getServices().getServiceId());
                preparedStatement.setString(i++, order.getPhonenumber());

        preparedStatement.setFloat(i++, order.getPriceorder());

        // Execute the SQL statement
        preparedStatement.executeUpdate();
        
        System.out.println("Order added successfully!");
        
        // Close the resources (preparedStatement and connection)
        preparedStatement.close();
    } catch (SQLException ex) {
        System.err.println("Error while adding order: " + ex.getMessage());
    }
}


    

    @Override
public void supprimerorder(int id) {
    String deleteQuery = "DELETE FROM orders WHERE order_id = ?";
    
    try {
        Connection connection = MyConnection.getInstance().getCnx();
        PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
        
        // Set the ID parameter for the prepared statement
        preparedStatement.setInt(1, id);
        
        // Execute the SQL statement to delete the order
        int rowsDeleted = preparedStatement.executeUpdate();
        
        if (rowsDeleted > 0) {
            System.out.println("Order with ID " + id + " deleted successfully!");
        } else {
            System.out.println("No order found with ID " + id);
        }
        
        // Close the resources (preparedStatement and connection)
        preparedStatement.close();
       // connection.close();
    } catch (SQLException ex) {
        System.err.println("Error while deleting order: " + ex.getMessage());
    }
}

   
 @Override
public Orders getOneorder(int id) {
    Orders order = null;
    String selectQuery = "SELECT * FROM orders WHERE order_id = ?";
    
    try {
        Connection connection = MyConnection.getInstance().getCnx();
        PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        
        if (resultSet.next()) {
            int orderId = resultSet.getInt("orderId");
            int numOrder = resultSet.getInt("num_order");
            int userId = resultSet.getInt("userId");
            // Retrieve other fields from the result set
            String status = resultSet.getString("status");
            Date pickupDateTime = resultSet.getTimestamp("pickupDateTime");
            int serviceId = resultSet.getInt("services");
            String phonenumber = resultSet.getString("phonenumber");
            float priceorder=resultSet.getFloat("priceorder");
            // Retrieve User, Date, and Service objects using appropriate methods
            
            // Retrieve User object (assuming you have a UserDAO to retrieve User by ID)
           User user1 = new User(resultSet.getInt("userId")); 
           // User user = user.getUserId();
            
            // Retrieve Service object (assuming you have a ServiceDAO to retrieve Service by ID)
            Service service = eco.getOne(serviceId);
            
            // Create an Orders object with retrieved data
            order = new Orders();
            order.setOrderId(orderId);
            order.setNum_order(numOrder);
            order.setUser(user1);
            order.setPickupDateTime(pickupDateTime);
            order.setStatus(status);
            order.setServices(service);
            order.setPhonenumber(phonenumber);
            order.setPriceorder(priceorder);
        } else {
            System.out.println("No order found with ID " + id);
        }
        
        resultSet.close();
        preparedStatement.close();
        connection.close();
    } catch (SQLException ex) {
        System.err.println("Error while retrieving order: " + ex.getMessage());
    }
    
    return order;
}

User user1=new User(1);
        

    @Override
    public List<Orders> getAllorder() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
   public float orderTotal() {
    String sql = "SELECT SUM(price) FROM orders WHERE userId = ?";

    float totalP = 0; // Initialize totalP here

    try (Connection connection = MyConnection.getInstance().getCnx();
         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
        preparedStatement.setInt(1, user1.getIduser()); // Set the user ID parameter

        try (ResultSet result = preparedStatement.executeQuery()) {
            if (result.next()) {
                totalP = result.getFloat(1); // Retrieve the result using the column index
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return totalP;
}

}
