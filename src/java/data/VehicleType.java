/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;

/**
 *
 * @author PiotrB. CCT - sb17018
 */
public class VehicleType implements ElementFromDBRetrievable, Serializable {
    
    private int vehicleTypeId;
    private String name;
    
    public VehicleType(){}

    public VehicleType(int vehicleTypeId, String name) {
        this.vehicleTypeId = vehicleTypeId;
        this.name = name;
    }

    public int getVehicleTypeId() {
        return vehicleTypeId;
    }

    public void setVehicleTypeId(int vehicleTypeId) {
        this.vehicleTypeId = vehicleTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}   