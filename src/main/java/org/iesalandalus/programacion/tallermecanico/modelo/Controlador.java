package org.iesalandalus.programacion.tallermecanico.modelo;

import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Cliente;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.TallerMecanicoExcepcion;

import java.time.LocalDate;
import java.util.List;

public class Controlador {

    private Modelo modelo;
    private Vista vista;

    // Constructor con parámetros
    public Controlador(Modelo modelo, Vista vista) {
        if (modelo == null || vista == null) {
            throw new IllegalArgumentException("Modelo y Vista no pueden ser null");
        }
        this.modelo = modelo;
        this.vista = vista;

        // Asignar controlador a la vista
        this.vista.setControlador(this);
    }

    // ---------------- INICIO / FIN ----------------

    public void comenzar() {
        modelo.comenzar();
        vista.comenzar();
    }

    public void terminar() {
        modelo.terminar();
        vista.terminar();
    }

    // ---------------- MÉTODOS DE CLIENTE ----------------

    public void insertarCliente(Cliente cliente) throws TallerMecanicoExcepcion {
        modelo.insertar(cliente);
    }

    public Cliente buscarCliente(Cliente cliente) {
        return modelo.buscar(cliente);
    }

    public Cliente modificarCliente(Cliente cliente, String nombre, String telefono)
            throws TallerMecanicoExcepcion {
        return modelo.modificar(cliente, nombre, telefono);
    }

    public void borrarCliente(Cliente cliente) throws TallerMecanicoExcepcion {
        modelo.borrar(cliente);
    }

    public List<Cliente> getClientes() {
        return modelo.getClientes();
    }

    // ---------------- MÉTODOS DE VEHÍCULO ----------------

    public void insertarVehiculo(Vehiculo vehiculo) throws TallerMecanicoExcepcion {
        modelo.insertar(vehiculo);
    }

    public Vehiculo buscarVehiculo(Vehiculo vehiculo) {
        return modelo.buscar(vehiculo);
    }

    public void borrarVehiculo(Vehiculo vehiculo) throws TallerMecanicoExcepcion {
        modelo.borrar(vehiculo);
    }

    public List<Vehiculo> getVehiculos() {
        return modelo.getVehiculos();
    }

    // ---------------- MÉTODOS DE REVISIÓN ----------------

    public void insertarRevision(Revision revision) throws TallerMecanicoExcepcion {
        modelo.insertar(revision);
    }

    public Revision buscarRevision(Revision revision) {
        return modelo.buscar(revision);
    }

    public Revision anadirHoras(Revision revision, float horas) throws TallerMecanicoExcepcion {
        return modelo.anadirHoras(revision, horas);
    }

    public Revision anadirPrecioMaterial(Revision revision, float precio)
            throws TallerMecanicoExcepcion {
        return modelo.anadirPrecioMaterial(revision, precio);
    }

    public Revision cerrarRevision(Revision revision, LocalDate fechaFin)
            throws TallerMecanicoExcepcion {
        return modelo.cerrar(revision, fechaFin);
    }

    public void borrarRevision(Revision revision) throws TallerMecanicoExcepcion {
        modelo.borrar(revision);
    }

    public List<Revision> getRevisiones() {
        return modelo.getRevisiones();
    }

    public List<Revision> getRevisiones(Cliente cliente) {
        return modelo.getRevisiones(cliente);
    }

    public List<Revision> getRevisiones(Vehiculo vehiculo) {
        return modelo.getRevisiones(vehiculo);
    }
}
