/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.technobsoftwares.gpiec;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author lab
 */
@Entity
@Table(name = "nseriegabinete", catalog = "gpiec", schema = "")
@NamedQueries({
    @NamedQuery(name = "Nseriegabinete.findAll", query = "SELECT n FROM Nseriegabinete n"),
    @NamedQuery(name = "Nseriegabinete.findByIdnseriegabinete", query = "SELECT n FROM Nseriegabinete n WHERE n.nseriegabinetePK.idnseriegabinete = :idnseriegabinete"),
    @NamedQuery(name = "Nseriegabinete.findByFkidpatrimonio", query = "SELECT n FROM Nseriegabinete n WHERE n.nseriegabinetePK.fkidpatrimonio = :fkidpatrimonio"),
    @NamedQuery(name = "Nseriegabinete.findByNseriefabricante", query = "SELECT n FROM Nseriegabinete n WHERE n.nseriefabricante = :nseriefabricante"),
    @NamedQuery(name = "Nseriegabinete.findByFkidgabinete", query = "SELECT n FROM Nseriegabinete n WHERE n.fkidgabinete = :fkidgabinete"),
    @NamedQuery(name = "Nseriegabinete.findByNomesystem", query = "SELECT n FROM Nseriegabinete n WHERE n.nomesystem = :nomesystem"),
    @NamedQuery(name = "Nseriegabinete.findBySystemdate", query = "SELECT n FROM Nseriegabinete n WHERE n.systemdate = :systemdate")})
public class Nseriegabinete implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NseriegabinetePK nseriegabinetePK;
    @Basic(optional = false)
    @Column(name = "nseriefabricante")
    private String nseriefabricante;
    @Basic(optional = false)
    @Column(name = "fkidgabinete")
    private int fkidgabinete;
    @Basic(optional = false)
    @Column(name = "nomesystem")
    private String nomesystem;
    @Basic(optional = false)
    @Column(name = "systemdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date systemdate;

    public Nseriegabinete() {
    }

    public Nseriegabinete(NseriegabinetePK nseriegabinetePK) {
        this.nseriegabinetePK = nseriegabinetePK;
    }

    public Nseriegabinete(NseriegabinetePK nseriegabinetePK, String nseriefabricante, int fkidgabinete, String nomesystem, Date systemdate) {
        this.nseriegabinetePK = nseriegabinetePK;
        this.nseriefabricante = nseriefabricante;
        this.fkidgabinete = fkidgabinete;
        this.nomesystem = nomesystem;
        this.systemdate = systemdate;
    }

    public Nseriegabinete(int idnseriegabinete, int fkidpatrimonio) {
        this.nseriegabinetePK = new NseriegabinetePK(idnseriegabinete, fkidpatrimonio);
    }

    public NseriegabinetePK getNseriegabinetePK() {
        return nseriegabinetePK;
    }

    public void setNseriegabinetePK(NseriegabinetePK nseriegabinetePK) {
        this.nseriegabinetePK = nseriegabinetePK;
    }

    public String getNseriefabricante() {
        return nseriefabricante;
    }

    public void setNseriefabricante(String nseriefabricante) {
        String oldNseriefabricante = this.nseriefabricante;
        this.nseriefabricante = nseriefabricante;
        changeSupport.firePropertyChange("nseriefabricante", oldNseriefabricante, nseriefabricante);
    }

    public int getFkidgabinete() {
        return fkidgabinete;
    }

    public void setFkidgabinete(int fkidgabinete) {
        int oldFkidgabinete = this.fkidgabinete;
        this.fkidgabinete = fkidgabinete;
        changeSupport.firePropertyChange("fkidgabinete", oldFkidgabinete, fkidgabinete);
    }

    public String getNomesystem() {
        return nomesystem;
    }

    public void setNomesystem(String nomesystem) {
        String oldNomesystem = this.nomesystem;
        this.nomesystem = nomesystem;
        changeSupport.firePropertyChange("nomesystem", oldNomesystem, nomesystem);
    }

    public Date getSystemdate() {
        return systemdate;
    }

    public void setSystemdate(Date systemdate) {
        Date oldSystemdate = this.systemdate;
        this.systemdate = systemdate;
        changeSupport.firePropertyChange("systemdate", oldSystemdate, systemdate);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nseriegabinetePK != null ? nseriegabinetePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nseriegabinete)) {
            return false;
        }
        Nseriegabinete other = (Nseriegabinete) object;
        if ((this.nseriegabinetePK == null && other.nseriegabinetePK != null) || (this.nseriegabinetePK != null && !this.nseriegabinetePK.equals(other.nseriegabinetePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.technobsoftwares.gpiec.Nseriegabinete[ nseriegabinetePK=" + nseriegabinetePK + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
