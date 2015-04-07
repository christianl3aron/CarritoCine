<%-- 
    Document   : mantFuncionDatos
    Created on : 18-oct-2014, 12:31:18
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
        <script src="js/ajax/MantFuncionAjax.js" type="text/javascript"></script>
        <script src="js/FuncionValidator.js" type="text/javascript"></script>
    <center>
        <table border="0" style="width: 1000px; table-layout: fixed">
            <tr>

                <td style="width: 333px;height: 200px;padding: 0;text-align: center">
                    <div style="background-color: #F2F2F2;margin: auto;width: 300px;height: 180px">
                        <form class="navy" action="FuncionServlet" method="post">
                            <label for="cmbPelicula">Pelicula:</label>
                            <select id="cmbPelicula" name="cmbPelicula">
                                <option value="0" selected>Seleccione una pelicula</option>
                                <c:forEach items="${requestScope.listaPelicula}" var="pelicula">
                                    <option value="<c:out value="${pelicula.codigo}"/>"><c:out value="${pelicula.titulo}"/></option>
                                </c:forEach>
                            </select><br>

                            <label for="cmbCine">Cine:</label>
                            <select id="cmbCine" name="cmbCine">
                                <option value="0">Seleccione un Cine</option>

                                <c:forEach items="${requestScope.listaCine}" var="cine">
                                    <option value="<c:out value="${cine.codigo}"/>"><c:out value="${cine.nombre}"/></option>
                                </c:forEach>
                            </select><br>

                            <label for="cmbSala">Sala:</label>
                            <select id="cmbSala" name="cmbSala">
                                <option value="0" selected>Seleccione una sala</option>
                            </select><br>
                            <label for="txtPrecio">Precio:</label>
                            <input type="number" name="txtPrecio" id="txtPrecio"  min="1" value="11"/><br>
                            <input type="datetime-local" name="time" id="time" value="<c:out value="${requestScope.today}"/>" min="<c:out value="${requestScope.today}"/>"/>
                            <br>
                            <input type="submit" value="insgrabar" name="accion" onclick="return validar()"/>

                        </form>
                    </div>

                </td>
                <td rowspan="2" style="text-align: center;padding: 0">
                    <div id="divListaFunciones" style="height: 580px;width: 640px;background-color: #F2F2F2;margin: auto">


                    </div>
                </td>
            </tr>
            <tr>
                <td style="height: 400px;text-align: center;padding: 0">
                    <div id="divDetailPelicula" style="width: 300px;height: 380px;background-color: #F2F2F2;margin: auto">

                    </div>
                </td>
            </tr>


        </table>


        <br>
        <% if (request.getAttribute("mensajeError") != null) {%>
        <b><font color="red"> <%= request.getAttribute("mensajeError")%> 
            </font></b>
            <% }%>
    </center>
</body>

</html>
