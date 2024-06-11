/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database.Validations;

import javax.swing.DefaultCellEditor;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author jazzy-wazzy
 */
public class NonNullCellEditor extends DefaultCellEditor {
    public NonNullCellEditor() {
        super(new JTextField());
    }

    @Override
    public boolean stopCellEditing() {
        String value = (String) getCellEditorValue();
        if (value == null || value.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "This field cannot be null or empty", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return super.stopCellEditing();
    }
}
