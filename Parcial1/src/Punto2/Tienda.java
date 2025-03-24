package Punto2;

class Tienda {
    private String nombre;
    private String nit;
    private java.util.List<Cliente> listaClientes;
    private java.util.List<Venta> listaVentas;
    private java.util.List<Producto> listaProductos;

    public Tienda(String nombre, String nit) {
        this.nombre = nombre;
        this.nit = nit;
        this.listaClientes = new java.util.ArrayList<>();
        this.listaVentas = new java.util.ArrayList<>();
        this.listaProductos = new java.util.ArrayList<>();
    }

    // Métodos para agregar elementos
    public void agregarCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }

    public void agregarVenta(Venta venta) {
        listaVentas.add(venta);
    }

    public void agregarProducto(Producto producto) {
        listaProductos.add(producto);
    }

    // A. Método para obtener clientes con al menos una factura en fecha específica
    public java.util.List<Cliente> obtenerClientesConFacturaEnFecha(String fecha) {
        java.util.List<Cliente> clientesConFactura = new java.util.ArrayList<>();

        for (Venta venta : listaVentas) {
            if (venta.getFecha().equals(fecha)) {
                Cliente cliente = venta.getCliente();
                if (!clientesConFactura.contains(cliente)) {
                    clientesConFactura.add(cliente);
                }
            }
        }

        return clientesConFactura;
    }

    // B. Método para obtener productos con stock entre 20 y 55
    public java.util.List<Producto> obtenerProductosConStockEntre(int min, int max) {
        java.util.List<Producto> productosEnRango = new java.util.ArrayList<>();

        for (Producto producto : listaProductos) {
            if (producto.getStock() >= min && producto.getStock() <= max) {
                productosEnRango.add(producto);
            }
        }

        return productosEnRango;
    }

    // C. Método para obtener clientes que compraron 5 huevos
    public java.util.List<Cliente> obtenerClientesQueCompraronProductoEspecifico(String nombreProducto, int cantidad) {
        java.util.List<Cliente> clientesQueCompraronProducto = new java.util.ArrayList<>();

        for (Venta venta : listaVentas) {
            boolean encontrado = false;

            for (DetalleVenta detalle : venta.getListaDetallesVenta()) {
                if (detalle.getProductoComprado().getNombre().equals(nombreProducto) &&
                        detalle.getCantidad() == cantidad) {
                    encontrado = true;
                    break;
                }
            }

            if (encontrado && !clientesQueCompraronProducto.contains(venta.getCliente())) {
                clientesQueCompraronProducto.add(venta.getCliente());
            }
        }

        return clientesQueCompraronProducto;
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getNit() { return nit; }
    public java.util.List<Cliente> getListaClientes() { return listaClientes; }
    public java.util.List<Venta> getListaVentas() { return listaVentas; }
    public java.util.List<Producto> getListaProductos() { return listaProductos; }
}