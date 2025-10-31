package com.tuempresa.hotel.dao;

import java.util.List;

import com.tuempresa.hotel.modelo.personas.Conserje;

public interface ConserjeDAO {

    // Método para obtener todos los conserjes
    List<Conserje> obtenerTodos();

    // Método para buscar un conserje por su nombre de usuario
    Conserje buscarPorUsuario(String usuario);

}
