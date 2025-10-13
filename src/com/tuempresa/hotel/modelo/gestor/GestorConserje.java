package com.tuempresa.hotel.modelo.gestor;

import com.tuempresa.hotel.dao.ConserjeDAO;
import com.tuempresa.hotel.modelo.personas.Conserje;

public class GestorConserje {

    private final ConserjeDAO dao;

    public GestorConserje(ConserjeDAO dao) {
        this.dao = dao;
    }

    public Conserje autenticar(String usuario, String contrasenia) throws Exception {
        Conserje conserje = dao.buscarPorUsuario(usuario);
        if (conserje == null) {
            throw new Exception("El usuario o la contraseña no son válidos");
        }

        if (!conserje.getContrasenia().equals(contrasenia)) {
            throw new Exception("El usuario o la contraseña no son válidos");
        }

        return conserje;
    }
}
