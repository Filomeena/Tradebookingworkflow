<%@page import="com.Trade.Bean.Trade"%>
<%@page import="java.util.Iterator" %>
<%@page import="java.util.List" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TRADE TABLE</title>

<link href="bg.css" rel="stylesheet"/>
<link href="stan.jpg" type="image/icon" rel="icon">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<body style="background-image:url('images/display.jpg');
background-position: center;
  background-repeat: no-repeat;
  background-size: 7000px 1000px; ">
<h1 style=color:"white"><u>TRADE DETAILS:</u></h1>

<form action="admin.jsp" method="post">
<input type="submit" class="btn btn-success" value="BACK">
</form>
<table border="ll">
<tr>
<th>CUST_ID</th>
<th>CUST_FIRSTNAME</th>
<th>CUST_LASTNAME</th>
<th>CUST_CONTACT</th>
<th>TRADER_ID</th>
<th>TRADER_FIRSTNAME</th>
<th>TRADER_LASTNAME</th>
<th>TRADER_CONTACT</th>
<th>TRADE_TYPE</th>
<th>TRADE_DATE</th>
<th>TRADE_TIMESTAMP</th>
<th>TRADE_ID</th>
<th>TRANSACTION_ID</th>
<th>TRANSACTION_TYPE</th>
<th>BUY/SELL</th>
<th>SETTLEMENT_ID</th>
<th>SETTLEMENT_DATE</th>
<th>SETTLEMENT_TIMESTAMP</th>
<th>ORDER_ID</th>
<th>ORDER_TIMESTAMP</th>
<th>QUANTITY</th>
<th>STATUS</th>
<th>CANCEL_DATE</th>
<th>CANCEL_TIME</th>
<th>BID</th>
<th>ASK</th>
<th>LTP</th>
<th>COUNTRY</th>
<th>CURRENCY</th>
<th>EXCHANGE</th>
<th>SECTOR_ID</th>
<th>ISIN CODE</th>
<th>LOCATION_ID</th>
</tr>
<%
List<Trade> listOfRec=(List<Trade>)request.getAttribute("data");
Iterator<Trade> itr=listOfRec.iterator();
while(itr.hasNext())
{
	Trade tt=itr.next();
	
%>
<tr>
<td><%=tt.getCust_Id()%></td>
<td><%=tt.getCust_FirstName()%></td>
<td><%=tt.getCust_LastName()%></td>
<td><%=tt.getCust_Mobile_Number() %></td>
<td><%=tt.getTrader_Id()%></td>
<td><%=tt.getTrader_FirstName()%></td>
<td><%=tt.getTrader_LastName()%></td>
<td><%=tt.getTrader_Contact()%></td>
<td><%=tt.getTrade_Type()%></td>
<td><%=tt.getTrade_Date()%></td>
<td><%=tt.getTrademod_Timestamp()%></td>
<td><%=tt.getTradeUniqueId()%></td>
<td><%=tt.getTransaction_Id()%></td>
<td><%=tt.getTransaction_Type()%></td>
<td><%=tt.getBuy_Sell()%></td>
<td><%=tt.getSettlement_Id()%></td>
<td><%=tt.getSettlement_Date()%></td>
<td><%=tt.getSettlement_Timestamp()%></td>
<td><%=tt.getOrder_Id()%></td>
<td><%=tt.getOrder_Timestamp()%></td>
<td><%=tt.getQuantity()%></td>
<td><%=tt.getStatus()%></td>
<td><%=tt.getCancel_Date()%></td>
<td><%=tt.getCancel_Time()%></td>
<td><%=tt.getBID()%></td>
<td><%=tt.getASK()%></td>
<td><%=tt.getLTP()%></td>
<td><%=tt.getCountry()%></td>
<td><%=tt.getCurrency()%></td>
<td><%=tt.getExchange()%></td>
<td><%=tt.getSector_Id()%></td>
<td><%=tt.getISIN_Code()%></td>
<td><%=tt.getLocation_Id()%></td>

</tr>
<%
}
%>
</table>
<br>
<form action="admin.jsp" method="post">
<input type="submit" value="BACK" class="btn btn-success"/>
</form>
</body>
</html>













