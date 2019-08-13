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

</body>
</html>