<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%@page import="javaee.amigos.model.Amigo"%>
	<%@page import="java.util.ArrayList"%>
	<%@page import="javaee.amigos.dao.DAOFactory"%>
<%@page import="javaee.amigos.dao.IAmigoDAO"%>	
	
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulario de actualizaci�n</title>


<% 


// Establecemos el contexto de la aplicaci�n para utilizarlo en las redirecciones o enlaces
	String contexto = pageContext.getRequest().getServletContext().getContextPath();


%>
</head>


<body>
	<h1>Formulario de actualizaci�n</h1>
<!-- 	<form action="../UpdateServlet"> -->



<form action="<%=contexto%>/UpdateServlet" method="post">

		<input name="form" value="amigo" type="hidden">
		 
		Nombre anterior: <input name="nombreAnterior"type="text"><br>
		
		Nuevo nombre: <input name="nombre" type="text" value="<%=%>"><br>
		Nueva direcci�n <input name="direccion" type="text"><br>
		Nuevo tel�fono: <input name="telefono" type="text"><br>
		Nueva edad: <input name="edad" type="text"><br>
		Nuevo nivel de amistad: <select name="nivelAmistad">
			<option>1</option>
			<option>2</option>
			<option>3</option>
			<option>4</option>
			<option>5</option>
			<option>6</option>
			<option>7</option>
			<option>8</option>
			<option>9</option>
			<option>10</option>
		</select> <br> 
		Nuevos comentarios:	<textarea name="comentarios" rows="4" cols="20"> </textarea><br>
		<button>Enviar</button>
	</form>
</body>
</html>