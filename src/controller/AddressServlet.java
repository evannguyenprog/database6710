//package controller;
//
//import evnprg.Address;
//import evnprg.AddressDao;
//import evnprg.Login;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.sql.PreparedStatement;
//
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.RequestDispatcher;
//
//
//
///**
// * Servlet implementation class UsersServlet
// * This servlet acts as a page controller for the application, handling all
// * requests from the user.
// */
//
//@WebServlet("/AddressServlet")
//public class AddressServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	private AddressDao AddressDao;
//	
//	public void init() {
//        AddressDao = new AddressDao();
//    }
//	
//	
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public AddressServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        System.out.println("doPost started: 000000000000000000000000000");
//        doGet(request, response);
//        System.out.println("doPost finished: 11111111111111111111111111");
//    }
// 
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        System.out.println("doGet started: 000000000000000000000000000"); 
//     
//        String action = request.getServletPath();
//        System.out.println(action);
//        try {
//            switch (action) {
//            // Listing is probably the only action we'll perform in the first, 
//            // part of project. 
//            case "/list": 
//                System.out.println("The action is: list");
//                listAddress(request, response);           	
//                break;
//            case "/insert":
//                System.out.println("The action is: insert");
//            	//insertAddress(request, response);
//                break;
//                
//            case "/delete":
//                System.out.println("The action is: delete");
//            	
//                break;
//            case "/edit":
//                System.out.println("The action is: edit");
//                break;
//            case "/update":
//                System.out.println("The action is: update");
//                break;
//            default:
//                System.out.println("Not sure which action, we will treat it as the list address");
//                listAddress(request, response);           	
//                break;
//            }
//        } catch (SQLException ex) {
//            throw new ServletException(ex);
//        }
//        System.out.println("doGet finished: 111111111111111111111111111111111111");
//    }
//    
//    private void listAddress(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException, ServletException {
//        System.out.println("listingAddresses started: 00000000000000000000000000000000000");
//
//        // Below block of code will list all the addresses of the users. 
//        
//        // Capturing the list of all the addresses in the below statement.
//        List<Address> listAddress = AddressDao.listAllAddress();
//        request.setAttribute("listAddress", listAddress);     
//        // ToDo : Please pass the parameter for "getResquestDispatcher()" below:
//        // i.e. a frontend page that it corresponds to : 
//        RequestDispatcher dispatcher = request.getRequestDispatcher("");       
//        dispatcher.forward(request, response);
//     
//        System.out.println("listAddress finished: 111111111111111111111111111111111111");
//    }
// 
//   
// 
//
// 
// 
//   
//
//}