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
    private String LieuEvent;
    private Date dateDebutEvent;
    private Date dateFinEvent;
    private String nbmaxParticipant;
    private String PrixTicket;
    private String nomEvent;
    private String typeEvent;
    private String descriptionEvent;
  
     private List<Participation> participations = new ArrayList<>();


    public Event(Integer idEvent, String LieuEvent, Date dateDebutEvent, Date dateFinEvent,
                 String nbmaxParticipant, String PrixTicket, String nomEvent, String typeEvent, String descriptionEvent) {
        this.idEvent = idEvent;
        this.LieuEvent = LieuEvent;
        this.dateDebutEvent = dateDebutEvent;
        this.dateFinEvent = dateFinEvent;
        this.nbmaxParticipant = nbmaxParticipant;
        this.PrixTicket = PrixTicket;
        this.nomEvent = nomEvent;
        this.typeEvent = typeEvent;
        this.descriptionEvent = descriptionEvent;
       
    }
    
    public Event( String LieuEvent, Date dateDebutEvent, Date dateFinEvent,
                 String nbmaxParticipant, String PrixTicket, String nomEvent, String typeEvent, String descriptionEvent) {
      
        this.LieuEvent = LieuEvent;
        this.dateDebutEvent = dateDebutEvent;
        this.dateFinEvent = dateFinEvent;
        this.nbmaxParticipant = nbmaxParticipant;
        this.PrixTicket = PrixTicket;
        this.nomEvent = nomEvent;
        this.typeEvent = typeEvent;
        this.descriptionEvent = descriptionEvent;
    }

       
    
    
    
    public Integer getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(Integer idEvent) {
        this.idEvent = idEvent;
    }

    public String getLieuEvent() {
        return LieuEvent;
    }

    public void setLieuEvent(String LieuEvent) {
        this.LieuEvent = LieuEvent;
    }

    public Date getDateDebutEvent() {
        return dateDebutEvent;
    }

    public void setDateDebutEvent(Date dateDebutEvent) {
        this.dateDebutEvent = dateDebutEvent;
    }

    public Date getDateFinEvent() {
        return dateFinEvent;
    }

    public void setDateFinEvent(Date dateFinEvent) {
        this.dateFinEvent = dateFinEvent;
    }

    public String getNbmaxParticipant() {
        return nbmaxParticipant;
    }

    public void setNbmaxParticipant(String nbmaxParticipant) {
        this.nbmaxParticipant = nbmaxParticipant;
    }

    public String getPrixTicket() {
        return PrixTicket;
    }

    public void setPrixTicket(String PrixTicket) {
        this.PrixTicket = PrixTicket;
    }

    public String getNomEvent() {
        return nomEvent;
    }

    public void setNomEvent(String nomEvent) {
        this.nomEvent = nomEvent;
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

     public List<Participation> getParticipations() {
        return participations;
    }

    public void setParticipations(List<Participation> participations) {
        this.participations = participations;
    }
    @Override
    public String toString() {
        return "Event [idEvent=" + idEvent + ", LieuEvent=" + LieuEvent + ", dateDebutEvent=" + dateDebutEvent
                + ", dateFinEvent=" + dateFinEvent + ", nbmaxParticipant=" + nbmaxParticipant + ", PrixTicket="
                + PrixTicket + ", nomEvent=" + nomEvent + ", typeEvent=" + typeEvent + ", descriptionEvent="
                + descriptionEvent + "]";
    }
      public void addParticipation(Event event, Participation participation) {
        if (event.equals(this)) {
            participations.add(participation);
        } else {
            System.err.println("Erreur : Tentative d'ajouter une participation à un événement incorrect.");
        }
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
}
    

