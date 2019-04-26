/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barpiotr.driver;

import barpiotr.util.ServiceUser;
import java.io.Serializable;

/**
 *
 * @author PiotrB. CCT - sb17018
 */
public class Driver implements ServiceUser, Serializable {
    
    private String driverId;
    private String firstName;
    private String lastName;
    private String login;
    private String phone;
    private String password;
    
    public Driver(){}

    public Driver(String login, String password) {
        this.login = login;
        this.password = password;
    }
  
    public Driver(String driverId, String firstName, String lastName, String email, String phone, String password) {
        this.driverId = driverId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = email;
        this.phone = phone;
        this.password = password;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
