/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import com.mycompany.avscan.Login_Signup_pages.StaffRole;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vince-kong
 */
public class DatabaseUtils {

    Connection con;
    private final String URL = "jdbc:mysql://localhost:3306/avscans";

    private final String USER = "root";
    private final String PASSWORD = "AUT4events_";
    private DatabaseConnector dbCon;

    public DatabaseUtils() throws SQLException {
        dbCon = new DatabaseConnector();
        
    }

    public DatabaseUtils(String equipmentID) throws SQLException {
        updateEquipmentLogStatusCheckedIn(equipmentID);
    }

    public DatabaseUtils(String evID, String evName, String evEquipmentID, String stID, String eqSentDateTime, String eqReturnDateTime) throws SQLException {
        insertDataBookingTable(evID, evName, evEquipmentID, stID, eqSentDateTime, eqReturnDateTime);
    }

    public DatabaseUtils(String username, String password) throws SQLException {
        getLoginCredentials(username, password);
    }

    public DatabaseUtils(DefaultTableModel table) throws SQLException {
        insertDataEquipmentLog(table);
    }

    public final void updateEquipmentLogStatusCheckedIn(String equipmentID) throws SQLException {
        String query = "UPDATE EquipmentLog "
                + "SET eqStatus = \'Checked In\' "
                + "WHERE eqID = ?";
        DatabaseConnector dbCon = new DatabaseConnector();
        try (Connection con = dbCon.connectToDatabase(); PreparedStatement prepStmt = con.prepareStatement(query)) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to Database");

            // Use PreparedStatement to prevent SQL injection
            //PreparedStatement prepStmt = con.prepareStatement(query);
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
    public final String insertDataEquipmentLog(DefaultTableModel table) throws SQLException {
        String query = "INSERT INTO EquipmentLog (eqID, eqName, eqType, parentID, eqStatus) VALUES (?, ?, ?, ?, ?)";
        //int ifDublicate = 0;


        String ifDublicate = "";
       
        try (Connection con = dbCon.connectToDatabase(); PreparedStatement prepStmt = con.prepareStatement(query)) {
      
            //Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to Database");

            //for (int i = 0; i < table.getRowCount(); i++) {
            while (table.getRowCount() > 0) {
                //ifDublicate = i;
                ifDublicate = (String) table.getValueAt(0, 0);
                String equipmentID = (String) table.getValueAt(0, 0);
                String equipmentName = (String) table.getValueAt(0, 1);
                String equipmentType = (String) table.getValueAt(0, 2);
                String eqyipmentParent = (String) table.getValueAt(0, 3);

                //PreparedStatement prepStmt = con.prepareStatement(query);
                prepStmt.setString(1, equipmentID);
                prepStmt.setString(2, equipmentName);
                prepStmt.setString(3, equipmentType);
                prepStmt.setString(4, eqyipmentParent);
                prepStmt.setString(5, "Checked In");
                prepStmt.execute();
                table.removeRow(0);
            }

            System.out.println("Information added");
            con.close();
            return null;

        } catch (Exception e) {
            if (e instanceof SQLIntegrityConstraintViolationException) {
                System.out.println("Dublicate catched");
                //return (String) table.getValueAt(ifDublicate, 0);
                return ifDublicate;
            }
            e.printStackTrace();
            System.out.println("CAN\'T CONNECT TO DATABASE!!");
            e.printStackTrace();
            return "CAN\'T CONNECT TO DATABASE!!";
        }
    } //End of added by Dmitry

    public final void insertDataBookingTable(String evID, String evName, String eqID, String stID, String eqSentDateTime, String eqReturnDateTime) throws SQLException {

        String bookingQuery = "INSERT INTO Booking (evID, evName, eqID, stID ,eqSentDateTime, eqReturnDateTime) VALUES (?, ?, ?, ?, ?, ?)";

        DatabaseConnector dbCon = new DatabaseConnector();
        Timestamp timeStampSent = Timestamp.valueOf(eqSentDateTime);
        Timestamp timeStampReturn = Timestamp.valueOf(eqReturnDateTime);
        try (Connection con = dbCon.connectToDatabase(); PreparedStatement bookingStmt = con.prepareStatement(bookingQuery)) {

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

        try (Connection con = dbCon.connectToDatabase(); PreparedStatement eventStmt = con.prepareStatement(eventQuery);) {

            eventStmt.setString(1, evID);
            eventStmt.setString(2, evName);
            eventStmt.executeUpdate();
            System.out.println("Data inserted into Event tables successfully");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to insert data into Event tables");
        }
    }

    public final void updateEquipmentStatusCheckedOut(String selectedEquipmentIDs) throws SQLException {
        String query = "UPDATE equipmentlog SET eqStatus = \'Checked Out\' WHERE eqID = ?";
        DatabaseConnector dbCon = new DatabaseConnector();

        try (Connection con = dbCon.connectToDatabase(); PreparedStatement prepStmt = con.prepareStatement(query)) {

            prepStmt.setString(1, selectedEquipmentIDs);
            prepStmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Data> fetchDataFromEquipmentLog() throws SQLException {
        List<Data> dataList = new ArrayList<>();
        //DatabaseConnector dbCon = new DatabaseConnector();
        // Connection con = null;
        String query = "SELECT * FROM equipmentlog";
        DatabaseConnector dbCon = new DatabaseConnector();

        try (Connection con = dbCon.connectToDatabase(); PreparedStatement eventStmt = con.prepareStatement(query);) {
            //con = dbCon.connectToDatabase();
            // Statement stmt = con.createStatement();
            ResultSet rs = eventStmt.executeQuery(query);

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

    public Hashtable<String, Data> selestAllEquipment() throws SQLException {
        Hashtable<String, Data> toReturn = new Hashtable<>();

        String query = "SELECT * FROM EquipmentLog";

        DatabaseConnector dbCon = new DatabaseConnector();

        try (Connection con = dbCon.connectToDatabase(); PreparedStatement eventStmt = con.prepareStatement(query);) {
            // Your code for executing queries and processing results
            //Statement stmt = con.createStatement();
            ResultSet rs = eventStmt.executeQuery(query);

            while (rs.next()) {
                Data equipment = new Data(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(5), rs.getString(4));
                toReturn.put(equipment.getEquipmentID(), equipment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return toReturn;
    }

    public final boolean getLoginCredentials(String stID, String password) throws SQLException {
        DatabaseConnector dbCon = new DatabaseConnector();
        StaffRole sr = new StaffRole();
        try (Connection con = dbCon.connectToDatabase()) {
            String query = "SELECT stRole FROM staff WHERE stID = ? AND password = ?";
            try (PreparedStatement prepStm = con.prepareStatement(query)) {
                prepStm.setString(1, stID);
                prepStm.setString(2, password);
                try (ResultSet rs = prepStm.executeQuery()) {
                    if (rs.next()) {
                        // Retrieve the user role from the result set
                        String role = rs.getString("stRole");
                        // Store the role in UserSession
                        sr.setUserRole(role);
                        return true;
                    } else {
                        return false; // Invalid credentials
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public final void insertStaff(String Username, String StaffID, String password) throws SQLException {

        String query = "INSERT INTO staff (stName, stID, stRole,password) VALUES (?, ?, ?, ?)";
        DatabaseConnector dbCon = new DatabaseConnector();

        try(Connection con = dbCon.connectToDatabase();
            PreparedStatement prepStmt = con.prepareStatement(query);){
            //DatabaseConnector dbCon = new DatabaseConnector();
            //PreparedStatement prepStmt = con.prepareStatement(query);
            prepStmt.setString(1, Username);
            prepStmt.setString(2, StaffID);
            prepStmt.setString(3, "Normal");
            prepStmt.setString(4, password);
            prepStmt.execute();

            System.out.println("Information added");
            con.close();

        } catch (Exception e) {
            System.out.println("CAN\'T CONNECT TO DATABASE!! Can't add new Item");
        }
    }

    public void updateEmailSentStatus() throws SQLException {
        String updateQuery = "UPDATE Booking SET email_sent = true WHERE eqReturnDateTime >= DATE_ADD(CURDATE(), INTERVAL 1 DAY) AND TIMESTAMPDIFF(DAY, eqSentDateTime, eqReturnDateTime) > 1 AND email_sent = false";
        DatabaseConnector dbCon = new DatabaseConnector();
        try (
                Connection con = dbCon.connectToDatabase();//connects to database without needing to write the drivermanager
                 PreparedStatement prepStmt = con.prepareStatement(updateQuery)) {
            prepStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

    public List<MaintenanceData> fetchMaintenanceData() {
        List<MaintenanceData> dataList = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            // Your code for executing queries and processing results
            Statement stmt = con.createStatement();

            String oldQery = "SELECT DISTINCT Maintenance.EquipmentID, child.EquipmentName, parent.EquipmentID AS ParentID, parent.EquipmentName AS ParentName, \n"
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

    public void getEquipmentStatusReturnDate(DefaultTableModel tableModel) throws SQLException {
        String query = "SELECT eq.eqID, eq.eqName, b.eqReturnDateTime, eq.eqStatus " +
                 "FROM equipmentlog eq " +
                "JOIN booking b ON eq.eqID = b.eqID " + 
                "WHERE eq.eqStatus = 'Checked Out'";
        DatabaseConnector dbCon = new DatabaseConnector();

        try ( Connection con = dbCon.connectToDatabase()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            // loops until it reads all rows from database
            while (rs.next()) {
                // use rs.getInt and rs.getString to get data from each row
                // use String.valueOf() to convert int to a String

                // getting data for each column
                String eqID = rs.getString("eqID");
                String eqName = rs.getString("eqName");
                String eqReturnDT = String.valueOf(rs.getTimestamp("eqReturnDateTime"));
                String eqStatus = rs.getString("eqStatus");


                // An array to store data into jTable
                String tableData[] = {eqID, eqName, eqReturnDT, eqStatus};

                // Add the String arary into the jTable
                tableModel.addRow(tableData);
            }
            // Clear out ResultSet
            rs.close();

            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    

    //Dmitry modified
    public List<MaintenanceData> fetchHashtableMaintenanceSearchData(String ID, String Name, String received, String returned) throws SQLException {
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

        DatabaseConnector dbCon = new DatabaseConnector();

        try (Connection con = dbCon.connectToDatabase()) {
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

    public boolean newInsertIntoMaintenanceTable(String eqID, String description, String received) throws SQLException {
        String query = "INSERT INTO Maintenance (eqID, mntDescription, mntRecieved, mntRepairedReturned)\n"
                + "VALUES (?, ?, ?, ?);";
//Checked In
//Checked out
        String updateEquipmentStatus = "UPDATE EquipmentLog "
                + "SET eqStatus = 'In Maintenance' "
                + "WHERE eqID = ?";
        DatabaseConnector dbCon = new DatabaseConnector();

        try (Connection con = dbCon.connectToDatabase(); PreparedStatement prepStmt = con.prepareStatement(query);) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connected to Database");

            Statement stmt = con.createStatement();

            PreparedStatement findEqStatus = con.prepareStatement(updateEquipmentStatus);
            findEqStatus.setString(1, eqID);
            findEqStatus.execute();

            //PreparedStatement prepStmt = con.prepareStatement(query);
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

    public Hashtable<String, Data> fetchHashtableMaintenanceData() throws SQLException {
        Hashtable<String, Data> dataList = new Hashtable<>();

        DatabaseConnector dbCon = new DatabaseConnector();

        try (Connection con = dbCon.connectToDatabase()) {
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

    public boolean equipmentRetunMaintenance(MaintenanceData insert) throws SQLException {
        String query = "UPDATE Maintenance "
                + "SET mntRepairedReturned = ? WHERE eqID = ? AND mntDescription = ? AND "
                + "mntRecieved = ?";

        String updateEquipmentStatus = "UPDATE EquipmentLog "
                + "SET eqStatus = 'Checked In' "
                + "WHERE eqID = ?";

        System.out.println("\nBEFORE ADD TO DATABASE RETURN_MAINT:  " + insert.toString());
        DatabaseConnector dbCon = new DatabaseConnector();

        try (Connection con = dbCon.connectToDatabase(); PreparedStatement prepStmt = con.prepareStatement(query);) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to Database");

            Statement stmt = con.createStatement();
            PreparedStatement findEqStatus = con.prepareStatement(updateEquipmentStatus);
            findEqStatus.setString(1, insert.getEqID());
            findEqStatus.execute();

            //PreparedStatement prepStmt = con.prepareStatement(query);
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

    public Hashtable<String, MaintenanceData> fetchMaintenanceUnreturned() throws SQLException {
        Hashtable<String, MaintenanceData> toReturn = new Hashtable<>();

        String query = "SELECT DISTINCT Maintenance.eqID, child.eqName, parent.eqID AS ParentID, parent.eqName AS ParentName, \n"
                + "Maintenance.mntDescription, Maintenance.mntRecieved, Maintenance.mntRepairedReturned\n"
                + "From Maintenance LEFT JOIN EquipmentLog AS child ON Maintenance.eqID = child.eqID\n"
                + "LEFT JOIN EquipmentLog AS parent ON child.ParentID = parent.eqID\n"
                + "WHERE Maintenance.mntRepairedReturned IS null\n"
                + "ORDER BY Maintenance.mntRecieved DESC;";

        DatabaseConnector dbCon = new DatabaseConnector();

        try (Connection con = dbCon.connectToDatabase()) {
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


    public void displayStaffTable(DefaultTableModel tableModel, Map<Integer, Map<String, String>> originalIDs) throws SQLException {
        String query = "SELECT * FROM staff";
        try ( Connection con = dbCon.connectToDatabase();  Statement stmt = con.createStatement();  ResultSet rs = stmt.executeQuery(query)) {

            // Loop through all rows from the database
            while (rs.next()) {
                // Get data for each column
                String stID = rs.getString("stID");
                String stName = rs.getString("stName");
                String stRole = rs.getString("stRole");
                String password = rs.getString("password");

                // An array to store data into jTable
                String[] tableData = {stID, stName, stRole, password};

                // Add the String array into the jTable
                tableModel.addRow(tableData);

                // Store the original data in the map
                Map<String, String> rowData = new HashMap<>();
                rowData.put("stID", stID);
                rowData.put("stName", stName);
                rowData.put("stRole", stRole);
                rowData.put("password", password);
                originalIDs.put(tableModel.getRowCount() - 1, rowData); // Use row index as the key
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    
    public void updateStaffTable(DefaultTableModel tableModel, Map<Integer, Map<String, String>> originalIDs) throws SQLException {

        try (Connection con = dbCon.connectToDatabase()) {
            String query = "UPDATE staff SET stID = ?, stName = ?, stRole = ?, password = ? WHERE stID = ?";
            try ( PreparedStatement pstmt = con.prepareStatement(query)) {
                for (int i = 0; i < tableModel.getRowCount(); i++) {
                    String stID = (String) tableModel.getValueAt(i, 0);
                    String stName = (String) tableModel.getValueAt(i, 1);
                    String stRole = (String) tableModel.getValueAt(i, 2);
                    String password = (String) tableModel.getValueAt(i, 3);
                    String ogIDs = originalIDs.get(i).get("stID");
                    
                    pstmt.setString(1, stID);
                    pstmt.setString(2, stName);
                    pstmt.setString(3, stRole);
                    pstmt.setString(4, password);
                    pstmt.setString(5, ogIDs);

                    // Log the update statement for debugging
                    System.out.println("Updating: ID=" + stID + ", Name=" + stName + ", Role=" + stRole + ", Password=" + password);

                    pstmt.addBatch(); // Add the update statement to the batch
                }
                int[] updateCounts = pstmt.executeBatch(); // Execute all updates in the batch

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    public void deleteStaffFromTable(DefaultTableModel tableModel, String rowDelete) throws SQLException {
        String query = "DELETE FROM staff WHERE stID = ?";
        try (Connection con = dbCon.connectToDatabase();
             PreparedStatement preparedStatement = con.prepareStatement(query)) {
            // Set the value for the parameter placeholder
            preparedStatement.setString(1, rowDelete);

            // Execute the DELETE query
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);
        }
    }
    
    public void moveToBin(DefaultTableModel model, String rowMoveToBin) throws SQLException {
        try (Connection con = dbCon.connectToDatabase();) {
            String insertQuery = "INSERT INTO trash (evID, evName, eqID, stID, eqSentDateTime, eqReturnDateTime, emailSent) " +
                                 "SELECT evID, evName, eqID, stID, eqSentDateTime, eqReturnDateTime, email_sent " +
                                 "FROM Booking WHERE eqID = ?";
            try (PreparedStatement insertStmt = con.prepareStatement(insertQuery);) {
                insertStmt.setString(1, rowMoveToBin);
                int rowsInserted = insertStmt.executeUpdate();
                JOptionPane.showMessageDialog(null, rowsInserted + " entries moved to trash successfully.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error moving entries to trash: " + ex.getMessage());
        }
    }
    

    public void deleteFromBooking(DefaultTableModel model, int[] selectedRows) throws SQLException {
        try (Connection con = dbCon.connectToDatabase()) {
            for (int selectedRow : selectedRows) {
                if (selectedRow >= 0) { // Adjusted to ensure positive indexing starts from 1
                    String rowToMoveToBinEv = (String) model.getValueAt(selectedRow, 0);
                    String rowToMoveToBinEq = (String) model.getValueAt(selectedRow, 1);

                    // Assuming evID and eqID are both Strings; adjust types as necessary
                    try (PreparedStatement prepStmt = con.prepareStatement("DELETE FROM Booking WHERE evID =? AND eqID =?")) {
                        prepStmt.setString(1, rowToMoveToBinEv);
                        prepStmt.setString(2, rowToMoveToBinEq);
                        prepStmt.executeUpdate();
                    }
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Error deleting booking entries", ex);
        }
    }
    

}
