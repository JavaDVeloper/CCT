/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barpiotr.data;

import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author PiotrB. CCT - sb17018
 */
public class VehicleMakeDAO extends ElementFromDBRetrievableDAO{
 
    private int id;
    private String name;
    private VehicleMake tempElement;
    
    public VehicleMakeDAO() {
        super.sql = "SELECT * FROM vehicle_make";
    }
    
    @Override
    public List<ElementFromDBRetrievable> getElementsFromDB(ResultSet myRS) throws Exception{
              
        while(myRS.next()){
            name = myRS.getString("vehicleMakeName");
        
        //create new user object
        tempElement = new VehicleMake(name);
        
        //add it to the list of students
        elementList.add(tempElement);
        }
         
    return elementList;
    }
    
}          
