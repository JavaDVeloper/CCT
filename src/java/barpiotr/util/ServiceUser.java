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
public interface ServiceUser {
    
    int id = 0;
    String login= null;
    String password = null;
    String firstName = null;

    public int getId();
    public String getLogin();
    public String getPassword();   
    public String getFirstName();   
    
}
