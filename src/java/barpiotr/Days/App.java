/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barpiotr.Days;

import data.FreeHourToBook;
import data.FreeHoursList;
import data.FreeHoursList_TEST;

import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDateTime;

import java.util.List;

/**
 *
 * @author PiotrB. CCT - sb17018
 */
public class App {

    
    public static void main(String [] args) throws Exception{
        
        LocalDateTime ldt = LocalDateTime.parse(("2019-04-22 13:00:00").replace(" ","T"));
        System.out.println(ldt);
        ldt = ldt.plusHours(2);
        System.out.println(ldt);
        ldt = ldt.withHour(17);
        System.out.println(ldt);
    
        
        String url = "jdbc:mysql://localhost:3306/gerbox";
        String user = "webstudent";
        String pass = "webstudent";    
        
        Connection myConn =  null;
        
        FreeHoursList_TEST freeHourList;
        List<FreeHourToBook> theList;
                           
        try{
            // get a connection
            myConn = DriverManager.getConnection(url, user, pass);
            
            if(myConn==null){
                System.out.println("I am NOT connected!");
            }
            else{
                System.out.println("I'm connected!");
            }

            freeHourList = new FreeHoursList_TEST(myConn);
            
            theList = freeHourList.getFreeHoursList(2, ldt);
            
            for(FreeHourToBook freeHour : theList){
                System.out.println("Service starts: " + freeHour.getStart().getHour() + ", and finish: " + freeHour.getFinish().getHour());
            }

        }
        catch(Exception exc){
            exc.printStackTrace();
        }
        
        myConn.close();
        
    }
}
 

