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
<title>Dokument</title>
</head>
<body>
	<form action="documents1" method="post"> 
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