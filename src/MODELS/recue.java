/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELS;

/**
 *
 * @author louay
 */
public class recue {
   private int  idrecue;
    private service demandeurservice;
    private service idservice;
    private float prixfinal;

    public recue(int idrecue, service demandeurservice, service idservice, float prixfinal) {
        this.idrecue = idrecue;
        this.demandeurservice = demandeurservice;
        this.idservice = idservice;
        this.prixfinal = prixfinal;
    }

    public int getIdrecue() {
        return idrecue;
    }

    public void setIdrecue(int idrecue) {
        this.idrecue = idrecue;
    }

    public service getDemandeurservice() {
        return demandeurservice;
    }

    public void setDemandeurservice(service demandeurservice) {
        this.demandeurservice = demandeurservice;
    }

    public service getIdservice() {
        return idservice;
    }

    public void setIdservice(service idservice) {
        this.idservice = idservice;
    }

    public float getPrixfinal() {
        return prixfinal;
    }

    public void setPrixfinal(float prixfinal) {
        this.prixfinal = prixfinal;
    }
    
    
    
}
