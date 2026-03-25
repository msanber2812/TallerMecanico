package org.iesalandalus.programacion.tallermecanico.modelo.negocio;

import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Cliente;
import org.iesalandalus.programacion.tallermecanico.modelo.TallerMecanicoExcepcion;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Revision;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Vehiculo;

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

    public void insertar(Revision revision) throws TallerMecanicoExcepcion {
        if (revision == null)
            throw new NullPointerException("No se puede insertar una revisión nula.");

        for (Revision r : coleccion) {
            if (r.getCliente().equals(revision.getCliente()) && !r.estaCerrada()) {
                try {
                    throw new TallerMecanicoExcepcion("El cliente tiene otra revisión en curso.");
                } catch (TallerMecanicoExcepcion e) {
                    throw new RuntimeException(e);
                }
            }
            if (r.getVehiculo().equals(revision.getVehiculo()) && !r.estaCerrada()) {
                try {
                    throw new TallerMecanicoExcepcion("El vehículo está actualmente en revisión.");
                } catch (TallerMecanicoExcepcion e) {
                    throw new RuntimeException(e);
                }
            }
        }

        for (Revision r : coleccion) {
            if (r.getCliente().equals(revision.getCliente()) && r.estaCerrada() &&
                    r.getFechaInicio().isAfter(revision.getFechaInicio())) {
                try {
                    throw new TallerMecanicoExcepcion("El cliente tiene una revisión posterior.");
                } catch (TallerMecanicoExcepcion e) {
                    throw new RuntimeException(e);
                }
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
            try {
                throw new TallerMecanicoExcepcion("No existe ninguna revisión igual.");
            } catch (TallerMecanicoExcepcion e) {
                throw new RuntimeException(e);
            }
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
            try {
                throw new TallerMecanicoExcepcion("No existe ninguna revisión igual.");
            } catch (TallerMecanicoExcepcion e) {
                throw new RuntimeException(e);
            }
        try {
            r.anadirHoras(horas);
        } catch (TallerMecanicoExcepcion e) {
            throw new RuntimeException(e);
        }
    }

    public void anadirPrecioMaterial(Revision revision, float precio) {
        if (revision == null)
            throw new NullPointerException("No puedo operar sobre una revisión nula.");
        Revision r = buscar(revision);
        if (r == null)
            try {
                throw new TallerMecanicoExcepcion("No existe ninguna revisión igual.");
            } catch (TallerMecanicoExcepcion e) {
                throw new RuntimeException(e);
            }
        try {
            r.anadirPrecioMaterial(precio);
        } catch (TallerMecanicoExcepcion e) {
            throw new RuntimeException(e);
        }
    }

    public void cerrar(Revision revision, LocalDate fechaFin) {
        if (revision == null)
            throw new NullPointerException("No puedo operar sobre una revisión nula.");
        Revision r = buscar(revision);
        if (r == null)
            try {
                throw new TallerMecanicoExcepcion("No existe ninguna revisión igual.");
            } catch (TallerMecanicoExcepcion e) {
                throw new RuntimeException(e);
            }
        try {
            r.cerrar(fechaFin);
        } catch (TallerMecanicoExcepcion e) {
            throw new RuntimeException(e);
        }
    }
}
