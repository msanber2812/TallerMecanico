package org.iesalandalus.programacion.tallermecanico.vista;

import org.iesalandalus.programacion.tallermecanico.controlador.Controlador;
import org.iesalandalus.programacion.tallermecanico.modelo.TallerMecanicoExcepcion;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Cliente;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Revision;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Vehiculo;

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
                case MODIFICAR_CLIENTE -> ModificarCliente();
                case BORRAR_CLIENTE -> borrarCliente();

                case INSERTAR_VEHICULO -> insertarVehiculo();
                case BUSCAR_VEHICULO -> buscarVehiculo();
                case BORRAR_VEHICULO -> borrarVehiculo();

                case INSERTAR_REVISION -> insertarRevision();
                case BUSCAR_REVISION -> buscarRevision();
                case ANADIR_HORAS_REVISION -> anadirHoras();
                case ANADIR_PRECIO_MATERIAL_REVISION -> anadirMaterial();
                case CERRAR_REVISION -> cerrarRevision();
                case BORRAR_REVISION -> borrarRevision();

                case SALIR -> terminar();
            }
        }catch (Exception e) {
            System.out.printf("ERROR: %s%n", e.getMessage());
        }
    }



    private void insertarCliente() throws TallerMecanicoExcepcion {
        Consola.mostrarCabecera("Insertar Cliente");
        controlador.insertar(Consola.leerCliente());
        System.out.println("Cliente insertado correctamente.");
    }

    private void buscarCliente() {
        Consola.mostrarCabecera("Buscar Cliente");
        Cliente cliente = controlador.buscar (Consola.leerClienteDni());
        System.out.println((cliente !=null) ? cliente : "No existe ningun cliente con dicho DNI. ");
    }

    private void ModificarCliente() throws TallerMecanicoExcepcion {
        Consola.mostrarCabecera("Modificar Cliente");
        controlador.modificar(Consola.leerClienteDni(), Consola.leerNuevoNombre(), Consola.leerNuevoTelefono());
        System.out.println("El cliente se ha modificado correctamente. ");
    }

    private void anadirHoras() throws TallerMecanicoExcepcion {
        Consola.mostrarCabecera("Añadir horas Revision");
        controlador.añadirHoras(Consola.leerRevision(), Consola.leerHoras());
        System.out.println("Horas añadidas correctamente. ");
    }

    private void borrarRevision() throws TallerMecanicoExcepcion {
        Consola.mostrarCabecera("Borrar Revision");
        controlador.borrar(Consola.leerRevision());
        System.out.println("Revision borrada correctamente. ");
    }



    private void insertarVehiculo() {
        Consola.mostrarCabecera("Insertar Vehículo");
        controlador.insertar(Consola.leerVehiculo());
        System.out.println("Vehiculo insertado correctamente.");
    }

    private void buscarVehiculo() {
        Consola.mostrarCabecera("Buscar Vehículo");
        Vehiculo vehiculo = controlador.buscar(Consola.leerVehiculoMatricula());
        System.out.println((vehiculo != null) ? vehiculo : "No existe ningun vehiculo con dicha matricula. ");
    }

    private void borrarVehiculo() throws TallerMecanicoExcepcion {
        Consola.mostrarCabecera("Borrar Vehículo");
        controlador.borrar(Consola.leerVehiculoMatricula());
        System.out.println("Vehiculo borrado correctamente. ");
    }



    private void insertarRevision() throws TallerMecanicoExcepcion {
        Consola.mostrarCabecera("Insertar Revisión");
       controlador.insertar(Consola.leerRevision());
       System.out.println("Revision insertada correctamente.");
    }

    private void buscarRevision() {
        Consola.mostrarCabecera("Buscar Revisión");
        Revision revision = controlador.buscar(Consola.leerRevision());
        System.out.println((revision != null) ? revision : "No existe ninguna revision para ese cliente. ");
    }


    private void anadirMaterial() {
        Consola.mostrarCabecera("Añadir Precio de Material");
        controlador.anadirHoras(Consola.leerRevision(), Consola.leerPrecioMaterial());
        System.out.println("Precio material añadido correctamente. ");

    }

    private void cerrarRevision() {
        Consola.mostrarCabecera("Cerrar Revisión");
       controlador.cerrar(Consola.leerRevision(), Consola.leerFechaCierre());
       System.out.println("Revisión cerrada correctamente. ");
    }

    private void borrarCliente() {
        Consola.mostrarCabecera("Borrar Revisión");
        controlador.borrar(Consola.leerClienteDni());
        System.out.println("Cliente borrado correctamente. ");
    }
}
