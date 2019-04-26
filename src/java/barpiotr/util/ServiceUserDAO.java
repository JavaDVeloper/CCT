/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barpiotr.util;

import java.util.List;

/**
 *
 * @author PiotrB. CCT - sb17018
 */
public interface ServiceUserDAO {
    
    public List<ServiceUser> getServiceUserList() throws Exception;
    
}
