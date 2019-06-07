/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barpiotr.util;

import barpiotr.data.ElementFromDBRetrievable;
import java.util.List;

/**
 *
 * @author PiotrB. CCT - sb17018
 */
public class UsersServicesToDisplay {
    
    private List<ElementFromDBRetrievable> usersServiceListToDisplay;
    private String userServiceTableLabel;

    public UsersServicesToDisplay(List<ElementFromDBRetrievable> usersServiceListToDisplay, String userServiceTableLabel) {
        this.usersServiceListToDisplay = usersServiceListToDisplay;
        this.userServiceTableLabel = userServiceTableLabel;
    }

    public List<ElementFromDBRetrievable> getUsersServiceListToDisplay() {
        return usersServiceListToDisplay;
    }

    public void setUsersServiceListToDisplay(List<ElementFromDBRetrievable> usersServiceListToDisplay) {
        this.usersServiceListToDisplay = usersServiceListToDisplay;
    }

    public String getUserServiceTableLabel() {
        return userServiceTableLabel;
    }

    public void setUserServiceTableLabel(String userServiceTableLabel) {
        this.userServiceTableLabel = userServiceTableLabel;
    }

    
    
}
