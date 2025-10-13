import java.time.LocalDate;

@SuppressWarnings("unused")
public class Pasajero {
    private String nombres;
    private String apellido;
    private String CUIT;
    private String nroDocumento;
    private LocalDate fechaDeNacimiento;
    private String nacionalidad;
    private String email;
    private String telefono;
    private String ocupacion;

    // Relaciones
    private Direccion direccion;
    private TipoDocumento tipoDocumento;
}
