/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avscan;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author dmitr
 */
public class NewEq {
    private int width;
    private int height;
    
    private JFrame frame;
    private JLabel[] inuptLabels;
    private JTextField[] inputField;
    private JScrollPane showInfo;
    
    public static void main(String[] args) {//Just to start the page
        new NewEq();
    }
    
    public NewEq(){
        
        creatingFrame();
    }
    
    private void creatingFrame(){
        this.frame = new JFrame("New Equipment");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        GraphicsDevice g = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        width = g.getDisplayMode().getWidth()+14;
        height = g.getDisplayMode().getHeight()-33;
        System.out.println("width = "+ width+"AND height = "+this.height);
        this.frame.setBounds(-7, 0, width, height);
        
        creatingInputPanels();
        addedEqPannel();
        
        JPanel temp = new JPanel();
        this.frame.add(temp);
        
//        frame.getContentPane().add(showInfo, BorderLayout.CENTER);
        this.frame.setResizable(false);
        this.frame.setVisible(true);
    }
    
    private void creatingInputPanels(){
        this.inuptLabels = new JLabel[3];
        this.inputField = new JTextField[3];
        String[] inputHeaders ={"Equipment ID", "Equipment Name", "Equipment Type"};
        
        for(int i =0; i<3;i++){
                    //.setBounds(x, y, width, height);
            this.inuptLabels[i] = new JLabel(inputHeaders[i]);
            this.inuptLabels[i].setBounds(i*600+50, i+10, 285, 35);
            this.inputField[i] = new JTextField();
            this.inputField[i].setBounds(i*600+50, i+50, 330, 35);
            System.out.println("inputField["+i+"].setBounds("+(i*600+50)+", "+(i+50)+", "+285+", "+35+")");
            
            this.frame.add(this.inuptLabels[i]);
            this.frame.add(this.inputField[i]);
            
        }
    }
    
    private void addedEqPannel() {

        // Create a table model with three columns
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Name");
        tableModel.addColumn("ID");
        tableModel.addColumn("Close");

        // Add some sample data
        for (int i = 0; i<100;i++){
            tableModel.addRow(new Object[]{"Data "+i+"A","Data "+i+"B", "Close"});
        }
        tableModel.addRow(new Object[]{"Data 1A", "Data 1B", "Button 1"});
        tableModel.addRow(new Object[]{"Data 2A", "Data 2B", "Button 2"});
        tableModel.addRow(new Object[]{"Data 3A", "Data 3B", "Button 3"});

        // Create a JTable with the model
        JTable table = new JTable(tableModel);

        // Set the size of the table
        table.setBounds(50, 300, 1000, 200);

        // Create a button column renderer
        TableColumn buttonColumn = table.getColumn("Close");
        buttonColumn.setCellRenderer(new ButtonRenderer());

        // Add action listener to the button column
        buttonColumn.setCellEditor(new ButtonEditor(new JTextField(), table));

        // Create a JScrollPane and add the table to it
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 300, this.width-155, 200);

        // Add the scroll pane to the frame
        frame.add(scrollPane);

    }

    // Custom renderer for the button column
    static class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                       boolean hasFocus, int row, int column) {
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }

    // Custom editor for the button column
    static class ButtonEditor extends DefaultCellEditor {
        private JButton button;
        private JTable table;

        public ButtonEditor(JTextField textField, JTable table) {
            super(textField);
            this.table= table;
            button = new JButton();
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Handle button click event
                    JOptionPane.showMessageDialog(null, "Button clicked in row " + table.getSelectedRow());
                }
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            button.setText((value == null) ? "" : value.toString());
            return button;
        }
    }
    
}
