package de.fhswf.fit;

import java.io.Serializable;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("editPizzaAction")
@ViewScoped()
public class EditPizzaAction implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
    private PizzaRepository pizzaRepository;
	
	private Long pizzaId;
    private Pizza pizza;
    
    /**
     * Gib Pizza-ID zurück.
     * 
     * @return Long
     */
    public Long getPizzaId() {
        return pizzaId;
    }
    
    /**
     * Setze Pizza-ID.
     * 
     * @param pizzaId
     */
    public void setPizzaId(Long pizzaId) {
        this.pizzaId = pizzaId;
    }
    
    /**
     * Pizza-Getter.
     * 
     * @return Pizza
     */
    public Pizza getPizza() {
        return pizza;
    }
    
    /**
     * Pizza-Setter.
     * 
     * @param pizza
     */
    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }
    
    /**
     * Init.
     */
    public void init() { 
        if (pizzaId == null) {
            pizza = new Pizza();
        } else {
            pizza = pizzaRepository.findById(pizzaId);
        } 
    }
    
    /**
     * Speichere eine Pizzabestellung.
     * 
     * @return String
     */
    public String save() {
        if(this.pizza.getId() == null) {
            this.pizza = pizzaRepository.save(pizza);
        } else {
            this.pizza = pizzaRepository.update(pizza);
        }

        return "/pizza.xhtml?faces-redirect=true";
    }
}
