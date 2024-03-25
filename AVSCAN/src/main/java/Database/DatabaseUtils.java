/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;


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
    insertDataEquipmentLog(equipmentID, equipmentName, equipmentType);
  }
  
  public DatabaseUtils(String evID, String evEquipmentID, String evName, String evDateTime, String evCheckOutStaff, String eqSentDateTime, String eqReturnDateTime){
      insertDataEventTable( evID,  evEquipmentID,  evName,  evDateTime,  evCheckOutStaff,  eqSentDateTime,  eqReturnDateTime);
  }
  
  public DatabaseUtils(String username, String password){
      loginCredentials(username, password);
  }

  public final void insertDataEquipmentLog(String equipmentID, String equipmentName, String equipmentType) {
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

  public final void insertDataEventTable(String evID, String evEquipmentID, String evName, String evDateTime, String evCheckOutStaff, String eqSentDateTime, String eqReturnDateTime){
    String query = "INSERT INTO Event (evID, evEquipmentID, evName, evDateTime, evCheckOutStaff, eqSentDateTime, eqReturnDateTime) VALUES (?, ?, ?, ?, ?, ?, ? )";
   
    try {
      Timestamp timeStampSent = Timestamp.valueOf(eqSentDateTime);
      Timestamp timeStampReturn = Timestamp.valueOf(eqReturnDateTime);

      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
      System.out.println("Connected to Database");
      
      Statement stmt = con.createStatement();
      PreparedStatement prepStmt = con.prepareStatement(query);
      prepStmt.setString(1, evID);
      prepStmt.setString(2, evEquipmentID);
      prepStmt.setString(3, evName);
      prepStmt.setString(4, evDateTime);
      prepStmt.setString(5, evCheckOutStaff);
      prepStmt.setTimestamp(6, timeStampSent);
      prepStmt.setTimestamp(7, timeStampReturn);

      prepStmt.execute();

      System.out.println("Information added");
      con.close();

    } catch (Exception e) {
//      System.out.println("CAN\'T CONNECT TO DATABASE!! Can't add new Item");
      e.printStackTrace();
    }
  }
  
  
public List<Data> fetchDataFromEquipmentLog() {
    List<Data> dataList = new ArrayList<>();
 
    try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * from EquipmentLog");

        while (rs.next()) {
            Data equipment = new Data(rs.getString(1), rs.getString(2), rs.getString(3));
            dataList.add(equipment);
        }
        
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    return dataList;
}
  
   public final boolean loginCredentials(String username, String password){
      
      try(Connection con = DriverManager.getConnection(URL, USER, PASSWORD)){
        String query = "SELECT * FROM Staff WHERE stName = ? AND password = ?";
        try(PreparedStatement prepStm = con.prepareStatement(query)){
            prepStm.setString(1, username);
            prepStm.setString(2, password);
            try(ResultSet rs = prepStm.executeQuery()){
                return rs.next();
            }

        }
      }catch(SQLException e){
          e.printStackTrace();
          return false;
      }
  }
 
}