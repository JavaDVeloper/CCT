/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barpiotr.data;

import barpiotr.user.settings.OpeningHours;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;

/**
 *
 * @author PiotrB. CCT - sb17018
 */
public class FreeHoursDAO {

    private DataSource datasource;
    
    private OpeningHours openingHours;
    
    private String finishServiceHour;

    private List<ElementFromDBRetrievable> howManyBookingAtHour;
    private List<ElementFromDBRetrievable> allAvailableMechanics;
    
    private AvailableMechanicDAO availableMechanics;
    private BookedSlotAtGivenHourDAO ifBookedSlot;

    public FreeHoursDAO(DataSource datasource) {
        this.datasource = datasource;
        freeHoursList = new ArrayList<>();
    }

    private FreeHour tempElement;
    private List<FreeHour> freeHoursList;

    public List<FreeHour> getFreeHoursList(int serviceTime, LocalDateTime checkedSlot) {
        openingHours = new OpeningHours();
        for (int i = openingHours.getOPEN_HOUR(); i <= openingHours.getCLOSED_HOUR() - serviceTime; i++) {
            ifBookedSlot = new BookedSlotAtGivenHourDAO(serviceTime, checkedSlot.withHour(i));
            availableMechanics = new AvailableMechanicDAO();
            try {
                howManyBookingAtHour = ifBookedSlot.getElementFromDBList(datasource, ifBookedSlot.sql);
                allAvailableMechanics = availableMechanics.getElementFromDBList(datasource, availableMechanics.sql);
            } catch (Exception ex) {
            }

            int numberOfBookings;
            int numberOfAvailMechanics;

            if (allAvailableMechanics.isEmpty()) {
                numberOfAvailMechanics = 0;
            } else {
                numberOfAvailMechanics = allAvailableMechanics.size();
            }

            if (howManyBookingAtHour.isEmpty()) {
                numberOfBookings = 0;
            } else {
                numberOfBookings = howManyBookingAtHour.size();
            }

            if (numberOfBookings < numberOfAvailMechanics) {
                tempElement = new FreeHour(checkedSlot.withHour(i), checkedSlot.withHour(i + serviceTime));
                freeHoursList.add(tempElement);
            }
        }
        return freeHoursList;
    }
    
    
    public String getFinishServiceHour(List<FreeHour> freeHoursList, String start) {
              
        finishServiceHour = mapFreeHoursList(freeHoursList).get(start);
        
        return finishServiceHour;
    }
    
    private static Map<String, String> mapFreeHoursList(List<FreeHour> freeHoursList){
          
       Map<String, String> listMap = new HashMap<>();
        
        for(FreeHour fhtb : freeHoursList){
            String start = String.valueOf(fhtb.getStartHour());
            String finish = String.valueOf(fhtb.getFinishHour());
            listMap.put(start, finish);
        }
        
        return listMap;
    }
    
}
