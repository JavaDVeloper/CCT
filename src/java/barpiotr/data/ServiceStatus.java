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
public class ServiceStatus implements ElementFromDBRetrievable, Serializable {
    
    private String name;
    
    public ServiceStatus(){}

    public ServiceStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ServiceStatus{" + "name=" + name + '}';
    }
    
    

}   