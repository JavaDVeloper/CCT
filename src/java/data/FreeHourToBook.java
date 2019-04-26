/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.time.LocalDateTime;

/**
 *
 * @author PiotrB. CCT - sb17018
 */
public class FreeHourToBook {
    
    private LocalDateTime start;
    private LocalDateTime finish;
    private int startHour;
    private int finishHour;

    public FreeHourToBook() {
    }

    public FreeHourToBook(LocalDateTime start, LocalDateTime finish) {
        this.start = start;
        this.finish = finish;
        this.startHour = start.getHour();
        this.finishHour = finish.getHour();
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

    public int getStartHour() {
        return startHour;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    public int getFinishHour() {
        return finishHour;
    }

    public void setFinishHour(int finishHour) {
        this.finishHour = finishHour;
    }

    @Override
    public String toString() {
        return "FreeHourToBook{" + "start=" + start + ", finish=" + finish + '}';
    }
    
}
