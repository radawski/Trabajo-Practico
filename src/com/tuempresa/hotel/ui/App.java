package com.tuempresa.hotel.ui;

import java.time.LocalDate;
import java.util.List;

import com.tuempresa.hotel.command.AutenticarConserjeCommand;
import com.tuempresa.hotel.command.Command;
import com.tuempresa.hotel.command.EliminarPasajeroCommand;
import com.tuempresa.hotel.command.ModificarPasajeroCommand;
import com.tuempresa.hotel.dao.implementacion.ConserjeFileDAO;
import com.tuempresa.hotel.dao.implementacion.PasajeroFileDAO;
import com.tuempresa.hotel.modelo.personas.Direccion;
import com.tuempresa.hotel.modelo.personas.Pasajero;
import com.tuempresa.hotel.servicio.ValidadorContrasenia;
import com.tuempresa.hotel.strategy.implementacion.ValidacionEstandar;

public class App {
    private PasajeroFileDAO pasajeroDAO;
    private Vista vista;
    private ConserjeFileDAO conserjeDAO;

    public App(Vista vista2, PasajeroFileDAO pasajeroDAO2, ConserjeFileDAO conserjeDAO2) {
        this.vista = vista2;
        this.pasajeroDAO = pasajeroDAO2;
        this.conserjeDAO = conserjeDAO2;
    }

    public void start(){
        boolean loginAcepatado = login();
        if(loginAcepatado){
            vista.mostrarBienvenida();
            mainMenu();
        }
        vista.mostrarSaludoDespedida();
        vista.cerrarScanner();
    }

    public void mainMenu() {
        while(true){
            int opcion = vista.mostrarMenuPrincipal();
            switch (opcion) {
                case 1:
                    buscarPasajero();
                    break;
                case 0:
                    System.out.println("Saliendo del menú...");
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, intente de nuevo.");
            }
        }
    }

    private boolean login(){
        while (true) {
            vista.mostrarEncabezadoLogin();
            String usuario = vista.pedirUsuario();
            String contrasenia = vista.pedirContrasenia();

            System.out.println(contrasenia);

            if (!ValidadorContrasenia.validar(contrasenia)) {
                System.out.println("La contraseña no cumple con los requisitos de seguridad.");
                continue;
            }

            Command autenticarCommand = new AutenticarConserjeCommand(conserjeDAO, usuario, contrasenia);

            try {
                autenticarCommand.execute();
                return true;

            } catch (Exception e) {
                System.out.println("❌ " + e.getMessage());
                System.out.println("Por favor, intente nuevamente.");
            }
        }
    }

    public void buscarPasajero() {
        String filtro = vista.pedirFiltroDeBusqueda();
        List<Pasajero> resultados = pasajeroDAO.buscarPasajerosPorDatos(filtro);
        Pasajero pasajeroSeleccionado = vista.seleccionarPasajeroDeLista(resultados);
        if (pasajeroSeleccionado != null) {
            modificarHuesped(pasajeroSeleccionado);
        } else {
            darDeAltaHuesped();
        }
    }

    public void modificarHuesped(Pasajero pasajero) {
        int opcion = vista.mostrarSubMenu(pasajero);
        switch (opcion) {
            case 1:
                int datoAModificar = vista.seleccionarDatoAModificar(pasajero);
                switch (datoAModificar) {
                    case 1:
                        String nuevoNombre = vista.pedirNuevoNombre();
                        pasajero.setNombre(nuevoNombre);
                        break;
                    case 2:
                        String nuevoApellido = vista.pedirNuevoApellido();
                        pasajero.setApellido(nuevoApellido);
                        break;
                    case 3:
                        String nuevoTipoDocumento = vista.pedirNuevoTipoDocumento();
                        pasajero.setTipoDocumento(nuevoTipoDocumento);
                        break;
                    case 4:
                        String nuevoNumeroDocumento = vista.pedirNuevoTipoDocumento();
                        pasajero.setTipoDocumento(nuevoNumeroDocumento);
                        break;
                    case 5:
                        LocalDate nuevaFechaNacimiento = vista.pedirNuevaFechaDeNacimiento();
                        pasajero.setFechaNacimiento(nuevaFechaNacimiento);
                        break;
                    case 6:
                        Direccion nuevaDireccion = vista.pedirNuevaDireccion();
                        pasajero.setDireccion(nuevaDireccion);
                        break;
                    case 7:
                        String nuevoTelefono = vista.pedirNuevoTelefono();
                        pasajero.setTelefono(nuevoTelefono);
                        break;
                    case 8:
                        String nuevaOcupacion = vista.pedirNuevaOcupacion();
                        pasajero.setOcupacion(nuevaOcupacion);
                        break;
                    case 9:
                        String nuevoEmail = vista.pedirNuevoEmail();
                        pasajero.setEmail(nuevoEmail);
                        break;
                    case 10:
                        String nuevoCUIT = vista.pedirNuevoCUIT();
                        pasajero.setCuit(nuevoCUIT);
                        break;
                    case 11:
                        String nuevaNacionalidad = vista.pedirNuevaNacionalidad();
                        pasajero.setNacionalidad(nuevaNacionalidad);
                        break;
                    case 12:
                        String nuevaRazonSocial = vista.pedirNuevaRazonSocial();
                        pasajero.setRazonSocial(nuevaRazonSocial);
                        break;
                    
                
                    default:
                        break;
                }
                ModificarPasajeroCommand modificarCommand = new ModificarPasajeroCommand(pasajeroDAO, pasajero);
                try {
                    modificarCommand.execute();
                    System.out.println("✅ Pasajero modificado: " + pasajero.getNombre() + " " + pasajero.getApellido());
                } catch (Exception e) {
                    System.out.println("Error al modificar el pasajero: " + e.getMessage());
                }
                break;
            case 2:
                eliminarHuesped(pasajero);
                break;
            case 0:
                System.out.println("Regresando al menú principal...");
                break;
            default:
                System.out.println("Opción inválida. Regresando al menú principal...");
                break;
        }
    }

    public void darDeAltaHuesped() {
        while(true){
            Pasajero nuevoPasajero = vista.pedirDatosDelNuevoPasajero();
            ValidacionEstandar validador = new ValidacionEstandar();
            if(validador.validarPasajero(nuevoPasajero) && !pasajeroDAO.esPasajeroRepetido(nuevoPasajero)) {
                pasajeroDAO.guardar(nuevoPasajero);
                System.out.println("✅ Nuevo pasajero agregado: " + nuevoPasajero.getNombre() + " " + nuevoPasajero.getApellido());
                break;
            } else if (pasajeroDAO.esPasajeroRepetido(nuevoPasajero)) {
                int opcion = vista.mostrarMensajePasajeroRepetido();
                if (opcion == 1) {
                    pasajeroDAO.guardar(nuevoPasajero);
                    System.out.println("✅ Nuevo pasajero agregado: " + nuevoPasajero.getNombre() + " " + nuevoPasajero.getApellido());
                    break;
                }
            } else {
                System.out.println("❌ Datos inválidos. Por favor, ingrese nuevamente los datos del pasajero.");
            }
        }
 
        
        
    }

    public void eliminarHuesped(Pasajero pasajero) {
        EliminarPasajeroCommand eliminarCommand = new EliminarPasajeroCommand(pasajeroDAO, pasajero);
        try {
            eliminarCommand.execute();
        } catch (Exception e) {
            System.out.println("Error al eliminar el pasajero: " + e.getMessage());
        }
    }
}
