<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	    <link href="css/gallo.css" rel="stylesheet" >
	</head>
	<body>
				<form:form action="registro-usuario" method="POST" modelAttribute="agregarusuario">
				  	<input name="nombre" placeholder="Ingrese el nombre" />
					<input name="apellido" placeholder="Ingrese el apellido" />
					<input name="dni" placeholder="Ingrese el dni" />

				
					<button Type="Submit"/>Agregar Usuario</button>
				</form:form>
				
				<a href="/proyecto-limpio-spring/lista-final">Obtener un listado</a>
	</body>
</html>
