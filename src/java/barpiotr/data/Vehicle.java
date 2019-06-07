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
public class Vehicle implements ElementFromDBRetrievable, Serializable {
    
    private int id;
    private String registration;
    private String colour;
    private int customerId;
    private String vehicleMakeName;
    private String vehicleModelName;
    private String engineTypeName;
    private String vehicleTypeName;
    
    
    public Vehicle(){}

    public Vehicle(int id, String registration, String colour, int customerId, String vehicleMakeName, String vehicleModelName, String engineTypeName, String vehicleTypeName) {
        this.id = id;
        this.registration = registration;
        this.colour = colour;
        this.customerId = customerId;
        this.vehicleMakeName = vehicleMakeName;
        this.vehicleModelName = vehicleModelName;
        this.engineTypeName = engineTypeName;
        this.vehicleTypeName = vehicleTypeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getVehicleMakeName() {
        return vehicleMakeName;
    }

    public void setVehicleMakeName(String vehicleMakeName) {
        this.vehicleMakeName = vehicleMakeName;
    }

    public String getVehicleModelName() {
        return vehicleModelName;
    }

    public void setVehicleModelName(String vehicleModelName) {
        this.vehicleModelName = vehicleModelName;
    }

    public String getEngineTypeName() {
        return engineTypeName;
    }

    public void setEngineTypeName(String engineTypeName) {
        this.engineTypeName = engineTypeName;
    }

    public String getVehicleTypeName() {
        return vehicleTypeName;
    }

    public void setVehicleTypeName(String vehicleTypeName) {
        this.vehicleTypeName = vehicleTypeName;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "id=" + id + ", registration=" + registration + ", colour=" + colour + ", customerId=" + customerId + ", vehicleMakeName=" + vehicleMakeName + ", vehicleModelName=" + vehicleModelName + ", engineTypeName=" + engineTypeName + ", vehicleTypeName=" + vehicleTypeName + '}';
    }

  
}
