package org.iesalandalus.programacion.tallermecanico.vista;

import org.iesalandalus.programacion.tallermecanico.modelo.TallerMecanicoExcepcion;

import java.util.HashMap;
import java.util.Map;

public enum Opcion {

    INSERTAR_CLIENTE(1, "Insertar cliente"),
    BUSCAR_CLIENTE(2, "Buscar cliente"),
    MODIFICAR_CLIENTE(3, "Modificar cliente"),
    BORRAR_CLIENTE(4, "Borrar cliente"),
    LISTAR_CLIENTES(14, "Listar clientes."),

    INSERTAR_VEHICULO(5, "Insertar vehículo"),
    BUSCAR_VEHICULO(6, "Buscar vehículo"),
    BORRAR_VEHICULO(7, "Borrar vehículo"),
    LISTAR_VEHICULO(24, "Listar vehículos."),

    INSERTAR_REVISION(8, "Insertar revisión"),
    BUSCAR_REVISION(9, "Buscar revisión"),
    ANADIR_HORAS_REVISION(10, "Añadir horas"),
    ANADIR_PRECIO_MATERIAL_REVISION(11, "Añadir precio material"),
    CERRAR_REVISION(12, "Cerrar revisión"),
    BORRAR_REVISION(13, "Borrar revisión"),
    LISTAR_REVISIONES(34, "Listar revisiones"),
    LISTAR_REVISIONES_CLIENTE(35, "Liistar revisiones de un cliente."),
    LISTAR_REVISIONES_VEHICULO(36, "Listar revisiones de un vehiculo."),

    SALIR(0, "Salir");

    private final int numeroOpcion;
    private final String texto;
    private static Map<Integer, Opcion> opciones = new HashMap<>();

    static {
        for (Opcion opcion : values()) {
            opciones.put(opcion.numeroOpcion, opcion);
        }
    }

    private Opcion(int numeroOpcion, String texto) {
        this.numeroOpcion = numeroOpcion;
        this.texto = texto;
    }

    public static boolean esValida(int numeroOpcion) {
        return opciones.containsKey(numeroOpcion);
    }


    public static Opcion get(int numeroOpcion) throws TallerMecanicoExcepcion {
        if (!esValida(numeroOpcion)) {
            throw new TallerMecanicoExcepcion("Opción no válida");
        }
        return opciones.get(numeroOpcion);
    }

    @Override
    public String toString() {
        return String.format("%d.- %s", numeroOpcion, texto);
    }
}
