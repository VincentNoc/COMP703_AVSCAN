/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avscan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 *
 * @author vince-kong
 */

public class DatabaseUtils {
  Connection con;
  private final String URL="jdbc:mysql://localhost:3306/mysql";
  private final String USER= "root";
  private final String PASSWORD = "AUT4events_";

  public DatabaseUtils() throws SQLException {
    this.con = DatabaseConnector.connectToDatabase();
  }
  
  public DatabaseUtils(String equipmentID, String equipmentName, String equipmentType) {
    insertData(equipmentID, equipmentName, equipmentType);
  }

  public final void insertData(String equipmentID, String equipmentName, String equipmentType) {
    String query = "INSERT INTO EquipmentLog (EquipmentID, EquipmentName, EquipmentType) VALUES (?, ?, ?)";
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
      System.out.println("Connected to Database");
      
      Statement stmt = con.createStatement();
      PreparedStatement prepStmt = con.prepareStatement(query);
      prepStmt.setString(1, equipmentID);
      prepStmt.setString(2, equipmentName);
      prepStmt.setString(3, equipmentType);
      prepStmt.execute();

      System.out.println("Information added");
      con.close();

    } catch (Exception e) {
      System.out.println("CAN\'T CONNECT TO DATABASE!! Can't add new Item");
    }
  }

  public void fetchDataFromDatabase() {
      
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
      System.out.println("Connected to Database");

      
      Statement stmt = con.createStatement();
      String query ="SELECT * FROM EquipmentLog";
      ResultSet rs = stmt.executeQuery(query);

      while(rs.next()){
          String equipmentID = rs.getString("EquipmentID");
          String equipmentName = rs.getString("EquipmentName");
          String equipmentType = rs.getString("EquipmentType");
      }
    } catch (Exception e) {
        System.err.println("Error!");
        System.err.println("Was not able to retrieve data from database.");
        e.printStackTrace();
      
    }
  }
}