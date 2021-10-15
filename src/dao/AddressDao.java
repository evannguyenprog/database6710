package dao;

import model.Login;
import model.Users;
import controller.UsersServlet;

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


// Importing the Address class from model package
// to perform various operations for the Address table :
import model.Address;

@WebServlet("/AddressDao")

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
            int user_id = resultSet.getInt("user_id");
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
    	String sql = "insert into  address (street, city, state, zipcode) values (?, ?, ?, ?)";
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
		preparedStatement.setString(1, address.getStreet());
		preparedStatement.setString(2, address.getCity());
		preparedStatement.setString(3, address.getState());
		preparedStatement.setInt(4, address.getZipcode());
	

		preparedStatement.executeUpdate();
        preparedStatement.close();
        disconnect();
    }
    
    public void createTable() throws SQLException {
 		try {
 			connect_func();
 			String s = "CREATE TABLE Address (" +
 					"user_id INT NOT NULL," +
 					"street VARCHAR(100) NOT NULL," +
 					"city CHAR(20) NOT NULL," +
 					"state CHAR(20) NOT NULL," +
 					"zipcode INT NOT NULL," +
 					"PRIMARY KEY(user_id)," +
 					"FOREIGN_KEY(user_id) REFERRENCES Users(id);";
 			//todo: add an insert statement below. 
 			// The insertion in 'Address' table has a foreign key attribute of 
 			// user_id referring to users(id). 
   
 			
 			
 		} catch (Exception e) {
 			System.out.println(e);
 		} finally {
 			statement.close(); 
 		}
 	}
	    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
