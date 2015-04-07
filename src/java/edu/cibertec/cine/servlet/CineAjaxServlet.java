/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cibertec.cine.servlet;

import edu.cibertec.cine.dao.bean.CineBean;
import edu.cibertec.cine.dao.bean.FuncionBean;
import edu.cibertec.cine.dao.bean.PeliculaFDBean;
import edu.cibertec.cine.service.CineService;
import edu.cibertec.cine.service.FuncionService;
import edu.cibertec.cine.service.PeliculaService;
import edu.cibertec.cine.service.imp.CineServiceImp;
import edu.cibertec.cine.service.imp.FuncionServiceImp;
import edu.cibertec.cine.service.imp.PeliculaServiceImp;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

/**
 *
 * @author CHRISTIAN-LAP
 */
public class CineAjaxServlet extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Logger logger = Logger.getLogger(this.getClass());
        PrintWriter out = response.getWriter();
        CineService cineService = new CineServiceImp();
        String page = request.getParameter("page");
        if (page.equals("index") || page.equals("detPelicula")) {
            int codigo = Integer.parseInt(request.getParameter("codigoCiudad"));
            StringBuilder sb = new StringBuilder();
            if (codigo == 1) {
                try {
                    List<CineBean> lista = cineService.listarCineLima();
                    for (int i = 0; i < lista.size(); i++) {
                        sb.append(lista.get(i).getCodigo()).append("-").append(lista.get(i).getNombre()).append(":");
                    }
                } catch (Exception ex) {
                    logger.error(ex.toString().replace("'", ""), ex);
                }
            } else if (codigo == 2) {
                try {
                    List<CineBean> lista = cineService.listarCineOtros();
                    for (int i = 0; i < lista.size(); i++) {
                        sb.append(lista.get(i).getCodigo()).append("-").append(lista.get(i).getNombre()).append(":");
                    }
                } catch (Exception ex) {
                    logger.error(ex.toString().replace("'", ""), ex);
                }
            }
            out.write(sb.toString());

        } else if (page.equals("detCine")) {
            response.setContentType("text/html;charset=UTF-8");
            String dia = request.getParameter("dia");
            int codCine = Integer.parseInt(request.getParameter("codCine"));
            
            Date diaFuncion = new Date();
            Calendar c = Calendar.getInstance();
            c.setTime(diaFuncion);
            if (dia.equals("hoy")) {
                c.add(Calendar.DATE, 0);
            } else if (dia.equals("man")) {
                c.add(Calendar.DATE, 1);
            } else if (dia.equals("pas")) {
                c.add(Calendar.DATE, 2);
            }
            diaFuncion = c.getTime();
            
            try {
                FuncionService funcionService = new FuncionServiceImp();
                List<FuncionBean> listaFuncion = funcionService.listarFuncionesPorCinePorFecha(codCine, diaFuncion);
                PeliculaService peliculaService = new PeliculaServiceImp();
                List<PeliculaFDBean> listaPelicula = peliculaService.listarPeliculasPorCinePorFecha(codCine, diaFuncion);
                HttpSession miSesion = request.getSession();
                for (int i = 0; i < listaPelicula.size(); i++) {
                    out.println("<table>");
                    out.println("<tr>");
                    out.println("<td width=\"200\" rowspan=\"4\">");
                    out.println("<div style=\"margin: auto;text-align: center\">");
                    out.println("<img src=\"" + listaPelicula.get(i).getImg_1() + "\" alt=\"imagen no disponible\" width=\"140px\"/>");
                    out.println("</div>");
                    out.println("</td>");
                    out.println("<td colspan=\"3\" width=\"600\" height=\"50\" class=\"headlight\">");
                    out.println(listaPelicula.get(i).getTitulo() + "<br>");
                    out.println(listaPelicula.get(i).getDuracion());
                    out.println("</td>");
                    out.println("<td height=\"50\" class=\"headlight\">");
                    out.println("<a href=\"DetailServlet?codigo=" + listaPelicula.get(i).getCodigo() + "&obj=pelicula\" class=\"peldetail\">ver detalle de la pelicula</a>");
                    out.println("</td>");
                    out.println("</tr>");
                    out.println("<tr>");
                    out.println("<td colspan=\"4\" class=\"funciones\">");
                    for (int j = 0; j < listaFuncion.size(); j++) {
                        if (listaFuncion.get(j).getPeliculaFDBean().getCodigo() == listaPelicula.get(i).getCodigo()) {
                            if (miSesion.getAttribute("usuario") != null) {
                                out.println("<a href=\"CompraServlet?accion=agregar&codFuncion=" + listaFuncion.get(j).getCodigo() + "\" class=\"comprar\">" + listaFuncion.get(j).getInicio() + "</a>");
                            } else {
                                out.println("<a href=\"login.jsp\" class=\"comprar\">" + listaFuncion.get(j).getInicio() + "</a>");
                            }
                        }
                    }
                    out.println("</td>");
                    out.println("</tr>");
                    out.println("</table>");
                }
//            
            } catch (Exception ex) {
                logger.error(ex.toString().replace("'", ""), ex);
            } finally {
                out.close();
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
