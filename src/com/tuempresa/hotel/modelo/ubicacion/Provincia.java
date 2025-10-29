package com.tuempresa.hotel.modelo.ubicacion;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class Provincia {
    public String nombre;
    public String IDProvincia;

    // Relaciones
    public Pais pais;
    public List<Ciudad> ciudades = new ArrayList<>();

    public Provincia(String nombre, Pais pais) {
        this.nombre = nombre;
        this.pais = pais;
    }

}

