/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barpiotr.insertingData;

/**
 *
 * @author PiotrB. CCT - sb17018
 */
public class ChosenTimeSlot {
    
    private String chosenDate;
    private String chosenYear;
    private String chosenMonth;
    private String chosenDay;
    private String chosenTimeSlotStart;
    private String chosenTimeSlotFinish;

    public ChosenTimeSlot() {
    }

    public ChosenTimeSlot(String chosenDate, String chosenYear, String chosenMonth, String chosenDay, String chosenTimeSlotStart, String chosenTimeSlotFinish) {
        this.chosenDate = chosenDate;
        this.chosenYear = chosenYear;
        this.chosenMonth = chosenMonth;
        this.chosenDay = chosenDay;
        this.chosenTimeSlotStart = chosenTimeSlotStart;
        this.chosenTimeSlotFinish = chosenTimeSlotFinish;
    }

    public String getChosenDate() {
        return chosenDate;
    }

    public void setChosenDate(String chosenDate) {
        this.chosenDate = chosenDate;
    }

    public String getChosenYear() {
        return chosenYear;
    }

    public void setChosenYear(String chosenYear) {
        this.chosenYear = chosenYear;
    }

    public String getChosenMonth() {
        return chosenMonth;
    }

    public void setChosenMonth(String chosenMonth) {
        this.chosenMonth = chosenMonth;
    }

    public String getChosenDay() {
        return chosenDay;
    }

    public void setChosenDay(String chosenDay) {
        this.chosenDay = chosenDay;
    }

    public String getChosenTimeSlotStart() {
        return chosenTimeSlotStart;
    }

    public void setChosenTimeSlotStart(String chosenTimeSlotStart) {
        this.chosenTimeSlotStart = chosenTimeSlotStart;
    }

    public String getChosenTimeSlotFinish() {
        return chosenTimeSlotFinish;
    }

    public void setChosenTimeSlotFinish(String chosenTimeSlotFinish) {
        this.chosenTimeSlotFinish = chosenTimeSlotFinish;
    }

 
    
}
