/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barpiotr.data;

import java.io.Serializable;

/**
 *
 * @author PiotrB. CCT - sb17018
 */
public class Mechanic implements ElementFromDBRetrievable, Serializable {
    
    private int employeeId;
    private String firstName;
    private String lastName;
    boolean available;
    
    public Mechanic(){}

    public Mechanic(int employeeId, String firstName, String lastName, boolean available) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.available = available;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
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

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Mechanic{" + "employeeId=" + employeeId + ", firstName=" + firstName + 
                ", lastName=" + lastName + ", availability=" + available + '}';
    }
  
}
