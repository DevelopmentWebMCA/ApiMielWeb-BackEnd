/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mca.apimiel.Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Jesus
 */
@Entity
@Table(name = "archivos_posts")
public class ArchivosPosts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_archivos")
    private Integer idArchivos;
    @Basic(optional = false)
    @Column(name = "url")
    private String url;
    @Basic(optional = false)
    @Column(name = "tipo_archivo")
    private String tipoArchivo;
    @JoinColumn(name = "posts_id_post", referencedColumnName = "id_post")
    @ManyToOne(optional = false)
    private Posts postsIdPost;

    public ArchivosPosts() {
    }

    public ArchivosPosts(Integer idArchivos) {
        this.idArchivos = idArchivos;
    }

    public ArchivosPosts(Integer idArchivos, String url, String tipoArchivo) {
        this.idArchivos = idArchivos;
        this.url = url;
        this.tipoArchivo = tipoArchivo;
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

    public Posts getPostsIdPost() {
        return postsIdPost;
    }

    public void setPostsIdPost(Posts postsIdPost) {
        this.postsIdPost = postsIdPost;
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
        if (!(object instanceof ArchivosPosts)) {
            return false;
        }
        ArchivosPosts other = (ArchivosPosts) object;
        if ((this.idArchivos == null && other.idArchivos != null) || (this.idArchivos != null && !this.idArchivos.equals(other.idArchivos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mca.apimiel.Entidades.ArchivosPosts[ idArchivos=" + idArchivos + " ]";
    }
    
}
