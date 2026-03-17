package org.iesalandalus.programacion.tallermecanico.modelo;

import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Cliente;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.TallerMecanicoExcepcion;

import java.util.ArrayList;
import java.util.List;

public class Clientes {

    private final List<Cliente> coleccion;

    public Clientes() {
        this.coleccion = new ArrayList<>();
    }

    public List<Cliente> get() {
        return new ArrayList<>(coleccion);
    }

    public void insertar(Cliente cliente) {
        if (cliente == null) throw new NullPointerException("No se puede insertar un cliente nulo.");
        if (coleccion.contains(cliente)) throw new TallerMecanicoExcepcion("Ya existe un cliente con ese DNI.");
        coleccion.add(cliente);
    }

    public void borrar(Cliente cliente) {
        if (cliente == null) throw new NullPointerException("No se puede borrar un cliente nulo.");
        if (!coleccion.remove(cliente)) throw new TallerMecanicoExcepcion("No existe ningún cliente con ese DNI.");
    }

    public Cliente buscar(Cliente cliente) {
        if (cliente == null) throw new NullPointerException("No se puede buscar un cliente nulo.");
        int index = coleccion.indexOf(cliente);
        return index != -1 ? coleccion.get(index) : null;
    }

    public Cliente modificar(Cliente cliente, String nombre, String telefono) {
        if (cliente == null) throw new NullPointerException("No se puede modificar un cliente nulo.");
        Cliente encontrado = buscar(cliente);
        if (encontrado == null) throw new TallerMecanicoExcepcion("No existe ningún cliente con ese DNI.");
        if (nombre != null && !nombre.isBlank()) encontrado.setNombre(nombre);
        if (telefono != null && !telefono.isBlank()) encontrado.setTelefono(telefono);
        return encontrado;
    }
}
