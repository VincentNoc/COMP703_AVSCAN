/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.avscan;


import Database.Data;
import Database.DatabaseUtils;
import Database.HistoryData;
import excel.ExcelWriter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import multi.use.frames.SmallErrorMessage;

/**
 *
 * @author vince-kong, Misako Morihana
 */
public class History extends javax.swing.JFrame {
    /**
     * Creates new form History
     */
    public History() {
        initComponents();
        outPutDataToTable();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        equipmentIDInput = new javax.swing.JTextField();
        parentIDInput = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        equipmentNameLabel = new javax.swing.JLabel();
        equipmentIDLabel = new javax.swing.JLabel();
        parentIDLabel = new javax.swing.JLabel();
        equipmentNameInput = new javax.swing.JTextField();
        eventIDInput = new javax.swing.JTextField();
        eventIDLabel = new javax.swing.JLabel();
        jTxtDate = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        homeButton = new javax.swing.JButton();
        ExportToCsvButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        equipmentIDInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                equipmentIDInputKeyPressed(evt);
            }
        });

        parentIDInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                parentIDInputKeyPressed(evt);
            }
        });

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        equipmentNameLabel.setText("Equipment Name");

        equipmentIDLabel.setText("Equipment ID");

        parentIDLabel.setText("Parent ID");

        equipmentNameInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equipmentNameInputActionPerformed(evt);
            }
        });
        equipmentNameInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                equipmentNameInputKeyPressed(evt);
            }
        });

        eventIDInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                eventIDInputKeyPressed(evt);
            }
        });

        eventIDLabel.setText("Event ID");

        jTxtDate.setToolTipText("");

        jLabel1.setText("Date");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTxtDate, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                            .addComponent(equipmentIDLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(equipmentIDInput))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(equipmentNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(equipmentNameLabel))
                                .addGap(98, 98, 98)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(eventIDInput, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(eventIDLabel))
                                .addGap(112, 112, 112)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(parentIDLabel)
                                    .addComponent(parentIDInput, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(searchButton, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(searchButton)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(eventIDLabel)
                            .addComponent(parentIDLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(eventIDInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(parentIDInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(equipmentNameLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(equipmentIDLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(equipmentNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(equipmentIDInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTxtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        homeButton.setText("Home");
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });

        ExportToCsvButton.setText("Export to .csv File");
        ExportToCsvButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExportToCsvButtonActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Event ID", "Equipment ID", "Equipment Name", "Parent ID", "Parent Name", "Return Date", "Staff ID", "Status"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ExportToCsvButton, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ExportToCsvButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

 public void outPutDataToTable() {
        // Database connection
        try {
            // Opening connection
            // for forName, goto Services>Databases>Drivers>right click MySQL>customize and copy what it says on the Driver Class.
            Class.forName("com.mysql.cj.jdbc.Driver");
            // for getConnection, use (Database name, "root", SQL password)
            //Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "AUT4events_");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/avscan", "root", "AUT4events_");
            
            // Getting Data from SQL Database
            Statement statement = connection.createStatement();
            
            // Writing out SQL query into String data
            String sqlQuery =
                    "SELECT ev.evID, eq.eqID, eq.eqName, p.parentID, p.eqName, b.eqReturnDateTime, b.stID, eq.eqStatus "
                    + "FROM Event ev, Equipmentlog eq, Equipmentlog p, Booking b, Staff s "
                    + "WHERE eq.eqID = b.eqID "
                    + "AND eq.eqID = p.eqID "
                    + "AND b.stID = s.stID "
                    + "AND b.evID = ev.evID ";
            
            ResultSet rs = statement.executeQuery(sqlQuery);
            
            // loops until it reads all rows from database
            while (rs.next()){
                // use rs.getInt and rs.getString to get data from each row
                // use String.valueOf() to convert int to a String
                
                // getting data for each column
                String evID = rs.getString("evID");
                String eqID = rs.getString("eqID");
                String eqName = rs.getString("eqName");
                String eqPID = rs.getString("parentID");
                String eqPName = rs.getString("p.eqName");
                String eqReturnDT = String.valueOf(rs.getTimestamp("eqReturnDateTime"));
                String stID = rs.getString("stID");
                String eqStatus = rs.getString("eqStatus");
                
                // An array to store data into jTable
                String tableData[] = {evID, eqID, eqName, eqPID,eqPName, eqReturnDT, stID, eqStatus};
                DefaultTableModel tableModel = (DefaultTableModel)jTable1.getModel();
                
                // Add the String arary into the jTable
                tableModel.addRow(tableData);
            }
            // Clear out ResultSet
            rs.close();
            
            connection.close();
        }catch(ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    // For searching data in table (search feature)
    // Takes in an array of any typed words in all four text fields
    public void outPutDataToTable(String[] searchWords){
        
        // Database connection
        try {
            // Opening connection
            // for forName, goto Services>Databases>Drivers>right click MySQL>customize and copy what it says on the Driver Class.
            Class.forName("com.mysql.cj.jdbc.Driver");
            // for getConnection, use (Database name, "root", SQL password)
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/avscan", "root", "AUT4events_");
            //Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "AUT4events_");
            
            // Clearing the jTable before adding the filtered data
            DefaultTableModel clearTable = (DefaultTableModel)jTable1.getModel();
            clearTable.setRowCount(0);
            
            // Getting Data from SQL Database
            Statement statement = connection.createStatement();
            
            //In default(no text writen in textfield)
            // Using SQL query
            String sqlQuery =
                    "SELECT ev.evID, eq.eqID, eq.eqName, p.parentID, p.eqName, b.eqReturnDateTime, b.stID, eq.eqStatus "
                    + "FROM Event ev, Equipmentlog eq, Equipmentlog p, Booking b, Staff s "
                    + "WHERE eq.eqID = b.eqID "
                    + "AND eq.eqID = p.eqID "
                    + "AND b.stID = s.stID "
                    + "AND b.evID = ev.evID "
                    + "AND b.eqReturnDateTime = eqReturnDateTime";
            
            // If Equipment Name text field is not empty
            if (!searchWords[0].equals("")){
                sqlQuery += " AND eq.eqName LIKE \'%" + searchWords[0] + "%\'";
            }
            // If Equipment ID text field is not empty
            if (!searchWords[1].equals("")) {
                sqlQuery += " AND eq.eqID LIKE \'%" + searchWords[1] + "%\'";
            }
            // If Parent ID text field is not empty
            if (!searchWords[2].equals("")) {
                sqlQuery += " AND p.parentID LIKE \'%" + searchWords[2] + "%\'";
            }
            // If Event ID text field is not empty
            if (!searchWords[3].equals("")) {
                sqlQuery += " AND ev.evID LIKE \'%" + searchWords[3] + "%\'";
            }
            
            if (searchWords[4] != null && !searchWords[4].isEmpty()) {
                sqlQuery += " AND b.eqReturnDateTime LIKE \'%" + searchWords[4] + "%\'";
            }
            
            ResultSet rs = statement.executeQuery(sqlQuery);
            
            // loops until it reads all rows from database
            while (rs.next()){
                // use rs.getInt and rs.getString to get data from each row
                // use String.valueOf() to convert int to a String               
                // getting data for each column
                String evID = rs.getString("evID");
                String eqID = rs.getString("eqID");
                String eqName = rs.getString("eqName");
                String eqPID = rs.getString("parentID");
                String eqPName = rs.getString("p.eqName");
                String eqReturnDT = String.valueOf(rs.getTimestamp("eqReturnDateTime"));
                String stID = rs.getString("stID");
                String eqStatus = rs.getString("eqStatus");
                
                // An array to store data into jTable
                String tableData[] = {evID, eqID, eqName, eqPID,eqPName, eqReturnDT, stID, eqStatus};
                DefaultTableModel tableModel = (DefaultTableModel)jTable1.getModel();
                
                // Add the String arary into the jTable
                tableModel.addRow(tableData);
            }
            
            // Clear out ResultSet
            rs.close();
            
            connection.close();
        }catch(ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
        MainMenu mainMenu = new MainMenu();
        mainMenu.setVisible(true);
    }//GEN-LAST:event_homeButtonActionPerformed

    private void ExportToCsvButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExportToCsvButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow[] = jTable1.getSelectedRows();
        //System.out.println(selectedRow);
        if (selectedRow != null) {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            ExcelWriter ex = new ExcelWriter();
            for (int i = 0; i < selectedRow.length; i++) {
                String evID         =     (String) model.getValueAt(selectedRow[i], 0);
                String equipmentID  =     (String) model.getValueAt(selectedRow[i], 1);
                String euipmentName =     (String) model.getValueAt(selectedRow[i], 2);
                String parentID     =     (String) model.getValueAt(selectedRow[i], 3);
                String parentName   =     (String) model.getValueAt(selectedRow[i], 4);
                String returnDate   =      String.valueOf(model.getValueAt(selectedRow[i], 5));
                String staffID      =     (String) model.getValueAt(selectedRow[i], 6);
                String status       =     (String)model.getValueAt(selectedRow[i], 7);
                
                HistoryData temp = new HistoryData(evID, equipmentID, euipmentName, parentID, parentName, returnDate, staffID, status);
                ex.addToExcel(temp);
            }
            ex.createAndWriteHistory();
        }else{
            new SmallErrorMessage("Please select at least one row.",this).setVisible(true);
        }
    }//GEN-LAST:event_ExportToCsvButtonActionPerformed

    private void equipmentNameInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_equipmentNameInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_equipmentNameInputActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // Create an array which will contain text from all four search text fields
        String dateReturn = formatDate(jTxtDate.getText());
        String[] searchWords = {equipmentNameInput.getText(), equipmentIDInput.getText(), parentIDInput.getText(), eventIDInput.getText(), dateReturn};
        outPutDataToTable(searchWords);
    }//GEN-LAST:event_searchButtonActionPerformed

    private void equipmentNameInputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_equipmentNameInputKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            searchButton.doClick();
        }
    }//GEN-LAST:event_equipmentNameInputKeyPressed

    private void equipmentIDInputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_equipmentIDInputKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            searchButton.doClick();
        }
    }//GEN-LAST:event_equipmentIDInputKeyPressed

    private void parentIDInputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_parentIDInputKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            searchButton.doClick();
        }
    }//GEN-LAST:event_parentIDInputKeyPressed

    private void eventIDInputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_eventIDInputKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            searchButton.doClick();
        }
    }//GEN-LAST:event_eventIDInputKeyPressed
    
    //takes the date from the calendar and changes the format to the preffered format
    private String formatDate(String date) {
        if(date.isEmpty()){
            return null;
        }
        /*originalDateFormat is created so that we can parse String Date as a Date object, which can later be formatted to yyyy-MM-dd format
        */
        SimpleDateFormat originalDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        try {
            // Parse the date string into a Date object
            Date formattedDate =  originalDateFormat.parse(date);
            String formattedDateString = dateFormat.format(formattedDate);
            
            return formattedDateString;
        } catch (ParseException e) {
            // Handle any parsing errors
            e.printStackTrace();
            return null; // or throw an exception or return a default value
        }
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(History.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(History.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(History.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(History.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new History().setVisible(true);
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ExportToCsvButton;
    private javax.swing.JTextField equipmentIDInput;
    private javax.swing.JLabel equipmentIDLabel;
    private javax.swing.JTextField equipmentNameInput;
    private javax.swing.JLabel equipmentNameLabel;
    private javax.swing.JTextField eventIDInput;
    private javax.swing.JLabel eventIDLabel;
    private javax.swing.JButton homeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTxtDate;
    private javax.swing.JTextField parentIDInput;
    private javax.swing.JLabel parentIDLabel;
    private javax.swing.JButton searchButton;
    // End of variables declaration//GEN-END:variables
}
