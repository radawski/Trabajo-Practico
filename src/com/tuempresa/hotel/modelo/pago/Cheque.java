package com.tuempresa.hotel.modelo.pago;

import java.time.LocalDate;

@SuppressWarnings("unused")
public class Cheque extends MedioDePago {
    private String nroCheque;
    private String plaza;
    private LocalDate fechaCobro;
    private EstadoCheque estado;
}
