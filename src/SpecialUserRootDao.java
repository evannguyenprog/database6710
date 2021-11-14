

import java.net.ConnectException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/SpecialRootUserDao")

public class SpecialUserRootDao {

	
	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public SpecialUserRootDao() {
		
	}
	
	//The below function connect_func(), is used for connecting with the 
	// mySQL database.
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
    
//    // Function "listAllSellPPS()" is for printing all the rows/records
//    // of 'SellPPS' table(i.e User model/class in Java terminology.)
//    public List<SellPPS> listAllSellPPS() throws SQLException {
//        List<SellPPS> listSellPPS = new ArrayList<SellPPS>();  
//        // A string 'sql' storing a sql query. 
//        String sql = "SELECT * FROM SellPPS"; 
//        // connecting with the database.
//        connect_func();      
//        statement =  (Statement) connect.createStatement();
//        // executing the 'sql' query :
//        ResultSet resultSet = statement.executeQuery(sql);
//         
//        while (resultSet.next()) {
//           
//            int id = resultSet.getInt("id");
//            String user_email = resultSet.getString("user_email");
//            int number_pps_sold = resultSet.getInt("number_pps_sold");
//            String pps_sold_date = resultSet.getString("pps_sold_date");
//            
//            
//             
//            SellPPS sell_pps = new SellPPS(id, user_email, number_pps_sold, pps_sold_date);
//            listSellPPS.add(sell_pps);
//        }        
//        resultSet.close();
//        statement.close();         
//        disconnect();        
//        return listSellPPS;
//    }
    
//    //Function 'insert' below is to insert a row/record in the 'SellPPS'
//    // table of the PPS database in mysql.
//    public void insert(SellPPS sell_pps) throws SQLException {
//    	connect_func();
//    	String sql = "insert into  SellPPS (user_email, number_pps_sold, pps_sold_date) values (?, ?, ?)";
//		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
//		preparedStatement.setString(1, sell_pps.getUser_email());
//		preparedStatement.setInt(2, sell_pps.getNumber_pps_sold());
//		preparedStatement.setString(3, sell_pps.getPps_sold_date());
//		
//		
//
//		preparedStatement.executeUpdate();
//        preparedStatement.close();
//        disconnect();
//    }
    
    // create table
 	public void createTable() throws SQLException { //TO DO: Add value of pps as an attribute
 		try {
 			connect_func();
 			//Creating the table RootUser :
 			String s = "CREATE TABLE RootUser(\r\n"
 					+ "email VARCHAR(30) NOT NULL, "
 					+ "password VARCHAR(30) NOT NULL, "
 					+ "firstName VARCHAR(20) NOT NULL, "
 					+ "lastName VARCHAR(20) NOT NULL, "
 					+ "birthday VARCHAR(10) NOT NULL, "
 					+ "ppsBalance DOUBLE(10,2), "
 					+ "ppsPrice DOUBLE(10,2), " //ADDed
 					+ "balanceOfMoneyRoot DOUBLE(10,2), " 
 					+ "PRIMARY KEY(email));";
 			// Inserting into the table SellPPS :
 			String s2 = "INSERT INTO RootUser(email, password, firstName, lastName, birthday, ppsBalance, ppsPrice, balanceOfMoneyRoot) VALUES\r\n"
 					+ "('root', 'pass1234', 'root', 'root', '10/12/2021',  '10000000.00', '1000000.00', '10000000.00');";
 			
 		
 			statement.executeUpdate(s);
 			System.out.println("'SellPPS' table created.");
 			statement.executeUpdate(s2);
 			System.out.println("Root User and table Added.");
 			

 		} catch (Exception e) {
 			System.out.println(e);
 		} finally {
 			statement.close();
 		}
 	}

 	// drop table function
  	public void dropTable() throws SQLException {
 		connect_func();
 		statement = (Statement) connect.createStatement();
 		statement.executeUpdate("SET FOREIGN_KEY_CHECKS = 0");
 		statement.executeUpdate("DROP TABLE IF EXISTS RootUser");
 		statement.executeUpdate("SET FOREIGN_KEY_CHECKS = 1");
  	}

 // email and username verification function
 	// need to implement password functionality and store password before we can log in users and authenticate sessions
   	//function done
   	public boolean validityCheck(String email, String password) throws SQLException {
  		connect_func();
  		boolean flag = false;

  		statement = (Statement) connect.createStatement();
  		String s = "Select * from RootUser where email='" + email + "' and password='" + password + "'";
  		ResultSet rs = statement.executeQuery(s);
  			
  		if(rs.next())
  			flag = true;
  		return flag;
  	}

}
