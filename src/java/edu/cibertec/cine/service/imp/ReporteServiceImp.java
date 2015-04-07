/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cibertec.cine.service.imp;

import edu.cibertec.cine.dao.bean.CineBean;
import edu.cibertec.cine.dao.bean.FuncionBean;
import edu.cibertec.cine.dao.bean.GrupoCine;
import edu.cibertec.cine.service.CineService;
import edu.cibertec.cine.service.FuncionService;
import edu.cibertec.cine.service.ReporteService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CHRISTIAN-LAP
 */
public class ReporteServiceImp implements ReporteService {

    @Override
    public List<GrupoCine> ListarFuncionesPorTodoCines() throws Exception {

        List<GrupoCine> lista = new ArrayList<GrupoCine>();

        CineService cineService = new CineServiceImp();
        List<CineBean> cines = cineService.listarCineCombobox();

        FuncionService funcionService = new FuncionServiceImp();

        for (int i = 0; i < cines.size(); i++) {
            List<FuncionBean> funciones=funcionService.listarFuncionesPorCine(cines.get(i).getCodigo());
            
            GrupoCine cine = new GrupoCine();
            cine.setCineBean(cines.get(i));
            cine.setLista(funciones);
            lista.add(cine);
        }
        return lista;
    }
}
