/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cibertec.cine.dao.bean;

/**
 *
 * @author CHRISTIAN-LAP
 */
public class UsuarioBean {

    private int codigo;
    private String alias;
    private String nombres;
    private String apellidos;
    private String password;
    private int tipo;

    public UsuarioBean() {
    }

    public UsuarioBean(int codigo) {
        this.codigo = codigo;
    }

    public UsuarioBean(int codigo, String alias, String nombres, String apellidos, int tipo, String password) {
        this.codigo = codigo;
        this.alias = alias;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.password = password;
        this.tipo = tipo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getAlias() {
        return alias;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getPassword() {
        return password;
    }

    public int getTipo() {
        return tipo;
    }
}
