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
public class VehicleModel implements ElementFromDBRetrievable, Serializable {

    private int modelId;
    private String name;
    private int makeId;
    private int typeId;

    public VehicleModel() {
    }

    public VehicleModel(int modelId, String name, int makeId, int typeId) {
        this.modelId = modelId;
        this.name = name;
        this.makeId = makeId;
        this.typeId = typeId;
    }

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMakeId() {
        return makeId;
    }

    public void setMakeId(int makeId) {
        this.makeId = makeId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

}
