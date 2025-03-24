package Punto2;

public class SistemaTienda {
    public static void main(String[] args) {
        // Crear una tienda
        Tienda tienda = new Tienda("Mi Tienda", "123456789");

        // Crear algunos clientes
        Cliente cliente1 = new Cliente("Juan", "Pérez", "1001", "3001234567", "juan@email.com");
        Cliente cliente2 = new Cliente("María", "García", "1002", "3007654321", "maria@email.com");
        Cliente cliente3 = new Cliente("Carlos", "Rodríguez", "1003", "3009876543", "carlos@email.com");

        // Agregar clientes a la tienda
        tienda.agregarCliente(cliente1);
        tienda.agregarCliente(cliente2);
        tienda.agregarCliente(cliente3);

        // Crear algunos productos
        Producto producto1 = new Producto("Huevos", "P001", 500.0, "Alimentos", 30);
        Producto producto2 = new Producto("Leche", "P002", 3000.0, "Lácteos", 15);
        Producto producto3 = new Producto("Pan", "P003", 2000.0, "Panadería", 50);
        Producto producto4 = new Producto("Arroz", "P004", 4000.0, "Granos", 25);

        // Agregar productos a la tienda
        tienda.agregarProducto(producto1);
        tienda.agregarProducto(producto2);
        tienda.agregarProducto(producto3);
        tienda.agregarProducto(producto4);

        // Crear ventas
        // Venta 1: Cliente 1 compra 5 huevos en 03-12-2025
        Venta venta1 = new Venta("03-12-2025", cliente1);
        venta1.agregarDetalleVenta(new DetalleVenta(producto1, 5));
        tienda.agregarVenta(venta1);

        // Venta 2: Cliente 2 compra leche y pan en 04-12-2025
        Venta venta2 = new Venta("04-12-2025", cliente2);
        venta2.agregarDetalleVenta(new DetalleVenta(producto2, 2));
        venta2.agregarDetalleVenta(new DetalleVenta(producto3, 3));
        tienda.agregarVenta(venta2);

        // Venta 3: Cliente 3 compra arroz en 03-12-2025
        Venta venta3 = new Venta("03-12-2025", cliente3);
        venta3.agregarDetalleVenta(new DetalleVenta(producto4, 2));
        tienda.agregarVenta(venta3);

        // Venta 4: Cliente 2 compra huevos en 03-12-2025
        Venta venta4 = new Venta("03-12-2025", cliente2);
        venta4.agregarDetalleVenta(new DetalleVenta(producto1, 5));
        tienda.agregarVenta(venta4);

        // Prueba del método A: Clientes con factura en fecha 03-12-2025
        System.out.println("A. Clientes con factura en fecha 03-12-2025:");
        java.util.List<Cliente> clientesConFactura = tienda.obtenerClientesConFacturaEnFecha("03-12-2025");
        for (Cliente cliente : clientesConFactura) {
            System.out.println(cliente);
        }

        // Prueba del método B: Productos con stock entre 20 y 55
        System.out.println("\nB. Productos con stock entre 20 y 55:");
        java.util.List<Producto> productosEnRango = tienda.obtenerProductosConStockEntre(20, 55);
        for (Producto producto : productosEnRango) {
            System.out.println(producto);
        }

        // Prueba del método C: Clientes que compraron 5 huevos
        System.out.println("\nC. Clientes que compraron 5 huevos:");
        java.util.List<Cliente> clientesQueCompraronHuevos = tienda.obtenerClientesQueCompraronProductoEspecifico("Huevos", 5);
        for (Cliente cliente : clientesQueCompraronHuevos) {
            System.out.println(cliente);
        }
    }
}
