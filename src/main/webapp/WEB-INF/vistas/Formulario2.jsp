<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tarea</title>
</head>
<body>
		
		<h1>Formulario</h1>
		<form modelAttribute="Persona" action="GuardarDatos" method="Post">
		
		<input type="text" path="nombre" name="nombre" placeholder="Ingrese nombre">
		<input type="text" path="apellido" name="apellido" placeholder="Ingrese apellido">
		
		<input type="submit" name="Agregar" value="Agregar"></input>
		
		</form>

<form action="Mostrar" method="post">
<br>
<input type="submit" name="Mostrar" value="Mostrar Guardados"/>

</form>
<br><br>


</body>
</html>