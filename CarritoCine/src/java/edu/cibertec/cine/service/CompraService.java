/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cibertec.cine.service;

import edu.cibertec.cine.dao.bean.CompraBean;
import java.util.List;

/**
 *
 * @author CHRISTIAN-LAP
 */
public interface CompraService {

    public void insertar(CompraBean compraBean) throws Exception;

    public List<CompraBean> listarCompras(int codUsers) throws Exception;
}
