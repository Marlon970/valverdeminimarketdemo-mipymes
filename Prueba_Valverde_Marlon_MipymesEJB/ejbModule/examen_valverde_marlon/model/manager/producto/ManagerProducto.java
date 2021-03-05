package examen_valverde_marlon.model.manager.producto;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import examen_valverde.model.component.entities.InvProducto;




/**
 * Session Bean implementation class ManagerProducto
 */
@Stateless
@LocalBean
public class ManagerProducto {
	
	@PersistenceContext
	private EntityManager em;

    /**
     * Default constructor. 
     */
    public ManagerProducto() {
        // TODO Auto-generated constructor stub
    }
    
    public List<InvProducto> findAllMueble() {
		return em.createNamedQuery("InvProducto.findAll", InvProducto.class).getResultList();
	}
    
public void crearProducto(String nombreproducto, String precioprodcutoString )  throws Exception{
		
		InvProducto e = new InvProducto();
		
		e.setNombreProducto(nombreproducto);
		e.setPrecioProducto(precioprodcutoString);
		
	

		em.persist(e);
	}
    

}
