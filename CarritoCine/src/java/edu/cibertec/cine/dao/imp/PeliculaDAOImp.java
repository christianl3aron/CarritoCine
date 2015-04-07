/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cibertec.cine.dao.imp;

import edu.cibertec.cine.dao.PeliculaDAO;
import edu.cibertec.cine.dao.bean.PeliculaFDBean;
import edu.cibertec.cine.util.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author CHRISTIAN-LAP
 */
public class PeliculaDAOImp implements PeliculaDAO {

    @Override
    public List<PeliculaFDBean> obtenerPeliculaCover() throws Exception {

        StringBuilder cadena = new StringBuilder();
        cadena.append("select p.idcv_pelicula,p.titulo, p.img_portada, p.img_1 from cv_pelicula p ");
        cadena.append("where p.img_portada is not null and flag=\"S\"");
        return getListaPeliculaLight(cadena.toString());
    }

    @Override
    public List<PeliculaFDBean> obtenerPeliculaCartelera() throws Exception {

        StringBuilder cadena = new StringBuilder();
        cadena.append("select p.idcv_pelicula,p.titulo, p.img_portada, p.img_1 from cv_pelicula p ");
        cadena.append("inner join cv_funcion f on f.id_pelicula=p.idcv_pelicula and f.hora>now() group by p.idcv_pelicula");
        return getListaPeliculaLight(cadena.toString());
    }

    @Override
    public List<PeliculaFDBean> obtenerPeliculaProximo() throws Exception {

        List<PeliculaFDBean> lista = null;
        StringBuilder cadena = new StringBuilder();
        cadena.append("select p.idcv_pelicula,p.titulo, p.img_portada, p.img_1,p.fecha_estreno,DATEDIFF(p.fecha_estreno,now()) as 'fecha' from cv_pelicula p ");
        Connection cn = ConexionBD.getInstance().obtenerConexion();
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(cadena.toString());
        lista = new ArrayList<PeliculaFDBean>();
        while (rs.next()) {
            if (rs.getInt("fecha") > 14) {
                PeliculaFDBean peliculaBean = new PeliculaFDBean(rs.getInt("idcv_pelicula"),
                        rs.getString("titulo"),
                        rs.getString("img_portada"),
                        rs.getString("img_1"));
                lista.add(peliculaBean);
            }
        }
        st.close();
        cn.close();
        return lista;
    }

