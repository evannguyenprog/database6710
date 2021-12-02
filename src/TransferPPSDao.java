


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


@WebServlet("/TransferPPSDao")

public class TransferPPSDao {
	
	
	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	// Constructor :
	public TransferPPSDao() {
		
	}
	
	
	// Methods of the class : TransferPPSDao
	
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
	
	 
	// Function "listAllTransferPPS()" is for printing all the rows/records
	    // of 'TransferPPS' table(i.e TransferPPS model/class in Java terminology.)
	    public List<TransferPPS> listAllTransferPPS() throws SQLException {
	        List<TransferPPS> listTransferPPS = new ArrayList<TransferPPS>();  
	        // A string 'sql' storing a sql query. 
	        String sql = "SELECT * FROM TransferPPS"; 
	        // connecting with the database.
	        connect_func();      
	        statement =  (Statement) connect.createStatement();
	        // executing the 'sql' query :
	        ResultSet resultSet = statement.executeQuery(sql);
	         
	        while (resultSet.next()) {
	           
	            int id = resultSet.getInt("id");
	            String transfering_user_email = resultSet.getString("transfering_user_email");
	            String receiving_user_email = resultSet.getString("receiving_user_email");
	            String transfer_date = resultSet.getString("transfer_date");
	            int number_pps_transfered = resultSet.getInt("number_pps_transfered");
	      
	            
	             
	        
				TransferPPS transferPPS = new TransferPPS(id, transfering_user_email, receiving_user_email, transfer_date, number_pps_transfered);
	            listTransferPPS.add(transferPPS);
	        }        
	        resultSet.close();
	        statement.close();         
	        disconnect();        
	        return listTransferPPS;
	    }
	    
	    
		// Function "listAllTransferPPS()" is for printing all the rows/records
	    // of 'TransferPPS' table(i.e TransferPPS model/class in Java terminology.)
	    public List<TransferPPS> listAllTransferPPSByUser(String current_email) throws SQLException {
	        List<TransferPPS> listTransferPPS = new ArrayList<TransferPPS>();  
	        // A string 'sql' storing a sql query. 
	        String sql = "SELECT * FROM TransferPPS WHERE transfering_user_email='"+ current_email +"';"; 
	        // connecting with the database.
	        connect_func();      
	        statement =  (Statement) connect.createStatement();
	        // executing the 'sql' query :
	        ResultSet resultSet = statement.executeQuery(sql);
	         
	        while (resultSet.next()) {
	           
	            int id = resultSet.getInt("id");
	            String transfering_user_email = resultSet.getString("transfering_user_email");
	            String receiving_user_email = resultSet.getString("receiving_user_email");
	            String transfer_date = resultSet.getString("transfer_date");
	            int number_pps_transfered = resultSet.getInt("number_pps_transfered");
	      
	            
				TransferPPS transferPPS = new TransferPPS(id, transfering_user_email, receiving_user_email, transfer_date, number_pps_transfered);
	            listTransferPPS.add(transferPPS);
	        }        
	        resultSet.close();
	        statement.close();         
	        return listTransferPPS;
	    }
	    
	    
	  //Function 'insert' below is to insert a row/record in the 'Users'
	    // table of the PPS database in mysql.
	    public void insert(TransferPPS transferPPS) throws SQLException {
	    	connect_func();
	    	String sql = "insert into  transferPPS(transfering_user_email, receiving_user_email, transfer_date, number_pps_transfered) values (?, ?, ?, ?)";
			preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
			preparedStatement.setString(1, transferPPS.getTransfering_user_email());
			preparedStatement.setString(2, transferPPS.getReceiving_user_email());
			preparedStatement.setString(3, transferPPS.getTransfer_date());
			preparedStatement.setInt(4, transferPPS.getNumber_pps_transfered());
			
			

			preparedStatement.executeUpdate();
	        preparedStatement.close();
	        disconnect();
	    }
	    
	    
	    public void createTable() throws SQLException {
	 		try {
	 			connect_func();
	 			String s = "CREATE TABLE TransferPPS(\r\n"
	 					+ "    id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,\r\n"
	 					+ "    transfering_user_email VARCHAR(20),\r\n"
	 					+ "    receiving_user_email VARCHAR(20),\r\n"
	 					+ "    transfer_date VARCHAR(10),\r\n"
	 					+ "    number_pps_transfered INTEGER,\r\n"
	 					+ "    FOREIGN KEY(transfering_user_email) REFERENCES Users(email),\r\n"  //this will cause an error, need the 2 emails differentiated somehow
	 				//	+ "    FOREIGN KEY(receiving_user_email) REFERENCES Users(email)\r\n"
	 					+ "    FOREIGN KEY(receiving_user_email) REFERENCES Users(email)\r\n"
	 					+ ");";
	 			//todo: add more users here
	 			//might have to change how address is stored
	 			// Removed the address attribute and its values in then below INSERT statement of 'Users' table.
	 			// 
	 		//	String s2 = " INSERT INTO TransferPPS(transfering_user_email, receiving_user_email, transfer_date, number_pps_transfered) VALUES\r\n"
	 		//			+ "	 					('evan@gmail.com', 'smit@gmail.com', '09/01/2021',  '0.00'),\r\n"
	 		//			+ "	 					('smit@gmail.com', 'john@gmail.com', '09/10/2021',  '0.00'),\r\n"
	 		//			+ "	 					('john@gmail.com', 'mihir@yahoo.com', '09/12/2021',  '0.00'),\r\n"
	 		//			+ "	 					('mihir@yahoo.com', 'varun@gmail.com','09/19/2021',  '0.00'),\r\n"
	 		//			+ "	 					('varun@gmail.com', 'Tej@aol.com','09/18/2021',  '0.00'),\r\n"
	 		//			+ "	 					('Tej@aol.com', 'mike@gmail.com','09/07/2021',  '0.00'),\r\n"
	 		//			+ "	 					('mike@gmail.com', 'tenisee@yahoo.com', '09/12/2021',  '0.00'),\r\n"
	 		//			+ "	 					('tenisee@yahoo.com', 'Ghanu@gmail.com','09/12/2021',  '0.00'),\r\n"
	 		//			+ "	 					('Ghanu@gmail.com', 'trott@hotmail.com','09/12/2021',  '0.00'),\r\n"
	 		//			+ "	 					('trott@hotmail.com', 'evan@gmail.com', '10/12/2021',  '0.00');";
	 
	 			statement.executeUpdate(s);
	 			System.out.println("'TransferPPS' table created.");
	 		//	statement.executeUpdate(s2);
	 			System.out.println("Multiple TrasnferPPS rows added.");
	 			
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
	 		statement.executeUpdate("DROP TABLE IF EXISTS TransferPPS");
	 		statement.executeUpdate("SET FOREIGN_KEY_CHECKS = 1");
	  	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
