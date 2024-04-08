/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Mail;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;
import javax.mail.*;
import Database.DatabaseConnector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.*;
/**
 *
 * @author vince-kong
 */


public class Mail {
    Session newSession;
    MimeMessage mimeMessage = null;
    private final String emailAdd = "Avscansmtp@outlook.com";
    private final String emailPass = "AUTAV26022024";
    
    public Mail(){
        setUpServerProperties();
//        draftEmail();
//        sendEmail();
    }

//    public static void main(String args[]) throws SQLException {
////      Mail mail = new Mail();
////      try {
////        mail.setUpServerProperties();
////        mail.draftEmail();
////        mail.sendEmail();
////      } catch (MessagingException e) {
////        e.printStackTrace();
////        System.out.println("Failed to send email: " + e.getMessage());
////      }
//    }

    private void setUpServerProperties() {
      Properties prop = new Properties();
      prop.put("mail.smtp.port", "587");
      prop.put("mail.smtp.auth", "true");
      prop.put("mail.smtp.starttls.enable", "true");
      newSession = Session.getDefaultInstance(prop, new Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
          return new PasswordAuthentication(emailAdd, emailPass);
        }
      });
    }

    public void draftEmail() throws MessagingException, SQLException {
      String[] emailRecipients = {
        "kst0629@autuni.ac.nz"
      };
      String emailSubject = "AV Equipment Due for Return";
      StringBuilder emailBody = new StringBuilder();

      try {
        // Connect to the database
        DatabaseConnector dbCon = new DatabaseConnector();
        Connection con = dbCon.connectToDatabase();

        // Query to retrieve events with AV equipment due for return within 3 days
        String query = "SELECT evID, evName, evEquipmentID FROM Event WHERE eqReturnDateTime >= DATE_SUB(CURDATE(), INTERVAL 3 DAY)";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        // Build the HTML email body
        emailBody.append("<html><body>");
        emailBody.append("<h2>AV Equipment Due For Return</h2>");
        emailBody.append("<p>The following events have received the listed AV equipment and are now due for return.</p>");
        emailBody.append("<table border='1'><tr><th>Event Name </th><th>Event ID </th><th>Equipment ID </th></tr>");

        // Iterate over the query results and populate the table rows
        while (rs.next()) {
          String evName = rs.getString("evName");
          String evID = rs.getString("evID");
          String eqID = rs.getString("evEquipmentID");
          emailBody.append("<tr>");
          emailBody.append("<td>").append(evName).append("</td>");
          emailBody.append("<td>").append(evID).append("</td>");
          emailBody.append("<td>").append(eqID).append("</td>");
          emailBody.append("</tr>");
        }

        emailBody.append("</table>");
        emailBody.append("</body></html>");

        // Close the database resources
        rs.close();
        stmt.close();
        con.close();

      } catch (SQLException e) {
        e.printStackTrace(); // Handle database-related exceptions
      }

      // Create a new MimeMessage and set email properties
      mimeMessage = new MimeMessage(newSession);
      mimeMessage.setFrom(new InternetAddress(emailAdd)); // Set the From address

      // Add recipients to the email
      for (String recipient: emailRecipients) {
        mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
      }

      mimeMessage.setSubject(emailSubject);

      // Create MimeBodyPart for the email body content
      MimeBodyPart bodyPart = new MimeBodyPart();
      bodyPart.setContent(emailBody.toString(), "text/html"); // Set the HTML content

      // Create a Multipart object and add the bodyPart to it
      Multipart multiPart = new MimeMultipart();
      multiPart.addBodyPart(bodyPart);

      // Set the content of the MimeMessage as the multipart object
      mimeMessage.setContent(multiPart);
    }

    public void sendEmail() throws MessagingException {
      String emailHost = "smtp-mail.outlook.com";
      try (Transport transport = newSession.getTransport("smtp")) {
        transport.connect(emailHost, emailAdd, emailPass);
        transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
        System.out.println("Email successfully sent!!!");
      }
    }
}

