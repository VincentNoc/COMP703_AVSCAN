/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.avscan;

import Database.Validations.NonEditableTableModel;
import Database.Data;
import Database.DatabaseUtils;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;
import javax.swing.UIManager;

/**
 *
 * @author vince-kong
 */
public class CheckOut extends javax.swing.JFrame {

    private Set<String> enteredIDs;

    /**
     * Creates new form CheckOut
     */
    public CheckOut() {
        initComponents();
//        outPutDataToTable();
        this.setLocationRelativeTo(null);
        enteredIDs = new HashSet<>();
//        BackgroundColour();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooser2 = new com.raven.datechooser.DateChooser();
        dateChooser1 = new com.raven.datechooser.DateChooser();
        JHomeButton = new javax.swing.JButton();
        jCheckOutButton = new javax.swing.JButton();
        JEventName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jEventID = new javax.swing.JTextField();
        jTxtDate = new javax.swing.JTextField();
        jTxtReturnDate = new javax.swing.JTextField();
        Date d = new Date();
        SpinnerDateModel timeIssue =
        new SpinnerDateModel(d, null, null, Calendar.HOUR_OF_DAY);
        jTimeIssued = new javax.swing.JSpinner(timeIssue);
        // Code adding the component to the parent container - not shown here
        Date dReturn = new Date();
        SpinnerDateModel timeReturn =
        new SpinnerDateModel(dReturn, null, null, Calendar.HOUR_OF_DAY);
        jTimeReturn = new javax.swing.JSpinner(timeReturn);
        jLabel6 = new javax.swing.JLabel();
        jEquipmentID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jAddToTable = new javax.swing.JButton();

        dateChooser2.setTextRefernce(jTxtReturnDate);

        dateChooser1.setTextRefernce(jTxtDate);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JHomeButton.setText("Home");
        JHomeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JHomeButtonActionPerformed(evt);
            }
        });

        jCheckOutButton.setText("Checkout");
        jCheckOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckOutButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jLabel3.setText("Date/Time Issued:");

        jLabel4.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jLabel4.setText("Return Date/Time:");

        jLabel5.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jLabel5.setText("Event Name:");

        jTxtDate.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jTxtReturnDate.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        JSpinner.DateEditor de = new JSpinner.DateEditor(jTimeIssued, "HH:mm");
        jTimeIssued.setEditor(de);
        jTimeIssued.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTimeIssued.setDoubleBuffered(true);

        JSpinner.DateEditor dateEdit = new JSpinner.DateEditor(jTimeReturn, "HH:mm");
        jTimeReturn.setEditor(dateEdit);
        jTimeReturn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jTimeReturn.setDoubleBuffered(true);

        jLabel6.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jLabel6.setText("Event ID:");

        jLabel2.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jLabel2.setText("Equipment ID");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Equipment ID"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jAddToTable.setText("+");
        jAddToTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAddToTableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jEquipmentID, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jAddToTable))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JHomeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCheckOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTxtReturnDate, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTxtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTimeIssued, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTimeReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addGap(78, 78, 78)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(JEventName, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                    .addComponent(jEventID))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jEquipmentID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jAddToTable))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jEventID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(JEventName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTxtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTimeIssued, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTxtReturnDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTimeReturn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JHomeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void outPutDataToTable() {
        try {
            //
            DatabaseUtils databaseUtils = new DatabaseUtils();

            // Fetches data from the database
            List<Data> dataList = databaseUtils.fetchDataFromEquipmentLog();

            //calls object of noneditabletable model to make the jtable noneditable
            NonEditableTableModel model = new NonEditableTableModel();

            model.setColumnIdentifiers(new Object[]{"EquipmentID", "EquipmentName"});

            for (Data data : dataList) {
                // Add each row of data to the JTable
                model.addRow(new Object[]{data.getEquipmentID(), data.getEquipmentName()});
            }

            // Set the table model
            jTable2.setModel(model);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //String formatDateTime to get time from spinner and date from calendar component  in the format that works with TimeStamp
    private String formatDateTime(Date time, String date) {
        /*originalDateFormat is created so that we can parse String Date as a Date object, which can later be formatted to yyyy-MM-dd format
         */
        SimpleDateFormat originalDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        try {
            // Parse the date string into a Date object
            Date formattedDate = originalDateFormat.parse(date);
            String formattedDateString = dateFormat.format(formattedDate);
            String formattedTime = timeFormat.format(time);

            return formattedDateString + " " + formattedTime;
        } catch (ParseException e) {
            // Handle any parsing errors
            e.printStackTrace();
            return null; // or throw an exception or return a default value
        }
    }

    private void JHomeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JHomeButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
        MainMenu mainmenu = new MainMenu();
        mainmenu.setVisible(true);
    }//GEN-LAST:event_JHomeButtonActionPerformed

    private void jCheckOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckOutButtonActionPerformed
        // TODO add your handling code here:

//             
//        for (int i = 0; i < model.getRowCount(); i++) {
//            String equipmentID = model.getValueAt(i, 0).toString();
//            String equipmentName = model.getValueAt(i, 1).toString();
//            String equipmentType = model.getValueAt(i, 2).toString();
//
//            try {
//                DatabaseUtils dbUtil = new DatabaseUtils();
//                dbUtil.insertDataEquipmentLog(equipmentID, equipmentName, equipmentType);
//                
//            } catch (SQLException ex) {
//                // Handle the exception (e.g., display error message)
//                ex.printStackTrace();
//                JOptionPane.showMessageDialog(this, "Error adding data to database: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//            }
//        }
//        model.setRowCount(0); 
        DefaultTableModel tableModel = (DefaultTableModel) jTable2.getModel();

        String evID = jEventID.getText();
        String evName = JEventName.getText();
        String dateIssue = jTxtDate.getText();
        String dateReturn = jTxtReturnDate.getText();

        //formatting date and time. 
        String dateTimeSent = formatDateTime((Date) jTimeIssued.getValue(), dateIssue);
        String dateTimeReturn = formatDateTime((Date) jTimeReturn.getValue(), dateReturn);

        for (int i = 0; i < tableModel.getRowCount(); i++) {
            String equipmentID = tableModel.getValueAt(i, 0).toString();

            try {
                DatabaseUtils dbUtils = new DatabaseUtils();
                // Check if a row is selected

                //this will be changed latter on. 
//                   dbUtils.insertDataEventTable(evID, selectedEqID, evName, "evDateTime", evCheckOutStaff, dateTimeSent, dateTimeReturn);
                dbUtils.insertDataEventTable(evID, evName, equipmentID, "01", dateTimeSent, dateTimeReturn);
                dbUtils.updateEquipmentStatus(equipmentID);
//            System.out.println(selectedValue);

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error has Occurred, check your connection to the database", "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jCheckOutButtonActionPerformed

    private void jAddToTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAddToTableActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        String equipmentID = jEquipmentID.getText();

        if (!enteredIDs.contains(equipmentID)) {
            model.addRow(new Object[]{equipmentID});
            enteredIDs.add(equipmentID);
            // Optionally, clear the text fields after adding
            jEquipmentID.setText("");

        } else {
            JOptionPane.showMessageDialog(null, "Duplicate ID found in the Table, please ensure there are now duplicates.");
        }
    }//GEN-LAST:event_jAddToTableActionPerformed

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
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CheckOut().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JEventName;
    private javax.swing.JButton JHomeButton;
    private com.raven.datechooser.DateChooser dateChooser1;
    private com.raven.datechooser.DateChooser dateChooser2;
    private javax.swing.JButton jAddToTable;
    private javax.swing.JButton jCheckOutButton;
    private javax.swing.JTextField jEquipmentID;
    private javax.swing.JTextField jEventID;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JSpinner jTimeIssued;
    private javax.swing.JSpinner jTimeReturn;
    private javax.swing.JTextField jTxtDate;
    private javax.swing.JTextField jTxtReturnDate;
    // End of variables declaration//GEN-END:variables

}
