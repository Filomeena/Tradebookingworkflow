<%@page import="com.Trade.Bean.Trade" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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
<h1 style="color:white;"><U>UPDATE RECORD</U></h1><br><br><br>

<form ACTION="updatefname.spring" method=post>
<%Trade id=(Trade)request.getAttribute("data"); %><br><br>
<%session.setAttribute("userId", id.getCust_Id()); %>
<h4 style="color:black;display:inline">  CUST_ID </h4><input type="text" name="Cust_Id" value="<%=id.getCust_Id() %>" readonly="readonly"><br><br><br>
<h4 style="color:black;display:inline">FIRSTNAME </h4><input type="text" name="Cust_FirstName" pattern="[A-Z][a-z]{3,40}" required
title="Username should start with uppercase letter and must have length with 40. e.g. John"><br><br><br>
<div style="width:300px"> 
<input type="submit"  value="SUBMIT" class="btn btn-success"/>
</form>&nbsp;&nbsp;&nbsp;&nbsp;
<form id="back" action="update1.jsp" method="post" style="display: inline">
 <input type="hidden" name="id" value="${id.getCust_Id()}"> 
<input type="submit"  value="BACK" class="btn btn-success"/><br><br><br><br><br><br><br><br><br><br>.</form></div>
</body>
</html>