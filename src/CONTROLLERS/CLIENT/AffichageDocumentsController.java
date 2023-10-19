/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLERS.CLIENT;

import INTERFACES.DocumentService;
import INTERFACES.NiveauService;
import INTERFACES.SemestreService;
import INTERFACES.TopicService;
import MODELS.Document;
import MODELS.HistoriqueDocument;
import MODELS.Niveau;
import MODELS.SearchDocumentDTO;
import MODELS.Semestre;
import MODELS.Topic;
import SERVICES.DocumentServiceImp;
import SERVICES.NiveauServiceImp;
import SERVICES.SemestreServiceImp;
import SERVICES.TopicServiceImp;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.util.StringConverter;

/**
 * FXML Controller class
 *
 * @author Dorra
 */
public class AffichageDocumentsController implements Initializable {

    @FXML
    private AnchorPane sanchorpane2_d;
    @FXML
    private AnchorPane sanchorpane3_d;
    @FXML
    private AnchorPane sanchorpane4_d;
    @FXML
    private ScrollPane sscrollpane_d;
    @FXML
    private GridPane sgridpane_d;
    @FXML
    private AnchorPane sanchorpane5_d;
    @FXML
    private Button order_receiptBtn;
    @FXML
    private ComboBox<Niveau> sniveau_d;
    @FXML
    private ComboBox<Topic> stopic_d;
    @FXML
    private ComboBox<String> stype_d;
    @FXML
    private TextField snomdoc_d;
    @FXML
    private ComboBox<Semestre> ssemestre_d;
    @FXML
    private Separator sseparator_d;
 
 private NiveauService niveauService=new NiveauServiceImp();
    private SemestreService semestreService=new SemestreServiceImp();
    private TopicService topicService=new TopicServiceImp();
    private DocumentService documentService=new DocumentServiceImp();
        private HistoriqueDocument historiqueDocument=new HistoriqueDocument();

