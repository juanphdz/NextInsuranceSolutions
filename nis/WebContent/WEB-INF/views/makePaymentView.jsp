<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"><html>
<head>
<style>
input[type=text], input[type=password], input[type=date], select {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}

input[type=submit] {
    width: 100%;
    background-color: #008CBA;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

input[type=submit]:hover {
    opacity: 0.8;
}

.backg {
    border-radius: 5px;
    background-color: #f2f2f2;
    padding: 20px;
    width: 40%;
}
</style>
<body>
	<jsp:include page="_menu.jsp"></jsp:include>
<div align="center">
<div class="backg">	
	<h3>Add Additional Driver</h3>
	<form method="POST" action="doMakePayment">
  		<p style="color: red;">${errorString}</p>

		<input type="hidden" name="policyNumber" value="${customer.policyNumber }" />
		
  		<label for="ttype">Transaction Type</label>
  		<select id="ttype" name="transactionType">
    	<option  value= "New Policy">New Policy</option>
        <option  value= "Monthly">Monthly</option>
        <option  value= "Endorsement">Endorsement</option>
        <option  value= "DMV Transfer">DMV Transfer</option>
        <option  value= "DMV Renewal">DMV Renewal</option>
        <option  value= "DMV Record">DMV Record</option>
  		</select>
  		
  		<label for="tamount">Payment amount</label>
    	<input type="text" id="tamount" placeholder="Payment amount" name="totalAmount" value = "${payment.totalAmount }" required />
  		
  		<label for="fid">Fiduciary amount</label>
    	<input type="text" id="fid" placeholder="Fiduciary amount" name="fid" value = "${payment.fid }" required />
  		
  		<label for="ptype">Payment Type</label>
  		<select id="ptye" name="paymentType">
    	<option  value= "Cash">Cash</option>
        <option  value= "Credit Card">Credit Card</option>
        <option  value= "Check">Check</option>
  		</select>
  		
  		<label for="receivedby">Received by:</label>
  		<select id="receivedby" name="agent">
    	<option  value= "${loggedInUser.fullName }">${loggedInUser.fullName }</option>
  		</select>
  		  		  		  		
  	    <input type="submit" value="Submit"><br>
  	    <div align="center">
    	<a href="customerProfile?policyNumber=${customer.policyNumber}">Cancel</a>
		</div>
</form>
</div>
</div>
</body>
</html>
