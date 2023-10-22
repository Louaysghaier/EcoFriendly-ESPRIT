/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mekni
 */
public class Event {
 
    private Integer idEvent;
    private String nomEvent;
    private Date dateDebutEvent;
    private String Durée; // Renommé de "Duée" en "Durée"
    private String LieuEvent;
    private Double PrixTicket;
    private Integer nbmaxParticipant;
    private String typeEvent;
    private String descriptionEvent;
    private String image;
     private User iduser;
     private User username;
    private List<Participation> participations = new ArrayList<>();
    private User user;

       // Constructeur pour un événement avec ID
    
    public Event(){
        
    }
    
    
    public Event(Integer idEvent, String nomEvent, Date dateDebutEvent, String Durée, String LieuEvent, Double PrixTicket, Integer nbmaxParticipant, String typeEvent, String descriptionEvent, String image) {
        this.idEvent = idEvent;
        this.nomEvent = nomEvent;
        this.dateDebutEvent = dateDebutEvent;
        this.Durée = Durée;
        this.LieuEvent = LieuEvent;
        this.PrixTicket = PrixTicket;
        this.nbmaxParticipant = nbmaxParticipant;
        this.typeEvent = typeEvent;
        this.descriptionEvent = descriptionEvent;
        this.image = image;
    }

    // Constructeur pour un événement sans ID (ID généré automatiquement par la base de données)
    public Event(String nomEvent, Date dateDebutEvent, String Durée, String LieuEvent, Double PrixTicket, Integer nbmaxParticipant, String typeEvent, String descriptionEvent, String image,User iduser) {
        this.nomEvent = nomEvent;
        this.dateDebutEvent = dateDebutEvent;
        this.Durée = Durée;
        this.LieuEvent = LieuEvent;
        this.PrixTicket = PrixTicket;
        this.nbmaxParticipant = nbmaxParticipant;
        this.typeEvent = typeEvent;
        this.descriptionEvent = descriptionEvent;
        this.image = image;
        this.iduser = iduser;
        
    }
    
    public Event(String nomEvent, Date dateDebutEvent, String Durée, String LieuEvent, Double PrixTicket, Integer nbmaxParticipant, String typeEvent, String descriptionEvent, String image) {
        this.nomEvent = nomEvent;
        this.dateDebutEvent = dateDebutEvent;
        this.Durée = Durée;
        this.LieuEvent = LieuEvent;
        this.PrixTicket = PrixTicket;
        this.nbmaxParticipant = nbmaxParticipant;
        this.typeEvent = typeEvent;
        this.descriptionEvent = descriptionEvent;
        this.image = image;
        
        
    }
    
    public Event(String nomEvent,  Double PrixTicket, String image) {
        this.nomEvent = nomEvent;
        
        this.PrixTicket = PrixTicket;
      
        this.image = image;
    
        
    }
    
    
    
    
    
    
    
    
    
    
public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
    // Getters and setters for all attributes

    public Integer getIdEvent() {
    return idEvent;
}

public void setIdEvent(Integer idEvent) {
    this.idEvent = idEvent;
}

public String getNomEvent() {
    return nomEvent;
}

public void setNomEvent(String nomEvent) {
    this.nomEvent = nomEvent;
}

public Date getDateDebutEvent() {
    return dateDebutEvent;
}

public void setDateDebutEvent(Date dateDebutEvent) {
    this.dateDebutEvent = dateDebutEvent;
}

public String getDurée() {
    return Durée;
}

public void setDurée(String Durée) {
    this.Durée = Durée;
}

public String getLieuEvent() {
    return LieuEvent;
}

public void setLieuEvent(String LieuEvent) {
    this.LieuEvent = LieuEvent;
}

public Double getPrixTicket() {
    return PrixTicket;
}

public void setPrixTicket(Double PrixTicket) {
    this.PrixTicket = PrixTicket;
}

public Integer getNbmaxParticipant() {
    return nbmaxParticipant;
}

public void setNbmaxParticipant(Integer nbmaxParticipant) {
    this.nbmaxParticipant = nbmaxParticipant;
}

public String getTypeEvent() {
    return typeEvent;
}

public void setTypeEvent(String typeEvent) {
    this.typeEvent = typeEvent;
}

public String getDescriptionEvent() {
    return descriptionEvent;
}

public void setDescriptionEvent(String descriptionEvent) {
    this.descriptionEvent = descriptionEvent;
}

public String getImage() {
    return image;
}

public void setImage(String image) {
    this.image = image;
}

    

  public User getIdUser() {
        return iduser;
    }

    // Setter pour iduser
    public void setIdUser(User user) {
        this.iduser = user;
    }
    
    
     public User getUsername() {
        return username;
    }

    public void setUsername(User username) {
        this.username = username;
    }
    
    
    
    public List<Participation> getParticipations() {
        return participations;
    }

    public void setParticipations(List<Participation> participations) {
        this.participations = participations;
    }

    public void addParticipation(Participation participation) {
        participations.add(participation);
    }
    

    public void removeParticipation(Participation participation) {
        participations.remove(participation);
    }

    
    
    
    
 
    
    
    
    
    
    
    public void afficherParticipations() {
        if (participations.isEmpty()) {
            System.out.println("Aucune participation pour cet événement.");
        } else {
            System.out.println("Liste des participations de l'événement '" + nomEvent + "' :");
            for (Participation participation : participations) {
                System.out.println("ID de la participation : " + participation.getIdParticipation());
                System.out.println("ID de l'utilisateur : " + participation.getIdUser());
                System.out.println("Code QR : " + participation.getCodeQR());
                System.out.println("-------------------------");
            }
        }
    }

    @Override
    public String toString() {
        return "Event [idEvent=" + idEvent + ", nomEvent=" + nomEvent + ", dateDebutEvent=" + dateDebutEvent
                + ", Durée=" + Durée + ", LieuEvent=" + LieuEvent + ", PrixTicket=" + PrixTicket
                + ", nbmaxParticipant=" + nbmaxParticipant + ", typeEvent=" + typeEvent
                + ", descriptionEvent=" + descriptionEvent + ", image=" + image + "]";
    }
}
