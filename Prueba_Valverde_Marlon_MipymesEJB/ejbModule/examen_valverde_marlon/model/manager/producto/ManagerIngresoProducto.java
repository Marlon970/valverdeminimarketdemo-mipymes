package examen_valverde_marlon.model.manager.producto;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import examen_valverde.model.component.entities.DestinoMueble;
import examen_valverde.model.component.entities.InvIngresoProducto;
import examen_valverde.model.component.entities.InvProducto;
import examen_valverde.model.component.entities.ValverdemMueble;

/**
 * Session Bean implementation class ManagerIngresoProducto
 */
@Stateless
@LocalBean
public class ManagerIngresoProducto {
	
	@PersistenceContext
	private EntityManager em;
	
	

    /**
     * Default constructor. 
     */
    public ManagerIngresoProducto() {
        // TODO Auto-generated constructor stub
    }
    
    
    public List<InvIngresoProducto> findAllIngresoProducto(){
    	return em.createNamedQuery("InvIngresoProducto.findAll", InvIngresoProducto.class).getResultList();
    }
    
    
    public void crearIngresoProducto(  int idProducto, int cantidad) throws Exception{
    	
    	InvIngresoProducto d= new InvIngresoProducto();
    	
    	InvProducto pro =  em.find(InvProducto.class, idProducto);
    	
    	
    	d.setInvProducto(pro);
    	d.setIngresoProductoCantidad(cantidad);
   
    	
    	em.persist(d);
    	
    }
    


}
