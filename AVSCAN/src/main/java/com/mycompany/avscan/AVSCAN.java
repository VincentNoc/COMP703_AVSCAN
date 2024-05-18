/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avscan;

import com.formdev.flatlaf.FlatLightLaf;
import com.mycompany.Mail.JobRunrSetUp;
import com.mycompany.Mail.Mail;
import com.mycompany.avscan.Login_Signup_pages.LoginPage;
import java.sql.SQLException;
import javax.mail.MessagingException;
import org.jobrunr.server.BackgroundJobServer;

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
            //initializing JobRunr
            JobRunrSetUp.initializeJobRunr();
            
            BackgroundJobServer bgJS = JobRunrSetUp.getBackgroundJobServer();
            bgJS.start();
            
            
//            mail.checkEmailSent();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
