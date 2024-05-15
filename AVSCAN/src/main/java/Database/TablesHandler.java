/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.sql.Timestamp;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 *
 * @author dmitr
 */
// that class crated to sort MaintenanceData data by java languge.
// Now everything is sorting by SQL so current class not in use.
//Might be needed later to sort by java
public class TablesHandler { 
    private Hashtable<String, MaintenanceData> IDType;
    private Hashtable<String, MaintenanceData> nameType;
    private Hashtable<Timestamp, MaintenanceData> receivedType;
    private Hashtable<Timestamp, MaintenanceData> returnedType;
    
    

    public TablesHandler(List <MaintenanceData> IDType) {
        //add methods
        createIDTypeTable(IDType);
    }
    
    
    
    private void createIDTypeTable(List<MaintenanceData> importat){
        IDType = new Hashtable<String, MaintenanceData>();
        for(MaintenanceData a: importat){
            IDType.put(a.getEqID(), a);
        }
    }
    
     private void createNameTypeTable(List<MaintenanceData> importat){
        nameType = new Hashtable<String, MaintenanceData>();
        for(MaintenanceData a: importat){
            nameType.put(a.getEqName(), a);
        }
    }
     
    private void createReceivedTypeTable(List<MaintenanceData> importat){
        receivedType = new Hashtable<Timestamp, MaintenanceData>();
        for(MaintenanceData a: importat){
            receivedType.put(a.getReceived(), a);
        }
    }
    
    private void createReturnedTypeTable(List<MaintenanceData> importat){
        returnedType = new Hashtable<Timestamp, MaintenanceData>();
        for(MaintenanceData a: importat){
            returnedType.put(a.getReturned(), a);
        }
    }
}
