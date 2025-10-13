package com.tuempresa.hotel.modelo.pago;

@SuppressWarnings("unused")
public class TarjetaDeCredito extends MedioDePago {
    private String NroTarjeta;
    private Integer CVV;
    private String fechaVencimiento;
    private Integer cuotas;

    // Relaciones
    private Banco banco;
}
