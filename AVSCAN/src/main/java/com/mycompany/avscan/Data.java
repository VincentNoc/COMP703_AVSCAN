/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avscan;

/**
 *
 * @author dmitr
 */
public class Data {
    private String equipmentID = "";
    private String equipmentName= "";
    private String equipmentType= "";

    
    public Data(String equipmentID, String equipmentName, String equipmentType){
        this.equipmentID=equipmentID;
        this.equipmentName=equipmentName;
        this.equipmentType = equipmentType;
        
    }
    
        // Getter methods
    public String getEquipmentID() {
        return equipmentID;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public String getEquipmentType() {
        return equipmentType;
    }
    
    
}
