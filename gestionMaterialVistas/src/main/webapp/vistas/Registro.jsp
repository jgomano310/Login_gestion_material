<%@ include file="/vistas/cabecera.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1>Registroo</h1>
	<form:form method="POST" action="guardarUsuario"
		modelAttribute="usuario">
		<table>
			<tr>
				<td><form:label path="nombre">Nombre</form:label></td>
				<td><form:input path="nombre" required="required"/></td>
			</tr>
			<tr>
				<td><form:label path="apellidos">Apellidos</form:label></td>
				<td><form:input path="apellidos" required="required" /></td>
			</tr>
			<tr>
				<td><form:label path="email">Email</form:label></td>
				<td><form:input path="email" required="required"/></td>
			</tr>
			<tr>
				<td><form:label path="nombreUsuario">Nombre de usuario</form:label></td>
				<td><form:input path="nombreUsuario" required="required"/></td>
			</tr>
			<tr>
				<td><form:label path="password">Contraseña</form:label></td>
				<td><form:input path="password" required="required"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Guardar" /></td>
			</tr>
		</table>
	</form:form>
	<br>
	<br>
	

</body>
</html>