/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELS;

import java.util.Date;

/**
 *
 * @author louay
 */
public class Service {
    private int serviceId;
    private String serviceName;
    private double price;
    private String img;

    // Constructors, getters, setters, and other methods can be added here

    public Service(int serviceId, String serviceName, double price, String img) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.price = price;
        this.img = img;
    }

    public Service(int serviceId, String serviceName, double price) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.price = price;
    }

    public Service() {
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setImg(byte[] image) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

