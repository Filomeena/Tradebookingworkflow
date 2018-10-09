<%@page import="com.Trade.Bean.Trade" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="admin.css" rel="stylesheet"/>

<link href="stan.jpg" type="image/icon" rel="icon">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UPDATE RECORD</title>
</head>
<body style="background-image:url('images/traderupdate.jpeg');
		 background-position: center;
  background-repeat: no-repeat;
  background-size: cover;">
   <form action="index.jsp" method="post">
<input type="submit" style="float: right"class="btn btn-success" value="LOG OUT"></form>
<h1 style="color:white;"><u>UPDATE RECORD</u></h1>


<form ACTION="updatetlname.spring" method=post>
<%Trade id=(Trade)request.getAttribute("data"); %>
<%session.setAttribute("traderId", id.getTrader_Id()); %>
<h4 style="color:white;">TRADER_ID:</h4><input type="text" name="Trader_Id" value="<%=id.getTrader_Id() %>" readonly="readonly"><br><br>
<h4 style="color:white;">TRADER_LASTNAME:</h4><input type="text" name="Trader_LastName" pattern="[A-Z][a-z]{3,40}" required
        title="Username should start with uppercase letter and must have length with 40. e.g. John"><br><br>
<div style="width:300px">
<input type="submit"  value="SUBMIT" class="btn btn-success"/>
</form>&nbsp;&nbsp;&nbsp;&nbsp;
<form id="back" action="Traderhome.jsp" method="post" style="display: inline">
 <input type="hidden" name="id" value="${id.getTrader_Id()}"> 
<input type="submit"  value="BACK" class="btn btn-success"/><br><br><br><br><br><br><br><br><br><br>.</div></form>
</body>
</html>