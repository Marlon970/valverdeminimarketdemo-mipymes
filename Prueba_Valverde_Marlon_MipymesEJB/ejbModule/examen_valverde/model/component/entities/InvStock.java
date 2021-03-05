package examen_valverde.model.component.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the inv_stock database table.
 * 
 */
@Entity
@Table(name="inv_stock")
@NamedQuery(name="InvStock.findAll", query="SELECT i FROM InvStock i")
public class InvStock implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_inv_stock")
	private Integer idInvStock;

	@Column(name="final_stock")
	private Integer finalStock;

	//bi-directional many-to-one association to InvProducto
	@ManyToOne
	@JoinColumn(name="id_inv_producto")
	private InvProducto invProducto;

	public InvStock() {
	}

	public Integer getIdInvStock() {
		return this.idInvStock;
	}

	public void setIdInvStock(Integer idInvStock) {
		this.idInvStock = idInvStock;
	}

	public Integer getFinalStock() {
		return this.finalStock;
	}

	public void setFinalStock(Integer finalStock) {
		this.finalStock = finalStock;
	}

	public InvProducto getInvProducto() {
		return this.invProducto;
	}

	public void setInvProducto(InvProducto invProducto) {
		this.invProducto = invProducto;
	}

}