package Punto2;

import java.util.ArrayList;
import java.util.List;

public class Tienda {
    private List<Cliente> clientes;
    private List<Producto> productos;
    private List<Venta> ventas;

    public Tienda() {
        this.clientes = new ArrayList<>();
        this.productos = new ArrayList<>();
        this.ventas = new ArrayList<>();
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void registrarVenta(Venta venta) {
        ventas.add(venta);
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    // 1. Ventas donde el nombre del cliente contiene dos veces la letra "r" (mayuscula o minuscula)
    public List<Venta> ventasClienteConDosR() {
        List<Venta> resultado = new ArrayList<>();

        for (Venta venta : ventas) {
            // Obtenemos solo el primer nombre del cliente (antes del primer espacio)
            String nombreCompleto = venta.getCliente().getNombre();
            String primerNombre = nombreCompleto.contains(" ") ?
                    nombreCompleto.substring(0, nombreCompleto.indexOf(" ")) :
                    nombreCompleto;

            // Convertimos a minúscula para comparar sin importar el caso
            String nombreMinuscula = primerNombre.toLowerCase();
            int contador = 0;

            for (int i = 0; i < nombreMinuscula.length(); i++) {
                if (nombreMinuscula.charAt(i) == 'r') {
                    contador++;
                }
            }

            if (contador >= 2) {
                // Verificamos que no hayamos agregado ya una venta con este cliente
                boolean yaExiste = false;
                for (Venta v : resultado) {
                    if (v.getCliente().getNombre().equals(venta.getCliente().getNombre())) {
                        yaExiste = true;
                        break;
                    }
                }

                if (!yaExiste) {
                    resultado.add(venta);
                }
            }
        }

        return resultado;
    }

    // 2. Productos con stock menor a un valor
    public List<Producto> productosStockMenorA(int valor) {
        List<Producto> resultado = new ArrayList<>();

        for (Producto i : productos) {
            if (i.getStock() < valor) {
                resultado.add(i);
            }
        }

        return resultado;
    }

    // 3. Clientes con mas de una compra
    public List<Cliente> clientesConMasDeUnaCompra() {
        List<Cliente> resultado = new ArrayList<>();

        for (Cliente cliente : clientes) {
            int contador = 0;

            for (Venta venta : ventas) {
                if (venta.getCliente().getNombre().equals(cliente.getNombre())) {
                    contador++;
                }
            }

            if (contador > 1 && !resultado.contains(cliente)) {
                resultado.add(cliente);
            }
        }

        return resultado;
    }

    // 4. Ventas entre dos fechas (usando String)
    public List<Venta> ventasEntreFechas(String fechaInicio, String fechaFin) {
        List<Venta> resultado = new ArrayList<>();

        // Convertimos las fechas a formato comparable (asumiendo formato dd/MM/yyyy)
        for (Venta venta : ventas) {
            String fechaVenta = venta.getFecha();

            // Comparacion simple de strings en formato dd/MM/yyyy
            // Este formato permite comparación lexicografica directa
            if (fechaVenta.compareTo(fechaInicio) >= 0 && fechaVenta.compareTo(fechaFin) <= 0) {
                resultado.add(venta);
            }
        }

        return resultado;
    }

    // 5. Nombre mas largo entre clientes (solo primer nombre)
    public String nombreClienteMasLargo() {
        String nombreMasLargo = "";

        for (Cliente cliente : clientes) {
            // Obtenemos solo el primer nombre
            String nombreCompleto = cliente.getNombre();
            String primerNombre = nombreCompleto.contains(" ") ?
                    nombreCompleto.substring(0, nombreCompleto.indexOf(" ")) :
                    nombreCompleto;

            if (primerNombre.length() > nombreMasLargo.length()) {
                nombreMasLargo = primerNombre;
            }
        }

        return nombreMasLargo;
    }

    // 6. Nombres de clientes palindromos
    public List<String> nombresClientesPalindromos() {
        List<String> resultado = new ArrayList<>();

        for (Cliente cliente : clientes) {
            String nombre = cliente.getNombre().toLowerCase();
            if (nombre.equals(new StringBuilder(nombre).reverse().toString())) {
                resultado.add(cliente.getNombre());
            }
        }

        return resultado;
    }

    // 7. Ventas con monto mayor a una cantidad
    public List<Venta> ventasConMontoMayorA(double monto) {
        List<Venta> resultado = new ArrayList<>();

        for (Venta venta : ventas) {
            if (venta.calcularMontoTotal() > monto) {
                resultado.add(venta);
            }
        }

        return resultado;
    }

    // 8. Clientes con correo de dominio especifico
    public List<Cliente> clientesConDominio(String dominio) {
        List<Cliente> resultado = new ArrayList<>();

        for (Cliente cliente : clientes) {
            if (cliente.getCorreo().endsWith(dominio)) {
                resultado.add(cliente);
            }
        }

        return resultado;
    }

    // 9. Ventas con productos de categoria especifica
    public List<Venta> ventasConCategoria(String categoria) {
        List<Venta> resultado = new ArrayList<>();

        for (Venta venta : ventas) {
            boolean tieneCategoria = false;

            for (Producto producto : venta.getProductos()) {
                if (producto.getCategoria().equalsIgnoreCase(categoria)) {
                    tieneCategoria = true;
                     break;
                }
            }

            if (tieneCategoria) {
                resultado.add(venta);
            }
        }

        return resultado;
    }
}
