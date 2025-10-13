package com.tuempresa.hotel.modelo.pago;

import java.time.LocalDate;

import com.tuempresa.hotel.modelo.factura.Factura;

@SuppressWarnings("unused")
public class Pago {
    private double montoAcumulado;
    private double vuelto;
    private LocalDate fechaDeRealizacion;

    // Relaciones
    private MedioDePago medioDePago;
    private Factura factura;
}
