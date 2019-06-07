/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barpiotr.data;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author PiotrB. CCT - sb17018
 */
public class RecentServiceOfUserDAO extends ElementFromDBRetrievableDAO {
 
    private String vehicleMake;
    private String vehicleModel;
    private String vehicleRegistration;
    private String serviceType;
    private String serviceStatus;
    private String serviceStart;
    private String serviceFinish;
    
    private RecentServiceOfUser tempElement;

    public RecentServiceOfUserDAO(int customerId) {
        super.sql = "SELECT *"
                    + " FROM service s"
                    + " INNER JOIN assigned_to a"
                        + " ON a.serviceId = a.serviceId"
                    + " INNER JOIN vehicle v "
                        + "ON a.vehicleId = v.vehicleId"
                    + " WHERE v.customerId=" + customerId + " "
                    + " AND s.statusName='collected'"
                    + " ORDER BY finish DESC"
                    + " LIMIT 1";
    }
    
    @Override
    public List<ElementFromDBRetrievable> getElementsFromDB(ResultSet myRS) throws Exception{
              
        while(myRS.next()){
            vehicleMake = myRS.getString("vehicleMakeName");
            vehicleModel = myRS.getString("vehicleModelName");
            vehicleRegistration = myRS.getString("registration");
            serviceType = myRS.getString("serviceTypeName");
            serviceStatus = myRS.getString("statusName");
            serviceStart = myRS.getString("start").substring(0, 16);
            serviceFinish = myRS.getString("finish").substring(0, 16);
        
        //create new user object
        tempElement = new RecentServiceOfUser(vehicleMake, vehicleModel, vehicleRegistration, serviceType, serviceStart, serviceFinish, serviceStatus);
        
        //add it to the list of students
        elementList.add(tempElement);
        }
         
    return elementList;
    }
    
    public Map <String, Integer> getElementsMapFromDB(List<ElementFromDBRetrievable>  serviceTypeList) throws Exception{
            
        HashMap mapOfServiceType = new HashMap();
        for (ElementFromDBRetrievable serviceTypeMapped : serviceTypeList){
            //add it to the list of students
            mapOfServiceType.put(((ServiceType)serviceTypeMapped).getName(), ((ServiceType)serviceTypeMapped).getTime());
        }
         
    return mapOfServiceType;
    }
}          
