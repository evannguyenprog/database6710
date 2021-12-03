
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

@WebServlet("/FollowUserDao")

public class FollowUserDao {
	
	// This class will have attributes and methods 
	// We need to define the createTable() method in order to create the table
	// for keeping the record of follower-followed details.
	
	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	//Constructor
    public FollowUserDao() {
		
	}
    
    
    // connect_func() method to connect with the database.
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
      
      
      public void createTable() throws SQLException {
   		try {
   			connect_func();
   			//Creating the table Withdraw :
   			String s = "create table  follow(\r\n"
   					+ "id int auto_increment primary key,\r\n"
   					+ "follower_user_email varchar(40),\r\n"
   					+ "followed_user_email varchar(40)\r\n"
   					+ ");";
   			
   			// Inserting into the table Withdraw :
   		//	String s2 = " INSERT INTO Withdraw(user_email, withdraw_amount, withdrawal_date) VALUES\r\n"
   		//			+ " 					('evan@gmail.com',0.00,'09/01/2021'),\r\n"
   		//			+ " 					('smit@gmail.com', 0.00,'09/01/2021'),\r\n"
   		//			+ " 					('john@gmail.com', 0.00,'09/11/2021'),\r\n"
   		//			+ " 					('mihir@yahoo.com', 0.00,'09/24/2021'),\r\n"
   		//			+ " 					('varun@gmail.com', 0.00,'09/19/2021'),\r\n"
   		//			+ " 					('Tej@aol.com', 0.00,'09/18/2021'),\r\n"
   		//			+ " 					('mike@gmail.com', 0.00,'09/05/2021'),\r\n"
   		//			+ " 					('tenisee@yahoo.com', 0.00,'09/01/2021'),\r\n"
   		//			+ " 					('Ghanu@gmail.com', 0.00,'09/01/2021'),\r\n"
   		//			+ " 					('trott@hotmail.com', 0.00,'09/01/2021');";
   
   			statement.executeUpdate(s);
   			System.out.println("'Follow' table created.");
   		//	statement.executeUpdate(s2);
   			
   		} catch (Exception e) {
   			System.out.println(e);
   		} finally {
   			statement.close(); //might cause issue, check back after testing
   		}
   	}

      
    public void dropTable() throws SQLException {
     		connect_func();
     		statement = (Statement) connect.createStatement();
     		statement.executeUpdate("SET FOREIGN_KEY_CHECKS = 0");
     		statement.executeUpdate("DROP TABLE IF EXISTS Follow");
     		statement.executeUpdate("SET FOREIGN_KEY_CHECKS = 1");
      	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
