<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<link href="login.css" rel="stylesheet" />
<link href="stan.jpg" type="image/icon" rel="icon">
 <title>Login</title>
</head>
<body id="LoginForm" style="background-image:url('images/login.jpg')">

</form>
<div class="container" >

<img src="images/stan1.png" width=300 height =200 align=right>
<div class="main-div" >
    <div class="wrap" >
   
    <form action="check.spring" method="post" >
   
      <br>
    <h1>Login</h1>
    <br>
    <br>
    </form>
<form action="check.spring" method="post" >
<h4>Enter username:</h4><input type="text" name="name" required="True"><br><br>
<h4>Enter password:</h4><input type="password" name="password" required="True"><br><br>
<input type="submit" value="submit" class="btn btn-success btn-sm">
</form>
<br><br><br><br>
<h3>
<%
String value=(String)request.getAttribute("msg");
if(value!=null)
{
	out.println(value);
}

%></h3></div></div>
</body>
</html>