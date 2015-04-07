<%-- 
    Document   : mantPelicula
    Created on : 11-oct-2014, 16:28:13
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
        <script type="text/javascript">
            function eliminar(codigo)
            {
                if (confirm("Desea eliminar el registro?"))
                {
                    window.location="PeliculaFDServlet?accion=eliminar&codigo="+codigo;
                }
            }
        </script>
    </head>
    <body>
        <%@include file="../../cabecera.jspf" %>


        <form action="PeliculaFDServlet" method="post">
            <center>

                <table class="cebra" width="1000">
                    <thead>
                    <th>Código</th>
                    <th>Titulo</th>
                    <th>Duracion</th>
                    <th>Pais de Origen</th>
                    <th>Genero</th>
                    <th>Portada</th>
                    <th>imagen1</th>
                    <th>Acciones</th>
                    </thead>
                    <c:forEach items="${requestScope.listaPelicula}" var="pelicula">
                        <tr>
                            <td align="center">
                                <c:out value="${pelicula.codigo}"/>
                            </td>
                            <td align="center">
                                <c:out value="${pelicula.titulo}"/>
                            </td><td align="center">
                                <c:out value="${pelicula.duracion}"/>
                            </td>
                            <td align="center">
                                <c:out value="${pelicula.paisOrigen}"/>
                            </td>
                            <td align="center">
                                <c:out value="${pelicula.genero}"/>
                            </td>
                            <%--    <td align="center">
                                    <c:out value="${pelicula.fechaEstreno}"/>
                            <c:out value="${pelicula.img_portada}"/>
                                </td>--%>
                            
                            <td><img src=" <c:out value="${pelicula.img_portada}"/>"
                                     width="50" height="35" alt="Imagen no encontrada"/>
                            </td>
                            <td><img src="<c:out value="${pelicula.img_1}"/>"
                                     width="50" height="35" alt="Imagen no encontrada"/>
                            </td>
                            <td>
                                <a href="PeliculaFDServlet?accion=modificar&codigo=<c:out value="${pelicula.codigo}"/>">
                                    <img src="imagenes/edit.png" width="32" height="32"/>
                                </a>
                                &nbsp;&nbsp;
                                <a href="javascript:eliminar(<c:out value="${pelicula.codigo}"/>);">
                                    <img src="imagenes/delete.png" width="32" height="32"/>
                                </a>

                            </td>

                        </tr>
                    </c:forEach>
                </table>

                <center>
                    <br><br>
                    <a href="PeliculaFDServlet?accion=insertar"><img src="imagenes/add.png" border="0" width="32" height="32"/></a>
                </center>
                <%--<input type="hidden" name="accion" value="comprar"/>
                <br>
                
                    <a href="javascript:enviar();">
                        <img src="imagenes/boton-compra.png" border='0'
                             width="100" height="30"/>
                    </a>
                    &nbsp;&nbsp;
                    <a href="CarritoServlet?accion=verCarrito">
                        <img src="imagenes/ir-carrito.gif" border='0'
                             width="100" height="30"/>
                    </a>--%>
            </center>

        </form>
    </body>

</html>
