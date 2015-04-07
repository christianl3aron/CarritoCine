/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cibertec.cine.service.imp;

import edu.cibertec.cine.dao.FuncionDAO;
import edu.cibertec.cine.dao.bean.FuncionBean;
import edu.cibertec.cine.dao.imp.FuncionDAOImp;
import edu.cibertec.cine.service.FuncionService;
import java.util.Date;
import java.util.List;

/**
 *
 * @author CHRISTIAN-LAP
 */
public class FuncionServiceImp implements FuncionService {

    @Override
    public List<FuncionBean> listarFunciones() throws Exception {
        FuncionDAO funcionDAO = new FuncionDAOImp();
        return funcionDAO.listarFunciones();
    }

    @Override
    public void insertar(FuncionBean funcionBean){
        FuncionDAO funcionDAO = new FuncionDAOImp();
        funcionDAO.insertar(funcionBean);
    }

    @Override
    public List<FuncionBean> listarFuncionesPorSala(int codigo) throws Exception {
        FuncionDAO funcionDAO = new FuncionDAOImp();
        return funcionDAO.listarFuncionesPorSala(codigo);
    }

    @Override
    public List<FuncionBean> listarFuncionesPorCine(int codigo) throws Exception {
        FuncionDAO funcionDAO = new FuncionDAOImp();
        return funcionDAO.listarFuncionesPorCine(codigo);
    }

    @Override
    public List<FuncionBean> listarFuncionesPorCinePorFecha(int codigo, Date diaFuncion) throws Exception {
        FuncionDAO funcionDAO = new FuncionDAOImp();
        return funcionDAO.listarFuncionesPorCinePorFecha(codigo, diaFuncion);
    }

    @Override
    public List<FuncionBean> listarFuncionesPorCinePorPeliculaPorFecha(int codCine, int codPel, Date diaFuncion) throws Exception {
        FuncionDAO funcionDAO = new FuncionDAOImp();
        return funcionDAO.listarFuncionesPorCinePorPeliculaPorFecha(codCine, codPel, diaFuncion);
    }

    @Override
    public FuncionBean obtenerFuncionPorId(int codigo) throws Exception {
        FuncionDAO funcionDAO = new FuncionDAOImp();
        return funcionDAO.obtenerFuncionPorId(codigo);
    }

    @Override
    public void eliminar(int codigo) throws Exception {
        FuncionDAO funcionDAO = new FuncionDAOImp();
        funcionDAO.eliminar(codigo);
    }
}
