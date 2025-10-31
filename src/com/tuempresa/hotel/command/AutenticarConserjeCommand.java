package com.tuempresa.hotel.command;

import com.tuempresa.hotel.dao.implementacion.ConserjeFileDAO;
import com.tuempresa.hotel.modelo.personas.Conserje;

public class AutenticarConserjeCommand implements Command {
    
    private final ConserjeFileDAO conserjeDAO;
    private final String usuario;
    private final String contrasenia;

    public AutenticarConserjeCommand(ConserjeFileDAO dao, String usuario, String contrasenia) {
        this.conserjeDAO = dao;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    @Override
    public void execute() throws Exception{
        
        Conserje conserjeEncontrado = conserjeDAO.buscarPorUsuario(usuario);

        if (conserjeEncontrado == null) {
            // Se lanza la excepción con el mensaje exacto que pediste
            throw new Exception("El usuario o la contraseña no son válidos");
        }
        String contraseñaAlmacenada = conserjeEncontrado.getContrasenia();

        if (!contraseñaAlmacenada.equals(this.contrasenia)) {
            // Se lanza la excepción con el mensaje exacto que pediste
            throw new Exception("El usuario o la contraseña no son válidos");
        }
    }

}
