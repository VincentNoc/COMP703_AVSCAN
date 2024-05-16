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
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author vince-kong
 */

public class DatabaseUtils {

    Connection con;
//    private final String URL="jdbc:mysql://localhost:3306/avscan";
    private final String URL="jdbc:mysql://localhost:3306/mysql";
    private final String USER= "root";
    private final String PASSWORD = "AUT4events_";

    public DatabaseUtils() throws SQLException{
      this.con = DatabaseConnector.connectToDatabase();
    }

    public DatabaseUtils(String equipmentID, String equipmentName, String equipmentType) throws SQLException {
      insertDataEquipmentLog(equipmentID, equipmentName, equipmentType);
    }

     public DatabaseUtils(String evID, String evName, String evEquipmentID, String stID,  String eqSentDateTime, String eqReturnDateTime) throws SQLException{
      insertDataEventTable( evID,  evName, evEquipmentID, stID, eqSentDateTime,  eqReturnDateTime);
    }

    public DatabaseUtils(String username, String password) throws SQLException{
      loginCredentials(username, password);
    }

    public DatabaseUtils(DefaultTableModel table) {
        insertData(table);
    }
    

    public final void insertDataEquipmentLog(String equipmentID, String equipmentName, String equipmentType) {
        String query = "INSERT INTO EquipmentLog (eqID, eqName, eqType, eqStatus) VALUES (?, ?, ?, ?)";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to Database");

            // Use PreparedStatement to prevent SQL injection
            PreparedStatement prepStmt = con.prepareStatement(query);
            prepStmt.setString(1, equipmentID);
            prepStmt.setString(2, equipmentName);
            prepStmt.setString(3, equipmentType);
            prepStmt.setString(4, "Checked In"); // Set the boolean value for the fourth parameter

            prepStmt.executeUpdate(); // Use executeUpdate for INSERT operations

            System.out.println("Information added");
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("CAN'T CONNECT TO DATABASE!! Can't add new Item");
        }
    }
  
    //Added by Dmitry
    //the same method as default one but using different value to store data and also using parrent ID
  
    private final void insertData(DefaultTableModel table) {
        String query = "INSERT INTO EquipmentLog (EquipmentID, EquipmentName, EquipmentType, parentID) VALUES (?, ?, ?, ?)";
        int size = table.getRowCount();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to Database");

            while (size > 0 ) {
                size--;
                String equipmentID = (String) table.getValueAt(size, 0);
                String equipmentName = (String) table.getValueAt(size, 1);
                String equipmentType = (String) table.getValueAt(size, 2);
                String eqyipmentParent = (String) table.getValueAt(size, 3);
                
                Statement stmt = con.createStatement();
                PreparedStatement prepStmt = con.prepareStatement(query);
                prepStmt.setString(1, equipmentID);
                prepStmt.setString(2, equipmentName);
                prepStmt.setString(3, equipmentType);
                prepStmt.setString(4, eqyipmentParent);
                prepStmt.execute();
            }

            System.out.println("Information added");
            con.close();

        } catch (Exception e) {
            System.out.println("CAN\'T CONNECT TO DATABASE!! Can't add new Item");
        }
    } //End of added by Dmitry
  

  public final void insertDataEventTable(String evID, String evName, String eqID, String stID, String eqSentDateTime, String eqReturnDateTime) throws SQLException {
    String eventQuery = "INSERT INTO Event (evID, evName) VALUES (?, ?)";
    String bookingQuery = "INSERT INTO Booking (evID, evName, eqID, stID ,eqSentDateTime, eqReturnDateTime) VALUES (?, ?, ?, ?, ?, ?)";
    
    DatabaseConnector dbCon = new DatabaseConnector();
    Timestamp timeStampSent = Timestamp.valueOf(eqSentDateTime);
    Timestamp timeStampReturn = Timestamp.valueOf(eqReturnDateTime);
    try (Connection con = dbCon.connectToDatabase();
   
         PreparedStatement eventStmt = con.prepareStatement(eventQuery);
         PreparedStatement bookingStmt = con.prepareStatement(bookingQuery)) {

        // Insert into Event table
        eventStmt.setString(1, evID);
        eventStmt.setString(2, evName);
        eventStmt.executeUpdate();

        // Insert into Booking table
        bookingStmt.setString(1, evID);
        bookingStmt.setString(2, evName);
        bookingStmt.setString(3, eqID);
        bookingStmt.setString(4, stID);
        bookingStmt.setTimestamp(5, timeStampSent);
        bookingStmt.setTimestamp(6, timeStampReturn);
        bookingStmt.executeUpdate();

        System.out.println("Data inserted into Event and Booking tables successfully");
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Failed to insert data into Event and Booking tables");
    }
}
  

