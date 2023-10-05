/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Mekni
 */
public class Participation {
      private int idParticipation;
    private int idEvent; // Clé étrangère faisant référence à l'événement associé
    private int idUser; // Clé étrangère faisant référence à l'utilisateur associé
    private String codeQR; // Code QR lié à la participation (si nécessaire)

    // Constructeur
      public Participation( int idUser, String codeQR) {
       
        this.idUser = idUser;
        this.codeQR = codeQR;
      }
    public Participation(int idEvent, int idUser, String codeQR) {
        this.idEvent = idEvent;
        this.idUser = idUser;
        this.codeQR = codeQR;
    }
public Participation(int idParticipation,int idEvent, int idUser, String codeQR) {
        this.idParticipation=idParticipation;
         this.idEvent = idEvent;
        this.idUser = idUser;
        this.codeQR = codeQR;
    }

    
    
    // Getters et setters
    public int getIdParticipation() {
        return idParticipation;
    }

    public void setIdParticipation(int idParticipation) {
        this.idParticipation = idParticipation;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getCodeQR() {
        return codeQR;
    }

    public void setCodeQR(String codeQR) {
        this.codeQR = codeQR;
    }

    
    
    @Override
public String toString() {
    return "Participation{" +
            "idParticipation=" + idParticipation +
            ", idEvent=" + idEvent +
            ", iduser=" + idUser +
            ", codeqr='" + codeQR + '\'' +
            '}';
}
    
    
    }
