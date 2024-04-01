/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avscan;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author mdd2557
 * 
 * That file create a small error message with ok button
 */
//!!!Error Message VERSION 2.0.0
//all classes that use older version of SmallErrorMessage class need to be addapted
public class SmallErrorMessage extends JDialog implements ActionListener{
    private JLabel testLabel;
    //private JFrame myFrame = new JFrame(); 
    private JButton okBut = new JButton("Ok");
    
    //Just use -> new SmallErrorMessage("Error message");//to call or create error message frame
    public SmallErrorMessage(String message, JFrame parentFrame){//!!!VERSION 2.0.0
        super(parentFrame, true);
        setLocationRelativeTo(parentFrame);
        setTitle("Error");
        
        testLabel = new JLabel("<html><p>"+message+"</p></html>", SwingConstants.CENTER);
        initErrorFrame();
        //setVisible(true); // Move setVisible here
        //okBut.requestFocusInWindow();
    }
    
    private void initErrorFrame() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBackground(Color.RED);
                
        JPanel groupPanel = new JPanel();
        add(groupPanel);
        
        groupPanel.setLayout(new BoxLayout(groupPanel, BoxLayout.Y_AXIS));
        groupPanel.setBackground(Color.GREEN);  

        JPanel itemPanel = new JPanel();
        groupPanel.add(itemPanel);
        
        JPanel buttonPan = new JPanel();
        
        okBut.addActionListener(this);
        buttonPan.add(okBut);
        groupPanel.add(buttonPan);
        
        itemPanel.setLayout(new GridLayout(1, 1));
        
        testLabel.setOpaque(true);
        
        itemPanel.setPreferredSize(new Dimension(400, 64));
        itemPanel.setMinimumSize(new Dimension(400, 64));
        itemPanel.setMaximumSize(new Dimension(400, 64));
        
        itemPanel.add(testLabel);
        
        pack();
    }
    
    public static void main(String[] args) {
        new SmallErrorMessage("Sooooo Loooong Eeeeerrrooor Meeeeessssaaaggeee", new JFrame());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==okBut){
            //this.myFrame.dispatchEvent(new WindowEvent(myFrame, WindowEvent.WINDOW_CLOSING));
            dispose();
        }
    }
}
