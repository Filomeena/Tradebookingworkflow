<%@page import="com.Trade.Bean.Trade" %>
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
<link href="admin.css" rel="stylesheet" />
<link href="stan.jpg" type="image/icon" rel="icon">
 <title>UPDATE RECORD</title>
</head>
<body style="background-image:url('images/update.jpeg');
		 background-position: center;
  background-repeat: no-repeat;
  background-size: 1500px 1000px;">
 <form action="index.jsp" method="post">
<input type="submit" style="float: right"class="btn btn-success" value="LOG OUT"></form>
<h1 style="color:white;"><u>UPDATE RECORD</u></h1>
<form action="updating.spring" method="post">
<%Trade id=(Trade)request.getAttribute("data"); %>
<h3 style="color:white;display:inline">ID to update:</h3><input type="text" name="Cust_Id" style="align:left" value="<%=id.getCust_Id()%>" readonly="readonly"><br><br>

<div><input type="radio" name="type" value="fname" id="radio1" class="radio"/> 

<label for="radio1">CUST_FIRSTNAME</label></div>
<div>
<input type="radio" name="type" value="lname" id="radio2" class="radio" /> 

<label for="radio2">CUST_LASTNAME</label></div>
<div>
<input type="radio" name="type" value="mobile_no" id="radio3" class="radio"/> 

<label for="radio3">MOBILE_NUMBER</label></div><br><br><br><br>

<div style="width:300px"><input type="submit"  value="SUBMIT" class="btn btn-success"/>
</form>&nbsp;&nbsp;&nbsp;&nbsp;
<form action="userhome.jsp" method="post" style="display: inline">
<input type="submit"  value="BACK" class="btn btn-success"/>
</form></div>
<h3 style="color:blue;background-color:white;text-align:center">
<%
String value=(String)request.getAttribute("msg");
if(value!=null)
{
	out.println(value);
}

%>
</h3>
</body>
</html>