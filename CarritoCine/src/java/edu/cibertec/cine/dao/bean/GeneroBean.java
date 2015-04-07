/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cibertec.cine.dao.bean;

/**
 *
 * @author CHRISTIAN-LAP
 */
public class GeneroBean {

    private int codigo;
    private String denominacion;

    public GeneroBean(int codigo, String denominacion) {
        this.codigo = codigo;
        this.denominacion = denominacion;
    }

    public GeneroBean() {
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDenominacion() {
        return denominacion;
    }
}
