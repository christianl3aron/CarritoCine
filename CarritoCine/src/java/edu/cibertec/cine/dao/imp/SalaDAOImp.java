/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cibertec.cine.dao.imp;

import edu.cibertec.cine.dao.SalaDAO;
import edu.cibertec.cine.dao.bean.SalaBean;
import edu.cibertec.cine.util.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CHRISTIAN-LAP
 */
public class SalaDAOImp implements SalaDAO {

    @Override
    public List<SalaBean> listarSalaPorCine(int codigo) throws Exception {
        List<SalaBean> lista = null;
        StringBuilder cadena = new StringBuilder();
        cadena.append("select s.idcv_sala ,s.num_sala from cv_sala s where s.id_cine=?");
        Connection cn = ConexionBD.getInstance().obtenerConexion();
        PreparedStatement ps = cn.prepareStatement(cadena.toString());
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();
        lista = new ArrayList<SalaBean>();
        while (rs.next()) {
            SalaBean salaBean = new SalaBean(rs.getInt("idcv_sala"), rs.getString("num_sala"));
            lista.add(salaBean);
        }
        ps.close();
        cn.close();
        return lista;
    }
}
