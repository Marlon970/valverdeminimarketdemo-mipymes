package examen_valverde.model.component.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the seg_modulo database table.
 * 
 */
@Entity
@Table(name="seg_modulo")
@NamedQuery(name="SegModulo.findAll", query="SELECT s FROM SegModulo s")
public class SegModulo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_seg_modulo")
	private Integer idSegModulo;

	@Column(name="nombre_modulo")
	private String nombreModulo;

	@Column(name="ruta_acceso")
	private String rutaAcceso;

	//bi-directional many-to-one association to SegAsignaccion
	@OneToMany(mappedBy="segModulo")
	private List<SegAsignaccion> segAsignaccions;

	public SegModulo() {
	}

	public Integer getIdSegModulo() {
		return this.idSegModulo;
	}

	public void setIdSegModulo(Integer idSegModulo) {
		this.idSegModulo = idSegModulo;
	}

	public String getNombreModulo() {
		return this.nombreModulo;
	}

	public void setNombreModulo(String nombreModulo) {
		this.nombreModulo = nombreModulo;
	}

	public String getRutaAcceso() {
		return this.rutaAcceso;
	}

	public void setRutaAcceso(String rutaAcceso) {
		this.rutaAcceso = rutaAcceso;
	}

	public List<SegAsignaccion> getSegAsignaccions() {
		return this.segAsignaccions;
	}

	public void setSegAsignaccions(List<SegAsignaccion> segAsignaccions) {
		this.segAsignaccions = segAsignaccions;
	}

	public SegAsignaccion addSegAsignaccion(SegAsignaccion segAsignaccion) {
		getSegAsignaccions().add(segAsignaccion);
		segAsignaccion.setSegModulo(this);

		return segAsignaccion;
	}

	public SegAsignaccion removeSegAsignaccion(SegAsignaccion segAsignaccion) {
		getSegAsignaccions().remove(segAsignaccion);
		segAsignaccion.setSegModulo(null);

		return segAsignaccion;
	}

}