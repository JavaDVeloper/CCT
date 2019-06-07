/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barpiotr.util;

import barpiotr.data.ElementFromDBRetrievable;
import barpiotr.data.PendingServiceOfUserDAO;
import barpiotr.data.RecentServiceOfUserDAO;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;

/**
 *
 * @author PiotrB. CCT - sb17018
 */
public class GetUserServicesToDisplayExe {

    private int userId;

    private CheckIfUserExistsInDBaseExe checkUser;

    private UsersServicesToDisplay userServicesData;
    private String userServiceTableLabel;

    private PendingServiceOfUserDAO usersPendingServices;
    private List<ElementFromDBRetrievable> usersServiceListToDisplay;
    private RecentServiceOfUserDAO usersRecentServices;
    private List<ElementFromDBRetrievable> recentServicesList;

    public GetUserServicesToDisplayExe(Map<String, String[]> userParam) {
        checkUser = new CheckIfUserExistsInDBaseExe(userParam);
    }

    //to get user's user's service(s) (one the most recent if all completed OR all pending);
    public UsersServicesToDisplay getUserServicesData(DataSource dataSource) throws Exception {
        userId = checkUser.getCustomer(dataSource).getId();
        usersPendingServices = new PendingServiceOfUserDAO(userId);
        usersServiceListToDisplay = usersPendingServices.getElementFromDBList(dataSource, usersPendingServices.sql);
        userServiceTableLabel = "pending";
        //if none service is pending returns recent unrepairable/completed/collected
        if (usersServiceListToDisplay.size() == 0) {
            //to get user's the most recent service
            usersRecentServices = new RecentServiceOfUserDAO(userId);
            recentServicesList = usersRecentServices.getElementFromDBList(dataSource, usersRecentServices.sql);
            usersServiceListToDisplay = recentServicesList;
            userServiceTableLabel = "recent";
        }

        userServicesData = new UsersServicesToDisplay(usersServiceListToDisplay, userServiceTableLabel);
        return userServicesData;
    }
}
