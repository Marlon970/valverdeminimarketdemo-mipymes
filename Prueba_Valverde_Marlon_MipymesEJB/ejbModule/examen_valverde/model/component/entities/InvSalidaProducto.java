package examen_valverde.model.component.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the inv_salida_productos database table.
 * 
 */
@Entity
@Table(name="inv_salida_productos")
@NamedQuery(name="InvSalidaProducto.findAll", query="SELECT i FROM InvSalidaProducto i")
public class InvSalidaProducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_inv_salida_producto")
	private Integer idInvSalidaProducto;

	@Column(name="salida_producto_cantidad")
	private Integer salidaProductoCantidad;

	//bi-directional many-to-one association to InvProducto
	@ManyToOne
	@JoinColumn(name="id_inv_producto")
	private InvProducto invProducto;

	public InvSalidaProducto() {
	}

	public Integer getIdInvSalidaProducto() {
		return this.idInvSalidaProducto;
	}

	public void setIdInvSalidaProducto(Integer idInvSalidaProducto) {
		this.idInvSalidaProducto = idInvSalidaProducto;
	}

	public Integer getSalidaProductoCantidad() {
		return this.salidaProductoCantidad;
	}

	public void setSalidaProductoCantidad(Integer salidaProductoCantidad) {
		this.salidaProductoCantidad = salidaProductoCantidad;
	}

	public InvProducto getInvProducto() {
		return this.invProducto;
	}

	public void setInvProducto(InvProducto invProducto) {
		this.invProducto = invProducto;
	}

}