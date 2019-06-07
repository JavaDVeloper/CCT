/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barpiotr.data;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author PiotrB. CCT - sb17018
 */
public class FreeHoursList_TEST {
    
    private DataSource datasource;
    private Connection myConn;
    
    private List<ElementFromDBRetrievable> howManyBookingAtHour;
    private List<ElementFromDBRetrievable> allAvailableMechanics;
    private AvailableMechanicDAO_TEST availableMechanics;
    private BookedSlotAtGivenHourDAO_TEST ifBookedSlot;

    public FreeHoursList_TEST(Connection myConn) {
        this.myConn = myConn;
        freeHoursList = new ArrayList<>();
    }
    
    private FreeHour tempElement;
    private List<FreeHour> freeHoursList;
    
    public List<FreeHour> getFreeHoursList(int serviceTime, LocalDateTime checkedSlot){
        for(int i = 9; i <= 17-serviceTime; i++){
            ifBookedSlot = new BookedSlotAtGivenHourDAO_TEST(serviceTime, checkedSlot.withHour(i));
            availableMechanics = new AvailableMechanicDAO_TEST();
            try {
                howManyBookingAtHour = ifBookedSlot.getElementFromDBList(myConn, ifBookedSlot.sql);
                allAvailableMechanics = availableMechanics.getElementFromDBList(myConn, availableMechanics.sql);
            }
            catch (Exception ex) {
            }
                      
            if(howManyBookingAtHour.size() < allAvailableMechanics.size()){
                tempElement =  new FreeHour(checkedSlot.withHour(i), checkedSlot.withHour(i + serviceTime));
                freeHoursList.add(tempElement);
            }
        }
        return freeHoursList;
    }
}
