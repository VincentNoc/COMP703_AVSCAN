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
    public static void insertData(String EquipmentID, String EquipmentName, String EquipmentType){
        Connection connection =null;
        try{
            connection = DatabaseConnector.getConnection();
            
            String query = "INSERT INTO EquipmentLog (EquipmentID, EquipmentName, Equipment Type)";
        }catch{
            
        }
            

    }
}
