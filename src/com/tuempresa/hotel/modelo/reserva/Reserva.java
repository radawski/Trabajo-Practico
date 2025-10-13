package com.tuempresa.hotel.modelo.reserva;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.tuempresa.hotel.modelo.personas.Acompaniante;
import com.tuempresa.hotel.modelo.personas.Conserje;
import com.tuempresa.hotel.modelo.personas.Pasajero;
import com.tuempresa.hotel.modelo.personas.ResponsableReserva;

@SuppressWarnings("unused")
public class Reserva {
    private LocalDate fechaIngreso;
    private LocalDate fechaEgreso;

    // Relaciones
    private Habitacion habitacion; // 1
    private List<Pasajero> pasajeros = new ArrayList<>(); // *
    private List<Acompaniante> acompanantes = new ArrayList<>(); // *
    private ResponsableReserva responsableReserva; // 1
    private Conserje conserje; // 1..* conserje -- * reserva
}
