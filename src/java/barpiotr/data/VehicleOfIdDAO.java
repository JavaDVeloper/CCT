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
public class VehicleOfIdDAO extends ElementFromDBRetrievableDAO{
 
    private int id;
    private String registration;
    private String colour;
    private int customerId;
    private String vehicleMakeName;
    private String vehicleModelName;
    private String engineTypeName;
    private String vehicleTypeName;
    
    Vehicle tempElement;
    
    public VehicleOfIdDAO(String vehicleId) {
        
        try{
            id = Integer.parseInt(vehicleId);
        }
        catch(Exception e){
            
        }
        super.sql = "SELECT * FROM vehicle v WHERE v.vehicleId=" + id;

    }
    
    @Override
    public List<ElementFromDBRetrievable> getElementsFromDB(ResultSet myRS) throws Exception{
              
        while(myRS.next()){
            id = myRS.getInt("vehicleId");
            registration = myRS.getString("registration");
            colour = myRS.getString("colour");
            customerId = myRS.getInt("customerId");
            vehicleMakeName = myRS.getString("vehicleMakeName");
            vehicleModelName = myRS.getString("vehicleModelName");
            engineTypeName = myRS.getString("engineTypeName");
            vehicleTypeName = myRS.getString("vehicleTypeName");
        
        //create new user object
        tempElement = new Vehicle(id, registration, colour, customerId, vehicleMakeName, vehicleModelName, engineTypeName, vehicleTypeName);
        
        //add it to the list of students
        elementList.add(tempElement);
        }
         
    return elementList;
    }
    
}          
