/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barpiotr.Days;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author PiotrB. CCT - sb17018
 */
public class DayFormatting {
    
    private SimpleDateFormat dayNameFormatter;
    private SimpleDateFormat dayFormatter;
    private SimpleDateFormat monthNumberFormatter;
    private SimpleDateFormat monthNameFormatter;
    private SimpleDateFormat yearFormatter;

    public DayFormatting() {
        
        //to set the way of format
        dayNameFormatter = new SimpleDateFormat("EEE");
        dayFormatter = new SimpleDateFormat("dd");
        monthNumberFormatter = new SimpleDateFormat("MM");
        monthNameFormatter = new SimpleDateFormat("MMM");
        yearFormatter = new SimpleDateFormat("YYYY");
    }
    
    public Day getFormattedDay(Date date){
        
        //to format given day accordingly
        String dayOfWeek = dayNameFormatter.format(date);
        String dayOfMonth = dayFormatter.format(date);
        String monthNumber = monthNumberFormatter.format(date);
        String monthName = monthNameFormatter.format(date);
        String theYear = yearFormatter.format(date);      
        
        return new Day (dayOfWeek, dayOfMonth, monthName, monthNumber, theYear); 
    }
    
}
