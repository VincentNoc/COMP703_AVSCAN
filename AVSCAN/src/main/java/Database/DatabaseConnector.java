/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author vince-kong
 */
public class DatabaseConnector {
    //these three could potentially change depending on how you've set up your DB. 

    private static final String URL = "jdbc:mysql://localhost:3306/avscans?zeroDateTimeBehavior=CONVERT_TO_NULL";
//    private static final String URL = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private static final String USER = "root";
    private static final String PASSWORD = "AUT4events_";

    public DatabaseConnector() throws SQLException {
        connectToDatabase();
    }

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
}
