/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cibertec.cine.dao.imp;

import edu.cibertec.cine.dao.CineDAO;
import edu.cibertec.cine.dao.bean.CineBean;
import edu.cibertec.cine.dao.bean.CiudadBean;
import edu.cibertec.cine.util.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CHRISTIAN-LAP
 */
public class CineDAOImp implements CineDAO {

    @Override
    public List<CineBean> listarCineLima() throws Exception {
        StringBuilder cadena = new StringBuilder();
        cadena.append("SELECT c.idcv_cine,c.nombre,c.direccion,c.cant_salas,c.observacion,c.id_ciudad, l.nombre as 'nomCiudad',c.imagen ");
        cadena.append("FROM cv_cine c inner join cv_ciudad l on l.idcv_ciudad=c.id_ciudad where c.id_ciudad=1");
        return getLista(cadena.toString());
    }

    @Override
    public List<CineBean> listarCineOtros() throws Exception {

        StringBuilder cadena = new StringBuilder();
        cadena.append("SELECT c.idcv_cine,c.nombre,c.direccion,c.cant_salas,c.observacion,c.id_ciudad, l.nombre as 'nomCiudad',c.imagen ");
        cadena.append("FROM cv_cine c inner join cv_ciudad l on l.idcv_ciudad=c.id_ciudad where c.id_ciudad!=1");
        return getLista(cadena.toString());
    }

    @Override
    public List<CineBean> listarCineCombobox() throws Exception {

        List<CineBean> lista = null;
        StringBuilder cadena = new StringBuilder();
        cadena.append("select c.idcv_cine, c.nombre from cv_cine c order by nombre");
        Connection cn = ConexionBD.getInstance().obtenerConexion();
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(cadena.toString());
        lista = new ArrayList<CineBean>();
        while (rs.next()) {
            CineBean cineBean = new CineBean(rs.getInt("idcv_cine"), rs.getString("nombre"));
            lista.add(cineBean);
        }
        st.close();
        cn.close();
        return lista;
    }

    @Override
    public CineBean obtenerCinePorId(int codigo) throws Exception {

        CineBean cineBean = null;
        String query = "select c.nombre, c.direccion from cv_cine c where c.idcv_cine=?";
        Connection cn = ConexionBD.getInstance().obtenerConexion();
        PreparedStatement st = cn.prepareStatement(query);
        st.setInt(1, codigo);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            cineBean = new CineBean(codigo,rs.getString("nombre"), rs.getString("direccion"));
        }
        st.close();
        cn.close();
        return cineBean;
    }

    private List<CineBean> getLista(String query) throws Exception {

        List<CineBean> lista = null;
        Connection cn = ConexionBD.getInstance().obtenerConexion();
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(query);
        lista = new ArrayList<CineBean>();
        while (rs.next()) {
            CineBean cineBean = new CineBean(rs.getInt("idcv_cine"),
                    rs.getString("nombre"),
                    rs.getString("direccion"),
                    rs.getInt("cant_salas"),
                    rs.getString("observacion"),
                    new CiudadBean(rs.getInt("id_ciudad"), rs.getString("nomCiudad")),
                    rs.getString("imagen"));
            lista.add(cineBean);
        }
        st.close();
        cn.close();
        return lista;
    }
}
