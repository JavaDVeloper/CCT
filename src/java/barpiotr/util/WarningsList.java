/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barpiotr.util;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author PiotrB. CCT - sb17018
 */
public class WarningsList {
    
    HashMap<String, String> emptyNameMap; 
    HashMap<String, String> returnedNameMap; 
    HashMap<String, String> warningMap;

    public WarningsList() {
    }
    
    String [][] warnings = {
        //http request parameters names
        {"first-name", "last-name", "login", "phone", "pass",  "vehicle-id", "vehicle-model", "vehicle-make",
        "vehicle-type", "engine-type", "vehicle-registration", "vehicle-color", "free-slot-time-start"},
        //fields names
        {"theFirstName", "theLastName", "theLogin", "thePhone", "thePass",  "theVehicleId", "theVehicleModel", "theVehicleMake",
        "theVehicleType", "theEngineType", "theVehicleRegistration", "theVehicleColor", "theFreeTimeSlotStart"},
        //warnigs text
        {"FIRST NAME CAN'T BE EMPTY",
         "LAST NAME CAN'T BE EMPTY",
         "LOGIN CAN'T BE EMPTY",
         "PHONE CAN'T BE EMPTY",
         "PASSWORD CAN'T BE EMPTY",
                
         "VEHICLE NEEDS TO CHOSEN",
         "MODEL NEEDS TO BE FILLED",
         "MAKE NEEDS TO BE FILLED",
         "TYPE CAN'T BE EMPTY",
         "ENGINE CAN'T BE EMPTY",
         "REGISTRATION CAN'T BE EMPTY",
         "COLOUR CAN'T BE EMPTY",
         
         "TIME NEEDS TO BE CHOSEN EMPTY"
        },
        //request Attribute names for warnings over input
        {"FIRST_NAME_EMPTY",
         "LAST_NAME_EMPTY",
         "LOGIN_EMPTY",
         "PHONE_EMPTY",
         "PASSWORD_EMPTY",
         
         "VEHICLE_ID_EMPTY",
         "VEHICLE_MODEL_EMPTY",
         "VEHICLE_MAKE_EMPTY",
         "VEHICLE_TYPE_EMPTY",
         "ENGINE_TYPE_EMPTY",
         "VEHICLE_REGISTRATION_EMPTY",
         "VEHICLE_COLOR_EMPTY",
         
         "FREE_SLOT_TIME_START_EMPTY"
        },
        //request Attribute names for values in input
        {"FIRST_NAME_RETURNED",
         "LAST_NAME_RETURNED",
         "LOGIN_RETURNED",
         "PHONE_RETURNED",
         "PASSWORD_RETURNED",
         
         "VEHICLE_ID_RETURNED",
         "VEHICLE_MODEL_RETURNED",
         "VEHICLE_MAKE_RETURNED",
         "VEHICLE_TYPE_RETURNED",
         "ENGINE_TYPE_RETURNED",
         "VEHICLE_REGISTRATION_RETURNED",
         "VEHICLE_COLOR_RETURNED",
         
         "FREE_SLOT_TIME_START_RETURNED"
        } 
    };
    
    public HashMap mapFieldsNamesToAttWhenEmpty(){
        emptyNameMap = new HashMap<>();
        for(int i = 0; i < warnings[1].length; i++){
            emptyNameMap.put(warnings[1][i], warnings[3][i]);
        }
        return emptyNameMap;
    }

    public HashMap mapFieldsNamesToWarnings(){
        warningMap = new HashMap<>();
        for(int i = 0; i < warnings[1].length; i++){
            warningMap.put(warnings[1][i], warnings[2][i]);
        }
        return warningMap;
    }
    
    public HashMap mapFieldsNamesToAttWhenReturned(){
        returnedNameMap = new HashMap<>();
        for(int i = 0; i < warnings[1].length; i++){
            returnedNameMap.put(warnings[1][i], warnings[4][i]);
        }
        return returnedNameMap;
    }
    
}
