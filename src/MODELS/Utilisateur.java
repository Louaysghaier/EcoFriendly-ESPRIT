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
public class Utilisateur {
    private int idUSER;
     private String nomuser;
    private String prenomuser;
  

    public Utilisateur(String nom, String prenom) {
        this.nomuser = nom;
        this.prenomuser = prenom;
       
    }

    public Utilisateur(int idUSER, String nom, String prenom) {
        this.idUSER = idUSER;
        this.nomuser = nom;
        this.prenomuser = prenom;
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

    

    
    }


