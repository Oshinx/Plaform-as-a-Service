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
<div class="container">

<div class="row">
<p style="text-align: center;"><span style="font-size: 19pt;"><strong>Documentation</strong></span></p>
<p style="text-align: left;"><span style="font-size: 10pt;">Welcome to Sheffield Cloud Base. The information&nbsp; below will provide details about the development&nbsp;of app for Sheffield&nbsp; Cloud Base. This&nbsp;platform&nbsp;supports Java only web application,&nbsp;MySQL&nbsp;database and the web server is tomcat.</span></p>
<p style="text-align: left;"><span style="font-size: 14pt;"><strong>Cookies</strong></span></p>
<p style="text-align: left;"><span style="font-size: 10pt;">In order to manage session across different applications on the platform the use of cookies was incorporated. Third party independent software vendors&nbsp;have access this cookie by using the following Java object. The first is the Customer object. Below&nbsp;is the structure</span></p>
<p style="text-align: left;">public class Customer {<br />&nbsp; &nbsp; &nbsp; &nbsp;private String firstname;<br />&nbsp; &nbsp; &nbsp; &nbsp;private String lastname;<br />&nbsp; &nbsp; &nbsp; &nbsp;private String email;<br />&nbsp; &nbsp; &nbsp; &nbsp;private String uniqueId;<br />&nbsp; &nbsp; &nbsp; &nbsp;private String role;<br />&nbsp; &nbsp; &nbsp; &nbsp;private String amount;<br /><br />&nbsp; &nbsp; public String getAmount() {<br />&nbsp; &nbsp; return amount;<br />&nbsp; &nbsp; &nbsp;}<br />&nbsp; &nbsp; &nbsp;public void setAmount(String amount) {<br />&nbsp; &nbsp; &nbsp;this.amount = amount;<br />&nbsp; &nbsp; &nbsp; }<br />&nbsp; &nbsp; public String getFirstname() {<br />&nbsp; &nbsp; return firstname;<br />&nbsp; &nbsp; }<br />&nbsp; &nbsp; &nbsp;public void setFirstname(String firstname) {<br />&nbsp; &nbsp; &nbsp;this.firstname = firstname;<br />&nbsp; &nbsp; &nbsp;}<br />&nbsp; &nbsp; &nbsp;public String getLastname() {<br />&nbsp; &nbsp; &nbsp; return lastname;<br />&nbsp; &nbsp; &nbsp; }<br />&nbsp; &nbsp; public void setLastname(String lastname) {<br />&nbsp; &nbsp; this.lastname = lastname;<br />&nbsp; &nbsp; &nbsp;}<br />&nbsp; &nbsp; public String getEmail() {<br />&nbsp; &nbsp; return email;<br />&nbsp; &nbsp; }<br />&nbsp; &nbsp; public void setEmail(String email) {<br />&nbsp; &nbsp; this.email = email;<br />&nbsp; &nbsp; }<br /><br />&nbsp; &nbsp; &nbsp;public String getUniqueId() {<br />&nbsp; &nbsp; &nbsp;return uniqueId;<br />&nbsp; &nbsp; &nbsp; }<br />&nbsp; &nbsp; &nbsp;public void setUniqueId(String uniqueId) {<br />&nbsp; &nbsp; &nbsp;this.uniqueId = uniqueId;<br />&nbsp; &nbsp; &nbsp;}<br />&nbsp; &nbsp; &nbsp;public String getRole() {<br />&nbsp; &nbsp; &nbsp;return role;<br />&nbsp; &nbsp; &nbsp; }<br />&nbsp; &nbsp; &nbsp;public void setRole(String role) {<br />&nbsp; &nbsp; &nbsp;this.role = role;<br />&nbsp; &nbsp; &nbsp; &nbsp; }}</p>
<p style="text-align: left;">The second Class need is the Jwt(Json&nbsp;web token) this contains methods that help&nbsp;retrieve&nbsp;the data stored&nbsp;in the cookies and validates the authenticity using the sign method. The&nbsp;hashing algorithm&nbsp;is Md5. The structure of the class is below.</p>
<p>public class Jwt {<br />&nbsp; &nbsp; &nbsp;private String issuer;<br />&nbsp; &nbsp; &nbsp;private Customer customer;<br />&nbsp; &nbsp; &nbsp;private String signature;<br />&nbsp; &nbsp; &nbsp;public String getIssuer() {<br />&nbsp; &nbsp; &nbsp;return issuer;<br />}<br />&nbsp; &nbsp;public void setIssuer(String issuer) {<br />&nbsp; &nbsp; &nbsp; &nbsp;this.issuer = issuer;<br />&nbsp; }<br />&nbsp;<br />&nbsp; &nbsp;public Customer getCustomer() {<br />&nbsp; &nbsp; &nbsp;return customer;<br />&nbsp; &nbsp; &nbsp;}<br />&nbsp; &nbsp; public void setCustomer(Customer customer) {<br />&nbsp; &nbsp; &nbsp;this.customer = customer;<br />&nbsp; &nbsp; &nbsp;}<br />&nbsp; &nbsp; public String getSignature() {<br />&nbsp; &nbsp; return signature;<br />&nbsp; &nbsp; &nbsp;}<br />&nbsp; &nbsp; public void setSignature(String signature) {<br />&nbsp; &nbsp; this.signature = signature;<br />&nbsp; &nbsp; }<br /><br />&nbsp; &nbsp; public String signjwt() throws NoSuchAlgorithmException {<br />&nbsp; &nbsp; &nbsp;String toSign = getIssuer() + getCustomer().toString();<br />&nbsp; &nbsp; &nbsp;MessageDigest digest;<br />&nbsp; &nbsp; &nbsp;digest = MessageDigest.getInstance("MD5");<br />&nbsp; &nbsp; &nbsp;digest.update(toString().getBytes());<br />&nbsp; &nbsp; &nbsp;StringBuilder sb = new StringBuilder();<br />&nbsp; &nbsp; &nbsp; byte [] bytes = digest.digest();<br />&nbsp; &nbsp; &nbsp; for(int i = 0; i&lt;bytes.length; i++) {<br />&nbsp; &nbsp; &nbsp; &nbsp;sb.append(Integer.toString((bytes[i] &amp; 0xff) + 0x100,&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 16).substring(1));<br />}</p>
<p>return sb.toString();<br />}<br /><br /><br />}</p>
<p>Some libraries will be needed this are&nbsp;</p>
<ul>
<li>Jackson core&nbsp;</li>
<li>Jackson annotation</li>
<li>Jackson databind&nbsp;</li>
<li>Jackson mapper</li>
</ul>
<p>All these libraries will help deserialize the JSON back to object. The method below is a sample method to&nbsp;deserialize the Json object.</p>
<p><span style="font-size: 10pt;">public List&lt;String&gt; getUser( HttpServletRequest request) throws JsonParseException, JsonMappingException, IOException{<br />Cookie[] cookies = request.getCookies();<br />List&lt;String&gt; userdetails = new ArrayList&lt;&gt;();<br />for (Cookie cookie : cookies) {<br />System.out.println("Jwt");<br />System.out.println(cookie.getName());<br />if(cookie.getName().equals("userdetails")) {<br />System.out.println( "inside");<br />String jwt =URLDecoder.decode( cookie.getValue().toString(), "UTF-8" );<br />System.out.println(jwt + "Jwt");<br />ObjectMapper mapper = new ObjectMapper();<br />mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);<br />Jwt jwtcookie = mapper.readValue(jwt, Jwt.class);<br />String id = jwtcookie.getCustomer().getUniqueId();<br />String firstname = jwtcookie.getCustomer().getFirstname();<br />userdetails.add(id);<br />userdetails.add(firstname);<br /><br />}<br />}<br />System.out.println(userdetails.get(0));<br />System.out.println(userdetails.get(1));<br />return userdetails;<br />}</span></p>
<p style="text-align: left;"><span style="font-size: 15pt;"><strong>App Upload</strong></span></p>
<p style="text-align: left;"><span style="font-size: 10pt;">In the nav bar above an upload button is provided for developers to upload application.To upload your application to the cloud the following instruction must be adhered to or app deployment becomes impossible.</span></p>
<ul>
<li style="text-align: left;"><span style="font-size: 10pt;">The system description of no more than 50 words</span></li>
<li style="text-align: left;"><span style="font-size: 10pt;">The sql&nbsp;database structure in sql query format.</span></li>
<li style="text-align: left;"><span style="font-size: 10pt;">The web archive file(war)</span></li>
</ul>
<p><span style="font-size: 10pt;">The above must be in a zip folder upon app upload.&nbsp;</span></p>
<p style="text-align: left;"><span style="font-size: 14pt;"><strong>Database Connection</strong></span></p>
<p style="text-align: left;"><span style="font-size: 10pt;">The database connection credentials are </span></p>
<p style="text-align: left;"><span style="font-size: 10pt;">username =roots</span></p>
<p style="text-align: left;"><span style="font-size: 10pt;">password =pass;</span></p>
<p style="text-align: left;"><span style="font-size: 10pt;">The above are necessary information needed to host the app on Sheffield cloud base.</span></p>


</div>
</div>
</body>    
</html>
