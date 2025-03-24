package Punto2;

class DetalleVenta {
    private Producto productoComprado;
    private int cantidad;
    private double subTotal;

    public DetalleVenta(Producto productoComprado, int cantidad) {
        this.productoComprado = productoComprado;
        this.cantidad = cantidad;
        this.subTotal = cantidad * productoComprado.getPrecio();
    }

    // Getters
    public Producto getProductoComprado() { return productoComprado; }
    public int getCantidad() { return cantidad; }
    public double getSubTotal() { return subTotal; }
}
