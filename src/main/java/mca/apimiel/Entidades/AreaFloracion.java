package mca.apimiel.Entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "areas_floracion")

public class AreaFloracion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_areas_floracion")
    private Integer idAreasFloracion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre_finca")
    private String nombreFinca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "region_estado")
    private String regionEstado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "familia_flores")
    private String familiaFlores;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "especie_flores")
    private String especieFlores;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre_comun")
    private String nombreComun;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre_cientifico")
    private String nombreCientifico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "periodo_floracion")
    private String periodoFloracion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "latitud")
    private BigDecimal latitud;
    @Column(name = "longitud")
    private BigDecimal longitud;
    @Basic(optional = false)
    @NotNull
    @Column(name = "actualizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actualizacion;

    public AreaFloracion() {
    }

    public AreaFloracion(Integer idAreasFloracion) {
        this.idAreasFloracion = idAreasFloracion;
    }

    public AreaFloracion(Integer idAreasFloracion, String nombreFinca, String regionEstado, String familiaFlores, String especieFlores, String nombreComun, String nombreCientifico, String periodoFloracion, Date actualizacion) {
        this.idAreasFloracion = idAreasFloracion;
        this.nombreFinca = nombreFinca;
        this.regionEstado = regionEstado;
        this.familiaFlores = familiaFlores;
        this.especieFlores = especieFlores;
        this.nombreComun = nombreComun;
        this.nombreCientifico = nombreCientifico;
        this.periodoFloracion = periodoFloracion;
        this.actualizacion = actualizacion;
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

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public void setNombreCientifico(String frecuenciaVisita) {
        this.nombreCientifico = frecuenciaVisita;
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

    public Date getActualizacion() {
        return actualizacion;
    }

    public void setActualizacion(Date actualizacion) {
        this.actualizacion = actualizacion;
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
        if (!(object instanceof AreaFloracion)) {
            return false;
        }
        AreaFloracion other = (AreaFloracion) object;
        if ((this.idAreasFloracion == null && other.idAreasFloracion != null) || (this.idAreasFloracion != null && !this.idAreasFloracion.equals(other.idAreasFloracion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mca.apimiel.Entidades.AreaFloracion[ idAreasFloracion=" + idAreasFloracion + " ]";
    }
    
}
