<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<style>
* {
  box-sizing: border-box;
}


body {
  font-family: Arial, Helvetica, sans-serif;
  margin: 0;
}


.header h1 {
  font-size: 40px;
}

/* Sticky navbar - toggles between relative and fixed, depending on the scroll position. It is positioned relative until a given offset position is met in the viewport - then it "sticks" in place (like position:fixed). The sticky value is not supported in IE or Edge 15 and earlier versions. However, for these versions the navbar will inherit default position */
.navbar {
  overflow: hidden;
  background-color: #333;
  position: sticky;
  position: -webkit-sticky;
  top: 0;
}

/* Style the navigation bar links */
.navbar a {
  float: left;
  display: block;
  color: white;
  text-align: center;
  padding: 14px 20px;
  text-decoration: none;
}


/* Right-aligned link */
.navbar a.right {
  float: right;
}

/* Change color on hover */
.navbar a:hover {
  background-color: #ddd;
  color: black;
}

/* Active/current link */
.navbar a.active {
  background-color: #666;
  color: white;
}

/* Column container */
.row {  
  display: -ms-flexbox; /* IE10 */
  display: flex;
  -ms-flex-wrap: wrap; /* IE10 */
  flex-wrap: wrap;
}

/* Create two unequal columns that sits next to each other */
/* Sidebar/left column */
.side {
  -ms-flex: 30%; /* IE10 */
  flex: 30%;
  background-color: #f1f1f1;
  padding: 20px;
}

/* Main column */
.main {   
  -ms-flex: 70%; /* IE10 */
  flex: 70%;
  background-color: white;
  padding: 20px;
}

/* Fake image, just for this example */
.fakeimg-center {
  width: 100%;
  padding: 20px;
  display: block;
}
.fakeimg {
  background-color: white;
  width: 100%;
  padding: 20px;

}
.div1 {
  text-align: center;
  color: black
}

.div1 a{
  font-size: 30px;
  color: red;
  font-weight: bold;
  
}

/* Footer */

.p{
text-align: justify;
}
/* Responsive layout - when the screen is less than 700px wide, make the two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 700px) {
  .row {   
    flex-direction: column;
  }
}

/* Responsive layout - when the screen is less than 400px wide, make the navigation links stack on top of each other instead of next to each other */
@media screen and (max-width: 400px) {
  .navbar a {
    float: none;
    width: 100%;
  }
}



.header {
  padding: 80px;
  text-align: center;
  background: #f5b34c;
  color: black;
}
.footer-distributed{
	background-color: #292c2f;
	box-shadow: 0 1px 1px 0 rgba(0, 0, 0, 0.12);
	box-sizing: border-box;
	width: 100%;
	font: bold 16px sans-serif;
	text-align: left;

	padding: 50px 60px 40px;
	margin-top: 80px;
	overflow: hidden;
}

/* Footer left */

.footer-distributed .footer-left{
	float: left;
}

/* The company logo */

.footer-distributed h3{
	color:  #ffffff;
	font: normal 36px 'Cookie', cursive;
	margin: 0 0 10px;
}

.footer-distributed h3 span{
	color:  #5383d3;
}

/* Footer links */

.footer-distributed .footer-links{
	color:  #ffffff;
	margin: 0 0 10px;
	padding: 0;
}

.footer-distributed .footer-links a{
	display:inline-block;
	line-height: 1.8;
	text-decoration: none;
	color:  inherit;
}

.footer-distributed .footer-company-name{
	color:  #8f9296;
	font-size: 14px;
	font-weight: normal;
	margin: 0;
}

/* Footer social icons */

.footer-distributed .footer-icons{
	margin-top: 40px;
}

.footer-distributed .footer-icons a{
	display: inline-block;
	width: 35px;
	height: 35px;
	cursor: pointer;
	background-color:  #33383b;
	border-radius: 2px;

	font-size: 20px;
	color: #ffffff;
	text-align: center;
	line-height: 35px;

	margin-right: 3px;
	margin-bottom: 5px;
}

/* Footer Right */

.footer-distributed .footer-right{
	float: right;
}

.footer-distributed .footer-right p{
	display: inline-block;
	vertical-align: top;
	margin: 15px 42px 0 0;
	color: #ffffff;
}

/* The contact form */

.footer-distributed form{
	display: inline-block;
}

.footer-distributed form input,
.footer-distributed form textarea{
	display: block;
	border-radius: 3px;
	box-sizing: border-box;
	background-color:  #1f2022;
	box-shadow: 0 1px 0 0 rgba(255, 255, 255, 0.1);
	border: none;
	resize: none;

	font: inherit;
	font-size: 14px;
	font-weight: normal;
	color:  #d1d2d2;

	width: 400px;
	padding: 18px;
}

.footer-distributed ::-webkit-input-placeholder {
	color:  #5c666b;
}

