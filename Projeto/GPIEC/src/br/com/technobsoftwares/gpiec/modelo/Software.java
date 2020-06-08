/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.technobsoftwares.gpiec.modelo;

/**
 *
 * @author Shutdown
 */
public class Software {
    int idsoftware;
    private String nome;
    private String descricao;

    public int getIdsoftware() {
        return idsoftware;
    }

    public void setIdsoftware(int idsoftware) {
        this.idsoftware = idsoftware;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
