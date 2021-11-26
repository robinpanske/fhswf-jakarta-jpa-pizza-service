package de.fhswf.fit;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Startup
@Singleton
public class Bootstrap {
	
    @Inject
    PizzaRepository pizzaRepository;
    
    // Kommentar entfernen für Testing.
    // @PostConstruct
    public void init() {
        Stream.of("Pizza 1", "Pizza 2")
            .map(s -> {
                Pizza pizza = new Pizza();
                pizza.setName(s);
                pizza.setGroesse("Gross");
                pizza.setBesteller("Max Mustermann");
                pizza.setAdresse("Musterstrasse 123, 12345 Musterstadt");
                pizza.setAnmerkungen("Testpizza");
                
                return pizza;
            })
            .map(data -> pizzaRepository.save(data))
            .collect(Collectors.toList());
    }
}