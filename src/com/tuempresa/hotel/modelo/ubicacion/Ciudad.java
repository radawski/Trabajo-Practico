package com.tuempresa.hotel.modelo.ubicacion;

import java.util.ArrayList;
import java.util.List;

import com.tuempresa.hotel.modelo.personas.Direccion;

@SuppressWarnings("unused")
public class Ciudad {
    public String nombre;
    public String IDCiudad;

    // Relaciones
    public Provincia provincia;
    public List<Direccion> direcciones = new ArrayList<>();

    public Ciudad(String nombre, Provincia provincia) {
        this.nombre = nombre;
        this.provincia = provincia;
    }

    public String getNombre() {
        return nombre;
    }

    public Provincia getProvincia() {
        return provincia;
    }

}


