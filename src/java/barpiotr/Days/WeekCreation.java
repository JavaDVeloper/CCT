/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barpiotr.Days;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author PiotrB. CCT - sb17018
 */
public class WeekCreation {
    
    private Day [] theWeek;
    private Date today;
    private Calendar cal;
    private int weekStartingDay;

    public WeekCreation(){
    }

    public Day[] getDays(int weeksAhead){
        weekStartingDay = weeksAhead*7;
        theWeek = new Day [7];
        today = new Date();

        cal = Calendar.getInstance();
        DayFormatting formDay = new DayFormatting();
        
        //to add saven days starting from today
        for (int i = weekStartingDay; i < weekStartingDay + 7; i++){
            
            //to get today's date
            cal.setTime(today);
            
            //to add a day to a current date
            cal.add(Calendar.DAY_OF_MONTH, i);
            
            //calculate indexes for theWeek array
            int j = i % 7;

            //to get date for acctual date after adding days
            Date modifiedDate = cal.getTime();
            
            //puttting a well formatted date in an array
            theWeek[j] = formDay.getFormattedDay(modifiedDate);
        }
        
        return theWeek;
    }
 
}
