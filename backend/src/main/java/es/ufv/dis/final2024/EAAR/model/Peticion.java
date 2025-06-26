package es.ufv.dis.final2024.EAAR.model;

public class Peticion {

    private String nombre;
    private int veces;

    public Peticion() {
    }

    public Peticion(String nombre, int veces) {
        this.nombre = nombre;
        this.veces = veces;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVeces() {
        return veces;
    }

    public void setVeces(int veces) {
        this.veces = veces;
    }
}
