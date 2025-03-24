package Punto23D;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Gimnasio {
    private String nombre;
    private LocalDate fechaInscripcion;
    private List<Miembro> miembros;
    private List<Entrenador> lista_entrenadores;

    public Gimnasio(String nombre, LocalDate fechaInscripcion) {
        this.nombre = nombre;
        this.fechaInscripcion = fechaInscripcion;
        this.miembros = new ArrayList<>();
        this.lista_entrenadores = new ArrayList<>();
    }

    // Métodos getter y setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    // Métodos para gestionar miembros
    public void agregarMiembro(Miembro miembro) {
        miembros.add(miembro);
    }

    // Métodos para gestionar entrenadores
    public void agregarEntrenador(Entrenador entrenador) {
        lista_entrenadores.add(entrenador);
    }

    // A. Método que devuelve el nombre más largo entre los entrenadores
    public String obtenerNombreEntrenadorMasLargo() {
        if (lista_entrenadores.isEmpty()) {
            return "";
        }

        String nombreMasLargo = "";

        for (Entrenador entrenador : lista_entrenadores) {
            String primerNombre = entrenador.getNombre().split(" ")[0];
            if (primerNombre.length() > nombreMasLargo.length()) {
                nombreMasLargo = primerNombre;
            }
        }

        return nombreMasLargo;
    }

    // B. Método que agrega a una lista los miembros cuya suma de dígitos del teléfono es igual a 30
    public LinkedList<Miembro> agregarMiembroConSumaTelefono() {
        LinkedList<Miembro> miembrosConSuma30 = new LinkedList<>();

        for (Miembro miembro : miembros) {
            String telefono = miembro.getTelefono().replaceAll("\\D", ""); // Remove non-digit characters
            int suma = 0;

            // Sumar cada dígito del teléfono
            for (int i = 0; i < telefono.length(); i++) {
                suma += Character.getNumericValue(telefono.charAt(i));
            }

            // Si la suma es 30, agregar a la lista
            if (suma == 30) {
                miembrosConSuma30.add(miembro);
            }
        }

        return miembrosConSuma30;
    }

    // C. Método que agrega a una lista los miembros con nombres palíndromos
    public LinkedList<Miembro> agregarMiembrosPalindromos() {
        LinkedList<Miembro> miembrosPalindromos = new LinkedList<>();

        for (Miembro miembro : miembros) {
            String primerNombre = miembro.getNombre().split(" ")[0].toLowerCase().replace(" ", "");
            boolean esPalindromo = true;

            // Verificar si el primer nombre es palíndromo
            for (int i = 0; i < primerNombre.length() / 2; i++) {
                if (primerNombre.charAt(i) != primerNombre.charAt(primerNombre.length() - 1 - i)) {
                    esPalindromo = false;
                    break;
                }
            }

            // Si es palíndromo, agregar a la lista
            if (esPalindromo) {
                miembrosPalindromos.add(miembro);
            }
        }

        return miembrosPalindromos;
    }
}