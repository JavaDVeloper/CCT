/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barpiotr.data;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author PiotrB. CCT - sb17018
 */
public abstract class ElementFromDBRetrievableDAO {
    
    DataSource dataSource;
    
    public String sql = "";
    
    Connection myConn = null;
    Statement myStmt = null;
    ResultSet myRS = null;
        
    public List<ElementFromDBRetrievable> elementList = new ArrayList<>();
       
    public List<ElementFromDBRetrievable> getElementFromDBList(DataSource dataSource, String sql) throws Exception{
        myRS = getSetFromDB(dataSource, sql);      
        elementList = getElementsFromDB(myRS);
        close(myConn, myStmt, myRS);
        return elementList;
    }   
    
    public ResultSet getSetFromDB(DataSource dataSource, String sql) throws Exception{    
        try{
            //get connection
            myConn = dataSource.getConnection();
            //create sql statement
            myStmt = myConn.createStatement();
            //execute query
            myRS = myStmt.executeQuery(sql);
            return myRS;
        }
        finally{
            //close JDBC objects
        }
    }
        
    public void close(Connection myConn, Statement myStmt, ResultSet myRs){
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

    public String getSql() {
        return sql;
    }
    
    //abstract class to override in implementating classes
    public abstract List<ElementFromDBRetrievable> getElementsFromDB(ResultSet myRS) throws Exception;

    @Override
    public String toString() {
        return "ElementFromDBRetrievableDAO2{" + "elementList=" + elementList + '}';
    }               
}
