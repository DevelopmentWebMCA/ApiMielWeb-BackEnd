/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mca.apimiel.Entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Jesus
 */
@Entity
@Table(name = "areas_floracion")
public class AreasFloracion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_areas_floracion")
    private Integer idAreasFloracion;
    @Basic(optional = false)
    @Column(name = "nombre_finca")
    private String nombreFinca;
    @Basic(optional = false)
    @Column(name = "region_estado")
    private String regionEstado;
    @Basic(optional = false)
    @Column(name = "familia_flores")
    private String familiaFlores;
    @Basic(optional = false)
    @Column(name = "especie_flores")
    private String especieFlores;
    @Basic(optional = false)
    @Column(name = "nombre_comun")
    private String nombreComun;
    @Basic(optional = false)
    @Column(name = "frecuencia_visita")
    private String frecuenciaVisita;
    @Basic(optional = false)
    @Column(name = "periodo_floracion")
    private String periodoFloracion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "latitud")
    private BigDecimal latitud;
    @Basic(optional = false)
    @Column(name = "longitud")
    private BigDecimal longitud;

    public AreasFloracion() {
    }

    public AreasFloracion(Integer idAreasFloracion) {
        this.idAreasFloracion = idAreasFloracion;
    }

    public AreasFloracion(Integer idAreasFloracion, String nombreFinca, String regionEstado, String familiaFlores, String especieFlores, String nombreComun, String frecuenciaVisita, String periodoFloracion, BigDecimal latitud, BigDecimal longitud) {
        this.idAreasFloracion = idAreasFloracion;
        this.nombreFinca = nombreFinca;
        this.regionEstado = regionEstado;
        this.familiaFlores = familiaFlores;
        this.especieFlores = especieFlores;
        this.nombreComun = nombreComun;
        this.frecuenciaVisita = frecuenciaVisita;
        this.periodoFloracion = periodoFloracion;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public Integer getIdAreasFloracion() {
        return idAreasFloracion;
    }

    public void setIdAreasFloracion(Integer idAreasFloracion) {
        this.idAreasFloracion = idAreasFloracion;
    }

    public String getNombreFinca() {
        return nombreFinca;
    }

    public void setNombreFinca(String nombreFinca) {
        this.nombreFinca = nombreFinca;
    }

    public String getRegionEstado() {
        return regionEstado;
    }

    public void setRegionEstado(String regionEstado) {
        this.regionEstado = regionEstado;
    }

    public String getFamiliaFlores() {
        return familiaFlores;
    }

    public void setFamiliaFlores(String familiaFlores) {
        this.familiaFlores = familiaFlores;
    }

    public String getEspecieFlores() {
        return especieFlores;
    }

    public void setEspecieFlores(String especieFlores) {
        this.especieFlores = especieFlores;
    }

    public String getNombreComun() {
        return nombreComun;
    }

    public void setNombreComun(String nombreComun) {
        this.nombreComun = nombreComun;
    }

    public String getFrecuenciaVisita() {
        return frecuenciaVisita;
    }

    public void setFrecuenciaVisita(String frecuenciaVisita) {
        this.frecuenciaVisita = frecuenciaVisita;
    }

    public String getPeriodoFloracion() {
        return periodoFloracion;
    }

    public void setPeriodoFloracion(String periodoFloracion) {
        this.periodoFloracion = periodoFloracion;
    }

    public BigDecimal getLatitud() {
        return latitud;
    }

    public void setLatitud(BigDecimal latitud) {
        this.latitud = latitud;
    }

    public BigDecimal getLongitud() {
        return longitud;
    }

    public void setLongitud(BigDecimal longitud) {
        this.longitud = longitud;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAreasFloracion != null ? idAreasFloracion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AreasFloracion)) {
            return false;
        }
        AreasFloracion other = (AreasFloracion) object;
        if ((this.idAreasFloracion == null && other.idAreasFloracion != null) || (this.idAreasFloracion != null && !this.idAreasFloracion.equals(other.idAreasFloracion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mca.apimiel.Entidades.AreasFloracion[ idAreasFloracion=" + idAreasFloracion + " ]";
    }
    
}
