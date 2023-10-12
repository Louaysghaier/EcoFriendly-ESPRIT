/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;

/**
 *
 * @author Grati Eya
 */
public class Post {
    
    private int idPost, idUser,nbreComment;
    private Date dateCreationp;
    private String nomUser, prenomUser;
    private int idSujet;
    
    public Post() {
    }

    public Post(int idPost, int idUser, int nbreComment, Date dateCreationp, String nomUser, String prenomUser, int idSujet) {
        this.idPost = idPost;
        this.idUser = idUser;
        this.nbreComment = nbreComment;
        this.dateCreationp = dateCreationp;
        this.nomUser = nomUser;
        this.prenomUser = prenomUser;
        this.idSujet = idSujet;
    }
    
    public Post( int idUser, int nbreComment, Date dateCreationp, String nomUser, String prenomUser) {
        this.idUser = idUser;
        this.nbreComment = nbreComment;
        this.dateCreationp = dateCreationp;
        this.nomUser = nomUser;
        this.prenomUser = prenomUser;
    }

    public int getIdPost() {
        return idPost;
    }
    
    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    
    public int getIdSujet() {
        return idSujet;
    }
     
    public void setIdSujet(int idSujet) {
        this.idSujet = idSujet;
    }

    public int getNbreComment() {
        return nbreComment;
    }

    public void setNbreComment(int nbreComment) {
        this.nbreComment = nbreComment;
    }

    public Date getDateCreationp() {
        return dateCreationp;
    }

    public void setDateCreationp(Date dateCreationp) {
        this.dateCreationp = dateCreationp;
    }

    public String getNomUser() {
        return nomUser;
    }

    public void setNomUser(String nomUser) {
        this.nomUser = nomUser;
    }

    public String getPrenomUser() {
        return prenomUser;
    }

    public void setPrenomUser(String prenomUser) {
        this.prenomUser = prenomUser;
    }

  






    
}
