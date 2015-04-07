/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cibertec.cine.dao.bean;

import java.util.Date;

/**
 *
 * @author CHRISTIAN-LAP
 */
public class FuncionBean {

    private int codigo;
    private SalaBean salaBean;
    private PeliculaFDBean peliculaFDBean;
    private double precio;
    private Date inicio;

    public FuncionBean(int codigo, SalaBean salaBean, PeliculaFDBean peliculaFDBean, double precio, Date inicio) {
        this.codigo = codigo;
        this.salaBean = salaBean;
        this.peliculaFDBean = peliculaFDBean;
        this.precio = precio;
        this.inicio = inicio;
    }

    public FuncionBean(SalaBean salaBean, PeliculaFDBean peliculaFDBean, double precio, Date inicio) {
        this.salaBean = salaBean;
        this.peliculaFDBean = peliculaFDBean;
        this.precio = precio;
        this.inicio = inicio;
    }

    public FuncionBean(int codigo, PeliculaFDBean peliculaFDBean, double precio, Date inicio) {
        this.codigo = codigo;
        this.peliculaFDBean = peliculaFDBean;
        this.precio = precio;
        this.inicio = inicio;
    }

    public FuncionBean(SalaBean salaBean, PeliculaFDBean peliculaFDBean, Date inicio) {
        this.salaBean = salaBean;
        this.peliculaFDBean = peliculaFDBean;
        this.inicio = inicio;
    }

    public FuncionBean(int codigo, PeliculaFDBean peliculaFDBean, Date inicio) {
        this.codigo = codigo;
        this.peliculaFDBean = peliculaFDBean;
        this.inicio = inicio;
    }

    public FuncionBean(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public Date getInicio() {
        return inicio;
    }

    public PeliculaFDBean getPeliculaFDBean() {
        return peliculaFDBean;
    }

    public double getPrecio() {
        return precio;
    }

    public SalaBean getSalaBean() {
        return salaBean;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public void setPeliculaFDBean(PeliculaFDBean peliculaFDBean) {
        this.peliculaFDBean = peliculaFDBean;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setSalaBean(SalaBean salaBean) {
        this.salaBean = salaBean;
    }
}
