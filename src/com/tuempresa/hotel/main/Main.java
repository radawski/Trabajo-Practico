package com.tuempresa.hotel.main;
import com.tuempresa.hotel.dao.implementacion.ConserjeFileDAO;
import com.tuempresa.hotel.dao.implementacion.PasajeroFileDAO;
import com.tuempresa.hotel.ui.App;
import com.tuempresa.hotel.ui.Vista;

public class Main {
    public static void main(String[] args) {
        Vista vista = new Vista();
        ConserjeFileDAO conserjeDAO = new ConserjeFileDAO("data/conserjes.txt");
        PasajeroFileDAO pasajeroDAO = new PasajeroFileDAO("data/pasajeros.txt");
        App aplicacion = new App(vista, pasajeroDAO, conserjeDAO);
        aplicacion.start();
    }
}
