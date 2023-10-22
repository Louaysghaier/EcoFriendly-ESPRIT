/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Mekni
 */
public class Participation {
    private int idParticipation;
    private Event event; // Clé étrangère faisant référence à l'événement associé
    private User user; // Clé étrangère faisant référence à l'utilisateur associé
    private String codeQR; // Code QR lié à la participation (si nécessaire)

    public Participation(){
        // Constructeur vide
    }
    
    public Participation(int idParticipation, Event event, User user, String codeQR) {
        this.idParticipation = idParticipation;
        this.event = event;
        this.user = user;
        this.codeQR = codeQR;
    }

    public int getIdParticipation() {
        return idParticipation;
    }

    public void setIdParticipation(int idParticipation) {
        this.idParticipation = idParticipation;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCodeQR() {
        return codeQR;
    }

    public void setCodeQR(String codeQR) {
        this.codeQR = codeQR;
    }
    
    public int getIdUser() {
    return user.getIduser();
}


}
