

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


//@WebServlet("/BuyPPSDao")

public class BuyPPSDao {

	
	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public BuyPPSDao() {
		
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
    
    // Function "listAllBuyPPS()" is for printing all the rows/records
    // of 'BuyPPS' table(i.e User model/class in Java terminology.)
    public List<BuyPPS> listAllBuyPPS() throws SQLException {
        List<BuyPPS> listBuyPPS = new ArrayList<BuyPPS>();  
        // A string 'sql' storing a sql query. 
        String sql = "SELECT * FROM BuyPPS"; 
        // connecting with the database.
        connect_func();      
        statement =  (Statement) connect.createStatement();
        // executing the 'sql' query :
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
           
            int id = resultSet.getInt("id");
            String user_email = resultSet.getString("user_email");
            int number_pps_bought = resultSet.getInt("number_pps_bought");
            String pps_bought_date = resultSet.getString("pps_bought_date");
            
            
             
            BuyPPS buy_pps = new BuyPPS(id, user_email, number_pps_bought, pps_bought_date);
            listBuyPPS.add(buy_pps);
        }        
        resultSet.close();
        statement.close();         
        disconnect();        
        return listBuyPPS;
    }
    
    
 // Function "listFrequentBuyers()" lists users with most amount of buys
    public List<BuyPPS> listFrequentBuyers() throws SQLException {
        List<BuyPPS> listFrequentBuyers = new ArrayList<BuyPPS>();  
        // A string 'sql' storing a sql query. 
        String sql = "\r\n"
        		+ "select user_email, count(user_email) AS occurances\r\n"
        		+ "FROM buypps\r\n"
        		+ "GROUP BY user_email\r\n"
        		+ "ORDER BY occurances DESC;"; 
        // connecting with the database.
        connect_func();      
        statement =  (Statement) connect.createStatement();
        // executing the 'sql' query :
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
        	
           System.out.println("starts .........................");
            String user_email = resultSet.getString("user_email");
            int occurances = resultSet.getInt("occurances");
            System.out.println("ends .........................");
            System.out.println(occurances);

            BuyPPS frequentBuyer = new BuyPPS(user_email, occurances);
            listFrequentBuyers.add(frequentBuyer);
        }
        resultSet.close();
        statement.close();         
        return listFrequentBuyers;
    }
    
    
    // Function "listFrequentBuyers()" lists users with most amount of buys
    public List<BuyPPS> listBiggestBuy() throws SQLException {
        List<BuyPPS> listBiggestBuy = new ArrayList<BuyPPS>();  
        // A string 'sql' storing a sql query. 
        String sql = "\r\n"
        		+ " SELECT tbl.user_email,tbl.number_pps_bought,tbl.pps_bought_date from buypps tbl\r\n"
        		+ "join ( select MAX(number_pps_bought) as maxBought from buypps) tbl1\r\n"
        		+ "on tbl1.maxBought=tbl.number_pps_bought;"; 
        // connecting with the database.
        connect_func();      
        statement =  (Statement) connect.createStatement();
        // executing the 'sql' query :
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
        	
           System.out.println("starts .........................");
            String user_email = resultSet.getString("user_email");
            Double number_pps_bought = resultSet.getDouble("number_pps_bought");
            String pps_bought_date = resultSet.getString("pps_bought_date");
            System.out.println("ends .........................");

            BuyPPS biggestBuy = new BuyPPS(user_email, number_pps_bought, pps_bought_date);
            listBiggestBuy.add(biggestBuy);
        }
        resultSet.close();
        statement.close();         
        return listBiggestBuy;
    }
    
    
    // Function "listFrequentBuyers()" lists users with most amount of buys
    public List<BuyPPS> listBiggestBuyer() throws SQLException {
        List<BuyPPS> listBiggestBuyer = new ArrayList<BuyPPS>();  
        // A string 'sql' storing a sql query. 
        
        String sql = "\r\n"
        	
        		+ "SELECT tbl.user_email,tbl.sum from sum tbl\r\n"
        		+ "join ( select MAX(sum) as maxSum from sum) tbl1\r\n"
        		+ "on tbl1.maxSum=tbl.sum;"; 
        // connecting with the database.
        connect_func();
        statement =  (Statement) connect.createStatement();
        // executing the 'sql' query :
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
        	
           System.out.println("starts .........................");
            String user_email = resultSet.getString("user_email");
            Double total_pps_bought = resultSet.getDouble("sum");
            System.out.println("ends .........................");

            BuyPPS biggestBuyer = new BuyPPS(user_email, total_pps_bought);
            listBiggestBuyer.add(biggestBuyer);
        }
        resultSet.close();
        statement.close();         
        return listBiggestBuyer;
    }
    
    
 // Function "listAllBuyPPS()" is for printing all the rows/records
    // of 'BuyPPS' table(i.e User model/class in Java terminology.)
    public List<BuyPPS> listAllBuyPPSByUser(String current_user) throws SQLException {
        List<BuyPPS> listBuyPPS = new ArrayList<BuyPPS>();  
        // A string 'sql' storing a sql query. 
        String sql = "SELECT * FROM BuyPPS WHERE user_email = '" + current_user + "';"; 
        // connecting with the database.
        connect_func();      
        statement =  (Statement) connect.createStatement();
        // executing the 'sql' query :
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
           
            int id = resultSet.getInt("id");
            String user_email = resultSet.getString("user_email");
            int number_pps_bought = resultSet.getInt("number_pps_bought");
            String pps_bought_date = resultSet.getString("pps_bought_date");
            
           
            BuyPPS buy_pps = new BuyPPS(id, user_email, number_pps_bought, pps_bought_date);
            listBuyPPS.add(buy_pps);
        }        
        resultSet.close();
        statement.close();         
        return listBuyPPS;
    }
    
    //Function 'insert' below is to insert a row/record in the 'BuyPPS'
    // table of the PPS database in mysql.
    public void insert(BuyPPS buy_pps) throws SQLException {
    	connect_func();
    	String sql = "insert into  BuyPPS (user_email, number_pps_bought, pps_bought_date) values (?, ?, ?)";
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
		preparedStatement.setString(1, buy_pps.getUser_email());
		preparedStatement.setDouble(2, buy_pps.getNumber_pps_bought());
		preparedStatement.setString(3, buy_pps.getPps_bought_date());
		preparedStatement.executeUpdate();
        preparedStatement.close();
        disconnect();
    }
    
    // create table
 	public void createTable() throws SQLException {
 		try {
 			connect_func();
 			//Creating the table BuyPPS :
 			String s = "CREATE TABLE BuyPPS(\r\n"
 					+ " 					id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,\r\n"
 					+ " 					user_email VARCHAR(20),\r\n"
 					+ " 					number_pps_bought DOUBLE(10,2),\r\n"
 					+ " 					pps_bought_date VARCHAR(10),\r\n"
 					+ " 					FOREIGN KEY(user_email) REFERENCES Users(email)\r\n"
 					+ " 					);";
 			
 			// Inserting into the table BuyPPS :
 			//String s2 = "INSERT INTO BuyPPS(user_email, number_pps_bought, pps_bought_date) VALUES\r\n"
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
 			System.out.println("'BuyPPS' table created.");
 			//statement.executeUpdate(s2);
 			System.out.println("Multiple BuyPPS Rows are Added.");
 			
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
 		statement.executeUpdate("DROP TABLE IF EXISTS BuyPPS");
 		statement.executeUpdate("DROP VIEW IF EXISTS sum");
 		statement.executeUpdate("SET FOREIGN_KEY_CHECKS = 1");
	
  	}
  	
  	 // create table
 	public void createView() throws SQLException {
 		try {
 			connect_func();
 			//Creating the table BuyPPS :
 		     String createView = "\r\n"
 			    	+ "CREATE VIEW sum AS\r\n"
 			    	+ "SELECT user_email, SUM(number_pps_bought) as sum\r\n"
 			    	+ "FROM buypps\r\n"
 			    	+ "GROUP BY user_email;\r\n";
  	
 			statement.executeUpdate(createView);
 			System.out.println("'sum' view created.");
 			
 		} catch (Exception e) {
 			System.out.println(e);
 		} finally {
 			statement.close();
 		}
 	}
 	
 // Function "listNeverBuyUsers()" is for listing all the users who have never bought PPS
  	// But, just have received the PPS from other users via transfer.
    public List<BuyPPS> listNeverBuyUsers() throws SQLException {
        List<BuyPPS> listNeverBuyUsers = new ArrayList<BuyPPS>();  
        // A string 'sql' storing a sql query. 
        String sql = "\r\n"
        		+ "select distinct t.receiving_user_email\r\n"
        		+ "from transferpps as t\r\n"
        		+ "where t.receiving_user_email \r\n"
        		+ "NOT IN\r\n"
        		+ "(select user_email \r\n"
        		+ "from buypps);"; 
        // connecting with the database.
        connect_func();      
        statement =  (Statement) connect.createStatement();
        // executing the 'sql' query :
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
        	
           System.out.print("starts .........................");
            String receiving_user_email = resultSet.getString("receiving_user_email");
            System.out.print("ends .........................");
           
            BuyPPS buy_pps = new BuyPPS(receiving_user_email);
            listNeverBuyUsers.add(buy_pps);
        }        
        resultSet.close();
        statement.close();         
        return listNeverBuyUsers;
    }

    
    
    // Function "listTotalBuyPPS()" is for listing total number of counts of pps bought overall.

    public List<BuyPPS> listTotalBuyPPS() throws SQLException {
        List<BuyPPS> listTotalBuyPPS = new ArrayList<BuyPPS>();  
        // A string 'sql' storing a sql query. 
        String sql = "select count(*) as number_pps_bought from buypps;"; 
        // connecting with the database.
        connect_func();      
        statement =  (Statement) connect.createStatement();
        // executing the 'sql' query :
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
        	
           System.out.print("starts .........................");
            double total_buypps = resultSet.getDouble("number_pps_bought");
            System.out.print("ends .........................");
           
            BuyPPS buy_pps = new BuyPPS(total_buypps);
            listTotalBuyPPS.add(buy_pps);
        }        
        resultSet.close();
        statement.close();         
        return listTotalBuyPPS;
    }
	

	public static void main(String[] args) {
	

	}

}
