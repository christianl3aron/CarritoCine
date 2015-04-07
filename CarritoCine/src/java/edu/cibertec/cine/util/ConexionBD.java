/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cibertec.cine.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author CHRISTIAN-LAP
 */
public class ConexionBD {

    static ConexionBD instancia;

    private ConexionBD() {
    }

    public static ConexionBD getInstance() {
        if (instancia == null) {
            instancia = new ConexionBD();
        }
        return instancia;
    }

    public Connection obtenerConexion() throws Exception {
        Connection cn = null;
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinevirtual", "root", "root");
        return cn;
    }
}
