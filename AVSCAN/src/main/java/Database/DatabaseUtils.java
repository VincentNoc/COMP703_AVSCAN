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
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.table.DefaultTableModel;
import multi.use.frames.SmallErrorMessage;

/**
 *
 * @author vince-kong
 */

public class DatabaseUtils {

    Connection con;
    private final String URL="jdbc:mysql://localhost:3306/avscan";
    //private final String URL="jdbc:mysql://localhost:3306/mysql";
    private final String USER= "root";
    private final String PASSWORD = "AUT4events_";

    public DatabaseUtils() throws SQLException{
      this.con = DatabaseConnector.connectToDatabase();
    }

    public DatabaseUtils(String equipmentID) throws SQLException {
      updateEquipmentLogStatusCheckedIn(equipmentID);
    }

     public DatabaseUtils(String evID, String evName, String evEquipmentID, String stID,  String eqSentDateTime, String eqReturnDateTime) throws SQLException{
      insertDataBookingTable( evID,  evName, evEquipmentID, stID, eqSentDateTime,  eqReturnDateTime);
    }

    public DatabaseUtils(String username, String password) throws SQLException{
      loginCredentials(username, password);
    }

    public DatabaseUtils(DefaultTableModel table) {
        insertDataEquipmentLog(table);
    }
    

    public final void updateEquipmentLogStatusCheckedIn(String equipmentID) {
        String query = "UPDATE EquipmentLog " +
                        "SET eqStatus = \'Checked In\' " +
                        "WHERE eqID = ?";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to Database");

            // Use PreparedStatement to prevent SQL injection
            PreparedStatement prepStmt = con.prepareStatement(query);
            prepStmt.setString(1, equipmentID);

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
  
    public final void insertDataEquipmentLog(DefaultTableModel table) {
        String query = "INSERT INTO EquipmentLog (eqID, eqName, eqType, parentID, eqStatus) VALUES (?, ?, ?, ?, ?)";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to Database");

            for (int i = 0; i<table.getRowCount();i++ ) {
                String equipmentID = (String) table.getValueAt(i, 0);
                String equipmentName = (String) table.getValueAt(i, 1);
                String equipmentType = (String) table.getValueAt(i, 2);
                String eqyipmentParent = (String) table.getValueAt(i, 3);
                
                PreparedStatement prepStmt = con.prepareStatement(query);
                prepStmt.setString(1, equipmentID);
                prepStmt.setString(2, equipmentName);
                prepStmt.setString(3, equipmentType);
                prepStmt.setString(4, eqyipmentParent);
                prepStmt.setString(5, "Checked In");
                prepStmt.execute();
            }

            System.out.println("Information added");
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("CAN\'T CONNECT TO DATABASE!! Can't add new Item");
            e.printStackTrace();
        }
    } //End of added by Dmitry
  

  public final void insertDataBookingTable(String evID, String evName, String eqID, String stID, String eqSentDateTime, String eqReturnDateTime) throws SQLException {
    
    String bookingQuery = "INSERT INTO Booking (evID, evName, eqID, stID ,eqSentDateTime, eqReturnDateTime) VALUES (?, ?, ?, ?, ?, ?)";
    
    DatabaseConnector dbCon = new DatabaseConnector();
    Timestamp timeStampSent = Timestamp.valueOf(eqSentDateTime);
    Timestamp timeStampReturn = Timestamp.valueOf(eqReturnDateTime);
    try (Connection con = dbCon.connectToDatabase();
         PreparedStatement bookingStmt = con.prepareStatement(bookingQuery)) {

        // Insert into Event table
        

        // Insert into Booking table
        bookingStmt.setString(1, evID);
        bookingStmt.setString(2, evName);
        bookingStmt.setString(3, eqID);
        bookingStmt.setString(4, stID);
        bookingStmt.setTimestamp(5, timeStampSent);
        bookingStmt.setTimestamp(6, timeStampReturn);
        bookingStmt.executeUpdate();

        System.out.println("Data inserted into Booking tables successfully");
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Failed to insert data into Booking tables");
    }
}
  
public final void insertDataEventTable(String evID, String evName) throws SQLException {
    String eventQuery = "INSERT INTO Event (evID, evName) VALUES (?, ?)";
    DatabaseConnector dbCon = new DatabaseConnector();
    
    try (Connection con = dbCon.connectToDatabase();
            PreparedStatement eventStmt = con.prepareStatement(eventQuery);){
        
        eventStmt.setString(1, evID);
        eventStmt.setString(2, evName);
        eventStmt.executeUpdate();
        System.out.println("Data inserted into Event tables successfully");
    }catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Failed to insert data into Event tables");
    }
}
  




