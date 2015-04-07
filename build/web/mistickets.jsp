<%-- 
    Document   : mistickets
    Created on : 25-oct-2014, 18:23:03
    Author     : CHRISTIAN-LAP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            // LA SEGURIDAD
            if (request.getSession(false)==null 
                    || request.getSession().getAttribute("usuario")==null ){
                response.sendRedirect("index.jsp");
                return;
            }
        %>
    </head>
    <body>
        <%@include file="cabecera.jspf" %>

    <center>
        <table class="cebra" width="1000">
            <thead>
            <th colspan="2">Pelicula</th>
            <th>Cine</th>
            <th>Sala N°</th>
            <th>Fecha de la funcion</th>
            <th>Cantidad </th>
            </thead>
            <c:forEach items="${requestScope.listaCompras}" var="compra">
                <tr>
                    <td  colspan="2" align="center">
                        <c:out value="${compra.funcionBean.peliculaFDBean.titulo}"/>
                    </td>
                    <td align="center">
                        <c:out value="${compra.funcionBean.salaBean.cineBean.nombre}"/>
                    </td><td align="center">
                        <c:out value="${compra.funcionBean.salaBean.numSala}"/>
                    </td>
                    <td align="center">
                        <c:out value="${compra.funcionBean.inicio}"/>
                    </td>
                    <td align="center">
                        <c:out value="${compra.cantidad}"/>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </center>

</body>
</html>
