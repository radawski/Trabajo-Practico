package com.tuempresa.hotel.ui;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import com.tuempresa.hotel.dao.PasajeroDAO;
import com.tuempresa.hotel.modelo.personas.Direccion;
import com.tuempresa.hotel.modelo.personas.Pasajero;
import com.tuempresa.hotel.modelo.otros.TipoDocumento;
import com.tuempresa.hotel.modelo.ubicacion.Ciudad;
import com.tuempresa.hotel.modelo.ubicacion.Pais;
import com.tuempresa.hotel.modelo.ubicacion.Provincia;

public class Vista {
    private Scanner scanner;

    public Vista() { this.scanner = new Scanner(System.in); }

    public int mostrarMenuPrincipal() {
        System.out.println("\n--- MENÚ PRINCIPAL ---");
        System.out.println("1. Buscar Pasajero (para Modificar/Eliminar)");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
        return Integer.parseInt(scanner.nextLine());
    }

//    public Boolean buscarPasajeros(PasajeroDAO dao) {
//        Scanner sc = new Scanner(System.in);
//        Boolean ret = false;
//
//        System.out.println("=== Buscar pasajero ===");
//        System.out.print("Apellido (dejar vacío si no se conoce): ");
//        String apellido = sc.nextLine().trim();
//
//        System.out.print("Nombre (dejar vacío si no se conoce): ");
//        String nombre = sc.nextLine().trim();
//
//        System.out.print("Tipo de documento (dejar vacío si no se conoce): ");
//        TipoDocumento tipoDoc = new TipoDocumento(sc.nextLine().trim());
//
//        System.out.print("Número de documento (dejar vacío si no se conoce): ");
//        String nroDoc = sc.nextLine().trim();
//
//        List<Pasajero> encontrados = dao.buscarPasajerosPorDatos(apellido, nombre, tipoDoc, nroDoc);
//
//        if (encontrados.isEmpty()){
//            System.out.println("No se encontraron pasajeros con esos datos.");
//        } else {
//            ret = true;
//            System.out.println("\n--- Resultados ---");
//            encontrados.forEach(System.out::println);
//        }
//
//        sc.close();
//        return ret;
//    }

    public String pedirFiltroDeBusqueda() {
        System.out.print("Ingresar datos de la busqueda: ");
        return scanner.nextLine();
    }

    /**
     * Muestra la lista y pide al usuario que seleccione uno.
     * Devuelve el Pasajero seleccionado, o null si se mueve a dar de alta un huesped.
     */
    public Pasajero seleccionarPasajeroDeLista(List<Pasajero> resultados) {
        System.out.println("--- Resultados ---");

        if (resultados.isEmpty()) {
            System.out.println("No se encontraron pasajeros.");
            return null;
        }

        System.out.println("Huéspedes encontrados:");
        for (int i = 0; i < resultados.size(); i++) {
            Pasajero p = resultados.get(i);
            System.out.println((i+1) + ") - " + p.getNombre() + " " + p.getApellido() + ", " + p.getTipoDocumento().getTipo() + ": "+ p.getNroDocumento());
        }
        
        System.out.print("Seleccione un pasajero (número) u otra cosa para dar de alta un huesped: ");
        int selection = Integer.parseInt(scanner.nextLine());
        
        if (selection <= 0 || selection > resultados.size()) {
            return null; // El usuario se mueve a dar de alta un huesped
        }

        return resultados.get(selection - 1); // Devuelve el pasajero elegido
    }

    /**
     * Muestra el sub-menú y devuelve la opción elegida.
     */
    public int mostrarSubMenu(Pasajero p) {
        System.out.println("\nOpciones para: " + p.getNombre());
        System.out.println("1. Modificar Pasajero");
        System.out.println("2. Eliminar Pasajero");
        System.out.println("0. Volver");
        System.out.print("Seleccione una opción: ");
        return Integer.parseInt(scanner.nextLine());
    }
    
