/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cibertec.cine.dao.imp;

import edu.cibertec.cine.dao.GeneroDAO;
import edu.cibertec.cine.dao.bean.GeneroBean;
import edu.cibertec.cine.util.ConexionBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CHRISTIAN-LAP
 */
public class GeneroDAOImp implements GeneroDAO {

    @Override
    public List<GeneroBean> listarGenero() throws Exception {
        Connection cn = ConexionBD.getInstance().obtenerConexion();
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery("Select * from cv_genero");
        List<GeneroBean> lista = new ArrayList<GeneroBean>();
        while (rs.next()) {
            GeneroBean generoBean = new GeneroBean(rs.getInt("idcv_genero"), rs.getString("denominacion"));
            lista.add(generoBean);
        }
        st.close();
        cn.close();
        return lista;
    }
}
