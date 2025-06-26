package es.ufv.dis.final2024.EAAR.utils;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.File;

public class PdfManager {

    private static final String RUTA_CARPETA = "naves/";

    public static boolean generarPdf(String nombre, String modelo, String clase, String tripulacion, int numPeliculas) {
        try {
            // Crear carpeta si no existe
            File carpeta = new File(RUTA_CARPETA);
            if (!carpeta.exists()) carpeta.mkdirs();

            String archivo = RUTA_CARPETA + nombre.replace(" ", "_") + ".pdf";

            try (PDDocument document = new PDDocument()) {
                PDPage page = new PDPage();
                document.addPage(page);

                try (PDPageContentStream content = new PDPageContentStream(document, page)) {
                    content.beginText();
                    content.setFont(PDType1Font.HELVETICA, 14);
                    content.setLeading(20f);
                    content.newLineAtOffset(50, 700);

                    content.showText("Nombre: " + nombre); content.newLine();
                    content.showText("Modelo: " + modelo); content.newLine();
                    content.showText("Clase: " + clase); content.newLine();
                    content.showText("Tripulacion: " + tripulacion); content.newLine();
                    content.showText("Peliculas: " + numPeliculas);

                    content.endText();
                }

                document.save(archivo);
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
