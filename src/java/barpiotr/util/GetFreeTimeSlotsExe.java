/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barpiotr.util;

import barpiotr.data.FreeHour;
import barpiotr.data.FreeHoursDAO;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;

/**
 *
 * @author PiotrB. CCT - sb17018
 */
public class GetFreeTimeSlotsExe {

    private Map<String, String[]> dayParam;

    private CheckedSingleDay cSD;
    private LocalDateTime checkedDate;

    private CheckedServiceTime cST;
    private int serviceTime;

    FreeHoursDAO freeHours;
    List<FreeHour> freeHoursList;

    public GetFreeTimeSlotsExe(Map<String, String[]> dayParam) {
        this.dayParam = dayParam;
    }

    public List<FreeHour> getServiceTimeSlots(DataSource dataSource) throws Exception {
        //to get which day is checked
        cSD = new CheckedSingleDay(dayParam);
        checkedDate = cSD.getDayAsLocalDateTime();

        //to get time of chosen service
        cST = new CheckedServiceTime(dayParam);
        serviceTime = cST.getServiceTime(dataSource);

        //to return list of time slots
        freeHours = new FreeHoursDAO(dataSource);
        freeHoursList = new ArrayList<>();
        freeHoursList = freeHours.getFreeHoursList(serviceTime, checkedDate);

        return freeHoursList;
    }
}
