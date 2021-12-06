



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


//@WebServlet("/SellPPSDao")

public class SellPPSDao {

	
	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public SellPPSDao() {
		
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
    
    // Function "listAllSellPPS()" is for printing all the rows/records
    // of 'SellPPS' table(i.e User model/class in Java terminology.)
    public List<SellPPS> listAllSellPPS() throws SQLException {
        List<SellPPS> listSellPPS = new ArrayList<SellPPS>();  
        // A string 'sql' storing a sql query. 
        String sql = "SELECT * FROM SellPPS"; 
        // connecting with the database.
        connect_func();      
        statement =  (Statement) connect.createStatement();
        // executing the 'sql' query :
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
           
            int id = resultSet.getInt("id");
            String user_email = resultSet.getString("user_email");
            int number_pps_sold = resultSet.getInt("number_pps_sold");
            String pps_sold_date = resultSet.getString("pps_sold_date");
            
            
             
            SellPPS sell_pps = new SellPPS(id, user_email, number_pps_sold, pps_sold_date);
            listSellPPS.add(sell_pps);
        }        
        resultSet.close();
        statement.close();         
        disconnect();        
        return listSellPPS;
    }
    
    // Function "listAllSellPPS()" is for printing all the rows/records
    // of 'SellPPS' table(i.e User model/class in Java terminology.)
    public List<SellPPS> listAllSellPPSByUser(String current_user) throws SQLException {
        List<SellPPS> listSellPPS = new ArrayList<SellPPS>();  
        // A string 'sql' storing a sql query. 
        String sql = "SELECT * FROM SellPPS WHERE user_email = '"+ current_user +"';"; 
        // connecting with the database.
        connect_func();      
        statement =  (Statement) connect.createStatement();
        // executing the 'sql' query :
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
           
            int id = resultSet.getInt("id");
            String user_email = resultSet.getString("user_email");
            int number_pps_sold = resultSet.getInt("number_pps_sold");
            String pps_sold_date = resultSet.getString("pps_sold_date");
            
            
             
            SellPPS sell_pps = new SellPPS(id, user_email, number_pps_sold, pps_sold_date);
            listSellPPS.add(sell_pps);
        }        
        resultSet.close();
        statement.close();         
        return listSellPPS;
    }
    
    
    //Function 'insert' below is to insert a row/record in the 'SellPPS'
    // table of the PPS database in mysql.
    public void insert(SellPPS sell_pps) throws SQLException {
    	connect_func();
    	String sql = "insert into  SellPPS (user_email, number_pps_sold, pps_sold_date) values (?, ?, ?)";
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
		preparedStatement.setString(1, sell_pps.getUser_email());
		preparedStatement.setDouble(2, sell_pps.getNumber_pps_sold());
		preparedStatement.setString(3, sell_pps.getPps_sold_date());
		
		

		preparedStatement.executeUpdate();
        preparedStatement.close();
        disconnect();
    }
    
    // create table
 	public void createTable() throws SQLException {
 		try {
 			connect_func();
 			//Creating the table SellPPS :
 			String s = "CREATE TABLE SellPPS(\r\n"
 					+ " 					id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,\r\n"
 					+ " 					user_email VARCHAR(20),\r\n"
 					+ " 					number_pps_sold INTEGER,\r\n"
 					+ " 					pps_sold_date VARCHAR(10),\r\n"
 					+ " 					FOREIGN KEY(user_email) REFERENCES Users(email)\r\n"
 					+ " 					);";
 			
 			// Inserting into the table SellPPS :
 			//String s2 = "INSERT INTO SellPPS(user_email, number_pps_sold, pps_sold_date) VALUES\r\n"
 			//		+ " 				('evan@gmail.com',0.00,'09/01/2021'),\r\n"
 			//		+ "			        ('smit@gmail.com', 0.00,'09/01/2021'),\r\n"
 			//		+ " 				('john@gmail.com', 0.00,'09/11/2021'),\r\n"
 			//		+ " 				('mihir@yahoo.com', 0.00,'09/24/2021'),\r\n"
 			//		+ " 				('varun@gmail.com', 0.00,'09/19/2021'),\r\n"
 			//		+ " 				('Tej@aol.com', 0.00,'09/18/2021'),\r\n"
 			//		+ " 				('mike@gmail.com', 0.00,'09/05/2021'),\r\n"
 			//		+ " 				('tenisee@yahoo.com', 0.00,'09/01/2021'),\r\n"
 			//		+ " 				('Ghanu@gmail.com', 0.00,'09/01/2021'),\r\n"
 			//		+ " 				('trott@hotmail.com', 0.00,'09/01/2021');";
 
 			statement.executeUpdate(s);
 			System.out.println("'SellPPS' table created.");
 		//	statement.executeUpdate(s2);
 			System.out.println("Multiple SellPPS Rows are Added.");
 			
 		} catch (Exception e) {
 			System.out.println(e);
 		} finally {
 			statement.close();
 		}
 	}
 	
 	 // Function "listTotalSellPPS()" is for listing total number of counts of pps bought overall.

    public List<SellPPS> listTotalSellPPS() throws SQLException {
        List<SellPPS> listTotalSellPPS = new ArrayList<SellPPS>();  
        // A string 'sql' storing a sql query. 
        String sql = "select count(*) as number_pps_sold from sellpps;"; 
        // connecting with the database.
        connect_func();      
        statement =  (Statement) connect.createStatement();
        // executing the 'sql' query :
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
        	
           System.out.print("starts .........................");
            double total_sellpps = resultSet.getDouble("number_pps_sold");
            System.out.print("ends .........................");
           
            SellPPS sell_pps = new SellPPS(total_sellpps);
            listTotalSellPPS.add(sell_pps);
        }        
        resultSet.close();
        statement.close();         
        return listTotalSellPPS;
    }

 	// drop table function
  	public void dropTable() throws SQLException {
 		connect_func();
 		statement = (Statement) connect.createStatement();
 		statement.executeUpdate("SET FOREIGN_KEY_CHECKS = 0");
 		statement.executeUpdate("DROP TABLE IF EXISTS SellPPS");
 		statement.executeUpdate("SET FOREIGN_KEY_CHECKS = 1");
  	}

	

}
