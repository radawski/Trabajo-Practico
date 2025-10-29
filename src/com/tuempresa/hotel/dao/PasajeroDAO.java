package com.tuempresa.hotel.dao;

import com.tuempresa.hotel.modelo.personas.Direccion;
import com.tuempresa.hotel.modelo.personas.Pasajero;
import com.tuempresa.hotel.modelo.ubicacion.Ciudad;
import com.tuempresa.hotel.modelo.ubicacion.Pais;
import com.tuempresa.hotel.modelo.ubicacion.Provincia;
import com.tuempresa.hotel.modelo.otros.TipoDocumento;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * DAO simple que carga pasajeros desde un archivo de texto (data/pasajeros.txt)
 * Cada línea debe contener 19 campos separados por ';':
 * apellido;nombres;tipoDocumento;nroDocumento;CUIT;razonSocial;fechaDeNacimiento;calle;nroCalle;nroDepartamento;piso;codigoPostal;nombreCiudad;nombreProvincia;nombrePais;telefono;email;ocupacion;nacionalidad
*/
public class PasajeroDAO {

    private final String rutaArchivo;

    public PasajeroDAO(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public List<Pasajero> obtenerTodos() {
        List<Pasajero> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;
                String[] partes = linea.split(";");
                if (partes.length < 19) {
                    System.err.println("Línea de pasajero con formato inválido (se esperaban 19 campos): " + linea);
                    continue;
                }

                try {
                    // Mapeo según el formato:
                    // 0: apellido
                    // 1: nombres
                    // 2: tipoDocumento
                    // 3: nroDocumento
                    // 4: CUIT
                    // 5: razonSocial
                    // 6: fechaDeNacimiento
                    // 7: calle
                    // 8: nroCalle
                    // 9: nroDepartamento
                    // 10: piso
                    // 11: codigoPostal
                    // 12: nombreCiudad
                    // 13: nombreProvincia
                    // 14: nombrePais
                    // 15: telefono
                    // 16: email
                    // 17: ocupacion
                    // 18: nacionalidad

                    String apellido = textOrNull(partes[0]);
                    String nombres = textOrNull(partes[1]);
                    String tipoDocTexto = textOrNull(partes[2]);
                    String nroDocumento = textOrNull(partes[3]);
                    String cuit = textOrNull(partes[4]);

                    String razonSocial = textOrNull(partes[5]);
                    if (razonSocial == null) razonSocial = "consumidor final";

                    String fechaNacimientoStr = textOrNull(partes[6]);
                    LocalDate fechaNacimiento = null;
                    if (fechaNacimientoStr != null) {
                        try {
                            fechaNacimiento = LocalDate.parse(fechaNacimientoStr);
                        } catch (Exception ex) {
                            System.err.println("Formato de fecha inválido para pasajero: " + fechaNacimientoStr + " -> " + ex.getMessage());
                            fechaNacimiento = null;
                        }
                    }

                    String calle = textOrNull(partes[7]);
                    Integer nroCalle = intOrNull(partes[8]);
                    Integer nroDepartamento = intOrNull(partes[9]);
                    Integer piso = intOrNull(partes[10]);
                    Integer codigoPostal = intOrNull(partes[11]);
                    String nombreCiudad = textOrNull(partes[12]);
                    String nombreProvincia = textOrNull(partes[13]);
                    String nombrePais = textOrNull(partes[14]);

                    String telefono = textOrNull(partes[15]);
                    String email = textOrNull(partes[16]);
                    String ocupacion = textOrNull(partes[17]);
                    String nacionalidad = textOrNull(partes[18]);
                    
                    Pais pais = new Pais(nombrePais);
                    Provincia provincia = new Provincia(nombreProvincia, pais);
                    Ciudad ciudad = new Ciudad(nombreCiudad, provincia);

                    Direccion direccion = new Direccion(codigoPostal, calle, nroCalle, piso, nroDepartamento, ciudad);

                    TipoDocumento tipoDocumento = new TipoDocumento(tipoDocTexto);

                    Pasajero p = new Pasajero(nombres, apellido, cuit, nroDocumento, fechaNacimiento, nacionalidad, email, telefono, ocupacion,direccion, tipoDocumento, razonSocial);

                    lista.add(p);
                } catch (Exception e) {
                    System.err.println("Error parseando línea de pasajero: " + linea + " -> " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer archivo de pasajeros: " + e.getMessage());
        }

        return lista;
    }

    private static String textOrNull(String s) {
        if (s == null) return null;
        String t = s.trim();
        if (t.isEmpty()) return null;
        return t;
    }

    private static Integer intOrNull(String s) {
        String t = textOrNull(s);
        if (t == null) return null;
        try {
            return Integer.valueOf(t);
        } catch (NumberFormatException e) {
            return null;
        }
    }


    public List<Pasajero> buscarPasajerosPorDatos(String datosBusqueda) {

        // 1. Procesar el String de Búsqueda
        // Se eliminan espacios innecesarios y se convierte a minúsculas.
        List<String> tokens = Arrays.stream(datosBusqueda.toLowerCase().trim().split("\\s+")).filter(s -> !s.isEmpty()).collect(Collectors.toList());

        if (tokens.isEmpty()) {
            return new ArrayList<>();
        }

        List<Pasajero> pasajerosEncontrados = new ArrayList<>();

        for (Pasajero p : obtenerTodos()) {
            // Obtiene todos los datos del pasajero en una sola cadena, para buscar fácilmente
            String datosPasajero = p.obtenerDatosCompletos();
            
            // Verificación de Todos los Datos
            boolean contieneTodosLosDatos = true;
            
            for (String token : tokens) {
                if (!datosPasajero.contains(token)) {
                    contieneTodosLosDatos = false;
                    break;
                }
            }

            if (contieneTodosLosDatos) {
                pasajerosEncontrados.add(p);
            }
        }

        return pasajerosEncontrados;
    }
}
