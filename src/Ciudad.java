import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class Ciudad {
    public String nombre;
    public String IDCiudad;

    // Relaciones
    public Provincia provincia;
    public List<Direccion> direcciones = new ArrayList<>();
}
