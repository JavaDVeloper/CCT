/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barpiotr.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PiotrB. CCT - sb17018
 */
public class InputFieldsDataUser {
    
    String theFirstName;
    String theLastName;
    String theLogin;
    String thePhone;
    String thePass;

    public InputFieldsDataUser() {
    }

    public InputFieldsDataUser(String theLogin, String thePass) {
        this.theLogin = theLogin;
        this.thePass = thePass;
    }

    public InputFieldsDataUser(String theFirstName, String theLastName, String theLogin, String thePhone, String thePass) {
        this.theFirstName = theFirstName;
        this.theLastName = theLastName;
        this.theLogin = theLogin;
        this.thePhone = thePhone;
        this.thePass = thePass;
    }

    public String getTheFirstName() {
        return theFirstName;
    }

    public void setTheFirstName(String theFirstName) {
        this.theFirstName = theFirstName;
    }

    public String getTheLastName() {
        return theLastName;
    }

    public void setTheLastName(String theLastName) {
        this.theLastName = theLastName;
    }

    public String getTheLogin() {
        return theLogin;
    }

    public void setTheLogin(String theLogin) {
        this.theLogin = theLogin;
    }

    public String getThePhone() {
        return thePhone;
    }

    public void setThePhone(String thePhone) {
        this.thePhone = thePhone;
    }

    public String getThePass() {
        return thePass;
    }

    public void setThePass(String thePass) {
        this.thePass = thePass;
    }
        
   
    
}
