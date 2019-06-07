/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barpiotr.insertingData;

import barpiotr.data.Customer;
import java.sql.SQLException;
import javax.sql.DataSource;

/**
 *
 * @author PiotrB. CCT - sb17018
 */
public class InsertNewCustomer extends InsertingData{
    
    Customer customer;
    
    public InsertNewCustomer() {}
    
    public InsertNewCustomer(DataSource dataSource) {
        super.dataSource = dataSource;
    }

    @Override
    public void insertToDatabase(InsertedData insertedData) throws SQLException, Exception {
        
        customer = (Customer)insertedData;
        
        try{
            // get a connection
            myConn = dataSource.getConnection();
            
            // create sql for insert
            String sql = "INSERT INTO customer (firstName, lastName, email, phone, password) "
                            + "VALUES (?,?,?,?,?)";
            
            myStmt = myConn.prepareStatement(sql);
            
            // set the param values for the student
            myStmt.setString(1, customer.getFirstName());
            myStmt.setString(2, customer.getLastName());
            myStmt.setString(3, customer.getLogin());
            myStmt.setInt(4, customer.getPhone());            
            myStmt.setString(5, customer.getPassword());
            
            // execute sql insert
            myStmt.executeUpdate();
        }         
        finally{
            //close JDBC objects
            super.close(myConn, myStmt, null); 
        }
    }

    public void insertToDatabase(Customer newCustomer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
