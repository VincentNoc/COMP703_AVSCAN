/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package playground;

import Database.DatabaseUtils;
import java.sql.SQLException;

/**
 *
 * @author dmitr
 */
public class ToTest {
    public static void main(String[] args) throws SQLException {
    }
    
    private static void checkDBconnection() throws SQLException{
        new DatabaseUtils();
    }
}
