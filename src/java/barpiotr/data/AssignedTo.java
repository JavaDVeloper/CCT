/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barpiotr.data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Calendar;

/**
 *
 * @author PiotrB. CCT - sb17018
 */
public class AssignedTo implements ElementFromDBRetrievable, Serializable {
    
    private int employeeId;
    private int serviceId;
    private int vehicleId;
    private LocalDateTime start;
    private LocalDateTime finish;
    
    public AssignedTo(){}

    public AssignedTo(int employeeId, int serviceId, int vehicleId, LocalDateTime start, LocalDateTime finish) {
        this.employeeId = employeeId;
        this.serviceId = serviceId;
        this.vehicleId = vehicleId;
        this.start = start;
        this.finish = finish;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
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

    @Override
    public String toString() {
        return "AssignedTo{" + "employeeId=" + employeeId + ", serviceId=" + serviceId + ", vehicleId=" + vehicleId + ", start=" + start + ", finish=" + finish + '}';
    }

}   