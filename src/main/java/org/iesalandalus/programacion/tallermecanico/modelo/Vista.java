package org.iesalandalus.programacion.tallermecanico.modelo;

import java.time.LocalDate;

public class Vista {

    private Consola consola;
    // Este atributo se conecta con el controlador (aún no existe)
    private Object controlador;

    // Constructor
    public Vista() {
        consola = new Consola();
    }

    // Asignar controlador
    public void setControlador(Object controlador) {
        if (controlador != null) {
            this.controlador = controlador;
        }
    }

    // Comenzar la vista
    public void comenzar() {
        Opcion opcion;
        do {
            consola.mostrarMenu();
            opcion = consola.elegirOpcion();
            ejecutar(opcion);
        } while (opcion != Opcion.SALIR);
    }

    // Terminar
    public void terminar() {
        consola.mostrarMensaje("Gracias por usar la aplicación. Hasta luego!");
    }

    // Ejecutar opción
    public void ejecutar(Opcion opcion) {
        switch (opcion) {
            case INSERTAR_CLIENTE -> opcionInsertarCliente();
            case BUSCAR_CLIENTE -> opcionBuscarCliente();
            case MODIFICAR_CLIENTE -> opcionModificarCliente();
            case BORRAR_CLIENTE -> opcionBorrarCliente();

            case INSERTAR_VEHICULO -> opcionInsertarVehiculo();
            case BUSCAR_VEHICULO -> opcionBuscarVehiculo();
            case BORRAR_VEHICULO -> opcionBorrarVehiculo();

            case INSERTAR_REVISION -> opcionInsertarRevision();
            case BUSCAR_REVISION -> opcionBuscarRevision();
            case ANADIR_HORAS -> opcionAnadirHoras();
            case ANADIR_MATERIAL -> opcionAnadirMaterial();
            case CERRAR_REVISION -> opcionCerrarRevision();
            case BORRAR_REVISION -> opcionBorrarRevision();

            case SALIR -> terminar();
        }
    }

    // ---------------- OPCIONES CLIENTE ----------------

    private void opcionInsertarCliente() {
        consola.mostrarCabecera("Insertar Cliente");
        try {
            String nombre = consola.leerCadena("Nombre");
            String dni = consola.leerCadena("DNI");
            String telefono = consola.leerCadena("Teléfono");

            // controlador.insertarCliente(...) -> aquí llamaría al método real
            consola.mostrarMensaje("Cliente insertado correctamente (simulado)");
        } catch (Exception e) {
            consola.mostrarMensaje("Error al insertar cliente: " + e.getMessage());
        }
    }

    private void opcionBuscarCliente() {
        consola.mostrarCabecera("Buscar Cliente");
        try {
            String dni = consola.leerCadena("DNI");
            // controlador.buscarCliente(dni)
            consola.mostrarMensaje("Cliente encontrado (simulado)");
        } catch (Exception e) {
            consola.mostrarMensaje("Error al buscar cliente: " + e.getMessage());
        }
    }

    private void opcionModificarCliente() {
        consola.mostrarCabecera("Modificar Cliente");
        try {
            String dni = consola.leerCadena("DNI");
            String nombre = consola.leerCadena("Nuevo nombre (dejar vacío para no cambiar)");
            String telefono = consola.leerCadena("Nuevo teléfono (dejar vacío para no cambiar)");
            // controlador.modificarCliente(dni, nombre, telefono)
            consola.mostrarMensaje("Cliente modificado correctamente (simulado)");
        } catch (Exception e) {
            consola.mostrarMensaje("Error al modificar cliente: " + e.getMessage());
        }
    }

    private void opcionBorrarCliente() {
        consola.mostrarCabecera("Borrar Cliente");
        try {
            String dni = consola.leerCadena("DNI");
            // controlador.borrarCliente(dni)
            consola.mostrarMensaje("Cliente borrado correctamente (simulado)");
        } catch (Exception e) {
            consola.mostrarMensaje("Error al borrar cliente: " + e.getMessage());
        }
    }

    // ---------------- OPCIONES VEHÍCULO ----------------

