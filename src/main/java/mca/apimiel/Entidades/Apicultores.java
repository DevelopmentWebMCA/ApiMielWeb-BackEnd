/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mca.apimiel.Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Jesus
 */
@Entity
@Table(name = "apicultores")
public class Apicultores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_apicultor")
    private String idApicultor;
    @Basic(optional = false)
    @Column(name = "nombre_apicultor")
    private String nombreApicultor;
    @Basic(optional = false)
    @Column(name = "numero_apiarios")
    private int numeroApiarios;
    @Basic(optional = false)
    @Column(name = "numero_empleados")
    private int numeroEmpleados;
    @Basic(optional = false)
    @Column(name = "correo_electronico")
    private String correoElectronico;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "apicultores")
    private List<DetalleProduccion> detalleProduccionList;
    @JoinColumn(name = "id_asociacion", referencedColumnName = "id_asociacion")
    @ManyToOne(optional = false)
    private Asociaciones idAsociacion;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuarios idUsuario;

    public Apicultores() {
    }

    public Apicultores(String idApicultor) {
        this.idApicultor = idApicultor;
    }

    public Apicultores(String idApicultor, String nombreApicultor, int numeroApiarios, int numeroEmpleados, String correoElectronico) {
        this.idApicultor = idApicultor;
        this.nombreApicultor = nombreApicultor;
        this.numeroApiarios = numeroApiarios;
        this.numeroEmpleados = numeroEmpleados;
        this.correoElectronico = correoElectronico;
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

    public List<DetalleProduccion> getDetalleProduccionList() {
        return detalleProduccionList;
    }

    public void setDetalleProduccionList(List<DetalleProduccion> detalleProduccionList) {
        this.detalleProduccionList = detalleProduccionList;
    }

    public Asociaciones getIdAsociacion() {
        return idAsociacion;
    }

    public void setIdAsociacion(Asociaciones idAsociacion) {
        this.idAsociacion = idAsociacion;
    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
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
        if (!(object instanceof Apicultores)) {
            return false;
        }
        Apicultores other = (Apicultores) object;
        if ((this.idApicultor == null && other.idApicultor != null) || (this.idApicultor != null && !this.idApicultor.equals(other.idApicultor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mca.apimiel.Entidades.Apicultores[ idApicultor=" + idApicultor + " ]";
    }
    
}
