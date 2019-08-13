<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Prikaz dokumenata</title>
	<style>
		table, th, td {
		  border: 1px solid black;
		}
	</style>
</head>
<body>
	<br>

	<h3>Prikaz svih dokumenata</h3>

	<table border="1">
		<thead>
			<tr>
				<th>Naziv</th>
				<th>Templejt</th>
				<th>Kompanija</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="dokument" items="${dokumentList}">
				<tr>
					<td>${dokument.getNazivDokumenta()}</td>
					<td>${dokument.getTemplejt().getNazivTemplejta()}</td>
					<td>${dokument.getKompanija().getImeKompanije()}</td>
					<td><a
						href="${pageContext.request.contextPath}/azurirajDokument/${dokument.getDokumentID()}">Edit</a></td>
					<td><a
						href="${pageContext.request.contextPath}/izbrisiDokument/${dokument.getDokumentID()}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>


	</table>
		<br>
		<p>Kreiraj novi dokument</p>
	 <form action="dodajDokument" method="post">
	  Unesi ime novog dokumenta: <input type="text" name="dokument"><br>
	  	   Unesi ime templejt dokumenta: <br>
	  <select id = "temp" name = "templejt">
	  <c:forEach var = "temp" items = "${templejtList}">
	  		   <option value = "${temp.getNazivTemplejta()}">${temp.getNazivTemplejta()}</option>

	  </c:forEach>
	  	 </select><br>
	  <input type="submit" value="Sacuvaj dokument i dodaj vrednosti">
	 </form>

		<p>Izaberi ili kreiraj novi templejt</p>
	<form action="dodajTemplejt" method="post">
      Izaberi templejt: <br>
      <select id = "temp" name = "name">
      					<option value = "Novi Templejt">Novi Templejt</option>
	  <c:forEach var = "temp" items = "${templejtList}">
	  	

					   <option value = "${temp.getNazivTemplejta()}">${temp.getNazivTemplejta()}</option>

	  </c:forEach> 
	  </select> <br>
	  Unesi ime novog templejta: <input type="text" name="noviTemplejt"><br>
	  <input type="submit" value="Sacuvaj templejt i kreiraj atribute">
	 </form>

	<br>
</body>
</html>