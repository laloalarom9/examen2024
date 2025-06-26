package org.vaadin.example.model;

import java.util.List;

public class Starship {
    private String name;
    private String model;
    private String cost_in_credits;
    private String crew;
    private String cargo_capacity;
    private String consumables;
    private String hyperdrive_rating;
    private String starship_class;
    private List<String> pilots;
    private List<String> films;

    public Starship() {}

    // Getters y Setters (solo los más importantes si quieres ahorrar)
    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public String getCrew() {
        return crew;
    }

    public String getStarship_class() {
        return starship_class;
    }

    public List<String> getFilms() {
        return films;
    }
}
