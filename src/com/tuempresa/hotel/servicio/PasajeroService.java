package com.tuempresa.hotel.servicio;

import com.tuempresa.hotel.dao.implementacion.PasajeroFileDAO;
import com.tuempresa.hotel.modelo.personas.Pasajero;
import com.tuempresa.hotel.strategy.ValidacionStrategy;

public class PasajeroService {

    private final PasajeroFileDAO pasajeroDAO;
    private ValidacionStrategy validacionStrategy;

    public PasajeroService(PasajeroFileDAO pasajeroDAO, ValidacionStrategy validacionStrategy) {
        this.pasajeroDAO = pasajeroDAO;
        this.validacionStrategy = validacionStrategy;
    }

    public boolean registrarPasajero(Pasajero pasajero, boolean aceptarDuplicado) {
        if (!validacionStrategy.validarPasajero(pasajero)) {
            System.out.println("Error: faltan datos obligatorios.");
            return false;
        }

        Pasajero existente = pasajeroDAO.buscarPorDocumento(
                pasajero.getTipoDocumento(),
                pasajero.getNroDocumento()
        );

        if (existente != null && !aceptarDuplicado) {
            System.out.println("⚠️ ¡CUIDADO! El tipo y número de documento ya existen.");
            return false;
        }

        pasajeroDAO.guardar(pasajero);
        
        System.out.println("✅ El pasajero " + pasajero.getNombre() + " " + pasajero.getApellido() + " ha sido cargado.");
        return true;
    }

    public void setValidacionStrategy(ValidacionStrategy nuevaEstrategia) {
        this.validacionStrategy = nuevaEstrategia;
    }

}
