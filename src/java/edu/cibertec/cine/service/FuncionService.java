/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cibertec.cine.service;

import edu.cibertec.cine.dao.bean.FuncionBean;
import java.util.Date;
import java.util.List;

/**
 *
 * @author CHRISTIAN-LAP
 */
public interface FuncionService {

    public List<FuncionBean> listarFunciones() throws Exception;

    public void insertar(FuncionBean funcionBean);

    public void eliminar(int codigo) throws Exception;

    public FuncionBean obtenerFuncionPorId(int codigo) throws Exception;

    public List<FuncionBean> listarFuncionesPorSala(int codigo) throws Exception;

    public List<FuncionBean> listarFuncionesPorCine(int codigo) throws Exception;

    public List<FuncionBean> listarFuncionesPorCinePorFecha(int codigo,Date diaFuncion) throws Exception;
    
    public List<FuncionBean> listarFuncionesPorCinePorPeliculaPorFecha(int codCine, int codPe,Date diaFuncion) throws Exception;
}
