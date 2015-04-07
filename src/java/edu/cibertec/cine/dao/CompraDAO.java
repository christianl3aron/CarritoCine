/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cibertec.cine.dao;

import edu.cibertec.cine.dao.bean.CompraBean;
import java.util.List;

/**
 *
 * @author CHRISTIAN-LAP
 */
public interface CompraDAO {

    public void insertar(CompraBean compraBean) throws Exception;
    
    public List<CompraBean> listarCompras(int codUser) throws Exception;
}
