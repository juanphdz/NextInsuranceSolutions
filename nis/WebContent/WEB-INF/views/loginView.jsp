<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"><html>
<head>
<style>
form {
    border: 3px solid #f1f1f1;
}

input[type=text], input[type=password] {
    width: 20%;
    padding: 12px 20px;
    margin: 0px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
    border-radius: 4px;
}


button {
    background-color: #008CBA;
    color: white;
    padding: 14px 20px;
    margin: 0px 0;
    border: none;
    cursor: pointer;
    width: 13%;
}

button:hover {
    opacity: 0.8;
}

.cancelbtn {
    width: auto;
    padding: 10px 18px;
    background-color: #f44336;
}

.container {
    padding: 16px;
    text-align: center;
}

span.psw {
    float: right;
    padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
    span.psw {
       display: block;
       float: none;
    }
    .cancelbtn {
       width: 100%;
    }
}
</style>
<body>

<h2>Next Insurance Solutions</h2>

<form method="POST" action="doLogin">
  <div class="container">
  <p style="color: red;">${errorString}</p>
  <label><b>Username</b></label>
    <input type="text" placeholder="Username" name="email" value="${user.email}" required />
  </div>
  <div class="container">
  <label><b>Password</b></label>
    <input type="password" placeholder="Password" name="password" value = "${user.password }" required />
  </div>
  <div class="container">
    <button type="submit">Login</button>
  </div>
</form>

</body>
</html>
