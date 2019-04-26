/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barpiotr.driver;

import barpiotr.Days.Day;
import barpiotr.Days.WeekCreation;
import barpiotr.util.IfServiceUserExistsInDB;
import barpiotr.util.ServiceUser;
import data.ElementFromDBRetrievable;
import data.EngineTypeDAO;
import data.FreeHourToBook;
import data.FreeHoursList;
import data.VehicleMakeDAO;
import data.ServiceTypeDAO;
import data.VehicleModelDAO;
import data.VehicleTypeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 *
 * @author PiotrB. CCT - sb17018
 */
public class DriverControllerServlet extends HttpServlet {
    
    private DriverDAO allUserToCheck;
    
    @Resource(name="jdbc/gerbox")
    private DataSource dataSource;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DriverControllerServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DriverControllerServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("aaa");
        //create our student db util... and pass in the conn pool / datasource
        
        try{
            allUserToCheck = new DriverDAO(dataSource);
        }
        catch(Exception exc){
            throw new ServletException(exc);
        }   
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        

        try {
            //read the "command" parameter
            String theCommand = request.getParameter("availabilitycheckform");
            
            //if the command is missing, then default to listing students
            if (theCommand == null){
                theCommand = "AVAILABILITY_CHECK";
            }
            
            //route to the appropriate method
            switch(theCommand){
                case "AVAILABILITY_CHECK":  String target_page = "/driver_dashboard.jsp";
                                            request = showServiceTypes(request, response);
                                            request = serviceTypeChosen(request, response);
                                            request = modelChosen(request, response);
                                            request = makeChosen(request, response);                                            
                                            //to check if a user has chosen the service option
                                            if(!request.getAttribute("CHOSEN_SERVICE_TYPE").equals("0")){
                                                request = displayWeek(request, response);
                                                request = showSubpage(request, response);                                                
                                                request = displaySingleDay(request, response);
                                                request = showVehicleModels(request, response);
                                                request = showVehicleMakes(request, response);
                                                request = showVehicleTypes(request, response);
                                                request = showEngineTypes(request, response);
                                            }
                                            dispatchingResult(request, response, target_page);
                                            break;
                case "SINGLE_DAY_DISPLAY":  target_page = "/driver_dashboard.jsp";
                                            request = showServiceTypes(request, response);
                                            request = serviceTypeChosen(request, response);
                                            request = modelChosen(request, response);
                                            request = makeChosen(request, response);                                              
                                            request = displayWeek(request, response);
                                            request = showSubpage(request, response);
                                            request = displaySingleDay(request, response);
                                            request = showVehicleModels(request, response);
                                            request = showVehicleMakes(request, response);
                                            request = showVehicleTypes(request, response);
                                            request = showEngineTypes(request, response);
                                            dispatchingResult(request, response, target_page);
                                            break;                             
                case "BOOK_A_SPOT":         target_page = "/driver_dashboard.jsp";
                                            request = serviceTypeChosen(request, response);
                                            request = modelChosen(request, response);
                                            request = makeChosen(request, response);                                            
                                            request = displayWeek(request, response);
                                            request = showSubpage(request, response);
                                            request = displaySingleDay(request, response);
                                            request = showVehicleModels(request, response);
                                            request = showVehicleMakes(request, response);                                                  
                                            insertBooking(request, response);
                                            dispatchingResult(request, response, target_page);
                                            break;                                     
                                            
                default: displayWeek(request, response);
            }   
        }
        catch (Exception exc) {
            throw new ServletException(exc);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //get login credential from mechanic login form
        try {
            //read the "command" parameter
            String theCommand = request.getParameter("driverloggingform");
            
            //if the command is missing, then default to listing students
            if (theCommand == null){
                theCommand = "LOGIN";
            }
            
            //route to the appropriate method
            switch(theCommand){
                case "LOGIN":   String target_page = "/driver.jsp";
                                request = checkCredentials(request, response);
                                if (request.getAttribute("LOGIN_RESULT") == null){
                                   target_page = "/driver_dashboard.jsp";
                                   request = showServiceTypes(request, response);
                                } 
                                dispatchingResult(request, response, target_page);
                                break;
                                       
                default: checkCredentials(request, response);
            }
        }
        catch (Exception exc){
            throw new ServletException(exc);
        }
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    private HttpServletRequest checkCredentials(HttpServletRequest request, HttpServletResponse response) throws Exception{
       
        //gets data from login form
        String theLogin = request.getParameter("login");
        String thePass = request.getParameter("pass");
        
        //gets list of credential from db of employees
        List<ServiceUser> theList = allUserToCheck.getServiceUserList();
        
        //pass mechanics list to method for checking existance in db
        IfServiceUserExistsInDB ifExists = new IfServiceUserExistsInDB(theList, theLogin, thePass);
                      
        String result = null;
            
        //logs in if the credential exist in db
        if(!ifExists.ifExistsInDB()){
            result = "INVALID USER OR PASSWORD";
        }
            
        //place the object in request attribute
        request.setAttribute("LOGIN_RESULT", result);
            
        return request;
    }

    private HttpServletRequest showServiceTypes(HttpServletRequest request, HttpServletResponse response) throws Exception{
       
        ServiceTypeDAO serviceTypeList = new ServiceTypeDAO();
        
        //information on result
        List<ElementFromDBRetrievable> result = serviceTypeList.getElementFromDBList(dataSource, serviceTypeList.sql);
            
        request.setAttribute("LIST_OF_SERVICE_TYPES", result);
        
        return request;
    }   
    
    private HttpServletRequest showVehicleModels(HttpServletRequest request, HttpServletResponse response) throws Exception{
       
        VehicleModelDAO vehicleModelList = new VehicleModelDAO();
        
        //information on result
        List<ElementFromDBRetrievable> result = vehicleModelList.getElementFromDBList(dataSource, vehicleModelList.sql);
            
        request.setAttribute("LIST_OF_VEHICLE_MODELS", result);
       
        return request;
    }
    
    private HttpServletRequest showVehicleMakes(HttpServletRequest request, HttpServletResponse response) throws Exception{
       
        VehicleMakeDAO vehicleMakeList = new VehicleMakeDAO();
        
        //information on result
        List<ElementFromDBRetrievable> result = vehicleMakeList.getElementFromDBList(dataSource, vehicleMakeList.sql);       
            
        request.setAttribute("LIST_OF_VEHICLE_MAKES", result);
        
        return request;
    }  
    
    private HttpServletRequest showVehicleTypes(HttpServletRequest request, HttpServletResponse response) throws Exception{
       
        VehicleTypeDAO vehicleTypeList = new VehicleTypeDAO();
        
        //information on result
        List<ElementFromDBRetrievable> result = vehicleTypeList.getElementFromDBList(dataSource, vehicleTypeList.sql);       
            
        request.setAttribute("LIST_OF_VEHICLE_TYPES", result);
        
        return request;
    }  
    
    private HttpServletRequest showEngineTypes(HttpServletRequest request, HttpServletResponse response) throws Exception{
       
        EngineTypeDAO engineTypeList = new EngineTypeDAO();
        
        //information on result
        List<ElementFromDBRetrievable> result = engineTypeList.getElementFromDBList(dataSource, engineTypeList.sql);       
            
        request.setAttribute("LIST_OF_ENGINE_TYPES", result);
        
        return request;
    }
    
    private HttpServletRequest displayWeek(HttpServletRequest request, HttpServletResponse response) throws Exception{
       
        int weekProgression;
        int howManyWeeksAhead;
        
        String ifReversingWeek = null;
        ifReversingWeek = request.getParameter("clicked-reverse");
        
        //if reverseWeek button wasn't clicked
        if(ifReversingWeek==null){
             
            try{
                weekProgression = Integer.parseInt(request.getParameter("how_many_weeks_ahead"));
                howManyWeeksAhead = weekProgression + 1;
            }
            catch(Exception e){
                weekProgression = 0;
                howManyWeeksAhead = 0;
            }
        }       
        //if reverseWeek button was clicked         
        else{
             
            try{
                weekProgression = Integer.parseInt(request.getParameter("how_many_weeks_ahead"));
                if(weekProgression==0){
                    howManyWeeksAhead = 0;
                }
                else{
                    howManyWeeksAhead = weekProgression - 1;
                }
            }
            catch(Exception e){
                weekProgression = 0;
                howManyWeeksAhead = 0;
            }  
        }
            
        //limits progression to 2 weeks ahead
        if(howManyWeeksAhead > 2){
            howManyWeeksAhead = 2;
        }
        
        //returns 7 days starting from today
        WeekCreation weekDays = new WeekCreation();   
        Day [] result = weekDays.getDays(howManyWeeksAhead);
        
        //place the object in request attribute
        request.setAttribute("WEEK_DAYS_TO_CHOOSE", result); 
                    
        //sets whch which (how many ahead) should be shown
        //int howManyWeeksAhead = 0;
        request.setAttribute("DAYS_AHEAD", howManyWeeksAhead);
        
        return request;
    }
    
     public void progressWeek(HttpServletRequest request, HttpServletResponse response) throws Exception{
            
        int weekProgression;
        
        try{
            weekProgression = Integer.parseInt(request.getParameter("how_many_weeks_ahead"));
        }
        catch(Exception e){
            weekProgression = 0;
        }
            int howManyWeeksAhead = weekProgression + 1;
            
            //limits progression to 2 weeks ahead
            if(howManyWeeksAhead > 2){
                howManyWeeksAhead = 2;
            }
            request.setAttribute("DAYS_AHEAD", howManyWeeksAhead);

            WeekCreation weekDays = new WeekCreation();
            Day [] result = weekDays.getDays(howManyWeeksAhead);

            request.setAttribute("LOGIN_RESULT", result);
    }
    
    private HttpServletRequest displaySingleDay(HttpServletRequest request, HttpServletResponse response) throws Exception{
        
        Day d;
        FreeHoursList freeHours;
        
        //set the day in the header of the table with day's hours
        String dayName = request.getParameter("day_name");
        String dayOfMonth = request.getParameter("day_of_month");
        String currentMonth = request.getParameter("current_month");
        String currentMonthNumber = request.getParameter("current_month_number");
        String currentYear = request.getParameter("current_year");
        
        String serviceTypeChosen = request.getParameter("service-type");
        
        //when parameters are not set yet / the day square hasn't been clicked yet
        if (dayName == null){
            WeekCreation weekDays = new WeekCreation();   
            Day [] result = weekDays.getDays(0);
            //set the day in the header of the table with day's hours
            d = new Day (result[0].getDayName(), result[0].getDayInMonth(), result[0].getCurrentMonth(), result[0].getCurrentMonthInNumber(), result[0].getCurrentYear());    
        }else{          
            d = new Day (dayName, dayOfMonth, currentMonth, currentMonthNumber, currentYear);
        }
                
        //to get time of serviceType by its name chosen
            //they both need to be mapped as per name,time pairs
        ServiceTypeDAO allServiceType = new ServiceTypeDAO();
        List<ElementFromDBRetrievable> serviceTypeList = allServiceType.getElementFromDBList(dataSource, allServiceType.sql);
        
        Map<String, Integer> serviceTypeTimeMapped;
        serviceTypeTimeMapped = allServiceType.getElementsMapFromDB(serviceTypeList);
        
        int serviceTime = serviceTypeTimeMapped.get(serviceTypeChosen);
        
        //to pass a date to check which time slots are free
        LocalDateTime checkedDate = LocalDateTime.parse(d.getCurrentYear()+"-"+d.getCurrentMonthInNumber()+"-"+d.getDayInMonth()+"T00:00");
        
        freeHours = new FreeHoursList(dataSource);
        List<FreeHourToBook> freeHoursList = new ArrayList<>();
        freeHoursList = freeHours.getFreeHoursList(serviceTime, checkedDate);
        
        //place the object in request attribute
        request.setAttribute("SINGLE_DAY", d);
        request.setAttribute("FREE_HOURS", freeHoursList);
        
        return request;
    }
    
    private HttpServletRequest serviceTypeChosen(HttpServletRequest request, HttpServletResponse response) throws Exception{
    
        String serviceTypeChosen = request.getParameter("service-type");
        request.setAttribute("CHOSEN_SERVICE_TYPE", serviceTypeChosen);
           
        return request;
    }
       
    private HttpServletRequest modelChosen(HttpServletRequest request, HttpServletResponse response) throws Exception{
    
        String modelChosen = request.getParameter("vehicle-model");
        request.setAttribute("CHOSEN_VEHICLE_MODEL", modelChosen);
           
        return request;
    }
    
         
    private HttpServletRequest makeChosen(HttpServletRequest request, HttpServletResponse response) throws Exception{
    
        String makeChosen = request.getParameter("vehicle-make");
        request.setAttribute("CHOSEN_VEHICLE_MAKE", makeChosen);
           
        return request;
    }
 
    private HttpServletRequest showSubpage(HttpServletRequest request, HttpServletResponse response) throws Exception{
    
        //include page in page
        request.setAttribute("PAGE_INCLUSION", "true");   
           
        return request;
    }
    
    private void insertBooking(HttpServletRequest request, HttpServletResponse response) throws Exception{
    
        //include page in page
        String serviceChosenHour = request.getParameter("free_spot_hour");
        String serviceChosenDay = request.getParameter("free_spot_day");
        String serviceChosenMonth = request.getParameter("free_spot_month");
        String serviceChosenYear = request.getParameter("free_spot_year");
        
        
//        request.setAttribute("PAGE_INCLUSION", "true");   
//           
//        return request;
    }
    
 
            
    private void dispatchingResult(HttpServletRequest request, HttpServletResponse response, String target_page) throws Exception{
        //sends to jsp page
        RequestDispatcher dispatcher = request.getRequestDispatcher(target_page);
        dispatcher.forward(request, response);
    }    
    
}

