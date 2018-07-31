<%@page import="java.util.ResourceBundle"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Developer's Dashboard</title>    
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, intial-scale=1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<link rel="stylesheet" href="css/developers_dashboard_styles.css">
</head>  
<body>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expires", "0");
Cookie cookies[] = request.getCookies();
Cookie cook = null;
if(cookies!=null) {
for (Cookie cookie : cookies) {
	if (cookie.getName().equals("userdetails") && cookie.getMaxAge() != 0) {
		cook = cookie;
		response.sendRedirect("Documentation.jsp");
    
         //response.sendRedirect("http://localhost:8080/SheffieldCloudPlatform/Authenticate");
	}
}
}

%>
<%
%>
<!--Start navigation elements-->    

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
    <div class="navbar-header">
    <button type="button" class="navbar-toggle" data-toogle="collaspe" data-target="#DevNavbar">
     <span class="icon-bar"></span>
     <span class="icon-bar"></span>    
      <span class="icon-bar"></span> 
    </button> 
    <a class="navbar-brand" href="#">Sheffield Cloud Base</a>
</div>
<!--this part of the code handles the collaspeable navbar-->
<div class="collaspe navbar-collapse" id="DevNavbar">
    <ul class="nav navbar-nav">
    <li><a href="#">Home</a></li>
    <li><a href="Register.jsp">Register</a></li> 
    </ul>
    <ul class="nav navbar-nav navbar-right">
    <li><a href="./CheckForCookie" ><span class="glyphicon glyphicon-log-in"></span> Login </a></li>
    </ul>

</div>
</div>
</nav>
<div id="myCarousel" class="carousel slide" data-ride="carousel">

<div class="carousel-inner" role="listbox">
<div class="item active">
  <img src="img/pexels-photo-242492.jpeg">
  <div class="carousel-caption">
    <h1>Develop Academic Theme Apps For Students</h1>
    <br>
   <a href="Register.jsp"><button type="button"  class="btn btn-default">Get Started</button></a> 

</div>

</div>
  