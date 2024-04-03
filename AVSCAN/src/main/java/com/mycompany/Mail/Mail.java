/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Mail;

import java.io.IOException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
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
       String emailSubject = "Test Mail";
       String emailBody = "Test Body of my email";
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

