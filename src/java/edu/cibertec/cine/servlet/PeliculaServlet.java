/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cibertec.cine.servlet;

import edu.cibertec.cine.dao.bean.PeliculaFDBean;
import edu.cibertec.cine.service.PeliculaService;
import edu.cibertec.cine.service.imp.PeliculaServiceImp;
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
public class PeliculaServlet extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        //1.  invocar logica de negocios
        PeliculaService ps = new PeliculaServiceImp();
        String page = request.getParameter("page");
        Logger logger = Logger.getLogger(this.getClass());

        if (page.equals("in")) {
            try {
                List<PeliculaFDBean> listaCover = ps.obtenerPeliculaCover();
                List<PeliculaFDBean> listaCartelera = ps.obtenerPeliculaCartelera();
                request.setAttribute("covers", listaCover);
                request.setAttribute("cartelera", listaCartelera);
            } catch (Exception ex) {
                logger.error(ex.toString().replace("'", ""), ex);
            }
        } else if (page.equals("car")) {
            try {
                List<PeliculaFDBean> listaCartelera = ps.obtenerPeliculaCartelera();
                request.setAttribute("listaCartelera", listaCartelera);
                request.setAttribute("titulo", "Peliculas en Cartelera");
                //3. Invocar al JSP
                RequestDispatcher dispa = getServletContext().
                        getRequestDispatcher("/peliculas.jsp");
                dispa.forward(request, response);
            } catch (Exception ex) {
                logger.error(ex.toString().replace("'", ""), ex);
            }
        } else if (page.equals("est")) {
            try {
                List<PeliculaFDBean> listaCartelera = ps.obtenerPeliculaEstreno();
                request.setAttribute("listaCartelera", listaCartelera);
                request.setAttribute("titulo", "Peliculas en Estreno");
                //3. Invocar al JSP
                RequestDispatcher dispa = getServletContext().
                        getRequestDispatcher("/peliculas.jsp");
                dispa.forward(request, response);
            } catch (Exception ex) {
                logger.error(ex.toString().replace("'", ""), ex);
            }
        } else if (page.equals("pro")) {
            try {
                List<PeliculaFDBean> listaCartelera = ps.obtenerPeliculaProximo();
                request.setAttribute("listaCartelera", listaCartelera);
                request.setAttribute("titulo", "Proximas peliculas");
                //3. Invocar al JSP
                RequestDispatcher dispa = getServletContext().
                        getRequestDispatcher("/peliculas.jsp");
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
