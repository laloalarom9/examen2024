package es.ufv.dis.final2024.EAAR.controller;

import es.ufv.dis.final2024.EAAR.model.Starship;
import es.ufv.dis.final2024.EAAR.service.StarshipService;
import es.ufv.dis.final2024.EAAR.utils.PdfManager;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    @GetMapping("/pdf")
    public ResponseEntity<byte[]> descargarPdf(@RequestParam String ship) {
        Starship nave = starshipService.buscarPorNombre(ship);
        if (nave == null) {
            return ResponseEntity.notFound().build();
        }

        byte[] pdfBytes = PdfManager.generarPdfComoBytes(
                nave.getName(),
                nave.getModel(),
                nave.getStarship_class(),
                nave.getCrew(),
                nave.getFilms() != null ? nave.getFilms().size() : 0
        );

        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=\"" + ship.replace(" ", "_") + ".pdf\"")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfBytes);
    }

}
