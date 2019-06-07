/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barpiotr.insertingData;

import barpiotr.data.AvailableMechanicDAO;
import barpiotr.data.Mechanic;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;

/**
 *
 * @author PiotrB. CCT - sb17018
 */
public class BookingDetailsConfirming extends InsertingData {

    BookingDetails bookingDetails;
    int enteredVehicleId;
    AvailableMechanicDAO availMechanics;
    Mechanic firstAvailMechanic;
    int availMechanicId;


    public BookingDetailsConfirming() {
    }

    public BookingDetailsConfirming(DataSource dataSource) {
        super.dataSource = dataSource;
    }

    @Override
    public void insertToDatabase(InsertedData insertedData) throws SQLException, Exception {

        bookingDetails = (BookingDetails) insertedData;
        String sql;
        ResultSet rs;
        try {
            enteredVehicleId = Integer.parseInt(bookingDetails.getTheVehicleId());
        }
        catch (Exception e){
            enteredVehicleId = 0;
        }
        try{
            availMechanics = new AvailableMechanicDAO();
            firstAvailMechanic = (Mechanic) availMechanics.getElementFromDBList(dataSource, availMechanics.sql).get(0);
            availMechanicId = firstAvailMechanic.getEmployeeId();

            // get a connection
            myConn = dataSource.getConnection();

            if (enteredVehicleId == 0) {
                // create sql for insert
                sql = "INSERT INTO vehicle (registration, colour, customerId, vehicleMakeName, vehicleModelName, engineTypeName, vehicleTypeName) "
                        + "VALUES (?,?,?,?,?,?,?)";
                //to get PRIMARY KEY of just-inserted
                myStmt = myConn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                // set the param values
                myStmt.setString(1, bookingDetails.getTheVehicleRegistration());
                myStmt.setString(2, bookingDetails.getTheVehicleColor());
                myStmt.setString(3, bookingDetails.getTheCustomerId());
                myStmt.setString(4, bookingDetails.getTheVehicleMake());
                myStmt.setString(5, bookingDetails.getTheVehicleModel());
                myStmt.setString(6, bookingDetails.getTheEngineType());
                myStmt.setString(7, bookingDetails.getTheVehicleType());

                // execute sql insert
                myStmt.executeUpdate();

                //to get ID of that vehicle entered
                rs = myStmt.getGeneratedKeys();
                rs.next();
                enteredVehicleId = rs.getInt(1);
            }

            sql = "INSERT INTO service (description, serviceTypeName, statusName) "
                    + "VALUES (?,?,?)";

            //to get PRIMARY KEY of just-inserted
            myStmt = myConn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            // set the param values for the student
            myStmt.setString(1, bookingDetails.getTheServiceDescription());
            myStmt.setString(2, bookingDetails.getTheServiceType());
            myStmt.setString(3, "booked");

            // execute sql insert
            myStmt.executeUpdate();

            //to get ID of that service entered
            rs = myStmt.getGeneratedKeys();
            rs.next();
            int enteredServiceId = rs.getInt(1);

            sql = "INSERT INTO assigned_to VALUES (?,?,?,?,?)";

            myStmt = myConn.prepareStatement(sql);

            // set the param values for the student
            myStmt.setInt(1, availMechanicId);
            myStmt.setInt(2, enteredServiceId);
            myStmt.setInt(3, enteredVehicleId);
            String startTime = bookingDetails.getTheFreeSlotYear() + "-" + bookingDetails.getTheFreeSlotMonth() + "-"
                    + bookingDetails.getTheFreeSlotDay() + " " + bookingDetails.getTheFreeSlotTimeStart();
            myStmt.setString(4, startTime);
            String finishTime = bookingDetails.getTheFreeSlotYear() + "-" + bookingDetails.getTheFreeSlotMonth() + "-"
                    + bookingDetails.getTheFreeSlotDay() + " " + bookingDetails.getTheFreeSlotTimeFinish();
            myStmt.setString(5, finishTime);

            // execute sql insert
            myStmt.executeUpdate();
        } finally {
            //close JDBC objects
            super.close(myConn, myStmt, null);
        }
    }

}
