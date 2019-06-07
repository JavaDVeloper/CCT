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
public class CustomerOfIdDAO extends ElementFromDBRetrievableDAO {
 
    private int id;
    private String firstName;
    private String lastName;
    private String login;
    private int phone;
    private String password;
    
    private Customer tempElement;
    
    public CustomerOfIdDAO(String customerId) {
        super.sql = "SELECT * FROM customer WHERE customerId ='" + customerId + "'";
    }
    
    @Override
    public List<ElementFromDBRetrievable> getElementsFromDB(ResultSet myRS) throws Exception{
              
        while(myRS.next()){
            id = myRS.getInt("customerId");
            firstName = myRS.getString("firstName");
            lastName = myRS.getString("lastName");
            login = myRS.getString("email");
            phone = myRS.getInt("phone");
            password = myRS.getString("password");
        
        //create new user object
        tempElement = new Customer(id, firstName, lastName, login, phone, password);
        
        //add it to the list of students
        elementList.add(tempElement);
        }
         
    return elementList;
    }  
}          
