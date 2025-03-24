package Punto2;

class Venta {
    private String fecha;
    private double total;
    private Cliente cliente;
    private java.util.List<DetalleVenta> listaDetallesVenta;

    public Venta(String fecha, Cliente cliente) {
        this.fecha = fecha;
        this.cliente = cliente;
        this.total = 0.0;
        this.listaDetallesVenta = new java.util.ArrayList<>();
    }

    // Métodos para gestionar detalles de venta
    public void agregarDetalleVenta(DetalleVenta detalle) {
        listaDetallesVenta.add(detalle);
        total += detalle.getSubTotal();
    }

    // Getters
    public String getFecha() { return fecha; }
    public double getTotal() { return total; }
    public Cliente getCliente() { return cliente; }
    public java.util.List<DetalleVenta> getListaDetallesVenta() { return listaDetallesVenta; }
}
