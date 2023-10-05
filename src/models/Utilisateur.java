 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author louay
 */
public class Utilisateur {
    private int idUSER;
     private String nom;
    private String prenom;
  
    private Role role; 

    public Utilisateur(String nom, String prenom, Role role) {
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
    }

    public Utilisateur(int idUSER, String nom, String prenom, Role role) {
        this.idUSER = idUSER;
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
    }

    public Utilisateur(int idUSER, String nom, String prenom) {
        this.idUSER = idUSER;
        this.nom = nom;
        this.prenom = prenom;
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "nom=" + nom + ", prenom=" + prenom + ", role=" + role + '}';
    }

   
    public int getIdUSER() {
        return idUSER;
    }

    public void setIdUSER(int idUSER) {
        this.idUSER = idUSER;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    
    }


