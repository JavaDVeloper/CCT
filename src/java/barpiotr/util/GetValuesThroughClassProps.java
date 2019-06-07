/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barpiotr.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author PiotrB. CCT - sb17018
 */
public abstract class GetValuesThroughClassProps {

    Field[] fields;
    WarningsList wl = new WarningsList();
    HashMap hm;
    Object userInputs;

    List<String> theList;

    public GetValuesThroughClassProps(Object userInputs) {
        
        fields = userInputs.getClass().getDeclaredFields();
        System.out.println(fields.length);
        for (Field f : fields) {
            System.out.println(f.getName());
        }
        this.userInputs = userInputs;
    }

    public List<String> getEmptyAttList() throws IllegalArgumentException, IllegalAccessException {
        theList = new ArrayList<>();
        hm = wl.mapFieldsNamesToAttWhenEmpty();
        for (Field f : fields) {
            if(f.get(userInputs)!=null){
                theList.add((String) hm.get(f.getName()));
            }    
        }
        return theList;
    }

    public List<String> getWarningsList() throws IllegalAccessException {
        theList = new ArrayList<>();
        hm = wl.mapFieldsNamesToWarnings();
        for (Field f : fields) {
            if(f.get(userInputs)!=null){
                if((f.get(userInputs).equals(""))){
                    theList.add((String) hm.get(f.getName()));
                }
                else{
                    theList.add("");
                }
            }   
        }
        return theList;
    }

    public List<String> getReturnedAttList() throws IllegalAccessException {
        theList = new ArrayList<>();
        hm = wl.mapFieldsNamesToAttWhenReturned();
        for (Field f : fields) {
            if(f.get(userInputs)!=null){
                theList.add((String) hm.get(f.getName()));
            }   
        }
        return theList;
    }

    public List<String> getPropsValuesList() throws IllegalArgumentException, IllegalAccessException {
        theList = new ArrayList<>();
        for (Field f : fields) {
            if(f.get(userInputs)!=null){
                theList.add((String) f.get(userInputs));
            }
        }
        return theList;
    }

    public Object getUserInputs() {
        return userInputs;
    }

    public void setUserInputs(Object userInputs) {
        this.userInputs = userInputs;
    }

    
    @Override
    public String toString() {
        return "GetValuesThroughClassProps{" + "fields=" + fields + ", wl=" + wl + ", hm=" + hm + ", userInputs=" + userInputs + ", theList=" + theList + '}';
    }

}
