/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cibertec.cine.servlet;

import edu.cibertec.cine.dao.bean.CineBean;
import edu.cibertec.cine.service.CineService;
import edu.cibertec.cine.service.imp.CineServiceImp;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

/**
 *
 * @author CHRISTIAN-LAP
 */
public class CineServlet extends HttpServlet {

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
        CineService cineService = new CineServiceImp();
        String region = request.getParameter("region");

        if (region.equals("lima")) {
            try {
                List<CineBean> lista = cineService.listarCineLima();
                request.setAttribute("listaCine", lista);
                request.setAttribute("titulo", "Cines en Lima");
                RequestDispatcher dispa = getServletContext().getRequestDispatcher("/cines.jsp");
                dispa.forward(request, response);
            } catch (Exception ex) {
                logger.error(ex.toString().replace("'", ""), ex);
            }

        } else if (region.equals("otros")) {
            try {
                List<CineBean> lista = cineService.listarCineOtros();
                request.setAttribute("titulo", "Cines en otras ciudades");
                request.setAttribute("listaCine", lista);
                RequestDispatcher dispa = getServletContext().getRequestDispatcher("/cines.jsp");
                dispa.forward(request, response);
            } catch (Exception ex) {
                logger.error(ex.toString().replace("'", ""), ex);
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
