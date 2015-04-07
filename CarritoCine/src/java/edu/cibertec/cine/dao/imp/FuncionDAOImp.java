/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cibertec.cine.dao.imp;

import edu.cibertec.cine.dao.FuncionDAO;
import edu.cibertec.cine.dao.bean.CineBean;
import edu.cibertec.cine.dao.bean.FuncionBean;
import edu.cibertec.cine.dao.bean.PeliculaFDBean;
import edu.cibertec.cine.dao.bean.SalaBean;
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
public class FuncionDAOImp implements FuncionDAO {

    @Override
    public List<FuncionBean> listarFunciones() throws Exception {

        List<FuncionBean> lista = null;
        StringBuilder cadena = new StringBuilder();
        cadena.append("select f.idcv_funcion,s.idcv_sala,s.num_sala , c.idcv_cine, c.nombre, s.aforo, p.idcv_pelicula, p.titulo, p.img_1, p.duracion , f.precio, f.hora ");
        cadena.append("from cv_funcion f ");
        cadena.append("inner join cv_pelicula p on p.idcv_pelicula=f.id_pelicula ");
        cadena.append("inner join cv_sala s on s.idcv_sala=f.id_sala ");
        cadena.append("inner join cv_cine c on c.idcv_cine=s.id_cine ");
        cadena.append("where f.hora>now() order by f.hora");
        Connection cn = ConexionBD.getInstance().obtenerConexion();
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(cadena.toString());
        lista = new ArrayList<FuncionBean>();
        while (rs.next()) {
            FuncionBean FuncionBean = new FuncionBean(rs.getInt("idcv_funcion"),
                    new SalaBean(rs.getInt("idcv_sala"), rs.getString("num_sala"), new CineBean(rs.getInt("idcv_cine"), rs.getString("nombre")), rs.getInt("aforo")),
                    new PeliculaFDBean(rs.getInt("idcv_pelicula"), rs.getString("titulo"), rs.getString("img_1"), rs.getInt("duracion")),
                    rs.getInt("precio"),
                    rs.getTimestamp("hora"));
            lista.add(FuncionBean);
        }
        st.close();
        cn.close();
        return lista;
    }

