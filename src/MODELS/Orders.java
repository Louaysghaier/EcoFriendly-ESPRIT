/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELS;

import java.util.Date;
import java.util.List;

/**
 *
 * @author louay
 */
public class Orders {
    private int orderId;
    private int num_order;
    private User user;
    private Date pickupDateTime;
    private String status;
    private Service services;
    private String phonenumber;
    private float priceorder;

    public float getPriceorder() {
        return priceorder;
    }

    public void setPriceorder(float priceorder) {
        this.priceorder = priceorder;
    }

    public Orders(int orderId, int num_order, User user, Date pickupDateTime, String status, Service services, String phonenumber, float priceorder) {
        this.orderId = orderId;
        this.num_order = num_order;
        this.user = user;
        this.pickupDateTime = pickupDateTime;
        this.status = status;
        this.services = services;
        this.phonenumber = phonenumber;
        this.priceorder = priceorder;
    }
   

    public Orders(int orderId, int num_order, User user, Date pickupDateTime, Date deliveryDateTime, String status, Service services, String phonenumber) {
        this.orderId = orderId;
        this.num_order = num_order;
        this.user = user;
        this.pickupDateTime = pickupDateTime;
        this.status = status;
        this.services = services;
        this.phonenumber = phonenumber;
    }

    public Orders(int orderId, User user, Date pickupDateTime, Date deliveryDateTime, String status, Service services) {
        this.orderId = orderId;
        this.user = user;
        this.pickupDateTime = pickupDateTime;
        this.status = status;
        this.services = services;
    }

    public Orders(int orderId, int num_order, User user, Date pickupDateTime, Date deliveryDateTime, String status) {
        this.orderId = orderId;
        this.num_order = num_order;
        this.user = user;
        this.pickupDateTime = pickupDateTime;

        this.status = status;
    }

    public Orders() {
    }
    

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getNum_order() {
        return num_order;
    }

    public void setNum_order(int num_order) {
        this.num_order = num_order;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getPickupDateTime() {
        return pickupDateTime;
    }

    public void setPickupDateTime(Date pickupDateTime) {
        this.pickupDateTime = pickupDateTime;
    }

    
    public void setDeliveryDateTime(Date deliveryDateTime) {

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Service getServices() {
        return services;
    }

    public void setServices(Service services) {
        this.services = services;
    }
 public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}
