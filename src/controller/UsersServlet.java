//package controller;
//
//import evnprg.Login;
//import evnprg.Users;
//import evnprg.UsersDao;
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
//@WebServlet("/UsersServlet")
//public class UsersServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//    
//	private UsersDao usersDao;
//	
//	public void init() {
//        usersDao = new UsersDao();
//    }
//	
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public UsersServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//        System.out.println("doPost started: 000000000000000000000000000");
//		doGet(request, response);
//        System.out.println("doPost finished: 11111111111111111111111111");
//	}
//
//}
