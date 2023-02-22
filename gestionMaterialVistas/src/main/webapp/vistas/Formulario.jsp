<%@ include file="/vistas/cabecera.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>

<title>Insert title here</title>
</head>
<body>

 <form:form method="POST" 
          action="guardarAlumno" modelAttribute="portatil">
             <table>
                <tr>
	
                    <td><form:label path="md_uuid">md_uuid</form:label></td>
                    <td><form:input path="md_uuid"/></td>
                </tr>
                <tr>
                    <td><form:label path="md_date">md_date</form:label></td>
                    <td><form:input path="md_date"/></td>
                </tr>
                
                <tr>
                    <td><form:label path="marca">marca</form:label></td>
                    <td><form:input path="marca"/></td>
                </tr>
                
                <tr>
                    <td><form:label path="modelo">modelo</form:label></td>
                    <td><form:input path="modelo"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="guardarAlumno"/></td>
                </tr>
            </table>
        </form:form>

</body>
</html>
