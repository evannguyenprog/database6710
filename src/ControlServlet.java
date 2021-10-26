

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.LinkedHashSet;
import java.util.Date;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;



public class ControlServlet extends HttpServlet
{
    // Declaring all private variables
    private static final long serialVersionUID = 1L;
    private AddressDao addressDao;
    private BalanceOfMoneyDao balanceOfMoneyDao;
    private BuyPPSDao buyPPSDao;
    private DepositDao depositDao;
    private SellPPSDao sellPPSDao;
    private TransferPPSDao transferPPSDao;
    private UsersDao usersDao;
    private WithdrawDao withdrawDao;
    private HttpSession session = null;
    
    public void init() {
        System.out.println("Servlet Connected.");
        
        addressDao = new AddressDao();
        balanceOfMoneyDao = new BalanceOfMoneyDao();
        buyPPSDao = new BuyPPSDao();
        depositDao = new DepositDao();
        sellPPSDao = new SellPPSDao();
        transferPPSDao = new TransferPPSDao();
        usersDao = new UsersDao();
        withdrawDao = new WithdrawDao();
        
    }
    
    
 // doPost declaration
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost started: 000000000000000000000000000");
    	doGet(request, response);
        System.out.println("doPost finished: 11111111111111111111111111");

    }
    
    
 // doGet declaration, switch statement to handle each request
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet started: 000000000000000000000000000"); 
    	String action = request.getServletPath();
        System.out.println(action);

        try
        {
            RequestDispatcher dispatcher;
            switch (action)
            {
            
            	//login user case
            case "/login":
                System.out.println("Logging in...");
                login(request, response);
                break;
            
                //register new user case
            case "/register":
                System.out.println("Registering...");
                register(request, response);
                break;
            
                //init DB case
            case "/initialize":
                initializeDatabase(request, response);
                break;
            
                	//logout case for later = WIP =
            case "/logout":
            	logout(request, response);
            	break;
            }
        } catch (SQLException ex) { throw new ServletException(ex); }

        System.out.println("doGet finished: 111111111111111111111111111111111111");

    }
   
 // Function to initialize the database for the root user
    private void initializeDatabase(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {       
        addressDao.dropTable();
        balanceOfMoneyDao.dropTable();
        buyPPSDao.dropTable();
        depositDao.dropTable();
        sellPPSDao.dropTable();
        transferPPSDao.dropTable();
        usersDao.dropTable();
        withdrawDao.dropTable();

        System.out.println("====== All Tables Dropped. ======");
       
        addressDao.createTable();
        balanceOfMoneyDao.createTable();
        buyPPSDao.createTable();
        depositDao.createTable();
        sellPPSDao.createTable();
        transferPPSDao.createTable();
        usersDao.createTable();
        withdrawDao.createTable();
        
        System.out.println("====== Database Initalized Successfully. ====== ");
       
        RequestDispatcher dispatcher = request.getRequestDispatcher("root_successpage.jsp");
        dispatcher.forward(request, response);
    }
    
    
 // log in user functionality
    private void login(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Login login = new Login(email, password);
       
        RequestDispatcher dispatcher;
        if(usersDao.validityCheck(email, password) && !email.isEmpty()) {
        	session = request.getSession();
        	session.setAttribute("currentEmail", login.getEmail());
        	session.setAttribute("currentPassword", login.getPassword());
        	
            if(email.contentEquals("root")) {
                dispatcher = request.getRequestDispatcher("initializepage.jsp");
                dispatcher.forward(request, response);
                System.out.println("Root User Authenticated.");
            } else {
            	dispatcher = request.getRequestDispatcher("user_successpage.jsp");
                dispatcher.forward(request, response);
                System.out.println("User Authenticated.");
            }
        } else {
            dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
            System.out.println("The entered credentials are not correct.");
        }
    }
    
    private void logout(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
    	RequestDispatcher dispatcher;
    	session = request.getSession();
        session.invalidate();
        dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);
   }
   
    // Function to register a new user
    private void register(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        int age = Integer.parseInt(request.getParameter("age"));
       
        RequestDispatcher dispatcher;
        if(password.contentEquals(password2)) {
            if(!usersDao.duplicateEmailCheck(email)) {
                Users newUser = new Users(email, password, firstname, lastname, age);
                usersDao.insert(newUser);
                dispatcher = request.getRequestDispatcher("loginpage.jsp");
                dispatcher.forward(request, response);
                System.out.println("Registration complete");
            } else {
                request.setAttribute("registerError", "This email is already taken");
                dispatcher = request.getRequestDispatcher("registerpage.jsp");
                dispatcher.forward(request, response);
                System.out.println("Registration failed, please enter a unique email.");
            }
        } else {
            request.setAttribute("registerError", "Passwords do not match");
            dispatcher = request.getRequestDispatcher("registerpage.jsp");
            dispatcher.forward(request, response);
            System.out.println("Registration failed, please make sure your passwords match.");
        }
    }
    
    
    
}