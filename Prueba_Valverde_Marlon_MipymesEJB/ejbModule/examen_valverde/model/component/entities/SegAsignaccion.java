package examen_valverde.model.component.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the seg_asignaccion database table.
 * 
 */
@Entity
@Table(name="seg_asignaccion")
@NamedQuery(name="SegAsignaccion.findAll", query="SELECT s FROM SegAsignaccion s")
public class SegAsignaccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_seg_asignacion")
	private Integer idSegAsignacion;

	//bi-directional many-to-one association to SegModulo
	@ManyToOne
	@JoinColumn(name="id_seg_modulo")
	private SegModulo segModulo;

	//bi-directional many-to-one association to SegUsuario
	@ManyToOne
	@JoinColumn(name="id_seg_usuario")
	private SegUsuario segUsuario;

	public SegAsignaccion() {
	}

	public Integer getIdSegAsignacion() {
		return this.idSegAsignacion;
	}

	public void setIdSegAsignacion(Integer idSegAsignacion) {
		this.idSegAsignacion = idSegAsignacion;
	}

	public SegModulo getSegModulo() {
		return this.segModulo;
	}

	public void setSegModulo(SegModulo segModulo) {
		this.segModulo = segModulo;
	}

	public SegUsuario getSegUsuario() {
		return this.segUsuario;
	}

	public void setSegUsuario(SegUsuario segUsuario) {
		this.segUsuario = segUsuario;
	}

}