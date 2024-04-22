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
public class MaintenanceData {
    private String eqID;
    private String eqName;
    private String parentID;
    private String parentName;
    private String description;
    private Timestamp received;
    private Timestamp returned;

    public MaintenanceData(MaintenanceData a) {
        this.eqID = a.getEqID();
        this.eqName = a.getEqName();
        this.parentID = a.getParentID();
        this.parentName = a.getParentName();
        this.description = a.getDescription();
        this.received = a.getReceived();
        this.returned = a.getReturned();
    }
    
    public MaintenanceData(String eqID, String eqName, String parentID, String parentName, String description, Timestamp received, Timestamp returned) {
        this.eqID = eqID;
        this.eqName = eqName;
        this.parentID = parentID;
        this.parentName = parentName;
        this.description = description;
        this.received = received;
        this.returned = returned;
    }

    public String getDescription() {
        return description;
    }

    

    public String getEqID() {
        return eqID;
    }

    public String getEqName() {
        return eqName;
    }

    public String getParentID() {
        return parentID;
    }

    public String getParentName() {
        return parentName;
    }

    public Timestamp getReceived() {
        return received;
    }

    public Timestamp getReturned() {
        return returned;
    }

    @Override
    public String toString() {
        return "MaintenanceData{" + "eqID=" + eqID + ", eqName=" + eqName + ", parentID=" + parentID + ", parentName=" + parentName + ", description=" + description + ", received=" + received + ", returned=" + returned + '}';
    }


}
