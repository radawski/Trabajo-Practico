package com.tuempresa.hotel.modelo.personas;

import com.tuempresa.hotel.modelo.ubicacion.Ciudad;
import com.tuempresa.hotel.modelo.ubicacion.Pais;
import com.tuempresa.hotel.modelo.ubicacion.Provincia;

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

    public Direccion(String calle2, int nroCalle2, int piso2, int nroDepartamento2, String ciudad2, int codigoPostal2,
            String provincia, String pais) {
        this.calle = calle2;
        this.nroCalle = nroCalle2;
        this.piso = piso2;
        this.nroDepartamento = nroDepartamento2;
        this.ciudad = new Ciudad(ciudad2, new Provincia(provincia, new Pais(pais)));
        this.codigoPostal = codigoPostal2;
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

    public Integer getNroDepartamento() {
        return nroDepartamento;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

}
