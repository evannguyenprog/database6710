

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



//@WebServlet("/UsersDao")

public class UsersDao {

	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public UsersDao() {
		
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
    
    private void close() throws SQLException {
		if (resultSet != null)
			resultSet.close();
		if (statement != null)
			statement.close();
	}
    
    // Function "listAllUsers()" is for printing all the rows/records
    // of 'Users' table(i.e User model/class in Java terminology.)
    public List<Users> listAllUsers() throws SQLException {
        List<Users> listUsers = new ArrayList<Users>();  
        // A string 'sql' storing a sql query. 
        String sql = "SELECT * FROM Users"; 
        // connecting with the database.
        connect_func();      
        statement =  (Statement) connect.createStatement();
        // executing the 'sql' query :
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
           
            String email = resultSet.getString("email");
            String password = resultSet.getString("password");
            String firstName = resultSet.getString("firstName");
            String lastName = resultSet.getString("lastName");
            String birthday = resultSet.getString("birthday");
            double ppsBalance = resultSet.getDouble("ppsBalance");
            
             
            Users users = new Users(email, password, firstName, lastName, birthday, ppsBalance);
            listUsers.add(users);
        }        
        resultSet.close();
        statement.close();         
        disconnect();        
        return listUsers;
    }
    
    //Function 'insert' below is to insert a row/record in the 'Users'
    // table of the PPS database in mysql.
    public void insert(Users user) throws SQLException {
    	connect_func();
    	String sql = "insert into  Users (email, password, firstName, lastName, birthday,  ppsBalance) values (?, ?, ?, ?, ?, ?)";
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
		preparedStatement.setString(1, user.getEmail());
		preparedStatement.setString(2, user.getPassword());
		preparedStatement.setString(3, user.getFirstName());
		preparedStatement.setString(4, user.getLastName());
		preparedStatement.setString(5, user.getBirthday());
		preparedStatement.setDouble(6, user.getPpsBalance());

		preparedStatement.executeUpdate();
        preparedStatement.close();
        disconnect();
    }
    
