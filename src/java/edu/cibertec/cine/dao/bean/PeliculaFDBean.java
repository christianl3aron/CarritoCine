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
public class PeliculaFDBean {

    private int codigo;
    private String titulo;
    private String img_portada;
    private String img_1;
    private int duracion;
    private String actores;
    private String sinopsis;
    private String paisOrigen;
    private String director;
    private String trailer;
    private String img_2;
    private String img_3;
    private String img_4;
    private double puntuacion;
    private Date fechaEstreno;
    private String flag3D;
    private String genero;

    public PeliculaFDBean() {
    }

    public PeliculaFDBean(int codigo, String titulo, String img_portada, String img_1) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.img_portada = img_portada;
        this.img_1 = img_1;
    }
    
    public PeliculaFDBean(int codigo, String titulo, String img_1, int duracion) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.img_1 = img_1;
        this.duracion = duracion;
    }

    public PeliculaFDBean(String titulo, String img_1) {
        this.titulo = titulo;
        this.img_1 = img_1;
    }

    public PeliculaFDBean(int codigo, String titulo) {
        this.codigo = codigo;
        this.titulo = titulo;
    }

    public PeliculaFDBean(int codigo) {
        this.codigo = codigo;
    }

    public PeliculaFDBean(String titulo) {
        this.titulo = titulo;
    }

    public PeliculaFDBean(String titulo, int duracion, String actores, String sinopsis, String paisOrigen, String director, String trailer, String img_portada, String img_1, String img_2, String img_3, String img_4, Date fechaEstreno, String genero) {
        this.titulo = titulo;
        this.img_portada = img_portada;
        this.img_1 = img_1;
        this.duracion = duracion;
        this.actores = actores;
        this.sinopsis = sinopsis;
        this.paisOrigen = paisOrigen;
        this.director = director;
        this.trailer = trailer;
        this.img_2 = img_2;
        this.img_3 = img_3;
        this.img_4 = img_4;
        this.fechaEstreno = fechaEstreno;
        this.genero = genero;
    }

    public PeliculaFDBean(int codigo, String titulo, int duracion, String actores, String sinopsis, String paisOrigen, String director, String trailer, String img_portada, String img_1, String img_2, String img_3, String img_4, double puntuacion, Date fechaEstreno, String flag3D, String genero) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.img_portada = img_portada;
        this.img_1 = img_1;
        this.duracion = duracion;
        this.actores = actores;
        this.sinopsis = sinopsis;
        this.paisOrigen = paisOrigen;
        this.director = director;
        this.trailer = trailer;
        this.img_2 = img_2;
        this.img_3 = img_3;
        this.img_4 = img_4;
        this.puntuacion = puntuacion;
        this.fechaEstreno = fechaEstreno;
        this.flag3D = flag3D;
        this.genero = genero;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setImg_1(String img_1) {
        this.img_1 = img_1;
    }

    public void setImg_portada(String img_portada) {
        this.img_portada = img_portada;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getImg_1() {
        return img_1;
    }

    public String getImg_portada() {
        return img_portada;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getActores() {
        return actores;
    }

    public String getDirector() {
        return director;
    }

    public int getDuracion() {
        return duracion;
    }

    public Date getFechaEstreno() {
        return fechaEstreno;
    }

    public String getFlag3D() {
        return flag3D;
    }

    public String getGenero() {
        return genero;
    }

    public String getImg_2() {
        return img_2;
    }

    public String getImg_3() {
        return img_3;
    }

    public String getImg_4() {
        return img_4;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public double getPuntuacion() {
        return puntuacion;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setActores(String atores) {
        this.actores = atores;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setFechaEstreno(Date fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public void setFlag3D(String flag3D) {
        this.flag3D = flag3D;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setImg_2(String img_2) {
        this.img_2 = img_2;
    }

    public void setImg_3(String img_3) {
        this.img_3 = img_3;
    }

    public void setImg_4(String img_4) {
        this.img_4 = img_4;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public void setPuntuacion(double puntuacion) {
        this.puntuacion = puntuacion;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }
}
