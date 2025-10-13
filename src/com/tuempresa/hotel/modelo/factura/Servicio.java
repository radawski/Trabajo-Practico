package com.tuempresa.hotel.modelo.factura;

import java.time.LocalDate;

@SuppressWarnings("unused")
public class Servicio {
    private String IDServicio;
    private LocalDate fechaDeRealizacion;
    private double precioUnitario;
    private Integer cantidad;
    private String descripcion;
    private Integer cantidadPagada;
}
