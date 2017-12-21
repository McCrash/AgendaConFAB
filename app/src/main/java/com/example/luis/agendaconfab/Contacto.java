package com.example.luis.agendaconfab;

/**
 * Created by luis on 20/12/2017.
 */

public class Contacto {
    private String nombre, telefono;
    private int id;

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public int getId() {
        return id;
    }

    public Contacto(String nombre, String telefono, int id) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.id = id;
    }
}
