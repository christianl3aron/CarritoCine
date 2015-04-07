<%-- 
    Document   : login
    Created on : 07-oct-2014, 15:16:23
    Author     : CHRISTIAN-LAP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link type="text/css" rel="stylesheet" href="css/estiloLogueo.css" />
        <script src="js/LoginValidator.js" type="text/javascript"></script>
    </head>
    <body id="bd-logueo">
        <header>
            <a href="#" title="Netflix" class="logo">
                <div class="img"><img src="imagenes/logo_cine.png" id="print-img"></div>
            </a>
        </header>
        <div id="sc-login">
            <div id="hmain">Iniciar sesión</div>
            <form action="LoginServlet" method="post">
                <label for="txtUsuario">Usuario</label><br>
                <input type="text" name="txtUsuario" id="txtUsuario" size="20"/><br>
                <label for="txtClave">Contraseña</label><br>
                <input type="password" name="txtClave"id="txtClave" size="20"/><br>
                <input type="submit" value="Iniciar sesión" onclick="return validar()" />
                <input type="hidden" name="accion" value="login"/>
            </form>
            <font color="red"><b> 
                <%= request.getAttribute("mensajeError") == null ? ""
                        : request.getAttribute("mensajeError")%>  
            </b></font>
        </div>
    </body>
</html>
