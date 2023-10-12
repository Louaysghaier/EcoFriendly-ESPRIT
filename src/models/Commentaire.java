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
public class Commentaire {
    
    private int idComment, idUser, idPost;
    private Date dateCreation;
    private String Description;
    
    public Commentaire() {
    }
    
    public Commentaire(  int idUser,Date dateCreation, String Description) {
        this.idUser = idUser;
        this.dateCreation = dateCreation;
        this.Description = Description;
    }
    
     public Commentaire( int idUser, Date dateCreation, String Description, int idPost) {
        this.idUser = idUser;
        this.dateCreation = dateCreation;
        this.Description = Description;
        this.idPost = idPost;
    }

    public Commentaire(int idComment, int idUser, Date dateCreation, String Description) {
        this.idComment = idComment;
        this.idUser = idUser;
        this.dateCreation = dateCreation;
        this.Description = Description;
    }

    public int getIdComment() {
        return idComment;
    }

    public void setIdComment(int idComment) {
        this.idComment = idComment;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    
    public int getIdPost() {
        return idPost;
    }
    
    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
    

}
