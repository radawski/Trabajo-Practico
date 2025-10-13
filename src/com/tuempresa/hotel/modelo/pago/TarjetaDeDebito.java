package com.tuempresa.hotel.modelo.pago;

@SuppressWarnings("unused")
public class TarjetaDeDebito extends MedioDePago {
    private TipoTarjeta tipo;
    private String NroTarjeta;
    private Integer cuotas;
    private String fechaVencimiento;
    private Integer CVV;

    // Relaciones
    private Banco banco;
}
