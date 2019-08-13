<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DODAJ DOKUMENT</title>
</head>
<body>
	
	<form action="sledeci" method="post"> 
	 Naziv dokumenta : ${dokument.getNazivDokumenta()} <br>
	Vrednost atributa ${atribut.getNazivAtributa()} (${atribut.getTip()}) je :<input type="text" name="vrednost"><br>
  	<input type="submit" value="sledeci">
	</form>
    <form action="documents" method="post"> 
  	 <input type="submit" value="Vrati se na prikaz dokumenata i odustani od cuvanja vrednosti dokumenta">
	</form>
		  	  <table border="1">
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
</body>
</html>