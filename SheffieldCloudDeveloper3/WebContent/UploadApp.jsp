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
<link rel="stylesheet" href="//cdn.jsdelivr.net/jquery.bootstrapvalidator/0.5.0/css/bootstrapValidator.min.css"/>
<link rel="stylesheet" href="css/developers_dashboard_styles.css">
</head>
<body>
<!--Start navigation elements-->
<% response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expires", "0");
Cookie cookies[] = request.getCookies();
Cookie cook = null;
if(cookies!=null) {
for (Cookie cookie : cookies) {
	if (cookie.getName().equals("userdetails") && cookie.getMaxAge() == 0) {
		response.sendRedirect("Home.jsp");
	}
}
}%>
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
<div class="collaspe navbar-collapse" id="#DevNavbar">
    <ul class="nav navbar-nav ">
      <li><a href="Documentation.jsp">Documentation</a></li>
    <li><a href="./GETTransaction">Billing</a></li>
    <li><a href="UploadApp.jsp">Upload Apps</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
     <li><a href="#">Welcome ${name}</a></li>
    <li><a href="./LogoutRedirect" ><span class="glyphicon glyphicon-log-in"></span> Logout </a></li>
    </ul>

</div>
</div>
</nav>
<!--The end of the navigationbar-->

<!--Documentation Start -->

<!--Documentation container and rows -->
<div class="container-fluid">

<div class="row">
<div class="col-md-1 col-lg-1 row-fluid" >
<div class="col-1"></div>
</div>

<!--Upload Apps View -->
<div class="col-md-10 col-lg-10 " >
<div class="col-md-3"></div>
<div class="col-main col-md-6 upload">


<form method="post" action="upload" enctype="multipart/form-data">

						<div class="form-group">
							<h1>Upload App</h1>
						</div>

						<div class="form-group">
							<label for="nameofapp">Name of Application</label> <input
								type="text" name="nameofapp" class="form-control"
								placeholder="Name of Application" required>
						</div>



						





						<div class="form-group">
							<label for="appwar">App Zip</label> <input type="file"
								name="uploadFile" required>
							<p class="help-block">upload a zip file (Include document, images and war file)</p>
						</div>



						
				<!--		<div class="form-group">
							<label for="appdescription">App Description</label> <input
								type="text" name="appdescription" class="form-control"
								id="appdescription" placeholder="optional infos"
								required>
						</div>

						<div class="form-group"> <label for="appurl">App Url</label> <input
							type="text" name="appurl" class="form-control" id="appurl"
							placeholder="eg. http://localhost/appname" required>
				</div>
 -->

				<input
					type="submit" value="Upload" />
				</form>
</div>
 <div class="col-md-3"></div>
</div>
<div class="col-md-1 col-lg-1 row-fluid" >
<div class="col-1"></div>
</div>
</div>
</div>

</body>
</html>
    