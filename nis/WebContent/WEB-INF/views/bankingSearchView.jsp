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
	<h3>Search Banking by Date</h3>
	<form method="POST" action="doBanking">
  		<p style="color: red;">${errorString}</p>

  		<label for="sdate">Start Date</label>
    	<input type="date" id="sdate" placeholder="YYYY-MM-DD" name="startDate" value = "${payment.startDate }" required/>
  		
  		<label for="edate">End Date</label>
    	<input type="date" id="edate" placeholder="YYYY-MM-DD" name="endDate" value = "${payment.endDate }" required/>
  		  		  		  		
  	    <input type="submit" value="Submit"><br>
  	    <div align="center">
    	<a href="main">Cancel</a>
		</div>
</form>
</div>
</div>
</body>
</html>
