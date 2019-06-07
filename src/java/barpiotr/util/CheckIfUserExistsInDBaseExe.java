/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barpiotr.util;

import barpiotr.data.Customer;
import barpiotr.data.CustomerDAO;
import barpiotr.data.CustomerOfIdDAO;
import barpiotr.data.ElementFromDBRetrievable;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;

/**
 *
 * @author PiotrB. CCT - sb17018
 */
public class CheckIfUserExistsInDBaseExe {

    private Boolean existance;

    private String login;
    private String password;
    private String id;

    private CustomerDAO theCustomers;
    private CustomerOfIdDAO theCustomerOfId;
    private List<ElementFromDBRetrievable> customersListToCheck;

    private IfServiceUserExistsInDB ifUserExists;

    private Customer customer;

    //Constructor
    public CheckIfUserExistsInDBaseExe(Map<String, String[]> userParam) {
        for (String key : userParam.keySet()) {
            switch (key) {
                case "login":
                    this.login = (String) userParam.get(key)[0];
                    break;
                case "pass":
                    this.password = (String) userParam.get(key)[0];
                    break;
            }
        }
        try {
            this.id = (String) userParam.get("customer-id")[0];
        } catch (Exception e) {
            this.id = null;
        }
    }

    public Boolean ifCredentialsExist(DataSource dataSource) throws Exception {
        //to get the list to check against
        if (id != null) {
            theCustomerOfId = new CustomerOfIdDAO(id);
            customersListToCheck = theCustomerOfId.getElementFromDBList(dataSource, theCustomerOfId.sql);
        } else {
        theCustomers = new CustomerDAO();
        customersListToCheck = theCustomers.getElementFromDBList(dataSource, theCustomers.sql);
        }

        if (id != null) {
            login = ((Customer) customersListToCheck.get(0)).getLogin();
            password = ((Customer) customersListToCheck.get(0)).getPassword();
        }
        //to check if input exists in the db
        ifUserExists = new IfServiceUserExistsInDB(customersListToCheck, login, password);
        existance = ifUserExists.ifExistsInDB();
        return existance;
    }

    public Boolean ifLoginExists(DataSource dataSource) throws Exception {
        //to get the list to check against
        theCustomers = new CustomerDAO();
        customersListToCheck = theCustomers.getElementFromDBList(dataSource, theCustomers.sql);

        //to check if input exists in the db
        ifUserExists = new IfServiceUserExistsInDB(customersListToCheck, login, password);
        existance = ifUserExists.ifLoginExistsInDB();
        return existance;
    }

    public Customer getCustomer(DataSource dataSource) throws Exception {
        ifCredentialsExist(dataSource);
        customer = ifUserExists.getCustomer();
        return customer;
    }
}
