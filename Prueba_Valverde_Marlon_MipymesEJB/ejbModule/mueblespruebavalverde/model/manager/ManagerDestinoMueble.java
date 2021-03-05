package mueblespruebavalverde.model.manager;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import examen_valverde.model.component.entities.DestinoMueble;
import examen_valverde.model.component.entities.ValverdemMueble;



/**
 * Session Bean implementation class ManagerDestinoMueble
 */
@Stateless
@LocalBean
public class ManagerDestinoMueble {
	
	@PersistenceContext
	private EntityManager em;

    /**
     * Default constructor. 
     */
    public ManagerDestinoMueble() {
        // TODO Auto-generated constructor stub
    }
    
    public List<DestinoMueble> findAllDestinoMueble(){
    	return em.createNamedQuery("DestinoMueble.findAll", DestinoMueble.class).getResultList();
    }
    
    public void crearDestino(  int idMueble, String lugardestino, String direccion) throws Exception{
    	DestinoMueble d= new DestinoMueble();

    	ValverdemMueble es= em.find(ValverdemMueble.class, idMueble);
    	d.setValverdemMueble(es);
    	d.setNombreDestino(lugardestino);
    	d.setDireccionDestino(direccion);
    	
    	
    	em.persist(d);
    	
    }
    
    public void eliminarDestino(int idDestino) throws Exception {
  		// Buscar el objeto lo que correspone al identificado clave primaria
  		DestinoMueble d = em.find(DestinoMueble.class, idDestino);
  		if (d == null)
  			throw new Exception("No existe el Destino (" + idDestino + ")");
  		// NO SE PUEDE ELIMINAR EL USUARIO ADMIN
  		
  		em.remove(d);
  	}
      
      public void actualizarDestino(DestinoMueble destino, int idmueble) throws Exception {
      
      		// busca el objeto Original
      	 
      	    DestinoMueble destinomueble = em.find(DestinoMueble.class, destino.getIdDestinoMueble());
      	    ValverdemMueble mueble = em.find(ValverdemMueble.class, idmueble);
      		
      		
      		if (destinomueble == null)
      			throw new Exception("No existe el destino del mueble(" + destino.getIdDestinoMueble() + ")");
      		// no se utiliza ni el Id ni la clave
      		
      		
      		destinomueble.setValverdemMueble(mueble);
      		destinomueble.setNombreDestino(destino.getNombreDestino());
      		destinomueble.setDireccionDestino(destino.getDireccionDestino());
      	
      		
      		em.merge(destinomueble);

      	}
      
     
      

}
