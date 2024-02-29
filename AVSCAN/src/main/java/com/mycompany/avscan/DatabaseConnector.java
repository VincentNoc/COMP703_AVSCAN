/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avscan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author vince-kong
 */
public class DatabaseConnector {
    //these three could potentially change depending on how you've set up your DB. 
    private static final String URL = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private static final String USER = "root";
    private static final String PASSWORD = "AUT4events_";
    
    public ArrayList<Data> equipment = new ArrayList<>();
    
        private void connectToDatabase() {
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to Database");
//here sonoo is database name, root is username and password  
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from EquipmentLog");
            while (rs.next()) {
                System.out.println(rs.getLong(1) + "  " + rs.getString(2));
                Data equipment = new Data(rs.getString(1), rs.getString(2), rs.getString(3));
                this.equipment.add(equipment);
            }
            con.close();
        } catch (Exception e) {
            System.out.println("Error has occurred, could not connect to database.");
        }
    }
    
}
