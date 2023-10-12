/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum;


import util.MyConnection;
import java.sql.Connection;
import java.sql.Date;
import java.util.List;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.Commentaire;
import models.Post;
import models.sujetdiscuss;
import services.CommentaireService;
import services.PostService;
import services.SujetdiscussService;

/**
 *
 * @author Grati Eya
 */
public class Forum {
    
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("ForumPage.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    } 

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
 
        MyConnection Mycnx = MyConnection.getInstance();
        
        //commentaire
       Commentaire comment = new Commentaire( 5, new Date(System.currentTimeMillis()),"nouveau commentaire",18);
       Commentaire comment1 = new Commentaire( 10, new Date(System.currentTimeMillis()),"nouveau commentaire1",18);
       CommentaireService commentservice= new CommentaireService();
       commentservice.ajouterCommentaire(comment);
       commentservice.supprimerCommentaire(1);
       
        CommentaireService commentaireService = new CommentaireService();

        Commentaire commentaireModifie = new Commentaire();
        commentaireModifie.setIdComment(9); 
        //commentaireModifie.setIdUser(2); 
        commentaireModifie.setDateCreation(new Date(System.currentTimeMillis())); 
        commentaireModifie.setDescription("Nouveau texte du commentaire"); 

        
        commentaireService.modifierCommentaire(commentaireModifie);
        
       List<Commentaire> tousLesCommentaires = commentaireService.afficherCommentaires();

        for (Commentaire commentaire : tousLesCommentaires) {
            System.out.println("Date de création : " + commentaire.getDateCreation());
            System.out.println("Description : " + commentaire.getDescription());
            System.out.println("===========================");
        }
             
        //Post
        Post post1 = new Post(2, 5, 10, new Date(System.currentTimeMillis()),"eya","grati",5);
        PostService postser = new PostService();
        postser.ajouterPost(post1);
        postser.supprimerPost(1);
    
                 
        PostService postService = new PostService();

        
        Post postModifie = new Post();
        postModifie.setIdPost(1);
        postModifie.setIdUser(2); 
        postModifie.setNbreComment(10); 
        postModifie.setDateCreationp(new Date(System.currentTimeMillis())); 
        postModifie.setNomUser("NouveauNom"); 
        postModifie.setPrenomUser("NouveauPrenom"); 

        
        postService.modifierPost(postModifie);
        
         List<Post> tousLesPosts = postService.afficherPosts();

        for (Post post : tousLesPosts) {
            System.out.println("Nombre de commentaires : " + post.getNbreComment());
            System.out.println("Date de création : " + post.getDateCreationp());
            System.out.println("Nom de l'utilisateur : " + post.getNomUser());
            System.out.println("Prénom de l'utilisateur : " + post.getPrenomUser());
            System.out.println("===========================");
        }
        
        
        String nomAChercher = "eya";
        String prenomAChercher = "grati"; 

        List<Post> postsTrouves = postService.chercherPostParNomPrenom(nomAChercher, prenomAChercher);

        if (!postsTrouves.isEmpty()) {
            System.out.println("Posts trouvés :");
            for (Post post : postsTrouves) {
                System.out.println("Nombre de commentaires : " + post.getNbreComment());
                System.out.println("Date de création : " + post.getDateCreationp());
                System.out.println("===========================");
            }
        } else {
            System.out.println("Aucun post trouvé avec le nom et prénom spécifiés.");
        }
        
        //Sujet de discussions
        sujetdiscuss sujet1 = new sujetdiscuss(19, "vente et échange");
        SujetdiscussService sujetser = new SujetdiscussService();
        sujetser.ajouterSujetDiscuss(sujet1);
        sujetser.supprimerSujetDiscuss(1);
        
        sujetdiscuss sujetModifie = new sujetdiscuss();
        sujetModifie.setIdSujet(2); 
        sujetModifie.setNbrePost(5); 
        sujetModifie.setTypeSujet("NouveauType"); 

        sujetser.modifierSujetDiscussion(sujetModifie);
        
        List<sujetdiscuss> tousLesSujets = sujetser.afficherLesSujets();

        for (sujetdiscuss sujet : tousLesSujets) {
            System.out.println("Nombre de posts : " + sujet.getNbrePost());
            System.out.println("Type de sujet : " + sujet.getTypeSujet());
            System.out.println("===========================");
        }
        
        String typeSujetAChercher = "vente et echange";
        List<sujetdiscuss> sujetsTrouves = sujetser.chercherSujetParType(typeSujetAChercher);

        if (!sujetsTrouves.isEmpty()) {
            System.out.println("Sujets de discussion trouvés :");
            for (sujetdiscuss sujet : sujetsTrouves) {
                System.out.println("Nombre de sujets : " + sujet.getNbrePost());
                System.out.println("Type de sujet : " + sujet.getTypeSujet());
                System.out.println("===========================");
            }
        } else {
            System.out.println("Aucun sujet de discussion trouvé avec le type : " + typeSujetAChercher);
        }
        /*sujetdiscuss sujet = new sujetdiscuss();
        sujet.setIdSujet(1); // Remplacez par l'ID du sujet de discussion
        Post post = new Post();
        post.setIdPost(1);
        sujet = sujetser.chercherSujetParID(sujet.getIdSujet());
        post = postService.chercherPostParID(post.getIdPost());

        // Affecter le post au sujet
        sujetser.affecterPost(sujet, post);*/
        
        
       
        
    }
}
