package com.tuempresa.hotel.modelo.personas;

import java.time.LocalDate;

import com.tuempresa.hotel.modelo.otros.TipoDocumento;

@SuppressWarnings("unused")
public class Pasajero {

    private final String nombres;
    private final String apellido;
    private final String CUIT;
    private final String nroDocumento;
    private final LocalDate fechaDeNacimiento;
    private final String nacionalidad;
    private final String email;
    private final String telefono;
    private final String ocupacion;
    private final String razonSocial;

    // Relaciones
    private final Direccion direccion;
    private final TipoDocumento tipoDocumento;

    public Pasajero(String nombres, String apellido, String CUIT, String nroDocumento,
            LocalDate fechaDeNacimiento, String nacionalidad, String email,
            String telefono, String ocupacion, Direccion direccion, TipoDocumento tipoDocumento, String razonSocial) {
        this.nombres = nombres;
        this.apellido = apellido;
        this.CUIT = CUIT;
        this.nroDocumento = nroDocumento;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.nacionalidad = nacionalidad;
        this.email = email;
        this.telefono = telefono;
        this.ocupacion = ocupacion;
        this.direccion = direccion;
        this.tipoDocumento = tipoDocumento;
        this.razonSocial = razonSocial;
    }

    public String getNombre() {
        return nombres;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCUIT() {
        return CUIT;
    }

    public String getNroDocumento() {
        return nroDocumento;
    }

    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public String obtenerDatosCompletos() {
        return (apellido + " " + nombres + " " + tipoDocumento.getTipo() + " " + nroDocumento).toLowerCase();
    }

}
