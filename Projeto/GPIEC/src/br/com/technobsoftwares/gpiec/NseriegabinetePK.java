/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.technobsoftwares.gpiec;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author lab
 */
@Embeddable
public class NseriegabinetePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idnseriegabinete")
    private int idnseriegabinete;
    @Basic(optional = false)
    @Column(name = "fkidpatrimonio")
    private int fkidpatrimonio;

    public NseriegabinetePK() {
    }

    public NseriegabinetePK(int idnseriegabinete, int fkidpatrimonio) {
        this.idnseriegabinete = idnseriegabinete;
        this.fkidpatrimonio = fkidpatrimonio;
    }

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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idnseriegabinete;
        hash += (int) fkidpatrimonio;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NseriegabinetePK)) {
            return false;
        }
        NseriegabinetePK other = (NseriegabinetePK) object;
        if (this.idnseriegabinete != other.idnseriegabinete) {
            return false;
        }
        if (this.fkidpatrimonio != other.fkidpatrimonio) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.technobsoftwares.gpiec.NseriegabinetePK[ idnseriegabinete=" + idnseriegabinete + ", fkidpatrimonio=" + fkidpatrimonio + " ]";
    }
    
}
