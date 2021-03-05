package mueblespruebavalverde.model.auditoria.manager;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import examen_valverde.model.component.entities.AudBitacora;
import mueblespruebavalverde.model.core.manager.ManagerDAO;

/**
 * Session Bean implementation class ManagerAuditoria
 */
@Stateless
@LocalBean
public class ManagerAuditoria {
	
	@EJB
	
	private ManagerDAO mDAO;

    /**
     * Default constructor. 
     */
    public ManagerAuditoria() {
       
    }
    
    public void mostrarLog( Class clase,String nombremetodo, String mensaje) {
    	
    	SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    	
    	System.out.println(format.format(new Date())+"["+clase.getSimpleName()+"/"+nombremetodo+"]:"+mensaje);
    	
    	AudBitacora pista = new AudBitacora();
    	
    	pista.setDescripcionEvento(mensaje);
    	pista.setDireccionIp("localhost");
    	Timestamp tiempo = new Timestamp(System.currentTimeMillis());
    	pista.setFechaEvento(tiempo);
    	pista.setIdUsuario("Anonimo");
    	pista.setNombreClase(clase.getSimpleName());
    	pista.setNombreMetodo(nombremetodo);
    	
    	try {
			mDAO.insertar(pista);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
    	
    	
        
     }
     

}