.footer-distributed ::-moz-placeholder {
	color:  #5c666b;
	opacity: 1;
}

.footer-distributed :-ms-input-placeholder{
	color:  #5c666b;
}


.footer-distributed form input{
	height: 55px;
	margin-bottom: 15px;
}

.footer-distributed form textarea{
	height: 100px;
	margin-bottom: 20px;
}

.footer-distributed form button{
	border-radius: 3px;
	background-color:  #33383b;
	color: #ffffff;
	border: 0;
	padding: 15px 50px;
	font-weight: bold;
	float: right;
}

/* If you don't want the footer to be responsive, remove these media queries */

@media (max-width: 1000px) {

	.footer-distributed {
		font: bold 14px sans-serif;
	}

	.footer-distributed .footer-company-name{
		font-size: 12px;
	}

	.footer-distributed form input,
	.footer-distributed form textarea{
		width: 250px;
	}

	.footer-distributed form button{
		padding: 10px 35px;
	}

}

@media (max-width: 800px) {

	.footer-distributed{
		padding: 30px;
	}

	.footer-distributed .footer-left,
	.footer-distributed .footer-right{
		float: none;
		max-width: 300px;
		margin: 0 auto;
	}

	.footer-distributed .footer-left{
		margin-bottom: 40px;
	}

	.footer-distributed form{
		margin-top: 30px;
	}

	.footer-distributed form{
		display: block;
	}

	.footer-distributed form button{
		float: none;
	}
}

		.table {
		  display: table;
		 

		}
		
		.row {
		  display: table-row;
		}
		
		.cell {
		  display: table-cell;
		  padding: 10px;
		}
		
		.row:hover {
		  background-color: #cccccc;
		}
		
		.cell:hover {
		  background-color: #e5e5e5;
		}
				
		td {border: 1px #DDD solid; padding: 5px; cursor: pointer;}
				body {
		  font-family: Arial, Helvetica, sans-serif;
		  margin: 0;
		}

</style>

	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="keywords" content="footer, contact, form, icons" />
    <link rel="stylesheet" href="css/demo.css">
	<link rel="stylesheet" href="css/footer-distributed-with-contact-form.css">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
	<link href="http://fonts.googleapis.com/css?family=Cookie" rel="stylesheet" type="text/css">
<title>DODAJ DOKUMENT</title>
</head>
<body>
		<div class="header">
  <h1>Kreiranje dokumenta</h1>

  </div>
	<form action="sledeci" method="post" align="center"> 
	 Naziv dokumenta : ${dokument.getNazivDokumenta()} <br>
	Vrednost atributa ${atribut.getNazivAtributa()} (${atribut.getTip()}) je :<input type="text" name="vrednost"><br>
  	<input type="submit" value="sledeci">
	</form>
    <form action="documents1" method="post" align="center"> 
  	 <input type="submit" value="Vrati se na prikaz dokumenata i odustani od cuvanja vrednosti dokumenta">
	</form>
	<br>
	<br>
		  	  <table border="1" align="center">
		<thead>
			<tr>
				<th>Naziv atributa</th>
				<th>Vrednost</th>
				<th>Tip</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="vrednost" items="${odredjeneVrednosti}">
				<tr>
				<td>${vrednost.getTemplejtatributa().getNazivAtributa()}</td>
					<c:choose>
					   <c:when test="${vrednost.getVrednostInteger()!=0}"><td>${vrednost.getVrednostInteger()}</td></c:when> 
					   <c:when test="${vrednost.getVrednostDouble()!=0}"><td>${vrednost.getVrednostDouble()}</td></c:when> 
					   <c:when test="${vrednost.getVrednostString()!=null}"><td>${vrednost.getVrednostString()}</td></c:when> 
					   <c:otherwise><td>${vrednost.isVrednostBoolean()}</td></c:otherwise>   
					</c:choose> 		
				<td>${vrednost.getTemplejtatributa().getTip()}</td>	
					
	
				</tr>
			</c:forEach>
		</tbody>


	</table>
		<footer class="footer-distributed">

		<div class="footer-left">

				<p class="footer-company-name">Management Document System &copy; 2019</p>

				<div class="footer-icons">

					<a href="https://www.facebook.com"><i class="fa fa-facebook"></i></a>
					<a href="https://www.twitter.com"><i class="fa fa-twitter"></i></a>
					<a href="https://www.linkedin.com"><i class="fa fa-linkedin"></i></a>
					<a href="https://github.com/anajacimovic1995/ProjekatNST/"><i class="fa fa-github"></i></a>

				</div>

			</div>

		<div class="footer-right">

				<p>Kontakt forma</p>

				<form action="/ProjekatNST/" method="post">
					<input type="text" name="email" placeholder="Email" />
					<textarea name="message" placeholder="Message"></textarea>
					<button class="btn btn-lg btn-primary btn-block" type="submit">Posalji</button>
				</form>
			</div>
</footer>
</body>
</html>