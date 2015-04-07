<%-- 
    Document   : index
    Created on : 09-oct-2014, 10:01:57
    Author     : CHRISTIAN-LAP
--%>

<%@page import="java.util.List"%>
<%@page import="edu.cibertec.cine.dao.bean.PeliculaFDBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="cabecera.jspf" %>
        <script src="js/ajax/IndexAjax.js" type="text/javascript"></script>
        <jsp:include page="PeliculaServlet?page=in"/>

        <% List<PeliculaFDBean> covers = (List<PeliculaFDBean>) request.getAttribute("covers");
            List<PeliculaFDBean> cartelera = (List<PeliculaFDBean>) request.getAttribute("cartelera");
        %>

    <center>
        <table border="0" width="1000px" height="600px" style="table-layout: fixed">
            <tr >
                <td id="main-banner" rowspan="3" colspan="2">
                    <div id="big-slide" style="width: 480px;height: 550px;background-color: #777777">
                        <img src="<%= covers.get(1).getImg_portada()%>"/> 
                    </div>
                </td>
                <td class="sml-banner" id="s1">
                    <div id="index-search" style="margin: auto">

                        <form>
                            <select id="cmbCiudad" name="cmbCiudad">
                                <option value="0" disabled selected>Seleccione la Ciudad</option>
                                <option value="1">Lima</option>
                                <option value="2">Otras ciudades</option>
                            </select><br>

                            <select id="cmbCine" name="cmbCine">
                                <option value="0" disabled selected>Seleccione el cine</option>
                            </select><br>

                            <select id="cmbPelicula" name="cmbPelicula">
                                <option value="0" disabled selected>Seleccione la pelicula</option>
                            </select><br>

                            <a href="#" id="btnAceptar" class="boton">Aceptar</a>
                        </form>
                    </div>

                </td>
                <td class="sml-banner" id="s2"><img src="imagenes/compraEntradas.jpg"/>
                </td>
            </tr>
            <tr>  
                <td rowspan="2" colspan="2">

                    <table style="margin: auto">
                        <tr>
                            <%for (int i = 0; i < 4; i++) {%>
                            <td><a href="DetailServlet?codigo=<%=cartelera.get(i).getCodigo()%>&obj=pelicula"><img src="<%=cartelera.get(i).getImg_1()%>" width="113px" height="162px"/></a></td>
                                    <%}%>

                        </tr>
                        <tr>
                            <%for (int i = 4; i < 8; i++) {%>
                            <td><a href="DetailServlet?codigo=<%=cartelera.get(i).getCodigo()%>&obj=pelicula"><img src="<%=cartelera.get(i).getImg_1()%>" width="113px" height="162px"/></a></td>
                                    <%}%>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
    </center>
</body>
</html>
