package mueblepruebavalverde1.controller.mueble;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import examen_valverde.model.component.entities.DestinoMueble;
import examen_valverde.model.component.entities.ValverdemMueble;
import mueblepruebavalverde1.controller.JSFUtil;

import mueblespruebavalverde.model.manager.ManagerDestinoMueble;
import mueblespruebavalverde.model.manager.ManagerMueble;
import mueblespruebavalverde.model.seguridades.manager.ManagerSeguridades;

@Named
@SessionScoped
public class BeanDestinoMueble implements Serializable {
	
	private int idmueble;
	private String lugardeDestino;
	private String direccionDestino;
	
	private List<DestinoMueble> listadestinos;
	private List<ValverdemMueble> listamuebles;
	private DestinoMueble edit;
	
	 @EJB
	 private ManagerMueble mMueble;
	 @EJB
	 private ManagerDestinoMueble mDestinoMueble;
	 
	 @EJB
	 private ManagerSeguridades mseguridad;
	 

	 @PostConstruct
	 
	 public void inicializar() {
		 
		 listadestinos= mDestinoMueble.findAllDestinoMueble();
		 listamuebles = mMueble.findAllMueble();
	 }

	public BeanDestinoMueble() {
		// TODO Auto-generated constructor stub
	}
	
	

	public void actionListenerCreaDestino() {
		try {

			mDestinoMueble.crearDestino( idmueble, lugardeDestino, direccionDestino);
			// cada ves que se crea un blog se actualiza la tabla
			listadestinos = mDestinoMueble.findAllDestinoMueble();
			JSFUtil.crearMensajeINFO("Se creado un Destino");
		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}

	}
	
	
	public void actionListenerEliminarDestino(int idDestino) {
		try {
			
			mDestinoMueble.eliminarDestino(idDestino);
			listadestinos = mDestinoMueble.findAllDestinoMueble();
            
			JSFUtil.crearMensajeINFO("El DEstino con el ID " + idDestino + " fue eliminado");

		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.printStackTrace();
		}

	}

	public void actionListenerSelecionarDestino(DestinoMueble  Destino) {
		edit=  Destino;
		System.out.println("Destino Selecionado: " + edit.getIdDestinoMueble());

	}

	public void actionListenerActualizarDestino() {
		try {
			
			mDestinoMueble.actualizarDestino(edit, idmueble);
           listadestinos = mDestinoMueble.findAllDestinoMueble();
           
			JSFUtil.crearMensajeINFO("El Destino y sus Datos fueron Actualizado");

		} catch (Exception e) {
			JSFUtil.crearMensajeERROR(e.getMessage());
			e.getStackTrace();
		}

	}
	
public String accionCargarMuebles(){
		
		//listadestinos = mseguridad.findAllDestinoMueble();
		
		return "destinomueble";
		
		
		
	}

	public int getIdmueble() {
		return idmueble;
	}

	public void setIdmueble(int idmueble) {
		this.idmueble = idmueble;
	}

	public String getLugardeDestino() {
		return lugardeDestino;
	}

	public void setLugardeDestino(String lugardeDestino) {
		this.lugardeDestino = lugardeDestino;
	}

	public String getDireccionDestino() {
		return direccionDestino;
	}

	public void setDireccionDestino(String direccionDestino) {
		this.direccionDestino = direccionDestino;
	}

	public List<DestinoMueble> getListadestinos() {
		return listadestinos;
	}

	public void setListadestinos(List<DestinoMueble> listadestinos) {
		this.listadestinos = listadestinos;
	}

	public List<ValverdemMueble> getListamuebles() {
		return listamuebles;
	}

	public void setListamuebles(List<ValverdemMueble> listamuebles) {
		this.listamuebles = listamuebles;
	}

	public DestinoMueble getEdit() {
		return edit;
	}

	public void setEdit(DestinoMueble edit) {
		this.edit = edit;
	}

	public ManagerMueble getmMueble() {
		return mMueble;
	}

	public void setmMueble(ManagerMueble mMueble) {
		this.mMueble = mMueble;
	}

	public ManagerDestinoMueble getmDestinoMueble() {
		return mDestinoMueble;
	}

	public void setmDestinoMueble(ManagerDestinoMueble mDestinoMueble) {
		this.mDestinoMueble = mDestinoMueble;
	}
	
	

}
