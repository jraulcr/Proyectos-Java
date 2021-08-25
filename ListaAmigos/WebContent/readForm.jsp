<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>Formulario de consultas</title>

</head>


<body>
	<h1>Formulario de consultas</h1>


<form action="<%=pageContext.getRequest().getServletContext().getContextPath() %>/ReadServlet" method="post">

	
		<input name="form" value="readServlet" type="hidden"> 
		
		Nombre de la persona a buscar: <input name="nombre" type="text"><br>
		<button>Enviar</button>
	</form>
</body>
</html>