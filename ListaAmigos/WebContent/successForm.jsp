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
<title>Operación realizada con éxito</title>


</head>

<body>
	<jsp:useBean id="amigo" class="javaee.amigos.model.Amigo" scope="session"/>
	<jsp:setProperty property="*" name="amigo"/>

	<h1>Operación realizada con éxito</h1>
	
	<% 
	
// 	String nombre = request.getParameter("nombre");	
// 	String direccion = request.getParameter("direccion");
// 	String telefono = request.getParameter("telefono");
// 	int edad = Integer.parseInt(request.getParameter("edad"));
// 	int nivelAmistad = Integer.parseInt(request.getParameter("nivelAmistad"));
// 	String comentarios = request.getParameter("comentarios");	
	
	
	
	%>
	

	
	
	<h2>Los datos del amigo recibidos son:</h2><br>
		Nombre: <jsp:getProperty property="nombre" name="amigo"/><br>
		Dirección: <jsp:getProperty property="direccion" name="amigo"/><br>
		Teléfono: <jsp:getProperty property="telefono" name="amigo"/><br>
		Edad: <jsp:getProperty property="edad" name="amigo"/><br> 
		Nivel de amistad: <jsp:getProperty property="nivelAmistad" name="amigo"/> <br> 
		Comentarios: <textarea name="comentarios" rows="4" cols="20">
		<jsp:getProperty property="comentarios" name="amigo"/>
		</textarea><br>
	<a href="index.jsp">Volver al menú principal</a>
</body>
</html>