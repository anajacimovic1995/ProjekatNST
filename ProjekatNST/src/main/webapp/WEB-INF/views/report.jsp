<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dokument</title>
</head>
<body>
	<form action="documents" method="post"> 
		<p> Dokument je uspesno sacuvan! </p>
		<p> Unete vrednosti za dokument ${Dokument.getNazivDokumenta()} su: </p>
		   <c:forEach items="${lista}" var="vrednost">
				<c:choose>
				   <c:when test="${vrednost.getVrednostInteger()!=0}">Za atribut ${vrednost.getTemplejtatributa().getNazivAtributa()} vrednost je ${vrednost.getVrednostInteger()}.</c:when> 
				   <c:when test="${vrednost.getVrednostDouble()!=0}">Za atribut ${vrednost.getTemplejtatributa().getNazivAtributa()} vrednost je ${vrednost.getVrednostDouble()}.</c:when> 
				   <c:when test="${vrednost.getVrednostString()!=null}">Za atribut ${vrednost.getTemplejtatributa().getNazivAtributa()} vrednost je ${vrednost.getVrednostString()}.</c:when> 
				   <c:otherwise>Za atribut ${vrednost.getTemplejtatributa().getNazivAtributa()} vrednost je ${vrednost.isVrednostBoolean()}.</c:otherwise>   
				</c:choose> 
				<br>
		  	</c:forEach>   		
	
	  	<p><input type="submit" value="Vrati se na listu dokumenta"/></p>
	</form>
</body>
</html>