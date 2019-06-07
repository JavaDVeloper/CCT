/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barpiotr.insertingData;

import javax.sql.DataSource;

/**
 *
 * @author PiotrB. CCT - sb17018
 */
public class UpdatingPendingServiceExe {

    private UpdatingPendingService uPeS;
    private UpdatingPendingServiceInserting uPeSeIn;

    public UpdatingPendingServiceExe(String [] serviceData, DataSource dataSource) throws Exception {
        this.uPeS = new UpdatingPendingService(serviceData[0], serviceData[10]);
        this.uPeSeIn = new UpdatingPendingServiceInserting(dataSource);
        uPeSeIn.insertToDatabase(uPeS);
    }    

    public UpdatingPendingService getuPeS() {
        return uPeS;
    }

    public void setuPeS(UpdatingPendingService uPeS) {
        this.uPeS = uPeS;
    }

    public UpdatingPendingServiceInserting getuPeSeIn() {
        return uPeSeIn;
    }

    public void setuPeSeIn(UpdatingPendingServiceInserting uPeSeIn) {
        this.uPeSeIn = uPeSeIn;
    }
       
}
