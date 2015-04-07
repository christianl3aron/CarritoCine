package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import edu.cibertec.cine.dao.bean.UsuarioBean;
import edu.cibertec.cine.dao.bean.UsuarioBean;

public final class prueba_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(1);
    _jspx_dependants.add("/cabecera.jspf");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("         ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset='utf-8'>\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/styles.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/main.css\">\n");
      out.write("        <script src=\"js/jquery-1.11.1.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <link href=\"css/table/estilos.css\" type=\"text/css\" rel=\"stylesheet\"/>\n");
      out.write("        <script src=\"js/menu/script.js\"></script>\n");
      out.write("        <title>Tus entradas Ya!!</title>\n");
      out.write("        ");
  response.setHeader("Cache-Control",
                    "no-cache, no-store, max-age=0, must-revalidate");
            response.setHeader("Cache-Control", "no-store");
            response.setHeader("Pragma", "no-cache");
            response.setDateHeader("Expires", 0);
        
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body >\n");
      out.write("\n");
      out.write("\n");
      out.write("        <table width='100%' bgcolor=\"#F2F2F2\" border=\"0\">\n");
      out.write("            <tr>\n");
      out.write("                <td rowspan=\"3\"><img src=\"imagenes/logo_cine.png\"></td>\n");
      out.write("                <td rowspan=\"3\" valign=\"bottom\">\n");
      out.write("\n");
      out.write("                    <div id='cssmenu' style=\"width: 500px\">\n");
      out.write("                        <ul>\n");
      out.write("                            <li><a href=\"index.jsp\">Inicio</a></li>\n");
      out.write("                            <li class='active has-sub'><a href='#'>Peliculas</a>\n");
      out.write("                                <ul>\n");
      out.write("                                    <li class='has-sub'><a href=\"PeliculaServlet?page=car\">En Cartelera</a>\n");
      out.write("\n");
      out.write("                                    </li>\n");
      out.write("                                    <li class='has-sub'><a href=\"PeliculaServlet?page=est\">Estrenos</a>\n");
      out.write("\n");
      out.write("                                    </li>\n");
      out.write("                                    <li class='has-sub'><a href=\"PeliculaServlet?page=pro\">Proximos</a>\n");
      out.write("\n");
      out.write("                                    </li>\n");
      out.write("                                </ul>\n");
      out.write("                            </li>\n");
      out.write("                            <li><a href='#'>Cines</a>\n");
      out.write("                                <ul>\n");
      out.write("                                    <li class='has-sub'><a href=\"CineServlet?region=lima\">Lima</a>\n");
      out.write("\n");
      out.write("                                    </li>\n");
      out.write("                                    <li class='has-sub'><a href=\"CineServlet?region=otros\">Provincias</a>\n");
      out.write("\n");
      out.write("                                    </li>\n");
      out.write("\n");
      out.write("                                </ul>\n");
      out.write("\n");
      out.write("\n");
      out.write("                            </li>\n");
      out.write("                            <c:if test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.usuario.tipo == 2}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                                <li><a href='#'>Administracion</a>\n");
      out.write("                                    <ul>\n");
      out.write("                                        <li class='has-sub'><a href=\"PeliculaFDServlet?accion=iniciar\">Mantenimiento Peliculas</a>\n");
      out.write("\n");
      out.write("                                        </li>\n");
      out.write("                                        <li class='has-sub'><a href=\"FuncionServlet?accion=iniciar\">Mantenimiento Funciones</a>\n");
      out.write("\n");
      out.write("                                        </li>\n");
      out.write("                                        <li class='has-sub'><a href='#'>Mantenimiento Usuario</a>\n");
      out.write("\n");
      out.write("                                        </li>                                    \n");
      out.write("                                    </ul>\n");
      out.write("                                </li>\n");
      out.write("                            </c:if>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </td>\n");
      out.write("                <c:choose>\n");
      out.write("                    <c:when test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${not empty sessionScope.usuario}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                        <td>Usuario:<c:out value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.usuario.nombres}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/>&nbsp;<c:out value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.usuario.apellidos}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>\n");
      out.write("                            <form action=\"CompraServlet\" method=\"post\">\n");
      out.write("                                <input type=\"hidden\" name=\"codUser\" value=\"<c:out value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.usuario.codigo}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/>\"/>\n");
      out.write("                                <input type=\"image\" name=\"accion\" value=\"carrito\" src=\"imagenes/ticket.png\" width=\"30px\" height=\"30px\"/>\n");
      out.write("                            </form>\n");
      out.write("                            <a href=\"LoginServlet?accion=logoff\">Cerrar Sesión</a>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                </c:when>\n");
      out.write("                <c:otherwise>\n");
      out.write("                    <td><a href=\"login.jsp\"><a href=\"login.jsp\">iniciar sesion</a></td>\n");
      out.write("                </tr>\n");
      out.write("            </c:otherwise>\n");
      out.write("        </c:choose>\n");
      out.write("\n");
      out.write("\n");
      out.write("    </table>\n");
      out.write("\n");
      out.write("\n");
      out.write("    <hr>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("<html>");
      out.write("\n");
      out.write("        <h1>PAGINA DE PRUEBA</h1>\n");
      out.write("\n");
      out.write("        <a href=\"CompraServlet?accion=imprimir\"> imprimir reporte</a>\n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
