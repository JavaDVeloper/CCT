/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barpiotr.mechanic;


import barpiotr.Days.Day;
import barpiotr.Days.WeekCreation;
import barpiotr.data.ElementFromDBRetrievable;
import barpiotr.data.ServiceStatus;
import barpiotr.data.ServiceStatusDAO;
import barpiotr.data.mechanic.ServiceOnRosterDAO;
import barpiotr.insertingData.UpdatingPendingService;
import barpiotr.insertingData.UpdatingPendingServiceExe;
import barpiotr.printing.DailyRoster.DayRoster;
import barpiotr.printing.DailyRoster.Printer;
import com.itextpdf.text.DocumentException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
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
public class MechanicControllerServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Resource(name = "jdbc/gerbox")
    private DataSource dataSource;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MechanicControllerServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MechanicControllerServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
            if (theCommand == null) {
                theCommand = "DISPLAY_SERVICES";
            }

            //route to the appropriate method
            switch (theCommand) {
                case "DISPLAY_SERVICES":
                    String target_page = "/mechanic-dashboard.jsp";
                    request = displayWeek(request, response);
                    request = displaySingleDay(request, response);
                    request = displayStatuses(request, response);
                    dispatchingResult(request, response, target_page);
                    break;
                case "DISPLAY_SERVICES_ON_DAY":
                    target_page = "/mechanic-dashboard.jsp";
                    request = displayWeek(request, response);
                    request = displaySingleDay(request, response);
                    request = displayStatuses(request, response);
                    dispatchingResult(request, response, target_page);
                    break;
                case "PRINT_DAILY_ROSTER":
                    target_page = "/mechanic-dashboard.jsp";
                    request = printDayRoster(request, response);

                    request = displayWeek(request, response);
                    request = displaySingleDay(request, response);
                    request = displayStatuses(request, response);
                    dispatchingResult(request, response, target_page);
                    break;
                case "PENDING_STATUS_CHANGE":
                    target_page = "/mechanic-dashboard.jsp";
                    updatePendingStatus(request, response);
                    request = displayWeek(request, response);
                    request = displaySingleDay(request, response);
                    request = displayStatuses(request, response);
                    dispatchingResult(request, response, target_page);
                    break;
                default:
                    displayWeek(request, response);
            }
        } catch (Exception exc) {
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    private void dispatchingResult(HttpServletRequest request, HttpServletResponse response, String target_page) throws Exception {
        //sends to jsp page
        RequestDispatcher dispatcher = request.getRequestDispatcher(target_page);
        dispatcher.forward(request, response);
    }

    private HttpServletRequest displayWeek(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int weekProgression;
        int howManyWeeksAhead;

        String ifReversingWeek = null;
        ifReversingWeek = request.getParameter("clicked-reverse");

        //to get clicked day as for it's of next week 
        int clickedDay = 0;
        try {
            clickedDay = Integer.parseInt(request.getParameter("day_of_month"));
        } catch (Exception e) {
        }

        //if reverseWeek button wasn't clicked
        if (ifReversingWeek == null) {

            try {
                weekProgression = Integer.parseInt(request.getParameter("how-many-weeks-ahead"));
                howManyWeeksAhead = weekProgression + 1;
            } catch (Exception e) {
                weekProgression = 0;
                howManyWeeksAhead = 0;
            }
        } //if reverseWeek button was clicked         
        else {

            try {
                weekProgression = Integer.parseInt(request.getParameter("how-many-weeks-ahead"));
                if (weekProgression == 0) {
                    howManyWeeksAhead = 0;
                } else {
                    howManyWeeksAhead = weekProgression - 1;
                }
            } catch (Exception e) {
                weekProgression = 0;
                howManyWeeksAhead = 0;
            }
        }

        //limits progression to 2 weeks ahead
        if (howManyWeeksAhead > 2) {
            howManyWeeksAhead = 2;
        }

        //returns 7 days starting from today
        WeekCreation weekDays = new WeekCreation();
        Day[] result = weekDays.getDays(howManyWeeksAhead);
        int dayAtCalendarBeg = Integer.parseInt(result[0].getDayInMonth());
        int diffInDays = clickedDay - dayAtCalendarBeg;
        if (diffInDays > 6) {
            int weekAhead = diffInDays / 7;
            result = weekDays.getDays(howManyWeeksAhead + weekAhead);
            howManyWeeksAhead = howManyWeeksAhead + weekAhead;
        }

        //limits progression to 2 weeks ahead
        if (howManyWeeksAhead > 2) {
            howManyWeeksAhead = 2;
        }

        //place the object in request attribute
        request.setAttribute("WEEK_DAYS_TO_CHOOSE", result);

        //sets whch which (how many ahead) should be shown
        //int howManyWeeksAhead = 0;
        request.setAttribute("DAYS_AHEAD", howManyWeeksAhead);

        return request;
    }

    public void progressWeek(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int weekProgression;

        try {
            weekProgression = Integer.parseInt(request.getParameter("how-many-weeks-ahead"));
        } catch (Exception e) {
            weekProgression = 0;
        }
        int howManyWeeksAhead = weekProgression + 1;

        //limits progression to 2 weeks ahead
        if (howManyWeeksAhead > 2) {
            howManyWeeksAhead = 2;
        }
        request.setAttribute("DAYS_AHEAD", howManyWeeksAhead);

        WeekCreation weekDays = new WeekCreation();
        Day[] result = weekDays.getDays(howManyWeeksAhead);

        request.setAttribute("LOGIN_RESULT", result);
    }

    private HttpServletRequest displaySingleDay(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Day d;
        ServiceOnRosterDAO servicesOnDay;

        //set the day in the header of the table with day's hours
        String dayName = request.getParameter("day_name");
        String dayOfMonth = request.getParameter("day_of_month");
        String currentMonth = request.getParameter("current_month");
        String currentMonthNumber = request.getParameter("current_month_number");
        String currentYear = request.getParameter("current_year");

        //when parameters are not set yet / the day square hasn't been clicked yet
        if (dayName == null) {
            WeekCreation weekDays = new WeekCreation();
            Day[] result = weekDays.getDays(0);
            //set the day in the header of the table with day's hours
            d = new Day(result[0].getDayName(), result[0].getDayInMonth(), result[0].getCurrentMonth(), result[0].getCurrentMonthInNumber(), result[0].getCurrentYear());
        } else {
            d = new Day(dayName, dayOfMonth, currentMonth, currentMonthNumber, currentYear);
        }

        //to pass a date to check which time slots are free
        LocalDate checkedDate = LocalDate.parse(d.getCurrentYear() + "-" + d.getCurrentMonthInNumber() + "-" + d.getDayInMonth());

        servicesOnDay = new ServiceOnRosterDAO(checkedDate);
        List<ElementFromDBRetrievable> servicesOnDayList = new ArrayList<>();
        servicesOnDayList = servicesOnDay.getElementFromDBList(dataSource, servicesOnDay.sql);

        //place the object in request attribute
        request.setAttribute("SINGLE_DAY", d);
        request.setAttribute("SERVICES_ON_DAY", servicesOnDayList);

        return request;
    }

    private HttpServletRequest displayStatuses(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ServiceStatusDAO statuses = new ServiceStatusDAO();

        //information on result
        List<ElementFromDBRetrievable> result = statuses.getElementFromDBList(dataSource, statuses.sql);
        
       
        
        List<String> result2 = new ArrayList<>();
        ServiceStatus ss;
        
        for(ElementFromDBRetrievable s : result){
            
            ss = new ServiceStatus();
            ss = (ServiceStatus) s;
            result2.add(ss.getName());
        }
                
        request.setAttribute("LIST_OF_STATUS_NAMES", result2);

        request.setAttribute("LIST_OF_SERVICE_STATUSES", result);

        return request;
    }

    private void updatePendingStatus(HttpServletRequest request, HttpServletResponse response) throws Exception {

    String[] dayRosterValue = request.getParameterValues("service-on-day-value");
        
    UpdatingPendingServiceExe upd = new UpdatingPendingServiceExe(dayRosterValue, dataSource);  

    }

    public HttpServletRequest printDayRoster(HttpServletRequest request, HttpServletResponse response) throws DocumentException {

        
        DayRoster dayRoster;
        String [] dayRosterValue;
        String iString;

        int numberOfServices = Integer.parseInt(request.getParameter("number-services"));
        String dayWithRoster = request.getParameter("free-slot-date");

        Map<String, String[]> theMap = new HashMap<>();
//        
        theMap = request.getParameterMap();
        
        List<DayRoster> list = new ArrayList<>();
        
        for (int i = 1; i <= numberOfServices; i++){
            iString = String.valueOf(i);
            dayRosterValue = theMap.get(iString);
            dayRoster = new DayRoster(dayWithRoster, dayRosterValue[0], dayRosterValue[1], dayRosterValue[2],
                dayRosterValue[3], dayRosterValue[4], dayRosterValue[5], dayRosterValue[6],
                dayRosterValue[7], dayRosterValue[8], dayRosterValue[9], dayRosterValue[10], dayRosterValue[11],
            dayRosterValue[12]);
            list.add(dayRoster);
        }
//
        Printer printer = new Printer();
        printer.writeUsingIText(list, request, response);

        request.setAttribute("VALUE", dayWithRoster);
        request.setAttribute("VALUES", list);

        return request;

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
