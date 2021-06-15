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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Jesus
 */
@Entity
@Table(name = "asociaciones")
public class Asociaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_asociacion")
    private String idAsociacion;
    @Basic(optional = false)
    @Column(name = "nombre_asociacion")
    private String nombreAsociacion;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "ciudad")
    private String ciudad;
    @Basic(optional = false)
    @Column(name = "codigo_postal")
    private String codigoPostal;
    @Basic(optional = false)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @Column(name = "correo_electronico")
    private String correoElectronico;
    @Basic(optional = false)
    @Column(name = "telefono")
    private String telefono;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAsociacion")
    private List<Apicultores> apicultoresList;

    public Asociaciones() {
    }

    public Asociaciones(String idAsociacion) {
        this.idAsociacion = idAsociacion;
    }

    public Asociaciones(String idAsociacion, String nombreAsociacion, String descripcion, String ciudad, String codigoPostal, String direccion, String correoElectronico, String telefono) {
        this.idAsociacion = idAsociacion;
        this.nombreAsociacion = nombreAsociacion;
        this.descripcion = descripcion;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
        this.direccion = direccion;
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
    }

    public String getIdAsociacion() {
        return idAsociacion;
    }

    public void setIdAsociacion(String idAsociacion) {
        this.idAsociacion = idAsociacion;
    }

    public String getNombreAsociacion() {
        return nombreAsociacion;
    }

    public void setNombreAsociacion(String nombreAsociacion) {
        this.nombreAsociacion = nombreAsociacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Apicultores> getApicultoresList() {
        return apicultoresList;
    }

    public void setApicultoresList(List<Apicultores> apicultoresList) {
        this.apicultoresList = apicultoresList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAsociacion != null ? idAsociacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asociaciones)) {
            return false;
        }
        Asociaciones other = (Asociaciones) object;
        if ((this.idAsociacion == null && other.idAsociacion != null) || (this.idAsociacion != null && !this.idAsociacion.equals(other.idAsociacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mca.apimiel.Entidades.Asociaciones[ idAsociacion=" + idAsociacion + " ]";
    }
    
}
