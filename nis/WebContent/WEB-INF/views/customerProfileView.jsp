<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset=UTF-8">
<title>Customer Profile</title>
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
	
	
	
	<p style="color: red;">${errorString}</p>
<div align="center">
<div class="backg">
<h3>Customer Profile</h3>
<div style="overflow-x:auto;">
<c:if test="${not empty profile}">
	<table>
		<tr>
			<th>Policy Number</th>
		</tr>
		<tr>
			<td>${profile.policyNumber}</td>
		</tr>
	</table>
	<table>
		<tr>
			<th>Name</th>
			<th>Date of Birth</th>
			<th>Driver License</th>
		</tr>
		
		<tr>
			<td>${profile.firstName} ${profile.lastName }</td>
			<td>${profile.dateOfBirth }</td>
			<td>${profile.driverLicense }</td>
		</tr>
	</table>
	<table>
		<tr>
			<th>Phone Number</th>
			<th>Address</th>
		</tr>
		
		<tr>
			<td>${profile.phoneNumber}</td>
			<td>${profile.addressStreet}, ${profile.addressCity } ${profile.addressState}, ${profile.addressZip }</td>
		</tr>
		
	</table>
</c:if>
</div>
<h3>Additional Drivers</h3>
	<table>
		<tr>
			<th>Name</th>
			<th>Date of Birth</th>
			<th>Driver License</th>
			<th>Driver Status</th>
		</tr>
		<c:forEach items="${additionalDriver}" var="additionalDriver" >
			<tr>
				<td>${additionalDriver.firstName} ${additionalDriver.lastName }</td>
				<td>${additionalDriver.dateOfBirth }</td>
				<td>${additionalDriver.driverLicense }</td>
				<td>${additionalDriver.driverStatus }</td>
			</tr>
		</c:forEach>
	</table>
<a href="addAdditionalDriver?policyNumber=${profile.policyNumber}">Add Additional Driver</a>
<h3>Vehicles</h3>
	<table>
		<tr>
			<th>Year</th>
			<th>Make</th>
			<th>Model</th>
			<th>Vin</th>
		</tr>
		<c:forEach items="${vehicle}" var="vehicle" >
			<tr>
				<td>${vehicle.vehicleYear}</td>
				<td>${vehicle.vehicleMake }</td>
				<td>${vehicle.vehicleModel }</td>
				<td>${vehicle.vehicleVin }</td>
			</tr>
		</c:forEach>
	</table>
<a href="addVehicle?policyNumber=${profile.policyNumber}">Add Vehicle</a>
<h3>Payment History</h3>
<a href="makePayment?policyNumber=${profile.policyNumber}"><b>Make a Payment</b></a>
	<table>
		<tr>
			<th>Payment Date</th>
			<th>Transaction Type</th>
			<th>Received by</th>
			<th>Payment Type</th>
			<th>Amount</th>
		</tr>
		<c:forEach items="${payment}" var="payment" >
			<tr>
				<td>${payment.paymentDate}</td>
				<td>${payment.transactionType }</td>
				<td>${payment.agent }</td>
				<td>${payment.paymentType }</td>
				<td>${payment.totalAmount }</td>
			</tr>
		</c:forEach>
	</table>
</div>
</div>
</body>
</html>