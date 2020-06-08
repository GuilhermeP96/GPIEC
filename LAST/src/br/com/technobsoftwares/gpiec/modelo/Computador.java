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
public class Computador {
    int id_pc;
    private int fk_id_mouse;
    private int fk_id_teclado;
    private int fk_id_num_serie_monitor;
    private int fk_id_num_serie_estabilizador;
    private int fk_id_num_serie_gabinete;
    private int fk_id_local;
    private int fk_id_status;
    private String nome_pc;

    public int getId_pc() {
        return id_pc;
    }

    public void setId_pc(int id_pc) {
        this.id_pc = id_pc;
    }

    public int getFk_id_mouse() {
        return fk_id_mouse;
    }

    public void setFk_id_mouse(int fk_id_mouse) {
        this.fk_id_mouse = fk_id_mouse;
    }

    public int getFk_id_teclado() {
        return fk_id_teclado;
    }

    public void setFk_id_teclado(int fk_id_teclado) {
        this.fk_id_teclado = fk_id_teclado;
    }

    public int getFk_id_num_serie_monitor() {
        return fk_id_num_serie_monitor;
    }

    public void setFk_id_num_serie_monitor(int fk_id_num_serie_monitor) {
        this.fk_id_num_serie_monitor = fk_id_num_serie_monitor;
    }

    public int getFk_id_num_serie_estabilizador() {
        return fk_id_num_serie_estabilizador;
    }

    public void setFk_id_num_serie_estabilizador(int fk_id_num_serie_estabilizador) {
        this.fk_id_num_serie_estabilizador = fk_id_num_serie_estabilizador;
    }

    public int getFk_id_num_serie_gabinete() {
        return fk_id_num_serie_gabinete;
    }

    public void setFk_id_num_serie_gabinete(int fk_id_num_serie_gabinete) {
        this.fk_id_num_serie_gabinete = fk_id_num_serie_gabinete;
    }

    public int getFk_id_local() {
        return fk_id_local;
    }

    public void setFk_id_local(int fk_id_local) {
        this.fk_id_local = fk_id_local;
    }

    public int getFk_id_status() {
        return fk_id_status;
    }

    public void setFk_id_status(int fk_id_status) {
        this.fk_id_status = fk_id_status;
    }

    public String getNome_pc() {
        return nome_pc;
    }

    public void setNome_pc(String nome_pc) {
        this.nome_pc = nome_pc;
    }
}
