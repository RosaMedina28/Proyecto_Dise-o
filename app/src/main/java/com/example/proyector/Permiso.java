package com.example.proyector;

public class Permiso {
    private static String nombre;

    public static String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Permiso(String nombre) {
        this.nombre = nombre;
    }
}
