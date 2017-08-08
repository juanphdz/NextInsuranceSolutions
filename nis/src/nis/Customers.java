package nis;

public class Customers extends Person{

	private String phoneNumber = null;
	private String addressStreet = null;
	private String addressCity = null;
	private String addressState = null;
	private String addressZip = null;
	
	public Customers(){
		super();
	}
		
	public Customers(String policyNumber, String firstName, String lastName, String dateOfBirth, String driverLicense, String phoneNumber, String addressStreet, String addressCity, String addressState, String addressZip){
		super(policyNumber, firstName, lastName, dateOfBirth, driverLicense);
		this.phoneNumber = phoneNumber;
		this.addressStreet = addressStreet;
		this.addressCity = addressCity;
		this.addressState = addressState;
		this.addressZip = addressZip;
	}
	
	public String getPhoneNumber(){
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
	}
	
	public String getAddressStreet(){
		return addressStreet;
	}
	
	public void setAddressStreet(String addressStreet){
		this.addressStreet = addressStreet;
	}
	
	public String getAddressCity(){
		return addressCity;
	}
	
	public void setAddressCity(String addressCity){
		this.addressCity = addressCity;
	}
	
	public String getAddressState(){
		return addressState;
	}
	
	public void setAddressState(String addressState){
		this.addressState = addressState;
	}
	
	public String getAddressZip(){
		return addressZip;
	}
	
	public void setAddressZip(String addressZip){
		this.addressZip = addressZip;
	}
}
