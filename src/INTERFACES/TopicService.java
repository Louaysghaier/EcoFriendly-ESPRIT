/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package INTERFACES;

import MODELS.Semestre;
import MODELS.Topic;
import java.util.List;

/**
 *
 * @author Dorra
 */
public interface TopicService {
     List<Topic> getAllTopics();
    Topic getTopicById(int id);
void ajouterTopic(int idTopic, String topicName);
    void modifierTopic(int idTopic, String nouveauNom);
    void supprimerTopic(int idTopic);
}
