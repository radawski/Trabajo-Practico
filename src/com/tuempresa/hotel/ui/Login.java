package com.tuempresa.hotel.ui;

import com.tuempresa.hotel.dao.ConserjeDAO;
import com.tuempresa.hotel.modelo.gestor.GestorConserje;
import com.tuempresa.hotel.modelo.personas.Conserje;
import com.tuempresa.hotel.modelo.personas.ValidadorContrasenia;

import java.util.Scanner;

public class Login {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConserjeDAO dao = new ConserjeDAO("conserjes.txt");
        GestorConserje gestor = new GestorConserje(dao);

        System.out.println("=== Sistema de Gestión Hotelera ===");
        System.out.print("Usuario: ");
        String usuario = scanner.nextLine();

        System.out.print("Contraseña: ");
        String contrasenia = scanner.nextLine();

        if (!ValidadorContrasenia.validar(contrasenia)) {
            System.out.println("⚠️ La contraseña no cumple con los requisitos de seguridad.");
            scanner.close();
            return;
        }

        try {
            Conserje conserje = gestor.autenticar(usuario, contrasenia);
            System.out.println("✅ Bienvenido " + conserje.getNombreCompleto() + "!");
            System.out.println("Cargando pantalla principal...");
        } catch (Exception e) {
            System.out.println("❌ " + e.getMessage());
            System.out.println("Por favor, intente nuevamente.");
        }

        scanner.close();
    }
}
