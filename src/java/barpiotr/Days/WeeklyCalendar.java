/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barpiotr.Days;

import barpiotr.user.settings.NumberPossibleWeeksAhead;
import java.util.Map;

/**
 *
 * @author PiotrB. CCT - sb17018
 */
public class WeeklyCalendar {
    
    private String howMovingWeek;
    private int weekProgression;

    private int howManyWeeksAhead;

    private WeekCreation weekDays;
    private Day[] weekToDisplay;

    private NumberPossibleWeeksAhead possibleWeeksAhead;
    private int limitOfWeeks;

    public WeeklyCalendar(Map<String, String[]> calendarParam) {
        for (String key : calendarParam.keySet()) {
            switch (key) {
                case "moving-week":
                    this.howMovingWeek = (String) calendarParam.get(key)[0];
                case "how-many-weeks-ahead":
                    try {
                        this.weekProgression = Integer.parseInt(calendarParam.get(key)[0]);
                    } catch (Exception e) {
                        this.howManyWeeksAhead = 0;
                    }
            }
        }
    }

    public void displayWeek() {
        //to set progression depending on type of clicked button (rev, day or forw)
        if (howMovingWeek != null) {
            if (howMovingWeek.equals("forward")) {//if forward button was clicked then the calendar goes a week ahead
                howManyWeeksAhead = weekProgression + 1;
            } else if (howMovingWeek.equals("back")) { //if reverseWeek button was clicked
                if (weekProgression == 0) {//if the current week is showing
                    howManyWeeksAhead = 0; //cannot go backwards
                } else {//if a week ahead is showing
                    howManyWeeksAhead = weekProgression - 1;//reverses 1 week
                }
            }
        } else {
            howManyWeeksAhead = weekProgression;
        }

        //limits progression weeks ahead
        possibleWeeksAhead = new NumberPossibleWeeksAhead();
        limitOfWeeks = possibleWeeksAhead.getNumberPossibleWeeksAhead();
        if (howManyWeeksAhead > limitOfWeeks) {
            howManyWeeksAhead = limitOfWeeks;
        }

        //returns 7 days starting from today
        weekDays = new WeekCreation();
        //to get days for corresponding weeks ahead
        weekToDisplay = weekDays.getDays(howManyWeeksAhead);
    }

    public int getHowManyWeeksAhead() {
        return howManyWeeksAhead;
    }

    public void setHowManyWeeksAhead(int howManyWeeksAhead) {
        this.howManyWeeksAhead = howManyWeeksAhead;
    }

    public Day[] getWeekToDisplay() {
        return weekToDisplay;
    }

    public void setWeekToDisplay(Day[] weekToDisplay) {
        this.weekToDisplay = weekToDisplay;
    }
}
