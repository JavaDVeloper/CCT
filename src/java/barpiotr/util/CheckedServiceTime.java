/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barpiotr.util;

import barpiotr.data.ServiceTypeDAO;
import java.util.Map;
import javax.sql.DataSource;

/**
 *
 * @author PiotrB. CCT - sb17018
 */
public class CheckedServiceTime {

    private String serviceType;
    ServiceTypeDAO serviceTypeList;
    Map mapOfServiceTypeTime;
    private int serviceTime;

    public CheckedServiceTime(Map<String, String[]> dayParam) {
        for (String key : dayParam.keySet()) {
            switch (key) {
                //checks names of the Parameter passed in and assignes values
                case "service-type": serviceType = (String) dayParam.get(key)[0];
            }
        }
    }

    public int getServiceTime(DataSource dataSource) throws Exception {
        serviceTypeList = new ServiceTypeDAO();
        mapOfServiceTypeTime = serviceTypeList.getElementsTimeMappedFromDB(dataSource, serviceTypeList.sql);

        //to get service time mapped from its time
        serviceTime = (Integer) mapOfServiceTypeTime.get(serviceType);

        return serviceTime;
    }
}
