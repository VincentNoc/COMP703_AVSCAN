/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.avscan;

/**
 *
 * @author Misako Morihana
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Help extends javax.swing.JFrame {

       /**
     * Creates new form Help
     */
    
    String hTxtHome;
    String hTxtCheckIn;
    String hTxtCheckOut;
    String hTxtAddNewEquipment;
    String hTxtDataList;
    
    public Help() {
        initComponents();
        
        // Txt for Home Page
        hTxtHome = "Help - Home Page\n"
                + "In this page you can select and move into one of the\n"
                + "pages shown in this page.\n"
                + "\n"
                + "\n"
                + "\n";
        //Write Help txt for Home Page here...
        
        // Txt for Check In Page
        hTxtCheckIn = "Help - Check In Page";
        //Write Help txt for Check In Page here...
        
        // Txt for Check Out Page
        hTxtCheckOut = "Help - Check Out Page";
        //Write Help txt for Check Out Page here...
        
        // Txt for Add New Equipment Page
        hTxtAddNewEquipment = "Help - Add New Equipment Page";
        //Write Help txt for Add New Equipment Page here...
        
        // Txt for History Page
        hTxtDataList = "Help - History Page";
        //Write Help txt for Data List Page here...
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jBtnHome = new javax.swing.JButton();
        jBtnCheckIn = new javax.swing.JButton();
        jBtnCheckOut = new javax.swing.JButton();
        jBtnAddNewEquip = new javax.swing.JButton();
        jBtnDataList = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1200, 700));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 0, 36)); // NOI18N
        jLabel1.setText("Help");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(380, 390));

        jBtnHome.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        jBtnHome.setText("Home");
        jBtnHome.setMaximumSize(new java.awt.Dimension(380, 60));
        jBtnHome.setMinimumSize(new java.awt.Dimension(380, 60));
        jBtnHome.setPreferredSize(new java.awt.Dimension(380, 60));
        jBtnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnHomeActionPerformed(evt);
            }
        });

        jBtnCheckIn.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        jBtnCheckIn.setText("Check In");
        jBtnCheckIn.setMaximumSize(new java.awt.Dimension(380, 60));
        jBtnCheckIn.setMinimumSize(new java.awt.Dimension(380, 60));
        jBtnCheckIn.setPreferredSize(new java.awt.Dimension(380, 60));
        jBtnCheckIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCheckInActionPerformed(evt);
            }
        });

        jBtnCheckOut.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        jBtnCheckOut.setText("Check Out");
        jBtnCheckOut.setMaximumSize(new java.awt.Dimension(380, 60));
        jBtnCheckOut.setMinimumSize(new java.awt.Dimension(380, 60));
        jBtnCheckOut.setPreferredSize(new java.awt.Dimension(380, 60));
        jBtnCheckOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCheckOutActionPerformed(evt);
            }
        });

        jBtnAddNewEquip.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        jBtnAddNewEquip.setText("Add New Equipment");
        jBtnAddNewEquip.setMaximumSize(new java.awt.Dimension(380, 60));
        jBtnAddNewEquip.setMinimumSize(new java.awt.Dimension(380, 60));
        jBtnAddNewEquip.setPreferredSize(new java.awt.Dimension(380, 60));
        jBtnAddNewEquip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAddNewEquipActionPerformed(evt);
            }
        });

        jBtnDataList.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        jBtnDataList.setText("History");
        jBtnDataList.setMaximumSize(new java.awt.Dimension(380, 60));
        jBtnDataList.setMinimumSize(new java.awt.Dimension(380, 60));
        jBtnDataList.setPreferredSize(new java.awt.Dimension(380, 60));
        jBtnDataList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDataListActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jBtnHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jBtnCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jBtnCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jBtnAddNewEquip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jBtnDataList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jBtnHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnAddNewEquip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnDataList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 66, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(620, 390));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane1.setPreferredSize(new java.awt.Dimension(620, 390));

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(100, 100, 100))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(206, 206, 206))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnHomeActionPerformed
        jTextArea1.setText(hTxtHome);
    }//GEN-LAST:event_jBtnHomeActionPerformed

    private void jBtnCheckInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCheckInActionPerformed
        jTextArea1.setText(hTxtCheckIn);
    }//GEN-LAST:event_jBtnCheckInActionPerformed

    private void jBtnCheckOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCheckOutActionPerformed
        jTextArea1.setText(hTxtCheckOut);
    }//GEN-LAST:event_jBtnCheckOutActionPerformed

    private void jBtnAddNewEquipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAddNewEquipActionPerformed
        jTextArea1.setText(hTxtAddNewEquipment);
    }//GEN-LAST:event_jBtnAddNewEquipActionPerformed

    private void jBtnDataListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDataListActionPerformed
        jTextArea1.setText(hTxtDataList);
    }//GEN-LAST:event_jBtnDataListActionPerformed

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
            java.util.logging.Logger.getLogger(Help.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Help.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Help.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Help.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Help().setVisible(true);
            }
        });
    }

    private HelpTxtHome helpTxtHome;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAddNewEquip;
    private javax.swing.JButton jBtnCheckIn;
    private javax.swing.JButton jBtnCheckOut;
    private javax.swing.JButton jBtnDataList;
    private javax.swing.JButton jBtnHome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
