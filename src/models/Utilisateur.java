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
     private String nomuser;
    private String prenomuser;
  
    private String role; 

    public Utilisateur(String nom, String prenom, String role) {
        this.nomuser = nom;
        this.prenomuser = prenom;
        this.role = role;
    }

    public Utilisateur(int idUSER, String nom, String prenom, String role) {
        this.idUSER = idUSER;
        this.nomuser = nom;
        this.prenomuser = prenom;
        this.role = role;
    }

    public Utilisateur(int idUSER, String nom, String prenom) {
        this.idUSER = idUSER;
        this.nomuser = nom;
        this.prenomuser = prenom;
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

   
    public int getIdUSER() {
        return idUSER;
    }

    public void setIdUSER(int idUSER) {
        this.idUSER = idUSER;
    }

    public String getNomuser() {
        return nomuser;
    }

    public void setNomuser(String nomuser) {
        this.nomuser = nomuser;
    }

    public String getPrenomuser() {
        return prenomuser;
    }

    public void setPrenomuser(String prenomuser) {
        this.prenomuser = prenomuser;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    
    }


