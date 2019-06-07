/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barpiotr.insertingData;

import java.sql.SQLException;
import javax.sql.DataSource;

/**
 *
 * @author PiotrB. CCT - sb17018
 */
public class UpdatingPendingServiceInserting extends InsertingData {

    private UpdatingPendingService updatingDetails;

    public UpdatingPendingServiceInserting(DataSource dataSource) {
        super.dataSource = dataSource;
    }

    @Override
    public void insertToDatabase(InsertedData insertedData) throws SQLException, Exception {

        updatingDetails = (UpdatingPendingService) insertedData;
        try {
            // get a connection
            myConn = dataSource.getConnection();

            // create sql for insert
            String sql = "UPDATE service SET statusName = ? WHERE serviceId = ?";

            myStmt = myConn.prepareStatement(sql);

            // set the param values for the student
            myStmt.setString(1, updatingDetails.getStatus());
            myStmt.setString(2, updatingDetails.getId());

            // execute sql insert
            myStmt.executeUpdate();

        } finally {
            //close JDBC objects
            super.close(myConn, myStmt, null);
        }
    }
}
