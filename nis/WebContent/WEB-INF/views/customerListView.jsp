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

tr:nth-child(even){background-color: #f2f2f2}
</style>
</head>
<body>
	
	<jsp:include page="_menu.jsp"></jsp:include>
	
	<h3>Customer List</h3>
	
	<p style="color: red;">${errorString}</p>
<div style="overflow-x:auto;">
	<table>
		<tr>
			<th>Policy Number</th>
			<th>Name</th>
			<th>Birthday</th>
			<th>Driver License</th>
			<th>Phone Number</th>
			<th>Address</th>
			<th></th>
			<th></th>
		</tr>
		<c:forEach items="${customerList}" var="customer" >
			<tr>
				<td>${customer.policyNumber}</td>
				<td>${customer.firstName} ${customer.lastName}</td>
				<td>${customer.birthday }</td>
				<td>${customer.driverLicense }</td>
				<td>${customer.phoneNumber }</td>
				<td>${customer.addressStreet }, ${customer.addressCity }, ${customer.addressState } ${customer.addressZip }</td>
				<td>
					<a href="editCustomer?policyNumber=${customer.policyNumber}">Edit</a>
				<td>
					<a href="deleteCustomer?policyNumber=${customer.policyNumber}">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>
	<a href="createCustomer">Create Customer</a>
	
</body>
</html>