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
public class Gabinete {
    int idgabinete;
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    private int fkidhd;
    private int fkidmemoria;
    private int fkidprocessador;
    private String systemdate;

    public int getIdgabinete() {
        return idgabinete;
    }

    public void setIdgabinete(int idgabinete) {
        this.idgabinete = idgabinete;
    }

    public int getFkidhd() {
        return fkidhd;
    }

    public void setFkidhd(int fkidhd) {
        this.fkidhd = fkidhd;
    }

    public int getFkidmemoria() {
        return fkidmemoria;
    }

    public void setFkidmemoria(int fkidmemoria) {
        this.fkidmemoria = fkidmemoria;
    }

    public int getFkidprocessador() {
        return fkidprocessador;
    }

    public void setFkidprocessador(int fkidprocessador) {
        this.fkidprocessador = fkidprocessador;
    }

    public String getSystemdate() {
        return systemdate;
    }

    public void setSystemdate(String systemdate) {
        this.systemdate = systemdate;
    }
}
