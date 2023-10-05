/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import static com.sun.org.apache.xml.internal.security.utils.XMLUtils.newDocument;
import java.util.ArrayList;
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
       // documentsService.ajouter(nouveauDocument);
        System.out.println("Document ajouté avec succès.");
         nouveauDocument.setTitre("DORRA");
        nouveauDocument.setType("JAI");
     //   documentsService.ajouter(nouveauDocument);
        System.out.println("Document ajouté .");
        
       List<documents> docs=documentsService.getAll();
                System.out.println("louay .");

        for (documents document : docs) {
            System.out.println("ID : " + document.getId());
            System.out.println("Titre : " + document.getTitre());
            System.out.println("Type : " + document.getType());
            System.out.println();       
        
        /*documentsservice documentService = new documentsservice();

        
        int id = 43; 

        
        documentService.supprimer(id);
     System.out.println("Document SUPPRIME .");
    /*
    
    
    /*topicservice  topicservice = new  topicservice();

     
        topic nouveautopic = new topic ();
        nouveautopic.setname("nouveautopic");
       
         topicservice.ajouter(nouveautopic);
        System.out.println("topicajouté avec succès.");
        
        
        List<topic> tousLestopic =  topicservice.getAll(nouveautopic);
        for (topic tou : tousLestopic) {
            System.out.println("idtopic : " + tou.getidtopic());
            System.out.println("name : " + tou.getname());
            
            System.out.println();
   
  */ 
    documentsservice documentService = new documentsservice();

       
        documents documentToUpdate = new documents();
        documentToUpdate.setId(44); 
        documentToUpdate.setTitre("OLALA"); 
        documentToUpdate.setType("FADIT"); 

        
        documentService.modifier(documentToUpdate); 
    
    
    
    
    
    } 
        
}}
    
 
    
 
    

