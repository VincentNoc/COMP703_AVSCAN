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

import javax.swing.table.DefaultTableModel;


/**
 *
 * @author vince-kong
 */
public class DatabaseUtils {

    Connection con;
    //private final String URL = "jdbc:mysql://localhost:3306/mysql";//Use that one as default version
    private final String URL = "jdbc:mysql://localhost:3306/avscan";//Don't use that one!!!!
    private final String USER = "root";
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

    //Added by Dmitry
    //the same method as default one but using different value to store data and also using parrent ID
    public DatabaseUtils(DefaultTableModel table) {
        insertData(table);
    }
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

    public List<Data> fetchDataFromDatabase() {
        List<Data> dataList = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            // Your code for executing queries and processing results
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * from EquipmentLog");

            while (rs.next()) {
                Data equipment = new Data(rs.getString(1), rs.getString(2), rs.getString(3));
                dataList.add(equipment);
                System.out.println(equipment.toString());//to show data
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataList;
    }
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

    public List<Data> fetchDataFromEquipmentLog() {
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
    }

    public List<MaintenanceData> fetchMaintenanceData() {
        List<MaintenanceData> dataList = new ArrayList<>();

        
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            // Your code for executing queries and processing results
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT DISTINCT Maintenance.EquipmentID, child.EquipmentName, parent.EquipmentID AS ParentID, parent.EquipmentName AS ParentName, \n"
                    + "Maintenance.Description, Maintenance.Received, Maintenance.repairedReturned\n"
                    + "From Maintenance LEFT JOIN EquipmentLog AS child ON Maintenance.EquipmentID = child.EquipmentID\n"
                    + "LEFT JOIN EquipmentLog AS parent ON child.ParentID = parent.EquipmentID\n"
                    + "ORDER BY Maintenance.Received;");

            while (rs.next()) {
                MaintenanceData equipment = new MaintenanceData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getTimestamp(6), rs.getTimestamp(7));
                dataList.add(equipment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataList;
    }
    public Hashtable<String, MaintenanceData> fetchHashtableMaintenanceData() {
        Hashtable<String, MaintenanceData> dataList = new Hashtable<>();

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            // Your code for executing queries and processing results
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT DISTINCT Maintenance.EquipmentID, child.EquipmentName, parent.EquipmentID AS ParentID, parent.EquipmentName AS ParentName, \n"
                    + "Maintenance.Description, Maintenance.Received, Maintenance.repairedReturned\n"
                    + "From Maintenance LEFT JOIN EquipmentLog AS child ON Maintenance.EquipmentID = child.EquipmentID\n"
                    + "LEFT JOIN EquipmentLog AS parent ON child.ParentID = parent.EquipmentID\n"
                    + "ORDER BY Maintenance.Received DESC;");

            while (rs.next()) {
                MaintenanceData equipment = new MaintenanceData(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getTimestamp(6), rs.getTimestamp(7));
                dataList.put(equipment.getEqID(), equipment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataList;
    }
    
    public List<MaintenanceData> fetchHashtableMaintenanceSearchData(String ID, String Name, String received, String returned) {
        List<MaintenanceData> dataList = new ArrayList<>();
        String query = "SELECT DISTINCT Maintenance.EquipmentID, child.EquipmentName, parent.EquipmentID AS ParentID, parent.EquipmentName AS ParentName, \n"
                    + "Maintenance.Description, Maintenance.Received, Maintenance.repairedReturned\n"
                    + "From Maintenance LEFT JOIN EquipmentLog AS child ON Maintenance.EquipmentID = child.EquipmentID\n"
                    + "LEFT JOIN EquipmentLog AS parent ON child.ParentID = parent.EquipmentID\n"
                    + "WHERE ";
        
        boolean canditionAdded = false;
        
        if(!ID.equals("")){
            query += ("Maintenance.EquipmentID = \'"+ ID + "\'");
            canditionAdded = true;
        }
        if(!Name.equals("")){
            if(canditionAdded == true){
                query += " AND";
            }
            query += (" child.EquipmentName = \'" + Name + "\'");
            canditionAdded = true;
        }
        if(!received.equals("dd/mm/yyyy")){
            if(canditionAdded == true){
                query += " AND";
            }
            query += (" Maintenance.Received Like \'"+ received+"\'");
            canditionAdded = true;
        }
        if(!returned.equals("dd/mm/yyyy")){
            if(canditionAdded == true){
                query += " AND";
            }
            query += (" Maintenance.repairedReturned Like \'"+ returned+"\'");
        }
        query += "\n";
        query += "ORDER BY Maintenance.Received DESC;";
        
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
   
}
