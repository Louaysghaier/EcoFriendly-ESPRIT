/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;
import java.util.Date;
import java.util.Objects;
/**
 *
 * @author Dorra
 */
public class documents {
    private int id;
    private String titre;
    private String type;
    private Date date; // Utilisation de java.util.Date

    // Constructeur
    public documents (String titre, String type, Date date){
      this.titre = titre;
        this.type = type;
        this.date = date;  
    }
    public documents(){};
    public documents(int id, String titre, String type, Date date) {
        this.id = id;
        this.titre = titre;
        this.type = type;
        this.date = date;
    }

    // Getters et setters (méthodes d'accès)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        documents documents = (documents) o;
        return id == documents.id &&
                Objects.equals(titre, documents.titre) &&
                Objects.equals(type, documents.type) &&
                Objects.equals(date, documents.date);
    }
     @Override
    public int hashCode() {
        return Objects.hash(id, titre, type, date);
    }
     @Override
    public String toString() {
        return "Documents{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", type='" + type + '\'' +
                ", date=" + date +
                '}';
    }
}

