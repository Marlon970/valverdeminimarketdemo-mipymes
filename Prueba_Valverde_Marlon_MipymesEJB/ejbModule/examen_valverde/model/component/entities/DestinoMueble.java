package examen_valverde.model.component.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the destino_mueble database table.
 * 
 */
@Entity
@Table(name="destino_mueble")
@NamedQuery(name="DestinoMueble.findAll", query="SELECT d FROM DestinoMueble d")
public class DestinoMueble implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_destino_mueble")
	private Integer idDestinoMueble;

	@Column(name="direccion_destino")
	private String direccionDestino;

	@Column(name="nombre_destino")
	private String nombreDestino;

	//bi-directional many-to-one association to ValverdemMueble
	@ManyToOne
	@JoinColumn(name="id_mueble")
	private ValverdemMueble valverdemMueble;

	public DestinoMueble() {
	}

	public Integer getIdDestinoMueble() {
		return this.idDestinoMueble;
	}

	public void setIdDestinoMueble(Integer idDestinoMueble) {
		this.idDestinoMueble = idDestinoMueble;
	}

	public String getDireccionDestino() {
		return this.direccionDestino;
	}

	public void setDireccionDestino(String direccionDestino) {
		this.direccionDestino = direccionDestino;
	}

	public String getNombreDestino() {
		return this.nombreDestino;
	}

	public void setNombreDestino(String nombreDestino) {
		this.nombreDestino = nombreDestino;
	}

	public ValverdemMueble getValverdemMueble() {
		return this.valverdemMueble;
	}

	public void setValverdemMueble(ValverdemMueble valverdemMueble) {
		this.valverdemMueble = valverdemMueble;
	}

}