package Asesoria5;

public class DetalleVenta {
    private int cantidad;
    private double subTotal;
    private Producto productoComprado;

    // Constructor
    public DetalleVenta(int cantidad, Producto productoComprado) {
        this.cantidad = cantidad;
        this.productoComprado = productoComprado;
        this.subTotal = cantidad * productoComprado.getPrecio();
    }

    // Getters y setters
    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        this.subTotal = cantidad * productoComprado.getPrecio();
    }

    public double getSubTotal() { return subTotal; }

    public Producto getProductoComprado() { return productoComprado; }
    public void setProductoComprado(Producto productoComprado) {
        this.productoComprado = productoComprado;
        this.subTotal = cantidad * productoComprado.getPrecio();
    }
}
