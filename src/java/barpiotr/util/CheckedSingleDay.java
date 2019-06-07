/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barpiotr.util;

import barpiotr.Days.Day;
import barpiotr.Days.WeekCreation;
import java.time.LocalDateTime;
import java.util.Map;

/**
 *
 * @author PiotrB. CCT - sb17018
 */
public class CheckedSingleDay {
    
    private Day d;
    private LocalDateTime lDT;
    
    private String dayName;
    private String dayInMonth;
    private String currentMonth;
    private String currentMonthInNumber;
    private String currentYear;

    public CheckedSingleDay(Map<String, String[]> dayParam) {
        for (String key : dayParam.keySet()){
            switch(key){
                case "day-name": this.dayName = (String)dayParam.get(key)[0];
                case "day-of-month": this.dayInMonth = (String)dayParam.get(key)[0];
                case "current-month": this.currentMonth = (String)dayParam.get(key)[0];
                case "current-month-number": this.currentMonthInNumber = (String)dayParam.get(key)[0];
                case "current-year": this.currentYear = (String)dayParam.get(key)[0];
            }
        }
    }   

    public Day getDay(){
        //when parameters are not set yet / the day square hasn't been clicked yet
        if (dayName == null) {
            //it's for first day of either week on calendar - not necessairly "today"
            WeekCreation weekDays = new WeekCreation();
            Day[] result = weekDays.getDays(0);
            //set the day in the header of the table with day's hours
            d = new Day(result[0].getDayName(), result[0].getDayInMonth(), result[0].getCurrentMonth(), result[0].getCurrentMonthInNumber(), result[0].getCurrentYear());
        }
        //when the day square has been clicked 
        else {
            d = new Day(dayName, dayInMonth, currentMonth, currentMonthInNumber, currentYear);
        }
        
        return d;
    }   
    
    public LocalDateTime getDayAsLocalDateTime(){
        //to pass a date to check which time slots are free
        lDT = LocalDateTime.parse(getDay().getCurrentYear() + "-" + getDay().getCurrentMonthInNumber() + "-" + getDay().getDayInMonth() + "T00:00"); 
        
        return lDT;
    }
}
