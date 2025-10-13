import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class Factura {
    private TipoFactura tipo;
    private double importeTotal;
    private LocalDate fechaDeEmision;

    // Relaciones
    private Moneda moneda;
    private NotaDeCredito notaDeCredito; // opcional
    private List<Pago> pagos = new ArrayList<>();
    private List<ItemFactura> items = new ArrayList<>();
}
