/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.List;

/**
 *
 * @author louay
 */
public class PrestataireServ extends Utilisateur {
    private List<service> servicesEffectues;
    private service serviceAssigne;

    public PrestataireServ(int idUSER, String nom, String prenom, String role, List<service> servicesEffectues, service serviceAssigne) {
        super(idUSER, nom, prenom, role);
        this.servicesEffectues = servicesEffectues;
        this.serviceAssigne = serviceAssigne;
    }

    public PrestataireServ(String nom, String prenom, String role) {
        super(nom, prenom, role);
    }

   
    public PrestataireServ(int idUSER, String nom, String prenom) {
                super(idUSER, nom, prenom);

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
