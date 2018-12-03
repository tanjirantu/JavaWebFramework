package models;

public class PersonFactory {
	
   //use getShape method to get object of type shape 
    public Person getPerson(String personType){
        if(personType == null){
            return null;
        }		
        if(personType.equalsIgnoreCase("FACULTY")){
            return new Faculty();

        } else if(personType.equalsIgnoreCase("STUDENT")){
            return new Student();

        }
        return null;
    }
}