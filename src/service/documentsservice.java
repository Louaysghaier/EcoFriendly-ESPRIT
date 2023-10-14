
package service;
//import java.sql.Connection;
//import java.sql.Date;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import models.documents;
//import util.myconnection;
///**
// *
// * @author Dorra
// */
// public class documentsservice implements IService<documents> {
//Connection cnx ;
//
//public documentsservice(){
//    this.cnx= myconnection.getInstance().getconnection();
//}
//
//   @Override
//   public void ajouter(documents d) {
////        String req = " INSERT INTO produit( titre, type, date, image) VALUES (?, ?, ?, ?, ?)";
////        try {
////            PreparedStatement ste = cnx.prepareStatement(req);
////         
////              ste.setString(1, d.getTitre());
////             ste.setString(2, d.getType());
////            ste.setDate(3, (Date) d.getDate());
////    
////            ste.setBytes(4, d.getImage());
////    
////  
////            ste.executeUpdate();
////            System.out.println(" Votre documents est ajouté avec success merci !");
////        } catch (SQLException ex) {
////            Logger.getLogger(documentsservice.class.getName()).log(Level.SEVERE, null, ex);
////        }
//        
//       
//       
//       String req = "INSERT INTO documents (type, titre, idtopic, image) VALUES (?, ?, ?, ?)";
//try {
//    PreparedStatement ste = cnx.prepareStatement(req);
//    ste.setString(1, d.getType());
//    ste.setString(2, d.getTitre());
//    ste.setInt(3, d.getTop().getidtopic()); // Assurez-vous que la méthode getidtopic() est correctement définie dans votre modèle.
//    ste.setBytes(4, d.getImage());
//    
//    // Utilisez executeUpdate() pour effectuer une mise à jour (INSERT, UPDATE, DELETE).
//    int rowsAffected = ste.executeUpdate();
//
//    if (rowsAffected > 0) {
//        System.out.println("Votre document a été ajouté avec succès, merci !");
//    } else {
//        System.out.println("L'ajout du document a échoué.");
//    }
//} catch (SQLException ex) {
//    Logger.getLogger(documentsservice.class.getName()).log(Level.SEVERE, null, ex);
//}
//   }
//
//       
//       
//       
////        String req = "INSERT INTO documents (type, titre, idtopic , image) VALUES (?, ?,?,?)";
////    try {
////        PreparedStatement ste = cnx.prepareStatement(req);
////        ste.setString(1, d.getType());
////        ste.setString(2, d.getTitre());
////        //ste.setInt(5, d.getTop().getidtopic());
////                ste.setBytes(4, d.getImage());
////
////
////        ste.executeQuery();
////        System.out.println("Votre document a été ajouté avec succès, merci !");
////    } catch (SQLException ex) {
////        Logger.getLogger(documentsservice.class.getName()).log(Level.SEVERE, null, ex);
////    }
////
////
////      }
//
//    @Override
//   public void modifier(documents d) {
//    try {
//                String req = "UPDATE `documents` SET `titre` = ?, `type` = ? ,`date`=? , WHERE `id-docu` = ?";
//        PreparedStatement preparedStatement = cnx.prepareStatement(req);
//        preparedStatement.setString(1, d.getTitre());
//        preparedStatement.setString(2, d.getType());
//        preparedStatement.setInt(3, d.getId_docu());
//        preparedStatement.setDate(4, (Date) d.getDate());
//
//        int rowCount = preparedStatement.executeUpdate();
//        
//        if (rowCount > 0) {
//            System.out.println("Document modifié avec succès.");
//        } else {
//            System.out.println("Aucun document correspondant n'a été trouvé pour la mise à jour.");
//        }
//    } catch (SQLException ex) {
//        System.out.println(ex.getMessage());
//    }
//}
//
//
//    @Override
//    public void supprimer(int id_docu) {
//        String req = "DELETE FROM documents WHERE id_docu = ?";
//        PreparedStatement preparedStatement = null;
//    try {
//        preparedStatement = cnx.prepareStatement(req);
//    } catch (SQLException ex) {
//        Logger.getLogger(documentsservice.class.getName()).log(Level.SEVERE, null, ex);
//    }
//    try {
//        preparedStatement.setInt(1, id_docu);
//    } catch (SQLException ex) {
//        Logger.getLogger(documentsservice.class.getName()).log(Level.SEVERE, null, ex);
//    }
//
//    try {
//        // Exécutez la requête SQL
//        preparedStatement.executeUpdate();
//    } catch (SQLException ex) {
//        Logger.getLogger(documentsservice.class.getName()).log(Level.SEVERE, null, ex);
//    }
//    }
//
//    @Override
//  public documents getOne(documents d) {
//    try {
//      
//        String req = "SELECT * FROM `documents` WHERE `titre` = ? AND `type` = ?";
//        PreparedStatement preparedStatement = cnx.prepareStatement(req);
//        preparedStatement.setString(1, d.getTitre());
//        preparedStatement.setString(2, d.getType());
//
//        ResultSet resultSet = preparedStatement.executeQuery();
//        
//        if (resultSet.next()) {
//            documents foundDocument = new documents();
//            foundDocument.setId_docu(resultSet.getInt("id"));
//            foundDocument.setTitre(resultSet.getString("titre"));
//            foundDocument.setType(resultSet.getString("type"));
//            
//            return foundDocument; 
//        } else {
//            return null; 
//        }
//    } catch (SQLException ex) {
//        System.out.println(ex.getMessage());
//        return null;
//    }
//}
//
//
//    @Override
//    public List<documents> getAll() {
//      String req = "SELECT * FROM `documents`";
//      List<documents> listedocuments= new ArrayList();
//    Statement stm;
//    try {
//        stm = this.cnx.createStatement();
//    
//    
//        ResultSet rs=  stm.executeQuery(req);
//    while (rs.next()){
//        documents de = new documents();
//        de.setId_docu(rs.getInt(1));
//        de.setTitre(rs.getString("titre"));
//        de.setType(rs.getString(3));
//        
//        
//        listedocuments.add(de);
//    }
//     if (stm != null) {
//            stm.close();
//        }
//    
//    
//    
//
//        
//        
//    } catch (SQLException ex) {
//    
//        System.out.println(ex.getMessage());
//    
//    }
//    return listedocuments;
//    }
//
//    
//}
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import models.documents;
import models.topic;
import util.myconnection;

