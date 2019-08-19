<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>

   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

   <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" type="text/css" rel="stylesheet">
   <link href='http://fonts.googleapis.com/css?family=Stint+Ultra+Condensed' rel='stylesheet' type='text/css'>
   <link href='http://fonts.googleapis.com/css?family=Bevan' rel='stylesheet' type='text/css'>
   <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
 
   <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
   <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.16.0/jquery.validate.min.js"></script>
   <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
	<meta charset="ISO-8859-1">
<title>Kreiraj templejt i atribute</title>
</head>
<body>
	<form action="dodajAtribut" method="post">
		  Naziv: <input type="text" name="name"><br>
		  Tip: <select id = "tip" name = "tip">
					   <option value = "NONE">Select</option>
					   <option value = "String">String</option>
					   <option value = "Double">Double</option>
					   <option value = "Integer">Integer</option>
					   <option value = "Boolean">Boolean</option>
					</select>  <br>
		  Obavezan(Ukoliko jeste upisati 0, ukoliko nije upisati 1): <input type="text" name="required"><br>
		  <input type="submit" value="Sacuvaj atribut">

	  </form>
	  <form action="documents1" method="post">

		  <input type="submit" value="Vrati se na listu dokumenata/ Gotovo kreiranje">

	  </form>
	  <table border="1">
		<thead>
			<tr>
				<th>Naziv</th>
				<th>Tip</th>
				<th>Delete</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="atribut" items="${atributList}">
				<tr>
					<td>${atribut.getNazivAtributa()}</td>
					<td>${atribut.getTip()}</td>
					<td><a
						href="${pageContext.request.contextPath}/izbrisiAtribut/${atribut.getTemplejtAtributaID()}">DELETE</a></td>
					
				</tr>
			</c:forEach>
		</tbody>


	</table>
</body>
</html>