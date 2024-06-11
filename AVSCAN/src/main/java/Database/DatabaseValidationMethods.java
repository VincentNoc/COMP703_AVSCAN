/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jazzy-wazzy
 */
public class DatabaseValidationMethods {
    
    public boolean doesEquipmentExists(String equipmentID) throws SQLException {
        String query = "SELECT COUNT(*) FROM equipmentlog WHERE eqID = ?";
        DatabaseConnector dbCon = new DatabaseConnector();

        try (Connection conn = dbCon.connectToDatabase(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, equipmentID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        }
        return false;
    }

    public boolean isEquipmentCheckedOut(String equipmentID) throws SQLException {
        String query = "SELECT eqStatus FROM equipmentlog WHERE eqID = ?";
        DatabaseConnector dbCon = new DatabaseConnector();

        try (Connection con = dbCon.connectToDatabase(); PreparedStatement prepStmt = con.prepareStatement(query)) {
            prepStmt.setString(1, equipmentID);
            ResultSet rs = prepStmt.executeQuery();
            if (rs.next()) {
                return "Checked Out".equals(rs.getString("eqStatus"));
            }
        }
        return false;
    }
    
    public boolean doesEventExist(String evID) throws SQLException{
        String query = "SELECT * FROM event WHERE evID = ?";
        DatabaseConnector dbCon = new DatabaseConnector();
        
        try(Connection con = dbCon.connectToDatabase(); PreparedStatement prepStmt = con.prepareStatement(query)) {
            prepStmt.setString(1, evID);
            ResultSet rs = prepStmt.executeQuery();
            if(rs.next()){
                return evID.equals(rs.getString("evID"));
            }
        }
        return false;
    }
    
    public boolean isEquipmentReparing(String eqID) throws SQLException{
        String query = "SELECT * FROM equipmentlog WHERE eqStatus = 'In Maintenance' AND eqID = ?";
        DatabaseConnector dbCon = new DatabaseConnector();
        
        try(Connection con = dbCon.connectToDatabase(); PreparedStatement prepStmt = con.prepareStatement(query)){
            prepStmt.setString(1, eqID);
            ResultSet rs = prepStmt.executeQuery();
            return rs.next();
        }
    }
    
}
