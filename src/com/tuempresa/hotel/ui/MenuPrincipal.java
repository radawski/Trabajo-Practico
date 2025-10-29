package com.tuempresa.hotel.ui;
import java.util.Scanner;

import com.tuempresa.hotel.dao.PasajeroDAO;

public class MenuPrincipal {
    public static void mostrarMenuPrincipal(Scanner scanner){
        boolean salir = false;
        
        while (!salir) {
            System.out.println("\n*** MENÚ DE OPCIONES ***");
            System.out.println("1. Buscar un husped");
            System.out.println("2. Modificar un husped");
            System.out.println("3. Dar de alta un husped");
            System.out.println("4. Dar de baja un husped");
            System.out.println("5. Salir del programa");
            System.out.print("Ingrese su opción: ");
            
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    buscarHuesped(scanner);
                    break;
                case "2":
                    //modificarHuesped();
                    break;
                case "3":
                    //darDeAltaHuesped();
                    break;
                case "4":
                    //darDeBajaHuesped();
                    break;
                case "5":
                    System.out.println("Saliendo del sistema. ¡Hasta pronto!");
                    salir = true; // Esto rompe el bucle while
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }

    }
    
    private static void buscarHuesped(Scanner scanner) {
        System.out.println("\nEjecutando la función: BUSCAR HUESPED...");
        PasajeroDAO dao = new PasajeroDAO("pasajeros.txt");
        System.out.println("\n BUSCAR: ");

        String datos = scanner.nextLine();

        System.out.println("Resultados de la búsqueda para: '" + datos + "'");
        if (dao.buscarPasajerosPorDatos(datos).isEmpty()) {
            System.out.println("No se encontraron resultados.");
            //darDeAltaHuesped();

        } else {
            System.out.println("Pasajeros encontrados:");
            dao.buscarPasajerosPorDatos(datos).forEach(p -> System.out.println(" - " + p.getNombre() + " " + p.getApellido() + ", " + p.getTipoDocumento().getTipo() + ": "+ p.getNroDocumento()));
        }
        

        
    }
}