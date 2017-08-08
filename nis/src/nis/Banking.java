package nis;

public class Banking extends Payments{
	private String firstName = null;
	private String lastName = null;
	
	public Banking(){
		super();
	}
	
	public Banking(String policyNumber, double fid, double brokerFee, double totalAmount, String paymentDate, String paymentType, String transactionType, String paymentStatus, String agent, String firstName, String lastName){
		super(policyNumber, fid, brokerFee, totalAmount, paymentDate, paymentType, transactionType, paymentStatus, agent);
		this.firstName = firstName;
		this.lastName = lastName;
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
}
