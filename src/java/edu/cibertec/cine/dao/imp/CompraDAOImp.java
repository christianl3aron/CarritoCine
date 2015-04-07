/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cibertec.cine.dao.imp;

import edu.cibertec.cine.dao.CompraDAO;
import edu.cibertec.cine.dao.bean.CineBean;
import edu.cibertec.cine.dao.bean.CompraBean;
import edu.cibertec.cine.dao.bean.FuncionBean;
import edu.cibertec.cine.dao.bean.PeliculaFDBean;
import edu.cibertec.cine.dao.bean.SalaBean;
import edu.cibertec.cine.util.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author CHRISTIAN-LAP
 */
public class CompraDAOImp implements CompraDAO {

    @Override
    public void insertar(CompraBean compraBean) {
        Logger logger = Logger.getLogger(this.getClass());
        Connection cn = null;
        try {
            cn = ConexionBD.getInstance().obtenerConexion();
            cn.setAutoCommit(false);
            PreparedStatement ps = cn.prepareStatement(
                    "insert into cv_compra(id_usuario,id_funcion,cantidad) values(?,?,?)");
            ps.setInt(1, compraBean.getUsuarioBean().getCodigo());
            ps.setInt(2, compraBean.getFuncionBean().getCodigo());
            ps.setInt(3, compraBean.getCantidad());
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
    public List<CompraBean> listarCompras(int codUser) throws Exception {

        List<CompraBean> lista = new ArrayList<CompraBean>();

        Connection cn = ConexionBD.getInstance().obtenerConexion();
        StringBuilder sb = new StringBuilder("");
        sb.append("select co.idcv_compra, p.titulo, c.nombre, s.num_sala, f.hora, co.cantidad from cv_compra co ");
        sb.append("inner join cv_funcion f on f.idcv_funcion=co.id_funcion ");
        sb.append("inner join cv_pelicula p on p.idcv_pelicula=f.id_pelicula ");
        sb.append("inner join cv_sala s on s.idcv_sala = f.id_sala ");
        sb.append("inner join cv_cine c on c.idcv_cine=s.id_cine ");
        sb.append("where co.id_usuario=? and f.hora>now() order by f.hora");
        PreparedStatement st = cn.prepareStatement(sb.toString());
        st.setInt(1, codUser);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            CompraBean compraBean = new CompraBean(rs.getInt("idcv_compra"),
                    new FuncionBean(new SalaBean(rs.getString("num_sala"), new CineBean(rs.getString("nombre"))), new PeliculaFDBean(rs.getString("titulo")), rs.getTimestamp("hora")),
                    rs.getInt("cantidad"));
            lista.add(compraBean);
        }
        st.close();
        cn.close();
        return lista;
    }
}
