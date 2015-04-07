/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cibertec.cine.service.imp;

import edu.cibertec.cine.dao.UsuarioDAO;
import edu.cibertec.cine.dao.bean.UsuarioBean;
import edu.cibertec.cine.dao.imp.UsuarioDAOImp;
import edu.cibertec.cine.service.LoginService;

/**
 *
 * @author CHRISTIAN-LAP
 */
public class LoginServiceImp implements LoginService {
    @Override
    public UsuarioBean validarUsuario(String usuario, String clave) throws Exception {
        UsuarioDAO usuarioDAO = new UsuarioDAOImp();
        UsuarioBean usuarioBean= usuarioDAO.obtenerUsuario(usuario, clave);
        
        return usuarioBean;
    }
}
