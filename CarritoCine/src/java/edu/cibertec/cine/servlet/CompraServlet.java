/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cibertec.cine.servlet;

import edu.cibertec.cine.dao.bean.CompraBean;
import edu.cibertec.cine.dao.bean.FuncionBean;
import edu.cibertec.cine.dao.bean.UsuarioBean;
import edu.cibertec.cine.service.CompraService;
import edu.cibertec.cine.service.FuncionService;
import edu.cibertec.cine.service.imp.CompraServiceImp;
import edu.cibertec.cine.service.imp.FuncionServiceImp;
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
public class CompraServlet extends HttpServlet {

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

        if (accion.equals("agregar")) {
            try {
                int codFuncion = Integer.parseInt(request.getParameter("codFuncion"));
                FuncionService funcionService = new FuncionServiceImp();
                FuncionBean funcionBean = funcionService.obtenerFuncionPorId(codFuncion);
                request.setAttribute("funcionBean", funcionBean);
                RequestDispatcher dispa = getServletContext().getRequestDispatcher("/compra.jsp");
                dispa.forward(request, response);
            } catch (Exception ex) {
                logger.error(ex.toString().replace("'", ""), ex);
            }

        } else if (accion.equals("comprar")) {
            try {
                //1 recibe codigo de funcion codigo usuario y datos de compra
                int codFuncion = Integer.parseInt(request.getParameter("codFuncion"));

                //2 graba en la session y manda al index
                int cantidad = Integer.parseInt(request.getParameter("cantidad"));
                int codUsuario = Integer.parseInt(request.getParameter("user"));

                CompraBean compraBean = new CompraBean(new UsuarioBean(codUsuario), new FuncionBean(codFuncion), cantidad);
                CompraService compraService = new CompraServiceImp();
                compraService.insertar(compraBean);

                RequestDispatcher dispa = getServletContext().getRequestDispatcher("/index.jsp");
                dispa.forward(request, response);
            } catch (Exception ex) {
                logger.error(ex.toString().replace("'", ""), ex);
            }

        } else if (accion.equals("carrito")) {

            try {
                int codigo = Integer.parseInt(request.getParameter("codUser"));
                CompraService compraService = new CompraServiceImp();
                List<CompraBean> listaCompras = compraService.listarCompras(codigo);
                request.setAttribute("listaCompras", listaCompras);
                RequestDispatcher dispa = getServletContext().getRequestDispatcher("/mistickets.jsp");
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
