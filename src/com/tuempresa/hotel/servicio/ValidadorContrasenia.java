package com.tuempresa.hotel.servicio;

public class ValidadorContrasenia {

    public static boolean validar(String contrasenia) {
        if (contrasenia == null) {
            return false;
        }

        int letras = 0;
        int numeros = 0;
        char[] chars = contrasenia.toCharArray();

        for (char c : chars) {
            if (Character.isLetter(c)) {
                letras++;
            }
            if (Character.isDigit(c)) {
                numeros++;
            }
        }

        if (letras < 5 || numeros < 3) {
            return false;
        }

        // Números no iguales ni consecutivos
        String soloNumeros = contrasenia.replaceAll("\\D+", "");
        for (int i = 1; i < soloNumeros.length(); i++) {
            int prev = Character.getNumericValue(soloNumeros.charAt(i - 1));
            int actual = Character.getNumericValue(soloNumeros.charAt(i));

            if (actual == prev) {
                return false;
            }
            if (actual == prev + 1 || actual == prev - 1) {
                return false;
            }
        }

        return true;
    }
}
