/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barpiotr.Days;

import barpiotr.data.Customer;
import barpiotr.data.CustomerOfIdDAO;
import barpiotr.data.CustomerOfIdDAO_TEST;
import barpiotr.data.ElementFromDBRetrievable;
import barpiotr.data.ServiceTypeDAO;
import barpiotr.util.CheckedServiceTime;
import barpiotr.util.CheckedServiceTime_TEST;
import barpiotr.util.FinishTimeCalculation;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class App {

    private static final String FILE_NAME = "itext.pdf";

    public static void main(String[] args) throws SQLException, IllegalAccessException {

//    private static void writeUsingIText() {
//        
//        Rectangle rect = new Rectangle(210, 297);
//
//        Document document = new Document(rect);
//
//        try {
//
//            PdfWriter.getInstance(document, new FileOutputStream(new File(FILE_NAME)));
//
//            //open
//            document.open();
//
//            Paragraph p = new Paragraph();
//            p.add("This is my paragraph 1");
//            p.setAlignment(Element.ALIGN_CENTER);
//
//            document.add(p);
//
//            Paragraph p2 = new Paragraph();
//            p2.add("This is my paragraph 2"); //no alignment
//
//            document.add(p2);
//
//            Font f = new Font();
//            f.setStyle(Font.BOLD);
//            f.setSize(8);
//
//            document.add(new Paragraph("This is my paragraph 3", f));
//
//            //close
//            document.close();
//
//            System.out.println("Done");
//         
//        } catch (FileNotFoundException | DocumentException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//}
        String url = "jdbc:mysql://localhost:3306/gerbox";
        String user = "webstudent";
        String pass = "webstudent";

        Connection myConn = null;

//       LocalDate ld = LocalDate.parse("2019-05-20");
        try {
            // get a connection
            myConn = DriverManager.getConnection(url, user, pass);

            if (myConn == null) {
                System.out.println("I am NOT connected!");
            } else {
                System.out.println("I'm connected!");
            }
            
           List<ElementFromDBRetrievable> list = new ArrayList<>();
           
           CustomerOfIdDAO_TEST theCus = new CustomerOfIdDAO_TEST("4");
           list = theCus.getElementFromDBList(myConn, theCus.sql);
           
            for (ElementFromDBRetrievable c : list) {
                System.out.println(((Customer)c).getLogin());
            }//            
//        String [] typeOfService = {"major repair"};
//            
//        Map <String, String[]> theMap = new HashMap<>();
//        
//        theMap.put("service-type", typeOfService);
//        
//            System.out.println("The map created. Service type: " + typeOfService);
//            
//            CheckedServiceTime_TEST cST = new CheckedServiceTime_TEST(theMap);
//            
//            int serTime = cST.getServiceTime(myConn);
//
//            
//            String [] timeSlot = {"11:00"};
//                        String [] serTime2 = {String.valueOf(serTime)};
//                        
//             Map <String, String[]> theMap2 = new HashMap<>();
//        
//        theMap2.put("free-slot-time-start", timeSlot);
//        theMap2.put("service-time", serTime2);
//        
//        FinishTimeCalculation fTC = new FinishTimeCalculation(theMap2);
//            
//            System.out.println("Start time: " + timeSlot[0]);
//            System.out.println("Service time: " + cST.getServiceTime(myConn));
//            System.out.println("Finish time: " + fTC.getFinishTime());
//
//                
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        myConn.close();
    }
}
