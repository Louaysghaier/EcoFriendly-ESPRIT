/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLERS.CLIENT;

import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * FXML Controller class
 *
 * @author Dorra
 */
public class MailController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int vue=1;
    
      if (vue == 1) {
    // Email properties
    Properties properties = new Properties();
    properties.put("mail.smtp.host", "your-smtp-server.com"); // Replace with your SMTP server
    properties.put("mail.smtp.port", "your-smtp-port"); // Replace with your SMTP server's port
    properties.put("mail.smtp.auth", "true");

    // Create a session with the email server
    Session session = Session.getInstance(properties, new Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication("dorra.jaidane@esprit.tn", "223JFT5027"); // Replace with your email and password
        }
    });

    try {
        // Create a message
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("dorra.jaidane@esprit.tn")); // Replace with your email
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("dorrajaidanee@gmail.com")); // Replace with recipient's email
        message.setSubject("Subject of the Email");
        message.setText("This is the email content.");

        // Send the email
        Transport.send(message);

        System.out.println("Email sent successfully.");
    } catch (MessagingException e) {
        e.printStackTrace();
    
    }    
    
}}}
