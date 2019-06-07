/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barpiotr.insertingData;

/**
 *
 * @author PiotrB. CCT - sb17018
 */
public class BookingDetails implements InsertedData { 
    
    
    public String theCustomerId;
    public String theCustomerName;
        
    public String theServiceType;

    public String theFreeSlotDate;
    public String theFreeSlotDay;
    public String theFreeSlotMonth;
    public String theFreeSlotYear;
    public String theFreeSlotTimeStart;
    public String theFreeSlotTimeFinish;

    public String theCarChoiceOption;

    public String theVehicleId;
        
    public String theVehicleMake;
    public String theVehicleMakeOther;
    public String theVehicleModel;
    public String theVehicleModelOther;
    public String theVehicleType;
    public String theEngineType;
    public String theVehicleRegistration;
    public String theVehicleColor;
    
    public String theServiceDescription;

    public BookingDetails(String theCustomerId, String theCustomerName, String theServiceType, String theFreeSlotDate, String theFreeSlotDay, String theFreeSlotMonth, String theFreeSlotYear, String theFreeSlotTimeStart, String theFreeSlotTimeFinish, String theCarChoiceOption, String theVehicleId, String theVehicleMake, String theVehicleModel, String theVehicleType, String theEngineType, String theVehicleRegistration, String theVehicleColor, String theServiceDescription) {
        this.theCustomerId = theCustomerId;
        this.theCustomerName = theCustomerName;
        this.theServiceType = theServiceType;
        this.theFreeSlotDate = theFreeSlotDate;
        this.theFreeSlotDay = theFreeSlotDay;
        this.theFreeSlotMonth = theFreeSlotMonth;
        this.theFreeSlotYear = theFreeSlotYear;
        this.theFreeSlotTimeStart = theFreeSlotTimeStart;
        this.theFreeSlotTimeFinish = theFreeSlotTimeFinish;
        this.theCarChoiceOption = theCarChoiceOption;
        this.theVehicleId = theVehicleId;
        this.theVehicleMake = theVehicleMake;
        this.theVehicleModel = theVehicleModel;
        this.theVehicleType = theVehicleType;
        this.theEngineType = theEngineType;
        this.theVehicleRegistration = theVehicleRegistration;
        this.theVehicleColor = theVehicleColor;
        this.theServiceDescription = theServiceDescription;
    }

    public String getTheCustomerId() {
        return theCustomerId;
    }

    public void setTheCustomerId(String theCustomerId) {
        this.theCustomerId = theCustomerId;
    }

    public String getTheCustomerName() {
        return theCustomerName;
    }

    public void setTheCustomerName(String theCustomerName) {
        this.theCustomerName = theCustomerName;
    }

    public String getTheServiceType() {
        return theServiceType;
    }

    public void setTheServiceType(String theServiceType) {
        this.theServiceType = theServiceType;
    }

    public String getTheFreeSlotDate() {
        return theFreeSlotDate;
    }

    public void setTheFreeSlotDate(String theFreeSlotDate) {
        this.theFreeSlotDate = theFreeSlotDate;
    }

    public String getTheFreeSlotDay() {
        return theFreeSlotDay;
    }

    public void setTheFreeSlotDay(String theFreeSlotDay) {
        this.theFreeSlotDay = theFreeSlotDay;
    }

    public String getTheFreeSlotMonth() {
        return theFreeSlotMonth;
    }

    public void setTheFreeSlotMonth(String theFreeSlotMonth) {
        this.theFreeSlotMonth = theFreeSlotMonth;
    }

    public String getTheFreeSlotYear() {
        return theFreeSlotYear;
    }

    public void setTheFreeSlotYear(String theFreeSlotYear) {
        this.theFreeSlotYear = theFreeSlotYear;
    }

    public String getTheFreeSlotTimeStart() {
        return theFreeSlotTimeStart;
    }

    public void setTheFreeSlotTimeStart(String theFreeSlotTimeStart) {
        this.theFreeSlotTimeStart = theFreeSlotTimeStart;
    }

    public String getTheFreeSlotTimeFinish() {
        return theFreeSlotTimeFinish;
    }

    public void setTheFreeSlotTimeFinish(String theFreeSlotTimeFinish) {
        this.theFreeSlotTimeFinish = theFreeSlotTimeFinish;
    }

    public String getTheCarChoiceOption() {
        return theCarChoiceOption;
    }

    public void setTheCarChoiceOption(String theCarChoiceOption) {
        this.theCarChoiceOption = theCarChoiceOption;
    }

    public String getTheVehicleId() {
        return theVehicleId;
    }

    public void setTheVehicleId(String theVehicleId) {
        this.theVehicleId = theVehicleId;
    }

    public String getTheVehicleMake() {
        return theVehicleMake;
    }

    public void setTheVehicleMake(String theVehicleMake) {
        this.theVehicleMake = theVehicleMake;
    }

    public String getTheVehicleModel() {
        return theVehicleModel;
    }

    public void setTheVehicleModel(String theVehicleModel) {
        this.theVehicleModel = theVehicleModel;
    }

    public String getTheVehicleType() {
        return theVehicleType;
    }

    public void setTheVehicleType(String theVehicleType) {
        this.theVehicleType = theVehicleType;
    }

    public String getTheEngineType() {
        return theEngineType;
    }

    public void setTheEngineType(String theEngineType) {
        this.theEngineType = theEngineType;
    }

    public String getTheVehicleRegistration() {
        return theVehicleRegistration;
    }

    public void setTheVehicleRegistration(String theVehicleRegistration) {
        this.theVehicleRegistration = theVehicleRegistration;
    }

    public String getTheVehicleColor() {
        return theVehicleColor;
    }

    public void setTheVehicleColor(String theVehicleColor) {
        this.theVehicleColor = theVehicleColor;
    }

    public String getTheServiceDescription() {
        return theServiceDescription;
    }

    public void setTheServiceDescription(String theServiceDescription) {
        this.theServiceDescription = theServiceDescription;
    }
}
