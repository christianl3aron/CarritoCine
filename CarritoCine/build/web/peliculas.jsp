<%-- 
    Document   : cartelera.jsp
    Created on : 15-oct-2014, 15:22:44
    Author     : CHRISTIAN-LAP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html >
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="cabecera.jspf" %>
        <c:set var="suma" value="1"/>
    <center>
        <table width="1000">
            <tr>
                <td colspan="5"><h1><c:out value="${requestScope.titulo}"/></h1></td>
            </tr>
            <tr>
            
                <c:forEach items="${requestScope.listaCartelera}" var="pelicula">
                    <td align="center" >
                        
                        <a href="DetailServlet?codigo=<c:out value="${pelicula.codigo}"/>&obj=pelicula"><img src="<c:out value="${pelicula.img_1}"/>" alt="imagen no disponible"/></a><br>
                        <span class="pelicula"><c:out value="${pelicula.titulo}"/></span>
                    </td>
                    <c:if test="${suma%5==0}">
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
