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
public class ServiceStatusDAO_TEST extends ElementFromDBRetrievableDAO_TEST {
 
    private String name;
    
    ServiceStatus tempElement;

    public ServiceStatusDAO_TEST() {
        super.sql = "SELECT * FROM status";
    }
    
    @Override
    public List<ElementFromDBRetrievable> getElementsFromDB(ResultSet myRS) throws Exception{
              
        while(myRS.next()){
            name = myRS.getString("statusName");
        
        //create new user object
        tempElement = new ServiceStatus(name);
        
        //add it to the list of students
        elementList.add(tempElement);
        }
         
    return elementList;
    }
    
}          
