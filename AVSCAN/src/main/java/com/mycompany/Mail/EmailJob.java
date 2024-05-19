/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Mail;


import java.sql.SQLException;
import org.quartz.Job;
import org.quartz.JobExecutionException;
import org.quartz.JobExecutionContext;


/**
 *
 * @author jazzy-wazzy
 */


public class EmailJob implements Job {

    @Override
    public void execute (JobExecutionContext context) throws JobExecutionException {
       try{
//           Mail mail = new Mail();
//           mail.checkEmailSent();
        System.out.println("Hi this is working now");
       }catch(Exception e){
           e.printStackTrace();
       }
    }
}