public class documentsservice  {
    Connection cnx;

    public documentsservice() {
        cnx = myconnection.getInstance().getCnx();
    }

    // Create (Add a new document)
    public void ajouter(documents doc) throws SQLException {
        String req = "INSERT INTO documents(titre, type, date, image, idtopic) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ste = cnx.prepareStatement(req);
            ste.setString(1, doc.getTitre());
            ste.setString(2, doc.getType());
            ste.setDate(3, (Date) doc.getDate());
            ste.setBytes(4, doc.getImage());
            ste.setInt(5, doc.getTop().getidtopic());

            ste.executeUpdate();
            System.out.println("Votre document est ajouté avec succès, merci!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // Read (Retrieve documents)
    public List<documents> afficher() {
        List<documents> documentsList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM documents";
            Statement ste = cnx.createStatement();
            ResultSet rs = ste.executeQuery(sql);
            while (rs.next()) {
                int id_docu = rs.getInt("id_docu");
                String titre = rs.getString("titre");
                String type = rs.getString("type");
                Date date = rs.getDate("date");
                byte[] image = rs.getBytes("image");
                int idtopic = rs.getInt("idtopic");

                // Assuming you have a method to get the topic based on topicId
                topic topic = getTopicById(idtopic);

                documents doc = new documents(id_docu, titre, type, date, image, topic);
                documentsList.add(doc);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return documentsList;
    }

    // Update (Modify an existing document)
    public void modifier(documents doc) throws SQLException {
        String sql = "UPDATE documents SET titre=?, type=?, date=?, image=?, idtopic=? WHERE id_docu=?";
        try {
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setString(1, doc.getTitre());
            ste.setString(2, doc.getType());
            ste.setDate(3, (Date) doc.getDate());
            ste.setBytes(4, doc.getImage());
            ste.setInt(5, doc.getTop().getidtopic());
            ste.setInt(6, doc.getId_docu());

            ste.executeUpdate();
            System.out.println("Document modifié !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // Delete (Remove a document)
    public void supprimer(documents doc) {
        String sql = "DELETE FROM documents WHERE id_docu = ?";
        try {
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setInt(1, doc.getId_docu());
            ste.executeUpdate();
            System.out.println("Document supprimé");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // Helper method to get a topic based on topicId
    private topic getTopicById(int topicId) {
         String sql = "SELECT * FROM topic WHERE idtopic = ?";
        topic foundTopic = null;
        
        try {
            PreparedStatement preparedStatement = cnx.prepareStatement(sql);
            preparedStatement.setInt(1, topicId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int idtopic = resultSet.getInt("idtopic");
                String nom = resultSet.getString("nom");
                foundTopic = new topic(idtopic, nom);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return foundTopic;
    }
}
