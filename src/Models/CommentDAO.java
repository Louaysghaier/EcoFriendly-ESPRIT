/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Grati Eya
 */
public class CommentDAO {
    private Connection cnx;

    public CommentDAO(Connection cnx) {
        this.cnx = cnx;
    }

    public List<Commentaire> getCommentsForPost(int postId) {
        List<Commentaire> comments = new ArrayList<>();

        try {
            Statement st = cnx.createStatement();
            String sql = "SELECT * FROM commentaire WHERE idPost = " + postId;
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Commentaire comment = new Commentaire();
                comment.setIdComment(rs.getInt("idComment"));
                comment.setIdPost(rs.getInt("idPost"));
                comment.setNomUser(rs.getString("nomUser"));
                comment.setPrenomUser(rs.getString("prenomUser"));
                comment.setDescription(rs.getString("Description"));
                comment.setDateCreation(rs.getDate("DateCreation"));

                comments.add(comment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return comments;
    }





    
}
