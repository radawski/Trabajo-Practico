package com.tuempresa.hotel.modelo.factura;

@SuppressWarnings("unused")
public class ItemFactura {
    private Integer cantidad;
    private String IDItemFactura;

    // Relaciones
    private Servicio servicio;
    private Factura factura;
}
