/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barpiotr.driver;

import barpiotr.Days.WeeklyCalendar;
import barpiotr.data.Customer;
import barpiotr.data.CustomerOfIdDAO;
import barpiotr.data.ElementFromDBRetrievable;
import barpiotr.data.EngineTypeExe;
import barpiotr.data.ServiceTypeExe;
import barpiotr.data.Vehicle;
import barpiotr.data.VehicleMakeExe;
import barpiotr.data.VehicleModelExe;
import barpiotr.data.VehicleOfIdDAO;
import barpiotr.data.VehicleTypeExe;
import barpiotr.insertingData.BookingDetails;
import barpiotr.insertingData.BookingDetailsConfirmingExe;
import barpiotr.insertingData.ChosenTimeSlot;
import barpiotr.insertingData.InsertNewCustomer;
import barpiotr.util.CheckedSingleDay;
import barpiotr.util.GetValuesOfBookingFields;
import barpiotr.util.GetValuesOfUserFields;
import barpiotr.util.GetValuesThroughClassProps;
import barpiotr.util.IfFieldsFilled;
import barpiotr.util.InputFieldsDataUser;
import barpiotr.util.CheckIfUserExistsInDBaseExe;
import barpiotr.util.CheckedServiceTime;
import barpiotr.util.FinishTimeCalculation;
import barpiotr.util.GetFreeTimeSlotsExe;
import barpiotr.util.GetUserServicesToDisplayExe;
import barpiotr.util.GetUserVehiclesToDisplayExe;
import java.io.IOException;
import java.io.PrintWriter;
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

    @Resource(name = "jdbc/gerbox")
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
            throws ServletException, IOException, ServletException, ServletException {
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
        super.init();

        //To change body of generated methods, choose Tools | Templates.
        //create our student db util... and pass in the conn pool / datasource
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
                theCommand = "AVAILABILITY_CHECK";
            }
            //route to the appropriate method
            switch (theCommand) {
                case "LOGOUT":
                    String target_page = "index.jsp";
                    dispatchingResult(request, response, target_page);
                    break;
                case "START_BOOKING":
                    target_page = "/driver-dashboard.jsp";
                    request = customerId(request, response);
                    request = customerName(request, response);
                    request = showServiceTypes(request, response);
                    dispatchingResult(request, response, target_page);
                    break;
                case "AVAILABILITY_CHECK":
                    target_page = "/driver-dashboard.jsp";
                    request = showServiceTypes(request, response);
                    request = customerId(request, response);
                    request = customerName(request, response);
                    request = serviceTypeChosen(request, response);
                    //to check if a user has chosen the service option
                    if (!request.getAttribute("CHOSEN_SERVICE_TYPE").equals("0")) {
                        //to show hidden parts of dashboard
                        request = showSubpage(request, response);
                        request = displaySingleDay(request, response);
                        request = displayWeek(request, response);
                        request = displayServiceHours(request, response);
                        request = getServiceTime(request, response);
                        //check if there are any vehicles of the user not being in service
                        request = displayTheUsersVehiclesData(request, response);
                        List<Vehicle> list = (List<Vehicle>) request.getAttribute("CUSTOMER_VEHICLES");
                        if (list.size() < 1) {
                            request.setAttribute("LIST_OR_FORM", "form");
                            //request.getAttribute("CUSTOMER_VEHICLES").equals("empty") || request.getAttribute("CUSTOMER_VEHICLES").equals("not_clicked")) {
                            request = showVehicleModels(request, response);
                            request = showVehicleMakes(request, response);
                            request = showVehicleTypes(request, response);
                            request = showEngineTypes(request, response);
                            request = vehicleModelChosen(request, response);
                            request = vehicleMakeChosen(request, response);
                        }
                        else{
                            request.setAttribute("LIST_OR_FORM", "list");
                            request = addNewVehicle(request, response);
                        }
                    }
                    dispatchingResult(request, response, target_page);
                    break;
                case "BOOK_A_SLOT":
                    target_page = "user-choice/booking-confirmation.jsp";
                    request = serviceTypeChosen(request, response);
                    request = customerId(request, response);
                    request = customerName(request, response);
                    request = freeTimeSlotChosen(request, response);
                    request = displayFinishHour(request, response);
                    request = displaySingleDay(request, response);
                    request = displayServiceHours(request, response);
                    request = sourceOfCarData(request, response);
                    if (request.getAttribute("SOURCE_INFO").equals("fromForm")) {
                        request = vehicleModelChosen(request, response);
                        request = vehicleMakeChosen(request, response);
                        request = vehicleTypeChosen(request, response);
                        request = engineTypeChosen(request, response);
                        request = vehicleRegistrationChosen(request, response);
                        request = vehicleColorChosen(request, response);
                    } else {
                        request = vehicleExistingUser(request, response);
                    }
                    dispatchingResult(request, response, target_page);
                    break;
                case "CONFIRM_BOOKING":
                    insertBooking(request, response);
                    target_page = "./user-account.jsp";
                    request = showServiceTypes(request, response);
                    request = customerId(request, response);
                    request = customerName(request, response);
                    // request = displayTheCustomerData(request, response);
                    request = displayTheUsersServicesData(request, response);
                    dispatchingResult(request, response, target_page);
                    break;
                default:
                    displayWeek(request, response);
            }
        } catch (Exception exc) {
            throw new ServletException(exc);
//            try {
//                String target_page = "index.jsp";
//                request.setAttribute("REDIRECTED_FROM_SERVLET", "from_servlet");
//                dispatchingResult(request, response, target_page);
//            } catch (Exception ex) {
//                Logger.getLogger(DriverControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
//            }
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
            if (theCommand == null) {
                theCommand = "LOGIN";
            }

            //route to the appropriate method
            switch (theCommand) {
                case "LOGIN":
                    String target_page = "/driver.jsp";
                    InputFieldsDataUser tempInput = getUserInput(request, response);
                    if (!(checkIfFieldsFilled(tempInput).ifUserFieldsFilled())) {
                        request = getFieldsComments(tempInput, request, response);
                    } else {
                        if (!ifCredentialsExist(request, response)) {
                            request = setLoginFailure(request, response);
                        } else {
                            target_page = "/user-account.jsp";
                            request = showServiceTypes(request, response);
                            request = displayTheCustomerData(request, response);
                            request = displayTheUsersServicesData(request, response);
                        }
                    }
                    dispatchingResult(request, response, target_page);
                    break;
                case "SETTING_ACCOUNT":
                    target_page = "/new-driver.jsp";
                    InputFieldsDataUser userInput = getUserInput(request, response);
                    if (checkIfFieldsFilled(userInput).ifUserFieldsFilled()) {
                        if (!checkIfNewUser(request, response)) {
                            target_page = "/signin-login.jsp";
                            request = getUserAlreadyExistsInfo(request, response);
                        } else {
                            target_page = "/driver.jsp";
                            insertNewUser(request, response);
                        }
                    } else {
                        request = getFieldsComments(userInput, request, response);
                    }
                    dispatchingResult(request, response, target_page);
                    break;
                default:
                    ifCredentialsExist(request, response);
            }
        } catch (Exception exc) {
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

    //XXXXXXXXXXXXXXXXX LOGIN XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
    private InputFieldsDataUser getUserInput(HttpServletRequest request, HttpServletResponse response) {

        String theFirstName = request.getParameter("first-name");
        String theLastName = request.getParameter("last-name");
        String theLogin = request.getParameter("login");
        String thePhone = request.getParameter("phone");
        String thePassword = request.getParameter("pass");

        InputFieldsDataUser tempInput = new InputFieldsDataUser(theFirstName, theLastName, theLogin, thePhone, thePassword);
        return tempInput;
    }

    private IfFieldsFilled checkIfFieldsFilled(Object userInput) throws Exception {
        IfFieldsFilled checkIfNotEmpty = new IfFieldsFilled(userInput);
        return checkIfNotEmpty;
    }

    private HttpServletRequest getFieldsComments(Object inputData, HttpServletRequest request, HttpServletResponse response) throws Exception {

        GetValuesThroughClassProps allValues = null;

        String className = inputData.getClass().getSimpleName();

        switch (className) {
            case "InputFieldsDataUser":
                GetValuesOfUserFields fieldsOfUserInput = new GetValuesOfUserFields((InputFieldsDataUser) inputData);
                allValues = fieldsOfUserInput;
                break;
            case "BookingDetails":
                GetValuesOfBookingFields fieldsOfBookingInput = new GetValuesOfBookingFields((BookingDetails) inputData);
                allValues = fieldsOfBookingInput;
                break;
        }

        List<String> listA = new ArrayList<>();
        List<String> listB = new ArrayList<>();
        List<String> listC = new ArrayList<>();
        List<String> listD = new ArrayList<>();

        listA = allValues.getEmptyAttList();
        listB = allValues.getWarningsList();
        listC = allValues.getReturnedAttList();
        listD = allValues.getPropsValuesList();

        for (int i = 0; i < listA.size(); i++) {
            request.setAttribute(listA.get(i), listB.get(i));
        }

        for (int i = 0; i < listA.size(); i++) {
            request.setAttribute(listC.get(i), listD.get(i));
        }

        return request;
    }

    private Boolean ifCredentialsExist(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //catches all parameters of url from the jsp
        Map<String, String[]> userParam = request.getParameterMap();
        //to check and ruturn if the credentials exist in the db
        CheckIfUserExistsInDBaseExe ifCredentialsExist = new CheckIfUserExistsInDBaseExe(userParam);
        Boolean result = ifCredentialsExist.ifCredentialsExist(dataSource);
        return result;
    }

    private HttpServletRequest setLoginFailure(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String loginFailure = "INVALID USER OR PASSWORD";
        request.setAttribute("LOGIN_FAILURE", loginFailure);
        return request;
    }

    private HttpServletRequest showServiceTypes(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //to generate a list of objects
        ServiceTypeExe serviceTypeList = new ServiceTypeExe(dataSource);
        request.setAttribute("LIST_OF_SERVICE_TYPES", serviceTypeList.getResult());
        return request;
    }

    private HttpServletRequest displayTheCustomerData(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //catches all parameters of url from the jsp
        Map<String, String[]> userParam = request.getParameterMap();
        //to check and ruturn if the credentials exist in the db
        CheckIfUserExistsInDBaseExe ifCredentialsExist = new CheckIfUserExistsInDBaseExe(userParam);

        String customerName = ifCredentialsExist.getCustomer(dataSource).getFirstName();
        int customerId = ifCredentialsExist.getCustomer(dataSource).getId();

        //place the object in request attribute
        request.setAttribute("CUSTOMER_NAME", customerName);
        request.setAttribute("CUSTOMER_ID", customerId);
        return request;
    }

    private HttpServletRequest displayTheUsersServicesData(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //catches all parameters of url from the jsp
        Map<String, String[]> userParam = request.getParameterMap();

        GetUserServicesToDisplayExe servicesDataToDisplay = new GetUserServicesToDisplayExe(userParam);

        List<ElementFromDBRetrievable> usersServiceListToDisplay = servicesDataToDisplay.getUserServicesData(dataSource).getUsersServiceListToDisplay();
        String userServiceTableLabel = servicesDataToDisplay.getUserServicesData(dataSource).getUserServiceTableLabel();

        //place the object in request attribute
        request.setAttribute("CUSTOMER_SERVICES", usersServiceListToDisplay);
        request.setAttribute("CUSTOMER_SERVICE_TABLE_LABEL", userServiceTableLabel);

        return request;
    }

    //XXXXXXXXXXXXXXXXXXXX FOR SETTING NEW XXXXXXXXXXXXXXXXXXXXXXXXX
    private Boolean checkIfNewUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //catches all parameters of url from the jsp
        Map<String, String[]> userParam = request.getParameterMap();
        //to check and ruturn if the login exist in the db
        CheckIfUserExistsInDBaseExe ifCredentialsExist = new CheckIfUserExistsInDBaseExe(userParam);
        Boolean result = ifCredentialsExist.ifLoginExists(dataSource);
        return result;
    }

    private HttpServletRequest getUserAlreadyExistsInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String notNewUser = "USER WITH THAT EMAIL ALREADY EXISTS";
        request.setAttribute("NOT_NEW_USER_INFO", notNewUser);
        return request;
    }

    private void insertNewUser(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String theFirstName = request.getParameter("first-name");
        String theLastName = request.getParameter("last-name");
        String theLogin = request.getParameter("login");
        String thePhone = request.getParameter("phone");
        String thePass = request.getParameter("pass");
        int thePhoneNumber = 0;
        try {
            thePhoneNumber = Integer.parseInt(thePhone);
        } catch (Exception e) {
        }

        Customer newCustomer = new Customer(theFirstName, theLastName, theLogin, thePhoneNumber, thePass);
        InsertNewCustomer insertNewCustomer = new InsertNewCustomer(dataSource);

        insertNewCustomer.insertToDatabase(newCustomer);
    }

    //XXXXXXXXXXXXXXXXXXXXX  FOR CHECKING TYPE OF SERVISE AVAILABILITY XXXXXXXXXXXXXXXXXXXXXXXX//
    private HttpServletRequest customerId(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String customerId = request.getParameter("customer-id");
        request.setAttribute("CUSTOMER_ID", customerId);
        return request;
    }

    private HttpServletRequest customerName(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String customerName = request.getParameter("customer-name");
        request.setAttribute("CUSTOMER_NAME", customerName);
        return request;
    }

    private HttpServletRequest serviceTypeChosen(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String serviceTypeChosen = request.getParameter("service-type");
        request.setAttribute("CHOSEN_SERVICE_TYPE", serviceTypeChosen);
        return request;
    }

    // ======================= TO SHOW HIDDEN OF DRIVER'S DASHBOARD =========================
    private HttpServletRequest showSubpage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //include page in page
        request.setAttribute("PAGE_INCLUSION", "true");
        return request;
    }
    // ======================= TO SHOW WEEK CALENDAR =========================

    private HttpServletRequest displayWeek(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Map<String, String[]> calendarParam = request.getParameterMap();
        WeeklyCalendar theWeekShown = new WeeklyCalendar(calendarParam);
        theWeekShown.displayWeek();

        //place the object in request attribute
        request.setAttribute("WEEK_DAYS_TO_CHOOSE", theWeekShown.getWeekToDisplay());

        //sets whch which week(how many ahead) should be shown
        //int howManyWeeksAhead = 0;
        request.setAttribute("DAYS_AHEAD", theWeekShown.getHowManyWeeksAhead());

        return request;
    }

