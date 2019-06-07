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
public class UpdatingPendingService implements InsertedData {
    
    private String id;
    private String status;

    public UpdatingPendingService(String id, String status) {
        this.id = id;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UpdatingPendingService{" + "id=" + id + ", status=" + status + '}';
    }

    
}
