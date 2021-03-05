package mueblespruebavalverde.model.seguridades.manager;

import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import examen_valverde.model.component.entities.DestinoMueble;
import examen_valverde.model.component.entities.SegAsignaccion;
import examen_valverde.model.component.entities.SegModulo;
import examen_valverde.model.component.entities.SegUsuario;
import examen_valverde.model.component.entities.ValverdemMueble;
import mueblespruebavalverde.model.auditoria.manager.ManagerAuditoria;

import mueblespruebavalverde.model.core.manager.ManagerDAO;
import mueblespruebavalverde.model.core.utils.ModelUtils;
import mueblespruebavalverde.model.seguridades.manager.dto.LoginDTO;




/**
 * Session Bean implementation class ManagerSeguridades
 */
@Stateless
@LocalBean
public class ManagerSeguridades {
	
	@EJB
	private ManagerDAO mDAO;
	@EJB
	private ManagerAuditoria mAuditoria;
    /**
     * Default constructor. 
     */
    public ManagerSeguridades() {
        
    }
    /**
     * Funcion de inicializacion de datos de usuarios.
     */
    public void inicializarDemo() throws Exception {
    	mAuditoria.mostrarLog(getClass(), "inicializarDemo", "Inicializacion de bdd demo.");
    	List<SegUsuario> listaUsuarios=mDAO.findAll(SegUsuario.class);
    	for(SegUsuario u:listaUsuarios) {
    		mAuditoria.mostrarLog(getClass(), "inicializarDemo", "Eliminacion de usuario "+u.getCorreo()+" "+u.getIdSegUsuario());
    		mDAO.eliminar(SegUsuario.class, u.getIdSegUsuario());
    	}
    	//creacion del usuario administrador:
		SegUsuario administrador=new SegUsuario();
		administrador.setActivo(true);
		administrador.setApellido("admin");
		administrador.setClave("admin");
		administrador.setCorreo("admin@minimarketdemo.com");
		administrador.setNombre("admin");
		administrador.setCodigo("admin");
		mDAO.insertar(administrador);
		mAuditoria.mostrarLog(getClass(), "inicializarDemo", "Usuario administrador creado.");
		//inicializacion de modulos:
		SegModulo modulo=new SegModulo();
		modulo.setNombreModulo("Seguridades");
		modulo.setRutaAcceso("seguridades");
		mDAO.insertar(modulo);
		modulo=new SegModulo();
		modulo.setNombreModulo("Auditoría");
		modulo.setRutaAcceso("auditoria");
		mDAO.insertar(modulo);
		mAuditoria.mostrarLog(getClass(), "inicializarDemo", "Módulos creados.");
		//asignacion de accesos:
		asignarModulo(1, 1);
		asignarModulo(1, 2);
		mAuditoria.mostrarLog(getClass(), "inicializarDemo", "Inicializacion de bdd demo terminada.");
    }
    
    /**
     * Funcion de autenticacion mediante el uso de credenciales.
     * @param idSegUsuario El codigo del usuario que desea autenticarse.
     * @param clave La contrasenia.
     * @return La ruta de acceso al sistema.
     * @throws Exception
     */
    public LoginDTO login(int idSegUsuario,String clave) throws Exception{
    	if(ModelUtils.isEmpty(clave)) {
    		mAuditoria.mostrarLog(getClass(), "login", "Debe indicar una clave "+idSegUsuario);
    		throw new Exception("Debe indicar una clave");
    	}
    	SegUsuario usuario=(SegUsuario) mDAO.findById(SegUsuario.class, idSegUsuario);
    	if(usuario==null) {
    		mAuditoria.mostrarLog(getClass(), "login", "No existe usuario "+idSegUsuario);
    		throw new Exception("Error en credenciales.");
    	}
    	if(usuario.getClave().equals(clave)) {
    		mAuditoria.mostrarLog(getClass(), "login", "Login exitoso "+idSegUsuario);
    		//crear DTO:
    		LoginDTO loginDTO=new LoginDTO();
    		loginDTO.setIdSegUsuario(usuario.getIdSegUsuario());
    		loginDTO.setCorreo(usuario.getCorreo());
    		//obtener la lista de modulos a los que tiene acceso:
    		String consulta="o.segUsuario.idSegUsuario="+usuario.getIdSegUsuario();
    		List<SegAsignaccion> listaAsignaciones=mDAO.findWhere(SegAsignaccion.class, consulta, null);
    		for(SegAsignaccion asig:listaAsignaciones) {
    			SegModulo modulo=asig.getSegModulo();
    			loginDTO.getListamodulos().add(modulo);
    		}
    		return loginDTO;
    	}
    	mAuditoria.mostrarLog(getClass(), "login", "No coincide la clave "+idSegUsuario);
    	throw new Exception("Error en credenciales");
    }
    
    public void cerrarSesion(int idSegUsuario) {
    	mAuditoria.mostrarLog(getClass(), "cerrarSesion", "Cerrar sesión usuario: "+idSegUsuario);
    }
    
    public void accesoNoPermitido(int idSegUsuario,String ruta) {
    	mAuditoria.mostrarLog(getClass(), "accesoNoPermitido", "Usuario "+idSegUsuario+" intento no autorizado a "+ruta);
    }
    
    public List<SegUsuario> findAllUsuarios(){
    	return mDAO.findAll(SegUsuario.class, "apellidos");
    }
    
    public List<SegModulo> findAllModulos(){
    	return mDAO.findAll(SegModulo.class, "nombreModulo");
    }
    
    public List<ValverdemMueble> findAllMuebles(){
    	return mDAO.findAll(ValverdemMueble.class, "nombreMueble");
    }
    
    public List<DestinoMueble> findAllDestinoMueble(){
    	return mDAO.findAll(DestinoMueble.class, "nombre_destino");
    }
    
    /**
     * Permite asignar el acceso a un modulo del inventario de sistemas.
     * @param idSegUsuario El codigo del usuario.
     * @param idSegModulo El codigo del modulo que se va a asignar.
     * @throws Exception
     */
    public void asignarModulo(int idSegUsuario,int idSegModulo) throws Exception{
    	//Buscar los objetos primarios:
    	SegUsuario usuario=(SegUsuario)mDAO.findById(SegUsuario.class, idSegUsuario);
    	SegModulo modulo=(SegModulo)mDAO.findById(SegModulo.class, idSegModulo);
    	//crear la relacion:
    	SegAsignaccion asignacion=new SegAsignaccion();
    	asignacion.setSegModulo(modulo);
    	asignacion.setSegUsuario(usuario);
    	//guardar la asignacion:
    	mDAO.insertar(asignacion);
    	mAuditoria.mostrarLog(getClass(), "asignarModulo", "Modulo "+idSegModulo+" asigando a usuario "+idSegUsuario);
    }

	





        
    }
