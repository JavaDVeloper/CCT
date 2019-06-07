/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barpiotr.printing.DailyRoster;

/**
 *
 * @author PiotrB. CCT - sb17018
 */
public class DayRoster {
    
    private String serviceDate;
    private String serviceId;
    private String serviceStart;
    private String serviceFinish;
    private String serviceType;
    private String mechanicFirstName;
    private String mechanicLastName;
    private String serviceVehMake;
    private String serviceVehModel;
    private String serviceVehType;
    private String serviceEngineType;
    private String serviceVehRegistration;
    private String serviceVehColor;
    private String serviceStatus;

    public DayRoster(String serviceDate, String serviceId, String serviceStart, String serviceFinish, String serviceType, String mechanicFirstName, String mechanicLastName, String serviceVehMake, String serviceVehModel, String serviceVehType, String serviceEngineType, String serviceVehRegistration, String serviceVehColor, String serviceStatus) {
        this.serviceDate = serviceDate;
        this.serviceId = serviceId;
        this.serviceStart = serviceStart;
        this.serviceFinish = serviceFinish;
        this.serviceType = serviceType;
        this.mechanicFirstName = mechanicFirstName;
        this.mechanicLastName = mechanicLastName;
        this.serviceVehMake = serviceVehMake;
        this.serviceVehModel = serviceVehModel;
        this.serviceVehType = serviceVehType;
        this.serviceEngineType = serviceEngineType;
        this.serviceVehRegistration = serviceVehRegistration;
        this.serviceVehColor = serviceVehColor;
        this.serviceStatus = serviceStatus;
    }

    public String getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(String serviceDate) {
        this.serviceDate = serviceDate;
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

    public String getServiceVehMake() {
        return serviceVehMake;
    }

    public void setServiceVehMake(String serviceVehMake) {
        this.serviceVehMake = serviceVehMake;
    }

    public String getServiceVehModel() {
        return serviceVehModel;
    }

    public void setServiceVehModel(String serviceVehModel) {
        this.serviceVehModel = serviceVehModel;
    }

    public String getServiceVehType() {
        return serviceVehType;
    }

    public void setServiceVehType(String serviceVehType) {
        this.serviceVehType = serviceVehType;
    }

    public String getServiceEngineType() {
        return serviceEngineType;
    }

    public void setServiceEngineType(String serviceEngineType) {
        this.serviceEngineType = serviceEngineType;
    }

    public String getServiceVehRegistration() {
        return serviceVehRegistration;
    }

    public void setServiceVehRegistration(String serviceVehRegistration) {
        this.serviceVehRegistration = serviceVehRegistration;
    }

    public String getServiceVehColor() {
        return serviceVehColor;
    }

    public void setServiceVehColor(String serviceVehColor) {
        this.serviceVehColor = serviceVehColor;
    }

    public String getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(String serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

    @Override
    public String toString() {
        return "DayRoster{" + "serviceDate=" + serviceDate + ", serviceId=" + serviceId + ", serviceStart=" + serviceStart + ", serviceFinish=" + serviceFinish + ", serviceType=" + serviceType + ", mechanicFirstName=" + mechanicFirstName + ", mechanicLastName=" + mechanicLastName + ", serviceVehMake=" + serviceVehMake + ", serviceVehModel=" + serviceVehModel + ", serviceVehType=" + serviceVehType + ", serviceEngineType=" + serviceEngineType + ", serviceVehRegistration=" + serviceVehRegistration + ", serviceVehColor=" + serviceVehColor + ", serviceStatus=" + serviceStatus + '}';
    }

    
    
}