/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.sql.Timestamp;

/**
 *
 * @author dmitr
 */
public class HistoryData {
    private String evID;//not null
    private String evEquipmentID;//FOREIGN KEY not null
    private String EquipmentName;
    private String ParentID;
    private String ParentName;
    private Timestamp eqReturnDateTime;
    private String evCheckOutStaff;//FOREIGN KEY not null

    

    public HistoryData(String evID, String evEquipmentID, String EquipmentName, String ParentID, String ParentName, Timestamp eqReturnDateTime, String evCheckOutStaff) {
        this.evID = evID;
        this.evEquipmentID = evEquipmentID;
        this.EquipmentName = EquipmentName;
        this.ParentID = ParentID;
        this.ParentName = ParentName;
        this.eqReturnDateTime = eqReturnDateTime;
        this.evCheckOutStaff = evCheckOutStaff;
    }
    
    public HistoryData(String evID, String evEquipmentID, String EquipmentName, String ParentID, String ParentName, String eqReturnDateTime, String evCheckOutStaff) {
        this.evID = evID;
        this.evEquipmentID = evEquipmentID;
        this.EquipmentName = EquipmentName;
        this.ParentID = ParentID;
        this.ParentName = ParentName;
        this.eqReturnDateTime = Timestamp.valueOf(eqReturnDateTime);
        this.evCheckOutStaff = evCheckOutStaff;
    }

    public String getEvID() {
        return evID;
    }

    public String getEvEquipmentID() {
        return evEquipmentID;
    }

    public String getEquipmentName() {
        return EquipmentName;
    }

    public String getParentID() {
        return ParentID;
    }

    public String getParentName() {
        return ParentName;
    }

    public String getEvCheckOutStaff() {
        return evCheckOutStaff;
    }

    public Timestamp getEqReturnDateTime() {
        return eqReturnDateTime;
    }

    @Override
    public String toString() {
        return "HistoryData{" + "evID=" + evID + ", evEquipmentID=" + evEquipmentID + ", EquipmentName=" + EquipmentName + ", ParentID=" + ParentID + ", ParentName=" + ParentName + ", evCheckOutStaff=" + evCheckOutStaff + ", eqReturnDateTime=" + eqReturnDateTime + '}';
    }
}
