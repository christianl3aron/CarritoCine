/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cibertec.cine.dao.imp;

import edu.cibertec.cine.dao.UsuarioDAO;
import edu.cibertec.cine.dao.bean.UsuarioBean;
import edu.cibertec.cine.util.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author CHRISTIAN-LAP
 */
public class UsuarioDAOImp implements UsuarioDAO {

    @Override
    public void insertar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void eliminar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public UsuarioBean obtenerUsuario(String usuario, String clave) throws Exception {
        UsuarioBean usuarioBean = null;
        Connection cn = ConexionBD.getInstance().obtenerConexion();
        StringBuilder sb = new StringBuilder("");
        sb.append("select u.idcv_usuario,u.nom_usuario,u.nombres,u.apellidos,u.id_tipo,u.pass_usuario from cv_usuario u ");
        sb.append("inner join cv_tipo_usuario t on t.idcv_tipo_usuario=u.id_tipo ");
        sb.append("where u.nom_usuario=? and u.pass_usuario=? ");
        PreparedStatement st = cn.prepareStatement(sb.toString());
        st.setString(1, usuario);
        st.setString(2, clave);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            usuarioBean = new UsuarioBean(rs.getInt("idcv_usuario"),
                    rs.getString("nom_usuario"),
                    rs.getString("nombres"),
                    rs.getString("apellidos"),
                    rs.getInt("id_tipo"),
                    rs.getString("pass_usuario"));
        }
        st.close();
        cn.close();
        return usuarioBean;
    }
}
