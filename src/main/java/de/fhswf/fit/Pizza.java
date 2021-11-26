package de.fhswf.fit;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pizza implements Serializable {

private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name")
	private String name;
	
	@Column(name = "groesse")
    private String groesse;
	
	@Column(name = "besteller")
    private String besteller;
	
	@Column(name = "adresse")
    private String adresse;
	
	@Column(name = "anmerkungen")
    private String anmerkungen;


    /**
     * Konstruktor.
     *
     */
    public Pizza() {}

    
    /**
     * Gibt die ID einer Pizza zurück.
     * 
     * @return Long
     */
    public Long getId()
    {
    	return id;
    }
	
	/**
     * Gibt den Namen der Pizza zurück.
     * 
     * @return String
     */
    public String getName() {
        return name;
    }
    
    /**
     * Setzt den Namen einer Pizza.
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gibt die Größe der Pizza zurück.
     * 
     * @return String
     */
    public String getGroesse() {
        return groesse;
    }
    
    /**
     * Setzt die Göße einer Pizza.
     * 
     * @param groesse
     */
    public void setGroesse(String groesse) {
        this.groesse = groesse;
    }

    /**
     * Gibt den Besteller der Pizza zurück.
     * 
     * @return String
     */
    public String getBesteller() {
        return besteller;
    }
    
    /**
     * Setzt den Besteller einer Pizza.
     * 
     * @param besteller
     */
    public void setBesteller(String besteller) {
        this.besteller = besteller;
    }

    /**
     * Gibt die Lieferadresse der Pizza zurück.
     * 
     * @return String
     */
    public String getAdresse() {
        return adresse;
    }
    
    /**
     * Setzt die Lieferadresse einer Pizza.
     * 
     * @param adresse
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * Gibt die Anmerkungen der Pizza zurück.
     * 
     * @return String
     */
    public String getAnmerkungen() { 
        return anmerkungen;
    }
    
    /**
     * Setzt die Anmerkungen einer Pizzabestellung.
     * 
     * @param anmerkungen
     */
    public void setAnmerkungen(String anmerkungen) {
        this.anmerkungen = anmerkungen;
    }
}