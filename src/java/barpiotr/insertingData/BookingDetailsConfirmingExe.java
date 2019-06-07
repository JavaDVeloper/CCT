/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barpiotr.insertingData;

import java.util.Map;
import javax.sql.DataSource;

/**
 *
 * @author PiotrB. CCT - sb17018
 */
public class BookingDetailsConfirmingExe {

    private BookingDetails bookingDetails;
    BookingDetailsConfirming bookingServiceConfirmation;

    private String theCustomerId;
    private String theCustomerName;

    private String theServiceType;

    private String theFreeSlotDate;
    private String theFreeSlotDay;
    private String theFreeSlotMonth;
    private String theFreeSlotYear;
    private String theFreeSlotTimeStart;
    private String theFreeSlotTimeFinish;

    private String theCarChoiceOption;

    private String theVehicleId;
    private String theVehicleMake;
    private String theVehicleMakeOther;
    private String theVehicleModel;
    private String theVehicleModelOther;
    private String theVehicleType;
    private String theEngineType;
    private String theVehicleRegistration;
    private String theVehicleColor;

    private String theServiceDescription;

    public BookingDetailsConfirmingExe(Map<String, String[]> bookingParam) {
        for (String key : bookingParam.keySet()) {
            switch (key) {
                //checks names of the Parameter passed in and assignes values
                case "customer-id":
                    this.theCustomerId = (String) bookingParam.get(key)[0];
                    break;
                case "customer-name":
                    this.theCustomerName = (String) bookingParam.get(key)[0];
                    break;
                case "service-type":
                    this.theServiceType = (String) bookingParam.get(key)[0];
                    break;
                case "free-slot-date":
                    this.theFreeSlotDate = (String) bookingParam.get(key)[0];
                    break;
                case "free-slot-day":
                    this.theFreeSlotDay = (String) bookingParam.get(key)[0];
                    break;
                case "free-slot-month":
                    this.theFreeSlotMonth = (String) bookingParam.get(key)[0];
                    break;
                case "free-slot-year":
                    this.theFreeSlotYear = (String) bookingParam.get(key)[0];
                    break;
                case "free-slot-time-start":
                    this.theFreeSlotTimeStart = (String) bookingParam.get(key)[0];
                    break;
                case "free-slot-time-finish":
                    this.theFreeSlotTimeFinish = (String) bookingParam.get(key)[0];
                    break;
                case "entered-car":
                    this.theCarChoiceOption = (String) bookingParam.get(key)[0];
                    break;
                case "vehicle-id":
                    this.theVehicleId = (String) bookingParam.get(key)[0];
                    break;
                case "vehicle-make":
                    this.theVehicleMake = (String) bookingParam.get(key)[0];
                    if (theVehicleMake.equals("")) {
                        this.theVehicleMake = (String) bookingParam.get("other-make")[0];
                    }
                    break;
                case "vehicle-model":
                    this.theVehicleModel = (String) bookingParam.get(key)[0];
                    if (theVehicleModel.equals("")) {
                        this.theVehicleModel = (String) bookingParam.get("other-model")[0];
                    }
                    break;
                case "vehicle-type":
                    this.theVehicleType = (String) bookingParam.get(key)[0];
                    break;
                case "engine-type":
                    this.theEngineType = (String) bookingParam.get(key)[0];
                    break;
                case "vehicle-registration":
                    this.theVehicleRegistration = (String) bookingParam.get(key)[0];
                    break;
                case "vehicle-color":
                    this.theVehicleColor = (String) bookingParam.get(key)[0];
                    break;
                case "service-description":
                    this.theServiceDescription = (String) bookingParam.get(key)[0];
                    break;
            }
        }

        bookingDetails = new BookingDetails(theCustomerId, theCustomerName, theServiceType, theFreeSlotDate, theFreeSlotDay,
                theFreeSlotMonth, theFreeSlotYear, theFreeSlotTimeStart, theFreeSlotTimeFinish, theCarChoiceOption, theVehicleId,
                theVehicleMake, theVehicleModel, theVehicleType, theEngineType, theVehicleRegistration, theVehicleColor, theServiceDescription);
    }

    public void insertToDataBase(DataSource dataSource, BookingDetails bookingDetails) throws Exception {
        bookingServiceConfirmation = new BookingDetailsConfirming(dataSource);
        bookingServiceConfirmation.insertToDatabase(bookingDetails);
    }

    public BookingDetails getBookingDetails() {
        return bookingDetails;
    }

    public void setBookingDetails(BookingDetails bookingDetails) {
        this.bookingDetails = bookingDetails;
    }
    
}
