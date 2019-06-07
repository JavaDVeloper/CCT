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
public class VehicleOfUserDAO extends ElementFromDBRetrievableDAO {

    private int id;
    private String registration;
    private String colour;
    private int customerId;
    private String vehicleMakeName;
    private String vehicleModelName;
    private String engineTypeName;
    private String vehicleTypeName;

    Vehicle tempElement;

    public VehicleOfUserDAO(int customerId) {
        super.sql = "SELECT DISTINCT v.vehicleId, registration, colour, customerId, vehicleMakeName,"
                + " vehicleModelName, engineTypeName, vehicleTypeName"
                + " FROM vehicle v"
                + " INNER JOIN assigned_to a "
                + "ON v.vehicleId = a.vehicleId"
                + " INNER JOIN service s "
                + "ON a.serviceId = s.serviceId"
                + " WHERE v.customerId=" + customerId + " AND s.statusName='collected'"
                + " HAVING COUNT(DISTINCT s.statusName)=1";
    }

    @Override
    public List<ElementFromDBRetrievable> getElementsFromDB(ResultSet myRS) throws Exception {

        while (myRS.next()) {
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
