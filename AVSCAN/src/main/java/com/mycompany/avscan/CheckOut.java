/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.avscan;

import Database.Validations.NonEditableTableModel;
import Database.Data;
import Database.DatabaseUtils;
import java.awt.Component;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicComboBoxEditor;


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
        JEventID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jEventName = new javax.swing.JTextField();
        jTxtDate = new javax.swing.JTextField();
        jTxtReturnDate = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jEquipmentID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jAddToTable = new javax.swing.JButton();
        timePicker1 = new javax.swing.JComboBox<>();
        timePicker2 = new javax.swing.JComboBox<>();

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

        String[] times = generateTimes();
        timePicker1 = new JComboBox<>(times);
        timePicker1.setEditable(true); // Make the dropdown editable
        timePicker1.setEditor(new CustomComboBoxEditor());
        timePicker1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        timePicker1.setModel(new javax.swing.DefaultComboBoxModel<>(generateTimes()));

        timePicker2 = new JComboBox<>(times);
        timePicker2.setEditable(true); // Make the dropdown editable
        timePicker2.setEditor(new CustomComboBoxEditor());
        timePicker2.setModel(new javax.swing.DefaultComboBoxModel<>(generateTimes()));

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
                                                .addComponent(jTxtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(timePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(timePicker2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel5))
                                        .addGap(78, 78, 78)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(JEventID, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                            .addComponent(jEventName))))
                                .addGap(19, 19, 19)))))
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
                            .addComponent(jEventName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(JEventID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(timePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(jTxtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTxtReturnDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(timePicker2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JHomeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        // Code adding the component to the parent container - not shown here

        pack();
    }// </editor-fold>//GEN-END:initComponents
  
    
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
    
    private String formatDateTime(String time, String date) {
        //original format the date chooser is. 
        SimpleDateFormat originalDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        try {
            // Parse the date string into a Date object 
            Date formattedDate = originalDateFormat.parse(date);

            // Format the date into the wanted format 
            String formattedDateString = dateFormat.format(formattedDate);

            // Append default seconds (00) to the time string and format it
            String formattedTimeString = timeFormat.format(timeFormat.parse(time + ":00"));
            
            
            System.out.println(date);
            System.out.println(formattedDateString + " " +formattedTimeString);
            return formattedDateString + " " + formattedTimeString;
        } catch (ParseException e) {
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
        DefaultTableModel tableModel = (DefaultTableModel) jTable2.getModel();

        String evID = JEventID.getText();
        String evName = jEventName.getText();
        String dateIssue = jTxtDate.getText();
        String dateReturn = jTxtReturnDate.getText();
        
        //formatting date and time. 
        String dateTimeSent = formatDateTime((String)timePicker1.getSelectedItem(), dateIssue);
        String dateTimeReturn = formatDateTime((String)timePicker2.getSelectedItem(), dateReturn);
        
        for(int i =0; i < tableModel.getRowCount(); i++){
            String equipmentID = tableModel.getValueAt(i, 0).toString();
             
        try{
            DatabaseUtils dbUtils = new DatabaseUtils();
              // Check if a row is selected

                    //this will be changed latter on. 
//                   dbUtils.insertDataEventTable(evID, selectedEqID, evName, "evDateTime", evCheckOutStaff, dateTimeSent, dateTimeReturn);
                    dbUtils.insertDataEventTable(evID, evName, equipmentID,  "01", dateTimeSent, dateTimeReturn);
                    dbUtils.updateEquipmentStatus(equipmentID);


        }catch(SQLException e){
            JOptionPane.showMessageDialog(this,"Error has Occurred, check your connection to the database", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        }
    }//GEN-LAST:event_jCheckOutButtonActionPerformed

    private void jAddToTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAddToTableActionPerformed
        // TODO add your handling code here:
          DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        String equipmentID = jEquipmentID.getText();
        
        
        if(!enteredIDs.contains(equipmentID) ){
            model.addRow(new Object[]{equipmentID});
            enteredIDs.add(equipmentID);
            // Optionally, clear the text fields after adding
            jEquipmentID.setText("");
           
        }else{
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
    private javax.swing.JTextField JEventID;
    private javax.swing.JButton JHomeButton;
    private com.raven.datechooser.DateChooser dateChooser1;
    private com.raven.datechooser.DateChooser dateChooser2;
    private javax.swing.JButton jAddToTable;
    private javax.swing.JButton jCheckOutButton;
    private javax.swing.JTextField jEquipmentID;
    private javax.swing.JTextField jEventName;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTxtDate;
    private javax.swing.JTextField jTxtReturnDate;
    private javax.swing.JComboBox<String> timePicker1;
    private javax.swing.JComboBox<String> timePicker2;
    // End of variables declaration//GEN-END:variables
    
}
