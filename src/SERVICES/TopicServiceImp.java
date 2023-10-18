/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICES;

import INTERFACES.TopicService;
import MODELS.Topic;
import UTIL.myconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Dorra
 */
public class TopicServiceImp implements TopicService{

    @Override
public List<Topic> getAllTopics() {
    List<Topic> topics = new ArrayList<>();
    try {
        // Establish a connection to your database using myconnection or your preferred method
        Connection connection = myconnection.getInstance().getCnx();

        // Create an SQL SELECT statement to retrieve all topics
        String selectSql = "SELECT * FROM topic";

        // Create a PreparedStatement
        PreparedStatement preparedStatement = connection.prepareStatement(selectSql);

        // Execute the SELECT statement
        ResultSet resultSet = preparedStatement.executeQuery();

        // Iterate through the result set and create Topic objects
        while (resultSet.next()) {
            Topic topic = new Topic(
                resultSet.getInt("idTopic"),
                resultSet.getString("topicName")
            );
            topics.add(topic);
        }

        // Close the ResultSet and PreparedStatement
        resultSet.close();
        preparedStatement.close();
    } catch (SQLException ex) {
        // Handle exceptions (e.g., log the error, throw a custom exception)
        ex.printStackTrace();
    }

    // Return the list of topics
    return topics;
}

@Override
public Topic getTopicById(int id) {
    Topic topic = null;
    try {
        // Establish a connection to your database using myconnection or your preferred method
        Connection connection = myconnection.getInstance().getCnx();

        // Create an SQL SELECT statement to retrieve the topic by its ID
        String selectSql = "SELECT * FROM topic WHERE idTopic = ?";

        // Create a PreparedStatement and set the parameter to the topic's ID
        PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
        preparedStatement.setInt(1, id);

        // Execute the SELECT statement
        ResultSet resultSet = preparedStatement.executeQuery();

        // Check if a topic was found
        if (resultSet.next()) {
            topic = new Topic(
                resultSet.getInt("idTopic"),
                resultSet.getString("topicName")
            );
        }

        // Close the ResultSet and PreparedStatement
        resultSet.close();
        preparedStatement.close();
    } catch (SQLException ex) {
        // Handle exceptions (e.g., log the error, throw a custom exception)
        ex.printStackTrace();
    }

    // Return the topic (or null if not found)
    return topic;
}




   private List<Topic> topics = new ArrayList<>();
    
    
    @Override
    public void ajouterTopic(int idTopic, String topicName) {
        Topic nouveauTopic = new Topic(idTopic, topicName);
        topics.add(nouveauTopic);
    }
    



@Override
public void modifierTopic(int idTopic, String nouveauNom) {
    for (Topic topic : topics) {
        if (topic.getIdTopic() == idTopic) {
            topic.setTopicName(nouveauNom);
            break; 
        }
    }}
@Override
public void supprimerTopic(int idTopic) {
    Iterator<Topic> iterator = topics.iterator();
    while (iterator.hasNext()) {
        Topic topic = iterator.next();
        if (topic.getIdTopic() == idTopic) {
            iterator.remove();
        }
    }



}}

