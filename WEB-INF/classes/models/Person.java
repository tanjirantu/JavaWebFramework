package models;

public interface Person {

    boolean login(String organizationalId, String password);
    void register(String organizationalId, String firstName, String lastName, String email, String address, String phoneNo, String password);
    void setOrganizationalId(String id);  
    void setName(String name);
    void setLastName(String lastName);
    void setEmail(String email);
    void setHomeAdd(String homeAdd);
    void setPhoneNo(String phoneNo);
    void setPassword(String password);
    String getOrganizationalId();
    String getFirstName();
    String getLastName();
	String getEmail();
	String getHomeAdd();
	String getPhoneNo();
	String getPassword();
}