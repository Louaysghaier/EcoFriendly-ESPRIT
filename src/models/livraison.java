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
public class livraison extends service {
       private int livraisonId;
    private String adresseLivraison;
    private List<String> articles;

    public livraison(int livraisonId, String adresseLivraison, List<String> articles, String type, Utilisateur demandeur) {
        super(type, demandeur);
        this.livraisonId = livraisonId;
        this.adresseLivraison = adresseLivraison;
        this.articles = articles;
    }

    

    public int getLivraisonId() {
        return livraisonId;
    }

    public void setLivraisonId(int livraisonId) {
        this.livraisonId = livraisonId;
    }

    public String getAdresseLivraison() {
        return adresseLivraison;
    }

    public void setAdresseLivraison(String adresseLivraison) {
        this.adresseLivraison = adresseLivraison;
    }

    public List<String> getArticles() {
        return articles;
    }

    public void setArticles(List<String> articles) {
        this.articles = articles;
    }

 
}
