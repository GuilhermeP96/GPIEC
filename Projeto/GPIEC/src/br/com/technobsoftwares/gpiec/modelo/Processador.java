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
public class Processador {
    int idprocessador;
    private String marca;
    private String nome;

    public int getIdprocessador() {
        return idprocessador;
    }

    public void setIdprocessador(int idprocessador) {
        this.idprocessador = idprocessador;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
