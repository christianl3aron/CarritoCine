<%-- 
    Document   : cines
    Created on : 16-oct-2014, 15:56:34
    Author     : CHRISTIAN-LAP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="cabecera.jspf" %>
        <c:set var="suma" value="1"/>

    <center>
        <table id="tabCine">
            <tr>
                <td colspan="3">
                    <h1><c:out value="${requestScope.titulo}"/></h1>
                </td>
            </tr>
            <tr>
                <c:forEach items="${requestScope.listaCine}" var="cine">
                    <td style="height: 300px;text-align: center;background-color: #7A7DFF;padding-left: 15px;padding-right: 15px">
                        <a href="DetailServlet?codigo=<c:out value="${cine.codigo}"/>&obj=cine"><img src="<c:out value="${pelicula.imagen}"/>" alt="imagen no disponible" width="300" height="200"/></a><br>
                        <span style="color: #ffffff;font: bold 15px Verdana,Geneva,sans-serif;padding: 0;margin: 0">
                            <c:out value="${cine.nombre}"/>
                        </span><br>
                        <span style="color: #ffffff;font: bold 10px Verdana,Geneva,sans-serif;padding: 0;margin: 0">
                            <c:out value="${cine.direccion}"/>
                        </span>
                    </td>
                    <c:if test="${suma%3==0}">
                    </tr>
                    <tr>
                    </c:if>
                    <c:set var="suma" value="${suma + 1}"/>
                </c:forEach>

            </tr>
        </table>
    </center>
</body>
</html>
