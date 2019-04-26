package barpiotr.mechanic;

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
public class MechanicDAO implements ServiceUserDAO{
    
      private DataSource dataSource;
    
    public MechanicDAO (DataSource theDataSource){
        this.dataSource = theDataSource;
    }

    @Override
    public List<ServiceUser> getServiceUserList() throws Exception {
           
        List<ServiceUser> mechanics = new ArrayList<>();
        
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
            String sql = "SELECT * FROM employee";
            myStmt = myConn.createStatement();

            //execute query
            myRS = myStmt.executeQuery(sql);
            
            if (myRS != null){
                System.out.println(myRS.toString());
            }

            //process result set
            while (myRS.next()){
               
               //retrieve data from result set row
               String empId = myRS.getString("emp_id");
               String firstName = myRS.getString("first_name");
               String lastName = myRS.getString("last_name");
               String empLogin = myRS.getString("emp_login");
               String empPass = myRS.getString("emp_pass");
                           
               
               //create new user object
               Mechanic tempMechanic = new Mechanic(empLogin, empPass);
               System.out.println(tempMechanic.getPassword());
               //add it to the list of students
               mechanics.add(tempMechanic);
            }
            
            System.out.println("Here, I am the object with list of students: " + mechanics.toString());
                        
            return mechanics;
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
