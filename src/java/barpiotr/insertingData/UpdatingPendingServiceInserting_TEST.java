/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barpiotr.insertingData;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;

/**
 *
 * @author PiotrB. CCT - sb17018
 */
public class UpdatingPendingServiceInserting_TEST extends InsertingData {
    
    
    Connection myConn = null;

    private UpdatingPendingService updatingDetails;

    public UpdatingPendingServiceInserting_TEST(Connection myConn) {
        this.myConn = myConn;
    }

    @Override
    public void insertToDatabase(InsertedData insertedData) throws SQLException, Exception {

        updatingDetails = (UpdatingPendingService) insertedData;
        try {


            // create sql for insert
            String sql = "UPDATE service "
                    + "SET statusName = ? "
                    + "WHERE serviceId = ?";
            
                        // create sql for insert
//            String sql2 = "UPDATE service "
//                    + "SET statusName = " + updatingDetails.getStatus()
//                    + " WHERE serviceId = " + updatingDetails.getId();

            myStmt = myConn.prepareStatement(sql);

            // set the param values for the student
            myStmt.setString(1, updatingDetails.getStatus());
            myStmt.setString(2, updatingDetails.getId());
            
            System.out.println(updatingDetails.getId());
            System.out.println(updatingDetails.getStatus());
            System.out.println(sql);
            System.out.println(myStmt);

            // execute sql insert
            myStmt.executeUpdate();
            
            System.out.println(updatingDetails.getId());
            System.out.println(updatingDetails.getStatus());
       //     System.out.println(sql2);


        } finally {
            //close JDBC objects
            super.close(myConn, myStmt, null);
        }
    }

}
