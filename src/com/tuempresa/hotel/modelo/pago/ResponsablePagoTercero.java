package com.tuempresa.hotel.modelo.pago;

import com.tuempresa.hotel.modelo.factura.Factura;

@SuppressWarnings("unused")
public class ResponsablePagoTercero {
    private String razonSocial;
    private String CUIT;
    private String telefono;

    // Relaciones
    private Factura factura; // 0..1
}
