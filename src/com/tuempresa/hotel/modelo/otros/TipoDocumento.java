package com.tuempresa.hotel.modelo.otros;

@SuppressWarnings("unused")
public class TipoDocumento {

    private Integer IDTipoDocumento;
    private final String tipo;

    public TipoDocumento(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

}
