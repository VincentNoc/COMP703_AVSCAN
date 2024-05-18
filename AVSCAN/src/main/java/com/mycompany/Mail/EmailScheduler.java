/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Mail;
import java.sql.SQLException;
import org.jobrunr.jobs.annotations.Job;
import org.jobrunr.scheduling.BackgroundJob;

import org.jobrunr.scheduling.JobScheduler;
/**
 *
 * @author jazzy-wazzy
 */


public class EmailScheduler {

    public static void main(String[] args) throws SQLException {
        JobRunrSetUp.initializeJobRunr();

        JobScheduler jobScheduler = JobRunrSetUp.getJobScheduler();

        // Schedule a job to run immediately
//        jobScheduler.enqueue(() -> sendScheduledEmail());
        jobScheduler.enqueue(() -> scheduleJobIn5Minutes());


        // Schedule a recurring job to run every day at midnight
//        jobScheduler.scheduleRecurrently("0 0 * * *", () -> sendScheduledEmail());
    }
    
    
    public static String getCronExpressionFor1MinutesFromNow() {
        // Calculate the time 5 minutes from now
        long currentTimeInMillis = System.currentTimeMillis();
        long fiveMinutesInMillis = 1 * 60 * 1000; // 5 minutes in milliseconds
        long targetTimeInMillis = currentTimeInMillis + fiveMinutesInMillis;

        // Convert the target time to a cron expression
        // For simplicity, we'll assume the time is within the same hour
        // The format is minutes, hours, day of month, month, day of week
        // We'll set minutes to 0 (start of the hour) and hours to the target hour
        long targetHour = (targetTimeInMillis / (60 * 60 * 1000)) % 24; // Get the hour portion
        return "0 " + targetHour + " * * *"; // Run at the start of the target hour
    }
    

    @Job(name = "Send Scheduled Email")
    public static void sendScheduledEmail() {
        try {
            Mail mail = new Mail();
            mail.checkEmailSent();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Job(name = "print Message")
    public static void printMessage(){
        System.out.println("YOOOO ITS BEEN 1 mins");
    }
    
    
    public static void scheduleJobIn5Minutes() {
        // Calculate the cron expression for 5 minutes from now
        String cronExpression = getCronExpressionFor1MinutesFromNow();
        // Schedule the job using the calculated cron expression
        BackgroundJob.scheduleRecurrently(cronExpression, EmailScheduler::printMessage);
    }
}