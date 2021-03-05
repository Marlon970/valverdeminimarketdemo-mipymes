package examen_valverde.model.component.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the inv_ingreso_productos database table.
 * 
 */
@Entity
@Table(name="inv_ingreso_productos")
@NamedQuery(name="InvIngresoProducto.findAll", query="SELECT i FROM InvIngresoProducto i")
public class InvIngresoProducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_inv_ingreso_producto")
	private Integer idInvIngresoProducto;

	@Column(name="ingreso_producto_cantidad")
	private Integer ingresoProductoCantidad;

	//bi-directional many-to-one association to InvProducto
	@ManyToOne
	@JoinColumn(name="id_inv_producto")
	private InvProducto invProducto;

	public InvIngresoProducto() {
	}

	public Integer getIdInvIngresoProducto() {
		return this.idInvIngresoProducto;
	}

	public void setIdInvIngresoProducto(Integer idInvIngresoProducto) {
		this.idInvIngresoProducto = idInvIngresoProducto;
	}

	public Integer getIngresoProductoCantidad() {
		return this.ingresoProductoCantidad;
	}

	public void setIngresoProductoCantidad(Integer ingresoProductoCantidad) {
		this.ingresoProductoCantidad = ingresoProductoCantidad;
	}

	public InvProducto getInvProducto() {
		return this.invProducto;
	}

	public void setInvProducto(InvProducto invProducto) {
		this.invProducto = invProducto;
	}

}