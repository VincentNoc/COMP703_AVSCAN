/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.avscan;

import Database.DatabaseUtils;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import multi.use.frames.SmallErrorMessage;

/**
 *
 * @author vince-kong
 */
public class NewEq extends javax.swing.JFrame  implements ConnectItemToParent.ConnectCallback{

    private ConnectItemToParent childs;
    private int rememberSelectedRow;
    /**
     * Creates new form CheckIn
     */
    public NewEq() {
        initComponents();
        //addFakeInfoRow();//Just simple dummy data to do not input it manualy. Comment it out if needed.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        deleteButton = new javax.swing.JButton();
        newEqButton = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        connToParent = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        homeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("ID");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Equipment ID", "Equipment Name", "Equipment Type", "Parent ID"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        newEqButton.setText("+");
        newEqButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newEqButtonActionPerformed(evt);
            }
        });

        connToParent.setText("Add childs");
        connToParent.setToolTipText("");
        connToParent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectToParent(evt);
            }
        });

        jLabel2.setText("Name");

        jLabel3.setText("Type");

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonaddActionPerformed(evt);
            }
        });

        homeButton.setText("Home");
        homeButton.setToolTipText("");
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonconnectToParent(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(homeButton)
                        .addGap(18, 18, 18)
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(connToParent)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(newEqButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newEqButton))
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(connToParent, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Creating dummy data. Comment out the caller in the constructor to stop generating.
    public void addFakeInfoRow() {
        //jTable1 = new javax.swing.JTable();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        final JTable table = new JTable(model);
        table.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        // Add 100 rows of dummy data
        for (int i = 0; i < 15; i++) {
            model.addRow(new Object[]{"ID " + i + "A", "Name " + i, "camera"});
        }

        // Assuming jScrollPane1 is already set up to display jTable1
        // You might need to refresh jScrollPane1 if it's not automatically updating
        jScrollPane1.setViewportView(jTable1);

        // Assuming jScrollPane1 is a JScrollPane declared elsewhere
        // jScrollPane1.setViewportView(jTable1);
    }


    //To remove Selected rows
    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        int selectedRow[] = jTable1.getSelectedRows();
        System.out.println(selectedRow);
        if (selectedRow != null) {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            for (int i = selectedRow.length - 1; i >= 0; i--) {
                model.removeRow(selectedRow[i]);
            }
        }

    }//GEN-LAST:event_deleteActionPerformed

    // Adding new row based on information inputed in jTextField(1&2&3)
    private void newEqButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newEqButtonActionPerformed
        // TODO add your handling code here:
        if (!this.jTextField1.getText().equals("") && !this.jTextField2.getText().equals("") && !this.jTextField3.getText().equals("")) {

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

            // Get text from JTextFields
            String text1 = jTextField1.getText();
            String text2 = jTextField2.getText();
            String text3 = jTextField3.getText();

            // Add new row to the table model
            boolean dublicates = false;
            for (int i = 0; i < model.getRowCount(); i++) {
                String toCheck = (String) model.getValueAt(i, 0);
                if (toCheck.equalsIgnoreCase(text1)) {
                    new SmallErrorMessage("The Equipment already added to the table.",this).setVisible(true);
                    return;
                }
            }
            model.addRow(new Object[]{text1, text2, text3});

            // Optionally, clear the text fields after adding
            jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
        } else {
            new SmallErrorMessage("Please fill all input areas.",this).setVisible(true);
        }
    }//GEN-LAST:event_newEqButtonActionPerformed

    //Open new window to create parent-child(super-sub) equipment realtion.
    //Will send the selected row to the next windo to add child equipments to the parent equipment.
    private void connectToParent(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectToParent
        if (jTable1.getSelectedRows().length != 1) {//Cancel the method if user selected multiple rows
            new SmallErrorMessage("Please select one Row only",this).setVisible(true);
            return;
        }
        this.rememberSelectedRow =  jTable1.getSelectedRow();

        // Assuming model is the DefaultTableModel associated with your JTable
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        // Assuming 0, 1, 2 and 3 are the column indices for Equipment ID, Equipment Name, and Equipment Type, ParentID
        String equipmentID = (String) model.getValueAt(rememberSelectedRow, 0);
        String equipmentName = (String) model.getValueAt(rememberSelectedRow, 1);
        String equipmentType = (String) model.getValueAt(rememberSelectedRow, 2);

        childs = new ConnectItemToParent(model, equipmentID, equipmentName, equipmentType, this);
        
        
    }//GEN-LAST:event_connectToParent

    //Updating child-parent relation information after adding childs
    @Override
    public void onConnect() {
        // Continue execution after connect action is performed
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        //var temp = model.getValueAt(rememberSelectedRow, 0);
        DefaultTableModel toConnect = childs.getChildsInfo();
        
        for (int i = 0; i < model.getRowCount(); i++) {
            for (int b = 0; b < toConnect.getRowCount(); b++) {
                if (model.getValueAt(i, 0).equals(toConnect.getValueAt(b, 0))) {
                    
                    model.setValueAt(model.getValueAt(rememberSelectedRow, 0), i, 3);
                    toConnect.removeRow(b);
                }
            }
        }
        while(toConnect.getRowCount()>0){
            
            String ID = (String) toConnect.getValueAt(0, 0);
            String Name = (String) toConnect.getValueAt(0, 1);
            String Type = (String) toConnect.getValueAt(0, 2);
            model.addRow(new Object[]{ID, Name, Type, model.getValueAt(rememberSelectedRow, 0)});
            toConnect.removeRow(0);
        }
        //this.jTable1 = new JTable(model);
    }
    
    //Sending data to database.
    private void addButtonaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonaddActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        if (model.getRowCount() > 0) {
            try {
                new DatabaseUtils(model);
                //new DatabaseUtils(model).fetchDataFromDatabase();
            } catch (SQLException ex) {
                Logger.getLogger(NewEq.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            new SmallErrorMessage("Use button \"Add\" to add new equipment before format!",this).setVisible(true);
        }

    }//GEN-LAST:event_addButtonaddActionPerformed

    private void homeButtonconnectToParent(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonconnectToParent
        // TODO add your handling code here:
        new MainMenu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_homeButtonconnectToParent

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
            java.util.logging.Logger.getLogger(NewEq.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewEq.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewEq.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewEq.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewEq().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton connToParent;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton homeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JButton newEqButton;
    // End of variables declaration//GEN-END:variables
}
