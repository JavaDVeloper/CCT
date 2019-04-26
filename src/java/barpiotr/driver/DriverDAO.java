package barpiotr.driver;

import barpiotr.util.ServiceUser;
import barpiotr.util.ServiceUserDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PiotrB. CCT - sb17018
 */
public class DriverDAO implements ServiceUserDAO {
    
    private DataSource dataSource;
    
    public DriverDAO (DataSource theDataSource){
        this.dataSource = theDataSource;
    }
    
    /**
     *
     * @return
     * @throws Exception
     */
    @Override
    public List<ServiceUser> getServiceUserList() throws Exception {
        
        List<ServiceUser> drivers = new ArrayList<>();
        
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRS = null;
        
        try{
            // get a connection
            myConn = dataSource.getConnection();
            
            if (myConn != null){
                System.out.println("I've got connected");
            }
            
            //create sql statement
            String sql = "SELECT * FROM customer";
            myStmt = myConn.createStatement();

            //execute query
            myRS = myStmt.executeQuery(sql);
            
            if (myRS != null){
                System.out.println(myRS.toString());
            }

            //process result set
            while (myRS.next()){
               
               //retrieve data from result set row
               String driverId = myRS.getString("customerId");
               String firstName = myRS.getString("firstName");
               String lastName = myRS.getString("lastName");
               String driverEmail = myRS.getString("email");
               int driverPhone= myRS.getInt("phone");
               String driverPass = myRS.getString("password");
                           
               
               //create new user object
               Driver tempDriver = new Driver(driverEmail, driverPass);
               System.out.println(tempDriver.getPassword());
               //add it to the list of students
               drivers.add(tempDriver);
            }
            
            System.out.println("Here, I am the object with list of students: " + drivers.toString());
                        
            return drivers;
        }
        finally{
            //close JDBC objects
            close(myConn, myStmt, myRS); 
        }
        
    }
        
    private void close (Connection myConn, Statement myStmt, ResultSet myRs){
        
        try{
            if(myRs != null){
                myRs.close();
            }
            
            if(myStmt != null){
                myStmt.close();
            }
                       
            if(myConn != null){
                myConn.close();  //doesn't really close it... just puts back in connection pool
            }
        }
        catch(Exception exc){
            exc.printStackTrace();
        }      
    }
 
}
