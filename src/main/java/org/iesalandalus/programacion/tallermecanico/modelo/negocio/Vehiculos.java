package org.iesalandalus.programacion.tallermecanico.modelo.negocio;

import org.iesalandalus.programacion.tallermecanico.modelo.TallerMecanicoExcepcion;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Vehiculo;

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

    public Vehiculos insertar(Vehiculo vehiculo) throws TallerMecanicoExcepcion {
        if (vehiculo == null) throw new NullPointerException("No se puede insertar un vehículo nulo.");
        if (coleccion.contains(vehiculo)) throw new TallerMecanicoExcepcion("Ya existe un vehículo con esa matrícula.");
        coleccion.add(vehiculo);
        return null;
    }

    public Vehiculo buscar(Vehiculo vehiculo) {
        if (vehiculo == null) throw new NullPointerException("No se puede buscar un vehículo nulo.");
        int index = coleccion.indexOf(vehiculo);
        return index != -1 ? coleccion.get(index) : null;
    }

    public void borrar(Vehiculo vehiculo) {
        if (vehiculo == null) throw new NullPointerException("No se puede borrar un vehículo nulo.");
        if (!coleccion.remove(vehiculo)) try {
            throw new TallerMecanicoExcepcion("No existe ningún vehículo con esa matrícula.");
        } catch (TallerMecanicoExcepcion e) {
            throw new RuntimeException(e);
        }
    }
}
