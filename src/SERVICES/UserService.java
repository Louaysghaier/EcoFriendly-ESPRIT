
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICES;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import MODELS.Utilisateur;
import UTIL.MyConnection;

/**
 *
 * @author louay
 */
public class UserService {
    Connection cnx = MyConnection.getInstance().getCnx();

public void ajouteruser(Utilisateur utilisateur) {
        String req = "INSERT INTO utilisateur (idUSER,nom, prenom) VALUES (?,?, ?, ?)";
        try (PreparedStatement preparedStatement = cnx.prepareStatement(req)) {
            
                       preparedStatement.setInt(1, utilisateur.getIdUSER());
                 preparedStatement.setString(2, utilisateur.getNomuser());
            preparedStatement.setString(3, utilisateur.getPrenomuser());

            preparedStatement.executeUpdate();
            System.out.println("Utilisateur ajouté avec succès.");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public Utilisateur getUtilisateurById(int utilisateurId) {
        String req = "SELECT * FROM utilisateur WHERE idUSER = ?";

        try (PreparedStatement preparedStatement = cnx.prepareStatement(req)) {
            preparedStatement.setInt(1, utilisateurId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int idUSER = resultSet.getInt("idUSER");
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                //String role =resultSet.getString("role");
                // Créez et retournez un objet Utilisateur avec les données récupérées
                return new Utilisateur(idUSER, nom, prenom);
            } else {
                return null; // Aucun utilisateur correspondant n'a été trouvé
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }}
}
