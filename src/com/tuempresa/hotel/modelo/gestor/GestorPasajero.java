package com.tuempresa.hotel.modelo.gestor;

import java.util.List;
import com.tuempresa.hotel.modelo.personas.Pasajero;
import com.tuempresa.hotel.dao.PasajeroDAO;

public class GestorPasajero {
    private PasajeroDAO pasajeroDAO;

    public GestorPasajero(PasajeroDAO pasajeroDAO) {
        this.pasajeroDAO = pasajeroDAO;
    }
    
    public List<Pasajero> buscarPasajerosPorDatos(String datos) {
        return pasajeroDAO.buscarPasajerosPorDatos(datos);
    }
}
