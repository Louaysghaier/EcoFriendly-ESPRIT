/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mekni
 */
public class User {
    
    
      private int iduser;
      private String username;
      private double wallet;
    

    public User(int iduser,String username,double wallet) {
        this.iduser = iduser;
        this.username = username;
        this.wallet=wallet;
    }
    
    
    public User(int iduser,String username) {
        this.iduser = iduser;
        this.username = username;
        
    }
    
    
    
public User() {
        }

public int getIduser() {
    return iduser;
}
public void setIduser(int iduser) {
    this.iduser = iduser;
}

public String getUsername() {
    return username;
}
public void setUsername(String username) {
    this.username = username;
}
    
public void setiduser(String username) {
    this.username = username;
}

public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

private List<Participation> participations = new ArrayList<>();



}

    
    
    
    
    
    
