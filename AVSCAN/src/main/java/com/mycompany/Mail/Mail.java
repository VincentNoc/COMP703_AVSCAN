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
import Database.DatabaseUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author vince-kong
 */


public class Mail {
    Session newSession;
    MimeMessage mimeMessage = null;
    MailCredentials mc = new MailCredentials();
    private final String emailAdd = mc.getEmailAdd();
    private final String emailPass = mc.getEmailPass();
    private final String smtpHost = mc.getSmtpAdd();

    public Mail(){
        setUpServerProperties();
    }


    private void setUpServerProperties() {
      Properties prop = new Properties();
      prop.put("mail.smtp.host", smtpHost);
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
        "testingemailnotif@yopmail.com"
      };
        String emailSubject = "AV Equipment Due for Return";
        StringBuilder emailBody = new StringBuilder();
        DatabaseConnector dbCon = new DatabaseConnector();
        String query = "SELECT evID, evName, evEquipmentID, eqSentDateTime, eqReturnDateTime FROM Event WHERE DATE(eqReturnDateTime) = DATE_ADD(CURDATE(), INTERVAL 1 DAY) AND TIMESTAMPDIFF(DAY, eqSentDateTime, eqReturnDateTime) > 1 AND email_sent = false;";


      try(Connection con = dbCon.connectToDatabase();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);) {
        // Connect to the database
       

        // Query to retrieve events with AV equipment due for return within 3 days
       

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
    
    //function that sends email 
    public void sendEmail() throws MessagingException, SQLException {
      try (Transport transport = newSession.getTransport("smtp")) {
        transport.connect(smtpHost, emailAdd, emailPass);
        transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
        System.out.println("Email successfully sent!!!");
      }
    }
    
    
//    public static boolean checkOneDayEvent(String daySent, String dayReturn){
//       try{
//           Timestamp timeStamp1 = Timestamp.valueOf(daySent);
//           Timestamp timeStamp2 = Timestamp.valueOf(dayReturn);
//           
//           //calculates difference in milliseconds between the two timestamps
//           long diffMillis = Math.abs(timeStamp2.getTime() - timeStamp1.getTime());
//           //one day in milliseconds
//           long oneDayMillis = 24 * 60 * 60 * 1000;
//           
//           return diffMillis > oneDayMillis;
//       }catch(IllegalArgumentException e){
//           return false;
//       }
//    }
//    
//    public void checkTimeStampInDB() throws SQLException, MessagingException{
//       String query = "SELECT evID, eqSentDateTime, eqReturnDateTime FROM Event";
//       DatabaseConnector dbCon= new DatabaseConnector();
//       try(Connection con = dbCon.connectToDatabase();
//            PreparedStatement prepStmt = con.prepareStatement(query);
//            ResultSet rs = prepStmt.executeQuery()){
//            
//            while(rs.next()){
//                String eventID = rs.getString("evID");
//                String sentDate = rs.getString("eqSentDateTime");
//                String returnDate = rs.getString("eqReturnDateTime");
//                
//                if(checkOneDayEvent(sentDate, returnDate)){
//                    draftEmail();
//                    sendEmail(); 
//                } 
//            }
//            
//            rs.close();
//            prepStmt.close();
//            con.close();
//            
//       }catch(SQLException e){
//           e.printStackTrace();
//       }
//    }
    
    public void checkEmailSent() throws SQLException, MessagingException {
        String query = "SELECT evID, eqSentDateTime, eqReturnDateTime FROM Event " +
                        "WHERE DATE(eqReturnDateTime) = DATE_ADD(CURDATE(), INTERVAL 1 DAY) " +
                        "AND TIMESTAMPDIFF(DAY, eqSentDateTime, eqReturnDateTime) > 1 " +
                        "AND email_sent = false";
         DatabaseUtils dbUtil = new DatabaseUtils();
         try (Connection con = DatabaseConnector.connectToDatabase();
              PreparedStatement prepStmt = con.prepareStatement(query);
              ResultSet resultSet = prepStmt.executeQuery()) {

             while (resultSet.next()) {
                 Timestamp eqReturnDateTime = resultSet.getTimestamp("eqReturnDateTime");

                 LocalDate currentDate = LocalDate.now();
                 LocalDate returnDate = eqReturnDateTime.toLocalDateTime().toLocalDate();

                 // Check if return date is within 1 day of current date
                 if (returnDate.equals(currentDate.plusDays(1))) {
                     // Call sendEmail and draftEmail functions
                     draftEmail();
                     sendEmail();
                     // Update email_sent flag to true for the processed event
                     dbUtil.updateEmailSentStatus();
                 }
             }
         } catch (SQLException e) {
             e.printStackTrace();

         }
    }
}

