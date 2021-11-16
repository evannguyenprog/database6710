


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

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/AddressDao")

public class AddressDao {
	
	
	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
    
	
	public AddressDao() {
		
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
    public List<Address> listAllAddress() throws SQLException {
        List<Address> listAddress = new ArrayList<Address>();  
        // A string 'sql' storing a sql query. 
        String sql = "SELECT * FROM Address"; 
        // connecting with the database.
        connect_func();      
        statement =  (Statement) connect.createStatement();
        // executing the 'sql' query :
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            String user_id = resultSet.getString("user_email");
            String street = resultSet.getString("street");
            String city = resultSet.getString("city");
            String state = resultSet.getString("state");
            int zipcode = resultSet.getInt("zipcode");
             
			Address address = new Address(user_id, street, city, state, zipcode);
            listAddress.add(address);
        }        
        resultSet.close();
        statement.close();         
        disconnect();        
        return listAddress;
    }
	
    
    
    public void insert(Address address) throws SQLException {
    	
    	connect_func();
    	// Preparing the sql statement to insert into 'Address' table.
    	String sql = "insert into  Address (user_email, street, city, state, zipcode) values (?, ?, ?, ?, ?)";
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
		preparedStatement.setString(1, address.getUser_email());
		preparedStatement.setString(2, address.getStreet());
		preparedStatement.setString(3, address.getCity());
		preparedStatement.setString(4, address.getState());
		preparedStatement.setInt(5, address.getZipcode());
	

		preparedStatement.executeUpdate();
        preparedStatement.close();
        disconnect();
    }
    
    public void createTable() throws SQLException {
 		try {
 			connect_func();
 			String s = "CREATE TABLE Address (" +
 					"user_email VARCHAR(100) NOT NULL," +
 					"street VARCHAR(100) NOT NULL," +
 					"city CHAR(20) NOT NULL," +
 					"state CHAR(10) NOT NULL," +
 					"zipcode INT NOT NULL," +
 					"PRIMARY KEY(user_email)," +
 					"FOREIGN KEY(user_email) REFERENCES Users(email));";
 					
				

 			//ToDo: add an insert statement below. 
 			// The insertion in 'Address' table has a foreign key attribute of 
 			// user_id referring to users(id). 
 			
 			
 			String s2 = "INSERT INTO Address(user_email, street, city, state, zipcode) VALUES\r\n"
 					+ "('evan@gmail.com', '567 Brooke Street', 'Akshardham', 'AK', 56565), \r\n"
 					+ "('smit@gmail.com', '899 Akshar Street', 'Saginaw', 'MI', 48189), \r\n"
 					+ "('john@gmail.com', '899 Random Street', 'Saginaw', 'MI', 48189), \r\n"
 					+ "('mihir@yahoo.com', '1 Aksharadhipati', 'Saginaw', 'MI', 48189),\r\n"
 					+ "('varun@gmail.com', '2424 Canterburry Circle', 'Canton', 'MI', 48185), \r\n"
 					+ "('Tej@aol.com', '5656 Canterburry Circle', 'Jersey', 'NJ', 48190),\r\n"
 					+ "('mike@gmail.com', '8989 Canterburry Circle', 'Mt. Laurel', 'NJ', 48196),\r\n"
 					+ "('tenisee@yahoo.com', '8909 Philips St.', 'Mt. Laurel', 'NJ', 48196),\r\n"
 					+ "('Ghanu@gmail.com', 'Akshardham Sihasan', 'Akshardham', 'PN', 11111),\r\n"
 					+ "('trott@hotmail.com', '89 Philips St.', 'Mt. City', 'NJ', 48156);";
 			
 			statement.executeUpdate(s);
 		    System.out.println("The Address table is created.");
 		    statement.execute(s2);
 		    System.out.println("The Addresses of all the Users are added.");
 			
 			
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
  		statement.executeUpdate("DROP TABLE IF EXISTS Address");
  		statement.executeUpdate("SET FOREIGN_KEY_CHECKS = 1");
   	}
	    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
