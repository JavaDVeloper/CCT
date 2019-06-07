/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barpiotr.data;

import java.io.Serializable;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author PiotrB. CCT - sb17018
 */
public class BookedSlotAtGivenHourDAO_TEST extends ElementFromDBRetrievableDAO_TEST{
    
    private int employeeId;
    private int serviceId;
    private int vehicleId;
    private LocalDateTime start;
    private LocalDateTime finish;

    private BookedSlotAtGivenHour tempElement;

    public BookedSlotAtGivenHourDAO_TEST(Integer serviceTime, LocalDateTime checkedTimeSlot){
        super.sql = "SELECT * FROM assigned_to WHERE start <= '" + checkedTimeSlot +
                "' AND finish > '" + checkedTimeSlot.plusHours(serviceTime) + "'";
    }
    
    @Override
    public List<ElementFromDBRetrievable> getElementsFromDB(ResultSet myRS) throws Exception{
              
        while(myRS.next()){
            employeeId = myRS.getInt("employeeId");
            serviceId = myRS.getInt("serviceId");
            vehicleId = myRS.getInt("vehicleId");
            start = LocalDateTime.parse((myRS.getString("start")).replace(" ","T"));
            finish = LocalDateTime.parse((myRS.getString("finish")).replace(" ","T"));
        
        //create new user object
        tempElement = new BookedSlotAtGivenHour (employeeId, serviceId, vehicleId, start, finish);
        
        //add it to the list of students
        elementList.add(tempElement);
        }
         
    return elementList;
    }  
}          
