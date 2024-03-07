/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

/**
 *
 * @author vince-kong
 */
public class Data {
    public String EquipmentID = "";
    public String EquipmentName= "";
    public String EquipmentType="";
    
    public Data(){};
    
    public Data(String EquipmentID, String EquipmentName, String EquipmentType){
        this.EquipmentID = EquipmentID;
        this.EquipmentName = EquipmentName;
        this.EquipmentType = EquipmentType; 
    }
    
    
}