package org.iesalandalus.programacion.tallermecanico.modelo;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;

public record Vehiculo(String marca, String modelo, String matricula) {

    private static final String FORMATO_MATRICULA = "\\d{4}[B-DF-HJ-NP-TV-Z]{3}";
    private static final Pattern PATRON_MATRICULA = Pattern.compile(FORMATO_MATRICULA);

    private static final Map<String, Vehiculo> VEHICULOS = new HashMap<>();

    public Vehiculo {
        // Validaciones
        if (marca == null) throw new NullPointerException("La marca no puede ser nula.");
        if (!marca.equals("Seat") && !marca.equals("Land Rover") && !marca.equals("KIA")
                && !marca.equals("Rolls-Royce") && !marca.equals("SsangYong"))
            throw new IllegalArgumentException("La marca no tiene un formato válido.");

        if (modelo == null) throw new NullPointerException("El modelo no puede ser nulo.");
        if (modelo.isBlank()) throw new IllegalArgumentException("El modelo no puede estar en blanco.");

        if (matricula == null) throw new NullPointerException("La matrícula no puede ser nula.");
        if (!PATRON_MATRICULA.matcher(matricula).matches())
            throw new IllegalArgumentException("La matrícula no tiene un formato válido.");

        // Registrar en mapa
        VEHICULOS.put(matricula, this);
    }

    public static Vehiculo get(String matricula) {
        if (matricula == null) throw new NullPointerException("La matrícula no puede ser nula.");
        if (!PATRON_MATRICULA.matcher(matricula).matches())
            throw new IllegalArgumentException("La matrícula no tiene un formato válido.");
        return VEHICULOS.get(matricula);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Vehiculo other)) return false;
        return matricula.equals(other.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }

    @Override
    public String toString() {
        return String.format("%s %s - %s", marca, modelo, matricula);
    }
}
