package org.iesalandalus.programacion.tallermecanico.modelo;

import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Cliente;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.TallerMecanicoExcepcion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Revisiones {

    private final List<Revision> coleccion;

    public Revisiones() {
        this.coleccion = new ArrayList<>();
    }

    public List<Revision> get() {
        return new ArrayList<>(coleccion);
    }

    public List<Revision> get(Cliente cliente) {
        List<Revision> resultado = new ArrayList<>();
        for (Revision r : coleccion) {
            if (r.getCliente().equals(cliente)) {
                resultado.add(r);
            }
        }
        return resultado;
    }

    public List<Revision> get(Vehiculo vehiculo) {
        List<Revision> resultado = new ArrayList<>();
        for (Revision r : coleccion) {
            if (r.getVehiculo().equals(vehiculo)) {
                resultado.add(r);
            }
        }
        return resultado;
    }

    public void insertar(Revision revision) {
        if (revision == null)
            throw new NullPointerException("No se puede insertar una revisión nula.");

        // Validar que no hay revisiones abiertas del cliente o vehículo
        for (Revision r : coleccion) {
            if (r.getCliente().equals(revision.getCliente()) && !r.estaCerrada()) {
                throw new TallerMecanicoExcepcion("El cliente tiene otra revisión en curso.");
            }
            if (r.getVehiculo().equals(revision.getVehiculo()) && !r.estaCerrada()) {
                throw new TallerMecanicoExcepcion("El vehículo está actualmente en revisión.");
            }
        }

        // Validar que no hay revisiones posteriores cerradas
        for (Revision r : coleccion) {
            if (r.getCliente().equals(revision.getCliente()) && r.estaCerrada() &&
                    r.getFechaInicio().isAfter(revision.getFechaInicio())) {
                throw new TallerMecanicoExcepcion("El cliente tiene una revisión posterior.");
            }
            if (r.getVehiculo().equals(revision.getVehiculo()) && r.estaCerrada() &&
                    r.getFechaInicio().isAfter(revision.getFechaInicio())) {
                throw new TallerMecanicoExcepcion("El vehículo tiene una revisión posterior.");
            }
        }

        coleccion.add(revision);
    }

    public void borrar(Revision revision) {
        if (revision == null)
            throw new NullPointerException("No se puede borrar una revisión nula.");
        if (!coleccion.remove(revision))
            throw new TallerMecanicoExcepcion("No existe ninguna revisión igual.");
    }

    public Revision buscar(Revision revision) {
        if (revision == null)
            throw new NullPointerException("No se puede buscar una revisión nula.");
        int index = coleccion.indexOf(revision);
        return index != -1 ? coleccion.get(index) : null;
    }

    public void anadirHoras(Revision revision, int horas) {
        if (revision == null)
            throw new NullPointerException("No puedo operar sobre una revisión nula.");
        Revision r = buscar(revision);
        if (r == null)
            throw new TallerMecanicoExcepcion("No existe ninguna revisión igual.");
        r.anadirHoras(horas);
    }

    public void anadirPrecioMaterial(Revision revision, float precio) {
        if (revision == null)
            throw new NullPointerException("No puedo operar sobre una revisión nula.");
        Revision r = buscar(revision);
        if (r == null)
            throw new TallerMecanicoExcepcion("No existe ninguna revisión igual.");
        r.anadirPrecioMaterial(precio);
    }

    public void cerrar(Revision revision, LocalDate fechaFin) {
        if (revision == null)
            throw new NullPointerException("No puedo operar sobre una revisión nula.");
        Revision r = buscar(revision);
        if (r == null)
            throw new TallerMecanicoExcepcion("No existe ninguna revisión igual.");
        r.cerrar(fechaFin);
    }
}
