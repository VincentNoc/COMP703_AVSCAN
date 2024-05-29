/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.avscan;

/**
 *
 * @author 2xkaz
 */
import Database.DatabaseUtils;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.mycompany.avscan.Login_Signup_pages.LoginPage;
import com.mycompany.avscan.Login_Signup_pages.StaffIDTracker;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
public class MainMenu extends javax.swing.JFrame {
    private static String loggedInStaffID; 
    /**
     * Creates new form MainMenu
     * @param recordUserID
     */
    public MainMenu() {
        initComponents();
        this.setLocationRelativeTo(null);
        StaffIDTracker staffIDTracker = new StaffIDTracker();
        String loggedInStaffID = staffIDTracker.getLoggedInStaffID();
        loadEquipmentLog();
        System.out.println(loggedInStaffID);
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
        welcometxt = new javax.swing.JLabel();
        recentlyIssuedEquipment = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jButtonDataList = new javax.swing.JButton();
        jButtonHelp = new javax.swing.JButton();
        jButtonCheckIn = new javax.swing.JButton();
        jButtonCheckOut = new javax.swing.JButton();
        jButtonLogOut = new javax.swing.JButton();
        newEqButton = new javax.swing.JButton();
        maintenanceButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        DarkModeButton = new javax.swing.JCheckBoxMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        welcometxt.setFont(new java.awt.Font("Yu Gothic UI", 0, 36)); // NOI18N
        welcometxt.setText("Welcome to AVSCAN!");

        recentlyIssuedEquipment.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        recentlyIssuedEquipment.setText("Recently Issued Equiptment");

        jTable1.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Equipment ID", "Equipment Name", "Return Due Date", "Status"
            }
        ));
        jTable1.setPreferredSize(new java.awt.Dimension(960, 180));
        jTable1.setRowHeight(30);
        jScrollPane2.setViewportView(jTable1);

        jPanel4.setPreferredSize(new java.awt.Dimension(960, 265));

        jButtonDataList.setText("Data List");
        jButtonDataList.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonDataList.setPreferredSize(new java.awt.Dimension(260, 53));
        jButtonDataList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDataListActionPerformed(evt);
            }
        });

        jButtonHelp.setText("Help");
        jButtonHelp.setPreferredSize(new java.awt.Dimension(260, 53));
        jButtonHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHelpActionPerformed(evt);
            }
        });

        jButtonCheckIn.setText("Check In");
        jButtonCheckIn.setPreferredSize(new java.awt.Dimension(260, 53));
        jButtonCheckIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCheckInActionPerformed(evt);
            }
        });

        jButtonCheckOut.setText("Check Out");
        jButtonCheckOut.setPreferredSize(new java.awt.Dimension(260, 53));
        jButtonCheckOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCheckOutActionPerformed(evt);
            }
        });

        jButtonLogOut.setText("Log Out");
        jButtonLogOut.setPreferredSize(new java.awt.Dimension(260, 53));
        jButtonLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogOutActionPerformed(evt);
            }
        });

        newEqButton.setText("Add New");
        newEqButton.setPreferredSize(new java.awt.Dimension(260, 53));
        newEqButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newEqButtonActionPerformed(evt);
            }
        });

        maintenanceButton.setText("Maintenance");
        maintenanceButton.setPreferredSize(new java.awt.Dimension(260, 53));
        maintenanceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maintenanceButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(345, 345, 345)
                .addComponent(jButtonLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 355, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButtonDataList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButtonHelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(newEqButton, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(maintenanceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(121, 121, 121))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButtonDataList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(jButtonHelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(newEqButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(maintenanceButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jButtonLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(welcometxt)
                    .addComponent(recentlyIssuedEquipment)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 960, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(welcometxt)
                .addGap(6, 6, 6)
                .addComponent(recentlyIssuedEquipment)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jMenu3.setText("Option");

        DarkModeButton.setText("Dark Mode");
        DarkModeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DarkModeButtonActionPerformed(evt);
            }
        });
        jMenu3.add(DarkModeButton);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadEquipmentLog(){
        try{
            DatabaseUtils dbUtils = new DatabaseUtils();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            dbUtils.getEquipmentStatusReturnDate(model);
        }catch(SQLException e){
            e.printStackTrace();
        }  
    }
    
    private void jButtonDataListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDataListActionPerformed
        this.dispose();
        History historyPage = new History();
        historyPage.setVisible(true);
    }//GEN-LAST:event_jButtonDataListActionPerformed

    private void jButtonCheckOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCheckOutActionPerformed
        this.dispose();
        CheckOut checkOutPage = new CheckOut();
        checkOutPage.setVisible(true);
    }//GEN-LAST:event_jButtonCheckOutActionPerformed

    private void jButtonCheckInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCheckInActionPerformed
       this.dispose();
       CheckIn checkInPage = new CheckIn();
       checkInPage.setVisible(true);
    }//GEN-LAST:event_jButtonCheckInActionPerformed

    private void jButtonHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHelpActionPerformed
        /*
        Comment from Misako
        Need to create help page (help class)
        
        this.dispose();
        Help helpPage = new Help();
        helpPage.setVisible(true);
        */
    }//GEN-LAST:event_jButtonHelpActionPerformed

    private void jButtonLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogOutActionPerformed
        /*
        comment from Misako
        Need to create log in page (logIn class)
        */
        this.dispose();
        LoginPage lp = new LoginPage();
        lp.setVisible(true);
        
    }//GEN-LAST:event_jButtonLogOutActionPerformed

    //this button changes the layout to dark or light
    private void DarkModeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DarkModeButtonActionPerformed
        // TODO add your handling code here:
        //checks if the dark mode button has been selected or not.
        if(DarkModeButton.isSelected()){ 
            EventQueue.invokeLater(new Runnable() {
            @Override
            public void run(){
                FlatDarkLaf.setup();
                FlatLaf.updateUI();
            }
            });   
        }else{
            EventQueue.invokeLater(new Runnable() {
            @Override
            public void run(){
                FlatLightLaf.setup();
                FlatLaf.updateUI();
            }
            }); 
        }
    }//GEN-LAST:event_DarkModeButtonActionPerformed

    private void newEqButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newEqButtonActionPerformed
        // TODO add your handling code here:
        new NewEq().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_newEqButtonActionPerformed

    private void maintenanceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maintenanceButtonActionPerformed
        try {
            // TODO add your handling code here:
            new Maintenance().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_maintenanceButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainMenu mainMenu = new MainMenu();
                mainMenu.setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBoxMenuItem DarkModeButton;
    private javax.swing.JButton jButtonCheckIn;
    private javax.swing.JButton jButtonCheckOut;
    private javax.swing.JButton jButtonDataList;
    private javax.swing.JButton jButtonHelp;
    private javax.swing.JButton jButtonLogOut;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton maintenanceButton;
    private javax.swing.JButton newEqButton;
    private javax.swing.JLabel recentlyIssuedEquipment;
    private javax.swing.JLabel welcometxt;
    // End of variables declaration//GEN-END:variables
}
