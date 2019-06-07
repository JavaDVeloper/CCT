/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barpiotr.insertingData;

import java.sql.Connection;
import javax.sql.DataSource;

/**
 *
 * @author PiotrB. CCT - sb17018
 */
public class UpdatingPendingServiceExe_TEST {

    private UpdatingPendingService uPeS;
    private UpdatingPendingServiceInserting_TEST uPeSeIn;

    public UpdatingPendingServiceExe_TEST(String id, String status, Connection myConn) {
        this.uPeS = new UpdatingPendingService(id, status);
        this.uPeSeIn = new UpdatingPendingServiceInserting_TEST(myConn);
    }    
    
    
    public void insert() throws Exception{
        System.out.println(uPeS.getId()+ " " + uPeS.getStatus());
        uPeSeIn.insertToDatabase(uPeS);
    }
}
