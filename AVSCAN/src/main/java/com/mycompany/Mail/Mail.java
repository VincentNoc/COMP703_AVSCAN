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
import java.sql.Statement;
import javax.sql.*;
/**
 *
 * @author vince-kong
 */


public class Mail {
    Session newSession = null;
    MimeMessage mimeMessage = null;

    public static void main(String args[]) {
        Mail mail = new Mail();
        try {
            mail.setUpServerProperties();
            mail.draftEmail();
            mail.sendEmail();
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Failed to send email: " + e.getMessage());
        }
    }

    private void setUpServerProperties() {
        Properties prop = new Properties();
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        newSession = Session.getDefaultInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("Avscansmtp@outlook.com", "AUTAV26022024");
            }
        });
    }

    private void draftEmail() throws MessagingException {
       String[] emailReceipients = {"kst0629@autuni.ac.nz"};
       String emailSubject = "Return AV Equipment";
       StringBuilder emailBody = new StringBuilder();
//       String emailBody = "";
       
       try{
            DatabaseConnector dbCon= new DatabaseConnector();
            Connection con = dbCon.connectToDatabase();
            String query="SELECT * FROM Event WHERE eqReturnDateTime >= DATE_SUB(CURDATE(), INTERVAL 3 DAY)";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            emailBody.append("<html><body>");
            emailBody.append("<h2>AV Equipment close to return date.</h2>");
           
       }catch(Exception e){
           e.printStackTrace();
       }
       
       mimeMessage = new MimeMessage(newSession);
       mimeMessage.setFrom(new InternetAddress("Avscansmtp@outlook.com")); // Set the From address
       for (int i = 0; i < emailReceipients.length; i++) {
           mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(emailReceipients[i]));
       }
       mimeMessage.setSubject(emailSubject);
       MimeBodyPart bodyPart = new MimeBodyPart();
       bodyPart.setContent(emailBody, "text/html");
       Multipart multiPart = new MimeMultipart();
       multiPart.addBodyPart(bodyPart);
       mimeMessage.setContent(multiPart);
   }

    private void sendEmail() throws MessagingException {
        String emailHost ="smtp-mail.outlook.com";
        try (Transport transport = newSession.getTransport("smtp")) {
            transport.connect(emailHost, "Avscansmtp@outlook.com", "AUTAV26022024");
            transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
            System.out.println("Email successfully sent!!!");
        }
    }
}

