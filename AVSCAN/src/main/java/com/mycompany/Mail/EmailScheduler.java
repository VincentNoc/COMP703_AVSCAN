/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Mail;
import java.sql.SQLException;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
/**
 *
 * @author jazzy-wazzy
 */


public class EmailScheduler {

    public static void main(String[] args) throws SQLException {
        try{
            //initializes scheduler object
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            //starts scheduler
            scheduler.start();
            
            JobDetail job = JobBuilder.newJob(EmailJob.class)
                    .withIdentity("emailJob", "group1")
                    .build();
            
            // Define a trigger for the job with misfire instructions
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("emailTrigger", "group1")
                    .startNow()
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule()
//                            .withIntervalInHours(24) // Execute every 24 hours
                            .withIntervalInMinutes(2)
                            .repeatForever()
                            .withMisfireHandlingInstructionFireNow()) // Handle misfires
                    .build();
            
            
            scheduler.scheduleJob(job, trigger);
            
        }catch(SchedulerException e){
            e.printStackTrace();
        }
    }
    
}