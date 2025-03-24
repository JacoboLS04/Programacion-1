package Punto2;

class Producto {
    private String nombre;
    private String codigo;
    private double precio;
    private String categoria;
    private int stock;

    public Producto(String nombre, String codigo, double precio, String categoria, int stock) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.precio = precio;
        this.categoria = categoria;
        this.stock = stock;
    }

    // Getters y setters
    public String getNombre() { return nombre; }
    public String getCodigo() { return codigo; }
    public double getPrecio() { return precio; }
    public String getCategoria() { return categoria; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    @Override
    public String toString() {
        return "Producto{" + "nombre='" + nombre + "', codigo='" + codigo +
                "', precio=" + precio + ", stock=" + stock + "}";
    }
}
