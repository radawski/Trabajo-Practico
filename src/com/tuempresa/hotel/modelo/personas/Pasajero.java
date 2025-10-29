package com.tuempresa.hotel.modelo.personas;

import java.time.LocalDate;

import com.tuempresa.hotel.modelo.otros.TipoDocumento;

@SuppressWarnings("unused")
public class Pasajero {
    private String nombres;
    private String apellido;
    private String CUIT;
    private String nroDocumento;
    private LocalDate fechaDeNacimiento;
    private String nacionalidad;
    private String email;
    private String telefono;
    private String ocupacion;
    private String razonSocial;

    // Relaciones
    private Direccion direccion;
    private TipoDocumento tipoDocumento;

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
