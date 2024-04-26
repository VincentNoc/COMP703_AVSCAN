/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package multi.use.frames;

import Database.MaintenanceData;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.text.*;
/**
 *
 * @author dmitr
 */
public class ReturnMaintenance extends javax.swing.JFrame {

    /**
     * Creates new form ReturnMaintenance
     */
    private ConnectCallback connectCallback;
    private ConfirmationCallback callback;
    
    public interface ConnectCallback {

        void onConnect();
    }
     public void setCallback(ConfirmationCallback callback) {
        this.callback = callback;
    }
    
    public interface ConfirmationCallback {

        void onConfirmationReceived(boolean confirmed);
    }
     
    private ReturnMaintenance() {
        initComponents();
    }
    public ReturnMaintenance(MaintenanceData data, ConnectCallback callback) {
        initComponents();
        this.showID.setText(data.getEqID());
        this.showEqName.setText(data.getEqName());
        this.showReceived.setText(String.valueOf(data.getReceived()));
        this.connectCallback = callback;
        createNowTimestamp();
        this.setVisible(true);
    }
    public ReturnMaintenance(MaintenanceData data) {
        initComponents();
        this.showID.setText(data.getEqID());
        this.showEqName.setText(data.getEqName());
        this.showReceived.setText(String.valueOf(data.getReceived()));
        this.showComment.setText("<html>"+data.getDescription()+"</html>");
        createNowTimestamp();
    }

    
    
    public void createNowTimestamp() {
        final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        this.showReturning.setText(format.format(timestamp));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        eqIDLabel = new javax.swing.JLabel();
        eqNameLabel = new javax.swing.JLabel();
        eqRecivedLabel = new javax.swing.JLabel();
        commentLabel = new javax.swing.JLabel();
        showComment = new javax.swing.JLabel();
        returningLabel = new javax.swing.JLabel();
        showReceived = new javax.swing.JLabel();
        showEqName = new javax.swing.JLabel();
        showID = new javax.swing.JLabel();
        showReturning = new javax.swing.JLabel();
        returnButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        eqIDLabel.setText("Equipment ID:");

        eqNameLabel.setText("Equipment Name:");

        eqRecivedLabel.setText("Equipment received:");

        commentLabel.setText("Comment");

        showComment.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        showComment.setText("Show Comment");

        returningLabel.setText("Returning:");

        showReceived.setText("Received");

        showEqName.setText("Name");

        showID.setText("ID");

        showReturning.setText("TImestamp Now");

        returnButton.setText("Return");
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtonActionPerformed(evt);
            }
        });

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(showComment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(commentLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(eqRecivedLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(showReceived))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(eqNameLabel)
                                    .addComponent(eqIDLabel))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(showID)
                                    .addComponent(showEqName)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(returningLabel)
                                    .addGap(18, 18, 18)
                                    .addComponent(showReturning)
                                    .addGap(114, 114, 114))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(backButton)
                                    .addGap(18, 18, 18)
                                    .addComponent(returnButton))))
                        .addGap(0, 113, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eqIDLabel)
                    .addComponent(showID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eqNameLabel)
                    .addComponent(showEqName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eqRecivedLabel)
                    .addComponent(showReceived))
                .addGap(18, 18, 18)
                .addComponent(commentLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(showComment, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(returningLabel)
                    .addComponent(showReturning))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(returnButton)
                    .addComponent(backButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        if (callback != null) {
            callback.onConfirmationReceived(true); // or false based on user action
        }
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed
        // TODO add your handling code here:
        callback.onConfirmationReceived(true);
        this.dispose();
    }//GEN-LAST:event_returnButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ReturnMaintenance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReturnMaintenance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReturnMaintenance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReturnMaintenance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReturnMaintenance().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel commentLabel;
    private javax.swing.JLabel eqIDLabel;
    private javax.swing.JLabel eqNameLabel;
    private javax.swing.JLabel eqRecivedLabel;
    private javax.swing.JButton returnButton;
    private javax.swing.JLabel returningLabel;
    private javax.swing.JLabel showComment;
    private javax.swing.JLabel showEqName;
    private javax.swing.JLabel showID;
    private javax.swing.JLabel showReceived;
    private javax.swing.JLabel showReturning;
    // End of variables declaration//GEN-END:variables
}
