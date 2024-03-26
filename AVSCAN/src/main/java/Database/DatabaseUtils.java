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
}
