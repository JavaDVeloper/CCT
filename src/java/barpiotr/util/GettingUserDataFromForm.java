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
public class GettingUserDataFromForm {
    
    private String theFirstName;
    private String theLastName;
    private String theLogin;
    private String thePhone;
    private String thePass;
    
    InputFieldsDataUser inputData;

    public GettingUserDataFromForm() {
    }
    
    

    public GettingUserDataFromForm(HttpServletRequest request, HttpServletResponse response){
        try{
            theFirstName = request.getParameter("first-name");
        }
        catch(Exception e){
            theFirstName = "";
        }
        try{
            theLastName = request.getParameter("last-name");
        }
        catch(Exception e){
            theLastName = "";
        }
        try{
            theLogin = request.getParameter("login");
        }
        catch(Exception e){
            theLogin = "";
        }
        try{
            thePhone = request.getParameter("phone");
        }
        catch(Exception e){
            thePhone = "";
        }
        try{
            thePass = request.getParameter("pass");
        }
        catch(Exception e){
            thePass = "";
        }
    }   

    public InputFieldsDataUser getInputDataUser() {
        inputData = new InputFieldsDataUser(theFirstName, theLastName, theLogin, thePhone, thePass);
        return inputData;
    }
}