// ======================= TO SHOW DAILY ROSTER - DAY IN HEADER =========================
    private HttpServletRequest displaySingleDay(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //set the day in the header of the table with day's hours

        //catches all parameters of url from the jsp
        Map<String, String[]> dayParam = request.getParameterMap();
        //passes them to the class
        CheckedSingleDay dSD = new CheckedSingleDay(dayParam);
        //place the return object in request attribute
        request.setAttribute("SINGLE_DAY", dSD.getDay());
        return request;
    }

// ======================= TO SHOW DAILY ROSTER - TIME SLOTS =========================
    private HttpServletRequest displayServiceHours(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //set the table with day's hours

        //catches all parameters of url from the jsp
        Map<String, String[]> dayParam = request.getParameterMap();
        //passes them to the class
        GetFreeTimeSlotsExe fTS = new GetFreeTimeSlotsExe(dayParam);
        //place the return object in request attribute
        request.setAttribute("FREE_HOURS", fTS.getServiceTimeSlots(dataSource));
        return request;
    }

    private HttpServletRequest getServiceTime(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //set the time of service

        //catches all parameters of url from the jsp
        Map<String, String[]> dayParam = request.getParameterMap();
        //passes them to the class
        CheckedServiceTime sTT = new CheckedServiceTime(dayParam);
        //place the return object in request attribute
        request.setAttribute("SERVICE_TIME", sTT.getServiceTime(dataSource));
        return request;
    }

    private HttpServletRequest displayFinishHour(HttpServletRequest request, HttpServletResponse response) {
        //set the finish time to pass to booking confirmation page

        //catches all parameters of url from the jsp
        Map<String, String[]> dayParam = request.getParameterMap();
        //passes them to the class
        FinishTimeCalculation finishServiceHour = new FinishTimeCalculation(dayParam);
        //place the return object in request attribute
        request.setAttribute("FINISH_HOUR", finishServiceHour.getFinishTime());
        return request;
    }

    //XXXXXXXXXXXXXXXXXXXXX  FOR PASSING CHOSEN VALUES  XXXXXXXXXXXXXXXXXXXXXXXX//
    private HttpServletRequest freeTimeSlotChosen(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String freeDateChosen = request.getParameter("free-slot-date");
        String freeYearChosen = request.getParameter("free-slot-year");
        String freeMonthChosenInNumber = request.getParameter("free-slot-month");
        String freeDayChosen = request.getParameter("free-slot-day");
        String freeTimeStartChosen = request.getParameter("free-slot-time-start");
        String freeTimeFinishChosen = request.getParameter("free-slot-time-finish");

        ChosenTimeSlot chosenTimeSlot = new ChosenTimeSlot(freeDateChosen, freeYearChosen, freeMonthChosenInNumber,
                freeDayChosen, freeTimeStartChosen, freeTimeFinishChosen);

        request.setAttribute("CHOSEN_TIME_SLOT", chosenTimeSlot);
        return request;
    }

    private HttpServletRequest vehicleModelChosen(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String modelChosen = request.getParameter("vehicle-model");
        request.setAttribute("CHOSEN_VEHICLE_MODEL", modelChosen);
        return request;
    }

    private HttpServletRequest vehicleMakeChosen(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String makeChosen = request.getParameter("vehicle-make");
        request.setAttribute("CHOSEN_VEHICLE_MAKE", makeChosen);
        return request;
    }

    private HttpServletRequest vehicleTypeChosen(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String vehicleTypeChosen = request.getParameter("vehicle-type");
        request.setAttribute("CHOSEN_VEHICLE_TYPE", vehicleTypeChosen);
        return request;
    }

    private HttpServletRequest engineTypeChosen(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String engineTypeChosen = request.getParameter("engine-type");
        request.setAttribute("CHOSEN_ENGINE_TYPE", engineTypeChosen);
        return request;
    }

    private HttpServletRequest vehicleRegistrationChosen(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String vehicleRegistration = request.getParameter("vehicle-registration");
        request.setAttribute("CHOSEN_VEHICLE_REGISTRATION", vehicleRegistration);
        return request;
    }

    private HttpServletRequest vehicleColorChosen(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String vehicleColor = request.getParameter("vehicle-color");
        request.setAttribute("CHOSEN_VEHICLE_COLOR", vehicleColor);
        return request;
    }

    //XXXXXXXXXXXXXXXXXXXXX  FOR CHECKING TYPE OF SERVISE AVAILABILITY XXXXXXXXXXXXXXXXXXXXXXXX//
    private HttpServletRequest sourceOfCarData(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String sourceCarInfo = request.getParameter("entered-car");
        request.setAttribute("SOURCE_INFO", sourceCarInfo);
        return request;
    }

    private HttpServletRequest addNewVehicle(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            String addingOtherVeh = request.getParameter("adding-vehicles");
            if (addingOtherVeh.equals("addOther")) {
                request.setAttribute("LIST_OR_FORM", "form");
            }
        } catch (Exception e) {
        }
        return request;
    }

    private HttpServletRequest displayTheUsersVehiclesData(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //catches all parameters of url from the jsp
        String userId = request.getParameter("customer-id");
        GetUserVehiclesToDisplayExe userVehiclesToDisplay = new GetUserVehiclesToDisplayExe(userId);
        request.setAttribute("CUSTOMER_VEHICLES", userVehiclesToDisplay.getUsersVehiclesData(dataSource));
        return request;
    }

    private HttpServletRequest showVehicleModels(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //to generate a list of objects
        VehicleModelExe vehModels = new VehicleModelExe(dataSource);
        request.setAttribute("LIST_OF_VEHICLE_MODELS", vehModels.getResult());
        return request;
    }

    private HttpServletRequest showVehicleMakes(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //to generate a list of objects
        VehicleMakeExe vehicleMakeList = new VehicleMakeExe(dataSource);
        request.setAttribute("LIST_OF_VEHICLE_MAKES", vehicleMakeList.getResult());
        return request;
    }

    private HttpServletRequest showVehicleTypes(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //to generate a list of objects
        VehicleTypeExe vehicleTypeList = new VehicleTypeExe(dataSource);
        request.setAttribute("LIST_OF_VEHICLE_TYPES", vehicleTypeList.getResult());
        return request;
    }

    private HttpServletRequest showEngineTypes(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //to generate a list of objects
        EngineTypeExe engineTypeList = new EngineTypeExe(dataSource);
        request.setAttribute("LIST_OF_ENGINE_TYPES", engineTypeList.getResult());
        return request;
    }

    private HttpServletRequest vehicleExistingUser(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String vehicleId = request.getParameter("vehicle-id");

        VehicleOfIdDAO theVehicle = new VehicleOfIdDAO(vehicleId);
        List<ElementFromDBRetrievable> result = theVehicle.getElementFromDBList(dataSource, theVehicle.sql);
        Vehicle theVeh = (Vehicle) result.get(0);
        request.setAttribute("CHOSEN_VEHICLE_ID", theVeh.getId());
        request.setAttribute("CHOSEN_VEHICLE_MAKE", theVeh.getVehicleMakeName());
        request.setAttribute("CHOSEN_VEHICLE_MODEL", theVeh.getVehicleModelName());
        request.setAttribute("CHOSEN_VEHICLE_TYPE", theVeh.getVehicleTypeName());
        request.setAttribute("CHOSEN_ENGINE_TYPE", theVeh.getEngineTypeName());
        request.setAttribute("CHOSEN_VEHICLE_REGISTRATION", theVeh.getRegistration());
        request.setAttribute("CHOSEN_VEHICLE_COLOR", theVeh.getColour());
        return request;
    }

    private void insertBooking(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //catches all parameters of url from the jsp
        Map<String, String[]> bookingParam = request.getParameterMap();
        BookingDetailsConfirmingExe bookingConfirmExe = new BookingDetailsConfirmingExe(bookingParam);
        bookingConfirmExe.insertToDataBase(dataSource, bookingConfirmExe.getBookingDetails());
    }

    private void dispatchingResult(HttpServletRequest request, HttpServletResponse response, String target_page) throws Exception {
        //sends to jsp page
        RequestDispatcher dispatcher = request.getRequestDispatcher(target_page);
        dispatcher.forward(request, response);
    }
}
