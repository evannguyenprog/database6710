

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class BalanceOfMoneyDao {
	
	
	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
    
	
	public BalanceOfMoneyDao() {
		
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
	
	
	
	// Function "listAllAddress()" is for printing all the rows/records
    // of 'Users' table(i.e User model/class in Java terminology.)
    public List<BalanceOfMoney> listAllBalanceOfMoney() throws SQLException {
        List<BalanceOfMoney> listBalanceOfMoney = new ArrayList<BalanceOfMoney>();  
        // A string 'sql' storing a sql query. 
        String sql = "SELECT * FROM BalanceOfMoney"; 
        // connecting with the database.
        connect_func();      
        statement =  (Statement) connect.createStatement();
        // executing the 'sql' query :
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            String user_email = resultSet.getString("user_email");
            Double balance_in_dollars = resultSet.getDouble("balance_in_dollars");
          
            BalanceOfMoney balance_of_money = new BalanceOfMoney(user_email, balance_in_dollars);
            listBalanceOfMoney.add(balance_of_money);
        }        
        resultSet.close();
        statement.close();         
        disconnect();        
        return listBalanceOfMoney;
    }
	
    
    
    public void insert(BalanceOfMoney balance_of_money) throws SQLException {
    	
    	connect_func();
    	String sql = "INSERT INTO  BalanceOfMoney(user_email, balance_in_dollars) values (?, ?)";
    	
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
		
		preparedStatement.setString(1, balance_of_money.getUser_email());
		preparedStatement.setDouble(2, balance_of_money.getBalance_in_dollars());

		preparedStatement.executeUpdate();
        preparedStatement.close();
        
        disconnect();
    }
    
 
    
    public void depositAmount(double depositAmount, String user_email) throws SQLException {
    	connect_func();
    	
    	String sql1 = "UPDATE BalanceOfMoney SET balance_in_dollars = balance_in_dollars+? WHERE user_email = ?;";
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql1);
		preparedStatement.setDouble(1, depositAmount);
		preparedStatement.setString(2, user_email);
		preparedStatement.executeUpdate();
        preparedStatement.close();
        disconnect();
    }
    
    
//    public void withdrawAmount(double withdrawAmount, String user_email) throws SQLException {
//  
//    	// First of all checking if the withdrawal amount is less than the balance, the user possesses :
//    	
//    	double existingBalance = existingBalance(user_email);
//    	
//    	if(existingBalance >= withdrawAmount) { // Withdrawal is possible
//    		
//    		connect_func();
//    		
//    		System.out.println("Withdrawal Started!!");
//    		
//    		String sql = "UPDATE BalanceOfMoney SET balance_in_dollars = ? WHERE user_email = ?;";
//    		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
//    		preparedStatement.setDouble(1, existingBalance - withdrawAmount);
//    		preparedStatement.setString(2, user_email);
//
//    		preparedStatement.executeUpdate();
//            preparedStatement.close();
//            disconnect();
//    		
//    		System.out.println("Withdrawal Done!!");
//    	}
//    	else { // Withdrawal is not possible
//    		System.out.println("Sorry, the amount of withdrawal is exceeding the existing balance. "
//    				+ "You can only withdraw less than or equal to $"+ existingBalance);
//    	}
//    }
//    
//    
    

    
    public void createTable() throws SQLException {
 		try {
 			connect_func();
 			
 			// CREATE TABLE BalanceOfMoney statement below :
 			String s = "CREATE TABLE BalanceOfMoney(\r\n"
 					+ "    user_email VARCHAR(20) NOT NULL PRIMARY KEY, \r\n"
 					+ "    balance_in_dollars DOUBLE,\r\n"
 					+ "    FOREIGN KEY(user_email) REFERENCES Users(email));";
 			
 			
 			
 			// 
 			String s2 = "INSERT INTO BalanceOfMoney(user_email, balance_in_dollars) \r\n"
 					+ "             VALUES('evan@gmail.com', 0),\r\n"
 					+ " 					('smit@gmail.com', 0),\r\n"
 					+ " 					('john@gmail.com', 0),\r\n"
 					+ " 					('mihir@gmail.com', 0),\r\n"
 					+ " 					('varun@gmail.com', 0),\r\n"
 					+ " 					('Tej@gmail.com', 0),\r\n"
 					+ " 					('mike@gmail.com', 0),\r\n"
 					+ " 					('tenisee@gmail.com', 0),\r\n"
 					+ " 					('Ghanu@gmail.com', 0),\r\n"
 					+ " 					('trott@gmail.com', 0);";
 			
 			statement.executeUpdate(s);
 		    System.out.println("The BalanceOfMoney table is created.");
 		    statement.executeUpdate(s2);
 		    System.out.println("The Rows in the table of BalanceOfMoney are filled.");
 			
 			
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
  		statement.executeUpdate("DROP TABLE IF EXISTS BalanceOfMoney");
  		statement.executeUpdate("SET FOREIGN_KEY_CHECKS = 1");
   	}

    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

}
