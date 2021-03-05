package examen_valverde.model.component.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the inv_producto database table.
 * 
 */
@Entity
@Table(name="inv_producto")
@NamedQuery(name="InvProducto.findAll", query="SELECT i FROM InvProducto i")
public class InvProducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_inv_producto")
	private Integer idInvProducto;

	@Column(name="nombre_producto")
	private String nombreProducto;

	@Column(name="precio_producto")
	private String precioProducto;

	//bi-directional many-to-one association to InvIngresoProducto
	@OneToMany(mappedBy="invProducto")
	private List<InvIngresoProducto> invIngresoProductos;

	//bi-directional many-to-one association to InvSalidaProducto
	@OneToMany(mappedBy="invProducto")
	private List<InvSalidaProducto> invSalidaProductos;

	//bi-directional many-to-one association to InvStock
	@OneToMany(mappedBy="invProducto")
	private List<InvStock> invStocks;

	public InvProducto() {
	}

	public Integer getIdInvProducto() {
		return this.idInvProducto;
	}

	public void setIdInvProducto(Integer idInvProducto) {
		this.idInvProducto = idInvProducto;
	}

	public String getNombreProducto() {
		return this.nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getPrecioProducto() {
		return this.precioProducto;
	}

	public void setPrecioProducto(String precioProducto) {
		this.precioProducto = precioProducto;
	}

	public List<InvIngresoProducto> getInvIngresoProductos() {
		return this.invIngresoProductos;
	}

	public void setInvIngresoProductos(List<InvIngresoProducto> invIngresoProductos) {
		this.invIngresoProductos = invIngresoProductos;
	}

	public InvIngresoProducto addInvIngresoProducto(InvIngresoProducto invIngresoProducto) {
		getInvIngresoProductos().add(invIngresoProducto);
		invIngresoProducto.setInvProducto(this);

		return invIngresoProducto;
	}

	public InvIngresoProducto removeInvIngresoProducto(InvIngresoProducto invIngresoProducto) {
		getInvIngresoProductos().remove(invIngresoProducto);
		invIngresoProducto.setInvProducto(null);

		return invIngresoProducto;
	}

	public List<InvSalidaProducto> getInvSalidaProductos() {
		return this.invSalidaProductos;
	}

	public void setInvSalidaProductos(List<InvSalidaProducto> invSalidaProductos) {
		this.invSalidaProductos = invSalidaProductos;
	}

	public InvSalidaProducto addInvSalidaProducto(InvSalidaProducto invSalidaProducto) {
		getInvSalidaProductos().add(invSalidaProducto);
		invSalidaProducto.setInvProducto(this);

		return invSalidaProducto;
	}

	public InvSalidaProducto removeInvSalidaProducto(InvSalidaProducto invSalidaProducto) {
		getInvSalidaProductos().remove(invSalidaProducto);
		invSalidaProducto.setInvProducto(null);

		return invSalidaProducto;
	}

	public List<InvStock> getInvStocks() {
		return this.invStocks;
	}

	public void setInvStocks(List<InvStock> invStocks) {
		this.invStocks = invStocks;
	}

	public InvStock addInvStock(InvStock invStock) {
		getInvStocks().add(invStock);
		invStock.setInvProducto(this);

		return invStock;
	}

	public InvStock removeInvStock(InvStock invStock) {
		getInvStocks().remove(invStock);
		invStock.setInvProducto(null);

		return invStock;
	}

}