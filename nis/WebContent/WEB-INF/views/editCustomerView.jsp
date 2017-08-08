<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Customer Name</title>
</head>
<body>
	
	<jsp:include page="_menu.jsp"></jsp:include>
	<jsp:include page="_header.jsp"></jsp:include>
	
	<h3>Edit Customer Name</h3>
	
	<p style="color: red;">${errorString}</p>
	
	<c:if test="${not empty customer}">
		<form method="POST" action="doEditCustomer">
			<input type="hidden" name="policyNumber" value="${customer.policyNumber }" />
			<table border="0">
				<tr>
					<td>Policy Number</td>
					<td style="color:red;">${customer.policyNumber }</td>
				</tr>
				<tr>
					<td>First name</td>
					<td><input type="text" name="firstName" value="${customer.firstName}" /></td>
				</tr>
				<tr>
					<td>Last name</td>
					<td><input type="text" name="lastName" value="${customer.lastName }" /></td>
				</tr>
				<tr>
					<td colspan = "2">
						<input type="submit" value= "Submit" />
						<a href="${pageContext.request.contextPath}/customerList">Cancel</a>
					</td>
				</tr>
			</table>
		</from>
	</c:if>
</body>
</html>