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
    private String name ;
    private int id;
     private int documentsId; // Clé étrangère

 public topic (int idtopic ,String name){
     this.idtopic =idtopic;
     this.name=name;
     this.documentsId = documentsId;
    
 }  
 public topic (String name){
     this.name=name;
     this.documentsId = documentsId;
 }
 public topic (){
}
  
    
public int getidtopic(){
  return idtopic ;
}
public void setidtopic(int idtopic){
    this.idtopic=idtopic;
}
 public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }
       public int getDocumentsId() {
        return documentsId;
    }

    public void setDocumentsId(int documentsId) {
        this.documentsId = documentsId;
    }






    

    @Override
    public String toString() {
        return "Topic{" +
                "idtopic=" + idtopic +
                ", name='" + name + '\'' +
                '}';
    }
     @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        topic topic= (topic) o;
        return idtopic == topic.idtopic &&
                Objects.equals(name, topic.name) ;
                       
              
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.idtopic;
        hash = 79 * hash + Objects.hashCode(this.name);
        return hash;
    }






}
