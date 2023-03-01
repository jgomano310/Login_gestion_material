<%@ include file="/vistas/cabecera.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>

<title>Insert title here</title>
</head>
<body>

 <form:form method="POST" 
          action="guardarAlumnoporId" modelAttribute="portatil">
             <table>
                
                
                <tr>
                    <td><form:label path="id">identificador</form:label></td>
                    <td><form:input path="id"/></td>
                </tr>
                
                
               
                <tr>
                    <td><input type="submit" value="Guardar"/></td>
                </tr>
            </table>
        </form:form>
         <button onclick="history.back()">volver</button>
        
     

</body>
</html>
