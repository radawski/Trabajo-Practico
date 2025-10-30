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

    public Direccion(Integer codigoPostal, String calle, Integer nroCalle, Integer piso, Integer nroDepartamento, Ciudad ciudad) {
        this.codigoPostal = codigoPostal;
        this.calle = calle;
        this.nroCalle = nroCalle;
        this.piso = piso;
        this.nroDepartamento = nroDepartamento;
        this.ciudad = ciudad;
    }

    public Integer getCodigoPostal() {
        return codigoPostal;
    }

    public String getCalle() {
        return calle;
    }

    public Integer getNroCalle() {
        return nroCalle;
    }

    public Integer getPiso() {
        return piso;
    }

    public Integer getnroDepartamento() {
        return nroDepartamento;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

}
