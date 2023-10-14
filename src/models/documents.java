/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
import models.topic;
/**
 *
 * @author Dorra
 */
public class documents {
    private int id_docu;
    private String titre;
    private String type;
    private Date date;
     byte[] image;
     private topic topic;

    public documents(String titre, String type, java.sql.Date date, topic topic, byte[] image) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "documents{" + "id_docu=" + id_docu + ", titre=" + titre + ", type=" + type + ", date=" + date + ", image=" + image + ", top=" + topic + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.id_docu;
        hash = 53 * hash + Objects.hashCode(this.titre);
        hash = 53 * hash + Objects.hashCode(this.type);
        hash = 53 * hash + Objects.hashCode(this.date);
        hash = 53 * hash + Arrays.hashCode(this.image);
        hash = 53 * hash + Objects.hashCode(this.topic);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final documents other = (documents) obj;
        if (this.id_docu != other.id_docu) {
            return false;
        }
        if (!Objects.equals(this.titre, other.titre)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Arrays.equals(this.image, other.image)) {
            return false;
        }
        if (!Objects.equals(this.topic, other.topic)) {
            return false;
        }
        return true;
    }

    public documents(int id_docu, String titre, String type, Date date, byte[] image, topic topic) {
        this.id_docu = id_docu;
        this.titre = titre;
        this.type = type;
        this.date = date;
        this.image = image;
        this.topic = topic;
    }

    public topic getTop() {
        return topic;
    }

    public void setTop(topic topic) {
        this.topic = topic;
    }

    public documents() {
    }

    public documents(int id_docu, String titre, String type, topic topic, byte[] image) {
        this.id_docu = id_docu;
        this.titre = titre;
        this.type = type;
         this.topic = topic;
        this.image = image;
    }
    
    public documents( String titre, String type,topic topic ,byte[] image) {
     
        this.titre = titre;
        this.type = type;
        this.topic = topic;
        this.image = image;
    }

    public int getId_docu() {
        return id_docu;
    }

    public void setId_docu(int id_docu) {
        this.id_docu = id_docu;
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }


    

   
}

