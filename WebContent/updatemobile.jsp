<%@page import="com.Trade.Bean.Trade" %><%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="admin.css" rel="stylesheet"/>

<link href="stan.jpg" type="image/icon" rel="icon">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UPDATE RECORD</title>
</head>
<body style="background-image:url('images/updatetrader.jpeg');
		 background-position: center;
  background-repeat: no-repeat;
  background-size: cover;">
     <form action="index.jsp" method="post">
<input type="submit" style="float: right"class="btn btn-success" value="LOG OUT"></form>
<h1 style="color:white;"><u>UPDATE RECORD</u></h1><br>
<form ACTION="updatemobile.spring" method=post>
<%Trade id=(Trade)request.getAttribute("data"); %>
<%session.setAttribute("userId", id.getCust_Id()); %>
<h4 style="color:black;">CUSTOMER_ID:</h4><input type="text" name="Cust_Id" value="<%=id.getCust_Id() %>" readonly="readonly"><br><br>

<h4 style="color:black;">CUSTOMER_MOBILE:</h4><input type="tel" pattern="^[0-9]{10}$"  maxlength="10" name="Mobile" required="True"><br><br>
<div style="width:300px">  
<input type="submit"  value="SUBMT" class="btn btn-success"/>
</form>&nbsp;&nbsp;&nbsp;&nbsp;

<form action="update1.jsp" method="post" style="display: inline">
 <input type="hidden" name="id" value="${id.getCust_Id()}"> 
<input type="submit"  value="BACK" class="btn btn-success"/><br><br><br><br><br><br><br><br><br><br>.</form></div><br><br><br><br>
</body>
</html>