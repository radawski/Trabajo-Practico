package com.tuempresa.hotel.modelo.pago;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class Banco {
    private String nombre;
    private String IDTipoTarjeta;

    // Relaciones
    private List<TarjetaDeCredito> tarjetasCredito = new ArrayList<>();
    private List<TarjetaDeDebito> tarjetasDebito = new ArrayList<>();
}
