/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cibertec.cine.service;

import edu.cibertec.cine.dao.bean.SalaBean;
import java.util.List;

/**
 *
 * @author CHRISTIAN-LAP
 */
public interface SalaService {
    
    public List<SalaBean> listarSalaPorCine(int codigo) throws Exception;
    
}
