/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Mail;

/**
 *
 * @author vince-kong
 */
public class MailCredentials {
    private String emailAdd;
    private String emailPass;
    
    public MailCredentials(){
        this.emailAdd = "Avscansmtp@outlook.com";
        this.emailPass = "AUTAV26022024";
    }
    
    
    public String getEmailAdd(){
        return emailAdd;
    }
    
     public String getEmailPass(){
        return emailPass;
    }
}
