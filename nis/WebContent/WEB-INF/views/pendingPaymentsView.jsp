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
	
	
	
	<p style="color: red;">${errorString}</p>
	<div align="center">
	<h3>Banking Logs</h3>
	<div class="backg">	
	<div style="overflow-x:auto;">
		<table>
			<tr>
				<th>Date</th>
				<th>Client Name</th>
				<th>Total Payment</th>
				<th>Payment Type</th>
				<th>Agent</th>
				<th>Policy Number</th>
				<th>Transaction Type</th>
				<th>Fiduciary</th>
				<th>Clear</th>
			</tr>
			<c:forEach items="${bankingList}" var="banking" >
				<tr>
					<td>${banking.paymentDate }</td>
					<td>
					<a href="customerProfile?policyNumber=${banking.policyNumber}">${banking.firstName} ${banking.lastName}</a>
					</td>
					<td>${banking.totalAmount }</td>
					<td>${banking.paymentType}</td>
					<td>${banking.agent }</td>
					<td>${banking.policyNumber }</td>
					<td>${banking.transactionType }</td>
					<td>${banking.fid }</td>
					<td>
					<a href="clearPayment?paymentId=${banking.paymentId}">Clear Payment</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	</div>
	</div>
</body>
</html>