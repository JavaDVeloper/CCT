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
public class VehicleOfUserDAO_TEST extends ElementFromDBRetrievableDAO_TEST{
 
    private int id;
    private String registration;
    private String colour;
    private int customerId;
    private String vehicleMakeName;
    private String vehicleModelName;
    private String engineTypeName;
    private String vehicleTypeName;
    
    Vehicle tempElement;
    
    public VehicleOfUserDAO_TEST(int customerId) {
        super.sql = "SELECT * FROM vehicle v WHERE v.customerId=" + customerId;
//        super.sql = "SELECT *"
//                    + " FROM service s"
//                    + " INNER JOIN assigned_to a"
//                        + " ON s.serviceId = a.serviceId"
//                    + " INNER JOIN vehicle v "
//                        + "ON a.vehicleId = v.vehicleId"
//                    + " WHERE v.customerId=" + customerId + " AND s.statusName='collected'";
    }
    
    @Override
    public List<ElementFromDBRetrievable> getElementsFromDB(ResultSet myRS) throws Exception{
              
        while(myRS.next()){
            id = myRS.getInt("vehicleId");
            registration = myRS.getString("registration");
            colour = myRS.getString("colour");
            customerId = myRS.getInt("registration");
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

    @Override
    public String toString() {
        return "VehicleOfUserDAO_TEST{" + "id=" + id + ", registration=" + registration + ", colour=" + colour + ", customerId=" + customerId + ", vehicleMakeName=" + vehicleMakeName + ", vehicleModelName=" + vehicleModelName + ", engineTypeName=" + engineTypeName + ", vehicleTypeName=" + vehicleTypeName + ", tempElement=" + tempElement + '}';
    }
    
    
}          
