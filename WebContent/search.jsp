<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="stan.jpg" type="image/icon" rel="icon">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>search</title>
<link href="admin.css" rel="stylesheet"/>
</head>
<body style="background-image:url('images/searchhome.jpg');
background-position: center;
background-repeat: no-repeat;
background-size: cover;">
<form action="index.jsp" method="post">
<input type="submit" style="float: right" class="btn btn-success" value="LOG OUT"></form>
<div class="vertical-menu">
<h2><a href="custid.jsp">SEARCH BY CUSTOMER ID</a><br><br>
<a href="tradeid.jsp">SEARCH BY TRADE ID</a><br><br>
<a href="traderid.jsp">SEARCH BY TRADER ID</a></h2>
</div>
<form action="admin.jsp" method="post">
<input type="submit" class="btn btn-success" value="BACK">
<h3 style="color:blue;background-color:white;text-align:center"><%
String value=(String)request.getAttribute("msg");
if(value!=null)
{
	out.println(value);
}

%></h3>
</body>
</html>