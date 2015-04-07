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
import java.util.Date;
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
public class DetailServlet extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //1.  valida la variable de entrada
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        String obj = request.getParameter("obj");
        Logger logger = Logger.getLogger(this.getClass());


        if (obj.equals("pelicula")) {
            try {
                PeliculaService peliculaService = new PeliculaServiceImp();
                PeliculaFDBean peliculaFDBean = peliculaService.obtenerDetallePelicula(codigo);
                request.setAttribute("peliculaFD", peliculaFDBean);
                RequestDispatcher dispa = getServletContext().getRequestDispatcher("/detailPelicula.jsp");
                dispa.forward(request, response);
            } catch (Exception ex) {
                logger.error(ex.toString().replace("'", ""), ex);
            }
        } else if (obj.equals("cine")) {
            try {
                CineService cineService = new CineServiceImp();
                CineBean cineBean = cineService.obtenerCinePorId(codigo);
                FuncionService funcionService = new FuncionServiceImp();
                List<FuncionBean> listaFuncion = funcionService.listarFuncionesPorCinePorFecha(codigo, new Date());
                PeliculaService peliculaService = new PeliculaServiceImp();
                List<PeliculaFDBean> listaPelicula = peliculaService.listarPeliculasPorCinePorFecha(codigo, new Date());

                request.setAttribute("cineBean", cineBean);
                request.setAttribute("listaFuncion", listaFuncion);
                request.setAttribute("listaPelicula", listaPelicula);

                RequestDispatcher dispa = getServletContext().getRequestDispatcher("/DetailCine.jsp");
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
