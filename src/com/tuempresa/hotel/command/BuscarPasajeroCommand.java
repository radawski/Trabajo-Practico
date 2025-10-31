package com.tuempresa.hotel.command;

import com.tuempresa.hotel.dao.implementacion.PasajeroFileDAO;

public class BuscarPasajeroCommand implements Command {
    private PasajeroFileDAO pasajeroDAO;
    private String datosBusqueda;

    public BuscarPasajeroCommand(PasajeroFileDAO pasajeroDAO, String datosBusqueda) {
        this.pasajeroDAO = pasajeroDAO;
        this.datosBusqueda = datosBusqueda;
    }

    @Override
    public void execute() throws Exception{
        pasajeroDAO.buscarPasajerosPorDatos(datosBusqueda);
        System.out.println("🔍 Ejecutando búsqueda de pasajero...");
    }

}
