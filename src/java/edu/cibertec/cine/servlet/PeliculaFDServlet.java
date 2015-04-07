/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cibertec.cine.servlet;

import edu.cibertec.cine.dao.bean.PeliculaFDBean;
import edu.cibertec.cine.service.GeneroService;
import edu.cibertec.cine.service.PeliculaService;
import edu.cibertec.cine.service.imp.GeneroServiceImp;
import edu.cibertec.cine.service.imp.PeliculaServiceImp;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
public class PeliculaFDServlet extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        Logger logger = Logger.getLogger(this.getClass());
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date today = new Date();

        if (accion.equals("iniciar")) {
            listarPeliculas(request, response);
        } else if (accion.equals("eliminar")) {
            try {
                int codigo = Integer.valueOf(request.getParameter("codigo"));
                PeliculaService peliculaService = new PeliculaServiceImp();
                peliculaService.eliminarPelicula(codigo);
                listarPeliculas(request, response);
            } catch (Exception ex) {
                logger.error(ex.toString().replace("'", ""), ex);
            }
        } else if (accion.equals("modificar")) {
            try {
                //1. Recuperar el codigo
                int codigo = Integer.parseInt(request.getParameter("codigo"));
                PeliculaService peliculaService = new PeliculaServiceImp();
                PeliculaFDBean peliculaFDBean = peliculaService.obtenerDetallePelicula(codigo);
                request.setAttribute("peliculaFD", peliculaFDBean);
                request.setAttribute("tipoGrabacion", "modgrabar");
                llamarPaginaDatos(request, response);

            } catch (Exception ex) {
                logger.error(ex.toString().replace("'", ""), ex);
                request.setAttribute("mensajeError", "No se pudo realizar la operación. Por favor reintente");
                listarPeliculas(request, response);
            }
        } else if (accion.equals("modgrabar")) {
            try {
                PeliculaFDBean peliculaFDBean = new PeliculaFDBean(
                        Integer.parseInt(request.getParameter("codigoPar")),
                        request.getParameter("txtTitulo"),
                        Integer.parseInt(request.getParameter("txtDuracion")),
                        request.getParameter("txtActores"),
                        request.getParameter("txtSinopsis"),
                        request.getParameter("txtPais"),
                        request.getParameter("txtDirector"),
                        request.getParameter("txtTrailer"),
                        (request.getParameter("txtImgPortada") == null) ? null : "peliculas/portada/" + request.getParameter("txtImgPortada"),
                        (request.getParameter("txtImagen1") == null) ? null : "peliculas/sm/" + request.getParameter("txtImagen1"),
                        (request.getParameter("txtImagen2") == null) ? null : "peliculas/sm/" + request.getParameter("txtImagen2"),
                        (request.getParameter("txtImagen3") == null) ? null : "peliculas/sm/" + request.getParameter("txtImagen3"),
                        (request.getParameter("txtImagen4") == null) ? null : "peliculas/sm/" + request.getParameter("txtImagen4"),
                        4.0, null, "N", request.getParameter("cmbTipo"));
                PeliculaService peliculaService = new PeliculaServiceImp();
                peliculaService.modificar(peliculaFDBean);
                listarPeliculas(request, response);
            } catch (Exception ex) {
                logger.error(ex.toString().replace("'", ""), ex);
                request.setAttribute("mensajeError", "No se pudo Grabar. Por favor reintente");
                llamarPaginaDatos(request, response);
            }
        } else if (accion.equals("insertar")) {

            request.setAttribute("tipoGrabacion", "insgrabar");
            PeliculaFDBean peliculaFDBean = new PeliculaFDBean(0, "", 0, "", "", "", "", "", "", "", "", "", "", 0, null, "N", "Terror");
            request.setAttribute("today", dateFormat.format(today));
            request.setAttribute("peliculaFD", peliculaFDBean);
            llamarPaginaDatos(request, response);
        } else if (accion.equals("insgrabar")) {

            try {
                //1. capturar los parametros
                Date date = dateFormat.parse(request.getParameter("txtFecha"));
                PeliculaFDBean peliculaFDBean = new PeliculaFDBean(
                        request.getParameter("txtTitulo"),
                        Integer.parseInt(request.getParameter("txtDuracion")),
                        request.getParameter("txtActores"),
                        request.getParameter("txtSinopsis"),
                        request.getParameter("txtPais"),
                        request.getParameter("txtDirector"),
                        request.getParameter("txtTrailer"),
                        (request.getParameter("txtImgPortada") == null) ? null : "peliculas/portada/" + request.getParameter("txtImgPortada"),
                        (request.getParameter("txtImagen1") == null) ? null : "peliculas/sm/" + request.getParameter("txtImagen1"),
                        (request.getParameter("txtImagen2") == null) ? null : "peliculas/sm/" + request.getParameter("txtImagen2"),
                        (request.getParameter("txtImagen3") == null) ? null : "peliculas/sm/" + request.getParameter("txtImagen3"),
                        (request.getParameter("txtImagen4") == null) ? null : "peliculas/sm/" + request.getParameter("txtImagen4"),
                        date,
                        request.getParameter("cmbTipo"));
                PeliculaService peliculaService = new PeliculaServiceImp();
                peliculaService.insertar(peliculaFDBean);
                listarPeliculas(request, response);
            } catch (Exception ex) {
                logger.error(ex.toString().replace("'", ""), ex);
                request.setAttribute("mensajeError", "No se pudo Grabar. Por favor reintente");
                llamarPaginaDatos(request, response);
            }
        }
    }

    public void llamarPaginaDatos(HttpServletRequest request, HttpServletResponse response) {

        Logger logger = Logger.getLogger(this.getClass());
        try {
            GeneroService generoService = new GeneroServiceImp();
            request.setAttribute("listaTipo", generoService.listarGenero());
            RequestDispatcher dispa = getServletContext().getRequestDispatcher("/mantenimiento/pelicula/mantPeliculaDatos.jsp");
            dispa.forward(request, response);
        } catch (Exception ex) {
            logger.error(ex.toString().replace("'", ""), ex);
        }
    }

    public void listarPeliculas(HttpServletRequest request, HttpServletResponse response) {

        Logger logger = Logger.getLogger(this.getClass());
        try {
            PeliculaService peliculaService = new PeliculaServiceImp();
            List<PeliculaFDBean> lista = peliculaService.listarPelicula();

            request.setAttribute("listaPelicula", lista);
            RequestDispatcher dispa = getServletContext().
                    getRequestDispatcher("/mantenimiento/pelicula/mantPelicula.jsp");
            dispa.forward(request, response);
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
