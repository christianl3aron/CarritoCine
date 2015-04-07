<%-- 
    Document   : compra
    Created on : 21-oct-2014, 14:05:10
    Author     : CHRISTIAN-LAP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tus Entradas Ya!!</title>
        <%
            if (request.getSession(false) == null
                    || request.getSession().getAttribute("usuario") == null) {
                response.sendRedirect("index.jsp");
                return;
            }
        %>
    </head>
    <body>
        <%@include file="cabecera.jspf" %>
        <script src="js/CompraUpdater.js" type="text/javascript"></script>
        <c:set var="funcion" value="${requestScope.funcionBean}"/>

        <form action="CompraServlet" method="post">
            <center>
                <table border="1" width="1000" style="table-layout:fixed">
                    <tr>
                        <th colspan="4">Pelicula</th>
                        <th>Precio</th>
                        <th>Cantidad</th>
                        <th colspan="2">Total</th>
                        <th colspan="2">Resumen de compra</th>
                    </tr>
                    <tr>
                        <td colspan="4" style="vertical-align:top;text-align: center">
                            <c:out value="${funcion.peliculaFDBean.titulo}"/>
                        </td>
                        <td style="vertical-align:top;text-align: center">
                            <c:out value="${funcion.precio}"/>
                            <input type="hidden" id="hdPrecio" value="<c:out value="${funcion.precio}"/>"/>
                        </td>
                        <td style="vertical-align:top;text-align: center">
                            <input type="number" min="1" max="200" id="cantidad" name="cantidad" value="1"/>
                        </td>
                        <td colspan="2" style="vertical-align:top;text-align: center">
                            <span id="lblTotal"><c:out value="${funcion.precio}"/></span>
                        </td>
                        <td rowspan="5" colspan="2" width="200px" style="position: relative;text-align: center">
                            <img src="<c:out value="${funcion.peliculaFDBean.img_1}"/>" width="100px" height="130px"/><br>
                            Cine:<c:out value="${funcion.salaBean.cineBean.nombre}"/><br>
                            <p><c:out value="${funcion.salaBean.cineBean.direccion}"/></p><br>
                            sala:<c:out value="${funcion.salaBean.numSala}"/><br>
                            <c:out value="${funcion.inicio}"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3"></td>
                        <td></td>
                        <td colspan="3" style="vertical-align: top;text-align: center;padding-top: 20px">

                            <input type="hidden" name="codFuncion" value="<c:out value="${funcion.codigo}"/>"/>
                            <input type="hidden" name="user" value="<c:if test="${sessionScope.usuario != null}"><c:out value="${sessionScope.usuario.codigo}"/></c:if>"/>

                            <a href="#" id="btnRegresar">regresar</a>&nbsp;
                            <input type="submit" id="btnComprar" value="comprar" name="accion"/></td>
                        <td></td>
                    </tr>


                </table>
            </center>
        </form>

    </body>
</html>
