package mueblepruebavalverde1.controller.mueble;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import examen_valverde.model.component.entities.ValverdemMueble;
import mueblepruebavalverde1.controller.JSFUtil;

import mueblespruebavalverde.model.manager.ManagerMueble;

@Named
@SessionScoped
public class BeanMueble1 implements Serializable {
	
	
	private String nombreMueble;
	private String materialMueble;
	private String precioMueble;
	private String stockMueble;
	private ValverdemMueble edit;
	
	private List<ValverdemMueble> listamuebles;
	
	

	@EJB
	private ManagerMueble managerMueble;
	
	@PostConstruct
	
	public void inicializar() {
		listamuebles = managerMueble.findAllMueble();
	}

	public void actionListenerCrearMueble() {

		try {
			managerMueble.crearMueble(nombreMueble, materialMueble, precioMueble, stockMueble);
			listamuebles = managerMueble.findAllMueble();
			JSFUtil.crearMensajeINFO("Mueble Creado");

		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}

	}

	public void actionListenerEliminarMueble(int idMUeble) {
		try {

			managerMueble.eliminarMueble(idMUeble);
			listamuebles = managerMueble.findAllMueble();
			JSFUtil.crearMensajeINFO("Mueble con el ID" + idMUeble + " fue Eliminado");
			

		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}
	}

	public void actionListenerSelecionarMUeble(ValverdemMueble mueble) {
		edit = mueble;
		System.out.println("Usuario Selecionado: " + edit.getIdMueble());

	}

	public void actionListenerActualizarMueble() {
		try {

			managerMueble.actualizarMueble(edit);
			JSFUtil.crearMensajeINFO("El Mueble a sido Actualizado");

		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.getStackTrace();
		}

	}
	
	

	public ValverdemMueble getEdit() {
		return edit;
	}

	public void setEdit(ValverdemMueble edit) {
		this.edit = edit;
	}

	public BeanMueble1() {
		// TODO Auto-generated constructor stub
	}

	public String getNombreMueble() {
		return nombreMueble;
	}

	public void setNombreMueble(String nombreMueble) {
		this.nombreMueble = nombreMueble;
	}

	public String getMaterialMueble() {
		return materialMueble;
	}

	public void setMaterialMueble(String materialMueble) {
		this.materialMueble = materialMueble;
	}

	public String getPrecioMueble() {
		return precioMueble;
	}

	public void setPrecioMueble(String precioMueble) {
		this.precioMueble = precioMueble;
	}

	public String getStockMueble() {
		return stockMueble;
	}

	public void setStockMueble(String stockMueble) {
		this.stockMueble = stockMueble;
	}

	public List<ValverdemMueble> getListamuebles() {
		return listamuebles;
	}

	public void setListamuebles(List<ValverdemMueble> listamuebles) {
		this.listamuebles = listamuebles;
	}
	
	
	

}
