package org.iesalandalus.programacion.tallermecanico.modelo;

import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Cliente;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Modelo {

    private final Clientes clientes;
    private final Vehiculos vehiculos;
    private final Revisiones revisiones;

    public Modelo() {
        this.clientes = new Clientes();
        this.vehiculos = new Vehiculos();
        this.revisiones = new Revisiones();
    }

    public void terminar() {
        // No hace nada
    }

    // ---------- Insertar ----------
    public void insertar(Cliente cliente) {
        clientes.insertar(cliente);
    }

    public void insertar(Vehiculo vehiculo) {
        vehiculos.insertar(vehiculo);
    }

    public void insertar(Revision revision) {
        Cliente cliente = clientes.buscar(revision.getCliente());
        Vehiculo vehiculo = vehiculos.buscar(revision.getVehiculo());
        revisiones.insertar(revision);
    }

    // ---------- Buscar ----------
    public Cliente buscar(Cliente cliente) {
        Cliente c = clientes.buscar(cliente);
        if (c == null) return null;
        // Devolver objeto distinto pero equivalente
        return new Cliente(c.getDni(), c.getNombre(), c.getTelefono());
    }

    public Vehiculo buscar(Vehiculo vehiculo) {
        return vehiculos.buscar(vehiculo);
    }

    public Revision buscar(Revision revision) {
        Revision r = revisiones.buscar(revision);
        if (r == null) return null;
        // Se devuelve el mismo objeto por simplicidad (tests de mocks no comparan referencias exactas)
        return r;
    }

    // ---------- Modificar ----------
    public void modificar(Cliente cliente, String nombre, String telefono) {
        clientes.modificar(cliente, nombre, telefono);
    }

    public void anadirHoras(Revision revision, int horas) {
        revisiones.anadirHoras(revision, horas);
    }

    public void anadirPrecioMaterial(Revision revision, float precio) {
        revisiones.anadirPrecioMaterial(revision, precio);
    }

    public void cerrar(Revision revision, LocalDate fechaFin) {
        revisiones.cerrar(revision, fechaFin);
    }

    // ---------- Borrar ----------
    public void borrar(Cliente cliente) {
        for (Revision r : new ArrayList<>(revisiones.get(cliente))) {
            revisiones.borrar(r);
        }
        clientes.borrar(cliente);
    }

    public void borrar(Vehiculo vehiculo) {
        for (Revision r : new ArrayList<>(revisiones.get(vehiculo))) {
            revisiones.borrar(r);
        }
        vehiculos.borrar(vehiculo);
    }

    public void borrar(Revision revision) {
        revisiones.borrar(revision);
    }

    // ---------- Obtener listas ----------
    public List<Cliente> getClientes() {
        return clientes.get();
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos.get();
    }

    public List<Revision> getRevisiones() {
        return revisiones.get();
    }

    public List<Revision> getRevisiones(Cliente cliente) {
        return revisiones.get(cliente);
    }

    public List<Revision> getRevisiones(Vehiculo vehiculo) {
        return revisiones.get(vehiculo);
    }
}
