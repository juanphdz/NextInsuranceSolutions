package nis;

public class Payments {

	private String paymentId = null;
	private String policyNumber = null;
	private double fid = 0;
	private double brokerFee = 0;
	private double totalAmount = 0;
	private String paymentDate = null;
	private String paymentType = null;
	private String transactionType = null;
	private String paymentStatus = null;
	private String agent = null;
	
	public Payments(){
		
	}
	
	public Payments(String policyNumber, double fid, double brokerFee, double totalAmount, String paymentDate, String paymentType, String transactionType, String paymentStatus, String agent){
		this.policyNumber = policyNumber;
		this.fid = fid;
		this.brokerFee = brokerFee;
		this.totalAmount = totalAmount;
		this.paymentDate = paymentDate;
		this.paymentType = paymentType;
		this.transactionType = transactionType;
		this.paymentStatus = paymentStatus;
		this.agent  = agent;
	}
	
	
	public String getPaymentId(){
		return paymentId;
	}
	
	public void setPaymentId(String paymentId){
		this.paymentId = paymentId;
	}
	
	public String getPolicyNumber(){
		return policyNumber;
	}
	
	public void setPolicyNumber(String policyNumber){
		this.policyNumber = policyNumber;
	}
	
	public double getFid(){
		return fid;
	}
	
	public void setFid(double fid){
		this.fid = fid;
	}
	
	public double getBrokerFee(){
		return brokerFee;
	}
	
	public void setBrokerFee(double brokerFee){
		this.brokerFee = brokerFee;
	}
	
	public double getTotalAmount(){
		return totalAmount;
	}
	
	public void setTotalAmount(double totalAmount){
		this.totalAmount = totalAmount;
	}
	
	public String getPaymentDate(){
		return paymentDate;
	}
	
	public void setPaymentDate(String paymentDate){
		this.paymentDate = paymentDate;
	}
	
	public String getPaymentType(){
		return paymentType;
	}
	
	public void setPaymentType(String paymentType){
		this.paymentType = paymentType;
	}
	
	public String getTransactionType(){
		return transactionType;
	}
	
	public void setTransactionType(String transactionType){
		this.transactionType = transactionType;
	}
	
	public String getPaymentStatus(){
		return paymentStatus;
	}
	
	
	public void setPaymentStatus(String paymentStatus){
		this.paymentStatus = paymentStatus;
	}
	
	public String getAgent(){
		return agent;
	}
	
	public void setAgent(String agent){
		this.agent = agent;
	}
	
	
}
