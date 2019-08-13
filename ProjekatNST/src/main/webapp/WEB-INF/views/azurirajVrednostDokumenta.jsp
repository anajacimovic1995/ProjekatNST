<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
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

    <form action="documents" method="post"> 
  	 <input type="submit" value="Vrati se na prikaz dokumenata i odustani od cuvanja vrednosti dokumenta">
	</form>
</body>
</html>