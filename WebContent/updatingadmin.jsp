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
<body>
<form action="index.jsp" method="post" style="display: inline">
<input type="submit" style="float: right" class="btn btn-success" value="LOG OUT"></form>
<h1 style="color:white;"><u>CHECK RECORD</u></h1>

  <br>
<form id="updateadmin" action="updateadm.spring" method="post"  style="display: inline">
<body style="background-image:url('images/update.jpeg');
		 background-position: center;
  background-repeat: no-repeat;
  background-size: cover;">

 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
 <h3 style="color:white;display:inline;align:middle">Enter ID to update:</h3><input type="text" name="Cust_Id" required="True" pattern="^[1-9]{1,5}$" align="middle" title="not a vaild id ,input is number format!">
 <br>
<form action="csv.spring" method="post" align=middle>
 
<div>

<input type="radio" name="type" value="tradetype" id="radio1" class="radio" align= middle />

<label for="radio1">TRADE TYPE</label>
</div>

<div>
<input type="radio" name="type" value="transtype" id="radio2" class="radio"/>

<label for="radio2">TRANSACTION TYPE</label>
</div>

<div>	
<input type="radio" name="type" value="buysell" id="radio3" class="radio"/>

<label for="radio3">BUYSELL</label>
</div>

<div>	
<input type="radio" name="type" value="country" id="radio4" class="radio"/>

<label for="radio4">COUNTRY</label>
</div>
<div>	
<input type="radio" name="type" value="currency" id="radio5" class="radio"/>

<label for="radio5">CURRENCY</label>
</div>
<div>
<input type="radio" name="type" value="exchange" id="radio6" class="radio"/>

<label for="radio6">EXCHANGE</label>
</div>

<div>	
<input type="radio" name="type" value="status" id="radio7" class="radio"/>

<label for="radio7">STATUS</label>
</div>

<div>	
<input type="radio" name="type" value="sectorid" id="radio8" class="radio"/>

<label for="radio8">SECTORID</label>
</div>
<div>	
<input type="radio" name="type" value="isincode" id="radio9" class="radio"/>

<label for="radio9">ISINCODE</label>
</div>
<div>	
<input type="radio" name="type" value="locationid" id="radio10" class="radio"/>

<label for="radio10">LOCATIONID</label>

</div>
<div>	
<input type="radio" name="type" value="quantity" id="radio11" class="radio"/>

<label for="radio11">QUANTITY</label>
</div>
<br><br><br><br>
<div style="width:1200px">
<input type="submit" align="middle" value="SUBMIT" class="btn btn-success"/>
</form> &nbsp;&nbsp;&nbsp;&nbsp;
<form action="admin.jsp" method="post" style="display: inline">
<input type="submit" align="middle" value="BACK" class="btn btn-success"/>

</form>

<!-- <form id="back" action="admin.jsp" method="post" style="display: inline"> -->
<!-- <input type="submit"  value="BACK" class="btn btn-success"/> --></form></div>
</div></div>
<br><br><br>
<h3 style="color:blue;background-color:white;text-align:center">
<%
String value=(String)request.getAttribute("msg");
if(value!=null)
{
	out.println(value);
}

%></h3>
</body>
</html>