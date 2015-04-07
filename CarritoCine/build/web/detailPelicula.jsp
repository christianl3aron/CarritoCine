<%-- 
    Document   : pelicula
    Created on : 11-oct-2014, 9:50:10
    Author     : CHRISTIAN-LAP
--%>

<%@page import="edu.cibertec.cine.dao.bean.PeliculaFDBean"%>
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
        <c:set var="pelicula" value="${requestScope.peliculaFD}"/>
        <script src="js/ajax/DetailPeliculaAjax.js" type="text/javascript"></script>

        <div>
            <center>
                <table border="0" width="1000px">
                    <tr>
                        <td colspan="15"><h1>Detalle de Pelicula</h1></td>
                    </tr
                    <tr>
                    <input type="hidden" id="codigoPelicula" value="<c:out value="${pelicula.codigo}"/>"/>
                    <td rowspan="8" width="200px"><img src="<c:out value="${pelicula.img_1}"/>" width="180px" height="270px"/></td>
                    <td colspan="12" rowspan="2"><div class="titulo"><c:out value="${pelicula.titulo}"/></div></div></td>
                    </tr>
                    <tr></tr>
                    <tr>
                        <td colspan="2"><div class="label-detail">genero</div></td>
                        <td colspan="4" width="267px"><c:out value="${pelicula.genero}"/></td>
                        <td rowspan="2" width="400px" colspan="6">trailer</td>
                    </tr>
                    <tr>
                        <td colspan="2"><div class="label-detail">duracion</div></td>
                        <td colspan="4" width="267px"><c:out value="${pelicula.duracion}"/></td>
                    </tr>
                    <tr>
                        <td colspan="2"><div class="label-detail">censura</div></td>
                        <td colspan="4" width="267px">.</td>
                        <td colspan="1">pais</td>
                        <td colspan="3">
                            <c:if test="${not empty pelicula.paisOrigen}">
                                <c:out value="${pelicula.paisOrigen}"/>
                            </c:if></td>
                        <td rowspan="2" colspan="2" width="133px">trailer</td>
                    </tr>
                    <tr>
                        <td colspan="2"><div class="label-detail">titulo original</div></td>
                        <td colspan="4" width="267px" >dracula untold</td>
                        <td colspan="1" width="67px">director</td>
                        <td colspan="3"  width="200px">
                            <c:if test="${not empty pelicula.director}">
                                <c:out value="${pelicula.director}"/>
                            </c:if>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"><div class="label-detail" id="ld-actores">actores</div></td>
                        <td colspan="10" ><c:out value="${pelicula.actores}"/></td>
                    </tr>

                    <tr>
                        <td colspan="2"><div class="label-detail" id="ld-sinop">sinopsis</div></td>
                        <td colspan="10" ><c:out value="${pelicula.sinopsis}"/></td
                    </tr>
                </table>

                <table border="0" width="1000px" style="table-layout: fixed;text-align: center;background-color: skyblue">
                    <tr style="height: 50px">
                        <td  width="350"> 
                            En que cine quiere verlo?
                        </td>
                        <td>
                            <select id="cmbCiudad" name="cmbCiudad">
                                <option value="0" disabled selected>Seleccione la Ciudad</option>
                                <option value="1">Lima</option>
                                <option value="2">Otras ciudades</option>
                            </select><br>
                        </td>
                        <td>
                            <select id="cmbCine" name="cmbCine">
                                <option value="0" disabled selected>Seleccione el cine</option>
                            </select>
                        </td>
                        <td>
                            <select id="cmbDia" name="cmbDia">
                                <option value="0" disabled selected>Seleccione el dia</option>
                            </select>
                        </td>
                    </tr>
                    <tr style="height: 60px">
                        <td colspan="4">
                            <div id="divFunciones">
                            </div>
                        </td>
                    </tr>
                </table>

            </center>
        </div>
    </body>
</html>