    @Override
    public PeliculaFDBean obtnerDetallePorID(int codigo) throws Exception {

        PeliculaFDBean pelicualFDBean = null;
        StringBuilder sb = new StringBuilder("");
        sb.append("select p.idcv_pelicula, p.titulo, p.duracion, p.actores, p.sinopsis, p.pais_origen, p.director, p.trailer,p.img_portada, p.img_1, p.img_2, p.img_3, p.img_4, p.puntuacion, p.fecha_estreno, p.f3d, g.denominacion ");
        sb.append("from cv_pelicula p inner join cv_genero g on p.id_genero=g.idcv_genero ");
        sb.append("where p.idcv_pelicula = ? and flag=\"S\"");
        Connection cn = ConexionBD.getInstance().obtenerConexion();
        PreparedStatement ps = cn.prepareStatement(sb.toString());
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            pelicualFDBean = new PeliculaFDBean(rs.getInt("idcv_pelicula"),
                    rs.getString("titulo"), rs.getInt("duracion"),
                    rs.getString("actores"), rs.getString("sinopsis"),
                    rs.getString("pais_origen"), rs.getString("director"),
                    rs.getString("trailer"), rs.getString("img_portada"),
                    rs.getString("img_1"), rs.getString("img_2"),
                    rs.getString("img_3"), rs.getString("img_4"),
                    rs.getDouble("puntuacion"), rs.getDate("fecha_estreno"),
                    rs.getString("f3d"), rs.getString("denominacion"));
        }
        ps.close();
        cn.close();
        return pelicualFDBean;
    }

    @Override
    public List<PeliculaFDBean> listarPelicula() throws Exception {

        List<PeliculaFDBean> lista = new ArrayList<PeliculaFDBean>();
        StringBuilder sb = new StringBuilder("");
        sb.append("select p.idcv_pelicula, p.titulo, p.duracion, p.actores, p.sinopsis, p.pais_origen, p.director, p.trailer,p.img_portada, p.img_1, p.img_2, p.img_3, p.img_4, p.puntuacion, p.fecha_estreno, p.f3d, g.denominacion ");
        sb.append("from cv_pelicula p inner join cv_genero g on p.id_genero=g.idcv_genero where flag=\"S\" order by idcv_pelicula");
        Connection cn = ConexionBD.getInstance().obtenerConexion();
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sb.toString());
        while (rs.next()) {
            PeliculaFDBean pelicualFDBean = new PeliculaFDBean(rs.getInt("idcv_pelicula"),
                    rs.getString("titulo"), rs.getInt("duracion"),
                    rs.getString("actores"), rs.getString("sinopsis"),
                    rs.getString("pais_origen"), rs.getString("director"),
                    rs.getString("trailer"), rs.getString("img_portada"),
                    rs.getString("img_1"), rs.getString("img_2"),
                    rs.getString("img_3"), rs.getString("img_4"),
                    rs.getDouble("puntuacion"), rs.getDate("fecha_estreno"),
                    rs.getString("f3d"), rs.getString("denominacion"));
            lista.add(pelicualFDBean);
        }
        st.close();
        cn.close();
        return lista;
    }

    @Override
    public void eliminarPelicula(int codigo) throws Exception {

        StringBuilder sb = new StringBuilder("");
        sb.append("update cv_pelicula set flag=\"N\" where idcv_pelicula=?");
        Connection cn = ConexionBD.getInstance().obtenerConexion();
        PreparedStatement ps = cn.prepareStatement(sb.toString());
        ps.setInt(1, codigo);
        ps.execute();
        
        StringBuilder db = new StringBuilder("");
        db.append("delete from cv_funcion  where id_pelicula=?");
        PreparedStatement ps2 = cn.prepareStatement(db.toString());
        ps2.setInt(1, codigo);
        ps2.execute();
        ps.close();
        cn.close();
    }

    @Override
    public void modificar(PeliculaFDBean pelicula) {

        Logger logger = Logger.getLogger(this.getClass());
        Connection cn = null;
        try {
            cn = ConexionBD.getInstance().obtenerConexion();
            cn.setAutoCommit(false);
            PreparedStatement ps = cn.prepareStatement(
                    "update cv_pelicula set titulo=?, duracion=?, actores=?, sinopsis=?, director=?, id_genero=?, trailer=?, pais_origen=?, img_portada=?, img_1=? where idcv_pelicula=?");
            ps.setString(1, pelicula.getTitulo());
            ps.setInt(2, pelicula.getDuracion());
            ps.setString(3, pelicula.getActores());
            ps.setString(4, pelicula.getSinopsis());
            ps.setString(5, pelicula.getDirector());
            ps.setInt(6, Integer.valueOf(pelicula.getGenero()));
            ps.setString(7, pelicula.getTrailer());
            ps.setString(8, pelicula.getPaisOrigen());
            ps.setString(9, pelicula.getImg_portada());
            ps.setString(10, pelicula.getImg_1());
            ps.setInt(11, pelicula.getCodigo());
            ps.execute();
            cn.commit();
            cn.close();
        } catch (Exception ex) {
            logger.error(ex.toString().replace("'", ""), ex);
            try {
                if (cn != null) {
                    cn.rollback();
                }
            } catch (SQLException ex2) {
                logger.error(ex2.toString().replace("'", ""), ex2);
            }
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException ex3) {
                logger.error(ex3.toString().replace("'", ""), ex3);
            }
        }
    }

    @Override
    public void insertar(PeliculaFDBean peliculaFD) {

        Logger logger = Logger.getLogger(this.getClass());
        Connection cn = null;
        try {
            cn = ConexionBD.getInstance().obtenerConexion();
            cn.setAutoCommit(false);
            PreparedStatement ps = cn.prepareStatement(
                    "insert into cv_pelicula(titulo,duracion,actores,sinopsis,pais_origen,director,trailer,img_portada,img_1,img_2,img_3,img_4,fecha_estreno,f3d,id_genero,flag) values(?,?,?,?,?,?,?,?,?,?,?,?,?,'S',?,'S')");
            ps.setString(1, peliculaFD.getTitulo());
            ps.setInt(2, peliculaFD.getDuracion());
            ps.setString(3, peliculaFD.getActores());
            ps.setString(4, peliculaFD.getSinopsis());
            ps.setString(5, peliculaFD.getPaisOrigen());
            ps.setString(6, peliculaFD.getDirector());
            ps.setString(7, peliculaFD.getTrailer());
            ps.setString(8, peliculaFD.getImg_portada());
            ps.setString(9, peliculaFD.getImg_1());
            ps.setString(10, peliculaFD.getImg_2());
            ps.setString(11, peliculaFD.getImg_3());
            ps.setString(12, peliculaFD.getImg_4());
            java.sql.Date sql = new java.sql.Date(peliculaFD.getFechaEstreno().getTime());
            ps.setDate(13, sql);
            ps.setInt(14, Integer.valueOf(peliculaFD.getGenero()));
            ps.execute();
            cn.commit();
            cn.close();
        } catch (Exception ex) {
            logger.error(ex.toString().replace("'", ""), ex);
            try {
                if (cn != null) {
                    cn.rollback();
                }
            } catch (SQLException ex2) {
                logger.error(ex2.toString().replace("'", ""), ex2);
            }
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException ex3) {
                logger.error(ex3.toString().replace("'", ""), ex3);
            }
        }
    }

    @Override
    public List<PeliculaFDBean> obtenerPeliculaEstreno() throws Exception {
        List<PeliculaFDBean> lista = null;
        StringBuilder cadena = new StringBuilder();
        cadena.append("select p.idcv_pelicula,p.titulo, p.img_portada, p.img_1,MIN(DATEDIFF(f.hora,now())) 'fecha', f.hora ");
        cadena.append("from cv_pelicula p inner join cv_funcion f on f.id_pelicula=p.idcv_pelicula group by p.idcv_pelicula");
        Connection cn = ConexionBD.getInstance().obtenerConexion();
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(cadena.toString());
        lista = new ArrayList<PeliculaFDBean>();
        while (rs.next()) {
            if (rs.getInt("fecha") < 7 && rs.getInt("fecha") > -7) {
                PeliculaFDBean peliculaBean = new PeliculaFDBean(rs.getInt("idcv_pelicula"),
                        rs.getString("titulo"),
                        rs.getString("img_portada"),
                        rs.getString("img_1"));
                lista.add(peliculaBean);
            }
        }
        st.close();
        cn.close();
        return lista;
    }

    @Override
    public List<PeliculaFDBean> listarPeliculaCombobox() throws Exception {

        List<PeliculaFDBean> lista = null;
        StringBuilder cadena = new StringBuilder();
        cadena.append("select p.idcv_pelicula, p.titulo from cv_pelicula p where p.flag=\"S\" order by p.fecha_estreno desc");
        Connection cn = ConexionBD.getInstance().obtenerConexion();
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(cadena.toString());
        lista = new ArrayList<PeliculaFDBean>();
        while (rs.next()) {
            PeliculaFDBean peliculaFDBean = new PeliculaFDBean(rs.getInt("idcv_pelicula"), rs.getString("titulo"));
            lista.add(peliculaFDBean);
        }
        st.close();
        cn.close();
        return lista;
    }

    @Override
    public List<PeliculaFDBean> listarPeliculasPorCine(int codigo) throws Exception {

        List<PeliculaFDBean> lista = null;
        StringBuilder cadena = new StringBuilder();
        cadena.append("select f.id_pelicula, p.titulo, p.img_1, p.duracion  from cv_funcion f ");
        cadena.append("inner join cv_sala s on s.idcv_sala=f.id_sala ");
        cadena.append("inner join cv_cine c on c.idcv_cine=s.id_cine ");
        cadena.append("inner join cv_pelicula p on p.idcv_pelicula=f.id_pelicula ");
        cadena.append("where c.idcv_cine=? and f.hora>now() ");
        cadena.append("group by f.id_pelicula order by f.id_pelicula");
        Connection cn = ConexionBD.getInstance().obtenerConexion();
        PreparedStatement ps = cn.prepareStatement(cadena.toString());
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();
        lista = new ArrayList<PeliculaFDBean>();
        while (rs.next()) {
            PeliculaFDBean peliculaFDBean = new PeliculaFDBean(rs.getInt("id_pelicula"),
                    rs.getString("titulo"), rs.getString("img_1"), rs.getInt("duracion"));
            lista.add(peliculaFDBean);
        }
        ps.close();
        cn.close();
        return lista;
    }

    @Override
    public List<PeliculaFDBean> listarPeliculasPorCinePorFecha(int codigo, Date diaFuncion) throws Exception {

        List<PeliculaFDBean> lista = null;
        StringBuilder cadena = new StringBuilder();
        cadena.append("select f.id_pelicula, p.titulo, p.img_1, p.duracion  from cv_funcion f ");
        cadena.append("inner join cv_sala s on s.idcv_sala=f.id_sala ");
        cadena.append("inner join cv_cine c on c.idcv_cine=s.id_cine ");
        cadena.append("inner join cv_pelicula p on p.idcv_pelicula=f.id_pelicula ");
        cadena.append("where c.idcv_cine=? and DATE_FORMAT(f.hora, \"%Y-%m-%d\")=? ");
        cadena.append("group by f.id_pelicula order by f.id_pelicula");
        Connection cn = ConexionBD.getInstance().obtenerConexion();
        PreparedStatement ps = cn.prepareStatement(cadena.toString());
        ps.setInt(1, codigo);
        java.sql.Date sql = new java.sql.Date(diaFuncion.getTime());
        ps.setDate(2, sql);
        ResultSet rs = ps.executeQuery();
        lista = new ArrayList<PeliculaFDBean>();
        while (rs.next()) {
            PeliculaFDBean peliculaFDBean = new PeliculaFDBean(rs.getInt("id_pelicula"),
                    rs.getString("titulo"), rs.getString("img_1"), rs.getInt("duracion"));
            lista.add(peliculaFDBean);
        }
        ps.close();
        cn.close();
        return lista;
    }

    private List<PeliculaFDBean> getListaPeliculaLight(String query) throws Exception {

        List<PeliculaFDBean> lista = null;
        Connection cn = ConexionBD.getInstance().obtenerConexion();
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(query);
        lista = new ArrayList<PeliculaFDBean>();
        while (rs.next()) {
            PeliculaFDBean peliculaBean = new PeliculaFDBean(rs.getInt("idcv_pelicula"),
                    rs.getString("titulo"),
                    rs.getString("img_portada"),
                    rs.getString("img_1"));
            lista.add(peliculaBean);
        }
        st.close();
        cn.close();
        return lista;
    }
}
