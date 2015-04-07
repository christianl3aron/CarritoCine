/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cibertec.cine.servlet;

import edu.cibertec.cine.dao.bean.FuncionBean;
import edu.cibertec.cine.service.FuncionService;
import edu.cibertec.cine.service.imp.FuncionServiceImp;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
public class FuncionAjaxServlet extends HttpServlet {

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
        FuncionService funcionService = new FuncionServiceImp();
        String page = request.getParameter("page");

        if (page.equals("detPelicula")) {

            response.setContentType("text/html;charset=UTF-8");
            int codCine = Integer.parseInt(request.getParameter("codigoCine"));
            int codPel = Integer.parseInt(request.getParameter("codigoPelicula"));
            int dia = Integer.parseInt(request.getParameter("dia"));
            PrintWriter out = response.getWriter();

            Date diaFuncion = new Date();
            Calendar c = Calendar.getInstance();
            c.setTime(diaFuncion);
            if (dia == 1) {
                c.add(Calendar.DATE, 0);
            } else if (dia == 2) {
                c.add(Calendar.DATE, 1);
            } else if (dia == 3) {
                c.add(Calendar.DATE, 2);
            }
            diaFuncion = c.getTime();
            
            try {
                List<FuncionBean> listaFuncion = funcionService.listarFuncionesPorCinePorPeliculaPorFecha(codCine, codPel, diaFuncion);
                HttpSession miSesion = request.getSession();
                for (int i = 0; i < listaFuncion.size(); i++) {
                    if (miSesion.getAttribute("usuario") != null) {
                        out.println("<a href=\"CompraServlet?accion=agregar&codFuncion=" + listaFuncion.get(i).getCodigo() + "\" class=\"comprar\">" + listaFuncion.get(i).getInicio() + "</a>");
                    } else if (miSesion.getAttribute("usuario") == null) {
                        out.println("<a href=login.jsp class=\"comprar\">" + listaFuncion.get(i).getInicio() + "</a>");
                    }
                }
            } catch (Exception ex) {
                logger.error(ex.toString().replace("'", ""), ex);
            } finally {
                out.close();
            }
        } else if (page.equals("manFunDatos")) {
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            DateFormat hourFormat = new SimpleDateFormat("HH:mm");
            int codSala = Integer.parseInt(request.getParameter("codSala"));
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            try {
                List<FuncionBean> listaFuncion = funcionService.listarFuncionesPorSala(codSala);
                System.out.println(listaFuncion.size());
                out.println("<center>");
                out.println("<table border=\"1\" style=\"width: 600px; table-layout: fixed\"");
                out.println("<tr>");
                out.println("<th colspan=\"2\">Pelicula</th>");
                out.println("<th>Precio</th>");
                out.println("<th>Dia</th>");
                out.println("<th>Hora de inicio</th>");
                out.println("<th>Acciones</th>");
                out.println("</tr>");
                for (int i = 0; i < listaFuncion.size(); i++) {
                    out.println("<tr>");
                    out.println("<td colspan=\"2\">");
                    out.println(listaFuncion.get(i).getPeliculaFDBean().getTitulo());
                    out.println("</td>");
                    out.println("<td>");
                    out.println(listaFuncion.get(i).getPrecio());
                    out.println("</td>");
                    out.println("<td>");
                    out.println(dateFormat.format(listaFuncion.get(i).getInicio()));
                    out.println("</td>");
                    out.println("<td>");
                    out.println(hourFormat.format(listaFuncion.get(i).getInicio()));
                    out.println("</td>");
                    out.println("<td>");
                    out.println("<a href=\"javascript:eliminar(" + listaFuncion.get(i).getCodigo() + ");\"><img src=\"imagenes/delete.png\" width=\"32\" height=\"32\"/></a>");
                    out.println("</tr>");
                }
                out.println("</table>");
                out.println("</center>");
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
