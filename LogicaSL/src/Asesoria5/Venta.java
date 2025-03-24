package Asesoria5;

import java.util.ArrayList;
import java.util.List;

public class Venta {
    private String fecha;
    private double total;
    private Cliente cliente;
    private List<DetalleVenta> listaDetallesVenta;

    // Constructor
    public Venta(String fecha, Cliente cliente) {
        this.fecha = fecha;
        this.cliente = cliente;
        this.listaDetallesVenta = new ArrayList<>();
        this.total = 0.0;
    }

    // Métodos para gestionar detalles de venta
    public void agregarDetalle(DetalleVenta detalle) {
        listaDetallesVenta.add(detalle);
        calcularTotal();
    }

    private void calcularTotal() {
        total = 0.0;
        for (DetalleVenta detalle : listaDetallesVenta) {
            total += detalle.getSubTotal();
        }
    }

    // Getters y setters
    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public double getTotal() { return total; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public List<DetalleVenta> getListaDetallesVenta() { return listaDetallesVenta; }
}
