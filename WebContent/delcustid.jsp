<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="login.css" rel="stylesheet"/>
<link href="stan.jpg" type="image/icon" rel="icon">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer ID</title>
</head>
<body style="background-image:url('images/img5.jpg');

  background-repeat: no-repeat;
  background-size: cover;">
<form action="index.jsp" method="post" style="display: inline">
<input type="submit" style="float: right" class="btn btn-success" value="LOG OUT"></form>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
<form action="delcustid.spring" align=middle  >
<h4><font color="white">
ENTER CUSTOMER ID</font><br><br></h4><input type="number" name="Cust_Id" min="1" max="30" required="True"><br>
<br>
<br>
<div style="width:250px">
<input type="submit" align="middle" value="SUBMIT" class="btn btn-success"/>
</form> &nbsp;&nbsp;&nbsp;&nbsp;
<form action="delete.jsp" method="post" style="display: inline">
<input type="submit" align="middle" value="BACK" class="btn btn-success"/>
</body>
</html>