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
import javax.swing.UIManager;


/**
 *
 * @author vince-kong
 */
public class CheckOut extends javax.swing.JFrame {
 

    /**
     * Creates new form CheckOut
     */
    public CheckOut() {
        initComponents();
        outPutDataToTable();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JEventID = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jEventName = new javax.swing.JTextField();
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

        jLabel1.setText("AUT EVENTS");

        jLabel2.setText("Event ID:");
        jLabel2.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N

        jTable1.setBorder(new javax.swing.border.MatteBorder(null));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "ID"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel3.setText("Date/Time Issued:");
        jLabel3.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N

        jLabel4.setText("Return Date/Time:");
        jLabel4.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N

        jLabel5.setText("Event Name:");
        jLabel5.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(JHomeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(39, 39, 39)
                                .addComponent(JEventID, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(jEventName, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(208, 208, 208)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTxtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTxtReturnDate, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTimeIssued, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                            .addComponent(jTimeReturn))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(412, 412, 412)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(114, 114, 114))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTxtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTimeIssued, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(JEventID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTxtReturnDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTimeReturn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jEventName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56)))
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JHomeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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
            
            model.setColumnIdentifiers(new Object[]{"Equipment ID", "Equipment Name"});

            for (Data data : dataList) {
                // Add each row of data to the JTable
                model.addRow(new Object[]{data.getEquipmentID(), data.getEquipmentName()});
            }

            // Set the table model
            jTable1.setModel(model);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //String formatDateTime to get time from spinner and date from calendar component  in the format that works with TimeStamp
    private String formatDateTime(Date time, String date) {
        //wanted formats for the mysql table TimeStamp column
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        try {
            // Parse the date string into a Date object
            Date formattedDate = dateFormat.parse(date);
//            System.out.println("this is the sysout"+ formattedDate);
//            String forDate = (String) formattedDate;
            // Format the time
            String formattedDateString = dateFormat.format(formattedDate);
                        System.out.println("this is the sysout"+ formattedDateString);

            String formattedTime = timeFormat.format(time);

            // Return the concatenated date and time strings
            return formattedDateString + " " + formattedTime;
        } catch (ParseException e) {
            // Handle any parsing errors
            e.printStackTrace();
            return null; // or throw an exception or return a default value
        }
    }

    //String method formatDateTime to get time from spinner and date from calendar component in the format that works with TimeStamp
//    private String getFormattedDateTime(Date date, String time) {
//        SimpleDateFormat formattedDate = new SimpleDateFormat("yyyy-MM-dd");
//        SimpleDateFormat formattedTime = new SimpleDateFormat("HH:mm:ss");
//        return formattedTime.format(date) + " " + time;
//    }
    
        
    private void JHomeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JHomeButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
        MainMenu mainmenu = new MainMenu();
        mainmenu.setVisible(true);
    }//GEN-LAST:event_JHomeButtonActionPerformed

    private void jCheckOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckOutButtonActionPerformed
        // TODO add your handling code here:
        String evID = JEventID.getText();
        String evName = jEventName.getText();
        String dateIssue = jTxtDate.getText();
        String dateReturn = jTxtReturnDate.getText();
        //formatting date and time. 
        String dateTimeSent = formatDateTime((Date) jTimeIssued.getValue(), dateIssue);
        String dateTimeReturn = formatDateTime((Date) jTimeReturn.getValue(), dateReturn);
    
        int selectedRow = jTable1.getSelectedRow();
        
        
        System.out.println(dateTimeSent);
        
        System.out.println(dateIssue);
//        System.out.println(dateReturn);

        System.out.println(dateTimeReturn);
        try{
            DatabaseUtils dbUtils = new DatabaseUtils();
              // Check if a row is selected
                if (selectedRow != -1) {
                    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                    Object selectedValue = jTable1.getValueAt(selectedRow, 0);
                    String selectedEqID = (String)selectedValue;
                    //this will be changed latter on. 
//                   dbUtils.insertDataEventTable(evID, selectedEqID, evName, "evDateTime", evCheckOutStaff, dateTimeSent, dateTimeReturn);
                    dbUtils.insertDataEventTable(evID, selectedEqID, evName, "2024-10-03 13:19:00", "8", dateTimeSent, dateTimeReturn);
        //            System.out.println(selectedValue);
                }else{
                    JOptionPane.showMessageDialog(this,"Error has Occurred, check your connection to the database", "Error", JOptionPane.ERROR_MESSAGE);
                    System.out.println("Must select an Equipment");
                }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this,"Error has Occurred, check your connection to the database", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
      
    }//GEN-LAST:event_jCheckOutButtonActionPerformed
    

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
    private javax.swing.JTextField JEventID;
    private javax.swing.JButton JHomeButton;
    private com.raven.datechooser.DateChooser dateChooser1;
    private com.raven.datechooser.DateChooser dateChooser2;
    private javax.swing.JButton jCheckOutButton;
    private javax.swing.JTextField jEventName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JSpinner jTimeIssued;
    private javax.swing.JSpinner jTimeReturn;
    private javax.swing.JTextField jTxtDate;
    private javax.swing.JTextField jTxtReturnDate;
    // End of variables declaration//GEN-END:variables
}
