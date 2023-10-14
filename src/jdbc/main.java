/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package jdbc;
import java.sql.SQLException;
import java.util.List;
import models.documents;
import models.topic;
import service.documentsservice;

/**
 *
 * @author Dorra
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        
        
       
        documentsservice service = new documentsservice();

        // Create a new document
        documents newDocument = new documents("Document Title", "Document Type", new topic(1, "Topic Name"), new byte[]{1, 2, 3, 4});
        try {
            service.ajouter(newDocument);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Retrieve and display all documents
        List<documents> documentsList = service.afficher();
        for (documents doc : documentsList) {
            System.out.println(doc);
        }
        // TODO code application logic here
    }
    
}
