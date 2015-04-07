/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cibertec.cine.service.imp;

import edu.cibertec.cine.dao.SalaDAO;
import edu.cibertec.cine.dao.bean.SalaBean;
import edu.cibertec.cine.dao.imp.SalaDAOImp;
import edu.cibertec.cine.service.SalaService;
import java.util.List;

/**
 *
 * @author CHRISTIAN-LAP
 */
public class SalaServiceImp implements SalaService{

    @Override
    public List<SalaBean> listarSalaPorCine(int codigo) throws Exception {
        SalaDAO salaDAO = new SalaDAOImp();
        return salaDAO.listarSalaPorCine(codigo);
    }
    
}
