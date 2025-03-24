package Punto2;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Crear una instancia de la tienda
        Tienda tienda = new Tienda();

        // Crear algunos clientes
        Cliente cliente1 = new Cliente("Maria Rodriguez", "maria@gmail.com");
        Cliente cliente2 = new Cliente("Carlos Perez", "carlos@hotmail.com");
        Cliente cliente3 = new Cliente("Ricardo Ramirez", "ricardo@gmail.com");
        Cliente cliente4 = new Cliente("Ana", "ana@gmail.com");
        Cliente cliente5 = new Cliente("Roberto", "roberto@yahoo.com");

        // Agregar clientes a la tienda
        tienda.agregarCliente(cliente1);
        tienda.agregarCliente(cliente2);
        tienda.agregarCliente(cliente3);
        tienda.agregarCliente(cliente4);
        tienda.agregarCliente(cliente5);

        // Crear algunos productos
        Producto producto1 = new Producto("Laptop", 1200.0, 5, "Electronica");
        Producto producto2 = new Producto("Smartphone", 800.0, 10, "Electronica");
        Producto producto3 = new Producto("Auriculares", 100.0, 20, "Accesorios");
        Producto producto4 = new Producto("Monitor", 300.0, 8, "Electronica");
        Producto producto5 = new Producto("Teclado", 50.0, 15, "Accesorios");

        // Agregar productos a la tienda        tienda.agregarProducto(producto1);
        tienda.agregarProducto(producto2);
        tienda.agregarProducto(producto3);
        tienda.agregarProducto(producto4);
        tienda.agregarProducto(producto5);

        // Crear algunas ventas con fechas como String
        Venta venta1 = new Venta(cliente1, "15/01/2023");
        venta1.agregarProducto(producto1);
        venta1.agregarProducto(producto3);

        Venta venta2 = new Venta(cliente2, "20/02/2023");
        venta2.agregarProducto(producto2);

        Venta venta3 = new Venta(cliente3, "10/03/2023");
        venta3.agregarProducto(producto4);
        venta3.agregarProducto(producto5);

        Venta venta4 = new Venta(cliente1, "05/04/2023");
        venta4.agregarProducto(producto2);

        Venta venta5 = new Venta(cliente3, "15/01/2023");
        venta5.agregarProducto(producto1);

        // Registrar ventas en la tienda
        tienda.registrarVenta(venta1);
        tienda.registrarVenta(venta2);
        tienda.registrarVenta(venta3);
        tienda.registrarVenta(venta4);
        tienda.registrarVenta(venta5);
        

        // Scanner para leer entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Menu para probar los diferentes metodos
        int opcion;
        do {
            System.out.println("\n--- MENU DE OPCIONES ---");
            System.out.println("1. Ventas con clientes que tienen dos 'r' en su nombre");
            System.out.println("2. Productos con stock menor a un valor");
            System.out.println("3. Clientes con mas de una compra");
            System.out.println("4. Ventas entre dos fechas");
            System.out.println("5. Nombre mas largo entre clientes");
            System.out.println("6. Nombres de clientes palindromos");
            System.out.println("7. Ventas con monto mayor a una cantidad");
            System.out.println("8. Clientes con correo de dominio especifico");
            System.out.println("9. Ventas con productos de categoria especifica");
            System.out.println("0. Salir");
            System.out.print("Ingrese una opcion: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.println("\nVentas con clientes que tienen dos 'r' en su nombre:");
                    List<Venta> ventasR = tienda.ventasClienteConDosR();
                    for (Venta v : ventasR) {
                        System.out.println(v);
                    }
                    break;

                case 2:
                    System.out.print("\nIngrese el valor de stock minimo: ");
                    int stock = scanner.nextInt();
                    List<Producto> productosStock = tienda.productosStockMenorA(stock);
                    System.out.println("Productos con stock menor a " + stock + ":");
                    for (Producto p : productosStock) {
                        System.out.println(p);
                    }
                    break;

                case 3:
                    System.out.println("\nClientes con mas de una compra:");
                    List<Cliente> clientesCompras = tienda.clientesConMasDeUnaCompra();
                    for (Cliente c : clientesCompras) {
                        System.out.println(c);
                    }
                    break;

                case 4:
                    System.out.print("\nIngrese fecha inicio (dd/MM/yyyy): ");
                    String fechaInicio = scanner.nextLine();

                    System.out.print("Ingrese fecha fin (dd/MM/yyyy): ");
                    String fechaFin = scanner.nextLine();

                    List<Venta> ventasFechas = tienda.ventasEntreFechas(fechaInicio, fechaFin);
                    System.out.println("Ventas entre " + fechaInicio + " y " + fechaFin + ":");
                    for (Venta v : ventasFechas) {
                        System.out.println(v);
                    }
                    break;

                case 5:
                    String nombreLargo = tienda.nombreClienteMasLargo();
                    System.out.println("\nEl nombre mas largo es: " + nombreLargo);
                    break;

                case 6:
                    System.out.println("\nNombres de clientes palindromos:");
                    List<String> palindromos = tienda.nombresClientesPalindromos();
                    for (String nombre : palindromos) {
                        System.out.println(nombre);
                    }
                    break;

                case 7:
                    System.out.print("\nIngrese el monto minimo: ");
                    double monto = scanner.nextDouble();
                    List<Venta> ventasMonto = tienda.ventasConMontoMayorA(monto);
                    System.out.println("Ventas con monto mayor a " + monto + ":");
                    for (Venta v : ventasMonto) {
                        System.out.println(v);
                    }
                    break;

                case 8:
                    System.out.print("\nIngrese el dominio de correo (ejemplo: @gmail.com): ");
                    String dominio = scanner.nextLine();
                    List<Cliente> clientesDominio = tienda.clientesConDominio(dominio);
                    System.out.println("Clientes con correo " + dominio + ":");
                    for (Cliente c : clientesDominio) {
                        System.out.println(c);
                    }
                    break;

                case 9:
                    System.out.print("\nIngrese la categoria: ");
                    String categoria = scanner.nextLine();
                    List<Venta> ventasCategoria = tienda.ventasConCategoria(categoria);
                    System.out.println("Ventas con productos de categoria " + categoria + ":");
                    for (Venta v : ventasCategoria) {
                        System.out.println(v);
                    }
                    break;

                case 0:
                    System.out.println("\nSaliendo del programa...");
                    break;

                default:
                    System.out.println("\nOpcion no valida!");
            }

        } while (opcion != 0);

        scanner.close();
    }

}