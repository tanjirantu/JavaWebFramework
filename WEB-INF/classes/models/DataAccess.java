package models;
import java.sql.*;  

public class DataAccess {

	private Connection con;

	public DataAccess() {
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","");
		} catch(Exception e) { 
			System.out.println(e);
		}
		
	}

	public ResultSet getQuery(String query) {
  		
  		try {
  			Statement stmt = con.createStatement();  
			ResultSet rs = stmt.executeQuery(query); 
			return rs;
  		} catch(Exception e) { 
			System.out.println(e);
		}
		return null;
	}

	public boolean updateQuery(String query) {
  		
  		try {
  			Statement stmt = con.createStatement();  
			stmt.executeUpdate(query); 
			return true;
  		} catch(Exception e) { 
			System.out.println(e);
		}
		return false;
	}

	public void closeConn() {

		try {
  			con.close();
  		} catch(Exception e) { 
			System.out.println(e);
		}
	}

}