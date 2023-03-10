<%@ include file="/vistas/cabecera.jsp"%>

<html>
<head>
<title>index</title>
</head>
<body>
<a href="<c:url value="Formulario"/>">Insertar Portatil</a><br>
<a href="<c:url value="FormularioAlumno"/>">Insertar Alumno</a><br>
<a href="<c:url value="ListarBorrarAlumno"/>">listar alumno y borrar</a><br>
<a href="<c:url value="listarAlumnoPorIdPortatil"/>">listar alumno por id de portatil</a><br>
<a href="<c:url value="listarPortatilPorid"/>">listar portatil por id de alumno</a><br>
<a href="<c:url value="login"/>">loguearse</a><br>
<a href="<c:url value="registro"/>">registro</a><br>


</body>
</html>