package barpiotr.mechanic;

import barpiotr.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PiotrB. CCT - sb17018
 */
public class Mechanic implements ServiceUser{
    
    private String empId;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    
    public Mechanic (String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Mechanic(String empId, String firstName, String lastName, String login, String password) {
        this.empId = empId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
    }

    public String getEmpId() {
        return empId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }   
    
}
