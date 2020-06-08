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
public class Nseriegabinete {
    int idnseriegabinete;
    private int fkidpatrimonio;
    private String nseriefabricante;
    private int fkidgabinete;
    private String nomesystem;
    private String systemdate;

    public int getIdnseriegabinete() {
        return idnseriegabinete;
    }

    public void setIdnseriegabinete(int idnseriegabinete) {
        this.idnseriegabinete = idnseriegabinete;
    }

    public int getFkidpatrimonio() {
        return fkidpatrimonio;
    }

    public void setFkidpatrimonio(int fkidpatrimonio) {
        this.fkidpatrimonio = fkidpatrimonio;
    }

    public String getNseriefabricante() {
        return nseriefabricante;
    }

    public void setNseriefabricante(String nseriefabricante) {
        this.nseriefabricante = nseriefabricante;
    }

    public int getFkidgabinete() {
        return fkidgabinete;
    }

    public void setFkidgabinete(int fkidgabinete) {
        this.fkidgabinete = fkidgabinete;
    }

    public String getNomesystem() {
        return nomesystem;
    }

    public void setNomesystem(String nomesystem) {
        this.nomesystem = nomesystem;
    }

    public String getSystemdate() {
        return systemdate;
    }

    public void setSystemdate(String systemdate) {
        this.systemdate = systemdate;
    }
}
