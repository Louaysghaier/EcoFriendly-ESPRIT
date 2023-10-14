/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ECOserviceApp;
import java.util.List;
import models.service;
import models.Utilisateur;
import models.PrestataireServ;
import services.ECOserviceService;
import services.UserService;
import services.PrestataireService;
/**
 *
 * @author louay
 */
public class MAINServices {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Création d'un utilisateur
        Utilisateur demandeur1 = new Utilisateur(1,"louay", "sghaier", "ETUDIANT");
         Utilisateur demandeur2 = new Utilisateur(2,"dorra", "jaiden", "ETUDIANT");
         Utilisateur demandeur3 = new Utilisateur(3,"dorra", "jaiden", "ETUDIANT");
         Utilisateur demandeur4 = new Utilisateur(4,"dorra", "jaiden", "ETUDIANT");

         UserService userservice =new UserService();
/*         
         userservice.ajouteruser(demandeur1);
            userservice.ajouteruser(demandeur2);
*/
         // Création d'un prestataire de service
        //livreur1
        PrestataireService prestataireService = new PrestataireService();
        PrestataireServ prestataire1 = new PrestataireServ( 1,"Ahmed", "delevery", "livreur", null, null);
//        prestataireService.ajouterpre(prestataire1);
        //pressing
        PrestataireServ prestataire2 = new PrestataireServ( 2,"studio", "pressing", "pressing", null, null);
//        prestataireService.ajouterpre(prestataire2);
        
   /*     
        // Récupération d'un prestataire par son ID
        PrestataireServ prestataireRecupere = prestataireService.getPrestataireServById(2);
        if (prestataireRecupere != null) {
             System.out.println("Prestataire récupéré : " + prestataireRecupere.getNom() + " " + prestataireRecupere.getPrenom());
        } else {
            System.out.println("Aucun prestataire trouvé avec cet ID.");
        }
        // Récupération de tous les presetataire
        
           List<PrestataireServ>prests=prestataireService.getAllpre();
                            System.out.println("Liste des prestataires :");
            for (PrestataireServ p : prests) {
                                System.out.println("nom de prestataire : " + p.getNom() +
                               ", prenom de prestataire : " + p.getPrenom() );
                               
        }
     */                // Modification d'un prestataireService
              List<PrestataireServ>prests=prestataireService.getAllpre();
     
             if(prests.size()>0){
             PrestataireServ PrestataireServModif=prests.get(0);
             PrestataireServModif.setNomuser("koussay");
             PrestataireServModif.setPrenomuser("benkemla");
             
             prestataireService.modifierpre(PrestataireServModif);
             System.out.println("prestataire modifié avec succès.");
        } else {
            System.out.println("erreur de modification de prestataire.");
        }      
           
                              // Supprimer  un prestataire
                              
              /*if(prests.size()>0){
             int PrestataireServSUpp=prests.get(0).getIdUSER();
             prestataireService.supprimerpre(PrestataireServSUpp);
             System.out.println("prestataire est supprimé avec succès.");
        } else {
            System.out.println("error de suppression de prestataire.");
        }         
                        */         
        // Création d'un service service
        //livraison
       ECOserviceService ecoService = new ECOserviceService();
        /*service service1 = new service("Livraison", demandeur1);
        ecoService.ajouter(service1);
      */
        //lessive
      /*  service service2 = new service("lessive", demandeur2);
        ecoService.ajouter(service2);
        */
        
        // Récupération de tous les services
        List<service> services = ecoService.getAll();
  /*      System.out.println("Liste des services :");
         for (service service : services) {
            System.out.println("Service ID: " + service.getServiceId());
            System.out.println("Type: " + service.getType());
            System.out.println("État: " + service.getEtat());
            System.out.println("Date de demande: " + service.getDateDemande());
         //   System.out.println("Demandeur: " + service.getDemandeur().getIdUSER());
          //  System.out.println("Prestataire: " + service.getPrestataire().getNom());
            System.out.println("-----------------------");
        }
         */
         // Modification d'un service
  /*     if (services.size() > 0) {
            service serviceAModifier = services.get(0);
            serviceAModifier.setType("Maintenance");
            ecoService.modifier(serviceAModifier);
            System.out.println("Service modifié avec succès.");
        } else {
            System.out.println("Aucun service à modifier.");
        } 
*/
        // Suppression d'un service
    /*   if (services.size() > 0) {
            int serviceIdASupprimer = services.get(0).getServiceId();
            ecoService.supprimer(serviceIdASupprimer);
            System.out.println("Service supprimé avec succès.");
        } else {
            System.out.println("Aucun service à supprimer.");
        }
        */

        
        
    }

    }
    

            