    /**
     * Pide los datos para modificar y actualiza el objeto Pasajero.
     */
    
    public int seleccionarDatoAModificar(Pasajero pasajero) {
        System.out.println("Seleccione el dato a modificar:");
        System.out.println("1. Nombre");
        System.out.println("2. Apellido");
        System.out.println("3. Tipo de Documento");
        System.out.println("4. Número de Documento");
        System.out.println("5. Fecha de Nacimiento");
        System.out.println("6. Nacionalidad");
        System.out.println("7. Teléfono");
        System.out.println("8. Ocupación");
        System.out.println("9. Dirección");
        System.out.println("10. Email");
        System.out.println("11. CUIT");
        System.out.print("Ingrese el número correspondiente al dato: ");
        
        int opcion = Integer.parseInt(scanner.nextLine());
        return opcion;
    }
    
    public Pasajero pedirDatosDelNuevoPasajero() {
        System.out.println("--- Ingrese los datos del nuevo Pasajero ---");

        // Pedir todos los datos
        String apellido = getStringOrNull(scanner, "Apellido: ");
        String nombres = getStringOrNull(scanner, "Nombres: ");
        String tipoDocTexto = getStringOrNull(scanner, "Tipo de Documento: ");
        String nroDocumento = getStringOrNull(scanner, "Nro de Documento: ");
        String cuit = getStringOrNull(scanner, "CUIT: ");

        String razonSocial = getStringOrNull(scanner, "Razón Social: ");
        if (razonSocial == null) {
            razonSocial = "consumidor final";
        }

        LocalDate fechaNacimiento = getLocalDateOrNull(scanner, "Fecha Nacimiento (YYYY-MM-DD): ");

        String calle = getStringOrNull(scanner, "Calle: ");
        Integer nroCalle = getIntegerOrNull(scanner, "Nro Calle: ");
        Integer nroDepartamento = getIntegerOrNull(scanner, "Nro Departamento: ");
        Integer piso = getIntegerOrNull(scanner, "Piso: ");
        Integer codigoPostal = getIntegerOrNull(scanner, "Código Postal: ");
        String nombreCiudad = getStringOrNull(scanner, "Ciudad: ");
        String nombreProvincia = getStringOrNull(scanner, "Provincia: ");
        String nombrePais = getStringOrNull(scanner, "País: ");

        String telefono = getStringOrNull(scanner, "Teléfono: ");
        String email = getStringOrNull(scanner, "Email: ");
        String ocupacion = getStringOrNull(scanner, "Ocupación: ");
        String nacionalidad = getStringOrNull(scanner, "Nacionalidad: ");

        // --- Construcción de Objetos ---
        
        Pais pais = new Pais(nombrePais);
        Provincia provincia = new Provincia(nombreProvincia, pais);
        Ciudad ciudad = new Ciudad(nombreCiudad, provincia);

        Direccion direccion = new Direccion(codigoPostal, calle, nroCalle, piso, nroDepartamento, ciudad);

        TipoDocumento tipoDocumento = new TipoDocumento(tipoDocTexto);

        Pasajero p = new Pasajero(nombres, apellido, cuit, nroDocumento, fechaNacimiento, 
                                  nacionalidad, email, telefono, ocupacion, 
                                  direccion, tipoDocumento, razonSocial);
        
        return p;
    }

    /**
     * Pide un texto. Si el usuario solo presiona Enter, devuelve null.
     */
    private static String getStringOrNull(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();
        return input.isEmpty() ? null : input;
    }

