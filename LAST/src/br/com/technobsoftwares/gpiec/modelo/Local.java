/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.technobsoftwares.gpiec.modelo;

/**
 *
 * @author User
 */
public class Local {
    int id_local;
    private String nome_local;
    private String desc_local;

    public int getId_local() {
        return id_local;
    }

    public void setId_local(int id_local) {
        this.id_local = id_local;
    }

    public String getNome_local() {
        return nome_local;
    }

    public void setNome_local(String nome_local) {
        this.nome_local = nome_local;
    }

    public String getDesc_local() {
        return desc_local;
    }

    public void setDesc_local(String desc_local) {
        this.desc_local = desc_local;
    }
}
