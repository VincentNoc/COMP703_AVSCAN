/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.avscan;

import Database.Data;
import Database.DatabaseUtils;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author vince-kong
 */
public class CheckIn extends javax.swing.JFrame {

    private Set<String> enteredIDs;
    private Hashtable<String, Data> equipments;

    public CheckIn() {
        initComponents();
        this.setLocationRelativeTo(null);
        enteredIDs = new HashSet<>();
        getAllEquipmentData();
    }

    private void getAllEquipmentData() {
        try {
            DatabaseUtils db = new DatabaseUtils();
            this.equipments = db.selestAllEquipment();
        } catch (SQLException ex) {
            Logger.getLogger(CheckOut.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jEquipmentID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
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

        jButton1.setText("-");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        jAddButtonToEquipmentLog.setText("Add");
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
                                .addComponent(jAddToTable, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(jButton1))
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


    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int[] selectedRow = jTable1.getSelectedRows();

        //iterates through the selected amount of rows, to delete at once. 
        for (int i = selectedRow.length - 1; i >= 0; i--) {
            int rowIndex = selectedRow[i];
            String equipmentID = (String) model.getValueAt(rowIndex, NORMAL);

            model.removeRow(rowIndex);

            enteredIDs.remove(equipmentID);

        }


    }//GEN-LAST:event_deleteActionPerformed

    // To remove selected row
    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        for (int i = 0; i < model.getRowCount(); i++) {
            String equipmentID = model.getValueAt(i, 0).toString();
            //String equipmentName = model.getValueAt(i, 1).toString();
            //String equipmentType = model.getValueAt(i, 2).toString();

            try {
                DatabaseUtils dbUtil = new DatabaseUtils();
                dbUtil.updateEquipmentLogStatusCheckedIn(equipmentID);

            } catch (SQLException ex) {
                // Handle the exception (e.g., display error message)
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error adding data to database: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        model.setRowCount(0);
    }//GEN-LAST:event_addActionPerformed

    private void JHomeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JHomeButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
        MainMenu mainmenu = new MainMenu();
        mainmenu.setVisible(true);
    }//GEN-LAST:event_JHomeButtonActionPerformed

    private void jAddToTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAddToTableActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        String equipmentID = jEquipmentID.getText();
        if(!this.equipments.containsKey(equipmentID)){
            JOptionPane.showMessageDialog(null, "The Equipment ID("+equipmentID+") does not exists in database.");
            return;
        }if(!this.equipments.get(equipmentID).getStatus().equals("Checked Out")){
            JOptionPane.showMessageDialog(null, "The Equipment ID("+equipmentID.trim()+") is currently "+this.equipments.get(equipmentID).getStatus()+".");
            return;
        }

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CheckIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CheckIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CheckIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CheckIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
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
    private javax.swing.JButton jButton1;
    private javax.swing.JTextField jEquipmentID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
