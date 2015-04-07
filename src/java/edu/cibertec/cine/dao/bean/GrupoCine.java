/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cibertec.cine.dao.bean;

import java.util.List;

/**
 *
 * @author CHRISTIAN-LAP
 */
public class GrupoCine {

    private CineBean cineBean;
    private List<FuncionBean> lista;

    public CineBean getCineBean() {
        return cineBean;
    }

    public List<FuncionBean> getLista() {
        return lista;
    }

    public void setCineBean(CineBean cineBean) {
        this.cineBean = cineBean;
    }

    public void setLista(List<FuncionBean> lista) {
        this.lista = lista;
    }
}
