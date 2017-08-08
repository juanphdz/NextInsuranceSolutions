package nis;

public class Person {
	
	private String policyNumber = null;
	private String firstName = null;
	private String lastName = null;
	private String dateOfBirth = null;
	private String driverLicense = null;
	
	public Person(){
		
	}
	
	public Person(String policyNumber, String firstName, String lastName, String dateOfBirth, String driverLicense){
		this.policyNumber = policyNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.driverLicense = driverLicense;
	}
	
	public String getPolicyNumber(){
		return policyNumber;
	}
	
	public void setPolicyNumber(String policyNumber){
		this.policyNumber = policyNumber;
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	
	
	public String getDateOfBirth(){
		return dateOfBirth;
	}
	
	public void setDateOfBirth(String dateOfBirth){
		this.dateOfBirth = dateOfBirth;
	}
	
	
	public String getDriverLicense(){
		return driverLicense;
	}
	
	public void setDriverLicense(String driverLicense){
		this.driverLicense = driverLicense;
	}
}
