<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
<title>Azuriraj vrednost dokumenta</title>
</head>
<body>
	  <form:form method="POST" action="azurirajVrednostDokumenta" modelAttribute="vrednost">
       
        	<form:hidden path="VrednostID" /> 
             <table>
             	<c:choose>
					   <c:when test="${vred.getVrednostInteger()!=0}">
					   <tr>
		                    <td><form:label path="VrednostInteger">Vrednost (Integer) : </form:label></td>
		                    <td><form:input path="VrednostInteger"/></td>
		               </tr></c:when> 
		               
					   <c:when test="${vred.getVrednostDouble()!=0}">
					   <tr>
		                    <td><form:label path="VrednostDouble">Vrednost (Double) : </form:label></td>
		                    <td><form:input path="VrednostDouble"/></td>
		               </tr></c:when> 
					   <c:when test="${vred.getVrednostString()!=null}"> 
					   <tr>
		                    <td><form:label path="VrednostString">Vrednost (String)</form:label></td>
		                    <td><form:input path="VrednostString"/></td>
		                </tr></c:when>
                
					   <c:otherwise><tr>
		                    <td><form:label path="VrednostBoolean">Vrednost (Boolean)</form:label></td>
		                    <td><form:input path="VrednostBoolean"/></td>
		                </tr></c:otherwise>   
					</c:choose> 

                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
            
        </form:form>

    <form action="documents1" method="post"> 
  	 <input type="submit" value="Vrati se na prikaz dokumenata i odustani od cuvanja vrednosti dokumenta">
	</form>
</body>
</html>