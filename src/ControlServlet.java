

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
import java.sql.ResultSet;
import java.io.PrintWriter;

import java.lang.NumberFormatException;



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
    private SpecialUserRootDao specialUserRootDao;
    private FollowUserDao followUserDao;
    private HttpSession session = null;
    
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	
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
        specialUserRootDao = new SpecialUserRootDao();
        followUserDao = new FollowUserDao();
        
    }
    
	protected void connect_func() throws SQLException {
        if (connect == null || connect.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            connect = (Connection) DriverManager
            		.getConnection("jdbc:mysql://127.0.0.1:3306/testdb?"
            			    + "user=john&password=john1234");
            System.out.println(connect);
        }
    }
    
	//The below function disconnect(), is used for disconnecting with the 
	// mySQL database.
    protected void disconnect() throws SQLException {
        if (connect != null && !connect.isClosed()) {
        	connect.close();
        }
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
            
                //logout case
            case "/logout":
            	logout(request, response);
            	break;
            
            	//deposit dollars into user account
            case "/depositDollars":
                System.out.println("Depositing...");
            	depositDollars(request, response);
            	break;
            
            case "/withdrawDollars":
                System.out.println("Withdrawing...");
            	withdrawDollars(request, response);
            	break;
            
            	case "/buyPPS":
            	buyPPS(request, response);
            	break;
            
            case "/sellPPS":
            	sellPPS(request, response);
            	break;
            	
            case "/transferPPS":
            	transferPPS(request, response);
            	break;
            	
              case "/displayDeposits":
	            System.out.println("Displaying...");
	            displayDeposits(request, response);
	            break;
              
              case "/displayWithdrawals":
                System.out.println("Displaying...");
            	displayWithdrawals(request, response);
            	break;
              
              case "/displayPPSBought":
                System.out.println("Displaying...");
            	displayBuyPPS(request, response);
            	break;
            	
              case "/displayPPSSold":
                  System.out.println("Displaying...");
                  displaySellPPS(request, response);
              	break;
              	
              case "/displayPPSTransfered":
                  System.out.println("Displaying...");
              	displayTransferPPS(request, response);
              	break;
              
//==== WIP
              	
              case "/frequentBuyers":
                  System.out.println("Displaying...");
              	displayFrequentBuyers(request, response);
              	break;
              
              case "/displayBiggestBuy":
                  System.out.println("Displaying...");
              	displayBiggestBuy(request, response);
              	break;
              	
              case "/displayBiggestBuyers":
                  System.out.println("Displaying...");
              	displayBiggestBuyers(request, response);
              	break;
              	
              case "/displayPopularUsers":
                  System.out.println("Displaying...");
              	displayPopularUsers(request, response);
              	break;
              	
              case "/displayCommonUsers":
                  System.out.println("Displaying...");
              	displayCommonUsers(request, response);
              	break;
              	
//==== WIP
              	
             case "/followAnotherUser":     
                 followAnotherUser(request, response);
                break;
                
             case "/displayNeverBuyUsers":
                 System.out.println("Displaying...");
             	displayNeverBuyUsers(request, response);
             	break;
             
             
             case "/displayNeverSellUsers":
                 System.out.println("Displaying...");
             	displayNeverSellUsers(request, response);
             	break;
             	
             case "/displayLuckyUsers":
                 System.out.println("Displaying...");
             	displayLuckyUsers(request, response);
             	break;
             	
             case "/displayInactiveUsers":
                 System.out.println("Displaying...");
             	displayInactiveUsers(request, response);
             	break;
             	
             case "/displayStatistics":
                 System.out.println("Displaying...");
             	displayStatistics(request, response);
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
        followUserDao.dropTable();
        sellPPSDao.dropTable();
        transferPPSDao.dropTable();
        withdrawDao.dropTable();
        specialUserRootDao.dropTable();
        usersDao.dropTable();
        
        

        System.out.println("====== All Tables Dropped. ======");
       
        
        usersDao.createTable(); //have to create user table first otherwise error occurs where users cannot be located
        specialUserRootDao.createTable();
        addressDao.createTable();
        balanceOfMoneyDao.createTable();
        buyPPSDao.createTable();
        depositDao.createTable();
        sellPPSDao.createTable();
        transferPPSDao.createTable();
        withdrawDao.createTable();
        followUserDao.createTable();
        
        buyPPSDao.createView();

        System.out.println("====== Database Initalized Successfully. ====== ");
       
        RequestDispatcher dispatcher = request.getRequestDispatcher("rootLoggedIn.jsp");
        dispatcher.forward(request, response);
    }
    
    //function to return the date in the correct format as it appears in the database.
    //dont use the Date datatype because project structure already uses String and it is easier here
    private String returnDate() {  
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
        Date transactionDate = new Date();
		String strTransactionDate = formatter.format(transactionDate);
        return strTransactionDate;  
    }  
  
    
 // log in user functionality
    private void login(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Login login = new Login(email, password);
       
        RequestDispatcher dispatcher;
        if( (usersDao.validityCheck(email, password) && !email.isEmpty()) || (specialUserRootDao.validityCheck(email, password) && !email.isEmpty())) {
        	session = request.getSession();
        	session.setAttribute("currentEmail", login.getEmail());
        	session.setAttribute("currentPassword", login.getPassword());
        	
            if(email.contentEquals("root")) {
                dispatcher = request.getRequestDispatcher("rootLoggedIn.jsp");
                dispatcher.forward(request, response);
                System.out.println("Root User Authenticated.");
            } else {
            	dispatcher = request.getRequestDispatcher("userLoggedIn.jsp");
                dispatcher.forward(request, response);
                System.out.println("User Authenticated.");
            }
        } else {
            dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
            System.out.println("The credentials entered are incorrect.");
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
        String birthdate= request.getParameter("birthdate");
        String street = request.getParameter("street");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        int zipcode = Integer.parseInt(request.getParameter("zipcode"));
       
        RequestDispatcher dispatcher;
        if(password.contentEquals(password2)) {
            if(!usersDao.duplicateEmailCheck(email)) {
                Users newUser = new Users(email, password, firstname, lastname, birthdate, 0.00); //default pps amount
                usersDao.insert(newUser);
                Address newAddress = new Address(email,street, city, state, zipcode);
                addressDao.insert(newAddress);
                
                dispatcher = request.getRequestDispatcher("login.jsp");
                dispatcher.forward(request, response);
                System.out.println("Registration Completed Successfully");
            } else {
                request.setAttribute("registerError", "This email is already taken");
                dispatcher = request.getRequestDispatcher("register_user.jsp");
                dispatcher.forward(request, response);
                System.out.println("Registration failed. Please enter a different email.");
            }
        } else {
            request.setAttribute("registerError", "Passwords do not match");
            dispatcher = request.getRequestDispatcher("register_user.jsp");
            dispatcher.forward(request, response);
            System.out.println("Registration failed. Verify your passwords match.");
        }
    }
    
//    private double calculatePPSValue(Double ppsAmount) throws SQLException {
//    	String sql = "SELECT ppsPrice FROM rootuser"; 
//        connect_func();      
//        statement =  (Statement) connect.createStatement();
//        ResultSet resultSet = statement.executeQuery(sql);
//    	double ppsPrice = resultSet.getDouble("ppsPrice");
//    	for(double i = 0; i <= ppsAmount; i++) {
//    		ppsPrice -= 1; 	
//        }
//    	return ppsPrice;
//    }
//    
//    private double calculatePPSBalance(Double ppsAmount) throws SQLException {
//    	String sql = "SELECT ppsBalance FROM rootuser"; 
//        connect_func();      
//        statement =  (Statement) connect.createStatement();
//        ResultSet resultSet = statement.executeQuery(sql);
//    	double ppsBalance = resultSet.getDouble("ppsPrice");
//    	for(double i = 0; i < ppsAmount; i++) {
//    		ppsBalance -= 1000000; 	
//        }
//    	return ppsBalance;
//    }
//    
    private void close() throws SQLException {
		if (resultSet != null)
			resultSet.close();
		if (statement != null)
			statement.close();
	}
    
    
    private void depositDollars(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
    	System.out.println(request.getParameter("depositDollarAmount"));
    	Double depositAmount = Double.parseDouble(request.getParameter("depositDollarAmount"));
    	RequestDispatcher dispatcher;
    	//getting current user information
        session = request.getSession();
        String currentUser = (String) session.getAttribute("currentEmail");
        System.out.println(currentUser);
        System.out.println(depositAmount);
        balanceOfMoneyDao.depositAmount(depositAmount, currentUser);
        String transactionDate = returnDate();
        Deposit newDeposit = new Deposit(currentUser, depositAmount, transactionDate);
        depositDao.insert(newDeposit);
//      response.setContentType("text/html");
//    	PrintWriter pw = response.getWriter();
//    	pw.println("<script type=\"text/javascript\">");
//    	pw.println("alert('Deposit Successful');");
//    	pw.println("</script>");   
        dispatcher = request.getRequestDispatcher("userLoggedIn.jsp");
    	dispatcher.forward(request, response);

   }
   
    private void withdrawDollars(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
    	System.out.println(request.getParameter("withdrawDollarAmount"));
    	Double withdrawAmount = Double.parseDouble(request.getParameter("withdrawDollarAmount"));
    	RequestDispatcher dispatcher;
    	
        session = request.getSession();
        
        String currentUser = (String) session.getAttribute("currentEmail");
        System.out.println(currentUser);
        System.out.println(withdrawAmount);
        balanceOfMoneyDao.withdrawAmount(withdrawAmount, currentUser);
        String transactionDate = returnDate();
        Withdraw newWithdrawl = new Withdraw(currentUser, withdrawAmount, transactionDate);
        withdrawDao.insert(newWithdrawl);
        dispatcher = request.getRequestDispatcher("userLoggedIn.jsp");
    	dispatcher.forward(request, response);
   }
    
    private void buyPPS(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
    	System.out.println(request.getParameter("buyPPSAmount"));
    	Double buyPPSAmount = Double.parseDouble(request.getParameter("buyPPSAmount"));
    	RequestDispatcher dispatcher;
    	
        session = request.getSession();
        
        //add amount purchased in pps to buypps table
        String currentUser = (String) session.getAttribute("currentEmail");
        System.out.println(currentUser);

        usersDao.buyPPSAmount(currentUser, buyPPSAmount);

        Integer buyPPSAmountInt = buyPPSAmount.intValue();
        String transactionDate = returnDate();
        BuyPPS newSale = new BuyPPS(currentUser, buyPPSAmountInt, transactionDate);
        buyPPSDao.insert(newSale);

        System.out.println("Transaction Successful!");
        dispatcher = request.getRequestDispatcher("userLoggedIn.jsp");
    	dispatcher.forward(request, response);
        
    }
    

    private void sellPPS(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
    	System.out.println(request.getParameter("sellPPSAmount"));
    	Double sellPPSAmount = Double.parseDouble(request.getParameter("sellPPSAmount"));
    	RequestDispatcher dispatcher;
    	
        session = request.getSession();
        
        String currentUser = (String) session.getAttribute("currentEmail");
        System.out.println(currentUser);
        System.out.println(sellPPSAmount);
        
        usersDao.sellPPSAmount(currentUser, sellPPSAmount);
        
        Integer sellPPSAmountInt = sellPPSAmount.intValue();
        //insert the transaction into the sellPPS table
        String transactionDate = returnDate();
    	SellPPS newSale = new SellPPS(currentUser, sellPPSAmountInt, transactionDate );
    	sellPPSDao.insert(newSale);
    
    	System.out.println("Sale Successful!");
        dispatcher = request.getRequestDispatcher("userLoggedIn.jsp");
    	dispatcher.forward(request, response);
    	
    }
    
   
    private void transferPPS(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        
    	RequestDispatcher dispatcher;
        session = request.getSession();
    	String currentUser = (String) session.getAttribute("currentEmail");
    	String transferToUser = request.getParameter("transferToUser");
    	System.out.println(transferToUser);

    	Double transferAmount = Double.parseDouble(request.getParameter("transferPPSAmount"));
    	System.out.println(transferAmount);

    	//call transfer function
    	usersDao.transferPPSAmount(currentUser, transferToUser, transferAmount);
    	//add to transfers table
    	
    	Integer transferPPSAmountInt = transferAmount.intValue();
         //insert the transaction into the sellPPS table
        String transactionDate = returnDate();
     	TransferPPS newTransfer = new TransferPPS(currentUser, transferToUser, transactionDate, transferPPSAmountInt);
     	transferPPSDao.insert(newTransfer);
     	System.out.println("Transfer Successful!");
        dispatcher = request.getRequestDispatcher("userLoggedIn.jsp");
    	dispatcher.forward(request, response);
    }
    
    
    private void displayDeposits(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
    	String currentUser = (String) session.getAttribute("currentEmail");
    	List<Deposit> depositList = new ArrayList<Deposit>();
    	depositList = depositDao.listAllDepositByUser(currentUser);
    	RequestDispatcher dispatcher;
    	request.setAttribute("depositList", depositList);
    	dispatcher = request.getRequestDispatcher("depositsPage.jsp");
    	dispatcher.forward(request,  response);
   }
    
    
    private void displayWithdrawals(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
    	String currentUser = (String) session.getAttribute("currentEmail");
    	List<Withdraw> withdrawalList = new ArrayList<Withdraw>();
    	withdrawalList = withdrawDao.listAllWithdrawByUser(currentUser);
    	RequestDispatcher dispatcher;
    	request.setAttribute("withdrawalList", withdrawalList);
    	dispatcher = request.getRequestDispatcher("withdrawalsPage.jsp");
    	dispatcher.forward(request,  response);
   }
    
    private void displayBuyPPS(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
    	String currentUser = (String) session.getAttribute("currentEmail");
    	List<BuyPPS> listBuyPPS = new ArrayList<BuyPPS>();
    	listBuyPPS = buyPPSDao.listAllBuyPPSByUser(currentUser);
    	RequestDispatcher dispatcher;
    	request.setAttribute("listBuyPPS", listBuyPPS);
    	dispatcher = request.getRequestDispatcher("PPSBoughtPage.jsp");
    	dispatcher.forward(request,  response);
    }
    
    private void displaySellPPS(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
    	String currentUser = (String) session.getAttribute("currentEmail");
    	List<SellPPS> listSellPPS = new ArrayList<SellPPS>();
    	listSellPPS = sellPPSDao.listAllSellPPSByUser(currentUser);
    	RequestDispatcher dispatcher;
    	request.setAttribute("listSellPPS", listSellPPS);
    	dispatcher = request.getRequestDispatcher("PPSSoldPage.jsp");
    	dispatcher.forward(request,  response);
    }
    
    private void displayTransferPPS(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
    	String currentUser = (String) session.getAttribute("currentEmail");
    	List<TransferPPS> listTransferPPS = new ArrayList<TransferPPS>();
    	listTransferPPS = transferPPSDao.listAllTransferPPSByUser(currentUser);
    	RequestDispatcher dispatcher;
    	request.setAttribute("listTransferPPS", listTransferPPS);
    	dispatcher = request.getRequestDispatcher("PPSTransfersPage.jsp");
    	dispatcher.forward(request,  response);
    }
    
    // So that a user can follow another user :-
    private void followAnotherUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        
    	RequestDispatcher dispatcher;
        session = request.getSession();
        
        // The current user's string will be stored in the string declared below :-
    	String currentUser = (String) session.getAttribute("currentEmail");
    	
    	// The user followed's email address will be stored in the string below :-
    	String theUserFollowed = request.getParameter("theUserFollowed");
    	System.out.println(theUserFollowed);

    	

    	//call the insert() function from FollowUserDao class. It will insert the record of "follower" and the user who is
    	// getting followed into the table 'follow'.
    	followUserDao.insert(currentUser, theUserFollowed);
    	
    	
        // After insertion above, we want to come back to the userLoggedIn.jsp page. Hence, the 
    	// below statements :-
        dispatcher = request.getRequestDispatcher("userLoggedIn.jsp");
    	dispatcher.forward(request, response);
    	
    	System.out.print("The user has successfully followed.");
    }
    
    //WIP
	private void displayFrequentBuyers(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException, NumberFormatException {
	    	
	    	List<BuyPPS> listFrequentBuyers = new ArrayList<BuyPPS>();
	    	listFrequentBuyers = buyPPSDao.listFrequentBuyers();
	    	RequestDispatcher dispatcher;
	    	request.setAttribute("listFrequentBuyers", listFrequentBuyers);
	    	dispatcher = request.getRequestDispatcher("frequentBuyersPage.jsp");
	    	dispatcher.forward(request,  response);
	    }
	   
    //DONE
	private void displayBiggestBuy(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException, NumberFormatException {
    	
    	List<BuyPPS> listBiggestBuy = new ArrayList<BuyPPS>();
    	listBiggestBuy = buyPPSDao.listBiggestBuy();
    	RequestDispatcher dispatcher;
    	request.setAttribute("listBiggestBuy", listBiggestBuy);
    	dispatcher = request.getRequestDispatcher("BiggestBuyPage.jsp");
    	dispatcher.forward(request,  response);
    }
    
	//DONE
	private void displayBiggestBuyers(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException, NumberFormatException {
    	
    	List<BuyPPS> listBiggestBuyer = new ArrayList<BuyPPS>();
    	listBiggestBuyer = buyPPSDao.listBiggestBuyer();
    	RequestDispatcher dispatcher;
    	request.setAttribute("listBiggestBuyer", listBiggestBuyer);
    	dispatcher = request.getRequestDispatcher("BiggestBuyerPage.jsp");
    	dispatcher.forward(request,  response);
    }
	
	//DONE
	private void displayPopularUsers(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException, NumberFormatException {
    	
    	List<FollowUser> listPopularUsers = new ArrayList<FollowUser>();
    	listPopularUsers = followUserDao.displayPopularUsers();
    	RequestDispatcher dispatcher;
    	request.setAttribute("listPopularUsers", listPopularUsers);
    	dispatcher = request.getRequestDispatcher("PopularUsersPage.jsp");
    	dispatcher.forward(request,  response);
    }
	
	//WIP
	private void displayCommonUsers(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException, NumberFormatException {
    	
    	List<TransferPPS> listNeverBuyUsers = new ArrayList<TransferPPS>();
    	listNeverBuyUsers = transferPPSDao.listNeverBuyUsers();
    	RequestDispatcher dispatcher;
    	request.setAttribute("listNeverBuyUsers", listNeverBuyUsers);
    	dispatcher = request.getRequestDispatcher("NeverBuyPage.jsp");
    	dispatcher.forward(request,  response);
    }
	
    //Done
    private void displayNeverBuyUsers(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException, NumberFormatException {
    	
    	List<TransferPPS> listNeverBuyUsers = new ArrayList<TransferPPS>();
    	listNeverBuyUsers = transferPPSDao.listNeverBuyUsers();
    	RequestDispatcher dispatcher;
    	request.setAttribute("listNeverBuyUsers", listNeverBuyUsers);
    	dispatcher = request.getRequestDispatcher("NeverBuyPage.jsp");
    	dispatcher.forward(request,  response);
    }
    
    //Done
    private void displayNeverSellUsers(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
    	List<Users> listNeverSellUsers = new ArrayList<Users>();
    	listNeverSellUsers = usersDao.listNeverSellUsers();
    	RequestDispatcher dispatcher;
    	request.setAttribute("listNeverSellUsers", listNeverSellUsers);
    	dispatcher = request.getRequestDispatcher("NeverSellPage.jsp");
    	dispatcher.forward(request,  response);
    }
    
    
    private void displayLuckyUsers(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
    	
    	List<FollowUser> listLuckyUsers = new ArrayList<FollowUser>();
    	listLuckyUsers = followUserDao.listLuckyUsers();
    	RequestDispatcher dispatcher;
    	request.setAttribute("listLuckyUsers", listLuckyUsers);
    	dispatcher = request.getRequestDispatcher("LuckyUsersPage.jsp");
    	dispatcher.forward(request,  response);
    }
    
    private void displayInactiveUsers(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
    	
    	List<Users> listInactiveUsers = new ArrayList<Users>();
    	listInactiveUsers = usersDao.listInactiveUsers();
    	RequestDispatcher dispatcher;
    	request.setAttribute("listInactiveUsers", listInactiveUsers);
    	dispatcher = request.getRequestDispatcher("InactiveUsersPage.jsp");
    	dispatcher.forward(request,  response);
    }
    
    private void displayStatistics(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
    	
    	RequestDispatcher dispatcher;
    	
    	List<Deposit> listTotalDeposits = new ArrayList<Deposit>();
    	listTotalDeposits = depositDao.listTotalDeposits();
    	request.setAttribute("listTotalDeposits", listTotalDeposits);
    	
    	List<Withdraw> listTotalWithdraws = new ArrayList<Withdraw>();
    	listTotalWithdraws = withdrawDao.listTotalWithdraws();
    	request.setAttribute("listTotalWithdraws", listTotalWithdraws);
    
    	
    	List<BuyPPS> listTotalBuyPPS = new ArrayList<BuyPPS>();
    	listTotalBuyPPS = buyPPSDao.listTotalBuyPPS();
    	request.setAttribute("listTotalBuyPPS", listTotalBuyPPS);
    	
    	    	
    	List<SellPPS> listTotalSellPPS = new ArrayList<SellPPS>();
    	listTotalSellPPS = sellPPSDao.listTotalSellPPS();
    	request.setAttribute("listTotalSellPPS", listTotalSellPPS);
    	
    	
    	List<TransferPPS> listTotalTransferPPS = new ArrayList<TransferPPS>();
    	listTotalTransferPPS = transferPPSDao.listTotalTransferPPS();
    	request.setAttribute("listTotalTransferPPS", listTotalTransferPPS);
    	
    	dispatcher = request.getRequestDispatcher("StatisticsPage.jsp");
    	dispatcher.forward(request,  response);
    }
    
}

/*

1. most buys
SELECT user_email, count(user_email) AS occurances
FROM buypps
GROUP BY user_email
ORDER BY occurances DESC
LIMIT 1;

2. largest buy

 SELECT tbl.user_email,tbl.number_pps_bought,tbl.pps_bought_date from buypps tbl
   join ( select MAX(number_pps_bought) as maxBought from buypps) tbl1
   on tbl1.maxBought=tbl.number_pps_bought;
   
)

3. 

Drop view if exists sum;
CREATE VIEW sum AS
	SELECT user_email, SUM(number_pps_bought) as sum
	FROM buypps
	GROUP BY user_email;

 SELECT tbl.user_email,tbl.sum from sum tbl
   join ( select MAX(sum) as maxSum from sum) tbl1
   on tbl1.maxSum=tbl.sum;

4. popular users

SELECT followed_user_email, count(*) AS count
FROM follow
GROUP BY followed_user_email
HAVING COUNT(followed_user_email) >= 5




*/