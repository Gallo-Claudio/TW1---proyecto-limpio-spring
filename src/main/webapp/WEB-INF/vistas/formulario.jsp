<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<title>Formulario</title>
<link href="css/gallo.css" rel="stylesheet" >
</head>
<body>
	<div class="recuadro">
        <form:form actions="formulario" method="POST" modelAttribute="usuarioPersona">  <%-- Terminar de preguntar que valor debe ir en actions porque funciona hasta estando vacio--%>
          <div>
          <input name="nombre" id="nombre" placeholder="Ingrese el Nombre" />
		  <input name="apellido" id="apellido" placeholder="Ingrese el Apellido" />     		  
		  </div>			
		  <button Type="Submit"/>Agregar</button>
        </form:form>
        <div class="limpia-float"></div>
        <a href="/proyecto-limpio-spring/listado">LISTAR</a>           
	</div>             
</body>
</html>