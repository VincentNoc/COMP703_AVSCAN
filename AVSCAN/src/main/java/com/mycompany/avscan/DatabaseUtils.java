/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avscan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author vince-kong
 */
public class DatabaseUtils {
    //String equipmentID = jEquipmentID.getText();
    //String equipmentName = jEquipmentName.getText(); 
    //String equipmentType = jEpuipmentType.getText(); 

    public static void insertData(Connection connection, String EquipmentID, String EquipmentName, String EquipmentType){
//        Connection connection =null;
        String query = "INSERT INTO EquipmentLog (EquipmentID, EquipmentName, Equipment Type) VALUES (?, ?, ?)";

        try(PreparedStatement preparedStatement = connection.preparedStatement(query)){
           preparedStatement.setString(equipmentID);
            
        }catch(SQLException ex){
            ex.printStackTrace();
           
    }
}
