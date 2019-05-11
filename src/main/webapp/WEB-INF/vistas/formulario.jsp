<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Formulario</title>
<link href="css/gallo.css" rel="stylesheet" >
</head>
<body>
	<div class="recuadro">
        <form actions="agregar" method="POST"  modelAttribute="usuarioPersona">
          <div><input name="nombre" placeholder="Ingrese el Nombre" />
		  <input name="apellido" placeholder="Ingrese el Apellido" />     		  
		  </div>			
		  <button Type="Submit"/>Agregar</button>
        </form>
        <div class="limpia-float"></div>
        <a href="#">LISTAR</a>           
	</div>             
</body>
</html>