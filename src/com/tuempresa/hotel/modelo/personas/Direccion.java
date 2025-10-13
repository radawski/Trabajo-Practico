package com.tuempresa.hotel.modelo.personas;

import com.tuempresa.hotel.modelo.ubicacion.Ciudad;

@SuppressWarnings("unused")
public class Direccion {
    private Integer codigoPostal;
    private String calle;
    private Integer nroCalle;
    private Integer piso;
    private Integer nroDepartamento;

    // Relaciones
    private Ciudad ciudad;
}
