/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cibertec.cine.service.imp;

import edu.cibertec.cine.dao.CineDAO;
import edu.cibertec.cine.dao.bean.CineBean;
import edu.cibertec.cine.dao.imp.CineDAOImp;
import edu.cibertec.cine.service.CineService;
import java.util.List;

/**
 *
 * @author CHRISTIAN-LAP
 */
public class CineServiceImp implements CineService {

    @Override
    public List<CineBean> listarCineLima() throws Exception {
        CineDAO cineDAO = new CineDAOImp();
        return cineDAO.listarCineLima();
    }

    @Override
    public List<CineBean> listarCineOtros() throws Exception {
        CineDAO cineDAO = new CineDAOImp();
        return cineDAO.listarCineOtros();
    }

    @Override
    public List<CineBean> listarCineCombobox() throws Exception {
        CineDAO cineDAO = new CineDAOImp();
        return cineDAO.listarCineCombobox();
    }

    @Override
    public CineBean obtenerCinePorId(int codigo) throws Exception {
CineDAO cineDAO = new CineDAOImp();
        return cineDAO.obtenerCinePorId(codigo);
    }
}
