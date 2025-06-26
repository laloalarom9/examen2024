package org.vaadin.example.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.vaadin.example.model.Starship;
import org.vaadin.example.service.StarshipService;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Route("")
public class MainView extends VerticalLayout {

    public MainView() {
        setSizeFull();
        setPadding(true);
        setSpacing(true);

        Grid<Starship> grid = new Grid<>(Starship.class, false);
        grid.setSizeFull();

        // Columnas visibles
        grid.addColumn(Starship::getName).setHeader("Nombre");
        grid.addColumn(Starship::getModel).setHeader("Modelo");
        grid.addColumn(Starship::getStarship_class).setHeader("Clase");
        grid.addColumn(Starship::getCrew).setHeader("Tripulación");
        grid.addColumn(s -> s.getFilms() != null ? s.getFilms().size() : 0).setHeader("Películas");

        // Columna con botón
        grid.addComponentColumn(starship -> {
            Anchor link = new Anchor(
                    "http://localhost:8080/api/starships/pdf?ship=" +
                            URLEncoder.encode(starship.getName(), StandardCharsets.UTF_8),
                    "Generar PDF"
            );
            link.setTarget("_blank");
            return link;
        }).setHeader("Acciones"); // <- También faltaba cerrar la columna con setHeader()


        grid.addThemeVariants(GridVariant.LUMO_ROW_STRIPES);
        add(grid);

        // Cargar datos desde el backend
        List<Starship> starships = StarshipService.getStarships();
        grid.setItems(starships);
    }
}
