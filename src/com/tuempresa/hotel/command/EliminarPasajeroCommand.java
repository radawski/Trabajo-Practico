package com.tuempresa.hotel.command;

import com.tuempresa.hotel.dao.implementacion.PasajeroFileDAO;
import com.tuempresa.hotel.modelo.personas.Pasajero;

public class EliminarPasajeroCommand implements Command {
    
    private PasajeroFileDAO pasajeroDAO;
    private Pasajero pasajero;

    public EliminarPasajeroCommand(PasajeroFileDAO pasajeroDAO, Pasajero pasajero) {
        this.pasajeroDAO = pasajeroDAO;
        this.pasajero = pasajero;
    }

    @Override
    public void execute() throws Exception{
        pasajeroDAO.eliminar(pasajero);
        System.out.println("El pasajero " + pasajero.getNombre() + " " + pasajero.getApellido() + " ha sido eliminado.");
    }

}
