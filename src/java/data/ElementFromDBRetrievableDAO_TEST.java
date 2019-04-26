/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;


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
public abstract class ElementFromDBRetrievableDAO_TEST {
    
    //DataSource dataSource;
    
    public String sql = "";
    
    Connection myConn = null;
    Statement myStmt = null;
    ResultSet myRS = null;
        
    List<ElementFromDBRetrievable> elementList = new ArrayList<>();
       
    public List<ElementFromDBRetrievable> getElementFromDBList(Connection myConn, String sql) throws Exception{

        myRS = getSetFromDB(myConn, sql);
            
        elementList = getElementsFromDB(myRS);

//        close(myConn, myStmt, myRS);

        return elementList;
    }   
    

    public ResultSet getSetFromDB(Connection myConn, String sql) throws Exception{    

        try{
            
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
    
    //abstract class to override in implementating classes
    public abstract List<ElementFromDBRetrievable> getElementsFromDB(ResultSet myRS) throws Exception;
        
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
    

    @Override
    public String toString() {
        return "ElementFromDBRetrievableDAO2{" + "elementList=" + elementList + '}';
    }
                
}
