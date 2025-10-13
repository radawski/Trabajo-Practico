package com.tuempresa.hotel.modelo.personas;

@SuppressWarnings("unused")

public class Conserje {

    private final String nombre;
    private final String apellido;
    private final String usuario;
    private final String contrasenia;

    public Conserje(String nombre, String apellido, String usuario, String contrasenia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " (" + usuario + ")";
    }
}
