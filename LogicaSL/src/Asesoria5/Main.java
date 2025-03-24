package Asesoria5;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear una tienda
        Tienda tienda = new Tienda("SuperMercado XYZ", "123456789");

        // Crear y agregar clientes
        Cliente cliente1 = new Cliente("Juan", "Pérez", "1001", "3001234567", "juan@email.com");
        Cliente cliente2 = new Cliente("María", "Gómez", "1002", "3109876543", "maria@email.com");
        Cliente cliente3 = new Cliente("Carlos", "López", "1003", "3205551234", "carlos@email.com");

        tienda.agregarCliente(cliente1);
        tienda.agregarCliente(cliente2);
        tienda.agregarCliente(cliente3);

        // Crear y agregar productos
        Producto lecheEntera = new Producto("Leche Entera", "L001", 2500.0, "leche", 100);
        Producto lecheDescremada = new Producto("Leche Descremada", "L002", 2700.0, "leche", 80);
        Producto lecheAlmendras = new Producto("Leche de Almendras", "L003", 3500.0, "leche", 50);
        Producto pan = new Producto("Pan", "P001", 1500.0, "panadería", 200);
        Producto arroz = new Producto("Arroz", "A001", 2000.0, "granos", 150);

        tienda.agregarProducto(lecheEntera);
        tienda.agregarProducto(lecheDescremada);
        tienda.agregarProducto(lecheAlmendras);
        tienda.agregarProducto(pan);
        tienda.agregarProducto(arroz);

        // Crear ventas para el cliente1 (comprará más de 20 productos de leche)
        Venta venta1Cliente1 = new Venta("2025-03-01", cliente1);
        venta1Cliente1.agregarDetalle(new DetalleVenta(15, lecheEntera));
        venta1Cliente1.agregarDetalle(new DetalleVenta(2, pan));

        Venta venta2Cliente1 = new Venta("2025-03-10", cliente1);
        venta2Cliente1.agregarDetalle(new DetalleVenta(10, lecheDescremada));
        venta2Cliente1.agregarDetalle(new DetalleVenta(5, arroz));

        tienda.registrarVenta(venta1Cliente1);
        tienda.registrarVenta(venta2Cliente1);

        // Crear ventas para el cliente2 (comprará menos de 20 productos de leche)
        Venta venta1Cliente2 = new Venta("2025-03-05", cliente2);
        venta1Cliente2.agregarDetalle(new DetalleVenta(3, lecheEntera));
        venta1Cliente2.agregarDetalle(new DetalleVenta(10, pan));

        tienda.registrarVenta(venta1Cliente2);

        // Crear ventas para el cliente3 (comprará más de 20 productos de leche)
        Venta venta1Cliente3 = new Venta("2025-03-08", cliente3);
        venta1Cliente3.agregarDetalle(new DetalleVenta(12, lecheEntera));
        venta1Cliente3.agregarDetalle(new DetalleVenta(5, arroz));

        Venta venta2Cliente3 = new Venta("2025-03-15", cliente3);
        venta2Cliente3.agregarDetalle(new DetalleVenta(15, lecheAlmendras));
        venta2Cliente3.agregarDetalle(new DetalleVenta(3, pan));

        tienda.registrarVenta(venta1Cliente3);
        tienda.registrarVenta(venta2Cliente3);

        // Ejecutar el método para obtener clientes que han comprado más de 20 productos de leche
        System.out.println("\nClientes que han comprado más de 20 productos de leche:");
        List<Cliente> clientesConMuchasComprasLeche = tienda.obtenerClientesComprasMasDe20ProductosLeche();

        for (Cliente cliente : clientesConMuchasComprasLeche) {
            System.out.println(cliente);
        }
    }
}
