/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barpiotr.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;

/**
 *
 * @author PiotrB. CCT - sb17018
 */
public class ServiceTypeDAO_TEST extends ElementFromDBRetrievableDAO_TEST {
 
    private int id;
    private String name;
    private int time;
    private int cost;
    private ServiceType tempElement;

    public ServiceTypeDAO_TEST() {
        super.sql = "SELECT * FROM service_type";
    }
    
    @Override
    public List<ElementFromDBRetrievable> getElementsFromDB(ResultSet myRS) throws Exception{
              
        while(myRS.next()){
            name = myRS.getString("serviceTypeName");
            time = myRS.getInt("time");
            cost = myRS.getInt("cost");
        
        //create new user object
        tempElement = new ServiceType(name, time, cost);
        
        //add it to the list of students
        elementList.add(tempElement);
        }     
    
    return elementList;
    }
    
    public Map<String, Integer> getElementsTimeMappedFromDB(Connection myConn, String sql) throws Exception {
        Map<String, Integer> mapOfServiceTypeTime = new HashMap<>();
        List<ElementFromDBRetrievable> serviceTypeList = getElementFromDBList(myConn, sql);
        for (ElementFromDBRetrievable serviceTypeMapped : serviceTypeList) {
            //add it to the list of students
            mapOfServiceTypeTime.put(((ServiceType)serviceTypeMapped).getName(), ((ServiceType)serviceTypeMapped).getTime());
        }

        return mapOfServiceTypeTime;
    }
}          
