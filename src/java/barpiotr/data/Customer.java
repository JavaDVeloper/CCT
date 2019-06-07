/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barpiotr.data;

import java.io.Serializable;

/**
 *
 * @author PiotrB. CCT - sb17018
 */
public class Customer implements ElementFromDBRetrievable, Serializable {
    
    private int id;
    private String firstName;
    private String lastName;
    private String login;
    private int phone;
    private String password;
    
    public Customer(){}

    public Customer(String firstName, String lastName, String login, int phone, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.phone = phone;
        this.password = password;
    }

    public Customer(int id, String firstName, String lastName, String login, int phone, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.phone = phone;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