    private void opcionInsertarVehiculo() {
        consola.mostrarCabecera("Insertar Vehículo");
        try {
            String marca = consola.leerCadena("Marca");
            String modelo = consola.leerCadena("Modelo");
            String matricula = consola.leerCadena("Matrícula");
            // controlador.insertarVehiculo(...)
            consola.mostrarMensaje("Vehículo insertado correctamente (simulado)");
        } catch (Exception e) {
            consola.mostrarMensaje("Error al insertar vehículo: " + e.getMessage());
        }
    }

    private void opcionBuscarVehiculo() {
        consola.mostrarCabecera("Buscar Vehículo");
        try {
            String matricula = consola.leerCadena("Matrícula");
            // controlador.buscarVehiculo(matricula)
            consola.mostrarMensaje("Vehículo encontrado (simulado)");
        } catch (Exception e) {
            consola.mostrarMensaje("Error al buscar vehículo: " + e.getMessage());
        }
    }

    private void opcionBorrarVehiculo() {
        consola.mostrarCabecera("Borrar Vehículo");
        try {
            String matricula = consola.leerCadena("Matrícula");
            // controlador.borrarVehiculo(matricula)
            consola.mostrarMensaje("Vehículo borrado correctamente (simulado)");
        } catch (Exception e) {
            consola.mostrarMensaje("Error al borrar vehículo: " + e.getMessage());
        }
    }

    // ---------------- OPCIONES REVISIÓN ----------------

    private void opcionInsertarRevision() {
        consola.mostrarCabecera("Insertar Revisión");
        try {
            String dni = consola.leerCadena("DNI del cliente");
            String matricula = consola.leerCadena("Matrícula del vehículo");
            LocalDate fechaInicio = consola.leerFecha("Fecha de inicio");

            // controlador.insertarRevision(dni, matricula, fechaInicio)
            consola.mostrarMensaje("Revisión insertada correctamente (simulado)");
        } catch (Exception e) {
            consola.mostrarMensaje("Error al insertar revisión: " + e.getMessage());
        }
    }

    private void opcionBuscarRevision() {
        consola.mostrarCabecera("Buscar Revisión");
        try {
            String dni = consola.leerCadena("DNI del cliente");
            String matricula = consola.leerCadena("Matrícula del vehículo");
            LocalDate fechaInicio = consola.leerFecha("Fecha de inicio");

            // controlador.buscarRevision(...)
            consola.mostrarMensaje("Revisión encontrada (simulado)");
        } catch (Exception e) {
            consola.mostrarMensaje("Error al buscar revisión: " + e.getMessage());
        }
    }

    private void opcionAnadirHoras() {
        consola.mostrarCabecera("Añadir Horas a Revisión");
        try {
            // pedir datos similares a buscar revisión
            double horas = consola.leerReal("Horas a añadir");
            // controlador.anadirHoras(...)
            consola.mostrarMensaje("Horas añadidas correctamente (simulado)");
        } catch (Exception e) {
            consola.mostrarMensaje("Error al añadir horas: " + e.getMessage());
        }
    }

    private void opcionAnadirMaterial() {
        consola.mostrarCabecera("Añadir Precio de Material");
        try {
            double precio = consola.leerReal("Precio material a añadir");
            // controlador.anadirPrecioMaterial(...)
            consola.mostrarMensaje("Precio de material añadido correctamente (simulado)");
        } catch (Exception e) {
            consola.mostrarMensaje("Error al añadir material: " + e.getMessage());
        }
    }

    private void opcionCerrarRevision() {
        consola.mostrarCabecera("Cerrar Revisión");
        try {
            LocalDate fechaFin = consola.leerFecha("Fecha de fin");
            // controlador.cerrarRevision(...)
            consola.mostrarMensaje("Revisión cerrada correctamente (simulado)");
        } catch (Exception e) {
            consola.mostrarMensaje("Error al cerrar revisión: " + e.getMessage());
        }
    }

    private void opcionBorrarRevision() {
        consola.mostrarCabecera("Borrar Revisión");
        try {
            // pedir datos similares a buscar revisión
            // controlador.borrarRevision(...)
            consola.mostrarMensaje("Revisión borrada correctamente (simulado)");
        } catch (Exception e) {
            consola.mostrarMensaje("Error al borrar revisión: " + e.getMessage());
        }
    }
}
