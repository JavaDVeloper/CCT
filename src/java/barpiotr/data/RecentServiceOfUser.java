/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barpiotr.data;

/**
 *
 * @author PiotrB. CCT - sb17018
 */
public class RecentServiceOfUser implements ElementFromDBRetrievable{
    
    private String vehicleMake;
    private String vehicleModel;
    private String vehicleRegistration;
    private String serviceType;
    private String serviceStart;
    private String serviceFinish;
    private String serviceStatus;

    public RecentServiceOfUser(String vehicleMake, String vehicleModel, String vehicleRegistration, String serviceType, String serviceStart, String serviceFinish, String serviceStatus) {
        this.vehicleMake = vehicleMake;
        this.vehicleModel = vehicleModel;
        this.vehicleRegistration = vehicleRegistration;
        this.serviceType = serviceType;
        this.serviceStart = serviceStart;
        this.serviceFinish = serviceFinish;
        this.serviceStatus = serviceStatus;
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

    public String getVehicleRegistration() {
        return vehicleRegistration;
    }

    public void setVehicleRegistration(String vehicleRegistration) {
        this.vehicleRegistration = vehicleRegistration;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
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

    public String getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(String serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

    
}
