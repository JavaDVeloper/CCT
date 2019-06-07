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
public class VehicleModelDAO extends ElementFromDBRetrievableDAO {
 
    private int id;
    private String name;
    private String make;
    private String type;
    
    private VehicleModel tempElement;

    public VehicleModelDAO() {
        super.sql = "SELECT * FROM vehicle_model";
    }
   
    @Override
    public List<ElementFromDBRetrievable> getElementsFromDB(ResultSet myRS) throws Exception{
              
        while(myRS.next()){
            name = myRS.getString("vehicleModelName");
            make = myRS.getString("vehicleMakeName");
            type = myRS.getString("vehicleTypeName");
        
        //create new user object
        tempElement = new VehicleModel(name, make, type);
        
        //add it to the list of students
        elementList.add(tempElement);
        }   
    return elementList;
    }
    
}          
