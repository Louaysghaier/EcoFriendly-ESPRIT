/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import models.Utilisateur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.ECOservice;
import models.EtatService;
import models.PrestataireServ;
import util.MyConnection;
import interfaces.IECOservice;

/**
 *
 * @author louay
 */
public class ECOserviceService implements IECOservice<ECOservice> {
    Connection cnx = MyConnection.getInstance().getCnx();

    @Override
    public void ajouter(ECOservice eco) {
       try {
            String req = "INSERT INTO ecoservice(type, etat, dateDemande, demandeurId) VALUES (?, ?, ?, ?)";
            
            PreparedStatement preparedStatement = cnx.prepareStatement(req);
            preparedStatement.setString(1, eco.getType());
            preparedStatement.setString(2, eco.getEtat().toString());
            preparedStatement.setDate(3, new java.sql.Date(eco.getDateDemande().getTime()));
            preparedStatement.setInt(4, eco.getDemandeur().getIdUSER()); // Supposons que getId() renvoie l'ID de l'utilisateur
            
            preparedStatement.executeUpdate();
                        System.out.println("ajout de service avec succée");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
        
    

    @Override
    public void modifier(ECOservice eco) {

try {
    String req = "UPDATE ecoservice SET type = ?, etat = ?, dateDemande = ?, demandeurId = ?, prestataireId = ? WHERE serviceId = ?";
        String req1 = "UPDATE ecoservice SET type = ?, etat = ?, dateDemande = ?,  WHERE serviceId = ?";

    PreparedStatement preparedStatement = cnx.prepareStatement(req1);
        preparedStatement.setInt(1, eco.getServiceId()); 

    preparedStatement.setString(2, eco.getType());
    preparedStatement.setString(3, eco.getEtat().toString());
    preparedStatement.setDate(4, new java.sql.Date(eco.getDateDemande().getTime()));
  //  preparedStatement.setInt(5, eco.getDemandeur().getIdUSER());
  //  preparedStatement.setInt(6, eco.getPrestataire().getIdUSER());

    int rowCount = preparedStatement.executeUpdate();

    if (rowCount > 0) {
        System.out.println("Service modifié avec succès.");
    } else {
        System.out.println("Aucun service correspondant n'a été trouvé pour la mise à jour.");
    }
} catch (SQLException ex) {
    System.out.println(ex.getMessage());
}



    }

    @Override
    public void supprimer(int serviceId) {
         try {
        String req = "DELETE FROM ecoservice WHERE serviceId = ?";
        PreparedStatement preparedStatement = cnx.prepareStatement(req);
        preparedStatement.setInt(1, serviceId);

        int rowCount = preparedStatement.executeUpdate();

        if (rowCount > 0) {
            System.out.println("Service supprimé avec succès.");
        } else {
            System.out.println("Aucun service correspondant n'a été trouvé pour la suppression.");
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    }

    @Override
public ECOservice getOne(int serviceId) {
        
String req = "SELECT * FROM ecoservice WHERE serviceId = ?";
        
    try (PreparedStatement preparedStatement = cnx.prepareStatement(req)) {
        preparedStatement.setInt(1, serviceId);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            // Récupération du demandeur de service associé à ce service
            int demandeurId = resultSet.getInt("demandeurId"); // Assurez-vous d'avoir la colonne demandeurId dans votre table ECOservice
            UserService utilisateurDataAccess = new UserService();
            Utilisateur demandeur = utilisateurDataAccess.getUtilisateurById(demandeurId);
            
            // Récupération du prestataire de service associé à ce service
            int prestataireId = resultSet.getInt("prestataireId"); // Assurez-vous d'avoir la colonne prestataireId dans votre table ECOservice
            PrestataireService prestataireDataAccess = new PrestataireService();
            PrestataireServ prestataire = prestataireDataAccess.getPrestataireServById(prestataireId);

            ECOservice foundService = new ECOservice(resultSet.getString("type"), demandeur);
            foundService.setServiceId(resultSet.getInt("serviceId"));
            foundService.setEtat(EtatService.valueOf(resultSet.getString("etat"))); 
            foundService.setDateDemande(resultSet.getDate("dateDemande"));
            foundService.setPrestataire(prestataire);
            
            return foundService;

} else {
            return null; // Aucun service correspondant n'a été trouvé
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
        return null;
    }
       }

    @Override
 public List<ECOservice> getAll() {
         List<ECOservice> services = new ArrayList<>();
    String req = "SELECT * FROM `ecoservice`";

    try (Statement stm = this.cnx.createStatement()) {
        ResultSet rs = stm.executeQuery(req);

        while (rs.next()) {
            // Récupération du demandeur de service associé à ce service
            int demandeurId = rs.getInt("demandeurId"); 
            UserService utilisateurDataAccess = new UserService();
            Utilisateur demandeur = utilisateurDataAccess.getUtilisateurById(demandeurId);

            // Récupération du prestataire de service associé à ce service
            int prestataireId = rs.getInt("prestataireId"); 
            PrestataireService prestataireDataAccess = new PrestataireService();
            PrestataireServ prestataire = prestataireDataAccess.getPrestataireServById(prestataireId);

            ECOservice service = new ECOservice(rs.getString("type"), demandeur);
            service.setServiceId(rs.getInt("serviceId"));
            service.setEtat(EtatService.valueOf(rs.getString("etat"))); 
            service.setDateDemande(rs.getDate("dateDemande"));
           // service.setDemandeur(demandeur);
            service.setPrestataire(prestataire);

            services.add(service);
        }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return services;
    }


}

    
    

