/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cibertec.cine.dao;

import edu.cibertec.cine.dao.bean.CineBean;
import java.util.List;

/**
 *
 * @author CHRISTIAN-LAP
 */
public interface CineDAO {

    public List<CineBean> listarCineLima() throws Exception;

    public List<CineBean> listarCineOtros() throws Exception;

    public List<CineBean> listarCineCombobox() throws Exception;

    public CineBean obtenerCinePorId(int codigo) throws Exception;
}
