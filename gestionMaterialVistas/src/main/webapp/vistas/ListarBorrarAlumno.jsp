<%@ include file="/vistas/cabecera.jsp" %>

<html>
  <head>
  <title>Lista de alumnos</title>
  </head>
  <body>
    <h1>Alumnos</h1>
     
    <c:forEach items="${modelo.listaAlumnos}" var="p">
      <c:out value="${p.nombre}"/> 
      <c:out value="${p.idAlumno}"/> 
      <c:out value="${p.portatil.id}"/> 
      <i><c:out value="${p.telefono}"/></i>
      <a href="eliminar?id_alumno=${p.idAlumno}">
      			<button type="button" onclick="confirmarAccesoURL()">eliminar alumno</button></a>
      <br><br>
    </c:forEach>
     <button onclick="history.back()">volver</button>
   <script> 
          //Cuadro de diálogo de confirmación en JavaScript
          function confirmarAccesoURL()
          {
	    return confirm("¿Está seguro que desea borrar?");
          }
	</script>
	
 </body>
</html>