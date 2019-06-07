/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barpiotr.util;

import barpiotr.data.ServiceTypeDAO;
import barpiotr.data.ServiceTypeDAO_TEST;
import java.sql.Connection;
import java.util.Map;
import javax.sql.DataSource;

/**
 *
 * @author PiotrB. CCT - sb17018
 */
public class CheckedServiceTime_TEST {

    private String serviceType;
    ServiceTypeDAO_TEST serviceTypeList;
    Map mapOfServiceTypeTime;
    private int serviceTime;

    public CheckedServiceTime_TEST(Map<String, String[]> dayParam) {
        for (String key : dayParam.keySet()) {
            switch (key) {
                //checks names of the Parameter passed in and assignes values
                case "service-type": serviceType = (String) dayParam.get(key)[0];
            }
        }
    }

    public int getServiceTime(Connection myConn) throws Exception {
        serviceTypeList = new ServiceTypeDAO_TEST();
        mapOfServiceTypeTime = serviceTypeList.getElementsTimeMappedFromDB(myConn, serviceTypeList.sql);

        //to get service time mapped from its time
        serviceTime = (Integer) mapOfServiceTypeTime.get(serviceType);

        return serviceTime;
    }
}
