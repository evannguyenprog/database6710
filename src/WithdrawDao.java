


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

@WebServlet("/WithdrawDao")

public class WithdrawDao {
	
	
	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public WithdrawDao() {
		
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
    
    // Function "listAllUsers()" is for printing all the rows/records
    // of 'Users' table(i.e User model/class in Java terminology.)
    public List<Withdraw> listAllWithdraw() throws SQLException {
        List<Withdraw> listWithdraw = new ArrayList<Withdraw>();  
        // A string 'sql' storing a sql query. 
        String sql = "SELECT * FROM Withdraw"; 
        // connecting with the database.
        connect_func();      
        statement =  (Statement) connect.createStatement();
        // executing the 'sql' query :
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
           
            int withdraw_id = resultSet.getInt("withdraw_id");
            String user_email = resultSet.getString("user_email");
            double withdraw_amount = resultSet.getDouble("withdraw_amount");
            String withdrawal_date = resultSet.getString("withdrawal_date");
            
            
             
            Withdraw withdraw = new Withdraw(withdraw_id, user_email, withdraw_amount, withdrawal_date);
            listWithdraw.add(withdraw);
        }        
        resultSet.close();
        statement.close();         
        disconnect();        
        return listWithdraw;
    }
    
 // Function "listAllWithdrawByUser()" is for printing all the rows/records
    // of a specific user
    public List<Withdraw> listAllWithdrawByUser(String current_user) throws SQLException {
        List<Withdraw> listWithdraw = new ArrayList<Withdraw>();  
        // A string 'sql' storing a sql query. 
        String sql = "SELECT * FROM Withdraw WHERE user_email =  '"+ current_user +"';";
        // connecting with the database.
        connect_func();      
        statement =  (Statement) connect.createStatement();
        // executing the 'sql' query :
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
           
            int withdraw_id = resultSet.getInt("withdraw_id");
            String user_email = resultSet.getString("user_email");
            double withdraw_amount = resultSet.getDouble("withdraw_amount");
            String withdrawal_date = resultSet.getString("withdrawal_date");
            
            
             
            Withdraw withdraw = new Withdraw(withdraw_id, user_email, withdraw_amount, withdrawal_date);
            listWithdraw.add(withdraw);
        }        
        resultSet.close();
        statement.close();         
        disconnect();        
        return listWithdraw;
    }
    
    //Function 'insert' below is to insert a row/record in the 'Users'
    // table of the PPS database in mysql.
    public void insert(Withdraw withdraw) throws SQLException {
    	connect_func();
    	String sql = "insert into  Withdraw (user_email, withdraw_amount, withdrawal_date) values (?, ?, ?)";
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
		preparedStatement.setString(1, withdraw.getUser_email());
		preparedStatement.setDouble(2, withdraw.getWithdraw_amount());
		preparedStatement.setString(3, withdraw.getWithdrawal_date());
		
		

		preparedStatement.executeUpdate();
        preparedStatement.close();
        disconnect();
    }
    
    // create table
 	public void createTable() throws SQLException {
 		try {
 			connect_func();
 			//Creating the table Withdraw :
 			String s = "CREATE TABLE Withdraw(\r\n"
 					+ "    withdraw_id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,\r\n"
 					+ "    user_email VARCHAR(20),\r\n"
 					+ "    withdraw_amount DOUBLE,\r\n"
 					+ "    withdrawal_date VARCHAR(10),\r\n"
 					+ "    FOREIGN KEY(user_email) REFERENCES Users(email)   \r\n"
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
 			System.out.println("'Withdraw' table created.");
 		//	statement.executeUpdate(s2);
 			System.out.println("Multiple Withdraw Rows are Added.");
 			
 		} catch (Exception e) {
 			System.out.println(e);
 		} finally {
 			statement.close(); //might cause issue, check back after testing
 		}
 	}

 	// drop table function
  	public void dropTable() throws SQLException {
 		connect_func();
 		statement = (Statement) connect.createStatement();
 		statement.executeUpdate("SET FOREIGN_KEY_CHECKS = 0");
 		statement.executeUpdate("DROP TABLE IF EXISTS Withdraw");
 		statement.executeUpdate("SET FOREIGN_KEY_CHECKS = 1");
  	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