    @Override
    public void insertar(FuncionBean funcionBean) {
        Logger logger = Logger.getLogger(this.getClass());
        Connection cn = null;
        try {
            cn = ConexionBD.getInstance().obtenerConexion();
            cn.setAutoCommit(false);
            PreparedStatement ps = cn.prepareStatement(
                    "insert into cv_funcion(id_sala,id_pelicula,precio,hora) values(?,?,?,?)");
            ps.setInt(1, funcionBean.getSalaBean().getId());
            ps.setInt(2, funcionBean.getPeliculaFDBean().getCodigo());
            ps.setDouble(3, funcionBean.getPrecio());
            java.sql.Timestamp sq = new java.sql.Timestamp(funcionBean.getInicio().getTime());
            ps.setTimestamp(4, sq);
            ps.execute();
            cn.commit();
            ps.close();
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
    public void eliminar(int codigo) throws Exception {
        StringBuilder sb = new StringBuilder("");
        sb.append("delete from cv_funcion where idcv_funcion=?");
        Connection cn = ConexionBD.getInstance().obtenerConexion();
        PreparedStatement st = cn.prepareStatement(sb.toString());
        st.setInt(1, codigo);
        st.execute();
        st.close();
        cn.close();
    }

    @Override
    public List<FuncionBean> listarFuncionesPorSala(int codigo) throws Exception {

        List<FuncionBean> lista = null;
        StringBuilder cadena = new StringBuilder();
        cadena.append("select f.idcv_funcion, p.titulo, f.precio, f.hora from cv_funcion f ");
        cadena.append("inner join cv_pelicula p on p.idcv_pelicula=f.id_pelicula ");
        cadena.append("where f.id_sala=? and f.hora>now() order by f.hora");
        Connection cn = ConexionBD.getInstance().obtenerConexion();
        PreparedStatement ps = cn.prepareStatement(cadena.toString());
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();
        lista = new ArrayList<FuncionBean>();
        while (rs.next()) {
            FuncionBean FuncionBean = new FuncionBean(rs.getInt("idcv_funcion"),
                    new PeliculaFDBean(rs.getString("titulo")),
                    rs.getDouble("precio"),
                    rs.getTimestamp("hora"));
            lista.add(FuncionBean);
        }
        ps.close();
        cn.close();
        return lista;
    }

    @Override
    public List<FuncionBean> listarFuncionesPorCine(int codigo) throws Exception {

        List<FuncionBean> lista = null;
        StringBuilder cadena = new StringBuilder();
        cadena.append("select f.idcv_funcion,f.hora,f.id_pelicula,p.titulo,f.precio from cv_funcion f ");
        cadena.append("inner join cv_sala s on s.idcv_sala=f.id_sala ");
        cadena.append("inner join cv_cine c on c.idcv_cine=s.id_cine ");
        cadena.append("inner join cv_pelicula p on p.idcv_pelicula=f.id_pelicula ");
        cadena.append("where c.idcv_cine=? and f.hora>now() order by f.hora");
        Connection cn = ConexionBD.getInstance().obtenerConexion();
        PreparedStatement ps = cn.prepareStatement(cadena.toString());
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();
        lista = new ArrayList<FuncionBean>();
        while (rs.next()) {
            FuncionBean FuncionBean = new FuncionBean(rs.getInt("idcv_funcion"),
                    new PeliculaFDBean(rs.getInt("id_pelicula"),rs.getString("titulo")),
                    rs.getDouble("precio"),
                    rs.getTimestamp("hora"));
            lista.add(FuncionBean);
        }
        ps.close();
        cn.close();
        return lista;
    }

    @Override
    public List<FuncionBean> listarFuncionesPorCinePorFecha(int codigo, Date diaFuncion) throws Exception {

        List<FuncionBean> lista = null;
        StringBuilder cadena = new StringBuilder();
        cadena.append("select f.idcv_funcion,f.hora,f.id_pelicula from cv_funcion f ");
        cadena.append("inner join cv_sala s on s.idcv_sala=f.id_sala ");
        cadena.append("inner join cv_cine c on c.idcv_cine=s.id_cine ");
        cadena.append("where c.idcv_cine=? and DATE_FORMAT(f.hora, \"%Y-%m-%d\")=? order by f.hora");
        Connection cn = ConexionBD.getInstance().obtenerConexion();
        PreparedStatement ps = cn.prepareStatement(cadena.toString());
        ps.setInt(1, codigo);
        java.sql.Date sql = new java.sql.Date(diaFuncion.getTime());
        ps.setDate(2, sql);
        ResultSet rs = ps.executeQuery();
        lista = new ArrayList<FuncionBean>();
        while (rs.next()) {
            FuncionBean FuncionBean = new FuncionBean(rs.getInt("idcv_funcion"),
                    new PeliculaFDBean(rs.getInt("id_pelicula")),
                    rs.getTime("hora"));
            lista.add(FuncionBean);
        }
        ps.close();
        cn.close();
        return lista;
    }

    @Override
    public List<FuncionBean> listarFuncionesPorCinePorPeliculaPorFecha(int codCine, int codPel, Date diaFuncion) throws Exception {

        List<FuncionBean> lista = null;
        StringBuilder cadena = new StringBuilder();
        cadena.append("select f.idcv_funcion,f.hora,f.id_pelicula from cv_funcion f ");
        cadena.append("inner join cv_sala s on s.idcv_sala=f.id_sala ");
        cadena.append("inner join cv_cine c on c.idcv_cine=s.id_cine ");
        cadena.append("where c.idcv_cine=? and f.id_pelicula=? and DATE_FORMAT(f.hora, \"%Y-%m-%d\")=? order by f.hora");
        Connection cn = ConexionBD.getInstance().obtenerConexion();
        PreparedStatement ps = cn.prepareStatement(cadena.toString());
        ps.setInt(1, codCine);
        ps.setInt(2, codPel);
        java.sql.Date sql = new java.sql.Date(diaFuncion.getTime());
        ps.setDate(3, sql);
        ResultSet rs = ps.executeQuery();
        lista = new ArrayList<FuncionBean>();
        while (rs.next()) {
            FuncionBean FuncionBean = new FuncionBean(rs.getInt("idcv_funcion"),
                    new PeliculaFDBean(rs.getInt("id_pelicula")),
                    rs.getTime("hora"));
            lista.add(FuncionBean);
        }
        ps.close();
        cn.close();
        return lista;
    }

    @Override
    public FuncionBean obtenerFuncionPorId(int codigo) throws Exception {

        FuncionBean funcionBean = null;
        StringBuilder cadena = new StringBuilder();
        cadena.append("select f.idcv_funcion, s.num_sala,c.idcv_cine, c.nombre, c.direccion, p.titulo, p.img_1, f.precio, f.hora from cv_funcion f ");
        cadena.append("inner join cv_sala s on s.idcv_sala=f.id_sala ");
        cadena.append("inner join cv_cine c on c.idcv_cine=s.id_cine ");
        cadena.append("inner join cv_pelicula p on p.idcv_pelicula=f.id_pelicula ");
        cadena.append("where f.idcv_funcion=?");
        Connection cn = ConexionBD.getInstance().obtenerConexion();
        PreparedStatement ps = cn.prepareStatement(cadena.toString());
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            funcionBean = new FuncionBean(rs.getInt("idcv_funcion"),
                    new SalaBean(rs.getString("num_sala"), new CineBean(rs.getInt("idcv_cine"), rs.getString("nombre"), rs.getString("direccion"))),
                    new PeliculaFDBean(rs.getString("titulo"), rs.getString("img_1")),
                    rs.getDouble("precio"),
                    rs.getTime("hora"));
        }
        ps.close();
        cn.close();
        return funcionBean;
    }
}
