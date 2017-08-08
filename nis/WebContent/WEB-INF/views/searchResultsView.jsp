<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset=UTF-8">
<title>Customer List</title>
<style>
table {
    border-collapse: collapse;
    border-spacing: 0;
    width: 100%;
    border: 1px solid #ddd;
}

th, td {
    border: none;
    text-align: left;
    padding: 8px;
}

.backg {
    border-radius: 5px;
    padding: 20px;
    width: 60%;
}

tr:nth-child(even){background-color: #f2f2f2}
</style>
</head>
<body>
	
	<jsp:include page="_menu.jsp"></jsp:include>
	
	<h3>Search results</h3>
	
	<p style="color: red;">${errorString}</p>
<div align="center">
<div class="backg">
<div style="overflow-x:auto;">
	<table>
		<tr>
			<th>Policy Number</th>
			<th>Name</th>
			<th>Date of Birth</th>
			<th>Phone Number</th>
		</tr>
		<c:forEach items="${customerList}" var="customer" >
			<tr>
				<td>
				<a href="customerProfile?policyNumber=${customer.policyNumber}">${customer.policyNumber}</a>
				</td>
				<td>${customer.lastName}, ${customer.firstName}</td>
				<td>${customer.dateOfBirth }</td>
				<td>${customer.phoneNumber }</td>
			</tr>
		</c:forEach>
	</table>
</div>
</div>
</div>
	
</body>
</html>