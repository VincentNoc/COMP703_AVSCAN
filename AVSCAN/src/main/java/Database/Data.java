/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

/**
 *
 * @author dmitr
 */
public class Data {
    private String equipmentID = "";
    private String equipmentName= "";
    private String equipmentType= "";
    private String equipmentParent = "";
    
    public Data(){}
    
    public Data(String equipmentID, String equipmentName, String equipmentType, String eqyipmentParent){
        this.equipmentID=equipmentID;
        this.equipmentName=equipmentName;
        this.equipmentType = equipmentType;
        this.equipmentParent = equipmentParent;
    }
    
    public Data(String equipmentID, String equipmentName, String equipmentType){
        this.equipmentID=equipmentID;
        this.equipmentName=equipmentName;
        this.equipmentType = equipmentType;
    }

    public Data(Data data){
        this.equipmentID = data.getEquipmentID();
        this.equipmentName = data.getEquipmentName();
        this.equipmentType = data.getEquipmentType();
        this.eqyipmentParent = data.getEqyipmentParent();
    public String getEquipmentParent() {
        return equipmentParent;
    }
    
    @Override
    public String toString() {
        return "Data{" + "equipmentID=" + equipmentID + ", equipmentName=" + equipmentName + ", equipmentType=" + equipmentType + ", eqyipmentParent=" + equipmentParent + '}';
    }
    
    
        // Getter methods
    public String getEquipmentID() {
        return equipmentID;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public String getEqyipmentParent() {
        return eqyipmentParent;
    }
    
    public String getEquipmentType() {
        return equipmentType;
    }
    
    
}
