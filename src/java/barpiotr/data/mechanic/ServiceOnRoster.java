/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barpiotr.data.mechanic;

import barpiotr.data.ElementFromDBRetrievable;
import java.io.Serializable;

/**
 *
 * @author PiotrB. CCT - sb17018
 */
public class ServiceOnRoster implements ElementFromDBRetrievable, Serializable {
    
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

    public ServiceOnRoster(String serviceId, String serviceStart, String serviceFinish, String serviceType, String serviceStatus, String mechanicFirstName, String mechanicLastName, String vehicleMake, String vehicleModel, String vehicleType, String engineType, String registration, String vehicleColor) {
        this.serviceId = serviceId;
        this.serviceStart = serviceStart;
        this.serviceFinish = serviceFinish;
        this.serviceType = serviceType;
        this.serviceStatus = serviceStatus;
        this.mechanicFirstName = mechanicFirstName;
        this.mechanicLastName = mechanicLastName;
        this.vehicleMake = vehicleMake;
        this.vehicleModel = vehicleModel;
        this.vehicleType = vehicleType;
        this.engineType = engineType;
        this.registration = registration;
        this.vehicleColor = vehicleColor;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceStart() {
        return serviceStart;
    }

    public void setServiceStart(String serviceStart) {
        this.serviceStart = serviceStart;
    }

    public String getServiceFinish() {
        return serviceFinish;
    }

    public void setServiceFinish(String serviceFinish) {
        this.serviceFinish = serviceFinish;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(String serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

    public String getMechanicFirstName() {
        return mechanicFirstName;
    }

    public void setMechanicFirstName(String mechanicFirstName) {
        this.mechanicFirstName = mechanicFirstName;
    }

    public String getMechanicLastName() {
        return mechanicLastName;
    }

    public void setMechanicLastName(String mechanicLastName) {
        this.mechanicLastName = mechanicLastName;
    }

    public String getVehicleMake() {
        return vehicleMake;
    }

    public void setVehicleMake(String vehicleMake) {
        this.vehicleMake = vehicleMake;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    @Override
    public String toString() {
        return "ServiceOnRoster{" + "serviceId=" + serviceId + ", serviceStart=" + serviceStart + ", serviceFinish=" + serviceFinish + ", serviceType=" + serviceType + ", serviceStatus=" + serviceStatus + ", mechanicFirstName=" + mechanicFirstName + ", mechanicLastName=" + mechanicLastName + ", vehicleMake=" + vehicleMake + ", vehicleModel=" + vehicleModel + ", vehicleType=" + vehicleType + ", engineType=" + engineType + ", registration=" + registration + ", vehicleColor=" + vehicleColor + '}';
    }


 
    
}
