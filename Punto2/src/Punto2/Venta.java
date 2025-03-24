package Punto2;

import java.util.ArrayList;
import java.util.List;

public class Venta {
    private Cliente cliente;
    private String fecha;  // Cambiado a String
    private List<Producto> productos;

    public Venta(Cliente cliente, String fecha) {
        this.cliente = cliente;
        this.fecha = fecha;
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getFecha() {  // Cambiado a String
        return fecha;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public double calcularMontoTotal() {
        double total = 0;
        for (Producto producto : productos) {
            total += producto.getPrecio();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Venta{" + "cliente=" + cliente + ", fecha=" + fecha + ", productos=" + productos + ", total=" + calcularMontoTotal() + '}';
    }
}