    //Function 'insert' below is to insert a row/record in the 'Users'
    // table of the PPS database in mysql.
    public void addPPS(Double pps, String user_email) throws SQLException {
    	connect_func();
  		statement = (Statement) connect.createStatement();
  		String sql = "UPDATE users SET ppsBalance = ? WHERE email=?;";
  		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
		preparedStatement.setDouble(1, pps);
		preparedStatement.setString(2, user_email);
		preparedStatement.executeUpdate();
        preparedStatement.close();
    }
    
    
    // create users table
 	public void createTable() throws SQLException {
 		try {
 			connect_func();
 			String s = "CREATE TABLE Users "
 					+ "( email VARCHAR(30) NOT NULL, "
 					+ "password VARCHAR(30) NOT NULL, "
 					+ "firstName VARCHAR(20) NOT NULL, "
 					+ "lastName VARCHAR(20) NOT NULL, "
 					+ "birthday VARCHAR(10) NOT NULL, "
 					+ "ppsBalance DOUBLE(10,2), "
 					+ "PRIMARY KEY(email));";
 			//todo: add more users here
 			//might have to change how address is stored
 			// Removed the address attribute and its values in then below INSERT statement of 'Users' table.
 			// 
 			String s2 = " INSERT INTO Users(email, password, firstName, lastName, birthday, ppsBalance) VALUES"
 					+ "('evan@gmail.com', 'pass1234', 'Evan', 'Nguyen', '09/01/2021',  '0.00'),"
 					+ "('smit@gmail.com', 'pass1234', 'Smit', 'Patel', '09/10/2021',  '0.00'),"
 					+ "('john@gmail.com', 'pass1234', 'John', 'Holdings','09/12/2021',  '0.00'),"
 					+ "('mihir@yahoo.com', 'pass1234', 'Mihir', 'Patel', '09/19/2021',  '0.00'),"
 					+ "('varun@gmail.com', 'pass1234', 'Varun', 'Sharma', '09/18/2021',  '0.00'),"
 					+ "('Tej@aol.com', 'pass1234', 'Tej', 'Singh', '09/07/2021',  '0.00'),"
 					+ "('mike@gmail.com', 'pass1234', 'Mike', 'Hussey', '09/12/2021',  '0.00'),"
 					+ "('tenisee@yahoo.com', 'pass1234', 'Tenise', 'McCullum', '09/12/2021',  '0.00'),"
 					+ "('Ghanu@gmail.com', 'pass1234', 'Ghanshyam', 'Mahaprabhu', '09/12/2021',  '0.00'),"
 					+ "('trott@hotmail.com', 'pass1234', 'Jonathan', 'Trott', '10/12/2021',  '0.00');";
 
 			statement.executeUpdate(s);
 			System.out.println("'Users' table created.");
 			statement.executeUpdate(s2);
 			System.out.println("Multiple users added.");
 			
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
 		statement.executeUpdate("DROP TABLE IF EXISTS Users");
 		statement.executeUpdate("SET FOREIGN_KEY_CHECKS = 1");
  	}

  	// email and username verification function
	// need to implement password functionality and store password before we can log in users and authenticate sessions
  	//function done
  	public boolean validityCheck(String email, String password) throws SQLException {
 		connect_func();
 		boolean flag = false;

 		statement = (Statement) connect.createStatement();
 		String s = "Select * from Users where email='" + email + "' and password='" + password + "'";
 		ResultSet rs = statement.executeQuery(s);
 			
 		if(rs.next())
 			flag = true;
 		return flag;
 	}
  	
	  	
 // Function to check if the username / email already exists
 	public boolean duplicateEmailCheck(String email) throws SQLException {
 		connect_func();
 		boolean flag = false;
 		statement = (Statement) connect.createStatement();
 		String s2 = "Select * from Users where email='" + email + "'";
 		ResultSet rs = statement.executeQuery(s2);
 			
 		if(rs.next())
 			flag = true;
 		return flag;
 	}
  	
  	
  	//add future functions below here
 	
 	
 	
 	// Function to obtain the current ppsBalance of the 'user' : (TO BE VERIFIED!!)
 	public double currentPPSBalance(String user_email) throws SQLException{
 		
 		connect_func();
 		
 		// SQL query to get the current ppsBalance of the user :
 		String sql = "select ppsBalance from users where email = '"+ user_email +"';";
 		
 		// Preparing the above statement below :
// 		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
// 		preparedStatement.setString(1, user_email);
// 		
 		// Executing the prepared query in the database (THIS NEEDS TO BE CHECKED !!!!!!!!!!)
        statement =  (Statement) connect.createStatement();
 		resultSet = statement.executeQuery(sql);
 		double currentPPSBalance = 0;
 		
        while (resultSet.next()) {
	 		// Extracting the "ppsBalance" from the resultSet :
	 		currentPPSBalance = resultSet.getDouble("ppsBalance");
        }        

        //resultSet.close();
        statement.close();  
        //disconnect();
 		// returning the PPSBalance
		return currentPPSBalance;	
 	}
 	
 	
 	public double currentPPSBalanceRoot() throws SQLException {
 		
 		connect_func();
 		
 		statement = (Statement) connect.createStatement();
 		String sql = "select ppsBalance from rootuser where email='root'";
 		ResultSet rs = statement.executeQuery(sql);
 		
 		double currentPPSBalanceRoot = 0;
 		
 		while (rs.next()) {
	 		// Extracting the "ppsBalance" from the resultSet :
 			currentPPSBalanceRoot = rs.getDouble("ppsBalance");
        }        

        //resultSet.close();
        statement.close();  
        //disconnect();
 		
 		return currentPPSBalanceRoot;
 	}
 	
 	
    public double currentPPSPrice() throws SQLException {
 		
 		connect_func();
 		
 		statement = (Statement) connect.createStatement();
 		String sql = "select ppsPrice from rootuser where email='root'";
 		ResultSet rs = statement.executeQuery(sql);
 		
 		double currentPPSPrice = 0;
 		while (rs.next()) {
 			currentPPSPrice = rs.getDouble("ppsPrice");
 		}
 		
 		//resultSet.close();
        statement.close();  
 		//disconnect();
 		
 		return currentPPSPrice;
 	}
    
    
    public double currentBalanceOfMoney(String user_email) throws SQLException{
    	
        connect_func();
 		
 		statement = (Statement) connect.createStatement();
 		String sql = "select balance_in_dollars from balanceOfMoney where user_email='"+user_email+"';";
 		ResultSet rs = statement.executeQuery(sql);
 		
 		double balance_in_dollars = 0;
 		while (rs.next()) {
 			 balance_in_dollars = rs.getDouble("balance_in_dollars");
 		}
 		
 		//resultSet.close();
        statement.close();  
 		//disconnect();
 		
 		
 		
    	return balance_in_dollars;
    	
    }
    
     public double currentBalanceOfMoneyRoot() throws SQLException{
    	
        connect_func();
 		
 		statement = (Statement) connect.createStatement();
 		String sql = "select balanceOfMoneyRoot from rootuser where email='root';";
 		ResultSet rs = statement.executeQuery(sql);
 		
 		double balanceOfMoneyRoot = 0;
 		
        while (rs.next()) {

        	balanceOfMoneyRoot = rs.getDouble("balanceOfMoneyRoot");
        }
        
        //resultSet.close();
        statement.close();  
 		//disconnect();
 		
 		
    	return balanceOfMoneyRoot;
    	
    }
 	
 	
    
 	// Function to sell the PPS to the rootuser :
 	public void sellPPSAmount(String seller, double numberPpsToSell) throws SQLException  {
 	    
 		// Connecting with the database :
 		connect_func();
 		
 		// First of all we need to check if the seller has enough PPS that he/she
 		// wants to sell from his/her PPSbalance.
 		
 		// i.e. Get the PPSbalance of the seller and check if it's more than or equal to 
 		// the number of PPS he/she wants to sell.
 		
 		//currentPPSBalance of the seller :
 		double currentPPSBalance = currentPPSBalance(seller);
 		
 		//currentPPSBalanceRoot :
 		double currentPPSBalanceRoot = currentPPSBalanceRoot();
 		
 		if(numberPpsToSell > currentPPSBalance) { // Cannot sellPPS in this condition
 			System.out.println("Sorry, but you cannot sell the number of PPS entered as "
 					+ "it is greater than your current PPS balance. You can either sell less than or equal to "+ currentPPSBalance);
 		}
 		else {// A seller/user can sellPPS in this condition (i.e. numberPpsToSell <= currentPPSBalance)
 			
 	 		//connect_func();

 			System.out.println("in the else");
 			// Firstly, we have to perform the deduction of the PPS to sell from the seller's account and 
 			// addition of the same into the rootuser's account.
 			String sqlSellerPPSBalanceChange = "update users set ppsBalance=? where email=? ;";
 			preparedStatement = (PreparedStatement) connect.prepareStatement(sqlSellerPPSBalanceChange);
 	 		preparedStatement.setDouble(1, currentPPSBalance-numberPpsToSell);
 	 		preparedStatement.setString(2, seller);
 	 		
 	 		preparedStatement.executeUpdate();
 	 		//preparedStatement.close();
 	 		
 	 		// Addition of the deducted number of PPS from the seller's account to the rootuser's ppsBalance :-
 	 		String sqlRootUserPPSAddition = "update rootuser set ppsBalance=? where email='root';";
 			preparedStatement = (PreparedStatement) connect.prepareStatement(sqlRootUserPPSAddition);
 			preparedStatement.setDouble(1, currentPPSBalanceRoot+numberPpsToSell);
 			
 			preparedStatement.executeUpdate();
 			//preparedStatement.close();
 			
 			
 			
 			// Addition of money in seller's account due to selling PPS :
 			String sqlAdditionMoneyToSeller = "update balanceOfMoney set balance_in_dollars=? where user_email=?;";
 			preparedStatement = (PreparedStatement) connect.prepareStatement(sqlAdditionMoneyToSeller);
 			preparedStatement.setDouble(1, currentBalanceOfMoney(seller) + (((double)numberPpsToSell)/1000000.0) );
 			preparedStatement.setString(2, seller);
 			
 			preparedStatement.executeUpdate();
 			//preparedStatement.close();
 			
 			
 		    // Reduction of money in seller's account due to selling PPS :
 			String sqlReductionMoneyRootuser = "update rootuser set balanceOfMoneyRoot=? where email='root';";
 			preparedStatement = (PreparedStatement) connect.prepareStatement(sqlReductionMoneyRootuser);
 			preparedStatement.setDouble(1, currentBalanceOfMoneyRoot() - (((double)numberPpsToSell)/1000000.0) );
 			
 			preparedStatement.executeUpdate();
 			//preparedStatement.close();
 			
 			
 			//Change in the price of pps :
 			String sqlRootUserPPSPriceChange = "update rootuser set ppsPrice=? where email='root';";
 			preparedStatement = (PreparedStatement) connect.prepareStatement(sqlRootUserPPSPriceChange);
 			preparedStatement.setDouble(1, currentPPSPrice()-1);
 			
 			preparedStatement.executeUpdate();
 			//preparedStatement.close();
 		
 		disconnect();	

 	 		
 		}	
 	}
  	
 	
 	
	public void buyPPSAmount(String buyer, double numberPpsToBuy) throws SQLException  {
	 	    
	 		// Connecting with the database :
	 		connect_func();
	 		double currentBalanceOfMoney = currentBalanceOfMoney(buyer);
	 		double currentPPSBalanceRoot = currentPPSBalanceRoot();
	 		double currentPPSPrice = currentPPSPrice();
	 		double currentBalanceOfPPS = currentPPSBalance(buyer);
	 		double currentBalanceOfMoneyRoot = currentBalanceOfMoneyRoot();
	 		
	 		System.out.println("in buy function");

	 		
	 		if(!( currentBalanceOfMoney < ((1/currentPPSPrice)*((double)numberPpsToBuy)))) { // Cannot sellPPS in this condition
	 				 			
	 			if(!(currentPPSBalanceRoot < numberPpsToBuy)) {
	 				
	 				System.out.println("in the else");
	 				//add ppsvalue to user
	 				String sqlBuyerPPSBalanceAddition = "update users set ppsBalance=? where email=? ;";
	 	 			preparedStatement = (PreparedStatement) connect.prepareStatement(sqlBuyerPPSBalanceAddition);
	 	 			System.out.println(currentBalanceOfPPS+numberPpsToBuy);
	 	 			preparedStatement.setDouble(1, currentBalanceOfPPS+numberPpsToBuy);
	 	 	 		preparedStatement.setString(2, buyer);
	 				preparedStatement.executeUpdate();
	 	 	 		
	 				//sub from root user
	 				String sqlRootUserPPSBalanceSubtraction = "update rootuser set ppsBalance=? where email='root' ;";
	 	 			preparedStatement = (PreparedStatement) connect.prepareStatement(sqlRootUserPPSBalanceSubtraction);
	 	 			System.out.println(currentPPSBalanceRoot-numberPpsToBuy);
	 	 			preparedStatement.setDouble(1, currentPPSBalanceRoot-numberPpsToBuy);
	 				preparedStatement.executeUpdate();
	 				
	 				//subtract balance from user
	 				String sqlBuyerBalanceSubtraction = "update balanceofmoney set balance_in_dollars=? where user_email=? ;";
	 	 			preparedStatement = (PreparedStatement) connect.prepareStatement(sqlBuyerBalanceSubtraction);
	 	 			System.out.println(currentBalanceOfMoney);
	 	 			System.out.println(((1/currentPPSPrice)*((double)numberPpsToBuy)));
	 	 			System.out.println(1/currentPPSPrice);
	 	 			preparedStatement.setDouble(1, currentBalanceOfMoney - ((1/currentPPSPrice)*((double)numberPpsToBuy)));
	 	 	 		preparedStatement.setString(2, buyer);
	 				preparedStatement.executeUpdate();
	 				
	 				//add balance to root
	 				String sqlRootUserBalanceAddition = "update rootuser set balanceOfMoneyRoot=? where email='root' ;";
	 	 			preparedStatement = (PreparedStatement) connect.prepareStatement(sqlRootUserBalanceAddition);
	 	 			System.out.println(currentBalanceOfMoneyRoot + ((1/currentPPSPrice)*((double)numberPpsToBuy)));
	 	 			preparedStatement.setDouble(1, currentBalanceOfMoneyRoot + ((1/currentPPSPrice)*((double)numberPpsToBuy)));
	 				preparedStatement.executeUpdate();
	 				
	 				//update pps price
	 				//Change in the price of pps :
	 	 			String sqlRootUserPPSPriceChange = "update rootuser set ppsPrice=? where email='root';";
	 	 			preparedStatement = (PreparedStatement) connect.prepareStatement(sqlRootUserPPSPriceChange);
	 	 			System.out.println(currentPPSPrice()+1);
	 	 			preparedStatement.setDouble(1, currentPPSPrice()+1);
	 	 			preparedStatement.executeUpdate();
	 				
	 			}
	 			else {
	 				System.out.println("in check");
 				System.out.println("Sorry, but you cannot buy the number of PPS entered as "
	 					+ "it is greater than the current global balance of PPS the root owns." 
	 					+ " You can either buy less than or equal to "+ currentPPSBalanceRoot);
	 			}
	 		}
	 		else
	 			System.out.println("Sorry, but you cannot buy the number of PPS entered as it is greater than your current balance of money. You can either buy less than or equal to "+ currentBalanceOfMoney);

	 			
	 			 		
	}
	 		
	public void transferPPSAmount(String sender, String receiver, double sentAmountPPS) throws SQLException  {
		
		connect_func();
		//check if user balanceofPPS < sentAMountpps
 		double currentBalanceOfPPS = currentPPSBalance(sender);
 		double currentBalanceOfPPSReceiver = currentPPSBalance(receiver);
 		
 		if(currentBalanceOfPPS < sentAmountPPS)
 			System.out.println("Sorry, but you cannot send the desired amount of PPS to this user, as your current balance of PPS is smaller than the transfer amount of: "+ sentAmountPPS);
 		else {
 			
 				String sqlSenderPPSSubtraction = "update users set ppsBalance=? where email=? ;";
	 			preparedStatement = (PreparedStatement) connect.prepareStatement(sqlSenderPPSSubtraction);
	 			preparedStatement.setDouble(1, currentBalanceOfPPS-sentAmountPPS);
	 	 		preparedStatement.setString(2, sender);
				preparedStatement.executeUpdate();
	 	 		
				String sqlRecieverPPSAddition = "update users set ppsBalance=? where email=? ;";
	 			preparedStatement = (PreparedStatement) connect.prepareStatement(sqlRecieverPPSAddition);
	 			preparedStatement.setDouble(1, currentBalanceOfPPSReceiver+sentAmountPPS);
	 	 		preparedStatement.setString(2, receiver);
				preparedStatement.executeUpdate();
				
			
 		}
 			

		
	}
  	
}

//todo: refactor peopleDAO to connect to DB and call all MYSQL statements