    /**
     * Pide un número. Si está vacío o no es un número válido, devuelve null.
     */
    private static Integer getIntegerOrNull(Scanner scanner, String prompt) {
        String input = getStringOrNull(scanner, prompt);
        if (input == null) {
            return null;
        }
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.err.println("Entrada inválida ('" + input + "'). Se guardará como null.");
            return null;
        }
    }

    /**
     * Pide una fecha. Si está vacía o no tiene el formato YYYY-MM-DD, devuelve null.
     */
    private static LocalDate getLocalDateOrNull(Scanner scanner, String prompt) {
        String input = getStringOrNull(scanner, prompt);
        if (input == null) {
            return null;
        }
        try {
            return LocalDate.parse(input); // Asume formato YYYY-MM-DD
        } catch (DateTimeParseException e) {
            System.err.println("Formato de fecha inválido ('" + input + "'). Se guardará como null.");
            return null;
        }
    }

    public int mostrarMensajePasajeroRepetido() {
        System.out.println("CUIDADO! El tipo y numero de documento ya existen en el sistema.");
        System.out.println("Selecciona una opcion:");
        System.out.println("1. Aceptar igualmente");
        System.out.println("2. Corregir datos");
        int opcion = scanner.nextInt();
        return opcion;
    }

    public String pedirNuevoNombre() {
        System.out.print("Ingrese el nuevo nombre: ");
        return scanner.nextLine();
    }

    public String pedirNuevoApellido() {
        System.out.print("Ingrese el nuevo apellido: ");
        return scanner.nextLine();
    }

    public String pedirNuevoTipoDocumento() {
        System.out.print("Ingrese el nuevo tipo de documento: ");
        return scanner.nextLine();
    }

    public LocalDate pedirNuevaFechaDeNacimiento() {
        System.out.print("Ingrese la nueva fecha de nacimiento (YYYY-MM-DD): ");
        String fechaStr = scanner.nextLine();
        return LocalDate.parse(fechaStr);
    }

    

    public Direccion pedirNuevaDireccion() {
        System.out.print("Ingrese la nueva Calle: ");
        String calle = scanner.nextLine();
        System.out.print("Ingrese el nuevo Número de Calle: ");
        int nroCalle = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.print("Ingrese el nuevo Piso: ");
        int piso = scanner.nextInt();
        System.out.print("Ingrese el nuevo Número de Departamento: ");
        int nroDepartamento = scanner.nextInt();
        System.out.println("ingrese el nuevo codigo postal: ");
        int codigoPostal = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.print("Ingrese la nueva Ciudad: ");
        String ciudad = scanner.nextLine();
        System.out.print("Ingrese la nueva Provincia: ");
        String provincia = scanner.nextLine();
        System.out.print("Ingrese el nuevo País: ");
        String pais = scanner.nextLine();
        return new Direccion(calle, nroCalle, piso, nroDepartamento, ciudad, codigoPostal, provincia, pais);
    }

    public String pedirNuevoTelefono() {
        System.out.print("Ingrese el nuevo teléfono: ");
        return scanner.nextLine();
    }

    public String pedirNuevaOcupacion() {
        System.out.print("Ingrese la nueva ocupación: ");
        return scanner.nextLine();
    }

    public String pedirNuevoEmail() {
        System.out.print("Ingrese el nuevo email: ");
        return scanner.nextLine();
    }
    

    public String pedirNuevoCUIT() {
        System.out.print("Ingrese el nuevo CUIT: ");
        return scanner.nextLine();
    }

    public String pedirNuevaNacionalidad() {
        System.out.print("Ingrese la nueva nacionalidad: ");
        return scanner.nextLine();
    }

    public String pedirNuevaRazonSocial() {
        System.out.print("Ingrese la nueva razón social: ");
        return scanner.nextLine();
    }

    public void cerrarScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }

    public void mostrarEncabezadoLogin() {
        System.out.println("=== Sistema de Gestión Hotelera ===");
    }

    public String pedirUsuario() {
        System.out.print("Usuario: ");
        return scanner.nextLine();
    }

    public String pedirContrasenia() {
        System.out.print("Contraseña: ");
        return scanner.nextLine();
    }
    
    public void mostrarBienvenida(){
        System.out.println("✅ Bienvenido !");
        System.out.println("Cargando pantalla principal...");
    }

    public void mostrarSaludoDespedida() {
        System.out.println("Gracias por usar el sistema. ¡Hasta luego!");
    }
}

