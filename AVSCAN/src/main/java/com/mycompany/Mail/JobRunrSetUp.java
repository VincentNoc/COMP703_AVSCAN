/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Mail;

import org.jobrunr.configuration.JobRunr;
import org.jobrunr.scheduling.JobScheduler;
import org.jobrunr.configuration.JobRunrConfiguration;
import org.jobrunr.storage.sql.SqlStorageProvider;
import org.jobrunr.storage.sql.mysql.MySqlStorageProvider;
import com.mysql.cj.jdbc.MysqlDataSource;


import java.sql.SQLException;
import org.jobrunr.server.BackgroundJobServer;
import org.jobrunr.server.JobActivator;
import org.jobrunr.storage.sql.common.SqlStorageProviderFactory;


/**
 *
 * @author jazzy-wazzy
 */


public class JobRunrSetUp {
    private static JobScheduler jobScheduler;
    private static BackgroundJobServer backgroundJobServer;
    
    
    public static void initializeJobRunr() throws SQLException {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/mysql");
        dataSource.setUser("root");
        dataSource.setPassword("AUT4events_");
        
        JobActivator JA;
        
        JobRunr.configure()
           .useJobActivator(JA)
                .useStorageProvider(SqlStorageProviderFactory
                .using(dataSource))
                .useBackgroundJobServer()
                .useDashboard()
                .initialize().getJobScheduler();

        jobScheduler = JobRunr.getBackgroundJobServer();
        backgroundJobServer = JobRunr.getBackgroundJobServer();
        
    }
    
     public static JobScheduler getJobScheduler() {
        return jobScheduler;
    }
     
    public static BackgroundJobServer getBackgroundJobServer() {
        return backgroundJobServer;
    }
}
