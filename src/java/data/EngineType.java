/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;

/**
 *
 * @author PiotrB. CCT - sb17018
 */
public class EngineType implements ElementFromDBRetrievable, Serializable {
    
    private int engineTypeId;
    private String name;

    public EngineType() {
    }

    public EngineType(int engineTypeId, String name) {
        this.engineTypeId = engineTypeId;
        this.name = name;
    }

    public int getEngineTypeId() {
        return engineTypeId;
    }

    public void setEngineTypeId(int engineTypeId) {
        this.engineTypeId = engineTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    


}   