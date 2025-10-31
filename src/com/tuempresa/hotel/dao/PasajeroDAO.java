package com.tuempresa.hotel.dao;
import com.tuempresa.hotel.modelo.otros.TipoDocumento;
import com.tuempresa.hotel.modelo.personas.Pasajero;
import java.util.List;

public interface PasajeroDAO {
    // Método para obtener todos los pasajeros
    List<Pasajero> obtenerTodos();

    // Método para buscar pasajeros por datos específicos (nombre, apellido, documento, etc.)
    List<Pasajero> buscarPasajerosPorDatos(String datosBusqueda);

    // Método para guardar un nuevo pasajero
    void guardar(Pasajero pasajero);

    // Método para modificar un pasajero existente
    void modificar(Pasajero pasajero);

    // Método para eliminar un pasajero
    void eliminar(Pasajero pasajero);

    // Método para buscar un pasajero por tipo y número de documento
    Pasajero buscarPorDocumento(TipoDocumento tipoDoc, String numeroDoc);

}
