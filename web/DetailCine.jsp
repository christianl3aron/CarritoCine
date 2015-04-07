<%-- 
    Document   : DetailCine
    Created on : 19-oct-2014, 13:11:04
    Author     : CHRISTIAN-LAP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cine</title>
    </head>
    <body>
        <%@include file="cabecera.jspf" %>
        <script src="js/ajax/DetailCineAjax.js" type="text/javascript"></script>


        <c:set var="pelicula" value="${requestScope.peliculaFD}"/>
        <input type="hidden" value="<c:out value="${requestScope.cineBean.codigo}"/>" id="codCine">
    <center>
        <table id="tdetcine">
            <tr>
                <td><h1><c:out value="${requestScope.cineBean.nombre}"/></h1></td>
            </tr>
            <tr>
                <td><h5><c:out value="${requestScope.cineBean.direccion}"/></h5></td>
            </tr>
            <tr>
                <td><h4>la cartelera en este cine</h4></td>
            </tr>
            <tr>
                <td id="diaButtons">
                    <a id="hoy" href="#" class="diaButton">Hoy</a>&nbsp;<a id="man" href="#" class="diaButton">Mañana</a>&nbsp;<a id="pas" href="#" class="diaButton">Pasado</a>
                </td>
            </tr>
        </table>

        <div id="divListaPeliculas">
            <c:forEach items="${requestScope.listaPelicula}" var="pelicula">          
                <table>
                    <tr>
                        <td width="200" rowspan="4">
                            <div style="margin: auto;text-align: center">
                                <img src="<c:out value="${pelicula.img_1}"/>" alt="imagen no disponible" width="140px"/>
                            </div>
                        </td>
                        <td colspan="3" width="600" height="50" class="headlight">
                            <c:out value="${pelicula.titulo}"/><br>
                            <c:out value="${pelicula.duracion}"/>
                        </td>
                        <td height="50" class="headlight">
                            <a href="DetailServlet?codigo=<c:out value="${pelicula.codigo}"/>&obj=pelicula" class="peldetail">ver detalle de la pelicula</a>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="4" class="funciones">
                            <c:forEach items="${requestScope.listaFuncion}" var="funcion"> 
                                <c:if test="${funcion.peliculaFDBean.codigo == pelicula.codigo}">
                                    <a href="<c:choose>
                                           <c:when test="${sessionScope.usuario != null}">CompraServlet?accion=agregar&codFuncion=<c:out value="${funcion.codigo}"/></c:when>
                                           <c:otherwise>login.jsp</c:otherwise>
                                       </c:choose>" class="comprar"><c:out value="${funcion.inicio}"/></a>
                                </c:if>
                            </c:forEach>
                        </td>
                    </tr>
                </table>
            </c:forEach>
        </div>
    </center>
</body>
</html>