public final void updateEquipmentStatus(String selectedEquipmentIDs) throws SQLException{
    String query ="UPDATE equipmentlog SET eqStatus = 'Checked Out' WHERE eqID = ?";
    DatabaseConnector dbCon = new DatabaseConnector();
    
    try(Connection con = dbCon.connectToDatabase();
            PreparedStatement prepStmt = con.prepareStatement(query)){
       
            prepStmt.setString(1, selectedEquipmentIDs);
            prepStmt.executeUpdate();
  
    }catch(SQLException e){
        e.printStackTrace();
    }
}
  


    public List<Data> fetchDataFromEquipmentLog() throws SQLException {
     List<Data> dataList = new ArrayList<>();
     DatabaseConnector dbCon = new DatabaseConnector();
     Connection con = null; 
     String query = "SELECT * FROM equipmentlog";

     try {
         con = dbCon.connectToDatabase();
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery(query);

         while (rs.next()) {
             Data equipment = new Data(rs.getString(1), rs.getString(2), rs.getString(3));
             dataList.add(equipment);
         }
     } catch (SQLException e) {
         e.printStackTrace();
     } finally {
         try {
             if (con != null) {
                 con.close();  // Close connection in finally block
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }
     }
        return dataList;
    }
  
   public final boolean loginCredentials(String username, String password) throws SQLException{
       DatabaseConnector dbCon= new DatabaseConnector();
      try(Connection con = dbCon.connectToDatabase();){
        String query = "SELECT * FROM staff WHERE stName = ? AND password = ?";
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
   
   public final void insertStaff(String Username,String StaffID, String password){
        String query = "INSERT INTO staff (stName, stID, password) VALUES (?, ?, ?)";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            DatabaseConnector dbCon= new DatabaseConnector();
            Connection con = dbCon.connectToDatabase();//connects to database without needing to write the drivermanager
            PreparedStatement prepStmt = con.prepareStatement(query);
            prepStmt.setString(1, Username);
            prepStmt.setString(2, StaffID);
            prepStmt.setString(3, password);
            prepStmt.execute();

            System.out.println("Information added");
            con.close();

        }catch (Exception e) {
            System.out.println("CAN\'T CONNECT TO DATABASE!! Can't add new Item");
        }
   }
   
   public void updateEmailSentStatus() throws SQLException{
       String updateQuery = "UPDATE Booking SET email_sent = true WHERE eqReturnDateTime >= DATE_ADD(CURDATE(), INTERVAL 1 DAY) AND TIMESTAMPDIFF(DAY, eqSentDateTime, eqReturnDateTime) > 1 AND email_sent = false";
       DatabaseConnector dbCon = new DatabaseConnector();
       try(
            Connection con = dbCon.connectToDatabase();//connects to database without needing to write the drivermanager
            PreparedStatement prepStmt = con.prepareStatement(updateQuery)){
            prepStmt.executeUpdate();
       }catch(SQLException e){
           e.printStackTrace();
       }
   }
   
    public List<HistoryData> fetchHistoryFromDatabase() {
        List<HistoryData> dataList = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            // Your code for executing queries and processing results
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Event.evID, Event.evEquipmentID, Child.EquipmentName AS EquipmentName, Child.ParentID, Parent.EquipmentName AS ParentEquipmentName,\n" +
                " Event.eqReturnDateTime, Event.evCheckOutStaff\n" +
                " FROM Event LEFT JOIN EquipmentLog AS Child ON Event.evEquipmentID = Child.EquipmentID\n" +
                " LEFT JOIN EquipmentLog AS Parent ON Child.ParentID = Parent.EquipmentID\n" +
                " ORDER BY Event.evID;");

            while (rs.next()) {
                HistoryData event = new HistoryData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                 rs.getString(5), rs.getTimestamp(6), rs.getString(7));
                dataList.add(event);
                //System.out.println(event.toString());//to show data
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataList;
    }

}
