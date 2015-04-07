/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cibertec.cine.dao.bean;

/**
 *
 * @author CHRISTIAN-LAP
 */
public class CineBean {

    private int codigo;
    private String nombre;
    private String direccion;
    private int cantSalas;
    private String obs;
    private CiudadBean ciudadBean;
    private String imagen;

    public CineBean() {
    }

    public CineBean(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public CineBean(String nombre) {
        this.nombre = nombre;
    }

    public CineBean(int codigo, String nombre, String direccion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public CineBean(int codigo, String nombre, String direccion, int cantSalas, String obs, CiudadBean ciudadBean, String imagen) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.cantSalas = cantSalas;
        this.obs = obs;
        this.ciudadBean = ciudadBean;
        this.imagen = imagen;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String image) {
        this.imagen = image;
    }

    public int getCantSalas() {
        return cantSalas;
    }

    public CiudadBean getCiudadBean() {
        return ciudadBean;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getObs() {
        return obs;
    }

    public void setCantSalas(int cantSalas) {
        this.cantSalas = cantSalas;
    }

    public void setCiudadBean(CiudadBean ciudadBean) {
        this.ciudadBean = ciudadBean;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
}
