
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.avscan;

import Database.Validations.NonEditableTableModel;
import Database.Data;
import Database.DatabaseUtils;
import com.mycompany.avscan.Login_Signup_pages.StaffIDTracker;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import java.text.ParseException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.basic.BasicComboBoxEditor;

/**
 *
 * @author vince-kong
 */
public class CheckOut extends javax.swing.JFrame {

    private Set<String> enteredIDs;
    private Map<String, Integer> enteredIDsToRowMap;
    private Timer barcodeTimer;

    /**
     * Creates new form CheckOut
     */
    public CheckOut() {
        initComponents();
        this.setLocationRelativeTo(null);
        enteredIDs = new HashSet<>();
        enteredIDsToRowMap = new HashMap<>();
        jEquipmentID.requestFocusInWindow();
   
        barcodeTimer = new Timer(300, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processBarcode();
            }
        });
        barcodeTimer.setRepeats(false);

        // Adding DocumentListener to detect text changes
        jEquipmentID.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                barcodeTimer.restart(); // Restart the timer on each keystroke
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                // Do nothing
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                // Do nothing
            }
        });
    }

    
    private void processBarcode() {
        String scannedBarcode = jEquipmentID.getText().trim();
        if (!scannedBarcode.isEmpty()) {
            if (enteredIDs.contains(scannedBarcode)) {
                removeEqID(scannedBarcode);
            } else {
                addBarcodeEqID(scannedBarcode);
            }
            jEquipmentID.setText(""); // Clear the buffer
        }
    }
   
       
    public void addBarcodeEqID(String eqID) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        enteredIDs.add(eqID);
        int row = model.getRowCount();
        model.addRow(new Object[] { eqID });
        enteredIDsToRowMap.put(eqID, row);
    }
    
    /***
     * this method was made to allow for barcode scanner to be able to scan twice and remove the scanned ID from the table
     * and the reason why eqID from enteredID hashset and enteredIDsToRowMap to hashmap is in this removal is so when the 
     * double scan removal happens the eqID is removed from the hashset and hashmap so that if a user wanted to add 
     * eqID that was added before an error will not happen. 
     ***/ 
    private void removeEqID(String eqID) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int row = enteredIDsToRowMap.get(eqID);
        enteredIDs.remove(eqID);
        enteredIDsToRowMap.remove(eqID);

        // Temporarily store adjustments
        Map<Integer, String> tempAdjustments = new HashMap<>();
        for (Map.Entry<String, Integer> entry : enteredIDsToRowMap.entrySet()) {
            if (entry.getValue() <= row) {
                tempAdjustments.put(entry.getValue(), entry.getKey());
            }
        }

        // Remove the row from the model
        model.removeRow(row);
        System.out.println("Barcode " + eqID + " scanned twice. Removed from the table.");

        // Apply adjustments
        for (Map.Entry<Integer, String> adjustment : tempAdjustments.entrySet()) {
            enteredIDsToRowMap.put(adjustment.getValue(), adjustment.getKey());
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
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
        jLabel6 = new javax.swing.JLabel();
        jEquipmentID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jAddToTable = new javax.swing.JButton();
        timePicker1 = new javax.swing.JComboBox<>();
        timePicker2 = new javax.swing.JComboBox<>();
        jDeleteEntry = new javax.swing.JButton();

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

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setText("Date/Time Issued:");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setText("Return Date/Time:");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setText("Event Name:");

        jTxtDate.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jTxtReturnDate.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setText("Event ID:");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setText("Equipment ID");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Equipment ID"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jAddToTable.setText("+");
        jAddToTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jAddToTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAddToTableActionPerformed(evt);
            }
        });

        String[] times = generateTimes();

        timePicker1.setEditable(true); // Make the dropdown editable
        timePicker1.setEditor(new CustomComboBoxEditor());
        timePicker1.setModel(new javax.swing.DefaultComboBoxModel<>(generateTimes()));

        String[] time2 = generateTimes();

        timePicker2.setEditable(true); // Make the dropdown editable
        timePicker2.setEditor(new CustomComboBoxEditor());
        timePicker2.setModel(new javax.swing.DefaultComboBoxModel<>(generateTimes()));

        jDeleteEntry.setText("-");
        jDeleteEntry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDeleteEntryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JHomeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCheckOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTxtReturnDate, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(JEventName, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jTxtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jEventID, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(timePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(timePicker2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(19, 19, 19))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jEquipmentID, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jAddToTable)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDeleteEntry, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jEquipmentID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jAddToTable)
                    .addComponent(jDeleteEntry))
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
                            .addComponent(timePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTxtReturnDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(timePicker2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JHomeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jDeleteEntryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDeleteEntryActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int[] selectedRow = jTable1.getSelectedRows();

        // iterates through the selected amount of rows, to delete at once.
        for (int i = selectedRow.length - 1; i >= 0; i--) {
            int rowIndex = selectedRow[i];
            String equipmentID = (String) model.getValueAt(rowIndex, NORMAL);
            model.removeRow(rowIndex);
            enteredIDs.remove(equipmentID);
            enteredIDsToRowMap.remove(equipmentID);
        }
    }//GEN-LAST:event_jDeleteEntryActionPerformed

    private String[] generateTimes() {
        String[] times = new String[24 * 4]; // 24 hours * 4 quarters per hour
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        for (int i = 0; i < times.length; i++) {
            times[i] = sdf.format(calendar.getTime());
            calendar.add(Calendar.MINUTE, 30);
        }
        return times;
    }

    private class CustomComboBoxEditor extends BasicComboBoxEditor {

        private JTextField textField;

        public CustomComboBoxEditor() {
            super();
            textField = (JTextField) editor;
            textField.setEditable(true);
            textField.setBorder(UIManager.getBorder("ComboBox.editorBorder"));
        }

        @Override
        public Component getEditorComponent() {
            return editor;
        }
    }

    public void outPutDataToTable() {
        try {
            //
            DatabaseUtils databaseUtils = new DatabaseUtils();

            // Fetches data from the database
            List<Data> dataList = databaseUtils.fetchDataFromEquipmentLog();

            // calls object of noneditabletable model to make the jtable noneditable
            NonEditableTableModel model = new NonEditableTableModel();

            model.setColumnIdentifiers(new Object[] { "EquipmentID", "EquipmentName" });

            for (Data data : dataList) {
                // Add each row of data to the JTable
                model.addRow(new Object[] { data.getEquipmentID(), data.getEquipmentName() });
            }

            // Set the table model
            jTable1.setModel(model);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // String formatDateTime to get time from spinner and date from calendar
    // component in the format that works with TimeStamp
    private String formatDateTime(String time, String date) {
        /*
         * originalDateFormat is created so that we can parse String Date as a Date
         * object, which can later be formatted to yyyy-MM-dd format
         */
        SimpleDateFormat originalDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        try {
            // Parse the date string into a Date object
            Date formattedDate = originalDateFormat.parse(date);
            String formattedDateString = dateFormat.format(formattedDate);
            String formattedTimeString = timeFormat.format(timeFormat.parse(time + ":00"));

            return formattedDateString + " " + formattedTimeString;
        } catch (ParseException e) {
            // Handle any parsing errors
            e.printStackTrace();
            return null; // or throw an exception or return a default value
        }
    }
    
    private void jCheckOutButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        String evID = jEventID.getText();
        String evName = JEventName.getText();
        String dateIssue = jTxtDate.getText();
        String dateReturn = jTxtReturnDate.getText();
        String eqID = jEquipmentID.getText();

        // formatting date and time.
        String dateTimeSent = formatDateTime((String) timePicker1.getSelectedItem(), dateIssue);
        String dateTimeReturn = formatDateTime((String) timePicker2.getSelectedItem(), dateReturn);
        
        if(eqID.trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "ID input is blank, please make sure input is valid.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(evID.trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "please enter a Event ID.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            DatabaseUtils dbUtils = new DatabaseUtils();

            // Retrieve the logged-in staff ID from AppContext
            String loggedInStaffID = StaffIDTracker.getLoggedInStaffID();

            // Check if staff ID is null or empty, handle the case if needed
            if (loggedInStaffID == null || loggedInStaffID.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Error: No staff ID found. Please login again.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!dbUtils.doesEventExist(evID)) {
                dbUtils.insertDataEventTable(evID, evName);
            }

            for (int i = 0; i < model.getRowCount(); i++) {
                String equipmentID = model.getValueAt(i, 0).toString();

                if (!dbUtils.doesEquipmentExists(equipmentID)) {
                    JOptionPane.showMessageDialog(this, "Equipment with ID " + equipmentID + " does not exist. Please add it to the database first.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (dbUtils.isEquipmentCheckedOut(equipmentID)) {
                    JOptionPane.showMessageDialog(this, "Equipment with ID " + equipmentID + " is already checked out.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                dbUtils.insertDataBookingTable(evID, evName, equipmentID, loggedInStaffID, dateTimeSent, dateTimeReturn);
                dbUtils.updateEquipmentStatusCheckedOut(equipmentID);
            }

            JOptionPane.showMessageDialog(this, "Equipment has been successfully checked out.", "Success", JOptionPane.INFORMATION_MESSAGE);
            model.setRowCount(0);
            enteredIDs.clear();
            enteredIDsToRowMap.clear();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error has occurred, check your connection to the database", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
    private void JHomeButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_JHomeButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
        MainMenu mainmenu = new MainMenu();
        mainmenu.setVisible(true);
    }// GEN-LAST:event_JHomeButtonActionPerformed

// GEN-LAST:event_jCheckOutButtonActionPerformed

    private void jAddToTableActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jAddToTableActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        String equipmentID = jEquipmentID.getText();

        if (!enteredIDs.contains(equipmentID)) {
            model.addRow(new Object[] { equipmentID });
            enteredIDs.add(equipmentID);
            // Optionally, clear the text fields after adding
            jEquipmentID.setText("");

        } else {
            JOptionPane.showMessageDialog(null,
                    "Duplicate ID found in the Table, please ensure there are now duplicates.");
        }
    }// GEN-LAST:event_jAddToTableActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CheckOut checkout = new CheckOut();
                checkout.setVisible(true);
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
    private javax.swing.JButton jDeleteEntry;
    private javax.swing.JTextField jEquipmentID;
    private javax.swing.JTextField jEventID;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTxtDate;
    private javax.swing.JTextField jTxtReturnDate;
    private javax.swing.JComboBox<String> timePicker1;
    private javax.swing.JComboBox<String> timePicker2;
    // End of variables declaration//GEN-END:variables

}

