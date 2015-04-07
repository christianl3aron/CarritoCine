/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cibertec.cine.dao.bean;

/**
 *
 * @author CHRISTIAN-LAP
 */
public class CompraBean {

    private int codigo;
    private UsuarioBean usuarioBean;
    private FuncionBean funcionBean;
    private int cantidad;

    public CompraBean(int codigo, UsuarioBean usuarioBean, FuncionBean funcionBean, int cantidad) {
        this.codigo = codigo;
        this.usuarioBean = usuarioBean;
        this.funcionBean = funcionBean;
        this.cantidad = cantidad;
    }

    public CompraBean(int codigo, FuncionBean funcionBean, int cantidad) {
        this.codigo = codigo;
        this.funcionBean = funcionBean;
        this.cantidad = cantidad;
    }

    public CompraBean(FuncionBean funcionBean, int cantidad) {
        this.funcionBean = funcionBean;
        this.cantidad = cantidad;
    }

    public CompraBean(UsuarioBean usuarioBean, FuncionBean funcionBean, int cantidad) {
        this.usuarioBean = usuarioBean;
        this.funcionBean = funcionBean;
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getCodigo() {
        return codigo;
    }

    public FuncionBean getFuncionBean() {
        return funcionBean;
    }

    public UsuarioBean getUsuarioBean() {
        return usuarioBean;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setFuncionBean(FuncionBean funcionBean) {
        this.funcionBean = funcionBean;
    }

    public void setUsuarioBean(UsuarioBean usuarioBean) {
        this.usuarioBean = usuarioBean;
    }
}
