/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avscan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author vince-kong
 */
public class DatabaseConnector {
  //these three could potentially change depending on how you've set up your DB. 
  private static final String URL = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL";
  private static final String USER = "root";
  private static final String PASSWORD = "AUT4events_";

public static Connection connectToDatabase() throws SQLException {
    try {
        // Optionally load the JDBC driver (not always required in modern JDBC versions)
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish the database connection
        Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
        System.out.println("Connected to Database");

        // Return the established connection
        return con;
    } catch (ClassNotFoundException e) {
        // Handle the ClassNotFoundException (e.g., log the error)
        System.err.println("JDBC driver not found: " + e.getMessage());
        e.printStackTrace();

        // Rethrow it as a runtime exception or another suitable exception
        throw new RuntimeException("JDBC driver not found", e);
    } catch (SQLException e) {
        System.err.println("Error has occurred, could not connect to database.");
        e.printStackTrace();

        // If an exception occurs, you might want to rethrow it or handle it accordingly
        throw new SQLException("Failed to connect to the database.", e);
    }
}

  //This main was just to test out whether the connection to the database actually works. 
  //    public static void main(String args[]) {
  //        /* Set the Nimbus look and feel */
  //        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
  //        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
  //         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
  //         */
  //        try {
  //            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
  //                if ("Nimbus".equals(info.getName())) {
  //                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
  //                    break;
  //                }
  //            }
  //        } catch (ClassNotFoundException ex) {
  //            java.util.logging.Logger.getLogger(CheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  //        } catch (InstantiationException ex) {
  //            java.util.logging.Logger.getLogger(CheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  //        } catch (IllegalAccessException ex) {
  //            java.util.logging.Logger.getLogger(CheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  //        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
  //            java.util.logging.Logger.getLogger(CheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  //        }
  //        //</editor-fold>
  //
  //        
  //        System.out.println("connecting to database");
  //        /* Create and display the form */
  //       try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
  //          Class.forName("com.mysql.cj.jdbc.Driver");
  ////          con = DriverManager.getConnection(URL, USER, PASSWORD);
  //          System.out.println("Connected to Database");
  //      } catch (Exception e) {
  //          System.err.println("Error has occurred, could not connect to database.");
  //          e.printStackTrace();
  //      }
  //    }

}