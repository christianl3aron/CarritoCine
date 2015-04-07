/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cibertec.cine.service.imp;

import edu.cibertec.cine.dao.PeliculaDAO;
import edu.cibertec.cine.dao.bean.PeliculaFDBean;
import edu.cibertec.cine.dao.imp.PeliculaDAOImp;
import edu.cibertec.cine.service.PeliculaService;
import java.util.Date;
import java.util.List;

/**
 *
 * @author CHRISTIAN-LAP
 */
public class PeliculaServiceImp implements PeliculaService {

    @Override
    public List<PeliculaFDBean> obtenerPeliculaCover() throws Exception {

        PeliculaDAO peliculaDAO = new PeliculaDAOImp();
        List<PeliculaFDBean> lista = peliculaDAO.obtenerPeliculaCover();
        return lista;
    }

    @Override
    public List<PeliculaFDBean> obtenerPeliculaCartelera() throws Exception {

        PeliculaDAO peliculaDAO = new PeliculaDAOImp();
        List<PeliculaFDBean> lista = peliculaDAO.obtenerPeliculaCartelera();
        return lista;
    }

    @Override
    public PeliculaFDBean obtenerDetallePelicula(int codigo) throws Exception {

        PeliculaDAO peliculaDAO = new PeliculaDAOImp();
        return peliculaDAO.obtnerDetallePorID(codigo);
    }

    @Override
    public List<PeliculaFDBean> listarPelicula() throws Exception {

        PeliculaDAO peliculaDAO = new PeliculaDAOImp();
        return peliculaDAO.listarPelicula();

    }

    @Override
    public void eliminarPelicula(int codigo) throws Exception {
        PeliculaDAO peliculaDAO = new PeliculaDAOImp();
        peliculaDAO.eliminarPelicula(codigo);
    }

    @Override
    public void modificar(PeliculaFDBean pelicula){
        PeliculaDAO peliculaDAO = new PeliculaDAOImp();
        peliculaDAO.modificar(pelicula);

    }

    @Override
    public void insertar(PeliculaFDBean pelicula){
        PeliculaDAO peliculaDAO = new PeliculaDAOImp();
        peliculaDAO.insertar(pelicula);
    }

    @Override
    public List<PeliculaFDBean> obtenerPeliculaEstreno() throws Exception {
        PeliculaDAO peliculaDAO = new PeliculaDAOImp();
        return peliculaDAO.obtenerPeliculaEstreno();
    }

    @Override
    public List<PeliculaFDBean> obtenerPeliculaProximo() throws Exception {
        PeliculaDAO peliculaDAO = new PeliculaDAOImp();
        return peliculaDAO.obtenerPeliculaProximo();
    }

    @Override
    public List<PeliculaFDBean> listarPeliculaCombobox() throws Exception {
        PeliculaDAO peliculaDAO = new PeliculaDAOImp();
        return peliculaDAO.listarPeliculaCombobox();
    }

    @Override
    public List<PeliculaFDBean> listarPeliculasPorCine(int codigo) throws Exception {
        PeliculaDAO peliculaDAO = new PeliculaDAOImp();
        return peliculaDAO.listarPeliculasPorCine(codigo);
    }

    @Override
    public List<PeliculaFDBean> listarPeliculasPorCinePorFecha(int codigo, Date date) throws Exception {
        PeliculaDAO peliculaDAO = new PeliculaDAOImp();
        return peliculaDAO.listarPeliculasPorCinePorFecha(codigo,date);
    }
}
