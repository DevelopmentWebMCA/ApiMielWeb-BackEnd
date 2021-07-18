/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mca.apimiel.Entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Andres Cuevas
 */
@Entity
@Table(name = "apicultores")

public class Apicultor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "id_apicultor")
    private String idApicultor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_apicultor")
    private String nombreApicultor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_apiarios")
    private int numeroApiarios;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_empleados")
    private int numeroEmpleados;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "correo_electronico")
    private String correoElectronico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "actualizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actualizacion;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "apicultor")
    private List<DetalleProduccion> detalleProduccionList;
    @JoinColumn(name = "id_asociacion", referencedColumnName = "id_asociacion")
    @ManyToOne(optional = false)
    private Asociacion asociacion;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario usuario;

    public Apicultor() {
    }

    public Apicultor(String idApicultor) {
        this.idApicultor = idApicultor;
    }

    public Apicultor(String idApicultor, String nombreApicultor, int numeroApiarios, int numeroEmpleados, String correoElectronico, Date actualizacion) {
        this.idApicultor = idApicultor;
        this.nombreApicultor = nombreApicultor;
        this.numeroApiarios = numeroApiarios;
        this.numeroEmpleados = numeroEmpleados;
        this.correoElectronico = correoElectronico;
        this.actualizacion = actualizacion;
    }

    public String getIdApicultor() {
        return idApicultor;
    }

    public void setIdApicultor(String idApicultor) {
        this.idApicultor = idApicultor;
    }

    public String getNombreApicultor() {
        return nombreApicultor;
    }

    public void setNombreApicultor(String nombreApicultor) {
        this.nombreApicultor = nombreApicultor;
    }

    public int getNumeroApiarios() {
        return numeroApiarios;
    }

    public void setNumeroApiarios(int numeroApiarios) {
        this.numeroApiarios = numeroApiarios;
    }

    public int getNumeroEmpleados() {
        return numeroEmpleados;
    }

    public void setNumeroEmpleados(int numeroEmpleados) {
        this.numeroEmpleados = numeroEmpleados;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public Date getActualizacion() {
        return actualizacion;
    }

    public void setActualizacion(Date actualizacion) {
        this.actualizacion = actualizacion;
    }

    public List<DetalleProduccion> getDetalleProduccionList() {
        return detalleProduccionList;
    }

    public void setDetalleProduccionList(List<DetalleProduccion> detalleProduccionList) {
        this.detalleProduccionList = detalleProduccionList;
    }

    public Asociacion getAsociacion() {
        return asociacion;
    }

    public void setAsociacion(Asociacion asociacion) {
        this.asociacion = asociacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idApicultor != null ? idApicultor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Apicultor)) {
            return false;
        }
        Apicultor other = (Apicultor) object;
        if ((this.idApicultor == null && other.idApicultor != null) || (this.idApicultor != null && !this.idApicultor.equals(other.idApicultor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mca.apimiel.Entidades.Apicultor[ idApicultor=" + idApicultor + " ]";
    }
    
}
