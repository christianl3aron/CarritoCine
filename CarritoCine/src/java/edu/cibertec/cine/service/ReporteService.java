/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cibertec.cine.service;

import edu.cibertec.cine.dao.bean.GrupoCine;
import java.util.List;

/**
 *
 * @author CHRISTIAN-LAP
 */
public interface ReporteService {
    
    public List<GrupoCine> ListarFuncionesPorTodoCines() throws Exception;
}
