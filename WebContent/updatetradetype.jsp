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
<body style="background-image:url('images/img5.jpg');
		 background-position: center;
  background-repeat: no-repeat;
  background-size: cover; ">
<h1 style="color:white;">UPDATE RECORD</h1>
<form ACTION="updatetradetype.spring" method=post>
<%Trade id=(Trade)request.getAttribute("data"); %>
<h3 style="color:white;">ID:</h3><input type="text" name="Cust_Id" value="<%=id.getCust_Id() %>" readonly="readonly"><br><br>
<h3 style="color:white;">TRADE TYPE</h3>
<select required aria-required="true" name="Trade_Type" required="True">
            <option></option>
            <option value=1>Bond</option>
            <option value=2>Repo</option>
</select>
<br><br>
<!--<div height:100%;>  -->
<div style="width:300px">
<input type="submit" value="SUBMIT" class="btn btn-success"/>
</form>&nbsp;&nbsp;&nbsp;&nbsp;
<form id="back" action="updatingadmin.jsp" method="post" style="display: inline">
<input type="submit" value="BACK" class="btn btn-success"/><br><br><br><br><br><br><br><br><br><br>.</form>
</div>
</form>
</body>
</html>