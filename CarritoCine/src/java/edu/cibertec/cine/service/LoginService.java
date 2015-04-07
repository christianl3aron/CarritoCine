/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cibertec.cine.service;

import edu.cibertec.cine.dao.bean.UsuarioBean;

/**
 *
 * @author CHRISTIAN-LAP
 */
public interface LoginService {
    
    public UsuarioBean validarUsuario(String usuario,String clave) throws Exception;
    
}
