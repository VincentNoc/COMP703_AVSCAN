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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author mdd2557
 */
public class SmallErrorMessage implements ActionListener{
    private JLabel testLabel;
    private JFrame myFrame = new JFrame(); 
    private JButton okBut = new JButton("Ok");
    
    public SmallErrorMessage(String message){
        testLabel = new JLabel("<html><p>"+message+"</p></html>", SwingConstants.CENTER);
        intiErrorFrame();
    }
    
    private void intiErrorFrame(){
             
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setBackground(Color.red);
                
        //myFrame.setSize(new Dimension(400, 1000));       
        myFrame.setLocationRelativeTo(null);
        
        JPanel groupPanel = new JPanel();
        myFrame.add(groupPanel);
        
        groupPanel.setLayout(new BoxLayout(groupPanel, BoxLayout.Y_AXIS));
        groupPanel.setBackground(Color.green);  

        JPanel itemPanel = new JPanel();
        groupPanel.add(itemPanel);
        
        JPanel buttonPan = new JPanel();
        
        okBut.addActionListener(this);
        buttonPan.add(okBut);
        groupPanel.add(buttonPan);
        
        itemPanel.setLayout(new GridLayout(1,1));
        
        /*String msg = "<html><p>This is going to be a really long message that says a lot of words but doesnt really say anything. ";
        msg += "We want label containing the message (and the itemPanel that contains it) to always have as much height as necessary ";
        msg += "to display the message given the width of the frame</p></html>";*/
        
        //testLabel = new JLabel(msg, SwingConstants.CENTER);
        testLabel.setOpaque(true);
        
        itemPanel.setPreferredSize(new Dimension(400, 64));
        itemPanel.setMinimumSize(new Dimension(400, 64));
        itemPanel.setMaximumSize(new Dimension(400, 64));
        
        itemPanel.add(testLabel);
        
        myFrame.pack();
        myFrame.setVisible(true);
    }
    
    public static void main(String[] args) {
        new SmallErrorMessage("Sooooo Loooong Eeeeerrrooor Meeeeessssaaaggeee");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==okBut){
            this.myFrame.dispatchEvent(new WindowEvent(myFrame, WindowEvent.WINDOW_CLOSING));
        }
    }
}
