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
	
	
	<h3>Policy Search</h3>
<div align="center">
<div class="backg">
	<form method="POST" action="doPolicySearch">
  		<p style="color: red;">${errorString}</p>
  		<label for="pnumber">Search by: Policy number or last name</label>
    	<input type="text" id="pnumber" placeholder="Policy Number or Last name" name="findPolicy" value="${customer.policyNumber}" required />

  	    <input type="submit" value="Search"><br>
</form>
</div>
</div>
</body>
</html>
