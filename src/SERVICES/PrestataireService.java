/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICES;

import INTERFACES.IprestatService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import MODELS.PrestataireServ;
import UTIL.MyConnection;

/**
 *
 * @author louay
 */
public class PrestataireService implements IprestatService<PrestataireServ>  {
    Connection cnx = MyConnection.getInstance().getCnx();

       @Override

    public PrestataireServ getPrestataireServById(int prestataireId) {
        String req = "SELECT * FROM prestataireserv WHERE idUSER = ?"; 

        try (PreparedStatement preparedStatement = cnx.prepareStatement(req)) {
            preparedStatement.setInt(1, prestataireId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Récupération des données du prestataire de service depuis le ResultSet
                int idUSER = resultSet.getInt("idUSER"); 
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");

                // Créez un objet PrestataireServ avec les données récupérées
                return new PrestataireServ(idUSER, nom,prenom);
            } else {
                return null; // Aucun prestataire correspondant n'a été trouvé
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public void ajouterpre(PrestataireServ prestataire) {
String req = "INSERT INTO prestataireserv(idUSER, nom, prenom, role) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = cnx.prepareStatement(req)) {
            preparedStatement.setInt(1, prestataire.getIdUSER());
            preparedStatement.setString(2, prestataire.getNomuser());
            preparedStatement.setString(3, prestataire.getPrenomuser());
            preparedStatement.setString(4, prestataire.getRole().toString());

            preparedStatement.executeUpdate();
            System.out.println("Prestataire ajouté avec succès.");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }    }

    @Override
    public void modifierpre(PrestataireServ prestataire) {
String req = "UPDATE prestataireserv SET nom = ?, prenom = ? WHERE idUSER = ?";
        try (PreparedStatement preparedStatement = cnx.prepareStatement(req)) {
            preparedStatement.setString(1, prestataire.getNomuser());
            preparedStatement.setString(2, prestataire.getPrenomuser());
            preparedStatement.setInt(3, prestataire.getIdUSER());

            int rowCount = preparedStatement.executeUpdate();

            if (rowCount > 0) {
                System.out.println("Prestataire modifié avec succès.");
            } else {
                System.out.println("Aucun prestataire correspondant n'a été trouvé pour la mise à jour.");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimerpre(int id) {
 String req = "DELETE FROM prestataireserv WHERE idUSER = ?";
        try (PreparedStatement preparedStatement = cnx.prepareStatement(req)) {
            preparedStatement.setInt(1, id);

            int rowCount = preparedStatement.executeUpdate();

            if (rowCount > 0) {
                System.out.println("Prestataire supprimé avec succès.");
            } else {
                System.out.println("Aucun prestataire correspondant n'a été trouvé pour la suppression.");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
    }}
        
    @Override
    
    public PrestataireServ getOnepre(int id) {
String req = "SELECT * FROM prestataireserv WHERE idUSER = ?";
        try (PreparedStatement preparedStatement = cnx.prepareStatement(req)) {
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int idUSER = resultSet.getInt("idUSER");
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                String role = String.valueOf(resultSet.getString("role"));
                return null;
       //         return new PrestataireServidUSER, nom, prenom, role);
            } else {
                return null; // Aucun prestataire correspondant n'a été trouvé
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }    
    }

    @Override
    public List<PrestataireServ> getAllpre() {
 List<PrestataireServ> prestataires = new ArrayList<>();
        String req = "SELECT * FROM prestataireserv";
        try (PreparedStatement preparedStatement = cnx.prepareStatement(req);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int idUSER = resultSet.getInt("idUSER");
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                String role = String.valueOf(resultSet.getString("role"));

         //       PrestataireServ prestataire = new PrestataireServ(idUSER, nom, prenom, role, new ArrayList<>(), null);
         //       prestataires.add(prestataire);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return prestataires;
    }
    
}

    


