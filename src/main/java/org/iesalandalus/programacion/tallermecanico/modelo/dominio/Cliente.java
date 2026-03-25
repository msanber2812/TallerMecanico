package org.iesalandalus.programacion.tallermecanico.modelo.dominio;

import java.util.regex.Pattern;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Cliente {

    private String nombre;
    private String dni;
    private String telefono;

    private static final String ER_NOMBRE = "([A-Z][a-z]+( [A-Z][a-z]+)*)";
    private static final String ER_DNI = "(\\d{8}[A-Z])";
    private static final String ER_TELEFONO = "\\d{9}";

    private static final Map<String, Cliente> clientes = new HashMap<>();


    public Cliente(String nombre, String dni, String telefono) {
        setNombre(nombre);
        setDni(dni);
        setTelefono(telefono);
        clientes.put(dni, this);
    }

    public Cliente(Cliente cliente) {
        if (cliente == null) {
            throw new NullPointerException("No es posible copiar un cliente nulo.");
        }
        this.nombre = cliente.nombre;
        this.dni = cliente.dni;
        this.telefono = cliente.telefono;

        clientes.put(this.dni, this);
    }


    public void setNombre(String nombre) {
        if (nombre == null) {
            throw new NullPointerException("El nombre no puede ser nulo.");
        }
        if (!Pattern.matches(ER_NOMBRE, nombre.trim())) {
            throw new IllegalArgumentException("El nombre no tiene un formato válido.");
        }
        this.nombre = nombre.trim();
    }

    public void setDni(String dni) {
        if (dni == null) {
            throw new NullPointerException("El DNI no puede ser nulo.");
        }
        dni = dni.trim().toUpperCase();
        if (!Pattern.matches(ER_DNI, dni)) {
            throw new IllegalArgumentException("El DNI no tiene un formato válido.");
        }
        if (esLetraCorrecta(dni)) {
            throw new IllegalArgumentException("La letra del DNI no es correcta.");
        }
        this.dni = dni;
    }

    public void setTelefono(String telefono) {
        if (telefono == null) {
            throw new NullPointerException("El teléfono no puede ser nulo.");
        }
        if (!Pattern.matches(ER_TELEFONO, telefono.trim())) {
            throw new IllegalArgumentException("El teléfono no tiene un formato válido.");
        }
        this.telefono = telefono.trim();
    }



    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public String getTelefono() {
        return telefono;
    }



    public static Cliente get(String dni) {
        if (dni == null) {
            throw new NullPointerException("El DNI no puede ser nulo.");
        }
        dni = dni.trim().toUpperCase();
        if (!Pattern.matches(ER_DNI, dni)) {
            throw new IllegalArgumentException("El DNI no tiene un formato válido.");
        }
        if (esLetraCorrecta(dni)) {
            throw new IllegalArgumentException("La letra del DNI no es correcta.");
        }
        return clientes.get(dni);
    }



    private static boolean esLetraCorrecta(String dni) {
        final String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        int numero = Integer.parseInt(dni.substring(0, 8));
        char letra = dni.charAt(8);
        return letra != letras.charAt(numero % 23);
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Cliente other)) return false;
        return dni.equals(other.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }


    @Override
    public String toString() {
        return String.format("%s - %s (%s)", nombre, dni, telefono);
    }
}
