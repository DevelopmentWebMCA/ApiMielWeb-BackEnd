/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mca.apimiel.Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Jesus
 */
@Embeddable
public class DetalleProduccionPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_apicultor")
    private String idApicultor;
    @Basic(optional = false)
    @Column(name = "id_producto")
    private String idProducto;
    @Basic(optional = false)
    @Column(name = "id_detalle_produccion")
    private int idDetalleProduccion;

    public DetalleProduccionPK() {
    }

    public DetalleProduccionPK(String idApicultor, String idProducto, int idDetalleProduccion) {
        this.idApicultor = idApicultor;
        this.idProducto = idProducto;
        this.idDetalleProduccion = idDetalleProduccion;
    }

    public String getIdApicultor() {
        return idApicultor;
    }

    public void setIdApicultor(String idApicultor) {
        this.idApicultor = idApicultor;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdDetalleProduccion() {
        return idDetalleProduccion;
    }

    public void setIdDetalleProduccion(int idDetalleProduccion) {
        this.idDetalleProduccion = idDetalleProduccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idApicultor != null ? idApicultor.hashCode() : 0);
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        hash += (int) idDetalleProduccion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleProduccionPK)) {
            return false;
        }
        DetalleProduccionPK other = (DetalleProduccionPK) object;
        if ((this.idApicultor == null && other.idApicultor != null) || (this.idApicultor != null && !this.idApicultor.equals(other.idApicultor))) {
            return false;
        }
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        if (this.idDetalleProduccion != other.idDetalleProduccion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mca.apimiel.Entidades.DetalleProduccionPK[ idApicultor=" + idApicultor + ", idProducto=" + idProducto + ", idDetalleProduccion=" + idDetalleProduccion + " ]";
    }
    
}
