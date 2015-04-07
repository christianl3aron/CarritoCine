/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cibertec.cine.servlet;

import edu.cibertec.cine.dao.bean.UsuarioBean;
import edu.cibertec.cine.service.LoginService;
import edu.cibertec.cine.service.imp.LoginServiceImp;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
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
public class LoginServlet extends HttpServlet {

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

        if (accion.equals("login")) {
            try {
                String usuario = request.getParameter("txtUsuario");
                String clave = request.getParameter("txtClave");
                LoginService loginService = new LoginServiceImp();
                UsuarioBean usuarioBean = loginService.validarUsuario(usuario, clave);
                if (usuarioBean == null) {
                    request.setAttribute("mensajeError", "Ingrese bien el usuario y clave!!!");
                    RequestDispatcher dispa = getServletContext().getRequestDispatcher("/login.jsp");
                    dispa.forward(request, response);
                }
                HttpSession miSesion = request.getSession(true);
                miSesion.setAttribute("usuario", usuarioBean);
                RequestDispatcher dispa = getServletContext().getRequestDispatcher("/index.jsp");
                dispa.forward(request, response);
            } catch (Exception ex) {
                logger.error(ex.toString().replace("'", ""), ex);
            }
        } else if (accion.equals("logoff")) {
            HttpSession miSesion = request.getSession();
            miSesion.removeAttribute("usuario");
            miSesion.invalidate();
            RequestDispatcher dispa = getServletContext().getRequestDispatcher("/index.jsp");
            dispa.forward(request, response);
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
