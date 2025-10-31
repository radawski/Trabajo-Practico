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

    public String toTxtLine() {
        return String.join(";", new String[] {
                apellido, nombres, tipoDocumento.getTipo(), nroDocumento, CUIT,
                razonSocial, fechaDeNacimiento != null ? fechaDeNacimiento.toString() : "",
                direccion.getCalle(), String.valueOf(direccion.getNroCalle()),
                direccion.getNroDepartamento() != null ? direccion.getNroDepartamento().toString() : "",
                direccion.getPiso() != null ? direccion.getPiso().toString() : "",
                String.valueOf(direccion.getCodigoPostal()),
                direccion.getCiudad().getNombre(), direccion.getCiudad().getProvincia().getNombre(),
                direccion.getCiudad().getProvincia().getPais().getNombre(), telefono, email,
                ocupacion, nacionalidad
        });
    }



    public void setNombre(String nuevoNombre) {
        this.nombres = nuevoNombre;
    }



    public void setApellido(String nuevoApellido) {
        this.apellido = nuevoApellido;
    }



    public void setTipoDocumento(String nuevoTipoDocumento) {
        this.tipoDocumento.setTipo(nuevoTipoDocumento);
    }



    public void setFechaNacimiento(LocalDate nuevaFechaNacimiento) {
        this.fechaDeNacimiento = nuevaFechaNacimiento;
    }



    public void setDireccion(Direccion nuevaDireccion) {
        this.direccion = nuevaDireccion;
    }



    public void setTelefono(String nuevoTelefono) {
        this.telefono = nuevoTelefono;
    }



    public void setOcupacion(String nuevaOcupacion) {
        this.ocupacion = nuevaOcupacion;
    }



    public void setEmail(String nuevoEmail) {
        this.email = nuevoEmail;
    }



    public void setCuit(String nuevoCUIT) {
        this.CUIT = nuevoCUIT;
    }



    public void setNacionalidad(String nuevaNacionalidad) {
        this.nacionalidad = nuevaNacionalidad;
    }



    public void setRazonSocial(String nuevaRazonSocial) {
        this.razonSocial = nuevaRazonSocial;
    }

    
}
