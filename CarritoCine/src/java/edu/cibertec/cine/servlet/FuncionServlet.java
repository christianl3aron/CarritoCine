/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cibertec.cine.servlet;

import edu.cibertec.cine.dao.bean.FuncionBean;
import edu.cibertec.cine.dao.bean.GrupoCine;
import edu.cibertec.cine.dao.bean.PeliculaFDBean;
import edu.cibertec.cine.dao.bean.SalaBean;
import edu.cibertec.cine.service.CineService;
import edu.cibertec.cine.service.FuncionService;
import edu.cibertec.cine.service.PeliculaService;
import edu.cibertec.cine.service.ReporteService;
import edu.cibertec.cine.service.imp.CineServiceImp;
import edu.cibertec.cine.service.imp.FuncionServiceImp;
import edu.cibertec.cine.service.imp.PeliculaServiceImp;
import edu.cibertec.cine.service.imp.ReporteServiceImp;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import org.apache.log4j.Logger;

/**
 *
 * @author CHRISTIAN-LAP
 */
public class FuncionServlet extends HttpServlet {

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
        String accion = request.getParameter("accion");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        Date today = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(today);
        c.add(Calendar.DATE, 1);
        today = c.getTime();

        if (accion.equals("iniciar")) {
            listarFunciones(request, response);
        } else if (accion.equals("insertar")) {
            try {
                PeliculaService peliculaService = new PeliculaServiceImp();
                CineService cineService = new CineServiceImp();
                request.setAttribute("listaPelicula", peliculaService.listarPeliculaCombobox());
                request.setAttribute("listaCine", cineService.listarCineCombobox());
                request.setAttribute("today", (formatter.format(today)).toString().replace(" ", "T"));
                RequestDispatcher dispa = getServletContext().getRequestDispatcher("/mantenimiento/funciones/mantFuncionDatos.jsp");
                dispa.forward(request, response);
            } catch (Exception ex) {
                logger.error(ex.toString().replace("'", ""), ex);
            }
        } else if (accion.equals("insgrabar")) {
            try {
                Date date = formatter.parse(request.getParameter("time").replace("T", " "));
                FuncionBean funcionBean = new FuncionBean(new SalaBean(Integer.parseInt(request.getParameter("cmbSala"))),
                        new PeliculaFDBean(Integer.parseInt(request.getParameter("cmbPelicula"))),
                        Double.parseDouble(request.getParameter("txtPrecio")),
                        date);
                FuncionService funcionService = new FuncionServiceImp();
                funcionService.insertar(funcionBean);
                listarFunciones(request, response);
            } catch (Exception ex) {
                logger.error(ex.toString().replace("'", ""), ex);
                request.setAttribute("mensajeError", "No se pudo Grabar. Por favor reintente");
            }
        } else if (accion.equals("eliminar")) {
            try {
                int codigo = Integer.valueOf(request.getParameter("codigo"));
                FuncionService funcionService = new FuncionServiceImp();
                funcionService.eliminar(codigo);
                listarFunciones(request, response);
            } catch (Exception ex) {
                logger.error(ex.toString().replace("'", ""), ex);
            }
        }else if (accion.equals("imprimir")) {
            try {
                ReporteService reporteService = new ReporteServiceImp();
                List<GrupoCine> cines = reporteService.ListarFuncionesPorTodoCines();

                HttpServletRequestWrapper srw = new HttpServletRequestWrapper(request);
                JasperReport jasperReport = (JasperReport) JRLoader.loadObject(srw.getRealPath("")
                        + "/reportes/Funciones.jasper");


                JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(cines);

                byte[] datos = JasperRunManager.runReportToPdf(jasperReport,
                        null, dataSource);

                response.setContentType("application/pdf");
                response.setContentLength(datos.length);
                ServletOutputStream out = response.getOutputStream();
                out.write(datos);
                out.flush();
                out.close();
            } catch (Exception ex) {
                logger.error(ex.toString(), ex);
            }
        }
    }

    public void listarFunciones(HttpServletRequest request, HttpServletResponse response) {

        Logger logger = Logger.getLogger(this.getClass());
        try {
            FuncionService funcionService = new FuncionServiceImp();
            List<FuncionBean> lista = funcionService.listarFunciones();

            request.setAttribute("listaFuncion", lista);
            RequestDispatcher dispa = getServletContext().getRequestDispatcher("/mantenimiento/funciones/mantFuncion.jsp");
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
