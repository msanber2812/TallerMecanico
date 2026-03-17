package org.iesalandalus.programacion.tallermecanico.modelo;

import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Cliente;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.TallerMecanicoExcepcion;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Revision {

    public static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private Cliente cliente;
    private Vehiculo vehiculo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private int horas;
    private float precioMaterial;

    // ---------------- CONSTRUCTORES ----------------

    public Revision(Cliente cliente, Vehiculo vehiculo, LocalDate fechaInicio) {
        if (cliente == null) throw new NullPointerException("El cliente no puede ser nulo.");
        if (vehiculo == null) throw new NullPointerException("El vehículo no puede ser nulo.");
        if (fechaInicio == null) throw new NullPointerException("La fecha de inicio no puede ser nula.");
        if (fechaInicio.isAfter(LocalDate.now())) throw new IllegalArgumentException("La fecha de inicio no puede ser futura.");

        this.cliente = new Cliente(cliente); // copia del cliente
        this.vehiculo = vehiculo; // inmutable
        this.fechaInicio = fechaInicio;
        this.fechaFin = null;
        this.horas = 0;
        this.precioMaterial = 0;
    }

    // Constructor copia
    public Revision(Revision revision) {
        if (revision == null) throw new NullPointerException("La revisión no puede ser nula.");
        this.cliente = new Cliente(revision.cliente);
        this.vehiculo = revision.vehiculo;
        this.fechaInicio = revision.fechaInicio;
        this.fechaFin = revision.fechaFin;
        this.horas = revision.horas;
        this.precioMaterial = revision.precioMaterial;
    }

    // ---------------- MÉTODOS DE ACCESO ----------------

    public Cliente getCliente() {
        return cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public int getHoras() {
        return horas;
    }

    public float getPrecioMaterial() {
        return precioMaterial;
    }

    public boolean estaCerrada() {
        return fechaFin != null;
    }

    // ---------------- MÉTODOS DE MODIFICACIÓN ----------------

    public void anadirHoras(int horas) throws TallerMecanicoExcepcion {
        if (estaCerrada())
            throw new TallerMecanicoExcepcion("No se puede añadir horas, ya que la revisión está cerrada.");
        if (horas <= 0)
            throw new IllegalArgumentException("Las horas a añadir deben ser mayores que cero.");
        this.horas += horas;
    }

    public void anadirPrecioMaterial(float precio) throws TallerMecanicoExcepcion {
        if (estaCerrada())
            throw new TallerMecanicoExcepcion("No se puede añadir precio del material, ya que la revisión está cerrada.");
        if (precio <= 0)
            throw new IllegalArgumentException("El precio del material a añadir debe ser mayor que cero.");
        this.precioMaterial += precio;
    }

    public void cerrar(LocalDate fechaFin) throws TallerMecanicoExcepcion {
        if (fechaFin == null)
            throw new NullPointerException("La fecha de fin no puede ser nula.");
        if (estaCerrada())
            throw new TallerMecanicoExcepcion("La revisión ya está cerrada.");
        if (fechaFin.isAfter(LocalDate.now()))
            throw new IllegalArgumentException("La fecha de fin no puede ser futura.");
        if (fechaFin.isBefore(fechaInicio))
            throw new IllegalArgumentException("La fecha de fin no puede ser anterior a la fecha de inicio.");

        this.fechaFin = fechaFin;
    }

    // ---------------- MÉTODO DE CÁLCULO ----------------

    public float getPrecio() {
        // Precio base por hora = 10
        // Coste material = precioMaterial
        // Recargo por día = 10% por cada día desde fechaInicio hasta fechaFin
        int dias = 0;
        if (fechaFin != null && !fechaFin.isBefore(fechaInicio)) {
            dias = (int) (fechaFin.toEpochDay() - fechaInicio.toEpochDay());
        }
        float totalHoras = horas * 10f;
        float totalMaterial = precioMaterial;
        float recargoDias = totalHoras * dias * 0.05f; // 5% por cada día sobre horas
        return totalHoras + totalMaterial + recargoDias;
    }

    // ---------------- EQUALS Y HASHCODE ----------------

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Revision)) return false;
        Revision other = (Revision) obj;
        return cliente.equals(other.cliente) &&
                vehiculo.equals(other.vehiculo) &&
                fechaInicio.equals(other.fechaInicio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cliente, vehiculo, fechaInicio);
    }

    // ---------------- TOSTRING ----------------

    @Override
    public String toString() {
        String fechaFinStr = (fechaFin == null) ? "" : fechaFin.format(FORMATO_FECHA);
        String precioTotalStr = (estaCerrada()) ? String.format(", %.2f € total", getPrecio()) : "";
        return String.format("%s - %s: (%s - %s), %d horas, %.2f € en material%s",
                cliente.toString(),
                vehiculo.toString(),
                fechaInicio.format(FORMATO_FECHA),
                fechaFinStr,
                horas,
                precioMaterial,
                precioTotalStr
        );
    }
}
