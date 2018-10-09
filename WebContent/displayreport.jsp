<%@page import="java.util.*" %>
<%@page import="java.lang.*" %>
<%@page import="java.io.*" %>

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

<title>Insert title here</title>
</head>
<body style="background-image:url('images/REPORT2.jpeg');

  background-repeat: no-repeat;
  background-size: 1300px 740px;">
<form action="index.jsp" method="post" style="display: inline">
<input type="submit" style="float: right" class="btn btn-success" value="LOG OUT"></form>
<div style="align-content:center;position: absolute;
left: 430px;
top: 200px;">
<h3 style="color:blue;align-content:center;width:400px;heigth:1000px;display:flex;"><%
			int res =0;
	        String File = "E:\\scb\\Report.txt";
	        BufferedReader br = null;
	        String line = "";
	        String cvsSplitBy = ",";

	        try {

	            br = new BufferedReader(new FileReader(File));
	            while ((line = br.readLine()) != null) {
	            	
	            	 
	            	String[] values = line.split(cvsSplitBy);
				
				
				
	               out.println(values[0]);
	               
	               
	                //out.print("\r\n");
	               // out.println();
	                //out.println();
	                
	              // System.out.println(values[0]);
	     
	            }
	            

	        } 
	       
	        catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } 
	        catch (IOException e) {
	            e.printStackTrace();
	        } 
	        catch(Exception e)
	        {
	        	System.out.println(e);
	        }
	        finally {
	        
	            if (br != null) {
	                try {
	                    br.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	                
	            }
	            
	        }
			
	        
	   
	    %></h3></div>
<form action="admin.jsp" method="post" style="display: inline">
<input type="submit" align="middle" value="BACK" class="btn btn-success"/>	
</body>

</html>