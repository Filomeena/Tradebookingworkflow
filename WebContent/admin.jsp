<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="admin.css" rel="stylesheet"/>
<link href="back.css" rel="stylesheet"/>
<link href="stan.jpg" type="image/icon" rel="icon">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrator Page</title>
</head>

 <body style="background-image:url('images/adminpage.jpg');
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;">
  
<form action="index.jsp" method="post">
<input type="submit" style="float: right"class="btn btn-success" value="LOG OUT"></form>

<form action="csv.spring" method="post" align="middle">
  <div class="container">
    <div class="topnav" >
      <h2 style="color:black"><u>ADMIN FUNCTIONS</u></h2>
    </div>
  </div><br><br><br>

<div style="align-items: right">
<br>
<input type="radio" align= "right" name="type" value="upload" id="radio1" class="radio" display="inline"/>

<label for="radio1">UPLOAD DATA</label>
</div>

<div>
<input type="radio" name="type" value="display" id="radio2" class="radio"  align= "left" display="inline"/>

<label for="radio2">DISPLAY DATA</label>
</div>

<div>	
<input type="radio" name="type" value="search" id="radio3" class="radio"  align= "right"/>

<label for="radio3">SEARCH DATA</label>
</div>
<br>
<div>	
<input type="radio" name="type" value="delete" id="radio4" class="radio"/>

<label for="radio4">DELETE DATA</label>
</div>

<div>	
<input type="radio" name="type" value="update" id="radio5" class="radio"  align= "left"/>

<label for="radio5">UPDATE DATA</label>
</div>

<div>
<input type="radio" name="type" value="REPORT" id="radio6" class="radio" align= "left"/>

<label for="radio6">REPORTS GENERATE</label>

</div>
<br>
<div>
<input type="radio" name="type" value="bondreport" id="radio7" class="radio" align= "left"/>

<label for="radio7">DISPLAY BOND</label>

</div>

<div>
<input type="radio" name="type" value="reporeport" id="radio8" class="radio" align= "left"/>

<label for="radio8">DISPLAY REPO</label>

</div>
<div>
<input type="radio" name="type" value="displayreport" id="radio9" class="radio" align= "left"/>

<label for="radio9">DISPLAY REPORT</label>

</div>

<br><br><br><br>
<div style="text-align:center">
<input type="submit" align="middle" value="SUBMIT" class="btn btn-success"/></div>
</form>
<h3 style="color:blue;background-color:white;text-align:center"><%
String value=(String)request.getAttribute("msg");
if(value!=null)
{
	out.println(value);
}

%></h3>
</body>
</html>