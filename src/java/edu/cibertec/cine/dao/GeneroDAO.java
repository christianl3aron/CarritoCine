/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cibertec.cine.dao;

import edu.cibertec.cine.dao.bean.GeneroBean;
import java.util.List;

/**
 *
 * @author CHRISTIAN-LAP
 */
public interface GeneroDAO {

    public List<GeneroBean> listarGenero() throws Exception;
}
