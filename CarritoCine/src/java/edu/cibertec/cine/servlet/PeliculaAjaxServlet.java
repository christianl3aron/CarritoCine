/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cibertec.cine.servlet;

import edu.cibertec.cine.dao.bean.PeliculaFDBean;
import edu.cibertec.cine.service.PeliculaService;
import edu.cibertec.cine.service.imp.PeliculaServiceImp;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

/**
 *
 * @author CHRISTIAN-LAP
 */
public class PeliculaAjaxServlet extends HttpServlet {

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
        try {
            PeliculaService peliculaService = new PeliculaServiceImp();
            String page = request.getParameter("pagina");

            if (page.equals("index")) {
                PrintWriter out = response.getWriter();
                int codigo = Integer.parseInt(request.getParameter("codigoCine"));
                List<PeliculaFDBean> listaPelicula = peliculaService.listarPeliculasPorCine(codigo);
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < listaPelicula.size(); i++) {
                    sb.append(listaPelicula.get(i).getCodigo()).append("-").append(listaPelicula.get(i).getTitulo()).append(":");
                }
                out.write(sb.toString());

            } else if (page.equals("manFunDatos")) {
                response.setContentType("text/html;charset=UTF-8");
                int codPel = Integer.parseInt(request.getParameter("codPelicula"));
                PrintWriter out = response.getWriter();
                PeliculaFDBean peliculaFDBean = peliculaService.obtenerDetallePelicula(codPel);
                try {
                    out.println("<img src=\"" + peliculaFDBean.getImg_1() + "\" alt=\"imagen no edisponible\"/>");
                    out.println("<p>" + peliculaFDBean.getTitulo() + "</p>");
                    out.println("<p>" + peliculaFDBean.getDuracion() + " minutos</p>");
                    out.println("<p>" + peliculaFDBean.getFechaEstreno() + "</p>");
                } finally {
                    out.close();
                }


            }

        } catch (Exception ex) {
            logger.error(ex.toString().replace("'", ""), ex);
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
