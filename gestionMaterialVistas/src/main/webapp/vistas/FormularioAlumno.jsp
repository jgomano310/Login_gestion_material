<%@ include file="/vistas/cabecera.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>

<title>Insert title here</title>
</head>
<body>

 <form:form method="POST" 
          action="guardarAlumno" modelAttribute="alumno">
             <table>
                
                
                <tr>
                    <td><form:label path="nombre">nombre</form:label></td>
                    <td><form:input path="nombre"/></td>
                </tr>
                
                <tr>
                    <td><form:label path="telefono">telefono</form:label></td>
                    <td><form:input path="telefono"/></td>
                </tr>
                
               
                <tr>
                    <td><input type="submit" value="guardarAlumno"/></td>
                </tr>
            </table>
        </form:form>
        
       <button onclick="history.back()">volver</button>
     

</body>
</html>
