/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barpiotr.data;

import java.io.Serializable;

/**
 *
 * @author PiotrB. CCT - sb17018
 */
public class ServiceType implements ElementFromDBRetrievable, Serializable {
    
    private int serviceTypeId;
    private String name;
    private int time;
    private int cost;
    
    public ServiceType(){}

    public ServiceType(String name, int time, int cost) {
        this.name = name;
        this.time = time;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return serviceTypeId + name + time + cost;
    }

}   