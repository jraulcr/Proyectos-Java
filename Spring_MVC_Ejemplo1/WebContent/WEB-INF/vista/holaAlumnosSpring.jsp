<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/css/estilo.css"/>


<title>Insert title here</title>
</head>
<body>


Hola ${param.nombreAlumno }. Bienvenido al curso de Spring 

<br/>


<h2>Atención a todos</h2>

<p>
${mensajeClaro}

</p>






<img alt="foto" src="${pageContext.request.contextPath}/recursos/img/imagen.jpg">

</body>
</html>