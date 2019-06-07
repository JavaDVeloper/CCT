/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barpiotr.util;

import barpiotr.data.ElementFromDBRetrievable;
import barpiotr.data.VehicleOfUserDAO;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;

/**
 *
 * @author PiotrB. CCT - sb17018
 */
public class GetUserVehiclesToDisplayExe {

    private int userId;

    VehicleOfUserDAO userVehicles;

    private List<ElementFromDBRetrievable> usersVehiclesList;

    public GetUserVehiclesToDisplayExe(String userId) {
        this.userId = Integer.parseInt(userId);
    }

    //to get user's user's service(s) (one the most recent if all completed OR all pending);
    public Object getUsersVehiclesData(DataSource dataSource) throws Exception {
        userVehicles = new VehicleOfUserDAO(userId);
        usersVehiclesList = userVehicles.getElementFromDBList(dataSource, userVehicles.sql);
       
        return usersVehiclesList;
    
    }
}
