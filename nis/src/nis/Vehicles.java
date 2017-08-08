package nis;

public class Vehicles {
	
	private String vehicleId = null;
	private String vehicleYear = null;
	private String vehicleMake = null;
	private String vehicleModel = null;
	private String vehicleVin  = null;
	private String policyNumber = null;
	
	public Vehicles(){
		
	}
	
	public Vehicles(String vehicleYear, String vehicleMake, String vehicleModel, String vehicleVin, String policyNumber){
		this.vehicleYear = vehicleYear;
		this.vehicleMake = vehicleMake;
		this.vehicleModel = vehicleModel;
		this.vehicleVin = vehicleVin;
		this.policyNumber = policyNumber;
	}
	
	public String getVehicleId(){
		return vehicleId;
	}
	
	public void setVehicleId(String vehicleId){
		this.vehicleId = vehicleId;
	}
	
	public String getVehicleYear(){
		return vehicleYear;
	}
	
	public void setVehicleYear(String vehicleYear){
		this.vehicleYear = vehicleYear;
	}
	
	public String getVehicleMake(){
		return vehicleMake;
	}
	
	public void setVehicleMake(String vehicleMake){
		this.vehicleMake = vehicleMake;
	}
	
	public String getVehicleModel(){
		return vehicleModel; 
	}
	
	public void setVehicleModel(String vehicleModel){
		this.vehicleModel = vehicleModel;
	}
	
	public String getVehicleVin(){
		return vehicleVin;
	}
	
	public void setVehicleVin(String vehicleVin){
		this.vehicleVin = vehicleVin;
	}
	
	public String getPolicyNumber(){
		return policyNumber;
	}
	
	public void setPolicyNumber(String policyNumber){
		this.policyNumber = policyNumber;
	}
}
