/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.technobsoftwares.gpiec.modelo;

/**
 *
 * @author lab
 */
public class Ordem_de_Servico_OK {
    int id_ordem_ok;
    private int fk_id_os;
    private int fk_id_usuario;
    private String data;

    public int getId_ordem_ok() {
        return id_ordem_ok;
    }

    public void setId_ordem_ok(int id_ordem_ok) {
        this.id_ordem_ok = id_ordem_ok;
    }

    public int getFk_id_os() {
        return fk_id_os;
    }

    public void setFk_id_os(int fk_id_os) {
        this.fk_id_os = fk_id_os;
    }

    public int getFk_id_usuario() {
        return fk_id_usuario;
    }

    public void setFk_id_usuario(int fk_id_usuario) {
        this.fk_id_usuario = fk_id_usuario;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
