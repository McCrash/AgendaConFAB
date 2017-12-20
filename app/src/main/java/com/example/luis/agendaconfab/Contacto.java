package com.example.luis.agendaconfab;

/**
 * Created by luis on 20/12/2017.
 */

public class Contacto {
    private String nombre, telefono;

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public Contacto(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }
}
