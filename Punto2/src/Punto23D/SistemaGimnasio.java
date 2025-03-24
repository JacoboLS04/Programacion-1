package Punto23D;

import java.time.LocalDate;
import java.util.LinkedList;

public class SistemaGimnasio {
    public static void main(String[] args) {
        // Crear un gimnasio

        Gimnasio gimnasio = new Gimnasio("FitPower", LocalDate.now());

        // Agregar entrenadores
        gimnasio.agregarEntrenador(new Entrenador("Juan Carlos Rodríguez", "Musculación", "juan@gym.com", 312456789));
        gimnasio.agregarEntrenador(new Entrenador("Ana", "Yoga", "ana@gym.com", 311434446));
        gimnasio.agregarEntrenador(new Entrenador("María Alexandra Pérez González", "Pilates", "maria@gym.com", 315789012));

        // Agregar miembros
        gimnasio.agregarMiembro(new Miembro("Ana", 28, "Femenino", "1098765432", "3112345678"));
        gimnasio.agregarMiembro(new Miembro("Carlos López", 35, "Masculino", "1087654321", "3109999999"));
        gimnasio.agregarMiembro(new Miembro("Somos", 42, "Masculino", "1076543210", "3161234567"));
        gimnasio.agregarMiembro(new Miembro("Juan Pérez", 30, "Masculino", "1065432109", "311434446")); // Suma = 30
        gimnasio.agregarMiembro(new Miembro("Reconocer", 25, "Femenino", "1054321098", "3187654321"));

        // Prueba A: Obtener nombre más largo de entrenadores
        System.out.println("=== ENTRENADOR CON NOMBRE MÁS LARGO ===");
        String nombreLargo = gimnasio.obtenerNombreEntrenadorMasLargo();
        System.out.println("El entrenador con nombre más largo es: " + nombreLargo);

        // Prueba B: Miembros con suma de teléfono igual a 30
        System.out.println("\n=== MIEMBROS CON SUMA DE TELÉFONO IGUAL A 30 ===");
        LinkedList<Miembro> miembrosSumaTel = gimnasio.agregarMiembroConSumaTelefono();
        if (miembrosSumaTel.isEmpty()) {
            System.out.println("No hay miembros con suma de teléfono igual a 30");
        } else {
            for (Miembro m : miembrosSumaTel) {
                System.out.println(m);
                System.out.println("Teléfono: " + m.getTelefono() + " (suma = 30)");
            }
        }

        // Prueba C: Miembros con nombres palíndromos
        System.out.println("\n=== MIEMBROS CON NOMBRES PALÍNDROMOS ===");
        LinkedList<Miembro> miembrosPalindromos = gimnasio.agregarMiembrosPalindromos();
        if (miembrosPalindromos.isEmpty()) {
            System.out.println("No hay miembros con nombres palíndromos");
        } else {
            for (Miembro m : miembrosPalindromos) {
                System.out.println(m);
                System.out.println("Nombre: " + m.getNombre() + " (palíndromo)");
            }
        }
    }
}