/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author PiotrB. CCT - sb17018
 */
public class ServiceTypeDAO extends ElementFromDBRetrievableDAO {
 
    private int id;
    private String name;
    private int time;
    private int cost;
    private ServiceType tempElement;

    public ServiceTypeDAO() {
        super.sql = "SELECT * FROM service_type";
    }
    
    @Override
    public List<ElementFromDBRetrievable> getElementsFromDB(ResultSet myRS) throws Exception{
              
        while(myRS.next()){
            id = myRS.getInt("serviceTypeId");
            name = myRS.getString("name");
            time = myRS.getInt("time");
            cost = myRS.getInt("cost");
        
        //create new user object
        tempElement = new ServiceType(id, name, time, cost);
        
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
