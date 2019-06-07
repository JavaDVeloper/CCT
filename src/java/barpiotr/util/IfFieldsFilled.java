/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barpiotr.util;

import barpiotr.insertingData.BookingDetails;

/**
 *
 * @author PiotrB. CCT - sb17018
 */
public class IfFieldsFilled {

    Boolean fieldsFilled;

    InputFieldsDataUser userInput;
    BookingDetails bookingInput;

    public IfFieldsFilled(Object dataInput) {

        String className = dataInput.getClass().getSimpleName();

        switch (className) {
            case "InputFieldsDataUser":
                this.userInput = (InputFieldsDataUser) dataInput;
                break;
            case "BookingDetails":
                this.bookingInput = (BookingDetails) dataInput;
                break;
        }
    }

    public Boolean ifLoginFieldsFilled() {

        fieldsFilled = true;
        if (userInput.theLogin.equals("")) {
            fieldsFilled = false;
        }

        if (userInput.thePass.equals("")) {
            fieldsFilled = false;
        }
        return fieldsFilled;
    }

    public Boolean ifUserFieldsFilled() {

        fieldsFilled = true;

        if (userInput.theFirstName.equals("")) {
            fieldsFilled = false;
        }

        if (userInput.theLastName.equals("")) {
            fieldsFilled = false;
        }

        if (userInput.theLogin.equals("")) {
            fieldsFilled = false;
        }

        if (userInput.thePhone.equals("")) {
            fieldsFilled = false;
        }

        if (userInput.thePass.equals("")) {
            fieldsFilled = false;
        }
        return fieldsFilled;
    }

    public Boolean ifBookingFieldsFilled() {

        fieldsFilled = true;

        if (bookingInput.getTheFreeSlotTimeStart().equals("")) {
            fieldsFilled = false;
        }

        if (bookingInput.getTheCarChoiceOption().equals("fromList")) {
            try {
                if (bookingInput.getTheVehicleId().equals("")) {
                fieldsFilled = false;
            }

            } catch (Exception e) {
            }

        } else {

            if (bookingInput.getTheVehicleModel().equals("")) {
                fieldsFilled = false;
            }

            if (bookingInput.getTheVehicleMake().equals("")) {
                fieldsFilled = false;
            }

            if (bookingInput.getTheVehicleType().equals("")) {
                fieldsFilled = false;
            }

            if (bookingInput.getTheEngineType().equals("")) {
                fieldsFilled = false;
            }
            if (bookingInput.getTheVehicleRegistration().equals("")) {
                fieldsFilled = false;
            }
            if (bookingInput.getTheVehicleColor().equals("")) {
                fieldsFilled = false;
            }

        }

        return fieldsFilled;
    }
}
