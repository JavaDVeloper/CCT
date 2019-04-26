/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author PiotrB. CCT - sb17018
 */
public class FreeHoursList {
    
    private DataSource datasource;
    
    private List<ElementFromDBRetrievable> howManyBookingAtHour;
    private List<ElementFromDBRetrievable> allAvailableMechanics;
    private AvailableMechanicDAO availableMechanics;
    private BookedSlotAtGivenHourDAO ifBookedSlot;

    public FreeHoursList(DataSource datasource) {
        this.datasource = datasource;
        freeHoursList = new ArrayList<>();
    }
    
    private FreeHourToBook tempElement;
    private List<FreeHourToBook> freeHoursList;
    
    public List<FreeHourToBook> getFreeHoursList(int serviceTime, LocalDateTime checkedSlot){
        for(int i = 9; i <= 17-serviceTime; i++){
            ifBookedSlot = new BookedSlotAtGivenHourDAO(serviceTime, checkedSlot.withHour(i));
            availableMechanics = new AvailableMechanicDAO();
            try {
                howManyBookingAtHour = ifBookedSlot.getElementFromDBList(datasource, ifBookedSlot.sql);
                allAvailableMechanics = availableMechanics.getElementFromDBList(datasource, availableMechanics.sql);
            }
            catch (Exception ex) {
            }
            
            int numberOfBookings;
            int numberOfAvailMechanics;
            
                        if (allAvailableMechanics.isEmpty()){
                numberOfAvailMechanics = 0;
            }
            else{
                numberOfAvailMechanics = allAvailableMechanics.size(); 
            }
            
            if (howManyBookingAtHour.isEmpty()){
                numberOfBookings = 0;
            }
            else{
                numberOfBookings = howManyBookingAtHour.size(); 
            }


            
            if(numberOfBookings < numberOfAvailMechanics){
                tempElement =  new FreeHourToBook(checkedSlot.withHour(i), checkedSlot.withHour(i + serviceTime));
                freeHoursList.add(tempElement);
            }
        }
        return freeHoursList;
    }
}
