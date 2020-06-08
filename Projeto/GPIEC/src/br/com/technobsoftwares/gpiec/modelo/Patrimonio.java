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
public class Patrimonio {
    int idpatrimonio;
    private int fkidtipopatrimonio;
    private int numero;
    private String systemdate;

    public int getIdpatrimonio() {
        return idpatrimonio;
    }

    public void setIdpatrimonio(int idpatrimonio) {
        this.idpatrimonio = idpatrimonio;
    }

    public int getFkidtipopatrimonio() {
        return fkidtipopatrimonio;
    }

    public void setFkidtipopatrimonio(int fkidtipopatrimonio) {
        this.fkidtipopatrimonio = fkidtipopatrimonio;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getSystemdate() {
        return systemdate;
    }

    public void setSystemdate(String systemdate) {
        this.systemdate = systemdate;
    }
    
}
