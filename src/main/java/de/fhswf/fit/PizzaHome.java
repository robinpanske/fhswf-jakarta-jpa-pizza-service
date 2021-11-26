package de.fhswf.fit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("pizzaHome")
@ViewScoped()
public class PizzaHome implements Serializable {
	
    @Inject
    private PizzaRepository pizzaRepository;
    
    private List<Pizza> pizzas = new ArrayList<>();
    
    
    /**
     * Gebe alle Pizzabestellungen zurück.
     * 
     * @return List<Pizza>
     */
    public List<Pizza> getPizzas() {
    	return pizzas;
    }
    
    /**
     * Init.
     */
    public void init() {
    	retrieveAllPizzas();
    }
    
    /**
     * Hole alle Pizzabestellungen aus der Datenbank.
     */
    private void retrieveAllPizzas() {
        this.pizzas = pizzaRepository.getAll();
    }
    
    /**
     * Lösche eine Pizzabestellung.
     * 
     * @param id
     */
    public void deletePizza(Long id) {        
        pizzaRepository.deleteById(id);
        retrieveAllPizzas();
    }
}