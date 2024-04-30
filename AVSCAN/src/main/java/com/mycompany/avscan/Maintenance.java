/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.avscan;

import Database.Data;
import multi.use.frames.SmallErrorMessage;
import Database.DatabaseUtils;
import Database.MaintenanceData;
import java.awt.Color;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import multi.use.frames.ReturnMaintenance;
import multi.use.frames.ShowCommentMaintenance;

/**
 *
 * @author dmitr
 */
public class Maintenance extends javax.swing.JFrame implements MaintenanceAddComment.ConnectCallback {

    ;
    private Hashtable<String, Data> equipment;
    private MaintenanceAddComment maint;
    private List<MaintenanceData> dataList;
    private Hashtable<String, MaintenanceData> hashUnreturned;
    private ReturnMaintenance returnMaint;

    /**
     * Creates new form Maintenance
     */
    public Maintenance() throws SQLException {
        initComponents();
        createAndPutDataToTable();
        getEquipmentData();
    }

    private void getEquipmentData() throws SQLException {
        DatabaseUtils temp = new DatabaseUtils();

        this.equipment = temp.fetchHashtableMaintenanceData();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        eqIDLabel = new javax.swing.JLabel();
        eqNameLabel = new javax.swing.JLabel();
        receivedLabel = new javax.swing.JLabel();
        repairedLabel = new javax.swing.JLabel();
        eqIDInput = new javax.swing.JTextField();
        eqNameInput = new javax.swing.JTextField();
        receivedInput = new javax.swing.JTextField();
        repairedInput = new javax.swing.JTextField();
        homeButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();
        readDescButton = new javax.swing.JButton();
        returnButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Equipment ID", "Equipment Name", "Parent ID", "Parent Name", "Received", "Repaired & Returned"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        eqIDLabel.setText("Equipment ID");

        eqNameLabel.setText("Equipment Name");

        receivedLabel.setText("Received ");

        repairedLabel.setText("Repaired & Returned");

        eqIDInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                eqIDInputKeyReleased(evt);
            }
        });

        receivedInput.setForeground(new java.awt.Color(204, 204, 204));
        receivedInput.setText("dd/mm/yyyy");
        receivedInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                receivedInputFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                receivedInputFocusLost(evt);
            }
        });

        repairedInput.setForeground(new java.awt.Color(204, 204, 204));
        repairedInput.setText("dd/mm/yyyy");
        repairedInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                repairedInputFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                repairedInputFocusLost(evt);
            }
        });

        homeButton.setText("Home");
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        searchButton.setText("Search");
        searchButton.setToolTipText("");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        readDescButton.setText("Read Description");
        readDescButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descriptionButtonActionPerformed(evt);
            }
        });

        returnButton.setText("Return Equipment");
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 769, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(homeButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(addButton))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(eqIDLabel)
                                    .addComponent(eqIDInput, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(62, 62, 62)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(eqNameInput)
                                    .addComponent(eqNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(receivedLabel)
                                    .addComponent(receivedInput, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(62, 62, 62)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(repairedLabel)
                                    .addComponent(repairedInput, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(readDescButton, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(returnButton)
                                .addGap(18, 18, 18)
                                .addComponent(searchButton)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(eqIDLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(eqIDInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(receivedLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(receivedInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(eqNameLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(eqNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(repairedLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(repairedInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(readDescButton)
                        .addComponent(returnButton)
                        .addComponent(searchButton))
                    .addComponent(addButton)
                    .addComponent(homeButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:

        if (this.equipment.containsKey(this.eqIDInput.getText())) {
            if (this.hashUnreturned.containsKey(this.eqIDInput.getText())) {
                new SmallErrorMessage("The equipment is already repairing!", this).setVisible(true);
                return;
            }
            Data temp = new Data(this.equipment.get(this.eqIDInput.getText()));
            this.maint = new MaintenanceAddComment(temp, this);
            this.setEnabled(false);
        } else {
            new SmallErrorMessage("The  ID:(" + this.eqIDInput.getText() + ") does not exists.", this).setVisible(true);
        }
    }//GEN-LAST:event_addButtonActionPerformed
    //Updating with added maintenance data
    @Override
    public void onConnect() {
        this.setEnabled(true);
        createArrayList();
    }

    private void descriptionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descriptionButtonActionPerformed
        // TODO add your handling code here:
        if (jTable1.getSelectedRows().length != 1) {//Cancel the method if user selected multiple rows
            new SmallErrorMessage("Please select one Row only", this).setVisible(true);
            return;
        }
        int selectedRow = jTable1.getSelectedRow();
        //call ConfirmationFrame
        ShowCommentMaintenance confirmationFrame = new ShowCommentMaintenance(this.dataList.get(selectedRow));
        confirmationFrame.setCallback(new ShowCommentMaintenance.ConfirmationCallback() {
            @Override
            public void onConfirmationReceived(boolean confirmed) {
                if (confirmed) {
                    // Unblock Maintenance
                    Maintenance.this.setEnabled(true);
                    Maintenance.this.toFront();
                }
            }
        });
        confirmationFrame.setVisible(true);
        Maintenance.this.setEnabled(false);

    }//GEN-LAST:event_descriptionButtonActionPerformed

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_homeButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        if (this.eqIDInput.getText().trim().equals("") && this.eqNameInput.getText().trim().equals("")
                && this.receivedInput.getText().trim().equals("dd/mm/yyyy") && this.repairedInput.getText().trim().equals("dd/mm/yyyy")) {
            //new SmallErrorMessage("Enter something in input fields.", this).setVisible(true);
            createAndPutDataToTable();
            return;
        }

        try {
            String ID = this.eqIDInput.getText();
            String Name = this.eqNameInput.getText();
            String received = this.receivedInput.getText();
            String returned = this.repairedInput.getText();
            DatabaseUtils db = new DatabaseUtils();
            this.dataList = db.fetchHashtableMaintenanceSearchData(ID, Name, received, returned);

            model.setRowCount(0); // Clear existing data

            for (MaintenanceData data : dataList) {
                // Add each row of data to the JTable
                //System.out.println(data.toString());
                model.addRow(new Object[]{
                    data.getEqID(), data.getEqName(), data.getParentID(), data.getParentName(), data.getReceived(), data.getReturned()
                });
            }

        } catch (SQLException ex) {
            Logger.getLogger(Maintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void receivedInputFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_receivedInputFocusLost
        // TODO add your handling code here:
        setDefaultDateInput(this.receivedInput);
    }//GEN-LAST:event_receivedInputFocusLost

    private void receivedInputFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_receivedInputFocusGained
        // TODO add your handling code here:
        dateInputClicked(this.receivedInput);
    }//GEN-LAST:event_receivedInputFocusGained

    private void repairedInputFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_repairedInputFocusGained
        // TODO add your handling code here:
        dateInputClicked(this.repairedInput);
    }//GEN-LAST:event_repairedInputFocusGained

    private void repairedInputFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_repairedInputFocusLost
        // TODO add your handling code here:
        setDefaultDateInput(this.repairedInput);
    }//GEN-LAST:event_repairedInputFocusLost

    private void eqIDInputKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_eqIDInputKeyReleased
        // TODO add your handling code here:'
        if (this.equipment.containsKey(this.eqIDInput.getText())) {
            Data temp = this.equipment.get(this.eqIDInput.getText());
            this.eqNameInput.setText(temp.getEquipmentName());
            this.eqNameInput.setForeground(Color.green);
            this.eqNameLabel.setText("<html>Equipment Name(<font color='green'>suggestion</font>):</html>");
            this.eqNameInput.setEditable(false);
            return;
        }
        this.eqNameInput.setText("");
        this.eqNameInput.setForeground(Color.black);
        this.eqNameLabel.setText("<html>Equipment Name</html>");
        this.eqNameInput.setEditable(true);
    }//GEN-LAST:event_eqIDInputKeyReleased

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed
        // TODO add your handling code here:
        if (jTable1.getSelectedRows().length != 1) {//Cancel the method if user selected multiple rows
            new SmallErrorMessage("Please select one Row only", this).setVisible(true);
            return;
        }

        int selectedRow = jTable1.getSelectedRow();

        if (this.dataList.get(selectedRow) != null) {
            new SmallErrorMessage("The seleceted equipment is already returned!", this).setVisible(true);
            return;
        }
        //call ConfirmationFrame
        ReturnMaintenance returnMaint = new ReturnMaintenance(this.dataList.get(selectedRow));
        returnMaint.setCallback(new ReturnMaintenance.ConfirmationCallback() {
            @Override
            public void onConfirmationReceived(boolean confirmed) {
                if (confirmed) {
                    // Unblock Maintenance
                    Maintenance.this.setEnabled(true);
                    Maintenance.this.toFront();
                }
            }
        });
        returnMaint.setVisible(true);
        Maintenance.this.setEnabled(false);

    }//GEN-LAST:event_returnButtonActionPerformed

    private void dateInputClicked(javax.swing.JTextField importat) {
        if (importat.getText().trim().equals("dd/mm/yyyy")) {
            importat.setText("");
            importat.setForeground(Color.black);
        }
    }

    private void setDefaultDateInput(javax.swing.JTextField importat) {
        if (importat.getText().trim().equals("")) {
            importat.setText("dd/mm/yyyy");
            importat.setForeground(new Color(140, 140, 140));
        }
    }

    public void createAndPutDataToTable() {
        createArrayList();//to put in table in requested order
        createHashtable();//to easily find the right data
    }

    public void createHashtable() {
        try {
            DatabaseUtils database = new DatabaseUtils();
            this.hashUnreturned = database.fetchMaintenanceUnreturned();
        } catch (SQLException ex) {
            Logger.getLogger(Maintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void createArrayList() {//using List to store data
        try {
            DatabaseUtils databaseUtils = new DatabaseUtils();
            // Fetch data from the database
            dataList = databaseUtils.fetchMaintenanceData();
            // Update the JTable with the fetched data
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0); // Clear existing data

            for (MaintenanceData data : dataList) {
                // Add each row of data to the JTable
                //System.out.println(data.toString());
                model.addRow(new Object[]{
                    data.getEqID(), data.getEqName(), data.getParentID(), data.getParentName(), data.getReceived(), data.getReturned()
                });
            }

        } catch (SQLException e) {
            e.printStackTrace();
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
            java.util.logging.Logger.getLogger(Maintenance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Maintenance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Maintenance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Maintenance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Maintenance().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Maintenance.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTextField eqIDInput;
    private javax.swing.JLabel eqIDLabel;
    private javax.swing.JTextField eqNameInput;
    private javax.swing.JLabel eqNameLabel;
    private javax.swing.JButton homeButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton readDescButton;
    private javax.swing.JTextField receivedInput;
    private javax.swing.JLabel receivedLabel;
    private javax.swing.JTextField repairedInput;
    private javax.swing.JLabel repairedLabel;
    private javax.swing.JButton returnButton;
    private javax.swing.JButton searchButton;
    // End of variables declaration//GEN-END:variables

}
