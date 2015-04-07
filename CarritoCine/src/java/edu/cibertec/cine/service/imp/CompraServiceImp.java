/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cibertec.cine.service.imp;

import edu.cibertec.cine.dao.CompraDAO;
import edu.cibertec.cine.dao.bean.CompraBean;
import edu.cibertec.cine.dao.imp.CompraDAOImp;
import edu.cibertec.cine.service.CompraService;
import java.util.List;

/**
 *
 * @author CHRISTIAN-LAP
 */
public class CompraServiceImp implements CompraService{

    @Override
    public void insertar(CompraBean compraBean) throws Exception {
        CompraDAO compraDAO=new CompraDAOImp();
        compraDAO.insertar(compraBean);
    }

    @Override
    public List<CompraBean> listarCompras(int codUsers) throws Exception {
        CompraDAO compraDAO=new CompraDAOImp();
        return compraDAO.listarCompras(codUsers);
    }
    
}
