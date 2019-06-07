/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barpiotr.data;

import java.io.Serializable;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author PiotrB. CCT - sb17018
 */
public class VehicleModelExe{
    
    List<ElementFromDBRetrievable> result;
    
    public VehicleModelExe(DataSource dataSource) throws Exception {
     VehicleModelDAO vehicleModelList = new VehicleModelDAO();
        //information on result
     this.result = vehicleModelList.getElementFromDBList(dataSource, vehicleModelList.sql);
    }  

    public List<ElementFromDBRetrievable> getResult() {
        return result;
    }

    public void setResult(List<ElementFromDBRetrievable> result) {
        this.result = result;
    }
}
