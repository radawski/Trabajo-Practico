package com.tuempresa.hotel.strategy.implementacion;

import com.tuempresa.hotel.modelo.personas.Pasajero;
import com.tuempresa.hotel.strategy.ValidacionStrategy;

public class ValidacionEstandar implements ValidacionStrategy {

    @Override
    // Chequea que todos los campos obligatorios del pasajero estén completos
    public boolean validarPasajero(Pasajero pasajero) {
        return pasajero.getApellido() != null && !pasajero.getApellido().isBlank()
                && pasajero.getNombre() != null && !pasajero.getNombre().isBlank()
                && pasajero.getTipoDocumento() != null && !pasajero.getTipoDocumento().getTipo().isBlank()
                && pasajero.getNroDocumento() != null && !pasajero.getNroDocumento().isBlank()
                && pasajero.getFechaDeNacimiento() != null
                && pasajero.getNacionalidad() != null && !pasajero.getNacionalidad().isBlank()
                && pasajero.getTelefono() != null && !pasajero.getTelefono().isBlank()
                && pasajero.getOcupacion() != null && !pasajero.getOcupacion().isBlank()
                && pasajero.getDireccion() != null;
    }

}
