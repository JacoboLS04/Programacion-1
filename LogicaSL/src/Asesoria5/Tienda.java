package Asesoria5;

import java.util.ArrayList;
import java.util.List;

public class Tienda {
    private String nombre;
    private String nit;
    private List<Cliente> listaClientes;
    private List<Producto> listaProductos;
    private List<Venta> listaVentas;

    // Constructor
    public Tienda(String nombre, String nit) {
        this.nombre = nombre;
        this.nit = nit;
        this.listaClientes = new ArrayList<>();
        this.listaProductos = new ArrayList<>();
        this.listaVentas = new ArrayList<>();
    }

    // Métodos para gestionar clientes
    public void agregarCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }

    public Cliente buscarClientePorIdentificacion(String identificacion) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getIdentificacion().equals(identificacion)) {
                return cliente;
            }
        }
        return null;
    }

    // Métodos para gestionar productos
    public void agregarProducto(Producto producto) {
        listaProductos.add(producto);
    }

    public Producto buscarProductoPorCodigo(String codigo) {
        for (Producto producto : listaProductos) {
            if (producto.getCodigo().equals(codigo)) {
                return producto;
            }
        }
        return null;
    }

    // Métodos para gestionar ventas
    public void registrarVenta(Venta venta) {
        listaVentas.add(venta);
    }

    public List<Venta> obtenerVentasPorCliente(Cliente cliente) {
        List<Venta> ventasCliente = new ArrayList<>();
        for (Venta venta : listaVentas) {
            if (venta.getCliente().getIdentificacion().equals(cliente.getIdentificacion())) {
                ventasCliente.add(venta);
            }
        }
        return ventasCliente;
    }

    /**
     * Método que retorna los clientes que hayan realizado la compra de más de 20 productos tipo leche
     * @return Lista de clientes que cumplen con la condición
     */
    public List<Cliente> obtenerClientesComprasMasDe20ProductosLeche() {
        List<Cliente> clientesResultado = new ArrayList<>();

        // Paso 1: Recorremos todos los clientes
        for (Cliente cliente : listaClientes) {
            int totalProductosLeche = 0;

            // Paso 2: Para cada cliente, accedemos a sus ventas
            List<Venta> ventasCliente = obtenerVentasPorCliente(cliente);

            for (Venta venta : ventasCliente) {

                // Paso 3: Para cada venta, accedemos a sus detalles
                List<DetalleVenta> detallesVenta = venta.getListaDetallesVenta();

                for (DetalleVenta detalle : detallesVenta) {

                    // Paso 4: Verificamos si el producto del detalle es de tipo "leche"
                    if (detalle.getProductoComprado().getCategoria().equalsIgnoreCase("leche")) {
                        // Sumamos la cantidad de productos de tipo leche
                        totalProductosLeche += detalle.getCantidad();
                    }
                }
            }

            // Si el cliente compró más de 20 productos de leche, lo agregamos a la lista resultado
            if (totalProductosLeche > 20) {
                clientesResultado.add(cliente);
                System.out.println("Cliente " + cliente.getNombres() + " " + cliente.getApellidos() +
                        " compró " + totalProductosLeche + " productos de leche");
            }
        }

        return clientesResultado;
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getNit() { return nit; }
    public List<Cliente> getListaClientes() { return listaClientes; }
    public List<Producto> getListaProductos() { return listaProductos; }
    public List<Venta> getListaVentas() { return listaVentas; }
}
