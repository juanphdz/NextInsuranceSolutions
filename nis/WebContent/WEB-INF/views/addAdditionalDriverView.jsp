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
	<h3>Add Additional Driver</h3>
	<form method="POST" action="doAddAdditionalDriver">
  		<p style="color: red;">${errorString}</p>

		<input type="hidden" name="policyNumber" value="${customer.policyNumber }" />
  		<label for="fname">First Name</label>
    	<input type="text" id="fname" placeholder="First Name" name="firstName" value = "${addDriver.firstName }" required />
  		
  		<label for="lname">Last Name</label>
    	<input type="text" id="lname" placeholder="Last Name" name="lastName" value = "${addDriver.lastName }" required />
  		
  		<label for="bday">Date of Birth</label>
    	<input type="date" id="bday" placeholder="YYYY-MM-DD" name="dateOfBirth" value = "${addDriver.dateOfBirth }" />
  		
  		<label for="dl">Driver License</label>
    	<input type="text" id="dl" placeholder="Driver License" name="driverLicense" value = "${addDriver.driverLicense }"/>
  		
  		<label for="status">Driver Status</label>
  		<select id="status" name="driverStatus">
    	<option  value= "Insured">Insured</option>
        <option  value= "Excluded">Excluded</option>
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
