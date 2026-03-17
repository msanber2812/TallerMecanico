package org.iesalandalus.programacion.tallermecanico.modelo.negocio;

import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Cliente;
import org.iesalandalus.programacion.tallermecanico.modelo.TallerMecanicoExcepcion;

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

    public Cliente insertar(Cliente cliente) {
        if (cliente == null) throw new NullPointerException("No se puede insertar un cliente nulo.");
        if (coleccion.contains(cliente)) try {
            throw new TallerMecanicoExcepcion("Ya existe un cliente con ese DNI.");
        } catch (TallerMecanicoExcepcion e) {
            throw new RuntimeException(e);
        }
        coleccion.add(cliente);
        return cliente;
    }

    public Cliente borrar(Cliente cliente) {
        if (cliente == null) throw new NullPointerException("No se puede borrar un cliente nulo.");
        if (!coleccion.remove(cliente)) try {
            throw new TallerMecanicoExcepcion("No existe ningún cliente con ese DNI.");
        } catch (TallerMecanicoExcepcion e) {
            throw new RuntimeException(e);
        }
        return cliente;
    }

    public Cliente buscar(Cliente cliente) {
        if (cliente == null) throw new NullPointerException("No se puede buscar un cliente nulo.");
        int index = coleccion.indexOf(cliente);
        return index != -1 ? coleccion.get(index) : null;
    }

    public Cliente modificar(Cliente cliente, String nombre, String telefono) {
        if (cliente == null) throw new NullPointerException("No se puede modificar un cliente nulo.");
        Cliente encontrado = buscar(cliente);
        if (encontrado == null) try {
            throw new TallerMecanicoExcepcion("No existe ningún cliente con ese DNI.");
        } catch (TallerMecanicoExcepcion e) {
            throw new RuntimeException(e);
        }
        if (nombre != null && !nombre.isBlank()) encontrado.setNombre(nombre);
        if (telefono != null && !telefono.isBlank()) encontrado.setTelefono(telefono);
        return encontrado;
    }
}
