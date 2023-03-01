<%@ include file="/vistas/cabecera.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>

<title>Insert title here</title>
</head>
<body>

 <form:form method="POST" 
          action="guardarPortatil" modelAttribute="portatil">
             <table>
                
                
                <tr>
                    <td><form:label path="marca">marca</form:label></td>
                    <td><form:input path="marca"/></td>
                </tr>
                
                <tr>
                    <td><form:label path="modelo">modelo</form:label></td>
                    <td><form:input path="modelo"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="guardarPortatil"/></td>
                </tr>
            </table>
        </form:form>

 <button onclick="history.back()">volver</button>
</body>
</html>
