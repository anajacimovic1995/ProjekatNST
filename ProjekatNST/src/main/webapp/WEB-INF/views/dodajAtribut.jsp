<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
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
	  <form action="documents" method="post">

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