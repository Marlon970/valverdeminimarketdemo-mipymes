package examen_valverde.model.component.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the valverdem_mueble database table.
 * 
 */
@Entity
@Table(name="valverdem_mueble")
@NamedQuery(name="ValverdemMueble.findAll", query="SELECT v FROM ValverdemMueble v")
public class ValverdemMueble implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_mueble")
	private Integer idMueble;

	@Column(name="material_mueble")
	private String materialMueble;

	@Column(name="nombre_mueble")
	private String nombreMueble;

	@Column(name="precio_material")
	private String precioMaterial;

	@Column(name="stock_mueble")
	private String stockMueble;

	//bi-directional many-to-one association to DestinoMueble
	@OneToMany(mappedBy="valverdemMueble")
	private List<DestinoMueble> destinoMuebles;

	public ValverdemMueble() {
	}

	public Integer getIdMueble() {
		return this.idMueble;
	}

	public void setIdMueble(Integer idMueble) {
		this.idMueble = idMueble;
	}

	public String getMaterialMueble() {
		return this.materialMueble;
	}

	public void setMaterialMueble(String materialMueble) {
		this.materialMueble = materialMueble;
	}

	public String getNombreMueble() {
		return this.nombreMueble;
	}

	public void setNombreMueble(String nombreMueble) {
		this.nombreMueble = nombreMueble;
	}

	public String getPrecioMaterial() {
		return this.precioMaterial;
	}

	public void setPrecioMaterial(String precioMaterial) {
		this.precioMaterial = precioMaterial;
	}

	public String getStockMueble() {
		return this.stockMueble;
	}

	public void setStockMueble(String stockMueble) {
		this.stockMueble = stockMueble;
	}

	public List<DestinoMueble> getDestinoMuebles() {
		return this.destinoMuebles;
	}

	public void setDestinoMuebles(List<DestinoMueble> destinoMuebles) {
		this.destinoMuebles = destinoMuebles;
	}

	public DestinoMueble addDestinoMueble(DestinoMueble destinoMueble) {
		getDestinoMuebles().add(destinoMueble);
		destinoMueble.setValverdemMueble(this);

		return destinoMueble;
	}

	public DestinoMueble removeDestinoMueble(DestinoMueble destinoMueble) {
		getDestinoMuebles().remove(destinoMueble);
		destinoMueble.setValverdemMueble(null);

		return destinoMueble;
	}

}