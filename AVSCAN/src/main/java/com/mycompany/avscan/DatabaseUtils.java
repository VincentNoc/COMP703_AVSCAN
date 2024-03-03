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
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "AUT4events_");
      System.out.println("Connected to Database");

      ////here sonoo is database name, root is username and password  
      Statement stmt = con.createStatement();
      PreparedStatement prepStmt = con.prepareStatement("insert into EquipmentLog (EquipmentID, EquipmentName, EquipmentType)" + " values (?, ?, ?)");
      prepStmt.setString(1, equipmentID);
      prepStmt.setString(2, equipmentName);
      prepStmt.setString(3, equipmentType);
      prepStmt.execute();
      ResultSet rs = stmt.executeQuery("select * from ITEMS");

      System.out.println("Information added");
      con.close();

    } catch (Exception e) {
      System.out.println("CAN\'T CONNECT TO DATABASE!! Can't add new Item");
    }
  }

  public void showTable() {

  }
}