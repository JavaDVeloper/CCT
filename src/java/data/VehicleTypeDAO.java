/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author PiotrB. CCT - sb17018
 */
public class VehicleTypeDAO extends ElementFromDBRetrievableDAO {
 
    private int id;
    private String name;
    private VehicleType tempElement;

    public VehicleTypeDAO() {
        super.sql = "SELECT * FROM vehicle_type";
    }
    
    @Override
    public List<ElementFromDBRetrievable> getElementsFromDB(ResultSet myRS) throws Exception{
              
        while(myRS.next()){
            id = myRS.getInt("vehicleTypeId");
            name = myRS.getString("name");
        
        //create new user object
        tempElement = new VehicleType(id, name);
        
        //add it to the list of students
        elementList.add(tempElement);
        }
         
    return elementList;
    }
    
}          
