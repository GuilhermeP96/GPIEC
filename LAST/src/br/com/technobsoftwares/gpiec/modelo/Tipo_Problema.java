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
public class Tipo_Problema {
    int id_tipo_problema;
    private String tipo_problema;

    public int getId_tipo_problema() {
        return id_tipo_problema;
    }

    public void setId_tipo_problema(int id_tipo_problema) {
        this.id_tipo_problema = id_tipo_problema;
    }

    public String getTipo_problema() {
        return tipo_problema;
    }

    public void setTipo_problema(String tipo_problema) {
        this.tipo_problema = tipo_problema;
    }
}
