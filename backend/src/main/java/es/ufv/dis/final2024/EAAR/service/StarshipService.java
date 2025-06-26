package es.ufv.dis.final2024.EAAR.service;


import es.ufv.dis.final2024.EAAR.model.Starship;
import es.ufv.dis.final2024.EAAR.utils.JsonUtils;
import es.ufv.dis.final2024.EAAR.utils.PdfManager;

import java.util.List;
import java.util.Optional;

public class StarshipService {

    private final List<Starship> starships;

    public StarshipService() {
        this.starships = JsonUtils.cargarStarships();
    }

    public List<Starship> getAllStarships() {
        return starships;
    }

    public Starship buscarPorNombre(String nombre) {
        Optional<Starship> resultado = starships.stream()
                .filter(s -> s.getName().equalsIgnoreCase(nombre))
                .findFirst();
        return resultado.orElse(null);
    }

    public boolean generarPdfDeNave(String nombre) {
        Starship nave = buscarPorNombre(nombre);
        if (nave == null) return false;

        int totalPeliculas = nave.getFilms() != null ? nave.getFilms().size() : 0;

        return PdfManager.generarPdf(nave.getName(), nave.getModel(),
                nave.getStarship_class(), nave.getCrew(), totalPeliculas);
    }
}