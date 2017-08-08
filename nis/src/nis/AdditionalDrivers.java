package nis;

public class AdditionalDrivers extends Person{
	
	private String addDriverId = null;
	private String driverStatus = null;

	public AdditionalDrivers(){
		super();
	}
	
	public AdditionalDrivers(String policyNumber, String firstName, String lastName, String dateOfBirth, String driverLicense, String driverStatus){
		super(policyNumber, firstName, lastName, dateOfBirth, driverLicense);
		this.driverStatus = driverStatus;
	}
	
	public String getAddDriverId(){
		return addDriverId;
	}
	
	public void setAddDriverId(String addDriverId){
		this.addDriverId = addDriverId;
	}
	
	public String getDriverStatus(){
		return driverStatus;
	}
	
	public void setDriverStatus(String driverStatus){
		this.driverStatus = driverStatus;
	}
}
