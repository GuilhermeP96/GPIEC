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
public class Ordem_de_Servico {
    int id_ordem_servico;
    private int fk_id_pc;
    private String fk_pc;
    private int fk_id_usuario;
    private String fk_usuario;
    private int fk_id_tipo_problema;
    private String fk_tipo_problema;
    private int fk_id_status;
    private String fk_status;
    private String titulo_os;
    private String detalhes_os;
    private String data_fechamento;
    private String data_entrada;
    private String local_os;

    public String getLocal_os() {
        return local_os;
    }

    public void setLocal_os(String local_os) {
        this.local_os = local_os;
    }

    public int getId_ordem_servico() {
        return id_ordem_servico;
    }

    public void setId_ordem_servico(int id_ordem_servico) {
        this.id_ordem_servico = id_ordem_servico;
    }

    public int getFk_id_pc() {
        return fk_id_pc;
    }

    public void setFk_id_pc(int fk_id_pc) {
        this.fk_id_pc = fk_id_pc;
    }

    public String getFk_pc() {
        return fk_pc;
    }

    public void setFk_pc(String fk_pc) {
        this.fk_pc = fk_pc;
    }

    public int getFk_id_usuario() {
        return fk_id_usuario;
    }

    public void setFk_id_usuario(int fk_id_usuario) {
        this.fk_id_usuario = fk_id_usuario;
    }

    public String getFk_usuario() {
        return fk_usuario;
    }

    public void setFk_usuario(String fk_usuario) {
        this.fk_usuario = fk_usuario;
    }

    public int getFk_id_tipo_problema() {
        return fk_id_tipo_problema;
    }

    public void setFk_id_tipo_problema(int fk_id_tipo_problema) {
        this.fk_id_tipo_problema = fk_id_tipo_problema;
    }

    public String getFk_tipo_problema() {
        return fk_tipo_problema;
    }

    public void setFk_tipo_problema(String fk_tipo_problema) {
        this.fk_tipo_problema = fk_tipo_problema;
    }

    public int getFk_id_status() {
        return fk_id_status;
    }

    public void setFk_id_status(int fk_id_status) {
        this.fk_id_status = fk_id_status;
    }

    public String getFk_status() {
        return fk_status;
    }

    public void setFk_status(String fk_status) {
        this.fk_status = fk_status;
    }

    public String getTitulo_os() {
        return titulo_os;
    }

    public void setTitulo_os(String titulo_os) {
        this.titulo_os = titulo_os;
    }

    public String getDetalhes_os() {
        return detalhes_os;
    }

    public void setDetalhes_os(String detalhes_os) {
        this.detalhes_os = detalhes_os;
    }

    public String getData_fechamento() {
        return data_fechamento;
    }

    public void setData_fechamento(String data_fechamento) {
        this.data_fechamento = data_fechamento;
    }

    public String getData_entrada() {
        return data_entrada;
    }

    public void setData_entrada(String data_entrada) {
        this.data_entrada = data_entrada;
    }
}
