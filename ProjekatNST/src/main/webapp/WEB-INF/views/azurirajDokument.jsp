<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page isELIgnored="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Azuriraj</title>
</head>
<body>
        <form:form method="POST" action="azurirajDokument" modelAttribute="dokument">
        
        	<form:hidden path="DokumentID" /> 
             <table>
                <tr>
                    <td><form:label path="NazivDokumenta">Naziv</form:label></td>
                    <td><form:input path="NazivDokumenta"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
            
        </form:form>
			  	  <table border="1">
		<thead>
			<tr>
				<th>Naziv atributa</th>
				<th>Vrednost</th>
				<th>Tip</th>
				<th>Edit</th>
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
					
				<td><a
						href="${pageContext.request.contextPath}/azurirajVrednostDokumenta/${vrednost.getVrednostID()}">EDIT</a></td>
					
				</tr>
			</c:forEach>
		</tbody>


	</table>
	<form action="documents" method="post">
		<p><input type="submit" value="Vrati se na listu dokumenta"/></p>
	</form>
</body>
</html>