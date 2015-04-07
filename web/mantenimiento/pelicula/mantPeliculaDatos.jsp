<%-- 
    Document   : mantPeliculaDatos
    Created on : 14-oct-2014, 13:32:08
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
        <%@include file="../../cabecera.jspf" %>
        <c:set var="pelicula" value="${requestScope.peliculaFD}"/>
        <script src="js/PeliculaValidator.js" type="text/javascript"></script>
    <center>
        <form class="navy" action="PeliculaFDServlet" method="post">
            <fieldset style="text-align: left">
                <legend>Datos de Pelicula</legend>
                <label for="txtTitulo">Titulo:</label>
                <input type="text" name="txtTitulo" id="txtTitulo" value="<c:out value="${pelicula.titulo}"/>" onkeydown="return isText(event);"/><br>

                <label for="txtDuracion">Duracion:</label>
                <input type="number" name="txtDuracion" id="txtDuracion" value="<c:out value="${pelicula.duracion}"/>" min="0" max="200"/><br>

                <label for="txtActores">Actores:</label>
                <TEXTAREA Name="txtActores" rows="4" cols="100" id="txtActores" onkeydown="return isText(event);"><c:out value="${pelicula.actores}"/></TEXTAREA> </br>

                <label for="txtSinopsis">Sinopsis:</label>
                <TEXTAREA Name="txtSinopsis" rows="4" cols="100" id="txtSinopsis" onkeydown="return isText(event);"><c:out value="${pelicula.sinopsis}"/></TEXTAREA>

                <label for="txtPais">Pais de Origen:</label>
                <input type="text" name="txtPais" id="txtPais" value="<c:out value="${pelicula.paisOrigen}"/>" onkeydown="return isText(event);"/><br>

                <label for="txtDirector">Director:</label>
                <input type="text" name="txtDirector" id="txtDirector" value="<c:out value="${pelicula.director}"/>" onkeydown="return isText(event);"/><br>

                <label for="txtTrailer">Trailer:</label>
                <input type="input" name="txtTrailer" id="txtTrailer" value="<c:out value="${pelicula.trailer}"/>"/></br>

                <label for="txtImgPortada">Imagen Portada:</label>
                <input type="file" name="txtImgPortada" id="txtImgPortada" value="<c:out value="${pelicula.img_portada}"/>"/></br>

                <label for="txtImagen1">Imagen 1:</label>
                <input type="file" name="txtImagen1" id="txtImagen1" value="<c:out value="${pelicula.img_1}"/>"/></br>

                <label for="txtImagen2">Imagen 2:</label>
                <input type="file" name="txtImagen2" id="txtImagen2" value="<c:out value="${pelicula.img_2}"/>"/></br>

                <label for="txtImagen3">Imagen 3:</label>
                <input type="file" name="txtImagen3" id="txtImagen3" value="<c:out value="${pelicula.img_3}"/>"/></br>

                <label for="txtImagen4">Imagen 4:</label>
                <input type="file" name="txtImagen4" id="txtImagen4" value="<c:out value="${pelicula.img_4}"/>"/></br>


                <label for="txtFecha">Fecha de estreno:</label>
                <c:choose>
                    <c:when test="${not empty pelicula.fechaEstreno}"><input type="date" name="txtFecha" id="txtFecha" value="<c:out value="${pelicula.fechaEstreno}"/>" min="<c:out value="${pelicula.fechaEstreno}"/>"/></c:when>
                    <c:otherwise><input type="date" name="txtFecha" id="txtFecha" value="<c:out value="${requestScope.today}"/>" min="<c:out value="${requestScope.today}"/>"/></c:otherwise>
                </c:choose>
                <br>
                <select id="cmbTipo" name="cmbTipo">

                    <c:forEach items="${requestScope.listaTipo}" var="tipo">
                        <c:if test="${tipo.denominacion == pelicula.genero}">
                            <option value="<c:out value="${tipo.codigo}"/>" selected><c:out value="${tipo.denominacion}"/></option>
                        </c:if>
                        <c:if test="${tipo.denominacion != pelicula.genero}">
                            <option value="<c:out value="${tipo.codigo}"/>"><c:out value="${tipo.denominacion}"/></option>
                        </c:if>
                    </c:forEach>

                    <input type="hidden" name="accion" value="<%= request.getAttribute("tipoGrabacion")%>" />
                    <input type="hidden" name="codigoPar" value="<c:out value="${pelicula.codigo}"/>" />

                    <input type="submit" value="Grabar" onclick="return validar()"/>
            </fieldset>
        </form>
    </center>
    <br>
    <% if (request.getAttribute("mensajeError") != null) {%>
    <b><font color="red"> <%= request.getAttribute("mensajeError")%> 
        </font></b>
        <% }%>


</body>
</html>
