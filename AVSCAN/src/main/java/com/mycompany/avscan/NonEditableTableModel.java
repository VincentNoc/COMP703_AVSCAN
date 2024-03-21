/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avscan;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vince-kong
 */
public class NonEditableTableModel extends DefaultTableModel {
     // Override isCellEditable method to make all cells non-editable
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}
