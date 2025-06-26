package es.ufv.dis.final2024.EAAR.controller;

import es.ufv.dis.final2024.EAAR.model.Starship;
import es.ufv.dis.final2024.EAAR.service.StarshipService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/starships")
public class StarshipController {

    private final StarshipService starshipService;

    public StarshipController() {
        this.starshipService = new StarshipService();
    }

    // GET: Listar todas las naves
    @GetMapping
    public List<Starship> getAllStarships() {
        return starshipService.getAllStarships();
    }

    // POST: Recibe {"ship": "Millennium Falcon"}, genera el PDF
    @PostMapping
    public Map<String, String> generarPdf(@RequestBody Map<String, String> request) {
        String nombre = request.get("ship");
        boolean exito = starshipService.generarPdfDeNave(nombre);

        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("resultado", exito ? "PDF generado" : "Nave no encontrada");
        return respuesta;
    }
}
