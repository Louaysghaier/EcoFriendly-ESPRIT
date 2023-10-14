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
public class service {
    
    private int serviceId;
    private String type; // Livraison, lessive, maintenance, etc.
    private EtatService etat; // Enum(en attente, en cours, terminé)
    private Date dateDemande;
    private Utilisateur demandeur; // Utilisateur qui a demandé le service
    private PrestataireServ prestataire;//prestateur de service 
    private float prixservice ;
    public service(String type, EtatService etat, Date dateDemande, Utilisateur demandeur, PrestataireServ prestataire) {
        this.type = type;
        this.etat = etat;
        this.dateDemande = dateDemande;
        this.demandeur = demandeur;
        this.prestataire = prestataire;
    }

    // Constructeur
    
    public service(int serviceId, String type, EtatService etat, Date dateDemande, Utilisateur demandeur, PrestataireServ prestataire, float prixservice) {
        this.serviceId = serviceId;
        this.type = type;
        this.etat = etat;
        this.dateDemande = dateDemande;
        this.demandeur = demandeur;
        this.prestataire = prestataire;
        this.prixservice = prixservice;
    }

    public service(String type, Utilisateur demandeur) {
        this.type = type;
        this.etat = EtatService.EN_ATTENTE;
        this.dateDemande = new Date();
        this.demandeur = demandeur;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public EtatService getEtat() {
        return etat;
    }

    public void setEtat(EtatService etat) {
        this.etat = etat;
    }

    public Date getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande(Date dateDemande) {
        this.dateDemande = dateDemande;
    }

    public Utilisateur getDemandeur() {
        return demandeur;
    }

    public void setDemandeur(Utilisateur demandeur) {
        this.demandeur = demandeur;
    }

    public PrestataireServ getPrestataire() {
        return prestataire;
    }

    public void setPrestataire(PrestataireServ prestataire) {
        this.prestataire = prestataire;
    }

  

  
               
            
        
    
    
}
