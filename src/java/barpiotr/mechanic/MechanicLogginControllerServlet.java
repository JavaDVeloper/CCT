/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barpiotr.mechanic;

import barpiotr.Days.Day;
import barpiotr.Days.WeekCreation;
import barpiotr.util.IfServiceUserExistsInDB;
import barpiotr.util.ServiceUser;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class MechanicLogginControllerServlet extends HttpServlet {
    
    private MechanicDAO allUserToCheck;
    
    @Resource(name="jdbc/garbox_employee")
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
            out.println("<title>Servlet MechanicLogginControllerServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MechanicLogginControllerServlet at " + request.getContextPath() + "</h1>");
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
            allUserToCheck = new MechanicDAO(dataSource);
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
        String theCommand = request.getParameter("mechanicloggingform");
            
        try {
                   
            if (theCommand == null){
                theCommand = "SINGLE_DAY_LOAD";
            }
            
            //route to the appropriate method
            switch(theCommand){
                case "SINGLE_DAY_LOAD": displaySingleDay(request, response);
                    break;
                //if forward button clicked ">" in week squares             
                case "WEEK_AHEAD": progressWeek(request, response);
                    break;      
                //if backward button clicked "<" in week squares         
                case "WEEK_BACK": reverseWeek(request, response);
                    break;   
                                       
                default: displaySingleDay(request, response);
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
            String theCommand = request.getParameter("mechanicloggingform");
            
            //if the command is missing, then default to listing students
            if (theCommand == null){
                theCommand = "LIST";
            }
            
            //route to the appropriate method
            switch(theCommand){
                case "LOGIN": checkCredentials(request, response);
                            break;
                            
                case "SINGLE_DAY_LOAD": displaySingleDay(request, response);
                            break;            
                                       
                default: checkCredentials(request, response);
            }
            
            //list the students ... in MVC fashion
            //listStudents(request, response);
        }
        catch (Exception exc) {
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

    private void checkCredentials(HttpServletRequest request, HttpServletResponse response) throws Exception{
       
        //gets data from form
        String theLogin = request.getParameter("login");
        String thePass = request.getParameter("pass");
        
        //gets list of credential from db of employees
        List<ServiceUser> theList = allUserToCheck.getServiceUserList();
        
        //pass mechanics list to method for checking existance in db
        IfServiceUserExistsInDB ifExists = new IfServiceUserExistsInDB(theList, theLogin, thePass);
        
        //information on result
        String target_page;
        String failResult;
        
        //logs in if the credential exist in db
        if(ifExists.ifExistsInDB()){
            
          //returns 7 days starting from today
            WeekCreation weekDays = new WeekCreation();
            
            Day [] result = weekDays.getDays(0);
            target_page = "/employee_dashboard.jsp";
            
            //place the object in request attribute
            request.setAttribute("LOGIN_RESULT", result);
            
            //set the day in the header of the table with day's hours
            Day d = new Day (result[0].getDayName(), result[0].getDayInMonth(), result[0].getCurrentMonth(), result[0].getCurrentYear());
        
            //place the object in request attribute
            request.setAttribute("SINGLE_DAY", d);  
            
                    
        //sets whch which (how many ahead) should be shown
        int howManyWeeksAhead = 0;
        request.setAttribute("DAYS_AHEAD", howManyWeeksAhead);
            
            //clearing failure inforamtion after successful login
            failResult = "";
        }
        //comes back to login page if the credential don'texist in db
        else{
            failResult = "INVALID USER OR PASSWORD";
            target_page = "/mechanic.jsp"; 
                   
            //place the object in request attribute
            request.setAttribute("LOGIN_FAIL", failResult);
        }
        
        //sends to jsp page: target_page
        RequestDispatcher dispatcher = request.getRequestDispatcher(target_page);
        dispatcher.forward(request, response);
    }
    
    
    private void displaySingleDay(HttpServletRequest request, HttpServletResponse response) throws Exception{
        
        String dayName = request.getParameter("day_name");
        String dayOfMonth = request.getParameter("day_of_month");
        String currentMonth = request.getParameter("current_month");
        String currentYear = request.getParameter("current_year");
        
        Day d = new Day (dayName, dayOfMonth, currentMonth, currentYear);
        

        
        //place the object in request attribute
        request.setAttribute("SINGLE_DAY", d);

        
            WeekCreation weekDays = new WeekCreation();
            Day [] result = weekDays.getDays(0);
            
            request.setAttribute("LOGIN_RESULT", result);
        
        //send to jsp page: update-student-form.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("/employee_dashboard.jsp");
        dispatcher.forward(request, response);
    }
    
    public void progressWeek(HttpServletRequest request, HttpServletResponse response) throws Exception{
            
        int weekProgression = Integer.parseInt(request.getParameter("how_many_weeks_ahead"));
        
            int howManyWeeksAhead = weekProgression + 1;
            
            //limits progression to 6 weeks ahead
            if(howManyWeeksAhead > 6){
                howManyWeeksAhead = 6;
            }
            request.setAttribute("DAYS_AHEAD", howManyWeeksAhead);

            WeekCreation weekDays = new WeekCreation();
            Day [] result = weekDays.getDays(howManyWeeksAhead);

            request.setAttribute("LOGIN_RESULT", result);

            //send to jsp page: update-student-form.jsp
            RequestDispatcher dispatcher = request.getRequestDispatcher("/employee_dashboard.jsp");
            dispatcher.forward(request, response);
    }
    
    public void reverseWeek(HttpServletRequest request, HttpServletResponse response) throws Exception{
            
        int weekReversion = Integer.parseInt(request.getParameter("how_many_weeks_back"));
        
        int howManyWeeksBack = weekReversion - 1;
            
        //limits reversion to current week
        if(howManyWeeksBack < 1){
            howManyWeeksBack = 0;
        }
        request.setAttribute("DAYS_AHEAD", howManyWeeksBack);

        WeekCreation weekDays = new WeekCreation();
        Day [] result = weekDays.getDays(howManyWeeksBack);

        request.setAttribute("LOGIN_RESULT", result);

        //send to jsp page: update-student-form.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("/employee_dashboard.jsp");
        dispatcher.forward(request, response);
    }    
    
}
