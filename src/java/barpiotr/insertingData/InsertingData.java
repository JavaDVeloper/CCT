/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barpiotr.insertingData;

import barpiotr.data.AvailableMechanicDAO;
import barpiotr.data.Mechanic;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;

/**
 *
 * @author PiotrB. CCT - sb17018
 */
public abstract class InsertingData {
    
    DataSource dataSource;
    
    Connection myConn = null;
    PreparedStatement myStmt = null;
 
    public abstract void insertToDatabase(InsertedData insertedData) throws SQLException, Exception;

    public void close (Connection myConn, Statement myStmt, ResultSet myRs){
        
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
