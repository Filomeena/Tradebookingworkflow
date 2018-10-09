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
<link href="back.css" rel="stylesheet"/>
<link href="stan.jpg" type="image/icon" rel="icon">
<title>USER  FUNCTIONS</title>
</head>
<body style="background-image:url('images/adminpage.jpg');
		 background-position: center;
  background-repeat: no-repeat;
  background-size: cover;">
<form action="index.jsp" method="post">
<input type="submit" style="float: right"class="btn btn-success" value="LOG OUT"></form>


<form action="userfunction.spring" method="post" align="middle">
  <div class="container">
    <div class="topnav" >
      <h2 style="color:black"><u>USER FUNCTIONS</u></h2>
    </div>
  </div>
<br><br>
<div style="align-items: right;display:inline;">
<br><br><br><br>
<input type="radio"  name="type" value="update" id="radio1" class="radio" display="inline"/>

<label for="radio1">UPDATE DETAILS</label>
</div>
<div>
<input type="radio" name="type" value="view" id="radio2" class="radio"  align= "left" display="inline"/>

<label for="radio2">DISPLAY DATA</label>
</div>
<br>
<br>
<br>
<div style="text-align:center">
<input type="submit" align="middle" value="SUBMIT" class="btn btn-success"/></div>
</form><br>
<h3 style="color:blue;background-color:white;text-align:center"><%
String value=(String)request.getAttribute("msg");
if(value!=null)
{
	out.println(value);
}

%></h3>

</body>
</html>