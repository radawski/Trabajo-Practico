import java.time.LocalDate;

@SuppressWarnings("unused")
public class Pago {
    private double montoAcumulado;
    private double vuelto;
    private LocalDate fechaDeRealizacion;

    // Relaciones
    private MedioDePago medioDePago;
    private Factura factura;
}
