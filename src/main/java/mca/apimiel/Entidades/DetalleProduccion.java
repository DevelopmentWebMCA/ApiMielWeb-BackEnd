/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mca.apimiel.Entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Jesus
 */
@Entity
@Table(name = "detalle_produccion")
public class DetalleProduccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetalleProduccionPK detalleProduccionPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "cantidad")
    private BigDecimal cantidad;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "id_apicultor", referencedColumnName = "id_apicultor", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Apicultores apicultores;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Productos productos;

    public DetalleProduccion() {
    }

    public DetalleProduccion(DetalleProduccionPK detalleProduccionPK) {
        this.detalleProduccionPK = detalleProduccionPK;
    }

    public DetalleProduccion(DetalleProduccionPK detalleProduccionPK, BigDecimal cantidad, Date fecha) {
        this.detalleProduccionPK = detalleProduccionPK;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public DetalleProduccion(String idApicultor, String idProducto, int idDetalleProduccion) {
        this.detalleProduccionPK = new DetalleProduccionPK(idApicultor, idProducto, idDetalleProduccion);
    }

    public DetalleProduccionPK getDetalleProduccionPK() {
        return detalleProduccionPK;
    }

    public void setDetalleProduccionPK(DetalleProduccionPK detalleProduccionPK) {
        this.detalleProduccionPK = detalleProduccionPK;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Apicultores getApicultores() {
        return apicultores;
    }

    public void setApicultores(Apicultores apicultores) {
        this.apicultores = apicultores;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detalleProduccionPK != null ? detalleProduccionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleProduccion)) {
            return false;
        }
        DetalleProduccion other = (DetalleProduccion) object;
        if ((this.detalleProduccionPK == null && other.detalleProduccionPK != null) || (this.detalleProduccionPK != null && !this.detalleProduccionPK.equals(other.detalleProduccionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mca.apimiel.Entidades.DetalleProduccion[ detalleProduccionPK=" + detalleProduccionPK + " ]";
    }
    
}