public final void updateEquipmentStatusCheckedOut(String selectedEquipmentIDs) throws SQLException{
    String query ="UPDATE equipmentlog SET eqStatus = \'Checked Out\' WHERE eqID = ?";
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
       String updateQuery = "UPDATE Event SET email_sent = true WHERE eqReturnDateTime >= DATE_ADD(CURDATE(), INTERVAL 1 DAY) AND TIMESTAMPDIFF(DAY, eqSentDateTime, eqReturnDateTime) > 1 AND email_sent = false";
       DatabaseConnector dbCon = new DatabaseConnector();
       try(
            Connection con = dbCon.connectToDatabase();//connects to database without needing to write the drivermanager
            PreparedStatement prepStmt = con.prepareStatement(updateQuery)){
            prepStmt.executeUpdate();
       }catch(SQLException e){
           e.printStackTrace();
       }
   }
   
   //Don't need any more??
    /*public List<HistoryData> fetchHistoryFromDatabase() {
        List<HistoryData> dataList = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            // Your code for executing queries and processing results
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Event.evID, Event.evEquipmentID, Child.EquipmentName AS EquipmentName, Child.ParentID, Parent.EquipmentName AS ParentEquipmentName,\n" +
                " Event.eqReturnDateTime, Event.evCheckOutStaff, \n" +
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
    }*/

    public final void insertDataEventTable(String evID, String evEquipmentID, String evName, String evDateTime, String evCheckOutStaff, String eqSentDateTime, String eqReturnDateTime) {
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

    /*public List<Data> fetchDataFromEquipmentLog() {
        List<Data> dataList = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            // Your code for executing queries and processing results
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * from EquipmentLog");

            while (rs.next()) {
                Data equipment = new Data(rs.getString(1), rs.getString(2), rs.getString(3));
                dataList.add(equipment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataList;
    }*/

    public List<MaintenanceData> fetchMaintenanceData() {
        List<MaintenanceData> dataList = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            // Your code for executing queries and processing results
            Statement stmt = con.createStatement();
            
            String oldQery="SELECT DISTINCT Maintenance.EquipmentID, child.EquipmentName, parent.EquipmentID AS ParentID, parent.EquipmentName AS ParentName, \n"
                    + "Maintenance.Description, Maintenance.Received, Maintenance.repairedReturned\n"
                    + "From Maintenance LEFT JOIN EquipmentLog AS child ON Maintenance.EquipmentID = child.EquipmentID\n"
                    + "LEFT JOIN EquipmentLog AS parent ON child.ParentID = parent.EquipmentID\n"
                    + "ORDER BY Maintenance.Received DESC;";
            
            String qery = "SELECT DISTINCT Maintenance.eqID, child.eqName, parent.eqID AS ParentID, parent.eqName AS ParentName, \n"
                    + "Maintenance.mntDescription, Maintenance.mntRecieved, Maintenance.mntRepairedReturned\n"
                    + "From Maintenance LEFT JOIN EquipmentLog AS child ON Maintenance.eqID = child.eqID\n"
                    + "LEFT JOIN EquipmentLog AS parent ON child.ParentID = parent.eqID\n"
                    + "ORDER BY Maintenance.mntRecieved DESC;";
            
            ResultSet rs = stmt.executeQuery(qery);

            while (rs.next()) {
                MaintenanceData equipment = new MaintenanceData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getTimestamp(6), rs.getTimestamp(7));
                dataList.add(equipment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataList;
    }

    //Dmitry modified
    public List<MaintenanceData> fetchHashtableMaintenanceSearchData(String ID, String Name, String received, String returned) {
        List<MaintenanceData> dataList = new ArrayList<>();
        String query = "SELECT DISTINCT Maintenance.eqID, child.eqName, parent.eqID AS ParentID, parent.eqName AS ParentName, \n"
                + "Maintenance.mntDescription, Maintenance.mntRecieved, Maintenance.mntRepairedReturned\n"
                + "From Maintenance LEFT JOIN EquipmentLog AS child ON Maintenance.eqID = child.eqID\n"
                + "LEFT JOIN EquipmentLog AS parent ON child.ParentID = parent.eqID\n"
                + "WHERE ";

        boolean canditionAdded = false;

        if (!ID.equals("")) {
            query += ("Maintenance.eqID LIKE \'%" + ID + "%\'");
            canditionAdded = true;
        }
        if (!Name.equals("")) {
            if (canditionAdded == true) {
                query += " AND";
            }
            query += (" child.eqName LIKE \'%" + Name + "%\'");
            canditionAdded = true;
        }
        if (!received.equals("yyyy-mm-dd")) {
            if (canditionAdded == true) {
                query += " AND";
            }
            query += (" Maintenance.mntRecieved LIKE \'%" + received + "%\'");
            canditionAdded = true;
        }
        if (!returned.equals("yyyy-mm-dd")) {
            if (canditionAdded == true) {
                query += " AND";
            }
            query += (" Maintenance.mntRepairedReturned LIKE \'%" + returned + "%\'");
        }
        query += " ";
        query += "ORDER BY Maintenance.mntRecieved DESC";

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            // Your code for executing queries and processing results
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                MaintenanceData equipment = new MaintenanceData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getTimestamp(6), rs.getTimestamp(7));
                dataList.add(equipment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataList;
    }

    public boolean newInsertIntoMaintenanceTable(String eqID, String description, String received) {
        String query = "INSERT INTO Maintenance (eqID, mntDescription, mntRecieved, mntRepairedReturned)\n"
                + "VALUES (?, ?, ?, ?);";
//Checked In
//Checked out
        String updateEquipmentStatus = "UPDATE EquipmentLog " +
                                        "SET eqStatus = 'In Maintenance' " +
                                        "WHERE eqID = ?";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to Database");
            

            Statement stmt = con.createStatement();
            
            PreparedStatement findEqStatus = con.prepareStatement(updateEquipmentStatus);
            findEqStatus.setString(1, eqID);
            findEqStatus.execute();
            
            
            PreparedStatement prepStmt = con.prepareStatement(query);
            prepStmt.setString(1, eqID);
            prepStmt.setString(2, description);
            prepStmt.setString(3, received);
            prepStmt.setString(4, null);
            prepStmt.execute();

            System.out.println("Information added");
            con.close();

            return true;
        } catch (Exception e) {
            System.out.println("CAN\'T CONNECT TO DATABASE!! Can't add new Item");
            return false;
        }
    }

    public Hashtable<String, Data> fetchHashtableMaintenanceData() {
        Hashtable<String, Data> dataList = new Hashtable<>();

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            // Your code for executing queries and processing results
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select * From EquipmentLog ");

            while (rs.next()) {
                Data equipment = new Data(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                dataList.put(equipment.getEquipmentID(), equipment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataList;
    }

    public boolean equipmentRetunMaintenance(MaintenanceData insert) {
        String query = "UPDATE Maintenance "
                + "SET mntRepairedReturned = ? WHERE eqID = ? AND mntDescription = ? AND "
                + "mntRecieved = ?";

        String updateEquipmentStatus = "UPDATE EquipmentLog " +
                                        "SET eqStatus = 'Checked In' " +
                                        "WHERE eqID = ?";
        
        System.out.println("\nBEFORE ADD TO DATABASE RETURN_MAINT:  "+insert.toString());
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to Database");
            
            Statement stmt = con.createStatement();
            PreparedStatement findEqStatus = con.prepareStatement(updateEquipmentStatus);
            findEqStatus.setString(1, insert.getEqID());
            findEqStatus.execute();
            
            PreparedStatement prepStmt = con.prepareStatement(query);
            prepStmt.setString(1, String.valueOf(insert.getReturned()));
            prepStmt.setString(2, insert.getEqID());
            prepStmt.setString(3, insert.getDescription());
            prepStmt.setString(4, String.valueOf(insert.getReceived()));
            prepStmt.execute();

            System.out.println("Information added");
            con.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseUtils.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseUtils.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public Hashtable<String, MaintenanceData> fetchMaintenanceUnreturned() {
        Hashtable<String, MaintenanceData> toReturn = new Hashtable<>();

        String query = "SELECT DISTINCT Maintenance.eqID, child.eqName, parent.eqID AS ParentID, parent.eqName AS ParentName, \n"
                + "Maintenance.mntDescription, Maintenance.mntRecieved, Maintenance.mntRepairedReturned\n"
                + "From Maintenance LEFT JOIN EquipmentLog AS child ON Maintenance.eqID = child.eqID\n"
                + "LEFT JOIN EquipmentLog AS parent ON child.ParentID = parent.eqID\n"
                + "WHERE Maintenance.mntRepairedReturned IS null\n"
                + "ORDER BY Maintenance.mntRecieved DESC;";
        
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            // Your code for executing queries and processing results
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                MaintenanceData equipment = new MaintenanceData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getTimestamp(6), rs.getTimestamp(7));
                toReturn.put(equipment.getEqID(), equipment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return toReturn;
    }
}
