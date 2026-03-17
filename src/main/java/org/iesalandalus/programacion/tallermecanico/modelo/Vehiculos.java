package org.iesalandalus.programacion.tallermecanico.modelo;

import org.iesalandalus.programacion.tallermecanico.modelo.dominio.TallerMecanicoExcepcion;

import java.util.ArrayList;
import java.util.List;

public class Vehiculos {

    private final List<Vehiculo> coleccion;

    public Vehiculos() {
        this.coleccion = new ArrayList<>();
    }

    public List<Vehiculo> get() {
        return new ArrayList<>(coleccion);
    }

    public void insertar(Vehiculo vehiculo) {
        if (vehiculo == null) throw new NullPointerException("No se puede insertar un vehículo nulo.");
        if (coleccion.contains(vehiculo)) throw new TallerMecanicoExcepcion("Ya existe un vehículo con esa matrícula.");
        coleccion.add(vehiculo);
    }

    public void borrar(Vehiculo vehiculo) {
        if (vehiculo == null) throw new NullPointerException("No se puede borrar un vehículo nulo.");
        if (!coleccion.remove(vehiculo)) throw new TallerMecanicoExcepcion("No existe ningún vehículo con esa matrícula.");
    }

    public Vehiculo buscar(Vehiculo vehiculo) {
        if (vehiculo == null) throw new NullPointerException("No se puede buscar un vehículo nulo.");
        int index = coleccion.indexOf(vehiculo);
        return index != -1 ? coleccion.get(index) : null;
    }
}
