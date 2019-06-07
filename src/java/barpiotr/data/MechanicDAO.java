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
public class MechanicDAO extends ElementFromDBRetrievableDAO {
 
    private int id;
    private String firstName;
    private String lastName;
    boolean available;
    private Mechanic tempElement;
    
    public MechanicDAO() {
        super.sql = "SELECT * FROM mechanic";
    }
    
    @Override
    public List<ElementFromDBRetrievable> getElementsFromDB(ResultSet myRS) throws Exception{
              
        while(myRS.next()){
            id = myRS.getInt("employeeId");
            firstName = myRS.getString("firstName");
            lastName = myRS.getString("lastName");
            available = myRS.getBoolean("availability");
        
        //create new user object
        tempElement = new Mechanic(id, firstName, lastName, available);
        
        //add it to the list of students
        elementList.add(tempElement);
        }
         
    return elementList;
    }
    
}          
