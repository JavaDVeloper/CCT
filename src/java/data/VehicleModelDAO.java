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
public class VehicleModelDAO extends ElementFromDBRetrievableDAO {
 
    private int id;
    private String name;
    private int makeId;
    private int typeId;
    
    private VehicleModel tempElement;

    public VehicleModelDAO() {
        super.sql = "SELECT * FROM vehicle_model";
    }
   
    @Override
    public List<ElementFromDBRetrievable> getElementsFromDB(ResultSet myRS) throws Exception{
              
        while(myRS.next()){
            id = myRS.getInt("modelId");
            name = myRS.getString("name");
            makeId = myRS.getInt("makeId");
            typeId = myRS.getInt("typeId");
        
        //create new user object
        tempElement = new VehicleModel(id, name, makeId, typeId);
        
        //add it to the list of students
        elementList.add(tempElement);
        }   
    return elementList;
    }
    
}          
