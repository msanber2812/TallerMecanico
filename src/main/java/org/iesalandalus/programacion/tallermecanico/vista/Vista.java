package org.iesalandalus.programacion.tallermecanico.vista;

import org.iesalandalus.programacion.tallermecanico.controlador.Controlador;

import java.time.LocalDate;
import java.util.Objects;

public class Vista {

    private Controlador controlador;

    public void setControlador(Object controlador) {
        Objects.requireNonNull(controlador, "ERROR: El controlador no puede ser nulo.");
        this.controlador = controlador;
    }

    public void comenzar() {
        Opcion opcion;
        do {
            Consola.mostrarMenu();
            opcion = Consola.elegirOpcion();
            ejecutar(opcion);
        } while (opcion != Opcion.SALIR);
        controlador.terminar();
    }

    public void terminar() {
        System.out.println("Hasta luego Lucasssss!!!");
    }


    public void ejecutar(Opcion opcion) {
        try {
            switch (opcion) {
                case INSERTAR_CLIENTE -> insertarCliente();
                case BUSCAR_CLIENTE -> buscarCliente();
                case MODIFICAR_CLIENTE -> opcionModificarCliente();
                case BORRAR_CLIENTE -> opcionBorrarCliente();

                case INSERTAR_VEHICULO -> insertarVehiculo();
                case BUSCAR_VEHICULO -> buscarVehiculo();
                case BORRAR_VEHICULO -> borrarVehiculo();

                case INSERTAR_REVISION -> insertarRevision();
                case BUSCAR_REVISION -> buscarRevision();
                case ANADIR_HORAS_REVISION -> anadirHoras();
                case ANADIR_PRECIO_MATERIAL_REVISION -> opcionAnadirMaterial();
                case CERRAR_REVISION -> cerrarRevision();
                case BORRAR_REVISION -> opcionBorrarRevision();

                case SALIR -> terminar();
            }
        }
    }



    private void opcionInsertarCliente() {
        consola.mostrarCabecera("Insertar Cliente");
        try {
            String nombre = consola.leerCadena("Nombre");
            String dni = consola.leerCadena("DNI");
            String telefono = consola.leerCadena("Teléfono");


            consola.mostrarMensaje("Cliente insertado correctamente (simulado)");
        } catch (Exception e) {
            consola.mostrarMensaje("Error al insertar cliente: " + e.getMessage());
        }
    }

    private void opcionBuscarCliente() {
        consola.mostrarCabecera("Buscar Cliente");
        try {
            String dni = consola.leerCadena("DNI");

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



    private void opcionInsertarVehiculo() {
        consola.mostrarCabecera("Insertar Vehículo");
        try {
            String marca = consola.leerCadena("Marca");
            String modelo = consola.leerCadena("Modelo");
            String matricula = consola.leerCadena("Matrícula");

            consola.mostrarMensaje("Vehículo insertado correctamente (simulado)");
        } catch (Exception e) {
            consola.mostrarMensaje("Error al insertar vehículo: " + e.getMessage());
        }
    }

    private void opcionBuscarVehiculo() {
        consola.mostrarCabecera("Buscar Vehículo");
        try {
            String matricula = consola.leerCadena("Matrícula");

            consola.mostrarMensaje("Vehículo encontrado (simulado)");
        } catch (Exception e) {
            consola.mostrarMensaje("Error al buscar vehículo: " + e.getMessage());
        }
    }

    private void opcionBorrarVehiculo() {
        consola.mostrarCabecera("Borrar Vehículo");
        try {
            String matricula = consola.leerCadena("Matrícula");

            consola.mostrarMensaje("Vehículo borrado correctamente (simulado)");
        } catch (Exception e) {
            consola.mostrarMensaje("Error al borrar vehículo: " + e.getMessage());
        }
    }



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


            consola.mostrarMensaje("Revisión encontrada (simulado)");
        } catch (Exception e) {
            consola.mostrarMensaje("Error al buscar revisión: " + e.getMessage());
        }
    }

    private void opcionAnadirHoras() {
        consola.mostrarCabecera("Añadir Horas a Revisión");
        try {

            double horas = consola.leerReal("Horas a añadir");

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
