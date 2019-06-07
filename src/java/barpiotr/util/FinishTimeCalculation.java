/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barpiotr.util;

import java.time.LocalTime;
import java.util.Map;

/**
 *
 * @author PiotrB. CCT - sb17018
 */
public class FinishTimeCalculation {
    
    private String startTime;
    private String serviceTime;
    
    LocalTime startTimeFigure;
    int serviceTimeFigure;
    LocalTime finishTimeFigure;
    
    private String finishTime;

    public FinishTimeCalculation(Map<String, String[]> dayParam) {
        for (String key : dayParam.keySet()) {
            switch (key) {
                //checks names of the Parameter passed in and assignes values
                case "service-time": serviceTime = (String) dayParam.get(key)[0];
                case "free-slot-time-start": startTime = (String) dayParam.get(key)[0];
                                             if(startTime.length()<5) startTime="0"+startTime;
            }
        }
    }

    public String getFinishTime(){
        startTimeFigure = LocalTime.parse(startTime);
        serviceTimeFigure =  Integer.parseInt(serviceTime);
        finishTimeFigure = startTimeFigure.plusHours(serviceTimeFigure);
        finishTime = String.valueOf(finishTimeFigure);
    return finishTime;
    }

 
}
