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
    width: 30%;
}
</style>
<body>
	<jsp:include page="_menu.jsp"></jsp:include>
	
	<div align="center">
	<div class="backg">
	<h3>Create customer</h3>

	<form method="POST" action="doCreateCustomer">
  		<p style="color: red;">${errorString}</p>
  		<label for="pnumber">Policy Number</label>
    	<input type="text" id="pnumber" placeholder="Policy Number" name="policyNumber" value="${customer.policyNumber}" required />

  		<label for="fname">First Name</label>
    	<input type="text" id="fname" placeholder="First Name" name="firstName" value = "${customer.firstName }" required />
  		
  		<label for="lname">Last Name</label>
    	<input type="text" id="lname" placeholder="Last Name" name="lastName" value = "${customer.lastName }" required />
  		
  		<label for="bday">Date of Birth</label>
    	<input type="date" id="bday" placeholder="YYYY-MM-DD" name="dateOfBirth" value = "${customer.dateOfBirth }" required/>
  		
  		<label for="dl">Driver License</label>
    	<input type="text" id="dl" placeholder="Driver License" name="driverLicense" value = "${customer.driverLicense }"/>
  		
  		<label for="phone">Phone Number</label>
    	<input type="text" id="phone" placeholder="555-555-5555" name="phoneNumber" value = "${customer.phoneNumber }"/>
  		  		
  		<label for="street">Street</label>
    	<input type="text" id="street" placeholder="Street" name="addressStreet" value = "${customer.addressStreet }"/>
  		  		  		
  		<label for="city">City</label>
    	<input type="text" id="city" placeholder="City" name="addressCity" value = "${customer.addressCity }"/>
		  		
  		<label for="state">State</label>
  		<select id="state" name="addressState">
    	<option  value= "CA">California</option>
  		</select>
  		  		  		  		
  		<label for="zip">ZipCode</label>
    	<input type="text" id="zip" placeholder="ZipCode" name="addressZip" value = "${customer.addressZip }"/>
		  	
  	    <input type="submit" value="Submit"><br>
  	    <div align="center">
    	<a href = "main">Cancel</a>
		</div>
</form>
</div>
</div>
</body>
</html>
