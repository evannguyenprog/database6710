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


// Importing the Users class from model package
// to perform various operations for the Users table :
import model.Users;



@WebServlet("/UsersDao")

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
            int id = resultSet.getInt("id");
            String email = resultSet.getString("email");
            String firstName = resultSet.getString("firstName");
            String lastName = resultSet.getString("lastName");
            String birthday = resultSet.getString("birthday");
            double ppsBalance = resultSet.getDouble("ppsBalance");
            double dollarBalance = resultSet.getDouble("dollarBalance");
             
            Users users = new Users(id, email, firstName, lastName, birthday, ppsBalance, dollarBalance);
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
    	String sql = "insert into  user (email, firstName, lastName, birthday,  ppsBalance, dollarBalance) values (?, ?, ?, ?, ?, ?)";
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
		preparedStatement.setString(1, user.getEmail());
		preparedStatement.setString(2, user.getFirstName());
		preparedStatement.setString(3, user.getLastName());
		preparedStatement.setString(4, user.getBirthday());
		preparedStatement.setDouble(5, user.getPpsBalance());
		preparedStatement.setDouble(6, user.getDollarBalance());

		preparedStatement.executeUpdate();
        preparedStatement.close();
        disconnect();
    }
    
    // create users table
 	public void createTable() throws SQLException {
 		try {
 			connect_func();
 			String s = "CREATE TABLE Users (" +
 					"id INT NOT NULL AUTO_INCREMENT," +
 					"email VARCHAR(30) NOT NULL," +
 					"firstName VARCHAR(20) NOT NULL," +
 					"lastName VARCHAR(20) NOT NULL," +
 					// changed the birthday datatype to 'DATE'
 					"birthday DATE NOT NULL," +
 					// removed Address attribute here. 
 					"ppsBalance DOUBLE(10,2)," +
 					"dollarBalance DOUBLE(10,2)," +
 					"PRIMARY KEY(id)," +
 					"UNIQUE(email);";
 			//todo: add more users here
 			//might have to change how address is stored
 			// Removed the address attribute and its values in then below INSERT statement of 'Users' table.
 			// 
 			String s2 = "INSERT INTO Users(email, firstName, lastName, birthday, ppsBalance, dollarBalance) VALUES" +
 					"('root@admin.com', 'Root', 'Man', NOW(), '100000000.00', '0.00'), " +
 					"('evan@gmail.com', 'Evan', 'Nguyen', NOW(),  '0.00', '0.00')," +
 					"('smit@gmail.com', 'Smit', 'Patel', NOW(),  '0.00', '0.00'),"+
 					"('john@gmail.com', 'John', 'Holdings', NOW(),  '0.00', '0.00'),"+
 					"('mihir@gmail.com', 'Mihir', 'Patel', NOW(),  '0.00', '0.00'),"+
 					"('varun@gmail.com', 'Varun', 'Sharma', NOW(),  '0.00', '0.00'),"+
 					"('Tej@gmail.com', 'Tej', 'Singh', NOW(),  '0.00', '0.00'),"+
 					"('mike@gmail.com', 'Mike', 'Hussey', NOW(),  '0.00', '0.00'),"+
 					"('tenisee@gmail.com', 'Tenise', 'McCullum', NOW(),  '0.00', '0.00'),"+
 					"('Ghanu@gmail.com', 'Ghanshyam', 'Mahaprabhu', NOW(),  '0.00', '0.00'),"+
 					"('trott@gmail.com', 'Jonathan', 'Trott', NOW(),  '0.00', '0.00');";
 
 			statement.executeUpdate(s);
 			System.out.println("'Users' table created.");
 			statement.executeUpdate(s2);
 			System.out.println("2 users added.");
 			
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

	//need to implement password functionality and store password before we can log in users and authenticate sessions
  	//==== W I P ====
  	public boolean isUserValid(String email, String password) throws SQLException {
		boolean check = false;
		return check;
	}
  	
  	//add future functions below here
  	
  	
}

//todo: refactor peopleDAO to connect to DB and call all MYSQL statements