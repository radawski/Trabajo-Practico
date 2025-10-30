package com.tuempresa.hotel.strategy;

import com.tuempresa.hotel.modelo.personas.Pasajero;

public interface ValidacionStrategy {

    boolean validarPasajero(Pasajero pasajero);

}
