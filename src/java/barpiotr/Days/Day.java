/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barpiotr.Days;

import java.io.Serializable;

/**
 *
 * @author PiotrB. CCT - sb17018
 */
public class Day implements Serializable {
    
    private String dayName;
    private String dayInMonth;
    private String currentMonth;
    private String currentMonthInNumber;
    private String currentYear;
    
    public Day() {}
    
    //constructor for test

    public Day(String dayName, String dayInMonth) {
        this.dayName = dayName;
        this.dayInMonth = dayInMonth;
    }
    
    public Day(String dayName, String dayInMonth, String currentMonth, String currentYear) {
        this.dayName = dayName;
        this.dayInMonth = dayInMonth;
        this.currentMonth = currentMonth;
        this.currentYear = currentYear;
    }
    
    public Day(String dayName, String dayInMonth, String currentMonth, String currentMonthInNumber, String currentYear) {
        this.dayName = dayName;
        this.dayInMonth = dayInMonth;
        this.currentMonth = currentMonth;
        this.currentMonthInNumber = currentMonthInNumber;
        this.currentYear = currentYear;
    }

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    public String getDayInMonth() {
        return dayInMonth;
    }

    public void setDayInMonth(String dayInMonth) {
        this.dayInMonth = dayInMonth;
    }

    public String getCurrentMonth() {
        return currentMonth;
    }

    public void setCurrentMonth(String currentMonth) {
        this.currentMonth = currentMonth;
    }

    public String getCurrentYear() {
        return currentYear;
    }

    public void setCurrentYear(String currentYear) {
        this.currentYear = currentYear;
    }

    public String getCurrentMonthInNumber() {
        return currentMonthInNumber;
    }

}
