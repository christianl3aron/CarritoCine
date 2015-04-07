/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cibertec.cine.dao;

import edu.cibertec.cine.dao.bean.UsuarioBean;

/**
 *
 * @author CHRISTIAN-LAP
 */
public interface UsuarioDAO {

    public void insertar() throws Exception;

    public void eliminar() throws Exception;

    public UsuarioBean obtenerUsuario(String usuario, String clave) throws Exception;
}
