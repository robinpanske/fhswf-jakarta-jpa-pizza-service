package de.fhswf.fit;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

@Stateless
public class PizzaRepository {

	@PersistenceContext
	EntityManager em;
	
	/**
	 * Finde eine Pizza mit ID.
	 * 
	 * @param Long id
	 * @return Pizza
	 */
	public Pizza findById(Long id) {
        Pizza pizza = em.find(Pizza.class, id);
        if (pizza == null) {
            // throw new PizzaNotFoundException(id);
        }
        return pizza;
    }
    
    /**
     * Gibt alle Pizzen zurück.
     * 
     * @param
     * @return List<Pizza>
     */
    public List<Pizza> getAll() {
        CriteriaBuilder cb = this.em.getCriteriaBuilder();
        CriteriaQuery<Pizza> q = cb.createQuery(Pizza.class);
        TypedQuery<Pizza> query = em.createQuery(q);
        
        return query.getResultList();
    }
    
    /**
	 * Speichere eine Pizza.
	 * 
	 * @param Pizza pizza
	 * @return Pizza
	 */
    public Pizza save(Pizza pizza) {
        em.persist(pizza);
        return pizza;
    }
    
    /**
   	 * Update eine Pizza.
   	 * 
   	 * @param Pizza pizza
   	 * @return Pizza
   	 */
    public Pizza update(Pizza pizza) {
        return em.merge(pizza);
    }
    
    /**
   	 * Lösche eine Pizza.
   	 * 
   	 * @param Pizza pizza
   	 * @return Pizza
   	 */
    public void delete(Pizza pizza) {
        pizza = em.merge(pizza);
        em.remove(pizza);
    }
    
    /**
   	 * Lösche eine Pizza mit ID.
   	 * 
   	 * @param Long id
   	 * @return Pizza
   	 */
    public void deleteById(Long id) {
    	Pizza pizza = this.findById(id);
        em.remove(pizza);
    }
}
