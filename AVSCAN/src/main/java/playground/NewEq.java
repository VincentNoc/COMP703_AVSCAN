/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package playground;

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
    //private JPanel page;

    //private JPanel inputArea;
    //private JPanel inputSection[];
    private JLabel[] inuptLabels;
    private JTextField[] inputField;
    private JScrollPane showInfo;

    private JTable table;
    private TableColumn buttonColumn;
    private JScrollPane scrollPane;

    // private JPanel buttons;
    private JButton controls[];

    ;
    
    public static void main(String[] args) {//Just to start the page
        new NewEq();
    }

    public NewEq() {

        creatingFrame();
    }

    private void creatingFrame() {
        /*this.page = new JPanel();
        this.page.setLayout(new BoxLayout(page, BoxLayout.Y_AXIS));*/
        this.frame = new JFrame("New Equipment");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GraphicsDevice g = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        width = g.getDisplayMode().getWidth() + 14;
        height = g.getDisplayMode().getHeight() - 32;
        System.out.println("width = " + width + "AND height = " + this.height);
        this.frame.setBounds(-7, 0, width, height);
        //this.page.setPreferredSize(new Dimension(width, height));

        creatingInputs();
        addedEqPannel();
        addingButtons();

        JPanel temp = new JPanel();
        this.frame.add(temp);

        this.frame.setResizable(false);
        this.frame.setVisible(true);
    }

    private void creatingInputs() {
        
        this.inuptLabels = new JLabel[3];
        this.inputField = new JTextField[3];
        String[] inputHeaders = {"Equipment ID", "Equipment Name", "Equipment Type"};

        for (int i = 0; i < 3; i++) {
            //.setBounds(x, y, width, height);
            this.inuptLabels[i] = new JLabel(inputHeaders[i]);
            this.inuptLabels[i].setBounds(i * 600 + 50, 10, 285, 35);
            this.inputField[i] = new JTextField();
            this.inputField[i].setBounds(i * 600 + 50, i + 50, 330, 35);
            System.out.println("inputField[" + i + "].setBounds(" + (i * 600 + 50) + ", " + (i + 50) + ", " + 285 + ", " + 35 + ")");

            /*this.inputSection[i] = new JPanel();
            this.inputSection[i].setLayout(new BoxLayout(inputSection[i], BoxLayout.Y_AXIS));
            this.inputSection[i].add(inuptLabels[i]);
            this.inputSection[i].add(inputField[i]);
            this.inputSection[i].setBorder(BorderFactory.createLineBorder(Color.RED));*/
 /*this.inputArea.add(inuptLabels[i]);
            this.inputArea.add(this.inputField[i]);*/
            this.frame.add(this.inuptLabels[i]);
            this.frame.add(this.inputField[i]);

        }
        /*this.inputArea.add(inputSection[0], BorderLayout.WEST);
        this.inputArea.add(inputSection[1], BorderLayout.CENTER);
        this.inputArea.add(inputSection[2], BorderLayout.EAST);
        this.inputArea.setPreferredSize(new Dimension(width,10));
        this.page.add(inputArea);*/
        //this.frame.add(inputArea);
    }

    private void addedEqPannel() {
        // Create a table model with three columns
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Name");
        tableModel.addColumn("ID");
        tableModel.addColumn("Delete");
        //tableModel.addColumn(new JButton("Delete"));

        // Add some sample data
        for (int i = 0; i < 100; i++) {
            tableModel.addRow(new Object[]{"Data " + i + "A", "Data " + i + "B", "Delete"});
        }

        // Create a JTable with the model
        table = new JTable(tableModel);

        // Set the size of the table
        table.setBounds(50, 300, 1000, 200);

        // Create a button column renderer
        buttonColumn = table.getColumn("Delete");
        buttonColumn.setCellRenderer(new ButtonRenderer());

        // Add action listener to the button column
        buttonColumn.setCellEditor(new ButtonEditor(new JTextField(), table, tableModel));

        // Create a JScrollPane and add the table to it
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 300, this.width - 155, 200);

        // Add the scroll pane to the frame
        frame.add(scrollPane);
        //this.page.add(scrollPane);
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
        private DefaultTableModel tableModel;

        public ButtonEditor(JTextField textField, JTable table, DefaultTableModel tableModel) {
            super(textField);
            this.table = table;
            this.tableModel = tableModel;
            button = new JButton();
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Handle button click event
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        tableModel.removeRow(selectedRow);
                    }
                }
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            button.setText((value == null) ? "" : value.toString());
            return button;
        }
    }

    private void addingButtons() {
        String buttonText[] = {"Home", "Add", "Format"};
        this.controls = new JButton[3];
        /*this.buttons = new JPanel();
        this.buttons.add(home);
        this.buttons.add(addButton);
        this.buttons.add(format);
        this.buttons.setLocation(400, 400);
        this.page.add(buttons);*/

        for (int i = 0; i < 3; i++) {
            controls[i]= new JButton(buttonText[i]);
            this.controls[i].setBounds(i * 600 + 50, 900, 330, 35);
            this.frame.add(controls[i]);
        }
    }
}
