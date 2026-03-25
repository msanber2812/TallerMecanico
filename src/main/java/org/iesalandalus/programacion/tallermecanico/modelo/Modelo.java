package org.iesalandalus.programacion.tallermecanico.modelo;

import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Cliente;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Revision;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.tallermecanico.modelo.negocio.Clientes;
import org.iesalandalus.programacion.tallermecanico.modelo.negocio.Revisiones;
import org.iesalandalus.programacion.tallermecanico.modelo.negocio.Vehiculos;

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
    }

    public void insertar(Cliente cliente) {
        clientes.insertar(cliente);
    }

    public void insertar(Vehiculo vehiculo) throws TallerMecanicoExcepcion {
        vehiculos.insertar(vehiculo);
    }

    public void insertar(Revision revision) throws TallerMecanicoExcepcion {
        Cliente cliente = clientes.buscar(revision.getCliente());
        Vehiculo vehiculo = vehiculos.buscar(revision.getVehiculo());
        revisiones.insertar(revision);
    }

    public Cliente buscar(Cliente cliente) {
        Cliente c = clientes.buscar(cliente);
        if (c == null) return null;
        return new Cliente(c.getDni(), c.getNombre(), c.getTelefono());
    }

    public Vehiculo buscar(Vehiculo vehiculo) {
        return vehiculos.buscar(vehiculo);
    }

    public Revision buscar(Revision revision) {
        Revision r = revisiones.buscar(revision);
        if (r == null) return null;
        return r;
    }

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
