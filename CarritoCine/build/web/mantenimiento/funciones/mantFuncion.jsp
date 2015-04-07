<%-- 
    Document   : mantFuncion
    Created on : 17-oct-2014, 10:42:02
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
                    window.location="FuncionServlet?accion=eliminar&codigo="+codigo;
                }
            }
        </script>
    </head>
    <body>
        <%@include file="../../cabecera.jspf" %>
        
        <form action="FuncionServlet" method="post">
            <center>

                <table class="cebra" width="1000">
                    <thead>
                    <th>Código</th>
                    <th>Titulo</th>
                    <th>Duracion</th>
                    <th>Hora de inicio</th>
                    <th>cine</th>
                    <th>Sala</th>
                    
                    <th>Acciones</th>
                    </thead>
                    <c:forEach items="${requestScope.listaFuncion}" var="funcion">
                        <tr>
                            <td align="center">
                                <c:out value="${funcion.codigo}"/>
                            </td>
                            <td align="center">
                                <c:out value="${funcion.peliculaFDBean.titulo}"/>
                            </td><td align="center">
                                <c:out value="${funcion.peliculaFDBean.duracion}"/>
                            </td>
                            <td align="center">
                                <c:out value="${funcion.inicio}"/>
                            </td>
                            <td align="center">
                                <c:out value="${funcion.salaBean.cineBean.nombre}"/>
                            </td>
                            <td align="center">
                                <c:out value="${funcion.salaBean.numSala}"/>
                            </td>
                            
                            
                            <%--    <td align="center">
                                    <c:out value="${pelicula.fechaEstreno}"/>
                            <c:out value="${pelicula.img_portada}"/>
                                </td>--%>
                            
                           <%-- <td><img src=" <c:out value="${pelicula.img_portada}"/>"
                                     width="50" height="35" alt="Imagen no encontrada"/>
                            </td>
                            <td><img src="<c:out value="${pelicula.img_1}"/>"
                                     width="50" height="35" alt="Imagen no encontrada"/>
                            </td>--%>
                            <td>
                                
                                <a href="javascript:eliminar(<c:out value="${funcion.codigo}"/>);">
                                    <img src="imagenes/delete.png" width="32" height="32"/>
                                </a>

                            </td>

                        </tr>
                    </c:forEach>
                </table>

                <center>
                    <br><br>
                    <a href="FuncionServlet?accion=insertar"><img src="imagenes/add.png" border="0" width="32" height="32"/></a>
                    &nbsp;&nbsp;
                    <a href="FuncionServlet?accion=imprimir" target="_blank"> imprimir reporte</a>
                </center>
    </body>
</html>
