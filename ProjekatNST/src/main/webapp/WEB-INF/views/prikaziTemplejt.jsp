<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Templejt</title>
</head>
<body>
	
	<form action="report" method="post"> 
	 Naziv dokumenta <input type="text" name="imeDokumenta"><br>
	<c:forEach items="$noviDokument.getVredosti()" var="vrednost">
		<c:forEach items="${listaVeza}" var="veza">
		  ${veza.getTemplejtAtr().getNazivAtributa()} <input type="text" name = "atribut"><br>		  
	  	</c:forEach>	  	
  	</c:forEach> 
  	<input type="submit" value="Report">
	</form>
</body>
</html>