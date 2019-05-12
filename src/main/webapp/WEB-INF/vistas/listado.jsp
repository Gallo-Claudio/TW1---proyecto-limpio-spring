<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<title>Listado</title>
<link href="css/gallo.css" rel="stylesheet" >
</head>
<body>
	<p>Hola ${listadop}</p>

	<table border="1" cellpadding="1" cellspacing="0">
	<thead>
	<tr>
	<th>Nombre</th>
	<th>Apellido</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="persona" items="${listadop}"> 
		<tr>
		<td>${persona.nombre}</td>
		<td>${persona.apellido}</td>
		</tr>
    </c:forEach>  
	</tbody>
	</table>   	     
</body>
</html>