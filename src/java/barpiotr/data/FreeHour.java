/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barpiotr.data;

import java.time.LocalDateTime;

/**
 *
 * @author PiotrB. CCT - sb17018
 */
public class FreeHour {
    
    private LocalDateTime start;
    private LocalDateTime finish;
    private String startHour;
    private String finishHour;

    public FreeHour() {
    }

    public FreeHour(LocalDateTime start, LocalDateTime finish) {
        this.start = start;
        this.finish = finish;
        this.startHour = String.valueOf(start.getHour());
        this.finishHour = String.valueOf(finish.getHour());
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getFinish() {
        return finish;
    }

    public void setFinish(LocalDateTime finish) {
        this.finish = finish;
    }

    public String getStartHour() {
        return startHour + ":00";
    }

    public void setStartHour(String startHour) {
        this.startHour = startHour;
    }

    public String getFinishHour() {
        return finishHour + ":00";
    }

    public void setFinishHour(String finishHour) {
        this.finishHour = finishHour;
    }

    @Override
    public String toString() {
        return "FreeHourToBook{" + "start=" + start + ", finish=" + finish + '}';
    }
    
}
