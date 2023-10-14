/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELS;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author louay
 */
public class PrestataireServ extends Utilisateur {
    private String Role;
    private List<service> servicesEffectues;
    private service serviceAssigne;

    public PrestataireServ(String Role, List<service> servicesEffectues, service serviceAssigne, String nom, String prenom) {
        super(nom, prenom);
        this.Role = Role;
        this.servicesEffectues = servicesEffectues;
        this.serviceAssigne = serviceAssigne;
    }

    public PrestataireServ(String Role, List<service> servicesEffectues, service serviceAssigne, int idUSER, String nom, String prenom) {
        super(idUSER, nom, prenom);
        this.Role = Role;
        this.servicesEffectues = servicesEffectues;
        this.serviceAssigne = serviceAssigne;
    }

    public PrestataireServ(String Role, List<service> servicesEffectues, int idUSER, String nom, String prenom) {
        super(idUSER, nom, prenom);
        this.Role = Role;
        this.servicesEffectues = servicesEffectues;
    }

    public PrestataireServ(String Role, int idUSER, String nom, String prenom) {
        super(idUSER, nom, prenom);
        this.Role = Role;
    }

    public PrestataireServ(int idUSER, String nom, String prenom) {
        super(idUSER, nom, prenom);
    }

  


    



   

   



    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    public List<service> getServicesEffectues() {
        return servicesEffectues;
    }

    public void setServicesEffectues(List<service> servicesEffectues) {
        this.servicesEffectues = servicesEffectues;
    }

    public service getServiceAssigne() {
        return serviceAssigne;
    }

    public void setServiceAssigne(service serviceAssigne) {
        this.serviceAssigne = serviceAssigne;
    }

    

   

 

   
    
}
