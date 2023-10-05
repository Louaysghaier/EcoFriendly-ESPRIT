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
    private List<ECOservice> servicesEffectues;
    private ECOservice serviceAssigne;

    public PrestataireServ(int idUSER, String nom, String prenom, Role role, List<ECOservice> servicesEffectues, ECOservice serviceAssigne) {
        super(idUSER, nom, prenom, role);
        this.servicesEffectues = servicesEffectues;
        this.serviceAssigne = serviceAssigne;
    }

    public PrestataireServ(String nom, String prenom, Role role) {
        super(nom, prenom, role);
    }

   
    public PrestataireServ(int idUSER, String nom, String prenom) {
                super(idUSER, nom, prenom);

    }

    @Override
    public String toString() {
        return "PrestataireServ{" + "servicesEffectues=" + servicesEffectues + ", serviceAssigne=" + serviceAssigne + '}';
    }

 
    

    public List<ECOservice> getServicesEffectues() {
        return servicesEffectues;
    }

    public void setServicesEffectues(List<ECOservice> servicesEffectues) {
        this.servicesEffectues = servicesEffectues;
    }

    public ECOservice getServiceAssigne() {
        return serviceAssigne;
    }

    public void setServiceAssigne(ECOservice serviceAssigne) {
        this.serviceAssigne = serviceAssigne;
    }
}
