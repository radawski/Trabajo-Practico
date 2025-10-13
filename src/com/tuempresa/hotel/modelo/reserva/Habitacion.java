package com.tuempresa.hotel.modelo.reserva;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class Habitacion {
    private String numero;
    private EstadoHabitacion estado;
    private String IDHabitacion;

    // Relaciones
    private TipoHabitacion tipoHabitacion;
    private List<CostoPorNoche> costos = new ArrayList<>();
    private Ocupacion ocupacion; // 0..1
}
