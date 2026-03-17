package org.iesalandalus.programacion.tallermecanico.modelo;

import org.iesalandalus.programacion.tallermecanico.modelo.dominio.TallerMecanicoExcepcion;

import java.util.HashMap;
import java.util.Map;

public enum Opcion {

    INSERTAR_CLIENTE(1, "Insertar cliente"),
    BUSCAR_CLIENTE(2, "Buscar cliente"),
    MODIFICAR_CLIENTE(3, "Modificar cliente"),
    BORRAR_CLIENTE(4, "Borrar cliente"),

    INSERTAR_VEHICULO(5, "Insertar vehículo"),
    BUSCAR_VEHICULO(6, "Buscar vehículo"),
    BORRAR_VEHICULO(7, "Borrar vehículo"),

    INSERTAR_REVISION(8, "Insertar revisión"),
    BUSCAR_REVISION(9, "Buscar revisión"),
    ANADIR_HORAS(10, "Añadir horas"),
    ANADIR_MATERIAL(11, "Añadir precio material"),
    CERRAR_REVISION(12, "Cerrar revisión"),
    BORRAR_REVISION(13, "Borrar revisión"),

    SALIR(0, "Salir");

    private int numero;
    private String texto;

    private static Map<Integer, Opcion> mapa = new HashMap<>();

    // Inicialización del mapa
    static {
        for (Opcion opcion : Opcion.values()) {
            mapa.put(opcion.numero, opcion);
        }
    }

    // Constructor
    private Opcion(int numero, String texto) {
        this.numero = numero;
        this.texto = texto;
    }

    // Método para comprobar si es válida
    public static boolean esValida(int numero) {
        return mapa.containsKey(numero);
    }

    // Obtener opción
    public static Opcion get(int numero) throws TallerMecanicoExcepcion {
        if (!esValida(numero)) {
            throw new TallerMecanicoExcepcion("Opción no válida");
        }
        return mapa.get(numero);
    }

    // toString
    @Override
    public String toString() {
        return String.format("%d.- %s", numero, texto);
    }
}
