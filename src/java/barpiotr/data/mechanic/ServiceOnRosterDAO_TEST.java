/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barpiotr.data.mechanic;

import barpiotr.data.ElementFromDBRetrievable;
import barpiotr.data.ElementFromDBRetrievableDAO;
import barpiotr.data.ElementFromDBRetrievableDAO_TEST;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author PiotrB. CCT - sb17018
 */
public class ServiceOnRosterDAO_TEST extends ElementFromDBRetrievableDAO_TEST {

    private String serviceId;
    private String serviceStart;
    private String serviceFinish;
    private String serviceType;
    private String serviceStatus;
    private String mechanicFirstName;
    private String mechanicLastName;
    private String vehicleMake;
    private String vehicleModel;
    private String vehicleType;
    private String engineType;
    private String registration;
    private String vehicleColor;

    ServiceOnRoster tempElement;

    public ServiceOnRosterDAO_TEST() {
        super.sql = "SELECT * FROM mechanic m"
                + " INNER JOIN assigned_to a"
                + " ON m.employeeId=a.employeeId"
                + " INNER JOIN service s "
                + " ON a.serviceId=s.serviceId"
                + " INNER JOIN vehicle v"
                + " ON a.vehicleId=v.vehicleId"
                + " WHERE NOT statusName='collected' AND CAST(start AS DATE)='2019-05-13'";
    }

    public ServiceOnRosterDAO_TEST(LocalDate scheduledDay) {
        super.sql = "SELECT * FROM assigned_to a"
                + " INNER JOIN mechanic m"
                + " ON m.employeeId = a.employeeId"
                + " INNER JOIN service s "
                + " ON a.serviceId = s.serviceId"
                + " INNER JOIN vehicle v "
                + " ON a.vehicleId = v.vehicleId"
                + " WHERE NOT statusName='collected' AND CAST(start AS DATE)= '" + scheduledDay + "'";

        System.out.println(sql);
    }

    @Override
    public List<ElementFromDBRetrievable> getElementsFromDB(ResultSet myRS) throws Exception {

        int count = 0;
        while (myRS.next()) {
            count++;
            serviceId = String.valueOf(myRS.getInt("serviceId"));
            serviceStart = myRS.getString("start");
            serviceFinish = myRS.getString("finish");
            serviceType = myRS.getString("serviceTypeName");
            serviceStatus = myRS.getString("statusName");
            mechanicFirstName = myRS.getString("firstName");
            mechanicLastName = myRS.getString("lastName");
            vehicleMake = myRS.getString("vehicleMakeName");
            vehicleModel = myRS.getString("vehicleModelName");
            vehicleType = myRS.getString("vehicleTypeName");
            engineType = myRS.getString("engineTypeName");
            registration = myRS.getString("registration");
            vehicleColor = myRS.getString("colour");

            tempElement = new ServiceOnRoster(serviceId, serviceStart, serviceFinish, serviceType, serviceStatus, mechanicFirstName, mechanicLastName, vehicleMake, vehicleModel, vehicleType, engineType, registration, vehicleColor);
            System.out.println("Temp element: "+tempElement);
            //add it to the list of students
            elementList.add(tempElement);
        }
        System.out.println("Count: " + count);
        return elementList;
    }
}
