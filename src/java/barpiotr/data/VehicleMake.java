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
public class VehicleMake implements ElementFromDBRetrievable, Serializable {
    
    private int makeId;
    private String name;
    
    public VehicleMake(){}

    public VehicleMake(String name) {
        this.name = name;
    }
    
    

    public VehicleMake(int makeId, String name) {
        this.makeId = makeId;
        this.name = name;
    }

    public int getMakeId() {
        return makeId;
    }

    public void setMakeId(int makeId) {
        this.makeId = makeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return makeId + " " + name + "; ";
    }
  
}
