package examen_valverde.model.component.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the seg_usuario database table.
 * 
 */
@Entity
@Table(name="seg_usuario")
@NamedQuery(name="SegUsuario.findAll", query="SELECT s FROM SegUsuario s")
public class SegUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_seg_usuario")
	private Integer idSegUsuario;

	private Boolean activo;

	private String apellido;

	private String clave;

	private String codigo;

	private String correo;

	private String nombre;

	//bi-directional many-to-one association to SegAsignaccion
	@OneToMany(mappedBy="segUsuario")
	private List<SegAsignaccion> segAsignaccions;

	public SegUsuario() {
	}

	public Integer getIdSegUsuario() {
		return this.idSegUsuario;
	}

	public void setIdSegUsuario(Integer idSegUsuario) {
		this.idSegUsuario = idSegUsuario;
	}

	public Boolean getActivo() {
		return this.activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<SegAsignaccion> getSegAsignaccions() {
		return this.segAsignaccions;
	}

	public void setSegAsignaccions(List<SegAsignaccion> segAsignaccions) {
		this.segAsignaccions = segAsignaccions;
	}

	public SegAsignaccion addSegAsignaccion(SegAsignaccion segAsignaccion) {
		getSegAsignaccions().add(segAsignaccion);
		segAsignaccion.setSegUsuario(this);

		return segAsignaccion;
	}

	public SegAsignaccion removeSegAsignaccion(SegAsignaccion segAsignaccion) {
		getSegAsignaccions().remove(segAsignaccion);
		segAsignaccion.setSegUsuario(null);

		return segAsignaccion;
	}

}