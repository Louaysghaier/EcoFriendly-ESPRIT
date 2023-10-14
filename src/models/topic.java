/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Objects;

/**
 *
 * @author Dorra
 */
public class topic {
    private int idtopic ;
    private String nom ;
   
    

 public topic (int idtopic ,String nom){
     this.idtopic =idtopic;
     this.nom=nom;
    
 }  
 public topic (String nom){
     this.nom=nom;
    
 }
 public topic (){
}
  
    
public int getidtopic(){
  return idtopic ;
}
public void setidtopic(int idtopic){
    this.idtopic=idtopic;
}
 public String getnom() {
        return nom;
    }

    public void setnom(String nom) {
        this.nom = nom;
    }
      

  






    

    @Override
    public String toString() {
        return "Topic{" +
                "idtopic=" + idtopic +
                ", nom='" + nom + '\'' +
                '}';
    }
     @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        topic topic= (topic) o;
        return idtopic == topic.idtopic &&
                Objects.equals(nom, topic.nom) ;
                       
              
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.idtopic;
        hash = 79 * hash + Objects.hashCode(this.nom);
        return hash;
    }






}
