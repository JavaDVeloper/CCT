/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barpiotr.util;

import barpiotr.data.Customer;
import barpiotr.data.ElementFromDBRetrievable;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author PiotrB. CCT - sb17018
 */
public class IfServiceUserExistsInDB {
    
    private List<ElementFromDBRetrievable> listToCheck;
    private String theLogin;
    private String thePass;
    private Customer customer;

    public IfServiceUserExistsInDB(List<ElementFromDBRetrievable> listToCheck, String theLogin) {
        this.listToCheck = listToCheck;
        this.theLogin = theLogin;
    }

    public IfServiceUserExistsInDB(List<ElementFromDBRetrievable> listToCheck, String theLogin, String thePass) {
        this.listToCheck = listToCheck;
        this.theLogin = theLogin;
        this.thePass = thePass;
    }
    
    //to check if login & pasword exist in the db
    public boolean ifExistsInDB(){
        
        boolean existance = false;
        Iterator iter = listToCheck.iterator();
        
        while(iter.hasNext() && existance == false){
            customer = (Customer)iter.next();
            if (theLogin.equals(customer.getLogin()) && thePass.equals(customer.getPassword())){
                existance = true;
            }
        }        
        return existance;
    }
    
    //to check if login exists in the db
    public boolean ifLoginExistsInDB(){
        
        boolean isNewCustomer = true;
        Iterator iter = listToCheck.iterator();
        
        while(iter.hasNext() && isNewCustomer == true){
            customer = (Customer)iter.next();
            if (theLogin.equals(customer.getLogin())){
                isNewCustomer = false;
            }
        }        
        return isNewCustomer;
    }

    public Customer getCustomer() {
        return customer;
    }
    
}