    @FXML
    private AnchorPane anchorpanedownload_d;
    @FXML
    private Label nomdoc_d;
    @FXML
    private Label semestre_d;
    @FXML
    private Label level_d;
    @FXML
    private Label topic_d;
    @FXML
    private Label type_d;
    @FXML
    private ImageView imageviewuplo_d;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         anchorpanedownload_d.setVisible(false);
        sanchorpane5_d.setVisible(true);
        this.initCombobox();
    List<Document> filteredDocuments = documentService. searchDocuments(new SearchDocumentDTO());
        this.initializeCards(filteredDocuments);

    }    
    

    @FXML
    private void srechercher_d(ActionEvent event) {

    // Get the search criteria from the UI components
    int niveau =(sniveau_d.getValue()!=null)? sniveau_d.getValue().getIdNiveau() : 0 ;
    int topic =(stopic_d.getValue()!=null)? stopic_d.getValue().getIdTopic():0;
    String type = stype_d.getValue();
    String nomdoc = snomdoc_d.getText();
    int semestre =(ssemestre_d.getValue()!=null)?  ssemestre_d.getValue().getIdSemestre():0;
        SearchDocumentDTO sd=new SearchDocumentDTO(nomdoc,type,niveau,topic,semestre);
    // SearchDocumentDTO(String documentName, String documentType, int idNiveau, int topic, int idSemestre)
    List<Document> filteredDocuments = documentService. searchDocuments(sd);
        System.out.println(sd.toString());
    // Clear the current content of the GridPane
    sgridpane_d.getChildren().clear();
this.initializeCards(filteredDocuments);
}

        
        public void initializeCards(List<Document>  document) {
 // TODO
        try{
            int row = 0 ;
            int column = 1;
            for(int i = 0 ; i<document.size();i++){
               
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/CardDoc.fxml"));
                AnchorPane pane = loader.load();
                CardDocController controller = loader.getController();
                controller.setDocument(document.get(i));
                controller.getCard_moreInfo_D().setVisible(true);
                controller.getCard_updateinfo_D1().setVisible(false);

                sgridpane_d.add(pane,column,row);
                column+=1;
                if(column>2){
                    column = 1;
                    row +=1 ;
                }
            }
            
        } catch (IOException ex) {
            Logger.getLogger(AffichageDocumentsController.class.getName()).log(Level.SEVERE, null, ex);
        }    }    

            private void initCombobox(){
          ObservableList<Semestre> semestres=FXCollections.observableArrayList( semestreService.getAllSemestres());
      ObservableList<Topic> topics=FXCollections.observableArrayList( topicService.getAllTopics());
      ObservableList<Niveau> niveaus= FXCollections.observableArrayList(niveauService.getAllNiveaus());
      ObservableList<String> types=  FXCollections.observableArrayList();
      types.add("TD");
       types.add("Devoirs");
      types.add("Corrige TD");
      types.add("Cours");

      sniveau_d.setConverter(new StringConverter<Niveau>() {
    @Override
    public String toString(Niveau niveau) {
        return niveau.getNiveauName(); // Assuming that 'getName()' is the method to get the name.
    }

    @Override
    public Niveau fromString(String string) {
        // This method doesn't need to be implemented in this case.
        return null;
    }
});
      stopic_d.setConverter(new StringConverter<Topic>() {
    @Override
    public String toString(Topic topic) {
        return topic.getTopicName(); // Assuming that 'getName()' is the method to get the name.
    }

    @Override
    public Topic fromString(String string) {
        // This method doesn't need to be implemented in this case.
        return null;
    }
});
      ssemestre_d.setConverter(new StringConverter<Semestre>() {
    @Override
    public String toString(Semestre semestre) {
        return semestre.getSemestreName(); // Assuming that 'getName()' is the method to get the name.
    }

    @Override
    public Semestre fromString(String string) {
        // This method doesn't need to be implemented in this case.
        return null;
    }
});

      sniveau_d.setItems( niveaus);
      stopic_d.setItems(topics);
      ssemestre_d.setItems(semestres);
      stype_d.setItems( types);
    }

    @FXML
    private void sreset_d(ActionEvent event) {
       List<Document> filteredDocuments = documentService. searchDocuments(new SearchDocumentDTO());
       snomdoc_d.setText("");
       stype_d.setValue(null);
       sniveau_d.setValue(null);
       ssemestre_d.setValue(null);
       stopic_d.setValue(null);
        this.initializeCards(filteredDocuments);
    }

    
    @FXML
    private void upload_d(ActionEvent event) {
        
        
        
        
        Document document=new Document();
        if (document != null) {
        // Récupérez l'URL du document
        String documentURL = document.getDocumentName(); // Remplacez par la manière dont vous obtenez l'URL du document

        if (documentURL != null && !documentURL.isEmpty()) {
           try {
        URL url = new URL(documentURL);
        InputStream in = url.openStream();
        Files.copy(in, Paths.get("LOCAL_PATH_TO_SAVE_DOCUMENT"));
        in.close();
        System.out.println("Download successful!");
    } catch (IOException e) {
        e.printStackTrace();
        System.out.println("Download error: " + e.getMessage());
    }
        } else {
            System.out.println("L'URL du document est vide ou nul.");
        }}
        
        
    }

    @FXML
    private void retour_d(ActionEvent event) {
        anchorpanedownload_d.setVisible(false);
        sanchorpane5_d.setVisible(true);
    }

  

    @FXML
    private void rloadAffichage_d(ActionEvent event) {
            
        
        
    }

          public AnchorPane getSanchorpane5_d() {
        return sanchorpane5_d;
    }

    public void setSanchorpane5_d(AnchorPane sanchorpane5_d) {
        this.sanchorpane5_d = sanchorpane5_d;
    }

    public AnchorPane getAnchorpanedownload_d() {
        return anchorpanedownload_d;
    }

    public void setAnchorpanedownload_d(AnchorPane anchorpanedownload_d) {
        this.anchorpanedownload_d = anchorpanedownload_d;
    }
        
        
    }
    

