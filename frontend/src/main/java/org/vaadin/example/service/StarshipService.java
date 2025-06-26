package org.vaadin.example.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.vaadin.example.model.Starship;

import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collections;
import java.util.List;

public class StarshipService {

    private static final String BASE_URL = "http://localhost:8080/api/starships";
    private static final Gson gson = new Gson();
    private static final HttpClient client = HttpClient.newHttpClient();

    // GET: Obtener todas las naves
    public static List<Starship> getStarships() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(BASE_URL))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            Type listType = new TypeToken<List<Starship>>() {}.getType();
            return gson.fromJson(response.body(), listType);
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    // POST: Generar PDF de una nave
    public static String generarPdf(String nombreNave) {
        try {
            String jsonBody = gson.toJson(new ShipRequest(nombreNave));

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(BASE_URL))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error al generar PDF";
        }
    }

    // Clase auxiliar para el body del POST
    private static class ShipRequest {
        private final String ship;

        public ShipRequest(String ship) {
            this.ship = ship;
        }
    }
}
