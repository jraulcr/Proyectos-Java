<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>Formulario de bajas</title>
<% // Establecemos el contexto de la aplicación para utilizarlo en las redirecciones o enlaces
	String contexto = pageContext.getRequest().getServletContext().getContextPath();
%>

</head>

<body>
	<h1>Formulario de bajas</h1>
<!-- 	<form action="/DeleteServlet"> -->

<form action="<%=pageContext.getRequest().getServletContext().getContextPath() %>/DeleteServlet" method="post">
		<input name="form" value="deleteServlet" type="hidden"> 
		Nombre de la persona a borrar: <input name="nombre" type="text"><br>
		<button>Enviar</button>
	</form>
</body>
</html>