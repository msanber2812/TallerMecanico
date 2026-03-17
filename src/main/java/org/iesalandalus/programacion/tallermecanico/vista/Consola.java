package org.iesalandalus.programacion.tallermecanico.vista;

import org.iesalandalus.programacion.tallermecanico.modelo.TallerMecanicoExcepcion;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Consola {

    private static Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    // Constructor
    public Consola() {
    }

    // ---------------- CABECERAS ----------------

    public void mostrarCabecera(String mensaje) {
        System.out.println(mensaje);
        System.out.println("-".repeat(mensaje.length()));
    }

    public void mostrarMenu() {
        mostrarCabecera("Aplicación Taller Mecánico");
        for (Opcion opcion : Opcion.values()) {
            System.out.println(opcion);
        }
    }

    // ---------------- LECTURAS ----------------

    public double leerReal(String mensaje) {
        while (true) {
            System.out.print(mensaje + ": ");
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Número real no válido. Intente de nuevo.");
            }
        }
    }

    public int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje + ": ");
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Número entero no válido. Intente de nuevo.");
            }
        }
    }

    public String leerCadena(String mensaje) {
        System.out.print(mensaje + ": ");
        return scanner.nextLine().trim();
    }

    public LocalDate leerFecha(String mensaje) {
        while (true) {
            System.out.print(mensaje + " (yyyy-MM-dd): ");
            String entrada = scanner.nextLine().trim();
            try {
                return LocalDate.parse(entrada, FORMATO_FECHA);
            } catch (DateTimeParseException e) {
                System.out.println("Fecha no válida. Intente de nuevo.");
            }
        }
    }

    // ---------------- OPCIONES ----------------

    public Opcion elegirOpcion() {
        while (true) {
            int numero = leerEntero("Seleccione una opción");
            if (Opcion.esValida(numero)) {
                try {
                    return Opcion.get(numero);
                } catch (TallerMecanicoExcepcion e) {
                    // Nunca debería ocurrir porque esValida lo asegura
                }
            }
            System.out.println("Opción no válida. Intente de nuevo.");
        }
    }

    // ---------------- MÉTODOS AUXILIARES ----------------

    // Por ejemplo, mostrar mensaje genérico
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    // Leer booleano simple
    public boolean leerBoolean(String mensaje) {
        while (true) {
            String entrada = leerCadena(mensaje + " (s/n)").toLowerCase();
            if (entrada.equals("s") || entrada.equals("si")) return true;
            if (entrada.equals("n") || entrada.equals("no")) return false;
            System.out.println("Entrada no válida. Responda s/n.");
        }
    }
}