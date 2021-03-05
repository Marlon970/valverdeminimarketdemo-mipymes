package mueblespruebavalverde.model.manager;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import examen_valverde.model.component.entities.ValverdemMueble;


/**
 * Session Bean implementation class ManagerMueble
 */
@Stateless
@LocalBean
public class ManagerMueble {
	
	@PersistenceContext
	private EntityManager em;

    /**
     * Default constructor. 
     */
    public ManagerMueble() {
        // TODO Auto-generated constructor stub
    }
    
    public List<ValverdemMueble> findAllMueble() {
		return em.createNamedQuery("ValverdemMueble.findAll", ValverdemMueble.class).getResultList();
	}
    
	public void crearMueble(String nombre, String material, String precio, String stock)  throws Exception{
		
		ValverdemMueble e = new ValverdemMueble();
		
		
		e.setNombreMueble(nombre);
		e.setMaterialMueble(material);
		e.setPrecioMaterial(precio);
		e.setStockMueble(stock);
	

		em.persist(e);
	}

	public void eliminarMueble(int idMueble) throws Exception {

		/* buscar objeto que corresponde al identificador proporcionado */
		ValverdemMueble u = em.find(ValverdemMueble.class, idMueble);
		if (u == null)
			throw new Exception("No existe el usuario indicado ("+idMueble+")");

		em.remove(u);

	}

	public void actualizarMueble(ValverdemMueble mueble) throws Exception {

		// busca el objeto Original
		ValverdemMueble e = em.find(ValverdemMueble.class, mueble.getIdMueble());
		if (e == null)
			throw new Exception("No existe el usuario Indicado(" + mueble.getIdMueble() + ")");
		
		
		// no se utiliza ni el Id ni la clave
		
		e.setNombreMueble(mueble.getNombreMueble());
		e.setMaterialMueble(mueble.getMaterialMueble());
		e.setPrecioMaterial(mueble.getPrecioMaterial());
		e.setStockMueble(mueble.getStockMueble());
	
		em.merge(e);

	}

    
    

}
