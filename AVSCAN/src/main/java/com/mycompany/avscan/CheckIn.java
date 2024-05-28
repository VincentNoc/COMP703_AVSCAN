
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.avscan;

import Database.Data;
import Database.DatabaseUtils;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author vince-kong
 */
public class CheckIn extends javax.swing.JFrame {
    private DefaultTableModel model;
    private Set<String> enteredIDs;
    private Map<String, Integer> enteredIDsToRowMap;
    private Hashtable<String, Data> equipments;
    private Timer barcodeTimer;
    

    public CheckIn() {
        initComponents();
        this.setLocationRelativeTo(null);
        enteredIDs = new HashSet<>();
        enteredIDsToRowMap = new HashMap<>();
        getAllEquipmentData();
        jEquipmentID.requestFocusInWindow();
      
        
        
//how long the delay is for automatic entry of keystrokes    
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
  
    private void getAllEquipmentData() {
        try {
            DatabaseUtils db = new DatabaseUtils();
            this.equipments = db.selestAllEquipment();
        } catch (SQLException ex) {
            Logger.getLogger(CheckOut.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jEquipmentID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jDeleteEntry = new javax.swing.JButton();
        jAddButtonToEquipmentLog = new javax.swing.JButton();
        JHomeButton = new javax.swing.JToggleButton();
        jAddToTable = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabel1.setText("ID:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Equipment ID"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jDeleteEntry.setText("-");
        jDeleteEntry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        jAddButtonToEquipmentLog.setText("Return");
        jAddButtonToEquipmentLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        JHomeButton.setText("Home");
        JHomeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JHomeButtonActionPerformed(evt);
            }
        });

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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JHomeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(136, 136, 136)
                                .addComponent(jAddButtonToEquipmentLog, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jEquipmentID, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jAddToTable)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDeleteEntry)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jEquipmentID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jAddToTable)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDeleteEntry))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jAddButtonToEquipmentLog, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JHomeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {
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
    }

    public void addBarcodeEqID(String eqID) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        enteredIDs.add(eqID);
        int row = model.getRowCount();
        model.addRow(new Object[] { eqID });
        enteredIDsToRowMap.put(eqID, row);
    }

    private void removeEqID(String eqID) {
        // Get the table model to manipulate the table data
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        // Find the row index corresponding to the eqID
        int row = enteredIDsToRowMap.get(eqID);

        // Remove the eqID from the set of entered IDs
        enteredIDs.remove(eqID);

        // Remove the eqID from the map that tracks row indices
        enteredIDsToRowMap.remove(eqID);

        // Remove the row from the model
        model.removeRow(row);
        System.out.println("Barcode " + eqID + " scanned twice. Removed from the table.");

        // Adjust the row indices in enteredIDsToRowMap
        Map<String, Integer> updatedMap = new HashMap<>();
        for (Map.Entry<String, Integer> entry : enteredIDsToRowMap.entrySet()) {
            int currentIndex = entry.getValue(); // Get the current row index for this entry
            if (currentIndex > row) { // Only adjust entries with indices greater than the removed row
                updatedMap.put(entry.getKey(), currentIndex - 1); // Decrement the index
            } else {
                updatedMap.put(entry.getKey(), currentIndex); // Keep the same index
            }
    }

    // Replace the original map with the updated map
    enteredIDsToRowMap = updatedMap;
}

    private void addActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        String eqID = jEquipmentID.getText();
        if(eqID.trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "ID input is blank, please make sure input is valid.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        for (int i = 0; i < model.getRowCount(); i++) {
            String equipmentID = model.getValueAt(i, 0).toString();

            try {
                DatabaseUtils dbUtil = new DatabaseUtils();
                dbUtil.updateEquipmentLogStatusCheckedIn(equipmentID);

            } catch (SQLException ex) {
                // Handle the exception (e.g., display error message)
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error adding data to database: " + ex.getMessage(), "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        model.setRowCount(0);
        enteredIDs.clear();
        enteredIDsToRowMap.clear();
    }// GEN-LAST:event_addActionPerformed

    private void JHomeButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_JHomeButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
        MainMenu mainmenu = new MainMenu();
        mainmenu.setVisible(true);
    }// GEN-LAST:event_JHomeButtonActionPerformed

    private void jAddToTableActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jAddToTableActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        String equipmentID = jEquipmentID.getText();

        if (!enteredIDsToRowMap.containsKey(equipmentID)) {
            model.addRow(new Object[] { equipmentID });
            enteredIDs.add(equipmentID);
            int row = model.getRowCount();
            enteredIDsToRowMap.put(equipmentID, row);
           

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
        // </editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CheckIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton JHomeButton;
    private javax.swing.JButton jAddButtonToEquipmentLog;
    private javax.swing.JButton jAddToTable;
    private javax.swing.JButton jDeleteEntry;
    private javax.swing.JTextField jEquipmentID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}

