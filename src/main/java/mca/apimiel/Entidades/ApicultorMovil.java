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

@Entity
@Table(name = "apicultores")
public class ApicultorMovil implements Serializable{
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

    @Column(name = "id_asociacion")
    private String idAsociacion;

	@Column(name = "nombre_asociacion")
    private String nombreAsociacion;
    @Column(name = "id_usuario")
    private int idUsuario;

    public ApicultorMovil() {
    }

    public ApicultorMovil(String idApicultor) {
        this.idApicultor = idApicultor;
    }

    public ApicultorMovil(String idApicultor, String nombreApicultor, int numeroApiarios, int numeroEmpleados, String correoElectronico, Date actualizacion, String idAsociacion, int idUsuario) {
        this.idApicultor = idApicultor;
        this.nombreApicultor = nombreApicultor;
        this.numeroApiarios = numeroApiarios;
        this.numeroEmpleados = numeroEmpleados;
        this.correoElectronico = correoElectronico;
        this.actualizacion = actualizacion;
        this.idAsociacion = idAsociacion;
        this.idUsuario = idUsuario;
    }

    
    public String getNombreAsociacion() {
		return nombreAsociacion;
	}

	public void setNombreAsociacion(String nombreAsociacion) {
		this.nombreAsociacion = nombreAsociacion;
	}

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public String getIdAsociacion() {
        return idAsociacion;
    }

    public void setIdAsociacion(String idAsociacion) {
        this.idAsociacion = idAsociacion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
