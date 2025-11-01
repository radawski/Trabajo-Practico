package com.tuempresa.hotel.servicio;

public class ValidadorContrasenia {

    public static boolean validar(String contrasenia) {
        if (contrasenia == null) return false;
        return contrasenia.length() >= 4;
    }
}