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
public class VehicleModel implements ElementFromDBRetrievable, Serializable {

    private String name;
    private String makeId;
    private String typeId;

    public VehicleModel() {
    }

    public VehicleModel(String name, String makeId, String typeId) {
        this.name = name;
        this.makeId = makeId;
        this.typeId = typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMakeId() {
        return makeId;
    }

    public void setMakeId(String makeId) {
        this.makeId = makeId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "VehicleModel{" + "name=" + name + ", makeId=" + makeId + ", typeId=" + typeId + '}';
    }

}
