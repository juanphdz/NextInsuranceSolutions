<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.container {
    overflow: hidden;
    background-color: #0F0F0F;
    font-family: Arial;
}

.container a {
    float: left;
    font-size: 16px;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

.container .right{
	float: right;
}

.dropdown {
    float: left;
    overflow: hidden;
}

.dropdown .dropbtn {
    font-size: 16px;    
    border: none;
    outline: none;
    color: white;
    padding: 14px 16px;
    background-color: inherit;
}

.username{
    font-size: 16px;    
    border: none;
    outline: none;
    color: white;
    background-color: inherit;
    float: right;
}

.container a:hover, .dropdown:hover .dropbtn {
    background-color: gray;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}

.dropdown-content a {
    float: none;
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
    text-align: left;
}

.dropdown-content a:hover {
    background-color: #ddd;
}

.dropdown:hover .dropdown-content {
    display: block;
}
</style>
</head>
<body>

<div class="container">
  <a href="${pageContent.request.contextPath}/nis/main">Home</a>
  <div class="dropdown">
    <button class="dropbtn">Agent</button>
    <div class="dropdown-content">
      <a href="${pageContext.request.contextPath}/main">Policy Search</a>
      <a href="${pageContext.request.contextPath}/createCustomer">Create Customer</a>
    </div>
  </div> 
    <div class="dropdown">
    <button class="dropbtn">Management</button>
    <div class="dropdown-content">
      <a href="${pageContext.request.contextPath}/banking">Banking</a>
      <a href="${pageContext.request.contextPath}/pendingPayments">Pending Payments</a>
    </div>
  </div>
  <a class="right" href="${pageContext.request.contextPath}/logout">Logout</a>
  <a class="right" href="${pageContext.request.contextPath}/main">${loggedInUser.fullName}</a>
</div>

</body>
</html>
