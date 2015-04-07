/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cibertec.cine.dao.bean;

/**
 *
 * @author CHRISTIAN-LAP
 */
public class SalaBean {

    private int id;
    private String numSala;
    private CineBean cineBean;
    private int aforo;

    public SalaBean() {
    }

    public SalaBean(int id) {
        this.id = id;
    }

    public SalaBean(int id, String numSala) {
        this.id = id;
        this.numSala = numSala;
    }

    public SalaBean(String numSala, CineBean cineBean) {
        this.numSala = numSala;
        this.cineBean = cineBean;
    }

    public SalaBean(int id, String numSala, CineBean cineBean, int aforo) {
        this.id = id;
        this.numSala = numSala;
        this.cineBean = cineBean;
        this.aforo = aforo;
    }

    public String getNumSala() {
        return numSala;
    }

    public void setNumSala(String numSala) {
        this.numSala = numSala;
    }

    public int getAforo() {
        return aforo;
    }

    public CineBean getCineBean() {
        return cineBean;
    }

    public int getId() {
        return id;
    }

    public void setAforo(int aforo) {
        this.aforo = aforo;
    }

    public void setCineBean(CineBean cineBean) {
        this.cineBean = cineBean;
    }

    public void setId(int id) {
        this.id = id;
    }
}
