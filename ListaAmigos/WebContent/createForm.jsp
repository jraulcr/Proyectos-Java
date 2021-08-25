<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%@page import="javaee.amigos.model.Amigo"%>
	<%@page import="java.util.ArrayList"%>
	<%@page import="javaee.amigos.dao.DAOFactory"%>
<%@page import="javaee.amigos.dao.IAmigoDAO"%>	
	
	
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Formulario de altas</title>
<% 


// Establecemos el contexto de la aplicación para utilizarlo en las redirecciones o enlaces
	String contexto = pageContext.getRequest().getServletContext().getContextPath();


%>

</head>


<body>
	<h1>Formulario de altas</h1>
<!--  	<form action="<%=contexto%>/CreateServlet" method="post">   -->

<!-- 	<form action="successForm.jsp" method="post"> -->

<form action="<%=pageContext.getRequest().getServletContext().getContextPath() %>/CreateServlet" method="post">	

		<input name="form" value="createServlet" type="hidden">
		Nombre: <input name="nombre" value="" type="text"><br>
		Dirección: <input name="direccion" value="" type="text"><br>
		Teléfono: <input name="telefono" value="" type="text"><br>
		Edad: <input name="edad" value="" type="text"><br> 
		Nivel de amistad: <select name="nivelAmistad">
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
		Comentarios: <textarea name="comentarios" rows="4" cols="20"></textarea><br>
		
<button>Enviar</button>
<!-- 		 <input type="submit" name="registrar" value="Enviar" /> -->
	</form>
</body>
</html>