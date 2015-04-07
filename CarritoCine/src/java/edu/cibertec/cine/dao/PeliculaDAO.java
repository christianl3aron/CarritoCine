/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cibertec.cine.dao;

import edu.cibertec.cine.dao.bean.PeliculaFDBean;
import java.util.Date;
import java.util.List;

/**
 *
 * @author CHRISTIAN-LAP
 */
public interface PeliculaDAO {

    public List<PeliculaFDBean> obtenerPeliculaCover() throws Exception;

    public List<PeliculaFDBean> obtenerPeliculaCartelera() throws Exception;

    public List<PeliculaFDBean> obtenerPeliculaEstreno() throws Exception;

    public List<PeliculaFDBean> obtenerPeliculaProximo() throws Exception;

    public PeliculaFDBean obtnerDetallePorID(int codigo) throws Exception;

    public List<PeliculaFDBean> listarPelicula() throws Exception;

    public void eliminarPelicula(int codigo) throws Exception;

    public void modificar(PeliculaFDBean pelicula);

    public void insertar(PeliculaFDBean pelicula);
    
    public List<PeliculaFDBean> listarPeliculaCombobox() throws Exception;
    
    public List<PeliculaFDBean> listarPeliculasPorCine(int codigo) throws Exception;

    public List<PeliculaFDBean> listarPeliculasPorCinePorFecha(int codigo, Date date) throws Exception;
}
