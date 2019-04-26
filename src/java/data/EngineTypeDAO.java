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
public class EngineTypeDAO extends ElementFromDBRetrievableDAO {
 
    private int id;
    private String name;
    
    private EngineType tempElement;

    public EngineTypeDAO() {
        super.sql = "SELECT * FROM engine_type";
    }
    
    @Override
    public List<ElementFromDBRetrievable> getElementsFromDB(ResultSet myRS) throws Exception{
              
        while(myRS.next()){
            id = myRS.getInt("engineTypeId");
            name = myRS.getString("name");
        
        //create new user object
        tempElement = new EngineType(id, name);
        
        //add it to the list of students
        elementList.add(tempElement);
        }
         
    return elementList;
    }
    
}          
