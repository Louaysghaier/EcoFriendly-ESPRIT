/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELS;

/**
 *
 * @author Dorra
 */
class User {
     private Integer iduser;
    private String nomuser;
    private String prenomuser ;
    private String mailuser ;
    private String mdpuser ;
    private String adressuser;
    private String walletuser ;
    private String classeuser ;
    private String roleuser ;

    public User(Integer iduser, String nomuser, String prenomuser, String mailuser, String mdpuser, String adressuser, String walletuser, String classeuser, String roleuser) {
        this.iduser = iduser;
        this.nomuser = nomuser;
        this.prenomuser = prenomuser;
        this.mailuser = mailuser;
        this.mdpuser = mdpuser;
        this.adressuser = adressuser;
        this.walletuser = walletuser;
        this.classeuser = classeuser;
        this.roleuser = roleuser;
    }

    public User(String nomuser, String prenomuser, String mailuser, String mdpuser, String adressuser, String walletuser, String classeuser, String roleuser) {
        this.nomuser = nomuser;
        this.prenomuser = prenomuser;
        this.mailuser = mailuser;
        this.mdpuser = mdpuser;
        this.adressuser = adressuser;
        this.walletuser = walletuser;
        this.classeuser = classeuser;
        this.roleuser = roleuser;
    }

    public User(Integer iduser) {
        this.iduser = iduser;
    }

    public User() {
    }

    public Integer getIduser() {
        return iduser;
    }

    public String getNomuser() {
        return nomuser;
    }

    public String getPrenomuser() {
        return prenomuser;
    }

    public String getMailuser() {
        return mailuser;
    }

    public String getMdpuser() {
        return mdpuser;
    }

    public String getAdressuser() {
        return adressuser;
    }

    public String getWalletuser() {
        return walletuser;
    }

    public String getClasseuser() {
        return classeuser;
    }

    public String getRoleuser() {
        return roleuser;
    }

    public void setIduser(Integer iduser) {
        this.iduser = iduser;
    }

    public void setNomuser(String nomuser) {
        this.nomuser = nomuser;
    }

    public void setPrenomuser(String prenomuser) {
        this.prenomuser = prenomuser;
    }

    public void setMailuser(String mailuser) {
        this.mailuser = mailuser;
    }

    public void setMdpuser(String mdpuser) {
        this.mdpuser = mdpuser;
    }

    public void setAdressuser(String adressuser) {
        this.adressuser = adressuser;
    }

    public void setWalletuser(String walletuser) {
        this.walletuser = walletuser;
    }

    public void setClasseuser(String classeuser) {
        this.classeuser = classeuser;
    }

    public void setRoleuser(String roleuser) {
        this.roleuser = roleuser;
    }

    

    }

    

  
    
