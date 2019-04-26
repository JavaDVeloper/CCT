/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barpiotr.util;

import java.util.Iterator;
import java.util.List;
import barpiotr.mechanic.*;

/**
 *
 * @author PiotrB. CCT - sb17018
 */
public class IfServiceUserExistsInDB {
    
    private List<ServiceUser> listToCheck;
    private String theLogin;
    private String thePass;
    private ServiceUser user;

    public IfServiceUserExistsInDB(List<ServiceUser> listToCheck, String theLogin, String thePass) {
        this.listToCheck = listToCheck;
        this.theLogin = theLogin;
        this.thePass = thePass;
    }
    
    
    public boolean ifExistsInDB(){
        
        boolean existance = false;
        Iterator iter = listToCheck.iterator();
        
        while(iter.hasNext() && existance == false){
            user = (ServiceUser)iter.next();
            if (theLogin.equals(user.getLogin()) && thePass.equals(user.getPassword())){
                existance = true;
            }
        }        
        return existance;
    }
}
