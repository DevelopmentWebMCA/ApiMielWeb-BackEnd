/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mca.apimiel.Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "archivos_posts")
public class ArchivoPost implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_archivos")
    private Integer idArchivos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "url")
    private String url;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tipo_archivo")
    private String tipoArchivo;
    @Basic(optional = false)
    @Column(name = "actualizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actualizacion;
   

    public ArchivoPost() {
    }

    public ArchivoPost(Integer idArchivos) {
        this.idArchivos = idArchivos;
    }

    public ArchivoPost(Integer idArchivos, String url, String tipoArchivo, Date actualizacion) {
        this.idArchivos = idArchivos;
        this.url = url;
        this.tipoArchivo = tipoArchivo;
        this.actualizacion = actualizacion;
    }

    public Integer getIdArchivos() {
        return idArchivos;
    }

    public void setIdArchivos(Integer idArchivos) {
        this.idArchivos = idArchivos;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTipoArchivo() {
        return tipoArchivo;
    }

    public void setTipoArchivo(String tipoArchivo) {
        this.tipoArchivo = tipoArchivo;
    }

    public Date getActualizacion() {
        return actualizacion;
    }

    public void setActualizacion(Date actualizacion) {
        this.actualizacion = actualizacion;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArchivos != null ? idArchivos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArchivoPost)) {
            return false;
        }
        ArchivoPost other = (ArchivoPost) object;
        if ((this.idArchivos == null && other.idArchivos != null) || (this.idArchivos != null && !this.idArchivos.equals(other.idArchivos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mca.apimiel.Entidades.ArchivoPost[ idArchivos=" + idArchivos + " ]";
    }
    
}
