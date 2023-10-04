/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.util.List;
import models.documents;
import models.topic;
import service.documentsservice;
import service.topicservice;
import util.myconnection;


/**
 *
 * @author Dorra
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        // TODO code application logic here
          myconnection.getInstance();
      
          documentsservice documentsService = new documentsservice();

     
        documents nouveauDocument = new documents();
        nouveauDocument.setTitre("Nouveau Document");
        nouveauDocument.setType("Type de Document");
        documentsService.ajouter(nouveauDocument);
        System.out.println("Document ajouté avec succès.");
        
        
        List<documents> tousLesDocuments = documentsService.getAll(nouveauDocument);
        for (documents document : tousLesDocuments) {
            System.out.println("ID : " + document.getId());
            System.out.println("Titre : " + document.getTitre());
            System.out.println("Type : " + document.getType());
            System.out.println();
        }
        
    
    
    
    
    topicservice  topicservice = new  topicservice();

     
        topic nouveautopic = new topic ();
        nouveautopic.setname("nouveautopic");
       
         topicservice.ajouter(nouveautopic);
        System.out.println("topicajouté avec succès.");
        
        
        List<topic> tousLestopic =  topicservice.getAll(nouveautopic);
        for (topic tou : tousLestopic) {
            System.out.println("idtopic : " + tou.getidtopic());
            System.out.println("name : " + tou.getname());
            
            System.out.println();
   
    } 
    }
}
    
 
    
 
    

