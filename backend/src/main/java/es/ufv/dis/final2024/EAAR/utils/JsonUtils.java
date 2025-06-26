package es.ufv.dis.final2024.EAAR.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import es.ufv.dis.final2024.EAAR.model.Starship;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    private static final String RUTA_JSON = "backend/data/datos.json";
    private static final Gson gson = new Gson();

    // Leer lista de naves desde el JSON
    public static List<Starship> cargarStarships() {
        try (FileReader reader = new FileReader(RUTA_JSON)) {
            Type listType = new TypeToken<List<Starship>>() {}.getType();
            return gson.fromJson(reader, listType);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    // Guardar lista de naves en el JSON (por si luego queremos sobrescribir)
    public static void guardarStarships(List<Starship> starships) {
        try (FileWriter writer = new FileWriter(RUTA_JSON)) {
            gson.toJson(starships, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}