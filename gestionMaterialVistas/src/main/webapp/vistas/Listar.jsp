<%@ include file="/vistas/cabecera.jsp" %>

<html>
  <head>
  <title>Lista de port�tiles:</title>
  </head>
  <body>
    <h1>port�tiles</h1>
     
    <c:forEach items="${modelo.listaPortatiles}" var="portatil">
      <c:out value="${portatil.id}"/> 
      <c:out value="${portatil.marca}"/> 
      <i><c:out value="${portatil.modelo}"/></i>
      <br><br>
    </c:forEach>
	<a href="<c:url value="Formulario"/>">vamos al formulario</a>
 </body>
</html>