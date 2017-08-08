<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<div style="background: #E0E0E0; height: 55px; padding: 5px;">
	<div style="float: left">
		<h1>Next Insurance Solutions</h1>
	</div>
	
	<div style="float: right; color: white; padding: 10px; text-align: right;">
		
		<!-- User store in Session with attribute: loggedinUser -->
		Hello <b>${loggedInUser.fullName}</b>
		<!-- Search <input name="search"> -->  
	</div>
</div>
<br>
</head>
</html>