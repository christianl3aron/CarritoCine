package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import edu.cibertec.cine.dao.bean.PeliculaFDBean;
import edu.cibertec.cine.dao.bean.UsuarioBean;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(1);
    _jspx_dependants.add("/cabecera.jspf");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_choose;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_when_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_out_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_otherwise;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_choose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_when_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_out_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_otherwise = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_if_test.release();
    _jspx_tagPool_c_choose.release();
    _jspx_tagPool_c_when_test.release();
    _jspx_tagPool_c_out_value_nobody.release();
    _jspx_tagPool_c_otherwise.release();
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
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
      out.write("                            ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </td>\n");
      out.write("                ");
      if (_jspx_meth_c_choose_0(_jspx_page_context))
        return;
      out.write("\n");
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
      out.write("        <script src=\"js/ajax/IndexAjax.js\" type=\"text/javascript\"></script>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "PeliculaServlet?page=in", out, false);
      out.write("\n");
      out.write("\n");
      out.write("        ");
 List<PeliculaFDBean> covers = (List<PeliculaFDBean>) request.getAttribute("covers");
            List<PeliculaFDBean> cartelera = (List<PeliculaFDBean>) request.getAttribute("cartelera");
        
      out.write("\n");
      out.write("\n");
      out.write("    <center>\n");
      out.write("        <table border=\"0\" width=\"1000px\" height=\"600px\" style=\"table-layout: fixed\">\n");
      out.write("            <tr >\n");
      out.write("                <td id=\"main-banner\" rowspan=\"3\" colspan=\"2\">\n");
      out.write("                    <div id=\"big-slide\" style=\"width: 480px;height: 550px;background-color: #777777\">\n");
      out.write("                        <img src=\"");
      out.print( covers.get(1).getImg_portada());
      out.write("\"/> \n");
      out.write("                    </div>\n");
      out.write("                </td>\n");
      out.write("                <td class=\"sml-banner\" id=\"s1\">\n");
      out.write("                    <div id=\"index-search\" style=\"margin: auto\">\n");
      out.write("\n");
      out.write("                        <form>\n");
      out.write("                            <select id=\"cmbCiudad\" name=\"cmbCiudad\">\n");
      out.write("                                <option value=\"0\" disabled selected>Seleccione la Ciudad</option>\n");
      out.write("                                <option value=\"1\">Lima</option>\n");
      out.write("                                <option value=\"2\">Otras ciudades</option>\n");
      out.write("                            </select><br>\n");
      out.write("\n");
      out.write("                            <select id=\"cmbCine\" name=\"cmbCine\">\n");
      out.write("                                <option value=\"0\" disabled selected>Seleccione el cine</option>\n");
      out.write("                            </select><br>\n");
      out.write("\n");
      out.write("                            <select id=\"cmbPelicula\" name=\"cmbPelicula\">\n");
      out.write("                                <option value=\"0\" disabled selected>Seleccione la pelicula</option>\n");
      out.write("                            </select><br>\n");
      out.write("\n");
      out.write("                            <a href=\"#\" id=\"btnAceptar\" class=\"boton\">Aceptar</a>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </td>\n");
      out.write("                <td class=\"sml-banner\" id=\"s2\"><img src=\"imagenes/compraEntradas.jpg\"/>\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>  \n");
      out.write("                <td rowspan=\"2\" colspan=\"2\">\n");
      out.write("\n");
      out.write("                    <table style=\"margin: auto\">\n");
      out.write("                        <tr>\n");
      out.write("                            ");
for (int i = 0; i < 4; i++) {
      out.write("\n");
      out.write("                            <td><a href=\"DetailServlet?codigo=");
      out.print(cartelera.get(i).getCodigo());
      out.write("&obj=pelicula\"><img src=\"");
      out.print(cartelera.get(i).getImg_1());
      out.write("\" width=\"113px\" height=\"162px\"/></a></td>\n");
      out.write("                                    ");
}
      out.write("\n");
      out.write("\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            ");
for (int i = 4; i < 8; i++) {
      out.write("\n");
      out.write("                            <td><a href=\"DetailServlet?codigo=");
      out.print(cartelera.get(i).getCodigo());
      out.write("&obj=pelicula\"><img src=\"");
      out.print(cartelera.get(i).getImg_1());
      out.write("\" width=\"113px\" height=\"162px\"/></a></td>\n");
      out.write("                                    ");
}
      out.write("\n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("    </center>\n");
      out.write("</body>\n");
      out.write("</html>\n");
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

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.usuario.tipo == 2}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
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
        out.write("                            ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_choose_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_choose_0 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _jspx_tagPool_c_choose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_choose_0.setPageContext(_jspx_page_context);
    _jspx_th_c_choose_0.setParent(null);
    int _jspx_eval_c_choose_0 = _jspx_th_c_choose_0.doStartTag();
    if (_jspx_eval_c_choose_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                    ");
        if (_jspx_meth_c_when_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_choose_0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("                ");
        if (_jspx_meth_c_otherwise_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_choose_0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("        ");
        int evalDoAfterBody = _jspx_th_c_choose_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_choose_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_0);
      return true;
    }
    _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_0);
    return false;
  }

  private boolean _jspx_meth_c_when_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_when_0 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _jspx_tagPool_c_when_test.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_when_0.setPageContext(_jspx_page_context);
    _jspx_th_c_when_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
    _jspx_th_c_when_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${not empty sessionScope.usuario}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_when_0 = _jspx_th_c_when_0.doStartTag();
    if (_jspx_eval_c_when_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                        <td>Usuario:");
        if (_jspx_meth_c_out_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_when_0, _jspx_page_context))
          return true;
        out.write("&nbsp;");
        if (_jspx_meth_c_out_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_when_0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("                        </td>\n");
        out.write("                    </tr>\n");
        out.write("                    <tr>\n");
        out.write("                        <td>\n");
        out.write("                            <form action=\"CompraServlet\" method=\"post\">\n");
        out.write("                                <input type=\"hidden\" name=\"codUser\" value=\"");
        if (_jspx_meth_c_out_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_when_0, _jspx_page_context))
          return true;
        out.write("\"/>\n");
        out.write("                                <input type=\"image\" name=\"accion\" value=\"carrito\" src=\"imagenes/ticket.png\" width=\"30px\" height=\"30px\"/>\n");
        out.write("                            </form>\n");
        out.write("                            <a href=\"LoginServlet?accion=logoff\">Cerrar Sesión</a>\n");
        out.write("                        </td>\n");
        out.write("                    </tr>\n");
        out.write("                ");
        int evalDoAfterBody = _jspx_th_c_when_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_when_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_0);
      return true;
    }
    _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_0);
    return false;
  }

  private boolean _jspx_meth_c_out_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_when_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_0.setPageContext(_jspx_page_context);
    _jspx_th_c_out_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_0);
    _jspx_th_c_out_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.usuario.nombres}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_0 = _jspx_th_c_out_0.doStartTag();
    if (_jspx_th_c_out_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_0);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_0);
    return false;
  }

  private boolean _jspx_meth_c_out_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_when_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_1 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_1.setPageContext(_jspx_page_context);
    _jspx_th_c_out_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_0);
    _jspx_th_c_out_1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.usuario.apellidos}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_1 = _jspx_th_c_out_1.doStartTag();
    if (_jspx_th_c_out_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_1);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_1);
    return false;
  }

  private boolean _jspx_meth_c_out_2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_when_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_2 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_2.setPageContext(_jspx_page_context);
    _jspx_th_c_out_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_0);
    _jspx_th_c_out_2.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.usuario.codigo}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_2 = _jspx_th_c_out_2.doStartTag();
    if (_jspx_th_c_out_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_2);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_2);
    return false;
  }

  private boolean _jspx_meth_c_otherwise_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:otherwise
    org.apache.taglibs.standard.tag.common.core.OtherwiseTag _jspx_th_c_otherwise_0 = (org.apache.taglibs.standard.tag.common.core.OtherwiseTag) _jspx_tagPool_c_otherwise.get(org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class);
    _jspx_th_c_otherwise_0.setPageContext(_jspx_page_context);
    _jspx_th_c_otherwise_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
    int _jspx_eval_c_otherwise_0 = _jspx_th_c_otherwise_0.doStartTag();
    if (_jspx_eval_c_otherwise_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                    <td><a href=\"login.jsp\"><a href=\"login.jsp\">iniciar sesion</a></td>\n");
        out.write("                </tr>\n");
        out.write("            ");
        int evalDoAfterBody = _jspx_th_c_otherwise_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_otherwise_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_0);
      return true;
    }
    _jspx_tagPool_c_otherwise.reuse(_jspx_th_c_otherwise_0);
    return false;
  }
}
