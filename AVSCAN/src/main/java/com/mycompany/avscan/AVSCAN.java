/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avscan;

import com.formdev.flatlaf.FlatLightLaf;
import com.mycompany.Mail.Mail;
import com.mycompany.avscan.Login_Signup_pages.LoginPage;
import java.sql.SQLException;
import javax.mail.MessagingException;

/**^
 *
 * @author vince-kongs
 */
public class AVSCAN {
    public static void main(String args[]) throws SQLException{
        FlatLightLaf.setup();
        LoginPage lp = new LoginPage();
        Mail mail = new Mail();
        try{
            lp.setVisible(true);
            mail.checkEmailSent();
        }catch(MessagingException e){
            e.printStackTrace();
        }
    }
}
