package models;
import java.sql.*;  
public class Student implements Person {

	public String organizationalId;
	public String firstName;
	public String lastName;
	public String email;
	public String homeAdd;
	public String phoneNo;
	public String password;

    @Override
    public boolean login(String organizationalId, String password) {

        DataAccess da = new DataAccess();	
 		ResultSet rs = da.getQuery("select * from employees where organizational_id = '"+ organizationalId +"' and password = '"+ password +"' ");

 		try {
 			while(rs.next()) {
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
				if (rs.getString(2).equals(organizationalId) && rs.getString(8).equals(password)) {
					return true; 
				}
 			}
			da.closeConn();
 		} catch(Exception e) { 
			System.out.println(e);
		}
		return false;
    }

    public void setOrganizationalId(String id) {
    	this.organizationalId = id;
    }

    public String getOrganizationalId() {
    	return this.organizationalId;
    }

    public void register(String organizationalId, String firstName, String lastName, String email, String address, String phoneNo, String password) {
   //  	DataAccess da = new DataAccess();	
 		// da.getQuery("insert into employees values('firstName', 'lastName', 'email')");	
    }

    public void setName(String firstName) {
    	this.firstName = firstName;
    }

    public String getFirstName() { 		
    	return firstName;
    }

    public void setLastName(String lastName) {
    	this.lastName = lastName;
    }

    public String getLastName() { 		
    	return this.lastName;
    }

    public void setEmail(String email) {
    	this.email = email;
    }

    public String getEmail() {
    	return this.email;
    }

    public void setHomeAdd(String add) {
    	this.homeAdd = add;
    }

    public String getHomeAdd() {
    	return this.homeAdd;
    }
    public void setPhoneNo(String phoneNo) {
    	this.phoneNo = phoneNo;
    }

    public String getPhoneNo() {
    	return this.phoneNo;
    }

    public void setPassword(String password) {
    	this.password = password;
    }

    public String getPassword() {
    	return this.password;
    }
}