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
<body style="background-image:url('images/search.jpg');

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
  <br><br>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
&nbsp;&nbsp;&nbsp;&nbsp;<form action="custid.spring" align=middle>
<h4><font color="white" align="middle">
ENTER CUSTOMER ID</font><br><br></h4><input type="number" name="Cust_Id" min="1" max="30" required="True" title="enter a correct id">
<br>
<br>
<div style="width:250px"><input type="submit" align="middle" value="SUBMIT" class="btn btn-success"/>
</form> &nbsp;&nbsp;&nbsp;&nbsp;
<form action="search.jsp" method="post" style="display: inline">
<input type="submit" align="middle" value="BACK" class="btn btn-success"/></form></div>
<h3 style="color:blue;background-color:white;text-align:center"><%
String value=(String)request.getAttribute("msg");
if(value!=null)
{
	out.println(value);
}

%></h3>
</body>
</html>