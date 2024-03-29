/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Mail;

import java.util.Properties;
import javax.mail.Session;

/**
 *
 * @author vince-kong
 */
public class Mail {
    Session newSession = null;
    public static void main(String args[]){
        Mail mail = new Mail();
        mail.setUpServerProperties();
        mail.draftEmail();
        mail.sendEmail();
    }

    private void setUpServerProperties() {
        Properties prop = System.getProperties();
        prop.put("mail.smtp.port", "547");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        newSession = Session.getDefaultInstance(prop, null);

    }

    private void draftEmail() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void sendEmail() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
