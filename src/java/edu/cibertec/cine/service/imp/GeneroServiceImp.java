/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cibertec.cine.service.imp;

import edu.cibertec.cine.dao.GeneroDAO;
import edu.cibertec.cine.dao.bean.GeneroBean;
import edu.cibertec.cine.dao.imp.GeneroDAOImp;
import edu.cibertec.cine.service.GeneroService;
import java.util.List;

/**
 *
 * @author CHRISTIAN-LAP
 */
public class GeneroServiceImp implements GeneroService {

    @Override
    public List<GeneroBean> listarGenero() throws Exception {
        GeneroDAO generoDAO = new GeneroDAOImp();
        return generoDAO.listarGenero();
    }
}
