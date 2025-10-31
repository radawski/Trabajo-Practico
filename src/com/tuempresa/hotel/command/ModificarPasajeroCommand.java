package com.tuempresa.hotel.command;

import com.tuempresa.hotel.dao.implementacion.PasajeroFileDAO;
import com.tuempresa.hotel.modelo.personas.Pasajero;

public class ModificarPasajeroCommand implements Command {
    private PasajeroFileDAO pasajeroDAO;
    private Pasajero pasajero;

    public ModificarPasajeroCommand(PasajeroFileDAO pasajeroDAO, Pasajero pasajero) {
        this.pasajeroDAO = pasajeroDAO;
        this.pasajero = pasajero;
    }
    
    @Override
    public void execute() throws Exception{
        pasajeroDAO.modificar(pasajero);
        System.out.println("✅ El pasajero " + pasajero.getNombre() + " " + pasajero.getApellido() + " ha sido modificado.");
    }

}
