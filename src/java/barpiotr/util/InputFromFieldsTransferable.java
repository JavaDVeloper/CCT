/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barpiotr.util;

/**
 *
 * @author PiotrB. CCT - sb17018
 */
public abstract class InputFromFieldsTransferable {
    
    String theFirstName;
    String theLastName;
    String theLogin;
    String thePhone;
    String thePass;
 
    public abstract Boolean ifAllFieldsFilled();
    
    
}
