package com.tuempresa.hotel.dao.implementacion;

import com.tuempresa.hotel.dao.ConserjeDAO;
import com.tuempresa.hotel.modelo.personas.Conserje;
import java.io.*;
import java.util.*;

public class ConserjeFileDAO implements ConserjeDAO {

    private final String rutaArchivo;

    public ConserjeFileDAO(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public List<Conserje> obtenerTodos() {
        List<Conserje> conserjes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length == 4) {
                    Conserje c = new Conserje(datos[0], datos[1], datos[2], datos[3]);
                    conserjes.add(c);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de conserjes: " + e.getMessage());
        }

        return conserjes;
    }

    public Conserje buscarPorUsuario(String usuario) {
        for (Conserje c : obtenerTodos()) {
            if (c.getUsuario().equals(usuario)) {
                return c;
            }
        }
        return null;
    }
}
