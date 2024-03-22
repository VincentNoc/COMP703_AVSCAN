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
    private String evName;
    private String evEquipmentID;//FOREIGN KEY not null
    private String EquipmentName;
    private String ParentID;
    private String ParentName;
    private String evCheckOutStaff;//FOREIGN KEY not null
    private Timestamp eqReturnDateTime;

    public HistoryData(String evID, String evName, String evEquipmentID, String EquipmentName, String ParentID, String ParentName, String evCheckOutStaff, Timestamp eqReturnDateTime) {
        this.evID = evID;
        this.evName = evName;
        this.evEquipmentID = evEquipmentID;
        this.EquipmentName = EquipmentName;
        this.ParentID = ParentID;
        this.ParentName = ParentName;
        this.evCheckOutStaff = evCheckOutStaff;
        this.eqReturnDateTime = eqReturnDateTime;
    }

    public String getEvID() {
        return evID;
    }

    public String getEvName() {
        return evName;
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
        return "HistoryData{" + "evID=" + evID + ", evName=" + evName + ", evEquipmentID=" + evEquipmentID + ", EquipmentName=" + EquipmentName + ", ParentID=" + ParentID + ", ParentName=" + ParentName + ", evCheckOutStaff=" + evCheckOutStaff + ", eqReturnDateTime=" + eqReturnDateTime + '}';
    }

   
       
}
