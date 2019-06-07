/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barpiotr.data;

import java.io.Serializable;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author PiotrB. CCT - sb17018
 */
public class EngineTypeExe{
    
    List<ElementFromDBRetrievable> result;
   
    public EngineTypeExe(DataSource dataSource) throws Exception {
     EngineTypeDAO engineTypeList = new EngineTypeDAO();
     //information on result
     this.result = engineTypeList.getElementFromDBList(dataSource, engineTypeList.sql);
    }  

    public List<ElementFromDBRetrievable> getResult() {
        return result;
    }

    public void setResult(List<ElementFromDBRetrievable> result) {
        this.result = result;
    }
}
